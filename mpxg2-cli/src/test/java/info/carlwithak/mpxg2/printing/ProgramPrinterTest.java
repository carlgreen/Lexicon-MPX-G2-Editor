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

package info.carlwithak.mpxg2.printing;

import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.sysex.SysexParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for ProgramPrinter.
 *
 * @author carl
 */
public class ProgramPrinterTest {

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintG2Blue() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("001_G2_Blue.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("001_G2_Blue.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintGuitarSolo() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("002_Guitar_Solo.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("002_Guitar_Solo.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintCordovox() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("003_Cordovox.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("003_Cordovox.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintPowerChords() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("004_Power_Chords.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("004_Power_Chords.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintVybeFlange() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("005_Vybe_Flange.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("005_Vybe_Flange.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintAnotherBrick() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("006_AnotherBrick.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("006_AnotherBrick.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintEnvFilterLP() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("007_EnvFilter_LP.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("007_EnvFilter_LP.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintTremoWah() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("008_TremoWah.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("008_TremoWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintJamMan() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("009_JamMan.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("009_JamMan.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintVHRig() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("010_VH_Rig.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("010_VH_Rig.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintRotaryCab() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("011_Rotary_Cab.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("011_Rotary_Cab.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintLittleWing() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("012_Little_Wing.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("012_Little_Wing.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintTechnoChords() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("013_TechnoChords.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("013_TechnoChords.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintPedalSwell() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("014_Pedal_Swell.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("014_Pedal_Swell.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintSlideComp() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("015_Slide_Comp.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("015_Slide_Comp.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintKissTheSky() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("016_Kiss_the_Sky.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("016_Kiss_the_Sky.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintCWah() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("064_C-Wah.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("064_C-Wah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintVWah() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource("074_V-Wah.txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource("074_V-Wah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    private static String readFile(final File file) throws FileNotFoundException {
        return new Scanner(file).useDelimiter("\\Z").next();
    }

    @Test
    public void testBeatValueToString() {
        assertEquals("eighth", ProgramPrinter.beatValueToString(0));
        assertEquals("dotted quarter", ProgramPrinter.beatValueToString(3));
        assertEquals("2 beats", ProgramPrinter.beatValueToString(4));
        assertEquals("16 beats", ProgramPrinter.beatValueToString(18));
        assertEquals("126 beats", ProgramPrinter.beatValueToString(128));
    }

    @Test
    public void testSpeakerSimulatorCabinetToString() {
        assertEquals("Combo1Brite", ProgramPrinter.speakerSimulatorCabinetToString(0));
        assertEquals("Combo1Norml", ProgramPrinter.speakerSimulatorCabinetToString(1));
        assertEquals("Combo1Dark", ProgramPrinter.speakerSimulatorCabinetToString(3));
        assertEquals("Stack2Warm", ProgramPrinter.speakerSimulatorCabinetToString(14));
    }
}
