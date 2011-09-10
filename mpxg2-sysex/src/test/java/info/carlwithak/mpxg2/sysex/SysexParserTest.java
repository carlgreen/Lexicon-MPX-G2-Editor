package info.carlwithak.mpxg2.sysex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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

        assertEquals("Clean Slate", program.getProgramName());
    }
}
