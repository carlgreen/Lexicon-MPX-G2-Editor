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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
