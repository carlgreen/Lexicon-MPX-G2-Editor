/*
 *  Copyright (C) 2011 Carl Green
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.carlwithak.mpxg2.sysex;

import info.carlwithak.mpxg2.model.BeatRate;
import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.NoiseGate;
import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.model.RoutingData;
import info.carlwithak.mpxg2.model.effects.algorithms.Ambience;
import info.carlwithak.mpxg2.model.effects.algorithms.AutoPan;
import info.carlwithak.mpxg2.model.effects.algorithms.BlueComp;
import info.carlwithak.mpxg2.model.effects.algorithms.Chamber;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusAlgorithm;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusVolumeDual;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.DetuneDual;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoMono;
import info.carlwithak.mpxg2.model.effects.algorithms.EqPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.FlangerStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.Hall;
import info.carlwithak.mpxg2.model.effects.algorithms.Overdrive;
import info.carlwithak.mpxg2.model.effects.algorithms.Panner;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah1;
import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;
import info.carlwithak.mpxg2.model.effects.algorithms.ShiftDual;
import info.carlwithak.mpxg2.model.effects.algorithms.SweepFilter;
import info.carlwithak.mpxg2.model.effects.algorithms.Tone;
import info.carlwithak.mpxg2.model.effects.algorithms.TremoloMono;
import info.carlwithak.mpxg2.model.effects.algorithms.UniVybe;
import info.carlwithak.mpxg2.model.effects.algorithms.VolumeMono;
import info.carlwithak.mpxg2.model.effects.algorithms.Wah2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests for SysexParser, using real files dumped from the MPX G2.
 *
 * @author carl
 */
public class SysexParserTest {
    private static final byte[] FILE_INTRO = {
        (byte) 0xf0, 0x06, 0x0f, 0x00, 0x01, 0x06, 0x0c, 0x01, 0x00,
    };
    private static final byte[] FILE_OUTRO = {
        0x04, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x0a, 0x00, 0x00, 0x00,
        0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
        0x00, (byte) 0xf7
    };
    private static final byte[] BLANK_PROGRAM_DATA = new byte[454 * 2];

    @Before
    public void setUp() {
        Arrays.fill(BLANK_PROGRAM_DATA, (byte) 0);
    }

    /**
     * Test parsing invalid data.
     */
    @Test
    public void testParseInvalidData() throws Exception {
        String expectedMessage = null;
        try {
            File temp = tempFileWithData(new byte[]{(byte) 0xe0});
            expectedMessage = "Invalid Sysex ID (start)";
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }

        try {
            File temp = tempFileWithData(new byte[]{(byte) 0xf0, 0x05});
            expectedMessage = "Invalid Manufacturer ID";
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }

        try {
            File temp = tempFileWithData(new byte[]{(byte) 0xf0, 0x06, 0x10});
            expectedMessage = "Invalid Product ID";
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }

        try {
            File temp = tempFileWithData(new byte[]{(byte) 0xf0, 0x06, 0x0f, 0x00, 0x00});
            expectedMessage = "Invalid Message Type";
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testNotFourLevelsOfControl() throws Exception {
        String expectedMessage = null;
        try {
            File temp = tempFileWithData(new byte[]{(byte) 0xf0, 0x06, 0x0f, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00,
            0x03, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00});
            expectedMessage = "Expect 4 control levels for a program dump";
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testNotProgramDumpControlPath() throws Exception {
        String expectedMessage = null;
        try {
            File temp = tempFileWithData(new byte[]{
                (byte) 0xf0, 0x06, 0x0f, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00,
                0x04, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0a, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00
            });
            expectedMessage = "Expect ProgramDump control tree path";
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }

        try {
            File temp = tempFileWithData(new byte[]{
                (byte) 0xf0, 0x06, 0x0f, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00,
                0x04, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x0b, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00
            });
            expectedMessage = "Expect ProgramDump control tree path";
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testNoSysexEndMarker() throws Exception {
        String expectedMessage = null;
        try {
            File temp = tempFileWithData(new byte[]{
                (byte) 0xf0, 0x06, 0x0f, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00,
                0x04, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x0a, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, (byte) 0xf6
            });
            expectedMessage = "Invalid Sysex ID (end)";
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testParsePrograms() throws IOException, ParseException {
        byte[] file = concat(FILE_INTRO, BLANK_PROGRAM_DATA, FILE_OUTRO);
        byte[] files = concat(file, file);

        File temp = tempFileWithData(files);
        List<Program> programs = SysexParser.parsePrograms(temp);
        assertEquals(2, programs.size());
    }

    @Test
    public void testInvalidEffect1AlgorithmNumber() throws IOException {
        BLANK_PROGRAM_DATA[558] = 0x22;
        byte[] file = concat(FILE_INTRO, BLANK_PROGRAM_DATA, FILE_OUTRO);

        File temp = tempFileWithData(file);
        String expectedMessage = "Invalid Effect 1 algorithm number: 34";
        try {
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testInvalidEffect2AlgorithmNumber() throws IOException {
        BLANK_PROGRAM_DATA[560] = 0x1b;
        byte[] file = concat(FILE_INTRO, BLANK_PROGRAM_DATA, FILE_OUTRO);

        File temp = tempFileWithData(file);
        String expectedMessage = "Invalid Effect 2 algorithm number: 27";
        try {
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testInvalidChorusAlgorithmNumber() throws IOException {
        BLANK_PROGRAM_DATA[562] = 0x12;
        byte[] file = concat(FILE_INTRO, BLANK_PROGRAM_DATA, FILE_OUTRO);

        File temp = tempFileWithData(file);
        String expectedMessage = "Invalid Chorus algorithm number: 18";
        try {
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testInvalidDelayAlgorithmNumber() throws IOException {
        BLANK_PROGRAM_DATA[564] = 0x0a;
        byte[] file = concat(FILE_INTRO, BLANK_PROGRAM_DATA, FILE_OUTRO);

        File temp = tempFileWithData(file);
        String expectedMessage = "Invalid Delay algorithm number: 10";
        try {
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testInvalidReverbAlgorithmNumber() throws IOException {
        BLANK_PROGRAM_DATA[566] = 0x06;
        byte[] file = concat(FILE_INTRO, BLANK_PROGRAM_DATA, FILE_OUTRO);

        File temp = tempFileWithData(file);
        String expectedMessage = "Invalid Reverb algorithm number: 6";
        try {
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testInvalidEqAlgorithmNumber() throws IOException {
        BLANK_PROGRAM_DATA[568] = 0x10;
        byte[] file = concat(FILE_INTRO, BLANK_PROGRAM_DATA, FILE_OUTRO);

        File temp = tempFileWithData(file);
        String expectedMessage = "Invalid EQ algorithm number: 16";
        try {
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testInvalidGainAlgorithmNumber() throws IOException {
        BLANK_PROGRAM_DATA[570] = 0x09;
        byte[] file = concat(FILE_INTRO, BLANK_PROGRAM_DATA, FILE_OUTRO);

        File temp = tempFileWithData(file);
        String expectedMessage = "Invalid Gain algorithm number: 9";
        try {
            SysexParser.parsePrograms(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    private File tempFileWithData(final byte[] data) throws IOException {
        File temp = File.createTempFile("test_", ".syx", new File("target/test-classes/"));
        temp.deleteOnExit();

        OutputStream out = null;
        try {
            out = new FileOutputStream(temp);
            out.write(data);
        } finally {
            out.close();
        }

        return temp;
    }

    private byte[] concat(byte[]... bb) {
        int length = 0;
        for (byte[] b : bb) {
            length += b.length;
        }
        byte[] result = new byte[length];
        int offset = 0;
        for (byte[] b : bb) {
            System.arraycopy(b, 0, result, offset, b.length);
            offset += b.length;
        }
        return result;
    }

    /**
     * Test parsing the Clean Slate preset, which has pretty much nothing defined.
     */
    @Test
    public void testParseCleanSlate() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("250_Clean_Slate.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        // effect types
        assertFalse(program.isChorus());
        assertTrue(program.isDelay());
        assertFalse(program.isDistortion());
        assertFalse(program.isEq());
        assertFalse(program.isFlanger());
        assertTrue(program.isGain());
        assertFalse(program.isMod());
        assertFalse(program.isOverdrive());
        assertFalse(program.isPhaser());
        assertTrue(program.isPitch());
        assertFalse(program.isReverb());
        assertFalse(program.isSpeakerSim());
        assertFalse(program.isWah());
        assertFalse(program.isPrePost());
        assertTrue(program.isStandAlone());
        assertFalse(program.isInline());

        // guitar styles
        assertFalse(program.isAcoustic());
        assertFalse(program.isBass());
        assertTrue(program.isBlues());
        assertTrue(program.isClean());
        assertFalse(program.isCountry());
        assertTrue(program.isJazz());
        assertTrue(program.isRock());

        RoutingData routing = program.getRouting0();
        assertEquals(8, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting1();
        assertEquals(0, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting2();
        assertEquals(1, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting3();
        assertEquals(6, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting4();
        assertEquals(5, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting5();
        assertEquals(2, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting6();
        assertEquals(3, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting7();
        assertEquals(4, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting8();
        assertEquals(7, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());

        assertEquals(0, program.getEffect1ToePatch());
        assertEquals(0, program.getEffect2ToePatch());
        assertEquals(0, program.getChorusToePatch());
        assertEquals(0, program.getDelayToePatch());
        assertEquals(0, program.getReverbToePatch());
        assertEquals(0, program.getEqToePatch());
        assertEquals(0, program.getGainToePatch());

        assertNull(program.getEffect1());
        assertNull(program.getEffect2());
        assertNull(program.getChorus());
        assertNull(program.getDelay());
        assertNull(program.getReverb());
        assertNull(program.getEq());
        assertNull(program.getGain());

        assertEquals("Clean Slate", program.getProgramName());

        assertFalse(program.isEffect1On());
        assertFalse(program.isEffect2On());
        assertFalse(program.isChorusOn());
        assertFalse(program.isDelayOn());
        assertFalse(program.isReverbOn());
        assertFalse(program.isEqOn());
        assertFalse(program.isGainOn());
        assertTrue(program.isInsertOn());

        assertEquals(120, program.getTempo());
        assertEquals(0, program.getTempoSource());
        assertEquals(2, program.getBeatValue()); // quater note
        assertEquals(0, program.getTapSource());
        assertEquals(2, program.getTapAverage());
        assertEquals(64, program.getTapSourceLevel());

        assertEquals(0, program.getPatch1().getSourceIndex());
        assertEquals(0, program.getPatch1().getSourceMin().intValue());
        assertNull(program.getPatch1().getSourceMid());
        assertEquals(127, program.getPatch1().getSourceMax().intValue());
        assertNull(program.getPatch1().getDestinationEffectIndex());
        assertEquals(255, program.getPatch1().getDestinationParameter());
        assertEquals(0, program.getPatch1().getDestinationMin());
        assertEquals(0x8000, program.getPatch1().getDestinationMid());
        assertEquals(0, program.getPatch1().getDestinationMax());
        assertEquals(0, program.getPatch2().getSourceIndex());
        assertEquals(0, program.getPatch2().getSourceMin().intValue());
        assertNull(program.getPatch2().getSourceMid());
        assertEquals(127, program.getPatch2().getSourceMax().intValue());
        assertNull(program.getPatch2().getDestinationEffectIndex());
        assertEquals(255, program.getPatch2().getDestinationParameter());
        assertEquals(0, program.getPatch2().getDestinationMin());
        assertEquals(0x8000, program.getPatch2().getDestinationMid());
        assertEquals(0, program.getPatch2().getDestinationMax());
        assertEquals(0, program.getPatch3().getSourceIndex());
        assertEquals(0, program.getPatch3().getSourceMin().intValue());
        assertNull(program.getPatch3().getSourceMid());
        assertEquals(127, program.getPatch3().getSourceMax().intValue());
        assertNull(program.getPatch3().getDestinationEffectIndex());
        assertEquals(255, program.getPatch3().getDestinationParameter());
        assertEquals(0, program.getPatch3().getDestinationMin());
        assertEquals(0x8000, program.getPatch3().getDestinationMid());
        assertEquals(0, program.getPatch3().getDestinationMax());
        assertEquals(0, program.getPatch4().getSourceIndex());
        assertEquals(0, program.getPatch4().getSourceMin().intValue());
        assertNull(program.getPatch4().getSourceMid());
        assertEquals(127, program.getPatch4().getSourceMax().intValue());
        assertNull(program.getPatch4().getDestinationEffectIndex());
        assertEquals(255, program.getPatch4().getDestinationParameter());
        assertEquals(0, program.getPatch4().getDestinationMin());
        assertEquals(0x8000, program.getPatch4().getDestinationMid());
        assertEquals(0, program.getPatch4().getDestinationMax());
        assertEquals(0, program.getPatch5().getSourceIndex());
        assertEquals(0, program.getPatch5().getSourceMin().intValue());
        assertNull(program.getPatch5().getSourceMid());
        assertEquals(127, program.getPatch5().getSourceMax().intValue());
        assertNull(program.getPatch5().getDestinationEffectIndex());
        assertEquals(255, program.getPatch5().getDestinationParameter());
        assertEquals(0, program.getPatch5().getDestinationMin());
        assertEquals(0x8000, program.getPatch5().getDestinationMid());
        assertEquals(0, program.getPatch5().getDestinationMax());

        assertEquals(50, program.getKnobValue());
        assertEquals(0, program.getKnobLow());
        assertEquals(100, program.getKnobHigh());
        assertEquals("Delay Adj", program.getKnobName());

        assertEquals(1, program.getLfo1Mode());
        assertEquals(new FrequencyRate("LFO1Rate", 0.60), program.getLfo1Rate());
        assertEquals(50, program.getLfo1PulseWidth());
        assertEquals(0, program.getLfo1Phase());
        assertEquals(100, program.getLfo1Depth());
        assertEquals(64, program.getLfo1OnLevel());
        assertEquals(0, program.getLfo1OnSource());

        assertEquals(1, program.getLfo2Mode());
        assertEquals(new FrequencyRate("LFO2Rate", 0.92), program.getLfo2Rate());
        assertEquals(50, program.getLfo2PulseWidth());
        assertEquals(0, program.getLfo2Phase());
        assertEquals(100, program.getLfo2Depth());
        assertEquals(64, program.getLfo2OnLevel());
        assertEquals(0, program.getLfo2OnSource());

        assertEquals(0, program.getRandomLow());
        assertEquals(127, program.getRandomHigh());
        assertEquals(1.00, program.getRandomRate(), 0.001);

        assertEquals(0, program.getABMode());
        assertEquals(100, program.getARate());
        assertEquals(100, program.getBRate());
        assertEquals(64, program.getABOnLevel());
        assertEquals(0, program.getABOnSource());

        assertEquals(0, program.getEnvelopeGeneratorSrc1());
        assertEquals(0, program.getEnvelopeGeneratorSrc2());
        assertEquals(100, program.getEnvelopeGeneratorATrim());
        assertEquals(64, program.getEnvelopeGeneratorResponse());

        assertEquals(0, program.getNoiseGate().getEnable());
        assertFalse(program.getNoiseGate().isSend());
        assertEquals(-83, program.getNoiseGate().getThreshold());
        assertEquals(-80, program.getNoiseGate().getAttenuation());
        assertEquals(-3, program.getNoiseGate().getOffset());
        assertEquals(0, program.getNoiseGate().getATime());
        assertEquals(100, program.getNoiseGate().getHTime());
        assertEquals(100, program.getNoiseGate().getRTime());
        assertEquals(0, program.getNoiseGate().getDelay());

        assertEquals(0, program.getBypassState());

        assertFalse(program.isSpeakerSimulatorEnable());
        assertEquals(1, program.getSpeakerSimulatorCabinet());

        assertEquals(0, program.getSendLevel());
        assertEquals(0, program.getSendBypassLevel());
        assertEquals(100, program.getPostMix());
        assertEquals(0, program.getPostLevel());
        assertEquals(0, program.getPostBypassLevel());

        assertEquals(301, program.getProgramNumber()); // 301 is the active program
    }

    /**
     * Test parsing the Unity Gain preset, which has a little more than Clean Slate defined.
     */
    @Test
    public void testParseUnityGain() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("249_Unity_Gain.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof VolumeMono);

        // effect types
        assertFalse(program.isChorus());
        assertTrue(program.isDelay());
        assertFalse(program.isDistortion());
        assertFalse(program.isEq());
        assertFalse(program.isFlanger());
        assertTrue(program.isGain());
        assertFalse(program.isMod());
        assertFalse(program.isOverdrive());
        assertFalse(program.isPhaser());
        assertTrue(program.isPitch());
        assertFalse(program.isReverb());
        assertFalse(program.isSpeakerSim());
        assertFalse(program.isWah());
        assertFalse(program.isPrePost());
        assertTrue(program.isStandAlone());
        assertFalse(program.isInline());

        // guitar styles
        assertFalse(program.isAcoustic());
        assertFalse(program.isBass());
        assertTrue(program.isBlues());
        assertTrue(program.isClean());
        assertFalse(program.isCountry());
        assertTrue(program.isJazz());
        assertTrue(program.isRock());

        RoutingData routing = program.getRouting0();
        assertEquals(8, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting1();
        assertEquals(0, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting2();
        assertEquals(1, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting3();
        assertEquals(6, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting4();
        assertEquals(5, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting5();
        assertEquals(2, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting6();
        assertEquals(3, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting7();
        assertEquals(4, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting8();
        assertEquals(7, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());

        assertEquals(0, program.getEffect1ToePatch());
        assertEquals(0, program.getEffect2ToePatch());
        assertEquals(0, program.getChorusToePatch());
        assertEquals(0, program.getDelayToePatch());
        assertEquals(0, program.getReverbToePatch());
        assertEquals(0, program.getEqToePatch());
        assertEquals(0, program.getGainToePatch());

        assertTrue(program.getEffect1() instanceof VolumeMono);
        assertNull(program.getEffect2());
        assertNull(program.getChorus());
        assertNull(program.getDelay());
        assertNull(program.getReverb());
        assertNull(program.getEq());
        assertNull(program.getGain());

        assertEquals("Unity Gain", program.getProgramName());

        assertTrue(program.isEffect1On());
        assertFalse(program.isEffect2On());
        assertFalse(program.isChorusOn());
        assertFalse(program.isDelayOn());
        assertFalse(program.isReverbOn());
        assertFalse(program.isEqOn());
        assertFalse(program.isGainOn());
        assertTrue(program.isInsertOn());

        assertEquals(170, program.getTempo());
        assertEquals(0, program.getTempoSource());
        assertEquals(2, program.getBeatValue()); // quater note
        assertEquals(0, program.getTapSource());
        assertEquals(2, program.getTapAverage());
        assertEquals(64, program.getTapSourceLevel());

        assertEquals(0, program.getPatch1().getSourceIndex());
        assertEquals(0, program.getPatch1().getSourceMin().intValue());
        assertNull(program.getPatch1().getSourceMid());
        assertEquals(127, program.getPatch1().getSourceMax().intValue());
        assertNull(program.getPatch1().getDestinationEffectIndex());
        assertEquals(255, program.getPatch1().getDestinationParameter());
        assertEquals(0, program.getPatch1().getDestinationMin());
        assertEquals(0x8000, program.getPatch1().getDestinationMid());
        assertEquals(0, program.getPatch1().getDestinationMax());
        assertEquals(0, program.getPatch2().getSourceIndex());
        assertEquals(0, program.getPatch2().getSourceMin().intValue());
        assertNull(program.getPatch2().getSourceMid());
        assertEquals(127, program.getPatch2().getSourceMax().intValue());
        assertNull(program.getPatch2().getDestinationEffectIndex());
        assertEquals(255, program.getPatch2().getDestinationParameter());
        assertEquals(0, program.getPatch2().getDestinationMin());
        assertEquals(0x8000, program.getPatch2().getDestinationMid());
        assertEquals(0, program.getPatch2().getDestinationMax());
        assertEquals(0, program.getPatch3().getSourceIndex());
        assertEquals(0, program.getPatch3().getSourceMin().intValue());
        assertNull(program.getPatch3().getSourceMid());
        assertEquals(127, program.getPatch3().getSourceMax().intValue());
        assertNull(program.getPatch3().getDestinationEffectIndex());
        assertEquals(255, program.getPatch3().getDestinationParameter());
        assertEquals(0, program.getPatch3().getDestinationMin());
        assertEquals(0x8000, program.getPatch3().getDestinationMid());
        assertEquals(0, program.getPatch3().getDestinationMax());
        assertEquals(0, program.getPatch4().getSourceIndex());
        assertEquals(0, program.getPatch4().getSourceMin().intValue());
        assertNull(program.getPatch4().getSourceMid());
        assertEquals(127, program.getPatch4().getSourceMax().intValue());
        assertNull(program.getPatch4().getDestinationEffectIndex());
        assertEquals(255, program.getPatch4().getDestinationParameter());
        assertEquals(0, program.getPatch4().getDestinationMin());
        assertEquals(0x8000, program.getPatch4().getDestinationMid());
        assertEquals(0, program.getPatch4().getDestinationMax());
        assertEquals(0, program.getPatch5().getSourceIndex());
        assertEquals(0, program.getPatch5().getSourceMin().intValue());
        assertNull(program.getPatch5().getSourceMid());
        assertEquals(127, program.getPatch5().getSourceMax().intValue());
        assertNull(program.getPatch5().getDestinationEffectIndex());
        assertEquals(255, program.getPatch5().getDestinationParameter());
        assertEquals(0, program.getPatch5().getDestinationMin());
        assertEquals(0x8000, program.getPatch5().getDestinationMid());
        assertEquals(0, program.getPatch5().getDestinationMax());

        assertEquals(50, program.getKnobValue());
        assertEquals(0, program.getKnobLow());
        assertEquals(100, program.getKnobHigh());
        assertEquals("Delay Adj", program.getKnobName());

        assertEquals(1, program.getLfo1Mode());
        assertEquals(new FrequencyRate("LFO1Rate", 0.60), program.getLfo1Rate());
        assertEquals(50, program.getLfo1PulseWidth());
        assertEquals(0, program.getLfo1Phase());
        assertEquals(100, program.getLfo1Depth());
        assertEquals(64, program.getLfo1OnLevel());
        assertEquals(0, program.getLfo1OnSource());

        assertEquals(1, program.getLfo2Mode());
        assertEquals(new FrequencyRate("LFO2Rate", 0.92), program.getLfo2Rate());
        assertEquals(50, program.getLfo2PulseWidth());
        assertEquals(0, program.getLfo2Phase());
        assertEquals(100, program.getLfo2Depth());
        assertEquals(64, program.getLfo2OnLevel());
        assertEquals(0, program.getLfo2OnSource());

        assertEquals(0, program.getRandomLow());
        assertEquals(127, program.getRandomHigh());
        assertEquals(1.00, program.getRandomRate(), 0.001);

        assertEquals(0, program.getABMode());
        assertEquals(100, program.getARate());
        assertEquals(100, program.getBRate());
        assertEquals(64, program.getABOnLevel());
        assertEquals(0, program.getABOnSource());

        assertEquals(0, program.getEnvelopeGeneratorSrc1());
        assertEquals(0, program.getEnvelopeGeneratorSrc2());
        assertEquals(100, program.getEnvelopeGeneratorATrim());
        assertEquals(64, program.getEnvelopeGeneratorResponse());

        assertEquals(0, program.getNoiseGate().getEnable());
        assertFalse(program.getNoiseGate().isSend());
        assertEquals(-83, program.getNoiseGate().getThreshold());
        assertEquals(-80, program.getNoiseGate().getAttenuation());
        assertEquals(-3, program.getNoiseGate().getOffset());
        assertEquals(0, program.getNoiseGate().getATime());
        assertEquals(100, program.getNoiseGate().getHTime());
        assertEquals(100, program.getNoiseGate().getRTime());
        assertEquals(0, program.getNoiseGate().getDelay());

        assertEquals(0, program.getBypassState());

        assertFalse(program.isSpeakerSimulatorEnable());
        assertEquals(1, program.getSpeakerSimulatorCabinet());

        assertEquals(0, program.getSendLevel());
        assertEquals(0, program.getSendBypassLevel());
        assertEquals(100, program.getPostMix());
        assertEquals(0, program.getPostLevel());
        assertEquals(0, program.getPostBypassLevel());

        assertEquals(301, program.getProgramNumber()); // 301 is the active program
    }

    /**
     * Test parsing the G2 Blue preset.
     */
    @Test
    public void testParseG2Blue() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("001_G2_Blue.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof UniVybe);
        assertTrue(program.getEffect2() instanceof PedalWah1);
        assertTrue(program.getChorus() instanceof ChorusPedalVol);
        assertTrue(program.getDelay() instanceof EchoDual);
        assertTrue(program.getReverb() instanceof Ambience);
        assertNull(program.getEq()); // no eq
        assertTrue(program.getGain() instanceof Screamer);

        // effect types
        assertTrue(program.isChorus());
        assertTrue(program.isDelay());
        assertFalse(program.isDistortion());
        assertFalse(program.isEq());
        assertFalse(program.isFlanger());
        assertTrue(program.isGain());
        assertFalse(program.isMod());
        assertFalse(program.isOverdrive());
        assertFalse(program.isPhaser());
        assertFalse(program.isPitch());
        assertTrue(program.isReverb());
        assertFalse(program.isSpeakerSim());
        assertTrue(program.isWah());
        assertTrue(program.isPrePost());
        assertFalse(program.isStandAlone());
        assertFalse(program.isInline());

        // guitar styles
        assertFalse(program.isAcoustic());
        assertFalse(program.isBass());
        assertTrue(program.isBlues());
        assertTrue(program.isClean());
        assertFalse(program.isCountry());
        assertTrue(program.isJazz());
        assertTrue(program.isRock());

        RoutingData routing = program.getRouting0();
        assertEquals(8, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting1();
        assertEquals(0, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting2();
        assertEquals(1, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting3();
        assertEquals(6, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting4();
        assertEquals(2, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting5();
        assertEquals(3, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting6();
        assertEquals(4, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting7();
        assertEquals(5, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting8();
        assertEquals(7, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());

        assertEquals(2, program.getEffect1ToePatch());
        assertEquals(1, program.getEffect2ToePatch());
        assertEquals(2, program.getChorusToePatch());
        assertEquals(0, program.getDelayToePatch());
        assertEquals(1, program.getReverbToePatch());
        assertEquals(0, program.getEqToePatch());
        assertEquals(0, program.getGainToePatch());

        assertTrue(program.getEffect1() instanceof UniVybe);
        assertTrue(program.getEffect2() instanceof PedalWah1);
        assertTrue(program.getChorus() instanceof ChorusPedalVol);
        assertTrue(program.getDelay() instanceof EchoDual);
        assertTrue(program.getReverb() instanceof Ambience);
        assertNull(program.getEq());
        assertTrue(program.getGain() instanceof Screamer);

        assertEquals("G2 Blue", program.getProgramName());

        assertTrue(program.isEffect1On());
        assertFalse(program.isEffect2On());
        assertTrue(program.isChorusOn());
        assertTrue(program.isDelayOn());
        assertFalse(program.isReverbOn());
        assertFalse(program.isEqOn());
        assertFalse(program.isGainOn());
        assertTrue(program.isInsertOn());

        assertEquals(6, program.getSoftRowEffectType(0));
        assertEquals(3, program.getSoftRowParameter(0));
        assertEquals(6, program.getSoftRowEffectType(1));
        assertEquals(4, program.getSoftRowParameter(1));
        assertEquals(6, program.getSoftRowEffectType(2));
        assertEquals(5, program.getSoftRowParameter(2));
        assertEquals(0, program.getSoftRowEffectType(3));
        assertEquals(2, program.getSoftRowParameter(3));
        assertEquals(3, program.getSoftRowEffectType(4));
        assertEquals(2, program.getSoftRowParameter(4));
        assertEquals(4, program.getSoftRowEffectType(5));
        assertEquals(0, program.getSoftRowParameter(5));
        assertEquals(4, program.getSoftRowEffectType(6));
        assertEquals(2, program.getSoftRowParameter(6));
        assertEquals(4, program.getSoftRowEffectType(7));
        assertEquals(5, program.getSoftRowParameter(7));
        assertEquals(4, program.getSoftRowEffectType(8));
        assertEquals(6, program.getSoftRowParameter(8));
        assertEquals(4, program.getSoftRowEffectType(9));
        assertEquals(7, program.getSoftRowParameter(9));

        assertEquals(120, program.getTempo());
        assertEquals(0, program.getTempoSource());
        assertEquals(2, program.getBeatValue()); // quater note
        assertEquals(0, program.getTapSource());
        assertEquals(2, program.getTapAverage());
        assertEquals(64, program.getTapSourceLevel());

        assertEquals(16, program.getPatch1().getSourceIndex()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch1().getSourceMin().intValue());
        assertNull(program.getPatch1().getSourceMid());
        assertEquals(127, program.getPatch1().getSourceMax().intValue());
        assertEquals(3, program.getPatch1().getDestinationEffectIndex().intValue());
        assertEquals(0, program.getPatch1().getDestinationParameter());
        assertEquals(2, program.getPatch1().getDestinationMin());
        assertEquals(0x8000, program.getPatch1().getDestinationMid());
        assertEquals(30, program.getPatch1().getDestinationMax());
        assertEquals(16, program.getPatch2().getSourceIndex()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch2().getSourceMin().intValue());
        assertNull(program.getPatch2().getSourceMid());
        assertEquals(127, program.getPatch2().getSourceMax().intValue());
        assertEquals(3, program.getPatch2().getDestinationEffectIndex().intValue());
        assertEquals(3, program.getPatch2().getDestinationParameter());
        assertEquals(260, program.getPatch2().getDestinationMin()); // TODO 260 = 0x0104 => 4, 1 - figure out how to split this
        assertEquals(0x8000, program.getPatch2().getDestinationMid());
        assertEquals(516, program.getPatch2().getDestinationMax()); // TODO 516 = 0x0204 => 4, 2 - figure out how to split this
        assertEquals(16, program.getPatch3().getSourceIndex()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch3().getSourceMin().intValue());
        assertNull(program.getPatch3().getSourceMid());
        assertEquals(127, program.getPatch3().getSourceMax().intValue());
        assertEquals(3, program.getPatch3().getDestinationEffectIndex().intValue());
        assertEquals(6, program.getPatch3().getDestinationParameter());
        assertEquals(1, program.getPatch3().getDestinationMin());
        assertEquals(0x8000, program.getPatch3().getDestinationMid());
        assertEquals(15, program.getPatch3().getDestinationMax());
        assertEquals(16, program.getPatch4().getSourceIndex()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch4().getSourceMin().intValue());
        assertNull(program.getPatch4().getSourceMid());
        assertEquals(127, program.getPatch4().getSourceMax().intValue());
        assertEquals(3, program.getPatch4().getDestinationEffectIndex().intValue());
        assertEquals(7, program.getPatch4().getDestinationParameter());
        assertEquals(1, program.getPatch4().getDestinationMin());
        assertEquals(0x8000, program.getPatch4().getDestinationMid());
        assertEquals(4, program.getPatch4().getDestinationMax());
        assertEquals(157, program.getPatch5().getSourceIndex()); // TODO why is the source 157 (0x9d) not 21 (0x15)?
        assertEquals(0, program.getPatch5().getSourceMin().intValue());
        assertNull(program.getPatch5().getSourceMid());
        assertEquals(127, program.getPatch5().getSourceMax().intValue());
        assertEquals(16, program.getPatch5().getDestinationEffectIndex().intValue());
        assertEquals(0, program.getPatch5().getDestinationParameter());
        assertEquals(0, program.getPatch5().getDestinationMin());
        assertEquals(0x8000, program.getPatch5().getDestinationMid());
        assertEquals(6, program.getPatch5().getDestinationMax());

        assertEquals(50, program.getKnobValue());
        assertEquals(0, program.getKnobLow());
        assertEquals(100, program.getKnobHigh());
        assertEquals("Delay Adj", program.getKnobName());

        assertEquals(1, program.getLfo1Mode());
        assertEquals(new FrequencyRate("LFO1Rate", 0.60), program.getLfo1Rate());
        assertEquals(50, program.getLfo1PulseWidth());
        assertEquals(0, program.getLfo1Phase());
        assertEquals(100, program.getLfo1Depth());
        assertEquals(64, program.getLfo1OnLevel());
        assertEquals(0, program.getLfo1OnSource());

        assertEquals(1, program.getLfo2Mode());
        assertEquals(new FrequencyRate("LFO2Rate", 0.92), program.getLfo2Rate());
        assertEquals(50, program.getLfo2PulseWidth());
        assertEquals(0, program.getLfo2Phase());
        assertEquals(100, program.getLfo2Depth());
        assertEquals(64, program.getLfo2OnLevel());
        assertEquals(0, program.getLfo2OnSource());

        assertEquals(0, program.getRandomLow());
        assertEquals(127, program.getRandomHigh());
        assertEquals(1.00, program.getRandomRate(), 0.001);

        assertEquals(0, program.getABMode());
        assertEquals(100, program.getARate());
        assertEquals(100, program.getBRate());
        assertEquals(64, program.getABOnLevel());
        assertEquals(0, program.getABOnSource());

        assertEquals(0, program.getEnvelopeGeneratorSrc1());
        assertEquals(0, program.getEnvelopeGeneratorSrc2());
        assertEquals(100, program.getEnvelopeGeneratorATrim());
        assertEquals(64, program.getEnvelopeGeneratorResponse());

        assertEquals(1, program.getNoiseGate().getEnable());
        assertTrue(program.getNoiseGate().isSend());
        assertEquals(-83, program.getNoiseGate().getThreshold());
        assertEquals(-85, program.getNoiseGate().getAttenuation());
        assertEquals(-3, program.getNoiseGate().getOffset());
        assertEquals(0, program.getNoiseGate().getATime());
        assertEquals(100, program.getNoiseGate().getHTime());
        assertEquals(100, program.getNoiseGate().getRTime());
        assertEquals(0, program.getNoiseGate().getDelay());

        assertEquals(0, program.getBypassState());

        assertFalse(program.isSpeakerSimulatorEnable());
        assertEquals(1, program.getSpeakerSimulatorCabinet());

        assertEquals(0, program.getSendLevel());
        assertEquals(0, program.getSendBypassLevel());
        assertEquals(100, program.getPostMix());
        assertEquals(0, program.getPostLevel());
        assertEquals(0, program.getPostBypassLevel());

        assertEquals(301, program.getProgramNumber()); // 301 is the active program
    }

    /**
     * Test parsing the Guitar Solo preset.
     */
    @Test
    public void testParseGuitarSolo() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("002_Guitar_Solo.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof DetuneDual);
        assertTrue(program.getEffect2() instanceof Panner);
        assertNull(program.getChorus()); // no chorus
        assertTrue(program.getDelay() instanceof EchoDual);
        assertTrue(program.getReverb() instanceof Plate);
        assertTrue(program.getGain() instanceof Screamer);

        RoutingData routing = program.getRouting0();
        assertEquals(8, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting1();
        assertEquals(5, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting2();
        assertEquals(2, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting3();
        assertEquals(6, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting4();
        assertEquals(0, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(3, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting5();
        assertEquals(3, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(1, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting6();
        assertEquals(4, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting7();
        assertEquals(1, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(2, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting8();
        assertEquals(7, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
    }

    /**
     * Test parsing the Cordovox preset.
     */
    @Test
    public void testParseCordovox() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("003_Cordovox.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof AutoPan);
        assertTrue(program.getEffect2() instanceof AutoPan);
        assertTrue(program.getChorus() instanceof ChorusAlgorithm);
        assertTrue(program.getDelay() instanceof EchoDual);
        assertTrue(program.getReverb() instanceof Chamber);
        assertTrue(program.getEq() instanceof EqPedalVol);
        assertTrue(program.getGain() instanceof Tone);

        RoutingData routing = program.getRouting0();
        assertEquals(8, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting1();
        assertEquals(5, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting2();
        assertEquals(6, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting3();
        assertEquals(2, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(3, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting4();
        assertEquals(0, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(4, routing.getLowerInputConnection());
        assertEquals(1, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting5();
        assertEquals(1, routing.getEffectId());
        assertEquals(3, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting6();
        assertEquals(3, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting7();
        assertEquals(4, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting8();
        assertEquals(7, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(2, routing.getRouting());
        assertEquals(1, routing.getPathType());
    }

    /**
     * Test parsing the Power Chords preset.
     */
    @Test
    public void testParsePowerChords() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("004_Power_Chords.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof ShiftDual);
        assertTrue(program.getDelay() instanceof DelayDual);
        assertTrue(program.getReverb() instanceof Chamber);
        assertTrue(program.getGain() instanceof Overdrive);
    }

    /**
     * Test parsing the Vybe/Flange preset.
     */
    @Test
    public void testParseVybeFlange() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("005_Vybe_Flange.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof UniVybe);
        assertTrue(program.getEffect2() instanceof AutoPan);
        assertTrue(program.getChorus() instanceof FlangerStereo);
        assertTrue(program.getDelay() instanceof EchoMono);
        assertTrue(program.getReverb() instanceof Plate);
        assertTrue(program.getEq() instanceof EqPedalVol);
        assertTrue(program.getGain() instanceof Screamer);
    }

    /**
     * Test parsing the AnotherBrick preset.
     */
    @Test
    public void testParseAnotherBrick() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("006_AnotherBrick.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect2() instanceof BlueComp);

        assertEquals("AnotherBrick", program.getProgramName());
    }

    /**
     * Test parsing the EnvFilter LP preset.
     */
    @Test
    public void testParseEnvFilterLP() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("007_EnvFilter_LP.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof SweepFilter);

        assertEquals("EnvFilter LP", program.getProgramName());
    }

    /**
     * Test parsing the TremoWah preset.
     */
    @Test
    public void testParseTremoWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("008_TremoWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof TremoloMono);
        assertTrue(program.getEffect2() instanceof Wah2);
        assertTrue(program.getChorus() instanceof ChorusVolumeDual);
        assertTrue(program.getDelay() instanceof DelayStereo);
        assertTrue(program.getReverb() instanceof Hall);

        assertEquals("TremoWah", program.getProgramName());

        assertEquals(50, program.getKnobValue());
        assertEquals(0, program.getKnobLow());
        assertEquals(100, program.getKnobHigh());
        assertEquals("Delay Adj", program.getKnobName());

        assertEquals(1, program.getLfo1Mode());
        assertEquals(new BeatRate("LFO1Rate", 1, 4), program.getLfo1Rate());
        assertEquals(50, program.getLfo1PulseWidth());
        assertEquals(0, program.getLfo1Phase());
        assertEquals(100, program.getLfo1Depth());
        assertEquals(64, program.getLfo1OnLevel());
        assertEquals(0, program.getLfo1OnSource());

        assertEquals(1, program.getLfo2Mode());
        assertEquals(new BeatRate("LFO2Rate", 1, 4), program.getLfo2Rate());
        assertEquals(50, program.getLfo2PulseWidth());
        assertEquals(0, program.getLfo2Phase());
        assertEquals(100, program.getLfo2Depth());
        assertEquals(64, program.getLfo2OnLevel());
        assertEquals(0, program.getLfo2OnSource());

        assertEquals(0, program.getRandomLow());
        assertEquals(127, program.getRandomHigh());
        assertEquals(1.00, program.getRandomRate(), 0.001);

        assertEquals(0, program.getABMode());
        assertEquals(100, program.getARate());
        assertEquals(100, program.getBRate());
        assertEquals(64, program.getABOnLevel());
        assertEquals(0, program.getABOnSource());

        assertEquals(0, program.getEnvelopeGeneratorSrc1());
        assertEquals(0, program.getEnvelopeGeneratorSrc2());
        assertEquals(100, program.getEnvelopeGeneratorATrim());
        assertEquals(64, program.getEnvelopeGeneratorResponse());
    }

    /**
     * Test parsing the JamMan preset.
     */
    @Test
    public void testParseJamMan() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("009_JamMan.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("JamMan", program.getProgramName());
    }

    /**
     * Test parsing the VH Rig preset.
     */
    @Test
    public void testParseVHRig() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("010_VH_Rig.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("VH Rig", program.getProgramName());
    }

    /**
     * Test parsing the Rotary Cab preset.
     */
    @Test
    public void testParseRotaryCab() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("011_Rotary_Cab.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Rotary Cab", program.getProgramName());
    }

    /**
     * Test parsing the Little Wing preset.
     */
    @Test
    public void testParseLittleWing() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("012_Little_Wing.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Little Wing", program.getProgramName());
    }

    /**
     * Test parsing the TechnoChords preset.
     */
    @Test
    public void testParseTechnoChords() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("013_TechnoChords.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("TechnoChords", program.getProgramName());
    }

    /**
     * Test parsing the Pedal Swell preset.
     */
    @Test
    public void testParsePedalSwell() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("014_Pedal_Swell.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Pedal Swell", program.getProgramName());
    }

    /**
     * Test parsing the Slide Comp preset.
     */
    @Test
    public void testParseSlideComp() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("015_Slide_Comp.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Slide Comp", program.getProgramName());
    }

    /**
     * Test parsing the Kiss the Sky preset.
     */
    @Test
    public void testParseKissTheSky() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("016_Kiss_the_Sky.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Kiss the Sky", program.getProgramName());
    }

    /**
     * Test parsing the Unchained preset.
     */
    @Test
    public void testParseUnchained() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("017_Unchained.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Unchained", program.getProgramName());
    }

    /**
     * Test parsing the Stomp! preset.
     */
    @Test
    public void testParseStomp() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("018_Stomp!.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Stomp!", program.getProgramName());
    }

    /**
     * Test parsing the OctaWah preset.
     */
    @Test
    public void testParseOctaWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("019_OctaWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("OctaWah", program.getProgramName());
    }

    /**
     * Test parsing the Wah & Uni preset.
     */
    @Test
    public void testParseWahUni() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("020_Wah_&_Uni.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Wah & Uni", program.getProgramName());
    }

    /**
     * Test parsing the ToeWah/Flng preset.
     */
    @Test
    public void testParseToeWahFlng() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("021_ToeWah_Flng.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("ToeWah/Flng", program.getProgramName());
    }

    /**
     * Test parsing the ToeWah/Phas preset.
     */
    @Test
    public void testParseToeWahPhas() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("022_ToeWah_Phas.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("ToeWah/Phas", program.getProgramName());
    }

    /**
     * Test parsing the ToeWah/Chrs preset.
     */
    @Test
    public void testParseToeWahChrs() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("023_ToeWah_Chrs.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("ToeWah/Chrs", program.getProgramName());
    }

    /**
     * Test parsing the ToeWah/Aero preset.
     */
    @Test
    public void testParseToeWahAero() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("024_ToeWah_Aero.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("ToeWah/Aero", program.getProgramName());
    }

    /**
     * Test parsing the ToeWah/Uni preset.
     */
    @Test
    public void testParseToeWahUni() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("025_ToeWah_Uni.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("ToeWah/Uni", program.getProgramName());
    }

    /**
     * Test parsing the Wah & Flange preset.
     */
    @Test
    public void testParseWahFlange() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("026_Wah_&_Flange.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Wah & Flange", program.getProgramName());
    }

    /**
     * Test parsing the Wah & Phaser preset.
     */
    @Test
    public void testParseWahPhaser() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("027_Wah_&_Phaser.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Wah & Phaser", program.getProgramName());
    }

    /**
     * Test parsing the Wah & Chorus preset.
     */
    @Test
    public void testParseWahChorus() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("028_Wah_&_Chorus.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Wah & Chorus", program.getProgramName());
    }

    /**
     * Test parsing the Wah & Aero preset.
     */
    @Test
    public void testParseWahAero() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("029_Wah_&_Aero.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Wah & Aero", program.getProgramName());
    }

    /**
     * Test parsing the ChrsDlyRvb+ preset.
     */
    @Test
    public void testParseChrsDlyRvb() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("030_ChrsDlyRvb+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("ChrsDlyRvb+", program.getProgramName());
    }

    /**
     * Test parsing the TS Chorus+ preset.
     */
    @Test
    public void testParseTSChorus() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("031_TS_Chorus+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("TS Chorus+", program.getProgramName());
    }

    /**
     * Test parsing the TS Delay+ preset.
     */
    @Test
    public void testParseTSDelay() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("032_TS_Delay+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("TS Delay+", program.getProgramName());
    }

    /**
     * Test parsing the TS ChrsDly+ preset.
     */
    @Test
    public void testParseTSChrsDly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("033_TS_ChrsDly+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("TS ChrsDly+", program.getProgramName());
    }

    /**
     * Test parsing the TS Reverb+ preset.
     */
    @Test
    public void testParseTSReverb() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("034_TS_Reverb+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("TS Reverb+", program.getProgramName());
    }

    /**
     * Test parsing the TS ChrsRvb+ preset.
     */
    @Test
    public void testParseTSChrsRvb() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("035_TS_ChrsRvb+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("TS ChrsRvb+", program.getProgramName());
    }

    /**
     * Test parsing the CompChorus+ preset.
     */
    @Test
    public void testParseCompChorus() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("036_CompChorus+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("CompChorus+", program.getProgramName());
    }

    /**
     * Test parsing the CompDelay+ preset.
     */
    @Test
    public void testParseCompDelay() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("037_CompDelay+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("CompDelay+", program.getProgramName());
    }

    /**
     * Test parsing the CompChrsDly+ preset.
     */
    @Test
    public void testParseCompChrsDly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("038_CompChrsDly+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("CompChrsDly+", program.getProgramName());
    }

    /**
     * Test parsing the CompChrsRvb+ preset.
     */
    @Test
    public void testParseCompChrsRvb() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("039_CompChrsRvb+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("CompChrsRvb+", program.getProgramName());
    }

    /**
     * Test parsing the PitchCascade preset.
     */
    @Test
    public void testParsePitchCascade() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("040_PitchCascade.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("PitchCascade", program.getProgramName());
    }

    /**
     * Test parsing the Pdl Octaves preset.
     */
    @Test
    public void testParsePdlOctaves() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("041_Pdl_Octaves.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Pdl Octaves", program.getProgramName());
    }

    /**
     * Test parsing the Pdl 2nds preset.
     */
    @Test
    public void testParsePdl2nds() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("042_Pdl_2nds.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Pdl 2nds", program.getProgramName());
    }

    /**
     * Test parsing the Pdl 2~3 b3~3 preset.
     */
    @Test
    public void testParsePdl2_3_b3_3() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("043_Pdl_2-3_b3-3.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Pdl 2~3 b3~3", program.getProgramName()); // TODO this can't be right
    }

    /**
     * Test parsing the Pdl 2~3  3~4 preset.
     */
    @Test
    public void testParsePdl2_3_3_4() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("044_Pdl_2-3_3-4.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Pdl 2~3  3~4", program.getProgramName()); // TODO this can't be right
    }

    /**
     * Test parsing the Pdl 4~5 5~6 preset.
     */
    @Test
    public void testParsePdl4_5_5_6() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("045_Pdl_4-5_5-6.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Pdl 4~5 5~6", program.getProgramName()); // TODO this can't be right
    }

    /**
     * Test parsing the Octaves preset.
     */
    @Test
    public void testParseOctaves() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("046_Octaves.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Octaves", program.getProgramName());
    }

    /**
     * Test parsing the 4ths & 5ths preset.
     */
    @Test
    public void testParse4ths5ths() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("047_4ths_&_5ths.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("4ths & 5ths", program.getProgramName());
    }

    /**
     * Test parsing the E Maj/Min 3 preset.
     */
    @Test
    public void testParseEMajMin3() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("048_E_Maj_Min_3.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("E Maj/Min 3", program.getProgramName());
    }

    /**
     * Test parsing the E Dor/Mix 3 preset.
     */
    @Test
    public void testParseEDorMix3() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("049_E_Dor_Mix_3.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("E Dor/Mix 3", program.getProgramName());
    }

    /**
     * Test parsing the Detune+Trem preset.
     */
    @Test
    public void testParseDetuneTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("050_Detune+Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Detune+Trem", program.getProgramName());
    }

    /**
     * Test parsing the Square Trem preset.
     */
    @Test
    public void testParseSquareTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("051_Square_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Square Trem", program.getProgramName());
    }

    /**
     * Test parsing the Trem~AutoWah preset.
     */
    @Test
    public void testParseTremAutoWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("052_Trem_AutoWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Trem~AutoWah", program.getProgramName()); // TODO this can't be right
    }

    /**
     * Test parsing the Env Trem preset.
     */
    @Test
    public void testParseEnvTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("053_Env_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Env Trem", program.getProgramName());
    }

    /**
     * Test parsing the Env AutoWahs preset.
     */
    @Test
    public void testParseEnvAutoWahs() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("054_Env_AutoWahs.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Env AutoWahs", program.getProgramName());
    }

    /**
     * Test parsing the Chaos Dance preset.
     */
    @Test
    public void testParseChaosDance() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("055_Chaos_Dance.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Chaos Dance", program.getProgramName());
    }

    /**
     * Test parsing the Round Trem preset.
     */
    @Test
    public void testParseRoundTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("056_Round_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Round Trem", program.getProgramName());
    }

    /**
     * Test parsing the Tap AutoWah preset.
     */
    @Test
    public void testParseTapAutoWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("057_Tap_AutoWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Tap AutoWah", program.getProgramName());
    }

    /**
     * Test parsing the Verbolo preset.
     */
    @Test
    public void testParseVerbolo() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("058_Verbolo.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Verbolo", program.getProgramName());
    }

    /**
     * Test parsing the DynaChrsTrem preset.
     */
    @Test
    public void testParseDynaChrsTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("059_DynaChrsTrem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("DynaChrsTrem", program.getProgramName());
    }

    /**
     * Test parsing the Univybe preset.
     */
    @Test
    public void testParseUnivybe() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("060_Univybe.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Univybe", program.getProgramName());
    }

    /**
     * Test parsing the Octave Fuzz preset.
     */
    @Test
    public void testParseOctaveFuzz() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("061_Octave_Fuzz.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Octave Fuzz", program.getProgramName());
    }

    /**
     * Test parsing the Phaser preset.
     */
    @Test
    public void testParsePhaser() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("062_Phaser.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Phaser", program.getProgramName());
    }

    /**
     * Test parsing the EnvFilter preset.
     */
    @Test
    public void testParseEnvFilter() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("063_EnvFilter.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("EnvFilter", program.getProgramName());
    }

    /**
     * Test parsing the C-Wah preset.
     */
    @Test
    public void testParseCWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("064_C-Wah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("C-Wah", program.getProgramName());
    }

    /**
     * Test parsing the Blue Comp preset.
     */
    @Test
    public void testParseBlueComp() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("065_Blue_Comp.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Blue Comp", program.getProgramName());
    }

    /**
     * Test parsing the Vintage Trem preset.
     */
    @Test
    public void testParseVintageTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("066_Vintage_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Vintage Trem", program.getProgramName());
    }

    /**
     * Test parsing the IPS TapeSlap preset.
     */
    @Test
    public void testParseIPSTapeSlap() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("067_IPS_TapeSlap.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("IPS TapeSlap", program.getProgramName());
    }

    /**
     * Test parsing the Space Echo preset.
     */
    @Test
    public void testParseSpaceEcho() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("068_Space_Echo.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Space Echo", program.getProgramName());
    }

    /**
     * Test parsing the Octabuzz preset.
     */
    @Test
    public void testParseOctabuzz() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("069_Octabuzz.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Octabuzz", program.getProgramName());
    }

    /**
     * Test parsing the OrangePhase preset.
     */
    @Test
    public void testParseOrangePhase() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("070_OrangePhase.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("OrangePhase", program.getProgramName());
    }

    /**
     * Test parsing the Gray Flange preset.
     */
    @Test
    public void testParseGrayFlange() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("071_Gray_Flange.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Gray Flange", program.getProgramName());
    }

    /**
     * Test parsing the Red Comp preset.
     */
    @Test
    public void testParseRedComp() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("072_Red_Comp.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Red Comp", program.getProgramName());
    }

    /**
     * Test parsing the S/H Pedal preset.
     */
    @Test
    public void testParseSHPedal() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("073_S_H_Pedal.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("S/H Pedal", program.getProgramName());
    }

    /**
     * Test parsing the V-Wah preset.
     */
    @Test
    public void testParseVWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("074_V-Wah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("V-Wah", program.getProgramName());
    }

    /**
     * Test parsing the Modern Trem preset.
     */
    @Test
    public void testParseModernTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("075_Modern_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Modern Trem", program.getProgramName());
    }

    /**
     * Test parsing the Tap Echo preset.
     */
    @Test
    public void testParseTapEcho() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("076_Tap_Echo.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Tap Echo", program.getProgramName());
    }

    /**
     * Test parsing the Env Wah preset.
     */
    @Test
    public void testParseEnvWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("077_Env_Wah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Env Wah", program.getProgramName());
    }

    /**
     * Test parsing the StereoChorus preset.
     */
    @Test
    public void testParseStereoChorus() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("078_StereoChorus.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("StereoChorus", program.getProgramName());
    }

    /**
     * Test parsing the ClasscDetune preset.
     */
    @Test
    public void testParseClasscDetune() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("079_ClasscDetune.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("ClasscDetune", program.getProgramName());
    }

    /**
     * Test parsing the Tone Boost preset.
     */
    @Test
    public void testParseToneBoost() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("080_Tone_Boost.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Tone Boost", program.getProgramName());
    }

    /**
     * Test parsing the Crunch Boost preset.
     */
    @Test
    public void testParseCrunchBoost() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("081_Crunch_Boost.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Crunch Boost", program.getProgramName());
    }

    /**
     * Test parsing the TS Lead preset.
     */
    @Test
    public void testParseTSLead() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("082_TS_Lead.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("TS Lead", program.getProgramName());
    }

    /**
     * Test parsing the TS Boost preset.
     */
    @Test
    public void testParseTSBoost() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("083_TS_Boost.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("TS Boost", program.getProgramName());
    }

    /**
     * Test parsing the OD Lead preset.
     */
    @Test
    public void testParseODLead() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("084_OD_Lead.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("OD Lead", program.getProgramName());
    }

    /**
     * Test parsing the OD Boost preset.
     */
    @Test
    public void testParseODBoost() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("085_OD_Boost.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("OD Boost", program.getProgramName());
    }

    /**
     * Test parsing the Dist Lead preset.
     */
    @Test
    public void testParseDistLead() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("086_Dist_Lead.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Dist Lead", program.getProgramName());
    }

    /**
     * Test parsing the Dist Boost preset.
     */
    @Test
    public void testParseDistBoost() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("087_Dist_Boost.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Dist Boost", program.getProgramName());
    }

    /**
     * Test parsing the Fuzz 1 preset.
     */
    @Test
    public void testParseFuzz1() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("088_Fuzz_1.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Fuzz 1", program.getProgramName());
    }

    /**
     * Test parsing the Fuzz 2 preset.
     */
    @Test
    public void testParseFuzz2() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("089_Fuzz_2.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Fuzz 2", program.getProgramName());
    }

    /**
     * Test parsing the Jam Chrs+ preset.
     */
    @Test
    public void testParseJamChrs() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("090_Jam_Chrs+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Jam Chrs+", program.getProgramName());
    }

    /**
     * Test parsing the Jam 1 Uni+ preset.
     */
    @Test
    public void testParseJam1Uni() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("091_Jam_1__Uni+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Jam 1  Uni+", program.getProgramName());
    }

    /**
     * Test parsing the Jam 1 S&H+ preset.
     */
    @Test
    public void testParseJam1SH() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("092_Jam_1_S&H+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Jam 1 S&H+", program.getProgramName());
    }

    /**
     * Test parsing the Jam 1 Env+ preset.
     */
    @Test
    public void testParseJam1Env() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("093_Jam_1_Env+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Jam 1 Env+", program.getProgramName());
    }

    /**
     * Test parsing the Jam1Cordovox preset.
     */
    @Test
    public void testParseJam1Cordovox() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("094_Jam1Cordovox.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Jam1Cordovox", program.getProgramName());
    }

    /**
     * Test parsing the Jam 2 Flange preset.
     */
    @Test
    public void testParseJam2Flange() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("095_Jam_2_Flange.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Jam 2 Flange", program.getProgramName());
    }

    /**
     * Test parsing the Jam 2 Phase preset.
     */
    @Test
    public void testParseJam2Phase() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("096_Jam_2_Phase.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Jam 2 Phase", program.getProgramName());
    }

    /**
     * Test parsing the Jam 2 Pitch+ preset.
     */
    @Test
    public void testParseJam2Pitch() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("097_Jam_2_Pitch+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Jam 2 Pitch+", program.getProgramName());
    }

    /**
     * Test parsing the Jam 2 Trem preset.
     */
    @Test
    public void testParseJam2Trem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("098_Jam_2_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Jam 2 Trem", program.getProgramName());
    }

    /**
     * Test parsing the Jam2AutoWah preset.
     */
    @Test
    public void testParseJam2AutoWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("099_Jam2AutoWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertEquals("Jam2AutoWah", program.getProgramName());
    }

    /**
     * Test parsing the various noise gate values.
     */
    @Test
    public void testParseNoiseGate() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("noisegate.syx").toURI());
        NoiseGate noiseGate = SysexParser.parsePrograms(preset).get(0).getNoiseGate();

        assertEquals(2, noiseGate.getEnable());
        assertTrue(noiseGate.isSend());
        assertEquals(-31, noiseGate.getThreshold());
        assertEquals(-7, noiseGate.getAttenuation());
        assertEquals(-11, noiseGate.getOffset());
        assertEquals(1999, noiseGate.getATime());
        assertEquals(499, noiseGate.getHTime());
        assertEquals(2000, noiseGate.getRTime());
        assertEquals(10, noiseGate.getDelay());
    }
}
