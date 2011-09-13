package info.carlwithak.mpxg2.sysex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;
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

        assertEquals(120, program.getTempo());
        assertEquals(0, program.getTempoSource());
        assertEquals(2, program.getBeatValue()); // quater note
        assertEquals(0, program.getTapSource());
        assertEquals(2, program.getTapAverage());
        assertEquals(64, program.getTapSourceLevel());

        assertEquals(0, program.getPatch1Source());
        assertEquals(0, program.getPatch1SourceMin());
        assertEquals(255, program.getPatch1SourceMid());
        assertEquals(127, program.getPatch1SourceMax());
        assertEquals(255, program.getPatch1DestinationEffect());
        assertEquals(255, program.getPatch1DestinationParameter());
        assertEquals(0, program.getPatch1DestinationMin());
        assertEquals(128, program.getPatch1DestinationMid());
        assertEquals(0, program.getPatch1DestinationMax());
        assertEquals(0, program.getPatch2Source());
        assertEquals(0, program.getPatch2SourceMin());
        assertEquals(255, program.getPatch2SourceMid());
        assertEquals(127, program.getPatch2SourceMax());
        assertEquals(255, program.getPatch2DestinationEffect());
        assertEquals(255, program.getPatch2DestinationParameter());
        assertEquals(0, program.getPatch2DestinationMin());
        assertEquals(128, program.getPatch2DestinationMid());
        assertEquals(0, program.getPatch2DestinationMax());
        assertEquals(0, program.getPatch3Source());
        assertEquals(0, program.getPatch3SourceMin());
        assertEquals(255, program.getPatch3SourceMid());
        assertEquals(127, program.getPatch3SourceMax());
        assertEquals(255, program.getPatch3DestinationEffect());
        assertEquals(255, program.getPatch3DestinationParameter());
        assertEquals(0, program.getPatch3DestinationMin());
        assertEquals(128, program.getPatch3DestinationMid());
        assertEquals(0, program.getPatch3DestinationMax());
        assertEquals(0, program.getPatch4Source());
        assertEquals(0, program.getPatch4SourceMin());
        assertEquals(255, program.getPatch4SourceMid());
        assertEquals(127, program.getPatch4SourceMax());
        assertEquals(255, program.getPatch4DestinationEffect());
        assertEquals(255, program.getPatch4DestinationParameter());
        assertEquals(0, program.getPatch4DestinationMin());
        assertEquals(128, program.getPatch4DestinationMid());
        assertEquals(0, program.getPatch4DestinationMax());
        assertEquals(0, program.getPatch5Source());
        assertEquals(0, program.getPatch5SourceMin());
        assertEquals(255, program.getPatch5SourceMid());
        assertEquals(127, program.getPatch5SourceMax());
        assertEquals(255, program.getPatch5DestinationEffect());
        assertEquals(255, program.getPatch5DestinationParameter());
        assertEquals(0, program.getPatch5DestinationMin());
        assertEquals(128, program.getPatch5DestinationMid());
        assertEquals(0, program.getPatch5DestinationMax());

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

        assertEquals(0, program.getNoiseGateEnable());
        assertEquals(0, program.getNoiseGateSend());
        assertEquals(-83, program.getNoiseGateThreshold());
        assertEquals(-80, program.getNoiseGateAttenuation());
        assertEquals(-3, program.getNoiseGateOffset());
        assertEquals(0, program.getNoiseGateATime());
        assertEquals(100, program.getNoiseGateHTime());
        assertEquals(100, program.getNoiseGateRTime());
        assertEquals(0, program.getNoiseGateDelay());

        assertEquals(0, program.getBypassState());

        assertEquals(0, program.getSpeakerSimulatorEnable());
        assertEquals(1, program.getSpeakerSimulatorCabinet());

        assertEquals(0, program.getSendLevel());
        assertEquals(0, program.getSendBypassLevel());
        assertEquals(100, program.getPostMix());
        assertEquals(0, program.getPostLevel());
        assertEquals(0, program.getPostBypassLevel());
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

        assertEquals(170, program.getTempo());
        assertEquals(0, program.getTempoSource());
        assertEquals(2, program.getBeatValue()); // quater note
        assertEquals(0, program.getTapSource());
        assertEquals(2, program.getTapAverage());
        assertEquals(64, program.getTapSourceLevel());

        assertEquals(0, program.getPatch1Source());
        assertEquals(0, program.getPatch1SourceMin());
        assertEquals(255, program.getPatch1SourceMid());
        assertEquals(127, program.getPatch1SourceMax());
        assertEquals(255, program.getPatch1DestinationEffect());
        assertEquals(255, program.getPatch1DestinationParameter());
        assertEquals(0, program.getPatch1DestinationMin());
        assertEquals(128, program.getPatch1DestinationMid());
        assertEquals(0, program.getPatch1DestinationMax());
        assertEquals(0, program.getPatch2Source());
        assertEquals(0, program.getPatch2SourceMin());
        assertEquals(255, program.getPatch2SourceMid());
        assertEquals(127, program.getPatch2SourceMax());
        assertEquals(255, program.getPatch2DestinationEffect());
        assertEquals(255, program.getPatch2DestinationParameter());
        assertEquals(0, program.getPatch2DestinationMin());
        assertEquals(128, program.getPatch2DestinationMid());
        assertEquals(0, program.getPatch2DestinationMax());
        assertEquals(0, program.getPatch3Source());
        assertEquals(0, program.getPatch3SourceMin());
        assertEquals(255, program.getPatch3SourceMid());
        assertEquals(127, program.getPatch3SourceMax());
        assertEquals(255, program.getPatch3DestinationEffect());
        assertEquals(255, program.getPatch3DestinationParameter());
        assertEquals(0, program.getPatch3DestinationMin());
        assertEquals(128, program.getPatch3DestinationMid());
        assertEquals(0, program.getPatch3DestinationMax());
        assertEquals(0, program.getPatch4Source());
        assertEquals(0, program.getPatch4SourceMin());
        assertEquals(255, program.getPatch4SourceMid());
        assertEquals(127, program.getPatch4SourceMax());
        assertEquals(255, program.getPatch4DestinationEffect());
        assertEquals(255, program.getPatch4DestinationParameter());
        assertEquals(0, program.getPatch4DestinationMin());
        assertEquals(128, program.getPatch4DestinationMid());
        assertEquals(0, program.getPatch4DestinationMax());
        assertEquals(0, program.getPatch5Source());
        assertEquals(0, program.getPatch5SourceMin());
        assertEquals(255, program.getPatch5SourceMid());
        assertEquals(127, program.getPatch5SourceMax());
        assertEquals(255, program.getPatch5DestinationEffect());
        assertEquals(255, program.getPatch5DestinationParameter());
        assertEquals(0, program.getPatch5DestinationMin());
        assertEquals(128, program.getPatch5DestinationMid());
        assertEquals(0, program.getPatch5DestinationMax());

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

        assertEquals(0, program.getNoiseGateEnable());
        assertEquals(0, program.getNoiseGateSend());
        assertEquals(-83, program.getNoiseGateThreshold());
        assertEquals(-80, program.getNoiseGateAttenuation());
        assertEquals(-3, program.getNoiseGateOffset());
        assertEquals(0, program.getNoiseGateATime());
        assertEquals(100, program.getNoiseGateHTime());
        assertEquals(100, program.getNoiseGateRTime());
        assertEquals(0, program.getNoiseGateDelay());

        assertEquals(0, program.getBypassState());

        assertEquals(0, program.getSpeakerSimulatorEnable());
        assertEquals(1, program.getSpeakerSimulatorCabinet());

        assertEquals(0, program.getSendLevel());
        assertEquals(0, program.getSendBypassLevel());
        assertEquals(100, program.getPostMix());
        assertEquals(0, program.getPostLevel());
        assertEquals(0, program.getPostBypassLevel());
    }

    /**
     * Test parsing the G2 Blue preset.
     */
    @Test
    public void testParseG2Blue() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("001_G2_Blue.syx").toURI());
        Program program = SysexParser.parseProgram(preset);

        assertEquals(100, program.getEffect1Mix());
        assertEquals(0, program.getEffect1Level());
        assertEquals(20, program.getEffect1Rate());
        assertEquals(100, program.getEffect2Mix());
        assertEquals(0, program.getEffect2Level());
        assertEquals(19, program.getEffect2Bass());
        assertEquals(0, program.getEffect2Type());
        assertEquals(100, program.getEffect2Response());
        assertEquals(10, program.getEffect2Gain());
        assertEquals(100, program.getChorusMix());
        assertEquals(0, program.getChorusLevel());
        assertEquals(2, program.getDelayMix());
        assertEquals(1, program.getDelayLevel());
        assertEquals(4, program.getDelayTime1Echoes());
        assertEquals(4, program.getDelayTime1Beat());
        assertEquals(2, program.getDelayTime2Echoes());
        assertEquals(1, program.getDelayTime2Beat());
        assertEquals(0, program.getDelayLevel1());
        assertEquals(0, program.getDelayLevel2());
        assertEquals(1, program.getDelayFeedback1());
        assertEquals(3, program.getDelayInsert());
        assertEquals(1, program.getDelayFeedback2());
        assertEquals(20, program.getDelayDamp1());
        assertEquals(20, program.getDelayDamp2());
        assertEquals(0, program.getDelayClear());
        assertEquals(18, program.getReverbMix());
        assertEquals(0, program.getReverbLevel());
        assertEquals(24.5, program.getReverbSize(), 0.01);
        assertEquals(1, program.getReverbLink());
        assertEquals(60, program.getReverbDiff());
        assertEquals(7, program.getReverbPreDelay());
        assertEquals(51, program.getReverbDelayTime()); // 1.41s is number 51 in list
        assertEquals(0, program.getReverbDelayLevel());
        assertEquals(12, program.getReverbRtHC()); // 12.8k is number 12 in list
        // no eq
        assertEquals(2, program.getGainLo());
        assertEquals(1, program.getGainMid());
        assertEquals(3, program.getGainHi());
        assertEquals(22, program.getGainDrive());
        assertEquals(25, program.getGainTone());
        assertEquals(57, program.getGainLevel());

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

        assertEquals(120, program.getTempo());
        assertEquals(0, program.getTempoSource());
        assertEquals(2, program.getBeatValue()); // quater note
        assertEquals(0, program.getTapSource());
        assertEquals(2, program.getTapAverage());
        assertEquals(64, program.getTapSourceLevel());


        assertEquals(16, program.getPatch1Source()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch1SourceMin());
        assertEquals(255, program.getPatch1SourceMid());
        assertEquals(127, program.getPatch1SourceMax());
        assertEquals(3, program.getPatch1DestinationEffect());
        assertEquals(0, program.getPatch1DestinationParameter());
        assertEquals(2, program.getPatch1DestinationMin());
        assertEquals(128, program.getPatch1DestinationMid());
        assertEquals(30, program.getPatch1DestinationMax());
        assertEquals(16, program.getPatch2Source()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch2SourceMin());
        assertEquals(255, program.getPatch2SourceMid());
        assertEquals(127, program.getPatch2SourceMax());
        assertEquals(3, program.getPatch2DestinationEffect());
        assertEquals(3, program.getPatch2DestinationParameter());
        assertEquals(260, program.getPatch2DestinationMin()); // TODO 260 = 0x0104 => 4, 1 - figure out how to split this
        assertEquals(128, program.getPatch2DestinationMid());
        assertEquals(516, program.getPatch2DestinationMax()); // TODO 516 = 0x0204 => 4, 2 - figure out how to split this
        assertEquals(16, program.getPatch3Source()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch3SourceMin());
        assertEquals(255, program.getPatch3SourceMid());
        assertEquals(127, program.getPatch3SourceMax());
        assertEquals(3, program.getPatch3DestinationEffect());
        assertEquals(6, program.getPatch3DestinationParameter());
        assertEquals(1, program.getPatch3DestinationMin());
        assertEquals(128, program.getPatch3DestinationMid());
        assertEquals(15, program.getPatch3DestinationMax());
        assertEquals(16, program.getPatch4Source()); // TODO why is the source 16 (0x10) not 3 (0x03)?
        assertEquals(0, program.getPatch4SourceMin());
        assertEquals(255, program.getPatch4SourceMid());
        assertEquals(127, program.getPatch4SourceMax());
        assertEquals(3, program.getPatch4DestinationEffect());
        assertEquals(7, program.getPatch4DestinationParameter());
        assertEquals(1, program.getPatch4DestinationMin());
        assertEquals(128, program.getPatch4DestinationMid());
        assertEquals(4, program.getPatch4DestinationMax());
        assertEquals(157, program.getPatch5Source()); // TODO why is the source 157 (0x9d) not 21 (0x15)?
        assertEquals(0, program.getPatch5SourceMin());
        assertEquals(255, program.getPatch5SourceMid());
        assertEquals(127, program.getPatch5SourceMax());
        assertEquals(16, program.getPatch5DestinationEffect());
        assertEquals(0, program.getPatch5DestinationParameter());
        assertEquals(0, program.getPatch5DestinationMin());
        assertEquals(128, program.getPatch5DestinationMid());
        assertEquals(6, program.getPatch5DestinationMax());

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

        assertEquals(1, program.getNoiseGateEnable());
        assertEquals(1, program.getNoiseGateSend());
        assertEquals(-83, program.getNoiseGateThreshold());
        assertEquals(-85, program.getNoiseGateAttenuation());
        assertEquals(-3, program.getNoiseGateOffset());
        assertEquals(0, program.getNoiseGateATime());
        assertEquals(100, program.getNoiseGateHTime());
        assertEquals(100, program.getNoiseGateRTime());
        assertEquals(0, program.getNoiseGateDelay());

        assertEquals(0, program.getBypassState());

        assertEquals(0, program.getSpeakerSimulatorEnable());
        assertEquals(1, program.getSpeakerSimulatorCabinet());

        assertEquals(0, program.getSendLevel());
        assertEquals(0, program.getSendBypassLevel());
        assertEquals(100, program.getPostMix());
        assertEquals(0, program.getPostLevel());
        assertEquals(0, program.getPostBypassLevel());
    }

    /**
     * Test parsing the various noise gate values.
     */
    @Test
    public void testParseNoiseGate() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("noisegate.syx").toURI());
        Program program = SysexParser.parseProgram(preset);

        assertEquals(2, program.getNoiseGateEnable());
        assertEquals(1, program.getNoiseGateSend());
        assertEquals(-31, program.getNoiseGateThreshold());
        assertEquals(-7, program.getNoiseGateAttenuation());
        assertEquals(-11, program.getNoiseGateOffset());
        assertEquals(1999, program.getNoiseGateATime());
        assertEquals(499, program.getNoiseGateHTime());
        assertEquals(2000, program.getNoiseGateRTime());
        assertEquals(10, program.getNoiseGateDelay());
    }
}
