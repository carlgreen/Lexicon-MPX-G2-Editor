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
 *
 * @author Carl Green
 */
public class ProgramPrinterIT {

    @Test
    public void testPrintG2Blue() throws Exception {
        testParseAndPrint("001_G2_Blue");
    }

    @Test
    public void testPrintGuitarSolo() throws Exception {
        testParseAndPrint("002_Guitar_Solo");
    }

    @Test
    public void testPrintCordovox() throws Exception {
        testParseAndPrint("003_Cordovox");
    }

    @Test
    public void testPrintPowerChords() throws Exception {
        testParseAndPrint("004_Power_Chords");
    }

    @Test
    public void testPrintVybeFlange() throws Exception {
        testParseAndPrint("005_Vybe_Flange");
    }

    @Test
    public void testPrintAnotherBrick() throws Exception {
        testParseAndPrint("006_AnotherBrick");
    }

    @Test
    public void testPrintEnvFilterLP() throws Exception {
        testParseAndPrint("007_EnvFilter_LP");
    }

    @Test
    public void testPrintTremoWah() throws Exception {
        testParseAndPrint("008_TremoWah");
    }

    @Test
    public void testPrintJamMan() throws Exception {
        testParseAndPrint("009_JamMan");
    }

    @Test
    public void testPrintVHRig() throws Exception {
        testParseAndPrint("010_VH_Rig");
    }

    @Test
    public void testPrintRotaryCab() throws Exception {
        testParseAndPrint("011_Rotary_Cab");
    }

    @Test
    public void testPrintLittleWing() throws Exception {
        testParseAndPrint("012_Little_Wing");
    }

    @Test
    public void testPrintTechnoChords() throws Exception {
        testParseAndPrint("013_TechnoChords");
    }

    @Test
    public void testPrintPedalSwell() throws Exception {
        testParseAndPrint("014_Pedal_Swell");
    }

    @Test
    public void testPrintSlideComp() throws Exception {
        testParseAndPrint("015_Slide_Comp");
    }

    @Test
    public void testPrintKissTheSky() throws Exception {
        testParseAndPrint("016_Kiss_the_Sky");
    }

    @Test
    public void testPrintUnchained() throws Exception {
        testParseAndPrint("017_Unchained");
    }

    @Test
    public void testPrintStomp() throws Exception {
        testParseAndPrint("018_Stomp!");
    }

    @Test
    public void testPrintOctaWah() throws Exception {
        testParseAndPrint("019_OctaWah");
    }

    @Test
    public void testPrintWahUni() throws Exception {
        testParseAndPrint("020_Wah_&_Uni");
    }

    @Test
    public void testPrintToeWahFlng() throws Exception {
        testParseAndPrint("021_ToeWah_Flng");
    }

    @Test
    public void testPrintToeWahPhas() throws Exception {
        testParseAndPrint("022_ToeWah_Phas");
    }

    @Test
    public void testPrintToeWahChrs() throws Exception {
        testParseAndPrint("023_ToeWah_Chrs");
    }

    @Test
    public void testPrintToeWahAero() throws Exception {
        testParseAndPrint("024_ToeWah_Aero");
    }

    @Test
    public void testPrintToeWahUni() throws Exception {
        testParseAndPrint("025_ToeWah_Uni");
    }

    @Test
    public void testPrintWahFlange() throws Exception {
        testParseAndPrint("026_Wah_&_Flange");
    }

    @Test
    public void testPrintWahPhaser() throws Exception {
        testParseAndPrint("027_Wah_&_Phaser");
    }

    @Test
    public void testPrintWahChorus() throws Exception {
        testParseAndPrint("028_Wah_&_Chorus");
    }

    @Test
    public void testPrintWahAero() throws Exception {
        testParseAndPrint("029_Wah_&_Aero");
    }

    @Test
    public void testPrintChrsDlyRvb() throws Exception {
        testParseAndPrint("030_ChrsDlyRvb+");
    }

    @Test
    public void testPrintTSChorus() throws Exception {
        testParseAndPrint("031_TS_Chorus+");
    }

    @Test
    public void testPrintTSDelay() throws Exception {
        testParseAndPrint("032_TS_Delay+");
    }

    @Test
    public void testPrintTSChrsDly() throws Exception {
        testParseAndPrint("033_TS_ChrsDly+");
    }

    @Test
    public void testPrintTSReverb() throws Exception {
        testParseAndPrint("034_TS_Reverb+");
    }

    @Test
    public void testPrintTSChrsRVB() throws Exception {
        testParseAndPrint("035_TS_ChrsRvb+");
    }

    @Test
    public void testPrintCompChorus() throws Exception {
        testParseAndPrint("036_CompChorus+");
    }

    @Test
    public void testPrintCompDelay() throws Exception {
        testParseAndPrint("037_CompDelay+");
    }

    @Test
    public void testPrintCompChrsDly() throws Exception {
        testParseAndPrint("038_CompChrsDly+");
    }

    @Test
    public void testPrintCompChrsRvb() throws Exception {
        testParseAndPrint("039_CompChrsRvb+");
    }

    @Test
    public void testPrintPitchCascade() throws Exception {
        testParseAndPrint("040_PitchCascade");
    }

    @Test
    public void testPrintPdlOctaves() throws Exception {
        testParseAndPrint("041_Pdl_Octaves");
    }

    @Test
    public void testPrintPdl2nds() throws Exception {
        testParseAndPrint("042_Pdl_2nds");
    }

    @Test
    public void testPrintPdl23_b33() throws Exception {
        testParseAndPrint("043_Pdl_2-3_b3-3");
    }

    @Test
    public void testPrintPdl23_34() throws Exception {
        testParseAndPrint("044_Pdl_2-3_3-4");
    }

    @Test
    public void testPrintPdl45_56() throws Exception {
        testParseAndPrint("045_Pdl_4-5_5-6");
    }

    @Test
    public void testPrintOctaves() throws Exception {
        testParseAndPrint("046_Octaves");
    }

    @Test
    public void testPrint4ths5ths() throws Exception {
        testParseAndPrint("047_4ths_&_5ths");
    }

    @Test
    public void testPrintEMajMin3() throws Exception {
        testParseAndPrint("048_E_Maj_Min_3");
    }

    @Test
    public void testPrintEDorMix3() throws Exception {
        testParseAndPrint("049_E_Dor_Mix_3");
    }

    @Test
    public void testPrintCWah() throws Exception {
        testParseAndPrint("064_C-Wah");
    }

    @Test
    public void testPrintVWah() throws Exception {
        testParseAndPrint("074_V-Wah");
    }

    private void testParseAndPrint(String filename) throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource(filename + ".txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource(filename + ".syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

    private static String readFile(final File file) throws FileNotFoundException {
        return new Scanner(file).useDelimiter("\\Z").next();
    }
}
