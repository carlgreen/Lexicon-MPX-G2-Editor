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
import info.carlwithak.mpxg2.model.Patch;
import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.model.RoutingData;
import info.carlwithak.mpxg2.model.effects.Chorus;
import info.carlwithak.mpxg2.model.effects.Delay;
import info.carlwithak.mpxg2.model.effects.Effect;
import info.carlwithak.mpxg2.model.effects.Eq;
import info.carlwithak.mpxg2.model.effects.Gain;
import info.carlwithak.mpxg2.model.effects.Reverb;
import info.carlwithak.mpxg2.sysex.effects.algorithms.AmbienceParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.AutoPanParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ChamberParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ChorusParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.DelayDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.DetuneDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.DetuneMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EchoDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EchoMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EqPedalVolParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.FlangerStereoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.OverdriveParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PannerParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PedalVolParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PedalWah1Parser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PlateParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ScreamerParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ShiftDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.ToneParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.UniVybeParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.VolumeMonoParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.Wah1Parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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

    /**
     * Parse a Program dumped in SysEx format.
     *
     * See {@link http://www.stecrecords.com/gear/mpxg2/doc/MPXG2_MIDI_Impl.htm}
     */
    public static Program parseProgram(final File preset) throws IOException, ParseException {
        InputStream in = new FileInputStream(preset);

        Program program = new Program();

        int b;
        if ((b = in.read()) != SYSEX_ID_START) {
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

        @SuppressWarnings("unused")
        int objectSize = readInt(in, 4);

        // effect 1 parameters
        byte[] effect1Parameters = new byte[32 * 2];
        in.read(effect1Parameters);

        // effect 2 parameters
        byte[] effect2Parameters = new byte[32 * 2];
        in.read(effect2Parameters);

        // chorus parameters
        byte[] chorusParameters = new byte[32 * 2];
        in.read(chorusParameters);

        // delay parameters
        byte[] delayParameters = new byte[32 * 2];
        in.read(delayParameters);

        // reverb parameters
        byte[] reverbParameters = new byte[32 * 2];
        in.read(reverbParameters);

        // eq parameters
        byte[] eqParameters = new byte[32 * 2];
        in.read(eqParameters);

        // gain parameters
        byte[] gainParameters = new byte[32 * 2];
        in.read(gainParameters);

        int effectTypes = readInt(in, 4);
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

        int guitarStyle = readInt(in, 2);
        program.setIsAcoustic((guitarStyle & GUITAR_STYLE_ACOUSTIC) == GUITAR_STYLE_ACOUSTIC);
        program.setIsBass((guitarStyle & GUITAR_STYLE_BASS) == GUITAR_STYLE_BASS);
        program.setIsBlues((guitarStyle & GUITAR_STYLE_BLUES) == GUITAR_STYLE_BLUES);
        program.setIsClean((guitarStyle & GUITAR_STYLE_CLEAN) == GUITAR_STYLE_CLEAN);
        program.setIsCountry((guitarStyle & GUITAR_STYLE_COUNTRY) == GUITAR_STYLE_COUNTRY);
        program.setIsJazz((guitarStyle & GUITAR_STYLE_JAZZ) == GUITAR_STYLE_JAZZ);
        program.setIsRock((guitarStyle & GUITAR_STYLE_ROCK) == GUITAR_STYLE_ROCK);

        for (int i = 0; i < 9; i++) {
            int effect = readInt(in, 2);
            int upperInputConn = readInt(in, 2);
            int lowerInputConn = readInt(in, 2);
            int routing = readInt(in, 2);
            int pathType = readInt(in, 2);
            RoutingData routingData = new RoutingData();
            routingData.setUpperInputConnection(upperInputConn);
            routingData.setLowerInputConnection(lowerInputConn);
            routingData.setEffectId(effect);
            routingData.setPathType(pathType);
            routingData.setRouting(routing);
            switch (i) {
                case 0:
                    program.setRouting0(routingData);
                    break;
                case 1:
                    program.setRouting1(routingData);
                    break;
                case 2:
                    program.setRouting2(routingData);
                    break;
                case 3:
                    program.setRouting3(routingData);
                    break;
                case 4:
                    program.setRouting4(routingData);
                    break;
                case 5:
                    program.setRouting5(routingData);
                    break;
                case 6:
                    program.setRouting6(routingData);
                    break;
                case 7:
                    program.setRouting7(routingData);
                    break;
                case 8:
                    program.setRouting8(routingData);
                    break;
            }
        }

        int effect1ToePatch = readInt(in, 2);
        program.setEffect1ToePatch(effect1ToePatch);

        int effect2ToePatch = readInt(in, 2);
        program.setEffect2ToePatch(effect2ToePatch);

        int chorusToePatch = readInt(in, 2);
        program.setChorusToePatch(chorusToePatch);

        int delayToePatch = readInt(in, 2);
        program.setDelayToePatch(delayToePatch);

        int reverbToePatch = readInt(in, 2);
        program.setReverbToePatch(reverbToePatch);

        int eqToePatch = readInt(in, 2);
        program.setEqToePatch(eqToePatch);

        int gainToePatch = readInt(in, 2);
        program.setGainToePatch(gainToePatch);

        for (int i = 0; i < 7; i++) {
            int algorithmNumber = readInt(in, 2);
            switch (i) {
                case 0:
                    program.setEffect1Algorithm(algorithmNumber);
                    Effect effect1;
                    switch (algorithmNumber) {
                        case 0:
                            effect1 = null;
                            break;
                        case 3:
                            effect1 = DetuneDualParser.parse(effect1Parameters);
                            break;
                        case 6:
                            effect1 = ShiftDualParser.parse(effect1Parameters);
                            break;
                        case 9:
                            effect1 = AutoPanParser.parse(effect1Parameters);
                            break;
                        case 12:
                            effect1 = UniVybeParser.parse(effect1Parameters);
                            break;
                        case 23:
                            effect1 = Wah1Parser.parse(effect1Parameters);
                            break;
                        case 27:
                            effect1 = VolumeMonoParser.parse(effect1Parameters);
                            break;
                        default:
                            throw new ParseException("Invalid Effect 1 algorithm number: " + algorithmNumber);
                    }
                    program.setEffect1(effect1);
                    break;
                case 1:
                    program.setEffect2Algorithm(algorithmNumber);
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
                        case 18:
                            effect2 = PedalWah1Parser.parse(effect2Parameters);
                            break;
                        case 20:
                            effect2 = VolumeMonoParser.parse(effect2Parameters);
                            break;
                        default:
                            throw new ParseException("Invalid Effect 2 algorithm number: " + algorithmNumber);
                    }
                    program.setEffect2(effect2);
                    break;
                case 2:
                    program.setChorusAlgorithm(algorithmNumber);
                    Chorus chorus;
                    switch (algorithmNumber) {
                        case 0:
                            chorus = null;
                            break;
                        case 1:
                            chorus = ChorusParser.parse(chorusParameters);
                            break;
                        case 2:
                            chorus = DetuneMonoParser.parse(chorusParameters);
                            break;
                        case 5:
                            chorus = FlangerStereoParser.parse(chorusParameters);
                            break;
                        case 16:
                            chorus = PedalVolParser.parse(chorusParameters);
                            break;
                        default:
                            throw new ParseException("Invalid Chorus algorithm number: " + algorithmNumber);
                    }
                    program.setChorus(chorus);
                    break;
                case 3:
                    program.setDelayAlgorithm(algorithmNumber);
                    Delay delay;
                    switch (algorithmNumber) {
                        case 0:
                            delay = null;
                            break;
                        case 3:
                            delay = DelayDualParser.parse(delayParameters);
                            break;
                        case 4:
                            delay = EchoMonoParser.parse(delayParameters);
                            break;
                        case 6:
                            delay = EchoDualParser.parse(delayParameters);
                            break;
                        default:
                            throw new ParseException("Invalid Delay algorithm number: " + algorithmNumber);
                    }
                    program.setDelay(delay);
                    break;
                case 4:
                    program.setReverbAlgorithm(algorithmNumber);
                    Reverb reverb;
                    switch (algorithmNumber) {
                        case 0:
                            reverb = null;
                            break;
                        case 1:
                            reverb = ChamberParser.parse(reverbParameters);
                            break;
                        case 3:
                            reverb = PlateParser.parse(reverbParameters);
                            break;
                        case 4:
                            reverb = AmbienceParser.parse(reverbParameters);
                            break;
                        default:
                            throw new ParseException("Invalid Reverb algorithm number: " + algorithmNumber);
                    }
                    program.setReverb(reverb);
                    break;
                case 5:
                    program.setEqAlgorithm(algorithmNumber);
                    Eq eq;
                    switch (algorithmNumber) {
                        case 0:
                            eq = null;
                            break;
                        case 14:
                            eq = EqPedalVolParser.parse(eqParameters);
                            break;
                        default:
                            throw new ParseException("Invalid EQ algorithm number: " + algorithmNumber);
                    }
                    program.setEq(eq);
                    break;
                case 6:
                    program.setGainAlgorithm(algorithmNumber);
                    Gain gain;
                    switch (algorithmNumber) {
                        case 0:
                            gain = null;
                            break;
                        case 1:
                            gain = ToneParser.parse(gainParameters);
                            break;
                        case 3:
                            gain = ScreamerParser.parse(gainParameters);
                            break;
                        case 4:
                            gain = OverdriveParser.parse(gainParameters);
                            break;
                        default:
                            throw new ParseException("Invalid Gain algorithm number: " + algorithmNumber);
                    }
                    program.setGain(gain);
                    break;
            }
        }

        // read program name
        byte[] bytes = new byte[24];
        in.read(bytes);
        StringBuilder sb = new StringBuilder(12);
        for (int i = 0; i < bytes.length; i += 2) {
            char c = (char) (bytes[i] + (bytes[i + 1] * 16));
            sb.append(c);
        }
        program.setProgramName(sb.toString().trim());

        int effectsStatus = readInt(in, 2);
        program.setEffect1On((effectsStatus & 0x01) == 0x01);
        program.setEffect2On((effectsStatus & 0x02) == 0x02);
        program.setChorusOn((effectsStatus & 0x04) == 0x04);
        program.setDelayOn((effectsStatus & 0x08) == 0x08);
        program.setReverbOn((effectsStatus & 0x10) == 0x10);
        program.setEqOn((effectsStatus & 0x20) == 0x20);
        program.setGainOn((effectsStatus & 0x40) == 0x40);
        program.setInsertOn((effectsStatus & 0x80) == 0x80);

        // soft row
        for (int i = 0; i < 10; i++) {
            int softRowEffectType = readInt(in, 2);
            program.setSoftRowEffectType(i, softRowEffectType);

            int softRowParameter = readInt(in, 2);
            program.setSoftRowParameter(i, softRowParameter);
        }

        // tempo
        int tempo = readInt(in, 4);
        program.setTempo(tempo);

        int tempoSource = readInt(in, 2);
        program.setTempoSource(tempoSource);

        int beatValue = readInt(in, 2);
        program.setBeatValue(beatValue);

        int tapSource = readInt(in, 2);
        program.setTapSource(tapSource);

        int tapAverage = readInt(in, 2);
        program.setTapAverage(tapAverage);

        int tapSourceLevel = readInt(in, 2);
        program.setTapSourceLevel(tapSourceLevel);

        // unused
        in.read(new byte[2]);

        // patching
        program.setPatch1(readPatch(in));
        program.setPatch2(readPatch(in));
        program.setPatch3(readPatch(in));
        program.setPatch4(readPatch(in));
        program.setPatch5(readPatch(in));

        // knob controller
        int knobValue = readInt(in, 2);
        program.setKnobValue(knobValue);

        int knobLow = readInt(in, 2);
        program.setKnobLow(knobLow);

        int knobHigh = readInt(in, 2);
        program.setKnobHigh(knobHigh);

        bytes = new byte[18];
        in.read(bytes);
        StringBuilder knobName = new StringBuilder(9);
        for (int i = 0; i < bytes.length; i += 2) {
            char c = (char) (bytes[i] + (bytes[i + 1] * 16));
            knobName.append(c);
        }
        program.setKnobName(knobName.toString());

        // lfo 1 controller
        int lfo1Mode = readInt(in, 2);
        program.setLfo1Mode(lfo1Mode);

        int lfo1Rate = readInt(in, 6);
        program.setLfo1Rate(lfo1Rate / 100.0);

        int lfo1PulseWidth = readInt(in, 2);
        program.setLfo1PulseWidth(lfo1PulseWidth);

        int lfo1Phase = readInt(in, 2);
        program.setLfo1Phase(lfo1Phase);

        int lfo1Depth = readInt(in, 2);
        program.setLfo1Depth(lfo1Depth);

        int lfo1OnLevel = readInt(in, 2);
        program.setLfo1OnLevel(lfo1OnLevel);

        int lfo1OnSource = readInt(in, 2);
        program.setLfo1OnSource(lfo1OnSource);

        // lfo 2 controller
        int lfo2Mode = readInt(in, 2);
        program.setLfo2Mode(lfo2Mode);

        int lfo2Rate = readInt(in, 6);
        program.setLfo2Rate(lfo2Rate / 100.0);

        int lfo2PulseWidth = readInt(in, 2);
        program.setLfo2PulseWidth(lfo2PulseWidth);

        int lfo2Phase = readInt(in, 2);
        program.setLfo2Phase(lfo2Phase);

        int lfo2Depth = readInt(in, 2);
        program.setLfo2Depth(lfo2Depth);

        int lfo2OnLevel = readInt(in, 2);
        program.setLfo2OnLevel(lfo2OnLevel);

        int lfo2OnSource = readInt(in, 2);
        program.setLfo2OnSource(lfo2OnSource);

        // random controller
        int randomLow = readInt(in, 2);
        program.setRandomLow(randomLow);

        int randomHigh = readInt(in, 2);
        program.setRandomHigh(randomHigh);

        int randomRate = readInt(in, 4);
        program.setRandomRate(randomRate / 100.0);

        // TODO what is this?
        in.read(new byte[2]);

        // a/b data
        int abMode = readInt(in, 2);
        program.setABMode(abMode);

        int aRate = readInt(in, 2);
        program.setARate(aRate);

        int bRate = readInt(in, 2);
        program.setBRate(bRate);

        int abOnLevel = readInt(in, 2);
        program.setABOnLevel(abOnLevel);

        int abOnSource = readInt(in, 2);
        program.setABOnSource(abOnSource);

        // envelope generator data
        int envGenSrc1 = readInt(in, 2);
        program.setEnvelopeGeneratorSrc1(envGenSrc1);

        int envGenSrc2 = readInt(in, 2);
        program.setEnvelopeGeneratorSrc2(envGenSrc2);

        int envGenATrim = readInt(in, 2);
        program.setEnvelopeGeneratorATrim(envGenATrim);

        int envGenResponse = readInt(in, 2);
        program.setEnvelopeGeneratorResponse(envGenResponse);

        // noise gate
        int noiseGateEnable = readInt(in, 2);
        int noiseGateThreshold = readInt(in, 2);
        int noiseGateOffset = readInt(in, 2);
        int noiseGateHTime = readInt(in, 4);
        int noiseGateATime = readInt(in, 4);
        int noiseGateRTime = readInt(in, 4);
        int noiseGateAttenuation = readInt(in, 2);
        int noiseGateDelay = readInt(in, 2);
        int noiseGateSend = readInt(in, 2);

        NoiseGate noiseGate = new NoiseGate();
        noiseGate.setEnable(noiseGateEnable);
        noiseGate.setThreshold(-1 * (256 - noiseGateThreshold));
        noiseGate.setOffset(-1 * noiseGateOffset);
        noiseGate.setHTime(noiseGateHTime);
        noiseGate.setATime(noiseGateATime);
        noiseGate.setRTime(noiseGateRTime);
        noiseGate.setAttenuation(-1 * (256 - noiseGateAttenuation));
        noiseGate.setDelay(noiseGateDelay);
        noiseGate.setSend(noiseGateSend);
        program.setNoiseGate(noiseGate);

        // Bypass State
        int bypassState = readInt(in, 2);
        program.setBypassState(bypassState);

        // Speaker Simulator
        int speakerSimulatorEnable = readInt(in, 2);
        program.setSpeakerSimulatorEnable(speakerSimulatorEnable);

        int speakerSimulatorCabinet = readInt(in, 2);
        program.setSpeakerSimulatorCabinet(speakerSimulatorCabinet);

        // Mix
        int postLevel = (byte) readInt(in, 2);
        program.setPostLevel(postLevel);

        int postBypassLevel = (byte) readInt(in, 2);
        program.setPostBypassLevel(postBypassLevel);

        int postMix = readInt(in, 2);
        program.setPostMix(postMix);

        int sendLevel = (byte) readInt(in, 2);
        program.setSendLevel(sendLevel);

        int sendBypassLevel = (byte) readInt(in, 2);
        program.setSendBypassLevel(sendBypassLevel);

        // unused
        in.read(new byte[2]);

        // TODO what is this?
        in.read(new byte[4]);

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

        if ((b = in.read()) != SYSEX_ID_END) {
            throw new ParseException("Invalid Sysex ID (end)");
        }

        in.close();

        return program;
    }

    private static Patch readPatch(final InputStream in) throws IOException {
        int source = readInt(in, 2);
        int sourceMin = readInt(in, 2);
        int sourceMid = readInt(in, 2);
        int sourceMax = readInt(in, 2);
        int destinationEffect = readInt(in, 2);
        int destinationParameter = readInt(in, 2);

        // what is this logic?
        int destinationMin = readInt(in, 4);
        if ((destinationMin & 0xff00) == 0xff00) {
            destinationMin = (byte) (destinationMin % 0xff00);
        }

        int destinationMid = readInt(in, 4);
        int destinationMax = readInt(in, 4);

        Patch patch = new Patch();
        patch.setSource(source);
        patch.setSourceMin(sourceMin);
        patch.setSourceMid(sourceMid);
        patch.setSourceMax(sourceMax);
        patch.setDestinationEffect(destinationEffect);
        patch.setDestinationParameter(destinationParameter);
        patch.setDestinationMin(destinationMin);
        patch.setDestinationMid(destinationMid);
        patch.setDestinationMax(destinationMax);
        return patch;
    }

    private static int readInt(final InputStream in, final int size) throws IOException {
        byte[] bytes = new byte[size];
        in.read(bytes);
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += (bytes[i] * Math.pow(16, i));
        }
        return result;
    }
}
