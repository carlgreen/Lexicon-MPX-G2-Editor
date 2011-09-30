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
        Program program = SysexParser.parseProgram(preset);
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
        Program program = SysexParser.parseProgram(preset);
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
        Program program = SysexParser.parseProgram(preset);
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
        Program program = SysexParser.parseProgram(preset);
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
        Program program = SysexParser.parseProgram(preset);
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
        Program program = SysexParser.parseProgram(preset);
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
        Program program = SysexParser.parseProgram(preset);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    private static String readFile(final File file) throws FileNotFoundException {
        return new Scanner(file).useDelimiter("\\Z").next();
    }
}

