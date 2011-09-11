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

        assertEquals(17, program.getEffect1Algorithm());
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
    }
}
