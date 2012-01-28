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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    public void testPrintDetuneTrem() throws Exception {
        testParseAndPrint("050_Detune+Trem");
    }

    @Test
    public void testPrintSquareTrem() throws Exception {
        testParseAndPrint("051_Square_Trem");
    }

    @Test
    public void testPrintTremAutoWah() throws Exception {
        testParseAndPrint("052_Trem_AutoWah");
    }

    @Test
    public void testPrintEnvTrem() throws Exception {
        testParseAndPrint("053_Env_Trem");
    }

    @Test
    public void testPrintEnvAutoWahs() throws Exception {
        testParseAndPrint("054_Env_AutoWahs");
    }

    @Test
    public void testPrintChaosDance() throws Exception {
        testParseAndPrint("055_Chaos_Dance");
    }

    @Test
    public void testPrintRoundTrem() throws Exception {
        testParseAndPrint("056_Round_Trem");
    }

    @Test
    public void testPrintTapAutoWah() throws Exception {
        testParseAndPrint("057_Tap_AutoWah");
    }

    @Test
    public void testPrintVerbolo() throws Exception {
        testParseAndPrint("058_Verbolo");
    }

    @Test
    public void testPrintDynaChrsTrem() throws Exception {
        testParseAndPrint("059_DynaChrsTrem");
    }

    @Test
    public void testPrintUnivybe() throws Exception {
        testParseAndPrint("060_Univybe");
    }

    @Test
    public void testPrintOctaveFuzz() throws Exception {
        testParseAndPrint("061_Octave_Fuzz");
    }

    @Test
    public void testPrintPhaser() throws Exception {
        testParseAndPrint("062_Phaser");
    }

    @Test
    public void testPrintEnvFilter() throws Exception {
        testParseAndPrint("063_EnvFilter");
    }

    @Test
    public void testPrintCWah() throws Exception {
        testParseAndPrint("064_C-Wah");
    }

    @Test
    public void testPrintBlueComp() throws Exception {
        testParseAndPrint("065_Blue_Comp");
    }

    @Test
    public void testPrintVintageTrem() throws Exception {
        testParseAndPrint("066_Vintage_Trem");
    }

    @Test
    public void testPrintIPSTapeSlap() throws Exception {
        testParseAndPrint("067_IPS_TapeSlap");
    }

    @Test
    public void testPrintSpaceEcho() throws Exception {
        testParseAndPrint("068_Space_Echo");
    }

    @Test
    public void testPrintOctabuzz() throws Exception {
        testParseAndPrint("069_Octabuzz");
    }

    @Test
    public void testPrintOrangePhase() throws Exception {
        testParseAndPrint("070_OrangePhase");
    }

    @Test
    public void testPrintGrayFlange() throws Exception {
        testParseAndPrint("071_Gray_Flange");
    }

    @Test
    public void testPrintRedComp() throws Exception {
        testParseAndPrint("072_Red_Comp");
    }

    @Test
    public void testPrintSHPedal() throws Exception {
        testParseAndPrint("073_S_H_Pedal");
    }

    @Test
    public void testPrintVWah() throws Exception {
        testParseAndPrint("074_V-Wah");
    }

    @Test
    public void testPrintModernTrem() throws Exception {
        testParseAndPrint("075_Modern_Trem");
    }

    @Test
    public void testPrintTapEcho() throws Exception {
        testParseAndPrint("076_Tap_Echo");
    }

    @Test
    public void testPrintEnvWah() throws Exception {
        testParseAndPrint("077_Env_Wah");
    }

    @Test
    public void testPrintStereoChorus() throws Exception {
        testParseAndPrint("078_StereoChorus");
    }

    @Test
    public void testPrintClasscDetune() throws Exception {
        testParseAndPrint("079_ClasscDetune");
    }

    @Test
    public void testPrintToneBoost() throws Exception {
        testParseAndPrint("080_Tone_Boost");
    }

    @Test
    public void testPrintCrunchBoost() throws Exception {
        testParseAndPrint("081_Crunch_Boost");
    }

    @Test
    public void testPrintTSLead() throws Exception {
        testParseAndPrint("082_TS_Lead");
    }

    @Test
    public void testPrintTSBoost() throws Exception {
        testParseAndPrint("083_TS_Boost");
    }

    @Test
    public void testPrintODLead() throws Exception {
        testParseAndPrint("084_OD_Lead");
    }

    @Test
    public void testPrintODBoost() throws Exception {
        testParseAndPrint("085_OD_Boost");
    }

    @Test
    public void testPrintDistLead() throws Exception {
        testParseAndPrint("086_Dist_Lead");
    }

    @Test
    public void testPrintDistBoost() throws Exception {
        testParseAndPrint("087_Dist_Boost");
    }

    @Test
    public void testPrintFuzz1() throws Exception {
        testParseAndPrint("088_Fuzz_1");
    }

    @Test
    public void testPrintFuzz2() throws Exception {
        testParseAndPrint("089_Fuzz_2");
    }

    @Test
    public void testPrintJamChrs() throws Exception {
        testParseAndPrint("090_Jam_Chrs+");
    }

    @Test
    public void testPrintJam1Uni() throws Exception {
        testParseAndPrint("091_Jam_1__Uni+");
    }

    @Test
    public void testPrintJam1SH() throws Exception {
        testParseAndPrint("092_Jam_1_S&H+");
    }

    @Test
    public void testPrintJam1Env() throws Exception {
        testParseAndPrint("093_Jam_1_Env+");
    }

    @Test
    public void testPrintJam1Cordovox() throws Exception {
        testParseAndPrint("094_Jam1Cordovox");
    }

    @Test
    public void testPrintJam2Flang() throws Exception {
        testParseAndPrint("095_Jam_2_Flange");
    }

    @Test
    public void testPrintJam2Phase() throws Exception {
        testParseAndPrint("096_Jam_2_Phase");
    }

    @Test
    public void testPrintJam2Pitch() throws Exception {
        testParseAndPrint("097_Jam_2_Pitch+");
    }

    @Test
    public void testPrintJam2Trem() throws Exception {
        testParseAndPrint("098_Jam_2_Trem");
    }

    @Test
    public void testPrintJam2AutoWah() throws Exception {
        testParseAndPrint("099_Jam2AutoWah");
    }

    @Test
    public void testPrintVintageRig_InputOnly() throws Exception {
        testParseAndPrint("100_VintageRig");
    }

    @Test
    public void testPrintPdlOctaves_InputOnly() throws Exception {
        testParseAndPrint("101_Pdl_Octaves");
    }

    @Test
    public void testPrintTechnoChords_InputOnly() throws Exception {
        testParseAndPrint("102_TechnoChords");
    }

    @Test
    public void testPrintCordovox_InputOnly() throws Exception {
        testParseAndPrint("103_Cordovox");
    }

    @Test
    public void testPrintAnalogEcho_InputOnly() throws Exception {
        testParseAndPrint("104_Analog__Echo");
    }

    @Test
    public void testPrintWahUni_InputOnly() throws Exception {
        testParseAndPrint("105_Wah_&_Uni");
    }

    @Test
    public void testPrintEnvFilterLP_InputOnly() throws Exception {
        testParseAndPrint("106_EnvFilter_LP");
    }

    @Test
    public void testPrintInfiniteEcho_InputOnly() throws Exception {
        testParseAndPrint("107_InfiniteEcho");
    }

    @Test
    public void testPrintFuzzWah_InputOnly() throws Exception {
        testParseAndPrint("108_Fuzz_Wah");
    }

    @Test
    public void testPrintJamMan_InputOnly() throws Exception {
        testParseAndPrint("109_JamMan");
    }

    @Test
    public void testPrintToneBoost_InputOnly() throws Exception {
        testParseAndPrint("110_ToneBoost");
    }

    @Test
    public void testPrintCrunchBoost_InputOnly() throws Exception {
        testParseAndPrint("111_CrunchBoost");
    }

    @Test
    public void testPrintTSLead_InputOnly() throws Exception {
        testParseAndPrint("112_TSLead");
    }

    @Test
    public void testPrintTSBoost_InputOnly() throws Exception {
        testParseAndPrint("113_TSBoost");
    }

    @Test
    public void testPrintODLead_InputOnly() throws Exception {
        testParseAndPrint("114_ODLead");
    }

    @Test
    public void testPrintODBoost_InputOnly() throws Exception {
        testParseAndPrint("115_ODBoost");
    }

    @Test
    public void testPrintDistLead_InputOnly() throws Exception {
        testParseAndPrint("116_DistLead");
    }

    @Test
    public void testPrintDistBoost_InputOnly() throws Exception {
        testParseAndPrint("117_DistBoost");
    }

    @Test
    public void testPrintFuzz1_InputOnly() throws Exception {
        testParseAndPrint("118_Fuzz1");
    }

    @Test
    public void testPrintFuzz2_InputOnly() throws Exception {
        testParseAndPrint("119_Fuzz2");
    }

    @Test
    public void testPrintUnivybe_InputOnly() throws Exception {
        testParseAndPrint("120_Univybe");
    }

    @Test
    public void testPrintOctaveFuzz_InputOnly() throws Exception {
        testParseAndPrint("121_OctaveFuzz");
    }

    @Test
    public void testPrintPhaser_InputOnly() throws Exception {
        testParseAndPrint("122_Phaser");
    }

    @Test
    public void testPrintEnvFilter_InputOnly() throws Exception {
        testParseAndPrint("123_EnvFilter");
    }

    @Test
    public void testPrintCWah_InputOnly() throws Exception {
        testParseAndPrint("124_C-Wah");
    }

    @Test
    public void testPrintBlueComp_InputOnly() throws Exception {
        testParseAndPrint("125_BlueComp");
    }

    @Test
    public void testPrintVintageTrem_InputOnly() throws Exception {
        testParseAndPrint("126_VintageTrem");
    }

    @Test
    public void testPrintIPSTapeSlap_InputOnly() throws Exception {
        testParseAndPrint("127_IPSTapeSlap");
    }

    @Test
    public void testPrintSpaceEcho_InputOnly() throws Exception {
        testParseAndPrint("128_SpaceEcho");
    }

    @Test
    public void testPrintOctabuzz_InputOnly() throws Exception {
        testParseAndPrint("129_Octabuzz");
    }

    @Test
    public void testPrintOrangePhase_InputOnly() throws Exception {
        testParseAndPrint("130_OrangePhase");
    }

    @Test
    public void testPrintGrayFlange_InputOnly() throws Exception {
        testParseAndPrint("131_GrayFlange");
    }

    @Test
    public void testPrintRedComp_InputOnly() throws Exception {
        testParseAndPrint("132_RedComp");
    }

    @Test
    public void testPrintSHPedal_InputOnly() throws Exception {
        testParseAndPrint("133_SHPedal");
    }

    @Test
    public void testPrintVWah_InputOnly() throws Exception {
        testParseAndPrint("134_V-Wah");
    }

    @Test
    public void testPrintModernTrem_InputOnly() throws Exception {
        testParseAndPrint("135_ModernTrem");
    }

    @Test
    public void testPrintTapEcho_InputOnly() throws Exception {
        testParseAndPrint("136_TapEcho");
    }

    @Test
    public void testPrintEnvWah_InputOnly() throws Exception {
        testParseAndPrint("137_EnvWah");
    }

    @Test
    public void testPrintStereoChorus_InputOnly() throws Exception {
        testParseAndPrint("138_StereoChorus");
    }

    @Test
    public void testPrintClasscDetune_InputOnly() throws Exception {
        testParseAndPrint("139_ClasscDetune");
    }

    @Test
    public void testPrintBassComp1_InputOnly() throws Exception {
        testParseAndPrint("140_BassComp1");
    }

    @Test
    public void testPrintBassCompChrs_InputOnly() throws Exception {
        testParseAndPrint("141_BassCompChrs");
    }

    @Test
    public void testPrintBassFuzz_InputOnly() throws Exception {
        testParseAndPrint("142_BassFuzz");
    }

    @Test
    public void testPrintBassPitchPdl_InputOnly() throws Exception {
        testParseAndPrint("143_BassPitchPdl");
    }

    @Test
    public void testPrintBootsyBass_InputOnly() throws Exception {
        testParseAndPrint("144_BootsyBass");
    }

    @Test
    public void testPrintJam1SH_InputOnly() throws Exception {
        testParseAndPrint("145_Jam_1_S_H+");
    }

    @Test
    public void testPrintJam1Cordovox_InputOnly() throws Exception {
        testParseAndPrint("146_Jam1Cordovox");
    }

    @Test
    public void testPrintJam1Uni_InputOnly() throws Exception {
        testParseAndPrint("147_Jam_1__Uni+");
    }

    @Test
    public void testPrintJam2Pitch_InputOnly() throws Exception {
        testParseAndPrint("148_Jam_2_Pitch+");
    }

    @Test
    public void testPrintJam2Flange_InputOnly() throws Exception {
        testParseAndPrint("149_Jam2_Flange+");
    }

    @Test
    public void testPrintBigBlue_StandAlone() throws Exception {
        testParseAndPrint("150_Big_Blue");
    }

    @Test
    public void testPrintBluesClub_StandAlone() throws Exception {
        testParseAndPrint("151_Blues_Club");
    }

    @Test
    public void testPrintAcoustifier_StandAlone() throws Exception {
        testParseAndPrint("152_Acoustifier");
    }

    @Test
    public void testPrintBritishStack_StandAlone() throws Exception {
        testParseAndPrint("153_BritishStack");
    }

    @Test
    public void testPrintPedalSwell_StandAlone() throws Exception {
        testParseAndPrint("154_Pedal_Swell");
    }

    @Test
    public void testPrintCleanJimi_StandAlone() throws Exception {
        testParseAndPrint("155_Clean_Jimi");
    }

    @Test
    public void testPrintMetalStack_StandAlone() throws Exception {
        testParseAndPrint("156_Metal_Stack");
    }

    @Test
    public void testPrintPdlOctaves_StandAlone() throws Exception {
        testParseAndPrint("157_Pdl_Octaves");
    }

    @Test
    public void testPrintGuitarSolo_StandAlone() throws Exception {
        testParseAndPrint("158_GuitarSolo");
    }

    @Test
    public void testPrintJamMan_StandAlone() throws Exception {
        testParseAndPrint("159_JamMan");
    }

    @Test
    public void testPrintJimmyP_StandAlone() throws Exception {
        testParseAndPrint("160_Jimmy_P___");
    }

    @Test
    public void testPrintSatch_StandAlone() throws Exception {
        testParseAndPrint("161_Satch___");
    }

    @Test
    public void testPrintKissTheSky_StandAlone() throws Exception {
        testParseAndPrint("162_Kiss_the_Sky");
    }

    @Test
    public void testPrintAngus_StandAlone() throws Exception {
        testParseAndPrint("163_Angus___");
    }

    @Test
    public void testPrintTheEdge_StandAlone() throws Exception {
        testParseAndPrint("164_The_Edge___");
    }

    @Test
    public void testPrintSandman_StandAlone() throws Exception {
        testParseAndPrint("165_Sandman");
    }

    @Test
    public void testPrintBrianM_StandAlone() throws Exception {
        testParseAndPrint("166_Brian_M___");
    }

    @Test
    public void testPrintBlowBy_StandAlone() throws Exception {
        testParseAndPrint("167_Blow_By___");
    }

    @Test
    public void testPrintOldEddie_StandAlone() throws Exception {
        testParseAndPrint("168_Old_Eddie");
    }

    @Test
    public void testPrintNewEddie_StandAlone() throws Exception {
        testParseAndPrint("169_New_Eddie");
    }

    @Test
    public void testPrintLiveJimi_StandAlone() throws Exception {
        testParseAndPrint("170_Live_Jimi");
    }

    @Test
    public void testPrintCliffsOf_StandAlone() throws Exception {
        testParseAndPrint("171_Cliffs_of___");
    }

    @Test
    public void testPrintColdShot_StandAlone() throws Exception {
        testParseAndPrint("172_Cold_Shot");
    }

    @Test
    public void testPrintCarlosS_StandAlone() throws Exception {
        testParseAndPrint("173_Carlos_S___");
    }

    @Test
    public void testPrintJazzman_StandAlone() throws Exception {
        testParseAndPrint("174_Jazzman");
    }

    @Test
    public void testPrintBoston_StandAlone() throws Exception {
        testParseAndPrint("175_Boston___");
    }

    @Test
    public void testPrintPurpleReign_StandAlone() throws Exception {
        testParseAndPrint("176_Purple_Reign");
    }

    @Test
    public void testPrintAnotherBrick_StandAlone() throws Exception {
        testParseAndPrint("177_AnotherBrick");
    }

    @Test
    public void testPrintChinaGrove_StandAlone() throws Exception {
        testParseAndPrint("178_China_Grove");
    }

    @Test
    public void testPrintTush_StandAlone() throws Exception {
        testParseAndPrint("179_Tush");
    }

    @Test
    public void testPrintAmericanClean_StandAlone() throws Exception {
        testParseAndPrint("180_AmericanClean");
    }

    @Test
    public void testPrintAmericanOD_StandAlone() throws Exception {
        testParseAndPrint("181_AmericanOD");
    }

    @Test
    public void testPrintAmericanGain_StandAlone() throws Exception {
        testParseAndPrint("182_AmericanGain");
    }

    @Test
    public void testPrintRoadhouse_StandAlone() throws Exception {
        testParseAndPrint("183_Roadhouse");
    }

    @Test
    public void testPrintTaxmania_StandAlone() throws Exception {
        testParseAndPrint("184_Taxmania");
    }

    @Test
    public void testPrintBritish60s_StandAlone() throws Exception {
        testParseAndPrint("185_British_60s");
    }

    @Test
    public void testPrintBritish70s_StandAlone() throws Exception {
        testParseAndPrint("186_British_70s");
    }

    @Test
    public void testPrintBritish80s_StandAlone() throws Exception {
        testParseAndPrint("187_British_80s");
    }

    @Test
    public void testPrintAmericanMod_StandAlone() throws Exception {
        testParseAndPrint("188_AmericanMod");
    }

    @Test
    public void testPrintModernHiGain_StandAlone() throws Exception {
        testParseAndPrint("189_ModernHiGain");
    }

    @Test
    public void testPrintTransChorus1_StandAlone() throws Exception {
        testParseAndPrint("190_TransChorus1");
    }

    @Test
    public void testPrintTransChorus2_StandAlone() throws Exception {
        testParseAndPrint("191_TransChorus2");
    }

    @Test
    public void testPrintJazzBright_StandAlone() throws Exception {
        testParseAndPrint("192_Jazz_Bright");
    }

    @Test
    public void testPrintJazzDark_StandAlone() throws Exception {
        testParseAndPrint("193_Jazz_Dark");
    }

    @Test
    public void testPrintAcoustic_StandAlone() throws Exception {
        testParseAndPrint("194_Acoustic");
    }

    @Test
    public void testPrintLittleAmp_StandAlone() throws Exception {
        testParseAndPrint("195_Little_Amp");
    }

    @Test
    public void testPrintPhoneFilter_StandAlone() throws Exception {
        testParseAndPrint("196_Phone_Filter");
    }

    @Test
    public void testPrintVibroCab_StandAlone() throws Exception {
        testParseAndPrint("197_Vibro_Cab");
    }

    @Test
    public void testPrintCordovox_StandAlone() throws Exception {
        testParseAndPrint("198_Cordovox");
    }

    @Test
    public void testPrintRotaryCab_StandAlone() throws Exception {
        testParseAndPrint("199_Rotary_Cab");
    }

    @Test
    public void testPrintTrackingRoom_StandAlone() throws Exception {
        testParseAndPrint("200_TrackingRoom");
    }

    @Test
    public void testPrintAcousticRoom_StandAlone() throws Exception {
        testParseAndPrint("201_Acoustic_Room");
    }

    @Test
    public void testPrintJazzClub_StandAlone() throws Exception {
        testParseAndPrint("202_Jazz_Club");
    }

    @Test
    public void testPrintSoloRoom_StandAlone() throws Exception {
        testParseAndPrint("203_Solo_Room");
    }

    @Test
    public void testPrintRhythmRoomL_StandAlone() throws Exception {
        testParseAndPrint("204_RhythmRoom_L");
    }

    @Test
    public void testPrintRhythmRoomR_StandAlone() throws Exception {
        testParseAndPrint("205_RhythmRoom_R");
    }

    @Test
    public void testPrintMicPlacement_StandAlone() throws Exception {
        testParseAndPrint("206_MicPlacement");
    }

    @Test
    public void testPrintTapePlate_StandAlone() throws Exception {
        testParseAndPrint("207_Tape_Plate");
    }

    @Test
    public void testPrintPCM60Room_StandAlone() throws Exception {
        testParseAndPrint("208_PCM_60_Room");
    }

    @Test
    public void testPrintGatedVerb_StandAlone() throws Exception {
        testParseAndPrint("209_Gated_Verb");
    }

    @Test
    public void testPrintClassicDetune_StandAlone() throws Exception {
        testParseAndPrint("210_Classic_Detune");
    }

    @Test
    public void testPrintCompChrs_StandAlone() throws Exception {
        testParseAndPrint("211_Comp+Chrs");
    }

    @Test
    public void testPrintStereoPhaser_StandAlone() throws Exception {
        testParseAndPrint("212_Stereo_Phaser");
    }

    @Test
    public void testPrintEnvAutoPan_StandAlone() throws Exception {
        testParseAndPrint("213_Env_AutoPan");
    }

    @Test
    public void testPrintEnvAutoWahs_StandAlone() throws Exception {
        testParseAndPrint("214_Env_AutoWahs");
    }

    @Test
    public void testPrintEnvFilterLP_StandAlone() throws Exception {
        testParseAndPrint("215_EnvFilter_LP");
    }

    @Test
    public void testPrintDualDelay_StandAlone() throws Exception {
        testParseAndPrint("216_Dual_Delay");
    }

    @Test
    public void testPrintEQDelay_StandAlone() throws Exception {
        testParseAndPrint("217_EQ_Delay");
    }

    @Test
    public void testPrintAnalogEcho_StandAlone() throws Exception {
        testParseAndPrint("218_Analog_Echo");
    }

    @Test
    public void testPrintInfiniteEcho_StandAlone() throws Exception {
        testParseAndPrint("219_InfiniteEcho");
    }

    @Test
    public void testPrintSurfsUp_StandAlone() throws Exception {
        testParseAndPrint("220_Surfs_Up");
    }

    @Test
    public void testPrintSlideComp_StandAlone() throws Exception {
        testParseAndPrint("221_Slide_Comp");
    }

    @Test
    public void testPrintFunkFX_StandAlone() throws Exception {
        testParseAndPrint("222_Funk+FX");
    }

    @Test
    public void testPrintBalladLead_StandAlone() throws Exception {
        testParseAndPrint("223_Ballad_Lead");
    }

    @Test
    public void testPrintDeDaDaDa_StandAlone() throws Exception {
        testParseAndPrint("224_De_DaDaDa");
    }

    @Test
    public void testPrintRockabilly_StandAlone() throws Exception {
        testParseAndPrint("225_Rockabilly");
    }

    @Test
    public void testPrintCountryRock_StandAlone() throws Exception {
        testParseAndPrint("226_Country_Rock");
    }

    @Test
    public void testPrintUltraClean_StandAlone() throws Exception {
        testParseAndPrint("227_Ultra_Clean");
    }

    @Test
    public void testPrintAcousticFX1_StandAlone() throws Exception {
        testParseAndPrint("228_Acoustic_FX1");
    }

    @Test
    public void testPrintTechnoChords_StandAlone() throws Exception {
        testParseAndPrint("229_TechnoChords");
    }

    @Test
    public void testPrintModernAB_StandAlone() throws Exception {
        testParseAndPrint("230_Modern_AB");
    }

    @Test
    public void testPrintBritishAB_StandAlone() throws Exception {
        testParseAndPrint("231_British_AB");
    }

    @Test
    public void testPrintAmericanAB_StandAlone() throws Exception {
        testParseAndPrint("232_American_AB");
    }

    @Test
    public void testPrintDetuneTrem_StandAlone() throws Exception {
        testParseAndPrint("233_Detune_Trem");
    }

    @Test
    public void testPrintDualAutoWahs_StandAlone() throws Exception {
        testParseAndPrint("234_DualAutoWahs");
    }

    @Test
    public void testPrintTremoWah_StandAlone() throws Exception {
        testParseAndPrint("235_TremoWah");
    }

    @Test
    public void testPrintPitchCascade_StandAlone() throws Exception {
        testParseAndPrint("236_Pitch_Cascade");
    }

    @Test
    public void testPrintOctaves_StandAlone() throws Exception {
        testParseAndPrint("237_Octaves");
    }

    @Test
    public void testPrintPdl2nds_StandAlone() throws Exception {
        testParseAndPrint("238_Pdl_2nds");
    }

    @Test
    public void testPrintEMajMin3_StandAlone() throws Exception {
        testParseAndPrint("239_EMajMin3");
    }

    @Test
    public void testPrintBassComp1_StandAlone() throws Exception {
        testParseAndPrint("240_BassComp1");
    }

    @Test
    public void testPrintBassCompChrs_StandAlone() throws Exception {
        testParseAndPrint("241_BassCompChrs");
    }

    @Test
    public void testPrintBassFuzz_StandAlone() throws Exception {
        testParseAndPrint("242_Bass_Fuzz");
    }

    @Test
    public void testPrintBassPitchPdl_StandAlone() throws Exception {
        testParseAndPrint("243_BassPitchPdl");
    }

    @Test
    public void testPrintBootsyBass_StandAlone() throws Exception {
        testParseAndPrint("244_BootsyBass");
    }

    @Test
    public void testPrintJam1SH_StandAlone() throws Exception {
        testParseAndPrint("245_Jam_1_SH+");
    }

    @Test
    public void testPrintJam1Cordovox_StandAlone() throws Exception {
        testParseAndPrint("246_Jam1Cordovox");
    }

    @Test
    public void testPrintJam2Pitch_StandAlone() throws Exception {
        testParseAndPrint("247_Jam_2_Pitch+");
    }

    @Test
    public void testPrintJam2AutoWah_StandAlone() throws Exception {
        testParseAndPrint("248_Jam2AutoWah");
    }

    private void testParseAndPrint(String filename) throws Exception {
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
