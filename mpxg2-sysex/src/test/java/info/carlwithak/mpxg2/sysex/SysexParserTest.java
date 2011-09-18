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

import info.carlwithak.mpxg2.model.NoiseGate;
import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.model.effects.algorithms.DetuneDual;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah1;
import info.carlwithak.mpxg2.model.effects.algorithms.UniVybe;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests for SysexParser, using real files dumped from the MPX G2.
 *
 * @author carl
 */
public class SysexParserTest {

    /**
     * Test parsing invalid data.
     */
    @Test
    public void testParseInvalidData() throws Exception {
        String expectedMessage = null;
        try {
            File temp = tempFileWithData(new byte[]{(byte) 0xe0});
            expectedMessage = "Invalid Sysex ID (start)";
            SysexParser.parseProgram(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }

        try {
            File temp = tempFileWithData(new byte[]{(byte) 0xf0, 0x05});
            expectedMessage = "Invalid Manufacturer ID";
            SysexParser.parseProgram(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }

        try {
            File temp = tempFileWithData(new byte[]{(byte) 0xf0, 0x06, 0x10});
            expectedMessage = "Invalid Product ID";
            SysexParser.parseProgram(temp);
            fail("Expected \"" + expectedMessage + "\"");
        } catch (ParseException e) {
            assertEquals(expectedMessage, e.getMessage());
        }

        try {
            File temp = tempFileWithData(new byte[]{(byte) 0xf0, 0x06, 0x0f, 0x00, 0x00});
            expectedMessage = "Invalid Message Type";
            SysexParser.parseProgram(temp);
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

    /**
     * Test parsing the Clean Slate preset, which has pretty much nothing defined.
     */
    @Test
    public void testParseCleanSlate() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("250_Clean_Slate.syx").toURI());
        Program program = SysexParser.parseProgram(preset);

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

        assertEquals("I=1=2=G=E=C=D=R=O", program.getRouting());

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

        assertEquals(0, program.getPatch1().getSource());
        assertEquals(0, program.getPatch1().getSourceMin());
        assertEquals(255, program.getPatch1().getSourceMid());
        assertEquals(127, program.getPatch1().getSourceMax());
        assertEquals(255, program.getPatch1().getDestinationEffect());
        assertEquals(255, program.getPatch1().getDestinationParameter());
        assertEquals(0, program.getPatch1().getDestinationMin());
        assertEquals(128, program.getPatch1().getDestinationMid());
        assertEquals(0, program.getPatch1().getDestinationMax());
        assertEquals(0, program.getPatch2().getSource());
        assertEquals(0, program.getPatch2().getSourceMin());
        assertEquals(255, program.getPatch2().getSourceMid());
        assertEquals(127, program.getPatch2().getSourceMax());
        assertEquals(255, program.getPatch2().getDestinationEffect());
        assertEquals(255, program.getPatch2().getDestinationParameter());
        assertEquals(0, program.getPatch2().getDestinationMin());
        assertEquals(128, program.getPatch2().getDestinationMid());
        assertEquals(0, program.getPatch2().getDestinationMax());
        assertEquals(0, program.getPatch3().getSource());
        assertEquals(0, program.getPatch3().getSourceMin());
        assertEquals(255, program.getPatch3().getSourceMid());
        assertEquals(127, program.getPatch3().getSourceMax());
        assertEquals(255, program.getPatch3().getDestinationEffect());
        assertEquals(255, program.getPatch3().getDestinationParameter());
        assertEquals(0, program.getPatch3().getDestinationMin());
        assertEquals(128, program.getPatch3().getDestinationMid());
        assertEquals(0, program.getPatch3().getDestinationMax());
        assertEquals(0, program.getPatch4().getSource());
        assertEquals(0, program.getPatch4().getSourceMin());
        assertEquals(255, program.getPatch4().getSourceMid());
        assertEquals(127, program.getPatch4().getSourceMax());
        assertEquals(255, program.getPatch4().getDestinationEffect());
        assertEquals(255, program.getPatch4().getDestinationParameter());
        assertEquals(0, program.getPatch4().getDestinationMin());
        assertEquals(128, program.getPatch4().getDestinationMid());
        assertEquals(0, program.getPatch4().getDestinationMax());
        assertEquals(0, program.getPatch5().getSource());
        assertEquals(0, program.getPatch5().getSourceMin());
        assertEquals(255, program.getPatch5().getSourceMid());
        assertEquals(127, program.getPatch5().getSourceMax());
        assertEquals(255, program.getPatch5().getDestinationEffect());
        assertEquals(255, program.getPatch5().getDestinationParameter());
        assertEquals(0, program.getPatch5().getDestinationMin());
        assertEquals(128, program.getPatch5().getDestinationMid());
        assertEquals(0, program.getPatch5().getDestinationMax());

        assertEquals(50, program.getKnobValue());
        assertEquals(0, program.getKnobLow());
        assertEquals(100, program.getKnobHigh());
        assertEquals("Delay Adj", program.getKnobName());

        assertEquals(1, program.getLfo1Mode());
        assertEquals(0.60, program.getLfo1Rate(), 0.001);
        assertEquals(50, program.getLfo1PulseWidth());
        assertEquals(0, program.getLfo1Phase());
        assertEquals(100, program.getLfo1Depth());
        assertEquals(64, program.getLfo1OnLevel());
        assertEquals(0, program.getLfo1OnSource());

        assertEquals(1, program.getLfo2Mode());
        assertEquals(0.92, program.getLfo2Rate(), 0.001);
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
        assertEquals(0, program.getNoiseGate().getSend());
        assertEquals(-83, program.getNoiseGate().getThreshold());
        assertEquals(-80, program.getNoiseGate().getAttenuation());
        assertEquals(-3, program.getNoiseGate().getOffset());
        assertEquals(0, program.getNoiseGate().getATime());
        assertEquals(100, program.getNoiseGate().getHTime());
        assertEquals(100, program.getNoiseGate().getRTime());
        assertEquals(0, program.getNoiseGate().getDelay());

        assertEquals(0, program.getBypassState());

        assertEquals(0, program.getSpeakerSimulatorEnable());
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
        Program program = SysexParser.parseProgram(preset);

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

        assertEquals("I=1=2=G=E=C=D=R=O", program.getRouting());

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

        assertEquals(0, program.getPatch1().getSource());
        assertEquals(0, program.getPatch1().getSourceMin());
        assertEquals(255, program.getPatch1().getSourceMid());
        assertEquals(127, program.getPatch1().getSourceMax());
        assertEquals(255, program.getPatch1().getDestinationEffect());
        assertEquals(255, program.getPatch1().getDestinationParameter());
        assertEquals(0, program.getPatch1().getDestinationMin());
        assertEquals(128, program.getPatch1().getDestinationMid());
        assertEquals(0, program.getPatch1().getDestinationMax());
        assertEquals(0, program.getPatch2().getSource());
        assertEquals(0, program.getPatch2().getSourceMin());
        assertEquals(255, program.getPatch2().getSourceMid());
        assertEquals(127, program.getPatch2().getSourceMax());
        assertEquals(255, program.getPatch2().getDestinationEffect());
        assertEquals(255, program.getPatch2().getDestinationParameter());
        assertEquals(0, program.getPatch2().getDestinationMin());
        assertEquals(128, program.getPatch2().getDestinationMid());
        assertEquals(0, program.getPatch2().getDestinationMax());
        assertEquals(0, program.getPatch3().getSource());
        assertEquals(0, program.getPatch3().getSourceMin());
        assertEquals(255, program.getPatch3().getSourceMid());
        assertEquals(127, program.getPatch3().getSourceMax());
        assertEquals(255, program.getPatch3().getDestinationEffect());
        assertEquals(255, program.getPatch3().getDestinationParameter());
        assertEquals(0, program.getPatch3().getDestinationMin());
        assertEquals(128, program.getPatch3().getDestinationMid());
        assertEquals(0, program.getPatch3().getDestinationMax());
        assertEquals(0, program.getPatch4().getSource());
        assertEquals(0, program.getPatch4().getSourceMin());
        assertEquals(255, program.getPatch4().getSourceMid());
        assertEquals(127, program.getPatch4().getSourceMax());
        assertEquals(255, program.getPatch4().getDestinationEffect());
        assertEquals(255, program.getPatch4().getDestinationParameter());
        assertEquals(0, program.getPatch4().getDestinationMin());
        assertEquals(128, program.getPatch4().getDestinationMid());
        assertEquals(0, program.getPatch4().getDestinationMax());
        assertEquals(0, program.getPatch5().getSource());
        assertEquals(0, program.getPatch5().getSourceMin());
        assertEquals(255, program.getPatch5().getSourceMid());
        assertEquals(127, program.getPatch5().getSourceMax());
        assertEquals(255, program.getPatch5().getDestinationEffect());
        assertEquals(255, program.getPatch5().getDestinationParameter());
        assertEquals(0, program.getPatch5().getDestinationMin());
        assertEquals(128, program.getPatch5().getDestinationMid());
        assertEquals(0, program.getPatch5().getDestinationMax());

        assertEquals(50, program.getKnobValue());
        assertEquals(0, program.getKnobLow());
        assertEquals(100, program.getKnobHigh());
        assertEquals("Delay Adj", program.getKnobName());

        assertEquals(1, program.getLfo1Mode());
        assertEquals(0.60, program.getLfo1Rate(), 0.001);
        assertEquals(50, program.getLfo1PulseWidth());
        assertEquals(0, program.getLfo1Phase());
        assertEquals(100, program.getLfo1Depth());
        assertEquals(64, program.getLfo1OnLevel());
        assertEquals(0, program.getLfo1OnSource());

        assertEquals(1, program.getLfo2Mode());
        assertEquals(0.92, program.getLfo2Rate(), 0.001);
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
        assertEquals(0, program.getNoiseGate().getSend());
        assertEquals(-83, program.getNoiseGate().getThreshold());
        assertEquals(-80, program.getNoiseGate().getAttenuation());
        assertEquals(-3, program.getNoiseGate().getOffset());
        assertEquals(0, program.getNoiseGate().getATime());
        assertEquals(100, program.getNoiseGate().getHTime());
        assertEquals(100, program.getNoiseGate().getRTime());
        assertEquals(0, program.getNoiseGate().getDelay());

        assertEquals(0, program.getBypassState());

        assertEquals(0, program.getSpeakerSimulatorEnable());
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
        Program program = SysexParser.parseProgram(preset);

        assertTrue(program.getEffect1() instanceof UniVybe);
        UniVybe effect1 = (UniVybe) program.getEffect1();
        assertEquals(100, effect1.getMix());
        assertEquals(0, effect1.getLevel());
        assertEquals(20, effect1.getRate());

        assertTrue(program.getEffect2() instanceof PedalWah1);
        PedalWah1 effect2 = (PedalWah1) program.getEffect2();
        assertEquals(100, effect2.getMix());
        assertEquals(0, effect2.getLevel());
        assertEquals(19, effect2.getBass());
        assertEquals(0, effect2.getType());
        assertEquals(100, effect2.getResponse());
        assertEquals(10, effect2.getGain());
        assertEquals(100, program.getChorus().getMix());
        assertEquals(0, program.getChorus().getLevel());
        assertEquals(2, program.getDelay().getMix());
        assertEquals(1, program.getDelay().getLevel());
        assertEquals(4, program.getDelay().getTime1Echoes());
        assertEquals(4, program.getDelay().getTime1Beat());
        assertEquals(2, program.getDelay().getTime2Echoes());
        assertEquals(1, program.getDelay().getTime2Beat());
        assertEquals(0, program.getDelay().getLevel1());
        assertEquals(0, program.getDelay().getLevel2());
        assertEquals(1, program.getDelay().getFeedback1());
        assertEquals(3, program.getDelay().getInsert());
        assertEquals(1, program.getDelay().getFeedback2());
        assertEquals(20, program.getDelay().getDamp1());
        assertEquals(20, program.getDelay().getDamp2());
        assertEquals(0, program.getDelay().getClear());
        assertEquals(18, program.getReverb().getMix());
        assertEquals(0, program.getReverb().getLevel());
        assertEquals(24.5, program.getReverb().getSize(), 0.01);
        assertEquals(1, program.getReverb().getLink());
        assertEquals(60, program.getReverb().getDiff());
        assertEquals(7, program.getReverb().getPreDelay());
        assertEquals(51, program.getReverb().getDelayTime()); // 1.41s is number 51 in list
        assertEquals(0, program.getReverb().getDelayLevel());
        assertEquals(12, program.getReverb().getRtHC()); // 12.8k is number 12 in list
        // no eq
        assertEquals(2, program.getGain().getLo());
        assertEquals(1, program.getGain().getMid());
        assertEquals(3, program.getGain().getHi());
        assertEquals(22, program.getGain().getDrive());
        assertEquals(25, program.getGain().getTone());
        assertEquals(57, program.getGain().getLevel());

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

        assertEquals("I=1=2=G=C=D=R=E=O", program.getRouting());

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


        assertEquals(16, program.getPatch1().getSource()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch1().getSourceMin());
        assertEquals(255, program.getPatch1().getSourceMid());
        assertEquals(127, program.getPatch1().getSourceMax());
        assertEquals(3, program.getPatch1().getDestinationEffect());
        assertEquals(0, program.getPatch1().getDestinationParameter());
        assertEquals(2, program.getPatch1().getDestinationMin());
        assertEquals(128, program.getPatch1().getDestinationMid());
        assertEquals(30, program.getPatch1().getDestinationMax());
        assertEquals(16, program.getPatch2().getSource()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch2().getSourceMin());
        assertEquals(255, program.getPatch2().getSourceMid());
        assertEquals(127, program.getPatch2().getSourceMax());
        assertEquals(3, program.getPatch2().getDestinationEffect());
        assertEquals(3, program.getPatch2().getDestinationParameter());
        assertEquals(260, program.getPatch2().getDestinationMin()); // TODO 260 = 0x0104 => 4, 1 - figure out how to split this
        assertEquals(128, program.getPatch2().getDestinationMid());
        assertEquals(516, program.getPatch2().getDestinationMax()); // TODO 516 = 0x0204 => 4, 2 - figure out how to split this
        assertEquals(16, program.getPatch3().getSource()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch3().getSourceMin());
        assertEquals(255, program.getPatch3().getSourceMid());
        assertEquals(127, program.getPatch3().getSourceMax());
        assertEquals(3, program.getPatch3().getDestinationEffect());
        assertEquals(6, program.getPatch3().getDestinationParameter());
        assertEquals(1, program.getPatch3().getDestinationMin());
        assertEquals(128, program.getPatch3().getDestinationMid());
        assertEquals(15, program.getPatch3().getDestinationMax());
        assertEquals(16, program.getPatch4().getSource()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch4().getSourceMin());
        assertEquals(255, program.getPatch4().getSourceMid());
        assertEquals(127, program.getPatch4().getSourceMax());
        assertEquals(3, program.getPatch4().getDestinationEffect());
        assertEquals(7, program.getPatch4().getDestinationParameter());
        assertEquals(1, program.getPatch4().getDestinationMin());
        assertEquals(128, program.getPatch4().getDestinationMid());
        assertEquals(4, program.getPatch4().getDestinationMax());
        assertEquals(157, program.getPatch5().getSource()); // TODO why is the source 157 (0x9d) not 21 (0x15)?
        assertEquals(0, program.getPatch5().getSourceMin());
        assertEquals(255, program.getPatch5().getSourceMid());
        assertEquals(127, program.getPatch5().getSourceMax());
        assertEquals(16, program.getPatch5().getDestinationEffect());
        assertEquals(0, program.getPatch5().getDestinationParameter());
        assertEquals(0, program.getPatch5().getDestinationMin());
        assertEquals(128, program.getPatch5().getDestinationMid());
        assertEquals(6, program.getPatch5().getDestinationMax());

        assertEquals(50, program.getKnobValue());
        assertEquals(0, program.getKnobLow());
        assertEquals(100, program.getKnobHigh());
        assertEquals("Delay Adj", program.getKnobName());

        assertEquals(1, program.getLfo1Mode());
        assertEquals(0.60, program.getLfo1Rate(), 0.001);
        assertEquals(50, program.getLfo1PulseWidth());
        assertEquals(0, program.getLfo1Phase());
        assertEquals(100, program.getLfo1Depth());
        assertEquals(64, program.getLfo1OnLevel());
        assertEquals(0, program.getLfo1OnSource());

        assertEquals(1, program.getLfo2Mode());
        assertEquals(0.92, program.getLfo2Rate(), 0.001);
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
        assertEquals(1, program.getNoiseGate().getSend());
        assertEquals(-83, program.getNoiseGate().getThreshold());
        assertEquals(-85, program.getNoiseGate().getAttenuation());
        assertEquals(-3, program.getNoiseGate().getOffset());
        assertEquals(0, program.getNoiseGate().getATime());
        assertEquals(100, program.getNoiseGate().getHTime());
        assertEquals(100, program.getNoiseGate().getRTime());
        assertEquals(0, program.getNoiseGate().getDelay());

        assertEquals(0, program.getBypassState());

        assertEquals(0, program.getSpeakerSimulatorEnable());
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
        Program program = SysexParser.parseProgram(preset);

        assertTrue(program.getEffect1() instanceof DetuneDual);
        DetuneDual effect1 = (DetuneDual) program.getEffect1();
        assertEquals(100, effect1.getMix());
        assertEquals(3, effect1.getLevel());
        assertEquals(7, effect1.getTune1());
        assertEquals(10, effect1.getOptimize());
        assertEquals(5, effect1.getTune2());
        assertEquals(22, effect1.getPreDelay());
    }

    /**
     * Test parsing the various noise gate values.
     */
    @Test
    public void testParseNoiseGate() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("noisegate.syx").toURI());
        NoiseGate noiseGate = SysexParser.parseProgram(preset).getNoiseGate();

        assertEquals(2, noiseGate.getEnable());
        assertEquals(1, noiseGate.getSend());
        assertEquals(-31, noiseGate.getThreshold());
        assertEquals(-7, noiseGate.getAttenuation());
        assertEquals(-11, noiseGate.getOffset());
        assertEquals(1999, noiseGate.getATime());
        assertEquals(499, noiseGate.getHTime());
        assertEquals(2000, noiseGate.getRTime());
        assertEquals(10, noiseGate.getDelay());
    }
}
