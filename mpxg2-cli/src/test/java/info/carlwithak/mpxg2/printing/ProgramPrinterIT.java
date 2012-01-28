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
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
@RunWith(Parameterized.class)
public class ProgramPrinterIT {
    private final String filename;

    public ProgramPrinterIT(final String filename) {
        this.filename = filename;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new String[][] {
            { "001_G2_Blue" },
            { "002_Guitar_Solo" },
            { "003_Cordovox" },
            { "004_Power_Chords" },
            { "005_Vybe_Flange" },
            { "006_AnotherBrick" },
            { "007_EnvFilter_LP" },
            { "008_TremoWah" },
            { "009_JamMan" },
            { "010_VH_Rig" },
            { "011_Rotary_Cab" },
            { "012_Little_Wing" },
            { "013_TechnoChords" },
            { "014_Pedal_Swell" },
            { "015_Slide_Comp" },
            { "016_Kiss_the_Sky" },
            { "017_Unchained" },
            { "018_Stomp!" },
            { "019_OctaWah" },
            { "020_Wah_&_Uni" },
            { "021_ToeWah_Flng" },
            { "022_ToeWah_Phas" },
            { "023_ToeWah_Chrs" },
            { "024_ToeWah_Aero" },
            { "025_ToeWah_Uni" },
            { "026_Wah_&_Flange" },
            { "027_Wah_&_Phaser" },
            { "028_Wah_&_Chorus" },
            { "029_Wah_&_Aero" },
            { "030_ChrsDlyRvb+" },
            { "031_TS_Chorus+" },
            { "032_TS_Delay+" },
            { "033_TS_ChrsDly+" },
            { "034_TS_Reverb+" },
            { "035_TS_ChrsRvb+" },
            { "036_CompChorus+" },
            { "037_CompDelay+" },
            { "038_CompChrsDly+" },
            { "039_CompChrsRvb+" },
            { "040_PitchCascade" },
            { "041_Pdl_Octaves" },
            { "042_Pdl_2nds" },
            { "043_Pdl_2-3_b3-3" },
            { "044_Pdl_2-3_3-4" },
            { "045_Pdl_4-5_5-6" },
            { "046_Octaves" },
            { "047_4ths_&_5ths" },
            { "048_E_Maj_Min_3" },
            { "049_E_Dor_Mix_3" },
            { "050_Detune+Trem" },
            { "051_Square_Trem" },
            { "052_Trem_AutoWah" },
            { "053_Env_Trem" },
            { "054_Env_AutoWahs" },
            { "055_Chaos_Dance" },
            { "056_Round_Trem" },
            { "057_Tap_AutoWah" },
            { "058_Verbolo" },
            { "059_DynaChrsTrem" },
            { "060_Univybe" },
            { "061_Octave_Fuzz" },
            { "062_Phaser" },
            { "063_EnvFilter" },
            { "064_C-Wah" },
            { "065_Blue_Comp" },
            { "066_Vintage_Trem" },
            { "067_IPS_TapeSlap" },
            { "068_Space_Echo" },
            { "069_Octabuzz" },
            { "070_OrangePhase" },
            { "071_Gray_Flange" },
            { "072_Red_Comp" },
            { "073_S_H_Pedal" },
            { "074_V-Wah" },
            { "075_Modern_Trem" },
            { "076_Tap_Echo" },
            { "077_Env_Wah" },
            { "078_StereoChorus" },
            { "079_ClasscDetune" },
            { "080_Tone_Boost" },
            { "081_Crunch_Boost" },
            { "082_TS_Lead" },
            { "083_TS_Boost" },
            { "084_OD_Lead" },
            { "085_OD_Boost" },
            { "086_Dist_Lead" },
            { "087_Dist_Boost" },
            { "088_Fuzz_1" },
            { "089_Fuzz_2" },
            { "090_Jam_Chrs+" },
            { "091_Jam_1__Uni+" },
            { "092_Jam_1_S&H+" },
            { "093_Jam_1_Env+" },
            { "094_Jam1Cordovox" },
            { "095_Jam_2_Flange" },
            { "096_Jam_2_Phase" },
            { "097_Jam_2_Pitch+" },
            { "098_Jam_2_Trem" },
            { "099_Jam2AutoWah" },
            { "100_VintageRig" },
            { "101_Pdl_Octaves" },
            { "102_TechnoChords" },
            { "103_Cordovox" },
            { "104_Analog__Echo" },
            { "105_Wah_&_Uni" },
            { "106_EnvFilter_LP" },
            { "107_InfiniteEcho" },
            { "108_Fuzz_Wah" },
            { "109_JamMan" },
            { "110_ToneBoost" },
            { "111_CrunchBoost" },
            { "112_TSLead" },
            { "113_TSBoost" },
            { "114_ODLead" },
            { "115_ODBoost" },
            { "116_DistLead" },
            { "117_DistBoost" },
            { "118_Fuzz1" },
            { "119_Fuzz2" },
            { "120_Univybe" },
            { "121_OctaveFuzz" },
            { "122_Phaser" },
            { "123_EnvFilter" },
            { "124_C-Wah" },
            { "125_BlueComp" },
            { "126_VintageTrem" },
            { "127_IPSTapeSlap" },
            { "128_SpaceEcho" },
            { "129_Octabuzz" },
            { "130_OrangePhase" },
            { "131_GrayFlange" },
            { "132_RedComp" },
            { "133_SHPedal" },
            { "134_V-Wah" },
            { "135_ModernTrem" },
            { "136_TapEcho" },
            { "137_EnvWah" },
            { "138_StereoChorus" },
            { "139_ClasscDetune" },
            { "140_BassComp1" },
            { "141_BassCompChrs" },
            { "142_BassFuzz" },
            { "143_BassPitchPdl" },
            { "144_BootsyBass" },
            { "145_Jam_1_S_H+" },
            { "146_Jam1Cordovox" },
            { "147_Jam_1__Uni+" },
            { "148_Jam_2_Pitch+" },
            { "149_Jam2_Flange+" },
            { "150_Big_Blue" },
            { "151_Blues_Club" },
            { "152_Acoustifier" },
            { "153_BritishStack" },
            { "154_Pedal_Swell" },
            { "155_Clean_Jimi" },
            { "156_Metal_Stack" },
            { "157_Pdl_Octaves" },
            { "158_GuitarSolo" },
            { "159_JamMan" },
            { "160_Jimmy_P___" },
            { "161_Satch___" },
            { "162_Kiss_the_Sky" },
            { "163_Angus___" },
            { "164_The_Edge___" },
            { "165_Sandman" },
            { "166_Brian_M___" },
            { "167_Blow_By___" },
            { "168_Old_Eddie" },
            { "169_New_Eddie" },
            { "170_Live_Jimi" },
            { "171_Cliffs_of___" },
            { "172_Cold_Shot" },
            { "173_Carlos_S___" },
            { "174_Jazzman" },
            { "175_Boston___" },
            { "176_Purple_Reign" },
            { "177_AnotherBrick" },
            { "178_China_Grove" },
            { "179_Tush" },
            { "180_AmericanClean" },
            { "181_AmericanOD" },
            { "182_AmericanGain" },
            { "183_Roadhouse" },
            { "184_Taxmania" },
            { "185_British_60s" },
            { "186_British_70s" },
            { "187_British_80s" },
            { "188_AmericanMod" },
            { "189_ModernHiGain" },
            { "190_TransChorus1" },
            { "191_TransChorus2" },
            { "192_Jazz_Bright" },
            { "193_Jazz_Dark" },
            { "194_Acoustic" },
            { "195_Little_Amp" },
            { "196_Phone_Filter" },
            { "197_Vibro_Cab" },
            { "198_Cordovox" },
            { "199_Rotary_Cab" },
            { "200_TrackingRoom" },
            { "201_Acoustic_Room" },
            { "202_Jazz_Club" },
            { "203_Solo_Room" },
            { "204_RhythmRoom_L" },
            { "205_RhythmRoom_R" },
            { "206_MicPlacement" },
            { "207_Tape_Plate" },
            { "208_PCM_60_Room" },
            { "209_Gated_Verb" },
            { "210_Classic_Detune" },
            { "211_Comp+Chrs" },
            { "212_Stereo_Phaser" },
            { "213_Env_AutoPan" },
            { "214_Env_AutoWahs" },
            { "215_EnvFilter_LP" },
            { "216_Dual_Delay" },
            { "217_EQ_Delay" },
            { "218_Analog_Echo" },
            { "219_InfiniteEcho" },
            { "220_Surfs_Up" },
            { "221_Slide_Comp" },
            { "222_Funk+FX" },
            { "223_Ballad_Lead" },
            { "224_De_DaDaDa" },
            { "225_Rockabilly" },
            { "226_Country_Rock" },
            { "227_Ultra_Clean" },
            { "228_Acoustic_FX1" },
            { "229_TechnoChords" },
            { "230_Modern_AB" },
            { "231_British_AB" },
            { "232_American_AB" },
            { "233_Detune_Trem" },
            { "234_DualAutoWahs" },
            { "235_TremoWah" },
            { "236_Pitch_Cascade" },
            { "237_Octaves" },
            { "238_Pdl_2nds" },
            { "239_EMajMin3" },
            { "240_BassComp1" },
            { "241_BassCompChrs" },
            { "242_Bass_Fuzz" },
            { "243_BassPitchPdl" },
            { "244_BootsyBass" },
            { "245_Jam_1_SH+" },
            { "246_Jam1Cordovox" },
            { "247_Jam_2_Pitch+" },
            { "248_Jam2AutoWah" },
            { "249_Unity_Gain" },
            { "250_Clean_Slate" }
        });
    }

    @Test
    public void testParseAndPrint() throws Exception {
        File expectedFile = new File(this.getClass().getClassLoader().getResource(filename + ".txt").toURI());
        String expected = readFile(expectedFile);
        File preset = new File(this.getClass().getClassLoader().getResource(filename + ".syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);
        assertThat(ProgramPrinter.print(program), is(expected));
    }

    private static String readFile(final File file) throws FileNotFoundException {
        final Scanner scanner = new Scanner(file).useDelimiter("\\Z");
        return scanner.hasNext() ? scanner.next() : null;
    }
}
