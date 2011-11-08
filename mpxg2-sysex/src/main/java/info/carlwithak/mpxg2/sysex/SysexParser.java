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
import info.carlwithak.mpxg2.model.Patch;
import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.model.Random;
import info.carlwithak.mpxg2.model.RoutingData;
import info.carlwithak.mpxg2.model.effects.Chorus;
import info.carlwithak.mpxg2.model.effects.Delay;
import info.carlwithak.mpxg2.model.effects.Effect;
import info.carlwithak.mpxg2.model.effects.Eq;
import info.carlwithak.mpxg2.model.effects.Gain;
import info.carlwithak.mpxg2.model.effects.Reverb;
import info.carlwithak.mpxg2.sysex.effects.algorithms.AerosolParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.AmbienceParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.AutoPanParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.BlueCompParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.Centrifuge1Parser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ChamberParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ChorusDetuneMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ChorusParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ChorusPedalVolParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ChorusVolumeDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ChorusVolumeMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ChorusVolumeStereoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.CrunchParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.CustomVybeParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.DelayDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.DelayMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.DelayStereoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.DetuneDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.DiatonicHmyParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.DistortionParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EchoDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EchoMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EchoStereoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EqPedalVolParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EqVolumeDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EqVolumeMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EqVolumeStereoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.Flanger24MonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.FlangerMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.FlangerStereoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.HallParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.JamManParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.OctaBuzzParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.OneBandMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.OrangePhaseParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.OverdriveParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PannerParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PedalVolParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PedalWah1Parser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PedalWah2Parser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PhaserParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PlateParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PreampParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.RedCompParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.RotaryCabParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ScreamerParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ShiftDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ShiftMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.SweepFilterParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ToneParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.TremoloMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.TremoloStereoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.TwoBandMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.UniVybeParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.VolumeDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.VolumeMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.VolumeStereoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.Wah1Parser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.Wah2Parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author carl
 */
public class SysexParser {

    private static final int SYSEX_ID_START = 0xf0;
    private static final int SYSEX_ID_END = 0xf7;
    private static final int LEXICON_MANUFACTURER_ID = 0x06;
    private static final int MPXG2_PRODUCT_ID = 0x0f;
    private static final int DATA_MESSAGE_TYPE = 0x01;
    private static final int NO_SOURCE_MID = 0xff;
    private static final int NO_DESTINATION = 0xff;
    // effect type constants
    private static final int EFFECT_TYPE_CHORUS = 0x0001;
    private static final int EFFECT_TYPE_DELAY = 0x0002;
    private static final int EFFECT_TYPE_DISTORTION = 0x0004;
    private static final int EFFECT_TYPE_EQ = 0x0008;
    private static final int EFFECT_TYPE_FLANGER = 0x0010;
    private static final int EFFECT_TYPE_GAIN = 0x0020;
    private static final int EFFECT_TYPE_MOD = 0x0040;
    private static final int EFFECT_TYPE_OVERDRIVE = 0x0080;
    private static final int EFFECT_TYPE_PHASER = 0x0100;
    private static final int EFFECT_TYPE_PITCH = 0x0200;
    private static final int EFFECT_TYPE_REVERB = 0x0400;
    private static final int EFFECT_TYPE_SPEAKERSIM = 0x0800;
    private static final int EFFECT_TYPE_WAH = 0x1000;
    private static final int APP_TYPE_PREPOST = 0x2000;
    private static final int APP_TYPE_STANDALONE = 0x4000;
    private static final int APP_TYPE_INLINE = 0x8000;
    // guitar style constants
    private static final int GUITAR_STYLE_ACOUSTIC = 0x02;
    private static final int GUITAR_STYLE_BASS = 0x04;
    private static final int GUITAR_STYLE_BLUES = 0x08;
    private static final int GUITAR_STYLE_CLEAN = 0x10;
    private static final int GUITAR_STYLE_COUNTRY = 0x20;
    private static final int GUITAR_STYLE_JAZZ = 0x40;
    private static final int GUITAR_STYLE_ROCK = 0x80;

    private static final Method[] SET_ROUTING_METHODS;
    static {
        SET_ROUTING_METHODS = new Method[9];
        for (int i = 0; i < SET_ROUTING_METHODS.length; i++) {
            try {
                SET_ROUTING_METHODS[i] = Program.class.getMethod("setRouting" + i, RoutingData.class);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Could not access \"setRouting" + i + "\" method on Program", e);
            }
        }
    }

    public static List<Program> parsePrograms(final File presets) throws IOException, ParseException {
        InputStream in = null;
        try {
            in = new FileInputStream(presets);
            List<Program> programs = new ArrayList<Program>();
            Program program;
            while ((program = parseProgram(in)) != null) {
                programs.add(program);
            }
            return programs;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    /**
     * Parse a Program dumped in SysEx format.
     *
     * See {@link http://www.stecrecords.com/gear/mpxg2/doc/MPXG2_MIDI_Impl.htm}
     */
    private static Program parseProgram(final InputStream in) throws IOException, ParseException {
        int b = in.read();
        if (b == -1) {
            return null;
        }

        if (b != SYSEX_ID_START) {
            throw new ParseException("Invalid Sysex ID (start)");
        }
        if ((b = in.read()) != LEXICON_MANUFACTURER_ID) {
            throw new ParseException("Invalid Manufacturer ID");
        }
        if ((b = in.read()) != MPXG2_PRODUCT_ID) {
            throw new ParseException("Invalid Product ID");
        }
        b = in.read();
        @SuppressWarnings("unused")
        int deviceId = b;

        if ((b = in.read()) != DATA_MESSAGE_TYPE) {
            throw new ParseException("Invalid Message Type");
        }

        Program program = new Program();

        int objectSize = readInt(in, 4);

        byte[] objectData = new byte[objectSize * 2];
        int length = in.read(objectData);
        if (length != objectSize * 2) {
            throw new ParseException("Expected to read " + (objectSize * 2) + " bytes, only read " + length);
        }

        int controlLevels = readInt(in, 4);
        if (controlLevels != 4) {
            throw new ParseException("Expect 4 control levels for a program dump");
        }

        int controlLevel0 = readInt(in, 4);
        int controlLevel1 = readInt(in, 4);
        if (controlLevel0 != 0x01 || controlLevel1 != 0x0A) {
            throw new ParseException("Expect ProgramDump control tree path");
        }

        int controlLevel2 = readInt(in, 4);
        int controlLevel3 = readInt(in, 4);
        int programNumber = controlLevel2 * 100 + controlLevel3 + 1;
        program.setProgramNumber(programNumber);

        b = in.read();
        @SuppressWarnings("unused")
        int checksum = b;

        if (in.read() != SYSEX_ID_END) {
            throw new ParseException("Invalid Sysex ID (end)");
        }

        // effect 1 parameters
        byte[] effect1Parameters = Arrays.copyOfRange(objectData, 0, 64);

        // effect 2 parameters
        byte[] effect2Parameters = Arrays.copyOfRange(objectData, 64, 128);

        // chorus parameters
        byte[] chorusParameters = Arrays.copyOfRange(objectData, 128, 192);

        // delay parameters
        byte[] delayParameters = Arrays.copyOfRange(objectData, 192, 256);

        // reverb parameters
        byte[] reverbParameters = Arrays.copyOfRange(objectData, 256, 320);

        // eq parameters
        byte[] eqParameters = Arrays.copyOfRange(objectData, 320, 384);

        // gain parameters
        byte[] gainParameters = Arrays.copyOfRange(objectData, 384, 448);

        int effectTypes = readInt(objectData, 448, 4);
        readEffectTypes(program, effectTypes);

        int guitarStyle = readInt(objectData, 452, 2);
        readGuitarStyles(program, guitarStyle);

        for (int i = 0; i < 9; i++) {
            int effect = readInt(objectData, 454 + (i * 10), 2);
            int upperInputConn = readInt(objectData, 456 + (i * 10), 2);
            int lowerInputConn = readInt(objectData, 458 + (i * 10), 2);
            int routing = readInt(objectData, 460 + (i * 10), 2);
            int pathType = readInt(objectData, 462 + (i * 10), 2);
            RoutingData routingData = new RoutingData();
            routingData.setUpperInputConnection(upperInputConn);
            routingData.setLowerInputConnection(lowerInputConn);
            routingData.setEffectId(effect);
            routingData.setPathType(pathType);
            routingData.setRouting(routing);
            try {
                SET_ROUTING_METHODS[i].invoke(program, routingData);
            } catch (IllegalAccessException e) {
                throw new ParseException("Could not call \"setRoutingData" + i + "\"", e);
            } catch (InvocationTargetException e) {
                throw new ParseException("Could not call \"setRoutingData" + i + "\"", e);
            }
        }

        int effect1ToePatch = readInt(objectData, 544, 2);
        program.setEffect1ToePatch(effect1ToePatch);

        int effect2ToePatch = readInt(objectData, 546, 2);
        program.setEffect2ToePatch(effect2ToePatch);

        int chorusToePatch = readInt(objectData, 548, 2);
        program.setChorusToePatch(chorusToePatch);

        int delayToePatch = readInt(objectData, 550, 2);
        program.setDelayToePatch(delayToePatch);

        int reverbToePatch = readInt(objectData, 552, 2);
        program.setReverbToePatch(reverbToePatch);

        int eqToePatch = readInt(objectData, 554, 2);
        program.setEqToePatch(eqToePatch);

        int gainToePatch = readInt(objectData, 556, 2);
        program.setGainToePatch(gainToePatch);

        for (int i = 0; i < 7; i++) {
            int algorithmNumber = readInt(objectData, 558 + (i * 2), 2);
            switch (i) {
                case 0:
                    Effect effect1;
                    switch (algorithmNumber) {
                        case 0:
                            effect1 = null;
                            break;
                        // TODO 1 - Detune (M)
                        // TODO 2 - Detune (S)
                        case 3:
                            effect1 = DetuneDualParser.parse(effect1Parameters);
                            break;
                        case 4:
                            effect1 = ShiftMonoParser.parse(effect1Parameters);
                            break;
                        // TODO 5 - Shift (S)
                        case 6:
                            effect1 = ShiftDualParser.parse(effect1Parameters);
                            break;
                        case 7:
                            effect1 = DiatonicHmyParser.parse(effect1Parameters);
                            break;
                        // TODO 8 - Panner
                        case 9:
                            effect1 = AutoPanParser.parse(effect1Parameters);
                            break;
                        case 10:
                            effect1 = TremoloMonoParser.parse(effect1Parameters);
                            break;
                        // TODO 11 - Tremolo (S)
                        case 12:
                            effect1 = UniVybeParser.parse(effect1Parameters);
                            break;
                        case 13:
                            effect1 = CustomVybeParser.parse(effect1Parameters);
                            break;
                        case 14:
                            effect1 = PhaserParser.parse(effect1Parameters);
                            break;
                        case 15:
                            effect1 = OrangePhaseParser.parse(effect1Parameters);
                            break;
                        case 16:
                            effect1 = RedCompParser.parse(effect1Parameters);
                            break;
                        case 17:
                            effect1 = BlueCompParser.parse(effect1Parameters);
                            break;
                        // TODO 18 - DigiDrive1
                        // TODO 19 - DigiDrive2
                        case 20:
                            effect1 = OctaBuzzParser.parse(effect1Parameters);
                            break;
                        case 21:
                            effect1 = SweepFilterParser.parse(effect1Parameters);
                            break;
                        // TODO 22 - 1-Band (M)
                        case 23:
                            effect1 = Wah1Parser.parse(effect1Parameters);
                            break;
                        case 24:
                            effect1 = Wah2Parser.parse(effect1Parameters);
                            break;
                        case 25:
                            effect1 = PedalWah1Parser.parse(effect1Parameters);
                            break;
                        case 26:
                            effect1 = PedalWah2Parser.parse(effect1Parameters);
                            break;
                        case 27:
                            effect1 = VolumeMonoParser.parse(effect1Parameters);
                            break;
                        case 28:
                            effect1 = VolumeStereoParser.parse(effect1Parameters);
                            break;
                        // TODO 29 - Volume (D)
                        case 30:
                            effect1 = PedalVolParser.parse(effect1Parameters);
                            break;
                        // TODO 31 - ExtPedalVol
                        // TODO 32 - Test Tone
                        // TODO 33 - Click
                        default:
                            throw new ParseException("Invalid Effect 1 algorithm number: " + algorithmNumber);
                    }
                    program.setEffect1(effect1);
                    break;
                case 1:
                    Effect effect2;
                    switch (algorithmNumber) {
                        case 0:
                            effect2 = null;
                            break;
                        case 1:
                            effect2 = PannerParser.parse(effect2Parameters);
                            break;
                        case 2:
                            effect2 = AutoPanParser.parse(effect2Parameters);
                            break;
                        case 3:
                            effect2 = TremoloMonoParser.parse(effect2Parameters);
                            break;
                        case 4:
                            effect2 = TremoloStereoParser.parse(effect2Parameters);
                            break;
                        // TODO 5 - UniVybe
                        // TODO 6 - CustomVybe
                        // TODO 7 - Phaser
                        case 8:
                            effect2 = OrangePhaseParser.parse(effect2Parameters);
                            break;
                        case 9:
                            effect2 = RedCompParser.parse(effect2Parameters);
                            break;
                        case 10:
                            effect2 = BlueCompParser.parse(effect2Parameters);
                            break;
                        // TODO 11 - DigiDrive1
                        // TODO 12 - DigiDrive2
                        case 13:
                            effect2 = OctaBuzzParser.parse(effect2Parameters);
                            break;
                        case 14:
                            effect2 = SweepFilterParser.parse(effect2Parameters);
                            break;
                        // TODO 15 - 1-Band (M)
                        case 16:
                            effect2 = Wah1Parser.parse(effect2Parameters);
                            break;
                        case 17:
                            effect2 = Wah2Parser.parse(effect2Parameters);
                            break;
                        case 18:
                            effect2 = PedalWah1Parser.parse(effect2Parameters);
                            break;
                        case 19:
                            effect2 = PedalWah2Parser.parse(effect2Parameters);
                            break;
                        case 20:
                            effect2 = VolumeMonoParser.parse(effect2Parameters);
                            break;
                        case 21:
                            effect2 = VolumeStereoParser.parse(effect2Parameters);
                            break;
                        case 22:
                            effect2 = VolumeDualParser.parse(effect2Parameters);
                            break;
                        // TODO 23 - PedalVol
                        // TODO 24 - ExtPedalVol
                        // TODO 25 - Test Tone
                        // TODO 26 - Click
                        default:
                            throw new ParseException("Invalid Effect 2 algorithm number: " + algorithmNumber);
                    }
                    program.setEffect2(effect2);
                    break;
                case 2:
                    Chorus chorus;
                    switch (algorithmNumber) {
                        case 0:
                            chorus = null;
                            break;
                        case 1:
                            chorus = ChorusParser.parse(chorusParameters);
                            break;
                        case 2:
                            chorus = ChorusDetuneMonoParser.parse(chorusParameters);
                            break;
                        case 3:
                            chorus = FlangerMonoParser.parse(chorusParameters);
                            break;
                        case 4:
                            chorus = Flanger24MonoParser.parse(chorusParameters);
                            break;
                        case 5:
                            chorus = FlangerStereoParser.parse(chorusParameters);
                            break;
                        case 6:
                            chorus = RotaryCabParser.parse(chorusParameters);
                            break;
                        case 7:
                            chorus = AerosolParser.parse(chorusParameters);
                            break;
                        // TODO 8 - Orbits
                        case 9:
                            chorus = Centrifuge1Parser.parse(chorusParameters);
                            break;
                        // TODO 10 - Centrifuge2
                        // TODO 11 - Comb 1
                        // TODO 12 - Comb 2
                        case 13:
                            chorus = ChorusVolumeMonoParser.parse(chorusParameters);
                            break;
                        case 14:
                            chorus = ChorusVolumeStereoParser.parse(chorusParameters);
                            break;
                        case 15:
                            chorus = ChorusVolumeDualParser.parse(chorusParameters);
                            break;
                        case 16:
                            chorus = ChorusPedalVolParser.parse(chorusParameters);
                            break;
                        // TODO 17 - ExtPedalVol
                        default:
                            throw new ParseException("Invalid Chorus algorithm number: " + algorithmNumber);
                    }
                    program.setChorus(chorus);
                    break;
                case 3:
                    Delay delay;
                    switch (algorithmNumber) {
                        case 0:
                            delay = null;
                            break;
                        case 1:
                            delay = DelayMonoParser.parse(delayParameters);
                            break;
                        case 2:
                            delay = DelayStereoParser.parse(delayParameters);
                            break;
                        case 3:
                            delay = DelayDualParser.parse(delayParameters);
                            break;
                        case 4:
                            delay = EchoMonoParser.parse(delayParameters);
                            break;
                        case 5:
                            delay = EchoStereoParser.parse(delayParameters);
                            break;
                        case 6:
                            delay = EchoDualParser.parse(delayParameters);
                            break;
                        // TODO 7 - Looper
                        case 8:
                            delay = JamManParser.parse(delayParameters);
                            break;
                        // TODO 9 - Ducker
                        default:
                            throw new ParseException("Invalid Delay algorithm number: " + algorithmNumber);
                    }
                    program.setDelay(delay);
                    break;
                case 4:
                    Reverb reverb;
                    switch (algorithmNumber) {
                        case 0:
                            reverb = null;
                            break;
                        case 1:
                            reverb = ChamberParser.parse(reverbParameters);
                            break;
                        case 2:
                            reverb = HallParser.parse(reverbParameters);
                            break;
                        case 3:
                            reverb = PlateParser.parse(reverbParameters);
                            break;
                        case 4:
                            reverb = AmbienceParser.parse(reverbParameters);
                            break;
                        // TODO 5 - Gate
                        default:
                            throw new ParseException("Invalid Reverb algorithm number: " + algorithmNumber);
                    }
                    program.setReverb(reverb);
                    break;
                case 5:
                    Eq eq;
                    switch (algorithmNumber) {
                        case 0:
                            eq = null;
                            break;
                        case 1:
                            eq = OneBandMonoParser.parse(eqParameters);
                            break;
                        case 2:
                            eq = TwoBandMonoParser.parse(eqParameters);
                            break;
                        // TODO 3 - 3-Band (M)
                        // TODO 4 - 4-Band (M)
                        // TODO 5 - 1-Band (S)
                        // TODO 6 - 2-Band (S)
                        // TODO 7 - 1-Band (D)
                        // TODO 8 - 2-Band (D)
                        // TODO 9 - Fc Splitter
                        // TODO 10 - Crossover
                        case 11:
                            eq = EqVolumeMonoParser.parse(eqParameters);
                            break;
                        case 12:
                            eq = EqVolumeStereoParser.parse(eqParameters);
                            break;
                        case 13:
                            eq = EqVolumeDualParser.parse(eqParameters);
                            break;
                        case 14:

                            eq = EqPedalVolParser.parse(eqParameters);
                            break;
                        // TODO 15 - ExtPedalVol
                        default:
                            throw new ParseException("Invalid EQ algorithm number: " + algorithmNumber);
                    }
                    program.setEq(eq);
                    break;
                case 6:
                    Gain gain;
                    switch (algorithmNumber) {
                        case 0:
                            gain = null;
                            break;
                        case 1:
                            gain = ToneParser.parse(gainParameters);
                            break;
                        case 2:
                            gain = CrunchParser.parse(gainParameters);
                            break;
                        case 3:
                            gain = ScreamerParser.parse(gainParameters);
                            break;
                        case 4:
                            gain = OverdriveParser.parse(gainParameters);
                            break;
                        case 5:
                            gain = DistortionParser.parse(gainParameters);
                            break;
                        case 6:
                            gain = PreampParser.parse(gainParameters);
                            break;
                        // TODO 7 - SplitPreamp
                        default:
                            throw new ParseException("Invalid Gain algorithm number: " + algorithmNumber);
                    }
                    program.setGain(gain);
                    break;
            }
        }

        // read program name
        byte[] bytes = Arrays.copyOfRange(objectData, 572, 596);
        StringBuilder sb = new StringBuilder(12);
        for (int i = 0; i < bytes.length; i += 2) {
            char c = (char) (bytes[i] + (bytes[i + 1] * 16));
            sb.append(c);
        }
        program.setProgramName(sb.toString().trim());

        int effectsStatus = readInt(objectData, 596, 2);
        readEffectsStatus(program, effectsStatus);

        // soft row
        for (int i = 0; i < 10; i++) {
            int softRowEffectType = readInt(objectData, 598 + (i * 4), 2);
            program.setSoftRowEffectType(i, softRowEffectType);

            int softRowParameter = readInt(objectData, 600 + (i * 4), 2);
            program.setSoftRowParameter(i, softRowParameter);
        }

        // tempo
        int tempo = readInt(objectData, 638, 4);
        program.setTempo(tempo);

        int tempoSource = readInt(objectData, 642, 2);
        program.setTempoSource(tempoSource);

        int beatValue = readInt(objectData, 644, 2);
        program.setBeatValue(beatValue);

        int tapSource = readInt(objectData, 646, 2);
        program.setTapSource(tapSource);

        int tapAverage = readInt(objectData, 648, 2);
        program.setTapAverage(tapAverage);

        int tapSourceLevel = readInt(objectData, 650, 2);
        program.setTapSourceLevel(tapSourceLevel);

        // unused bytes 652 - 654

        // patching
        program.setPatch1(readPatch(Arrays.copyOfRange(objectData, 654, 678)));
        program.setPatch2(readPatch(Arrays.copyOfRange(objectData, 678, 702)));
        program.setPatch3(readPatch(Arrays.copyOfRange(objectData, 702, 726)));
        program.setPatch4(readPatch(Arrays.copyOfRange(objectData, 726, 750)));
        program.setPatch5(readPatch(Arrays.copyOfRange(objectData, 750, 774)));

        // knob controller
        program.setKnob(readKnob(Arrays.copyOfRange(objectData, 774, 798)));

        // lfo 1 controller
        program.setLfo1(readLfo(Arrays.copyOfRange(objectData, 798, 816)));

        // lfo 2 controller
        program.setLfo2(readLfo(Arrays.copyOfRange(objectData, 816, 834)));

        // random controller
        program.setRandom(readRandom(Arrays.copyOfRange(objectData, 834, 844)));

        // a/b data
        program.setAb(readAb(Arrays.copyOfRange(objectData, 844, 854)));

        // envelope generator data
        program.setEnvelopeGenerator(readEnvelopeGenerator(Arrays.copyOfRange(objectData, 854, 862)));

        // noise gate
        int noiseGateEnable = readInt(objectData, 862, 2);
        int noiseGateThreshold = readInt(objectData, 864, 2);
        int noiseGateOffset = readInt(objectData, 866, 2);
        int noiseGateHTime = readInt(objectData, 868, 4);
        int noiseGateATime = readInt(objectData, 872, 4);
        int noiseGateRTime = readInt(objectData, 876, 4);
        int noiseGateAttenuation = readInt(objectData, 880, 2);
        int noiseGateDelay = readInt(objectData, 882, 2);
        int noiseGateSend = readInt(objectData, 884, 2);

        NoiseGate noiseGate = new NoiseGate();
        noiseGate.setEnable(noiseGateEnable);
        noiseGate.setThreshold(-1 * (256 - noiseGateThreshold));
        noiseGate.setOffset(-1 * noiseGateOffset);
        noiseGate.setHTime(noiseGateHTime);
        noiseGate.setATime(noiseGateATime);
        noiseGate.setRTime(noiseGateRTime);
        noiseGate.setAttenuation(-1 * (256 - noiseGateAttenuation));
        noiseGate.setDelay(noiseGateDelay);
        noiseGate.setSend(Util.parseBoolean(noiseGateSend));
        program.setNoiseGate(noiseGate);

        // Bypass State
        int bypassState = readInt(objectData, 886, 2);
        program.setBypassState(bypassState);

        // Speaker Simulator
        int speakerSimulatorEnable = readInt(objectData, 888, 2);
        program.setSpeakerSimulatorEnable(Util.parseBoolean(speakerSimulatorEnable));

        int speakerSimulatorCabinet = readInt(objectData, 890, 2);
        program.setSpeakerSimulatorCabinet(speakerSimulatorCabinet);

        // Mix
        int postLevel = readInt(objectData, 892, 2);
        program.setPostLevel(postLevel);

        int postBypassLevel = readInt(objectData, 894, 2);
        program.setPostBypassLevel(postBypassLevel);

        int postMix = readInt(objectData, 896, 2);
        program.setPostMix(postMix);

        int sendLevel = readInt(objectData, 898, 2);
        program.setSendLevel(sendLevel);

        int sendBypassLevel = readInt(objectData, 900, 2);
        program.setSendBypassLevel(sendBypassLevel);

        // unused bytes 902 - 904

        // TODO what is this?
        // skip bytes 904 - 908

        return program;
    }

    static void readEffectTypes(final Program program, final int effectTypes) {
        program.setIsChorus((effectTypes & EFFECT_TYPE_CHORUS) == EFFECT_TYPE_CHORUS);
        program.setIsDelay((effectTypes & EFFECT_TYPE_DELAY) == EFFECT_TYPE_DELAY);
        program.setIsDistortion((effectTypes & EFFECT_TYPE_DISTORTION) == EFFECT_TYPE_DISTORTION);
        program.setIsEq((effectTypes & EFFECT_TYPE_EQ) == EFFECT_TYPE_EQ);
        program.setIsFlanger((effectTypes & EFFECT_TYPE_FLANGER) == EFFECT_TYPE_FLANGER);
        program.setIsGain((effectTypes & EFFECT_TYPE_GAIN) == EFFECT_TYPE_GAIN);
        program.setIsMod((effectTypes & EFFECT_TYPE_MOD) == EFFECT_TYPE_MOD);
        program.setIsOverdrive((effectTypes & EFFECT_TYPE_OVERDRIVE) == EFFECT_TYPE_OVERDRIVE);
        program.setIsPhaser((effectTypes & EFFECT_TYPE_PHASER) == EFFECT_TYPE_PHASER);
        program.setIsPitch((effectTypes & EFFECT_TYPE_PITCH) == EFFECT_TYPE_PITCH);
        program.setIsReverb((effectTypes & EFFECT_TYPE_REVERB) == EFFECT_TYPE_REVERB);
        program.setIsSpeakerSim((effectTypes & EFFECT_TYPE_SPEAKERSIM) == EFFECT_TYPE_SPEAKERSIM);
        program.setIsWah((effectTypes & EFFECT_TYPE_WAH) == EFFECT_TYPE_WAH);
        program.setIsPrePost((effectTypes & APP_TYPE_PREPOST) == APP_TYPE_PREPOST);
        program.setIsStandAlone((effectTypes & APP_TYPE_STANDALONE) == APP_TYPE_STANDALONE);
        program.setIsInline((effectTypes & APP_TYPE_INLINE) == APP_TYPE_INLINE);
    }

    static void readGuitarStyles(final Program program, final int guitarStyle) {
        program.setIsAcoustic((guitarStyle & GUITAR_STYLE_ACOUSTIC) == GUITAR_STYLE_ACOUSTIC);
        program.setIsBass((guitarStyle & GUITAR_STYLE_BASS) == GUITAR_STYLE_BASS);
        program.setIsBlues((guitarStyle & GUITAR_STYLE_BLUES) == GUITAR_STYLE_BLUES);
        program.setIsClean((guitarStyle & GUITAR_STYLE_CLEAN) == GUITAR_STYLE_CLEAN);
        program.setIsCountry((guitarStyle & GUITAR_STYLE_COUNTRY) == GUITAR_STYLE_COUNTRY);
        program.setIsJazz((guitarStyle & GUITAR_STYLE_JAZZ) == GUITAR_STYLE_JAZZ);
        program.setIsRock((guitarStyle & GUITAR_STYLE_ROCK) == GUITAR_STYLE_ROCK);
    }

    static void readEffectsStatus(final Program program, final int effectsStatus) {
        program.setEffect1On((effectsStatus & 0x01) == 0x01);
        program.setEffect2On((effectsStatus & 0x02) == 0x02);
        program.setChorusOn((effectsStatus & 0x04) == 0x04);
        program.setDelayOn((effectsStatus & 0x08) == 0x08);
        program.setReverbOn((effectsStatus & 0x10) == 0x10);
        program.setEqOn((effectsStatus & 0x20) == 0x20);
        program.setGainOn((effectsStatus & 0x40) == 0x40);
        program.setInsertOn((effectsStatus & 0x80) == 0x80);
    }

    private static Patch readPatch(final byte[] bytes) throws IOException {
        int source = readInt(bytes, 0, 2);
        int sourceMin = readInt(bytes, 2, 2);
        int sourceMid = readInt(bytes, 4, 2);
        int sourceMax = readInt(bytes, 6, 2);
        int destinationEffect = readInt(bytes, 8, 2);
        int destinationParameter = readInt(bytes, 10, 2);

        // what is this logic?
        int destinationMin = readInt(bytes, 12, 4);
        if ((destinationMin & 0xff00) == 0xff00) {
            destinationMin = (byte) (destinationMin % 0xff00);
        }

        int destinationMid = readInt(bytes, 16, 4);
        int destinationMax = readInt(bytes, 20, 4);

        Patch patch = new Patch();
        patch.setSource(source);
        patch.setSourceMin(sourceMin);
        patch.setSourceMid(sourceMid == NO_SOURCE_MID ? null : sourceMid);
        patch.setSourceMax(sourceMax);
        patch.setDestinationEffect(destinationEffect == NO_DESTINATION ? null : destinationEffect);
        patch.setDestinationParameter(destinationParameter);
        patch.setDestinationMin(destinationMin);
        patch.setDestinationMid(destinationMid);
        patch.setDestinationMax(destinationMax);
        return patch;
    }

    static Knob readKnob(byte[] bytes) {
        final Knob knob = new Knob();

        int knobValue = bytes[0] + bytes[1] * 16;
        knob.setValue(knobValue);

        int knobLow = bytes[2] + bytes[3] * 16;
        knob.setLow(knobLow);

        int knobHigh = bytes[4] + bytes[5] * 16;
        knob.setHigh(knobHigh);

        bytes = Arrays.copyOfRange(bytes, 6, 24);
        StringBuilder knobName = new StringBuilder(9);
        for (int i = 0; i < bytes.length; i += 2) {
            char c = (char) (bytes[i] + (bytes[i + 1] * 16));
            knobName.append(c);
        }
        knob.setName(knobName.toString().trim());

        return knob;
    }

    static Lfo readLfo(final byte[] bytes) throws ParseException {
        final Lfo lfo = new Lfo();

        int mode = bytes[0] + bytes[1] * 16;
        lfo.setMode(mode);

        byte[] rateBytes = Arrays.copyOfRange(bytes, 2, 8);
        lfo.setRate(RateParser.parse("Rate", rateBytes));

        int pulseWidth = bytes[8] + bytes[9] * 16;
        lfo.setPulseWidth(pulseWidth);

        int phase = bytes[10] + bytes[11] * 16;
        lfo.setPhase(phase);

        int depth = bytes[12] + bytes[13] * 16;
        lfo.setDepth(depth);

        int onLevel = bytes[14] + bytes[15] * 16;
        lfo.setOnLevel(onLevel);

        int onSource = bytes[16] + bytes[17] * 16;
        lfo.setOnSource(onSource);

        return lfo;
    }

    static Random readRandom(byte[] bytes) throws ParseException {
        final Random random = new Random();

        int randomLow = bytes[0] + bytes[1] * 16;
        random.setLow(randomLow);

        int randomHigh = bytes[2] + bytes[3] * 16;
        random.setHigh(randomHigh);

        byte[] rateBytes = Arrays.copyOfRange(bytes, 4, 10);
        random.setRate(RateParser.parse("Rate", rateBytes));

        return random;
    }

    static Ab readAb(byte[] bytes) {
        final Ab ab = new Ab();

        int abMode = bytes[0] + bytes[1] * 16;
        ab.setMode(abMode);

        int aRate = bytes[2] + bytes[3] * 16;
        ab.setARate(aRate);

        int bRate = bytes[4] + bytes[5] * 16;
        ab.setBRate(bRate);

        int abOnLevel = bytes[6] + bytes[7] * 16;
        ab.setOnLevel(abOnLevel);

        int abOnSource = bytes[8] + bytes[9] * 16;
        ab.setOnSource(abOnSource);

        return ab;
    }

    static EnvelopeGenerator readEnvelopeGenerator(byte[] bytes) {
        EnvelopeGenerator envelopeGenerator = new EnvelopeGenerator();

        int envGenSrc1 = bytes[0] + bytes[1] * 16;
        envelopeGenerator.setSrc1(envGenSrc1);

        int envGenSrc2 = bytes[2] + bytes[3] * 16;
        envelopeGenerator.setSrc2(envGenSrc2);

        int envGenATrim = bytes[4] + bytes[5] * 16;
        envelopeGenerator.setATrim(envGenATrim);

        int envGenResponse = bytes[6] + bytes[7] * 16;
        envelopeGenerator.setResponse(envGenResponse);

        return envelopeGenerator;
    }

    private static int readInt(final InputStream in, final int size) throws IOException, ParseException {
        byte[] bytes = new byte[size];
        int length = in.read(bytes);
        if (length != size) {
            throw new ParseException("Expected to read " + size + " bytes, only read " + length);
        }
        return readInt(bytes, 0, size);
    }

    private static int readInt(final byte[] bytes, final int offset, final int size) {
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += (bytes[i + offset] * Math.pow(16, i));
        }
        return result;
    }
}
