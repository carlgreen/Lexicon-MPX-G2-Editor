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

/**
 * Class to print out a program nicely.
 *
 * @author carl
 */
public class ProgramPrinter {

    private static final String[] EFFECT1_ALGORITHM_NAMES = {
        "no effect", "Detune (M)", "Detune (S)", "Detune (D)", "Shift (M)", "Shift (S)", "Shift (D)",
        "DiatonicHmy", "Panner", "Auto Pan", "Tremolo (M)", "Tremolo (S)", "UniVybe", "Custom Vybe",
        "Phaser", "OrangePhase", "Red Comp", "Blue Comp", "DigiDrive1", "DigiDrive2", "OctaBuzz",
        "SweepFilter", "1-Band (M)", "Wah  1", "Wah  2", "Pedal Wah 1", "Pedal Wah 2",
        "Volume (M)", "Volume (S)", "Volume (D)", "Pedal Vol", "ExtPedalVol", "Test Tone", "Click"
    };
    private static final String[] EFFECT2_ALGORITHM_NAMES = {
        "no effect", "Panner", "Auto Pan", "Tremolo (M)", "Tremolo (S)", "UniVybe", "Custom Vybe",
        "Phaser", "OrangePhase", "Red Comp", "Blue Comp", "DigiDrive1", "DigiDrive2", "OctaBuzz",
        "SweepFilter", "1-Band (M)", "Wah  1", "Wah  2", "Pedal Wah 1", "Pedal Wah 2",
        "Volume (M)", "Volume (S)", "Volume (D)", "Pedal Vol", "ExtPedalVol", "Test Tone", "Click"
    };
    private static final String[] CHORUS_ALGORITHM_NAMES = {
        "no effect", "Chorus", "Detune (M)", "Flanger (M)", "Flanger24(M)", "Flanger (S)", "Rotary Cab",
        "Aerosol", "Orbits", "Centrifuge1", "Centrifuge2", "Comb 1", "Comb 2",
        "Volume (M)", "Volume (S)", "Volume (D)", "Pedal Vol", "ExtPedalVol"
    };
    private static final String[] DELAY_ALGORITHM_NAMES = {
        "no effect", "Delay (M)", "Delay (S)", "Delay (D)", "Echo (M)", "Echo (S)", "Echo (D)",
        "Looper", "JamMan", "Ducker"
    };
    private static final String[] REVERB_ALGORITHM_NAMES = {
        "no effect", "Chamber", "Hall", "Plate", "Ambience", "Gate"
    };
    private static final String[] GAIN_ALGORITHM_NAMES = {
        "no effect", "Tone", "Crunch", "Screamer", "Overdrive", "Distortion", "Preamp", "SplitPreamp"
    };

    private static final String[] DELAY_INSERTS = {
        "effect 1", "effect 2", "chorus", "delay", "reverb", "eq", "gain"
    };

    private static final double[] REVERB_DELAY_TIMES = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.41
    };

    private static final double[] REVERB_RT_HC = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12.8
    };

    static String print(Program program) {
        StringBuilder sb = new StringBuilder();
        sb.append(program.getProgramName()).append("\n");
        StringBuilder styleSB = new StringBuilder();
        if (program.isAcoustic()) {
            styleSB.append("Acoustic, ");
        }
        if (program.isBass()) {
            styleSB.append("Bass, ");
        }
        if (program.isBlues()) {
            styleSB.append("Blues, ");
        }
        if (program.isClean()) {
            styleSB.append("Clean, ");
        }
        if (program.isCountry()) {
            styleSB.append("Country, ");
        }
        if (program.isJazz()) {
            styleSB.append("Jazz, ");
        }
        if (program.isRock()) {
            styleSB.append("Rock, ");
        }
        sb.append("  Guitar Style: ");
        if (styleSB.length() > 0) {
            sb.append(styleSB.substring(0, styleSB.length() - 2));
        }
        sb.append("\n");
        StringBuilder effectTypeSB = new StringBuilder();
        if (program.isChorus()) {
            effectTypeSB.append("Chorus, ");
        }
        if (program.isDelay()) {
            effectTypeSB.append("Delay, ");
        }
        if (program.isDistortion()) {
            effectTypeSB.append("Distortion, ");
        }
        if (program.isEq()) {
            effectTypeSB.append("EQ, ");
        }
        if (program.isFlanger()) {
            effectTypeSB.append("Flanger, ");
        }
        if (program.isGain()) {
            effectTypeSB.append("Gain, ");
        }
        if (program.isMod()) {
            effectTypeSB.append("Mod, ");
        }
        if (program.isOverdrive()) {
            effectTypeSB.append("Overdrive, ");
        }
        if (program.isPhaser()) {
            effectTypeSB.append("Phaser, ");
        }
        if (program.isPitch()) {
            effectTypeSB.append("Pitch, ");
        }
        if (program.isReverb()) {
            effectTypeSB.append("Reverb, ");
        }
        if (program.isSpeakerSim()) {
            effectTypeSB.append("Speaker Sim, ");
        }
        if (program.isWah()) {
            effectTypeSB.append("Wah, ");
        }
        sb.append("  Effect Type: ");
        if (effectTypeSB.length() > 0) {
            sb.append(effectTypeSB.substring(0, effectTypeSB.length() - 2));
        }
        sb.append("\n");
        StringBuilder appTypeSB = new StringBuilder();
        if (program.isPrePost()) {
            appTypeSB.append("Amp Input + FX Loop");
        }
        if (program.isStandAlone()) {
            appTypeSB.append("Stand alone");
        }
        if (program.isInline()) {
            appTypeSB.append("Amp Input Only");
        }
        sb.append("  Application Type: ");
        sb.append(appTypeSB.toString());
        sb.append("\n");
        sb.append("  Effect Routing: ").append(program.getRouting()).append("\n");
        if (program.getEffect1Algorithm() > 0) {
            sb.append("  Effect 1: ").append(effect1AlgorithmToString(program.getEffect1Algorithm())).append(" (").append(program.isEffect1On() ? "on" : "off").append(")").append("\n");
            sb.append("    Toe Switch: ").append(toePatchToString(program.getEffect1ToePatch())).append("\n");
            sb.append("    Mix: ").append(program.getEffect1Mix()).append("%\n");
            sb.append("    Level: ").append(program.getEffect1Level()).append("dB\n");
            sb.append("    Rate: ").append(program.getEffect1Rate()).append("\n");
        }
        if (program.getEffect2Algorithm() > 0) {
            sb.append("  Effect 2: ").append(effect2AlgorithmToString(program.getEffect2Algorithm())).append(" (").append(program.isEffect2On() ? "on" : "off").append(")").append("\n");
            sb.append("    Toe Switch: ").append(toePatchToString(program.getEffect2ToePatch())).append("\n");
            sb.append("    Mix: ").append(program.getEffect2Mix()).append("%\n");
            sb.append("    Level: ").append(program.getEffect2Level()).append("dB\n");
            sb.append("    Bass: ").append(program.getEffect2Bass()).append("\n");
            sb.append("    Type: Model ").append(program.getEffect2Type() == 0 ? "C" : "V").append("\n");
            sb.append("    Resp: ").append(program.getEffect2Response()).append("\n");
            sb.append("    Gain: ").append(program.getEffect2Gain() > 0 ? "+" : "").append(program.getEffect2Gain()).append("\n");
        }
        if (program.getChorusAlgorithm() > 0) {
            sb.append("  Chorus: ").append(chorusAlgorithmToString(program.getChorusAlgorithm())).append(" (").append(program.isChorusOn() ? "on" : "off").append(")").append("\n");
            sb.append("    Toe Switch: ").append(toePatchToString(program.getChorusToePatch())).append("\n");
            sb.append("    Mix: ").append(program.getChorusMix()).append("%\n");
            sb.append("    Level: ").append(program.getChorusLevel()).append("dB\n");
        }
        if (program.getDelayAlgorithm() > 0) {
            sb.append("  Delay: ").append(delayAlgorithmToString(program.getDelayAlgorithm())).append(" (").append(program.isDelayOn() ? "on" : "off").append(")").append("\n");
            sb.append("    Toe Switch: ").append(toePatchToString(program.getDelayToePatch())).append("\n");
            sb.append("    Mix: ").append(program.getDelayMix()).append("%\n");
            sb.append("    Level: ").append(program.getDelayLevel() > 0 ? "+" : "").append(program.getDelayLevel()).append("dB\n");
            sb.append("    Time1: ").append(program.getDelayTime1Echoes()).append(":").append(program.getDelayTime1Beat()).append("\n");
            sb.append("    Time2: ").append(program.getDelayTime2Echoes()).append(":").append(program.getDelayTime2Beat()).append("\n");
            sb.append("    Level1: ").append(program.getDelayLevel1() > 0 ? "+" : "").append(program.getDelayLevel1()).append("dB\n");
            sb.append("    Level2: ").append(program.getDelayLevel2() > 0 ? "+" : "").append(program.getDelayLevel2()).append("dB\n");
            sb.append("    Feedback1: ").append(program.getDelayFeedback1() > 0 ? "+" : "").append(program.getDelayFeedback1()).append("%\n");
            sb.append("    Insert: ").append(delayInsertToString(program.getDelayInsert())).append("\n");
            sb.append("    Feedback2: ").append(program.getDelayFeedback2() > 0 ? "+" : "").append(program.getDelayFeedback2()).append("%\n");
            sb.append("    Damp1: ").append(program.getDelayDamp1()).append("%\n");
            sb.append("    Damp2: ").append(program.getDelayDamp2()).append("%\n");
            sb.append("    Clear: ").append(program.getDelayClear() == 0 ? "off" : "on").append("\n");
        }
        if (program.getReverbAlgorithm() > 0) {
            sb.append("  Reverb: ").append(reverbAlgorithmToString(program.getReverbAlgorithm())).append(" (").append(program.isReverbOn() ? "on" : "off").append(")").append("\n");
            sb.append("    Toe Switch: ").append(toePatchToString(program.getReverbToePatch())).append("\n");
            sb.append("    Mix: ").append(program.getReverbMix()).append("%\n");
            sb.append("    Level: ").append(program.getReverbLevel()).append("dB\n");
            sb.append("    Size: ").append(program.getReverbSize()).append("m\n");
            sb.append("    Link: ").append(program.getReverbLink() == 0 ? "off" : "on").append("\n");
            sb.append("    Diff: ").append(program.getReverbDiff()).append("%\n");
            sb.append("    Pre Delay: ").append(program.getReverbPreDelay()).append("ms\n");
            sb.append("    Delay Time: ").append(reverbDelayTimeToString(program.getReverbDelayTime())).append("s\n");
            sb.append("    Delay Level: ").append(program.getReverbDelayLevel() == 0 ? "off" : "on").append("\n");
            sb.append("    Rt HC: ").append(reverbRtHCToString(program.getReverbRtHC())).append("k\n");
        }
        if (program.getGainAlgorithm() > 0) {
            sb.append("  Gain: ").append(gainAlgorithmToString(program.getGainAlgorithm())).append(" (").append(program.isGainOn() ? "on" : "off").append(")").append("\n");
            sb.append("    Toe Switch: ").append(toePatchToString(program.getGainToePatch())).append("\n");
            sb.append("    Lo: ").append(program.getGainLo() > 0 ? "+" : "").append(program.getGainLo()).append("\n");
            sb.append("    Mid: ").append(program.getGainMid() > 0 ? "+" : "").append(program.getGainMid()).append("\n");
            sb.append("    Hi: ").append(program.getGainHi() > 0 ? "+" : "").append(program.getGainHi()).append("\n");
            sb.append("    Drive: ").append(program.getGainDrive()).append("\n");
            sb.append("    Tone: ").append(program.getGainTone()).append("\n");
            sb.append("    Level: ").append(program.getGainLevel()).append("\n");
        }
        return sb.toString().trim();
    }

    private static String effect1AlgorithmToString(final int effect1Algorithm) {
        return EFFECT1_ALGORITHM_NAMES[effect1Algorithm];
    }

    private static String effect2AlgorithmToString(final int effect2Algorithm) {
        return EFFECT2_ALGORITHM_NAMES[effect2Algorithm];
    }

    private static String chorusAlgorithmToString(final int chorusAlgorithm) {
        return CHORUS_ALGORITHM_NAMES[chorusAlgorithm];
    }

    private static String delayAlgorithmToString(final int delayAlgorithm) {
        return DELAY_ALGORITHM_NAMES[delayAlgorithm];
    }

    private static String reverbAlgorithmToString(final int reverbAlgorithm) {
        return REVERB_ALGORITHM_NAMES[reverbAlgorithm];
    }

    private static String gainAlgorithmToString(final int gainAlgorithm) {
        return GAIN_ALGORITHM_NAMES[gainAlgorithm];
    }

    private static String toePatchToString(final int toePatch) {
        String s = null;
        switch(toePatch) {
            case 0:
                s = "disabled";
                break;
            case 1:
                s = "off=bypass";
                break;
            case 2:
                s = "on=bypass";
                break;
        }
        return s;
    }

    private static String delayInsertToString(final int delayInsert) {
        return DELAY_INSERTS[delayInsert];
    }

    private static double reverbDelayTimeToString(final int reverbDelayTime) {
        return REVERB_DELAY_TIMES[reverbDelayTime];
    }

    private static double reverbRtHCToString(final int reverbRtHC) {
        return REVERB_RT_HC[reverbRtHC];
    }
}
