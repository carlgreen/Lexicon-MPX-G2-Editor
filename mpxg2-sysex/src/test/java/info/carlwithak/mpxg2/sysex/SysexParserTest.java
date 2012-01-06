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

import info.carlwithak.mpxg2.model.Ab;
import info.carlwithak.mpxg2.model.EnvelopeGenerator;
import info.carlwithak.mpxg2.model.Knob;
import info.carlwithak.mpxg2.model.Lfo;
import info.carlwithak.mpxg2.model.NoiseGate;
import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.model.Random;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsBeat.beat;
import static info.carlwithak.mpxg2.test.IsFrequency.frequency;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
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
    public void testReadEffectTypes() {
        Program program = new Program();
        SysexParser.readEffectTypes(program, 0);

        assertFalse(program.isChorus());
        SysexParser.readEffectTypes(program, 1);
        assertTrue(program.isChorus());

        assertFalse(program.isDelay());
        SysexParser.readEffectTypes(program, 2);
        assertTrue(program.isDelay());

        assertFalse(program.isDistortion());
        SysexParser.readEffectTypes(program, 4);
        assertTrue(program.isDistortion());

        assertFalse(program.isEq());
        SysexParser.readEffectTypes(program, 8);
        assertTrue(program.isEq());

        assertFalse(program.isFlanger());
        SysexParser.readEffectTypes(program, 16);
        assertTrue(program.isFlanger());

        assertFalse(program.isGain());
        SysexParser.readEffectTypes(program, 32);
        assertTrue(program.isGain());

        assertFalse(program.isMod());
        SysexParser.readEffectTypes(program, 64);
        assertTrue(program.isMod());

        assertFalse(program.isOverdrive());
        SysexParser.readEffectTypes(program, 128);
        assertTrue(program.isOverdrive());

        assertFalse(program.isPhaser());
        SysexParser.readEffectTypes(program, 256);
        assertTrue(program.isPhaser());

        assertFalse(program.isPitch());
        SysexParser.readEffectTypes(program, 512);
        assertTrue(program.isPitch());

        assertFalse(program.isReverb());
        SysexParser.readEffectTypes(program, 1024);
        assertTrue(program.isReverb());

        assertFalse(program.isSpeakerSim());
        SysexParser.readEffectTypes(program, 2048);
        assertTrue(program.isSpeakerSim());

        assertFalse(program.isWah());
        SysexParser.readEffectTypes(program, 4096);
        assertTrue(program.isWah());

        assertFalse(program.isPrePost());
        SysexParser.readEffectTypes(program, 8192);
        assertTrue(program.isPrePost());

        assertFalse(program.isStandAlone());
        SysexParser.readEffectTypes(program, 16384);
        assertTrue(program.isStandAlone());

        assertFalse(program.isInline());
        SysexParser.readEffectTypes(program, 32768);
        assertTrue(program.isInline());
    }

    @Test
    public void testReadGuitarStyles() {
        Program program = new Program();

        SysexParser.readGuitarStyles(program, 0);
        assertFalse(program.isAcoustic());

        SysexParser.readGuitarStyles(program, 1);
        assertFalse(program.isAcoustic());

        SysexParser.readGuitarStyles(program, 2);
        assertTrue(program.isAcoustic());

        assertFalse(program.isBass());
        SysexParser.readGuitarStyles(program, 4);
        assertTrue(program.isBass());

        assertFalse(program.isBlues());
        SysexParser.readGuitarStyles(program, 8);
        assertTrue(program.isBlues());

        assertFalse(program.isClean());
        SysexParser.readGuitarStyles(program, 16);
        assertTrue(program.isClean());

        assertFalse(program.isCountry());
        SysexParser.readGuitarStyles(program, 32);
        assertTrue(program.isCountry());

        assertFalse(program.isJazz());
        SysexParser.readGuitarStyles(program, 64);
        assertTrue(program.isJazz());

        assertFalse(program.isRock());
        SysexParser.readGuitarStyles(program, 128);
        assertTrue(program.isRock());
    }

    @Test
    public void testReadEffectsStatus() {
        Program program = new Program();
        SysexParser.readEffectsStatus(program, 0);

        assertFalse(program.isEffect1On());
        SysexParser.readEffectsStatus(program, 1);
        assertTrue(program.isEffect1On());

        assertFalse(program.isEffect2On());
        SysexParser.readEffectsStatus(program, 2);
        assertTrue(program.isEffect2On());

        assertFalse(program.isChorusOn());
        SysexParser.readEffectsStatus(program, 4);
        assertTrue(program.isChorusOn());

        assertFalse(program.isDelayOn());
        SysexParser.readEffectsStatus(program, 8);
        assertTrue(program.isDelayOn());

        assertFalse(program.isReverbOn());
        SysexParser.readEffectsStatus(program, 16);
        assertTrue(program.isReverbOn());

        assertFalse(program.isEqOn());
        SysexParser.readEffectsStatus(program, 32);
        assertTrue(program.isEqOn());

        assertFalse(program.isGainOn());
        SysexParser.readEffectsStatus(program, 64);
        assertTrue(program.isGainOn());

        assertFalse(program.isInsertOn());
        SysexParser.readEffectsStatus(program, 128);
        assertTrue(program.isInsertOn());
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

    @Test
    public void testReadKnob() {
        byte[] bytes = {2, 3, 0, 0, 4, 6, 4, 4, 5, 6, 12, 6, 1, 6, 9, 7, 0, 2, 1, 4, 4, 6, 10, 6};
        Knob knob = SysexParser.readKnob(bytes);

        assertThat(knob.getValue(), is(value(50)));
        assertThat(knob.getLow(), is(value(0)));
        assertThat(knob.getHigh(), is(value(100)));
        assertEquals("Delay Adj", knob.getName());
    }

    @Test
    public void testReadLfo() throws Exception {
        byte[] bytes = {1, 0, 12, 3, 0, 0, 0, 0, 2, 3, 0, 0, 4, 6, 0, 4, 0, 0};
        Lfo lfo = SysexParser.readLfo(bytes);

        assertThat(lfo.getMode(), is(value(1)));
        assertThat(lfo.getRate(), is(frequency(0.60)));
        assertThat(lfo.getPulseWidth(), is(value(50)));
        assertThat(lfo.getPhase(), is(value(0)));
        assertThat(lfo.getDepth(), is(value(100)));
        assertThat(lfo.getOnLevel(), is(value(64)));
        assertThat(lfo.getOnSource(), is(value(0)));
    }

    @Test
    public void testReadRandom() throws ParseException {
        byte[] bytes = {0, 0, 2, 3, 3, 0, 1, 0, 1, 0};

        Random random = SysexParser.readRandom(bytes);
        assertThat(random.getLow(), is(value(0)));
        assertThat(random.getHigh(), is(value(50)));
        assertThat(random.getRate(), is(beat(3, 1)));
    }

    @Test
    public void testReadAb() {
        byte[] bytes = {0, 0, 4, 6, 4, 6, 0, 4, 0, 0};

        Ab ab = SysexParser.readAb(bytes);
        assertThat(ab.getMode(), is(value(0)));
        assertThat(ab.getARate(), is(value(100)));
        assertThat(ab.getBRate(), is(value(100)));
        assertThat(ab.getOnLevel(), is(value(64)));
        assertThat(ab.getOnSource(), is(value(0)));
    }

    @Test
    public void testReadEnvelopeGenerator() {
        byte[] bytes = {0, 0, 0, 0, 4, 6, 0, 4};

        EnvelopeGenerator envelopeGenerator = SysexParser.readEnvelopeGenerator(bytes);
        assertEquals(0, envelopeGenerator.getSrc1());
        assertEquals(0, envelopeGenerator.getSrc2());
        assertEquals(100, envelopeGenerator.getATrim());
        assertEquals(64, envelopeGenerator.getResponse());
    }
}
