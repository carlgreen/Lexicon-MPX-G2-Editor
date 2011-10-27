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
import info.carlwithak.mpxg2.model.effects.algorithms.PedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah1;
import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;
import info.carlwithak.mpxg2.model.effects.algorithms.ShiftDual;
import info.carlwithak.mpxg2.model.effects.algorithms.SweepFilter;
import info.carlwithak.mpxg2.model.effects.algorithms.Tone;
import info.carlwithak.mpxg2.model.effects.algorithms.TremoloMono;
import info.carlwithak.mpxg2.model.effects.algorithms.UniVybe;
import info.carlwithak.mpxg2.model.effects.algorithms.VolumeDual;
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

        assertEquals(0, program.getEffect1Algorithm());
        assertEquals(0, program.getEffect2Algorithm());
        assertEquals(0, program.getChorusAlgorithm());
        assertEquals(0, program.getDelayAlgorithm());
        assertEquals(0, program.getReverbAlgorithm());
        assertEquals(0, program.getEqAlgorithm());
        assertEquals(0, program.getGainAlgorithm());

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

        assertEquals(27, program.getEffect1Algorithm());
        assertEquals(0, program.getEffect2Algorithm());
        assertEquals(0, program.getChorusAlgorithm());
        assertEquals(0, program.getDelayAlgorithm());
        assertEquals(0, program.getReverbAlgorithm());
        assertEquals(0, program.getEqAlgorithm());
        assertEquals(0, program.getGainAlgorithm());

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
        assertTrue(program.getChorus() instanceof PedalVol);
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

        assertEquals(12, program.getEffect1Algorithm());
        assertEquals(18, program.getEffect2Algorithm());
        assertEquals(16, program.getChorusAlgorithm());
        assertEquals(6, program.getDelayAlgorithm());
        assertEquals(4, program.getReverbAlgorithm());
        assertEquals(0, program.getEqAlgorithm());
        assertEquals(3, program.getGainAlgorithm());

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
        assertTrue(program.getChorus() instanceof VolumeDual);
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
