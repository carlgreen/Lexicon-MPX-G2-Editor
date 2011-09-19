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
import info.carlwithak.mpxg2.model.effects.Chorus;
import info.carlwithak.mpxg2.model.effects.Delay;
import info.carlwithak.mpxg2.model.effects.Effect1;
import info.carlwithak.mpxg2.model.effects.Effect2;
import info.carlwithak.mpxg2.model.effects.Gain;
import info.carlwithak.mpxg2.model.effects.Reverb;
import info.carlwithak.mpxg2.sysex.effects.algorithms.AmbienceParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.DetuneDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.EchoDualParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PannerParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PedalVolParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PedalWah1Parser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.PlateParser;
import info.carlwithak.mpxg2.sysex.effects.algorithms.UniVybeParser;
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
    static Program parseProgram(final File preset) throws IOException, ParseException {
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

        byte[] bytes = new byte[4];
        in.read(bytes);
        @SuppressWarnings("unused")
        int objectSize = 0;
        for (int i = 0; i < bytes.length; i++) {
            objectSize += (bytes[i] * Math.pow(16, i));
        }

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

        // TODO eq parameters
        in.read(new byte[32 * 2]);

        // gain parameters
        bytes = new byte[2];
        in.read(bytes);
        int gainLo = bytes[0] + bytes[1] * 16;

        in.read(bytes);
        int gainMid = bytes[0] + bytes[1] * 16;

        in.read(bytes);
        int gainHi = bytes[0] + bytes[1] * 16;

        in.read(bytes);
        int gainDrive = bytes[0] + bytes[1] * 16;

        in.read(bytes);
        int gainTone = bytes[0] + bytes[1] * 16;

        in.read(bytes);
        int gainLevel = bytes[0] + bytes[1] * 16;

        Gain gain = new Gain();
        gain.setLo(gainLo);
        gain.setMid(gainMid);
        gain.setHi(gainHi);
        gain.setDrive(gainDrive);
        gain.setTone(gainTone);
        gain.setLevel(gainLevel);
        program.setGain(gain);

        // unused
        in.read(new byte[26 * 2]);

        // TODO
        bytes = new byte[6];
        in.read(bytes);

        int effectTypes = 0;
        for (int i = 0; i < 4; i++) {
            effectTypes += (bytes[i] * Math.pow(16, i));
        }
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

        int guitarStyle = 0;
        for (int i = 0; i < 2; i++) {
            guitarStyle += (bytes[i + 4] * Math.pow(16, i));
        }
        program.setIsAcoustic((guitarStyle & GUITAR_STYLE_ACOUSTIC) == GUITAR_STYLE_ACOUSTIC);
        program.setIsBass((guitarStyle & GUITAR_STYLE_BASS) == GUITAR_STYLE_BASS);
        program.setIsBlues((guitarStyle & GUITAR_STYLE_BLUES) == GUITAR_STYLE_BLUES);
        program.setIsClean((guitarStyle & GUITAR_STYLE_CLEAN) == GUITAR_STYLE_CLEAN);
        program.setIsCountry((guitarStyle & GUITAR_STYLE_COUNTRY) == GUITAR_STYLE_COUNTRY);
        program.setIsJazz((guitarStyle & GUITAR_STYLE_JAZZ) == GUITAR_STYLE_JAZZ);
        program.setIsRock((guitarStyle & GUITAR_STYLE_ROCK) == GUITAR_STYLE_ROCK);

        StringBuilder sb = new StringBuilder(17);
        for (int i = 0; i < 9; i++) {
            bytes = new byte[10];
            in.read(bytes);
            int effect = bytes[0] + bytes[1] * 16;
            @SuppressWarnings("unused")
            int upperInputConn = bytes[2] + bytes[3] * 16;
            @SuppressWarnings("unused")
            int lowerInputConn = bytes[4] + bytes[5] * 16;
            @SuppressWarnings("unused")
            int routing = bytes[6] + bytes[7] * 16;
            @SuppressWarnings("unused")
            int pathType = bytes[8] + bytes[9] * 16;
            switch (effect) {
                case 0:
                    sb.append("=1");
                    break;
                case 1:
                    sb.append("=2");
                    break;
                case 2:
                    sb.append("=C");
                    break;
                case 3:
                    sb.append("=D");
                    break;
                case 4:
                    sb.append("=R");
                    break;
                case 5:
                    sb.append("=E");
                    break;
                case 6:
                    sb.append("=G");
                    break;
                case 7:
                    sb.append("=O");
                    break;
                case 8:
                    sb.append("I");
                    break;
            }
        }
        program.setRouting(sb.toString());

        bytes = new byte[2];
        in.read(bytes);
        int effect1ToePatch = bytes[0] + bytes[1] * 16;
        program.setEffect1ToePatch(effect1ToePatch);

        in.read(bytes);
        int effect2ToePatch = bytes[0] + bytes[1] * 16;
        program.setEffect2ToePatch(effect2ToePatch);

        in.read(bytes);
        int chorusToePatch = bytes[0] + bytes[1] * 16;
        program.setChorusToePatch(chorusToePatch);

        in.read(bytes);
        int delayToePatch = bytes[0] + bytes[1] * 16;
        program.setDelayToePatch(delayToePatch);

        in.read(bytes);
        int reverbToePatch = bytes[0] + bytes[1] * 16;
        program.setReverbToePatch(reverbToePatch);

        in.read(bytes);
        int eqToePatch = bytes[0] + bytes[1] * 16;
        program.setEqToePatch(eqToePatch);

        in.read(bytes);
        int gainToePatch = bytes[0] + bytes[1] * 16;
        program.setGainToePatch(gainToePatch);

        for (int i = 0; i < 7; i++) {
            bytes = new byte[2];
            in.read(bytes);
            int algorithmNumber = bytes[0] + bytes[1] * 16;
            switch (i) {
                case 0:
                    program.setEffect1Algorithm(algorithmNumber);
                    Effect1 effect1 = null;
                    switch (algorithmNumber) {
                        case 3:
                            effect1 = DetuneDualParser.parse(effect1Parameters);
                            break;
                        case 12:
                            effect1 = UniVybeParser.parse(effect1Parameters);
                            break;
                    }
                    program.setEffect1(effect1);
                    break;
                case 1:
                    program.setEffect2Algorithm(algorithmNumber);
                    Effect2 effect2 = null;
                    switch (algorithmNumber) {
                        case 1:
                            effect2 = PannerParser.parse(effect2Parameters);
                            break;
                        case 18:
                            effect2 = PedalWah1Parser.parse(effect2Parameters);
                            break;
                    }
                    program.setEffect2(effect2);
                    break;
                case 2:
                    program.setChorusAlgorithm(algorithmNumber);
                    Chorus chorus = null;
                    switch (algorithmNumber) {
                        case 16:
                            chorus = PedalVolParser.parse(chorusParameters);
                            break;
                    }
                    program.setChorus(chorus);
                    break;
                case 3:
                    program.setDelayAlgorithm(algorithmNumber);
                    Delay delay = null;
                    switch (algorithmNumber) {
                        case 6:
                            delay = EchoDualParser.parse(delayParameters);
                            break;
                    }
                    program.setDelay(delay);
                    break;
                case 4:
                    program.setReverbAlgorithm(algorithmNumber);
                    Reverb reverb = null;
                    switch (algorithmNumber) {
                        case 3:
                            reverb = PlateParser.parse(reverbParameters);
                            break;
                        case 4:
                            reverb = AmbienceParser.parse(reverbParameters);
                            break;
                    }
                    program.setReverb(reverb);
                    break;
                case 5:
                    program.setEqAlgorithm(algorithmNumber);
                    break;
                case 6:
                    program.setGainAlgorithm(algorithmNumber);
                    break;
            }
        }

        // read program name
        bytes = new byte[24];
        in.read(bytes);
        sb = new StringBuilder(12);
        for (int i = 0; i < bytes.length; i += 2) {
            char c = (char) (bytes[i] + (bytes[i + 1] * 16));
            sb.append(c);
        }
        program.setProgramName(sb.toString().trim());

        bytes = new byte[2];
        in.read(bytes);
        int effectsStatus = bytes[0] + (bytes[1] * 16);
        program.setEffect1On((effectsStatus & 0x01) == 0x01);
        program.setEffect2On((effectsStatus & 0x02) == 0x02);
        program.setChorusOn((effectsStatus & 0x04) == 0x04);
        program.setDelayOn((effectsStatus & 0x08) == 0x08);
        program.setReverbOn((effectsStatus & 0x10) == 0x10);
        program.setEqOn((effectsStatus & 0x20) == 0x20);
        program.setGainOn((effectsStatus & 0x40) == 0x40);
        program.setInsertOn((effectsStatus & 0x80) == 0x80);

        // soft row
        bytes = new byte[2];
        for (int i = 0; i < 10; i++) {
            in.read(bytes);
            int softRowEffectType = bytes[0] + (bytes[1] * 16);
            program.setSoftRowEffectType(i, softRowEffectType);

            in.read(bytes);
            int softRowParameter = bytes[0] + (bytes[1] * 16);
            program.setSoftRowParameter(i, softRowParameter);
        }

        // tempo
        bytes = new byte[4];
        in.read(bytes);
        int tempo = 0;
        for (int i = 0; i < 4; i++) {
            tempo += (bytes[i] * Math.pow(16, i));
        }
        program.setTempo(tempo);

        bytes = new byte[2];
        in.read(bytes);
        int tempoSource = bytes[0] + (bytes[1] * 16);
        program.setTempoSource(tempoSource);

        in.read(bytes);
        int beatValue = bytes[0] + (bytes[1] * 16);
        program.setBeatValue(beatValue);

        in.read(bytes);
        int tapSource = bytes[0] + (bytes[1] * 16);
        program.setTapSource(tapSource);

        in.read(bytes);
        int tapAverage = bytes[0] + (bytes[1] * 16);
        program.setTapAverage(tapAverage);

        in.read(bytes);
        int tapSourceLevel = bytes[0] + (bytes[1] * 16);
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
        bytes = new byte[2];
        in.read(bytes);
        int knobValue = bytes[0] + (bytes[1] * 16);
        program.setKnobValue(knobValue);

        in.read(bytes);
        int knobLow = bytes[0] + (bytes[1] * 16);
        program.setKnobLow(knobLow);

        in.read(bytes);
        int knobHigh = bytes[0] + (bytes[1] * 16);
        program.setKnobHigh(knobHigh);

        bytes = new byte[18];
        in.read(bytes);
        StringBuilder programName = new StringBuilder(9);
        for (int i = 0; i < bytes.length; i += 2) {
            char c = (char) (bytes[i] + (bytes[i + 1] * 16));
            programName.append(c);
        }
        program.setKnobName(programName.toString());

        // lfo 1 controller
        bytes = new byte[2];
        in.read(bytes);
        int lfo1Mode = bytes[0] + (bytes[1] * 16);
        program.setLfo1Mode(lfo1Mode);

        bytes = new byte[6];
        in.read(bytes);
        int lfo1Rate = 0;
        for (int i = 0; i < bytes.length; i++) {
            lfo1Rate += (bytes[i] * Math.pow(16, i));
        }
        program.setLfo1Rate(lfo1Rate / 100.0);

        bytes = new byte[2];
        in.read(bytes);
        int lfo1PulseWidth = bytes[0] + (bytes[1] * 16);
        program.setLfo1PulseWidth(lfo1PulseWidth);

        in.read(bytes);
        int lfo1Phase = bytes[0] + (bytes[1] * 16);
        program.setLfo1Phase(lfo1Phase);

        in.read(bytes);
        int lfo1Depth = bytes[0] + (bytes[1] * 16);
        program.setLfo1Depth(lfo1Depth);

        in.read(bytes);
        int lfo1OnLevel = bytes[0] + (bytes[1] * 16);
        program.setLfo1OnLevel(lfo1OnLevel);

        in.read(bytes);
        int lfo1OnSource = bytes[0] + (bytes[1] * 16);
        program.setLfo1OnSource(lfo1OnSource);

        // lfo 2 controller
        bytes = new byte[2];
        in.read(bytes);
        int lfo2Mode = bytes[0] + (bytes[1] * 16);
        program.setLfo2Mode(lfo2Mode);

        bytes = new byte[6];
        in.read(bytes);
        int lfo2Rate = 0;
        for (int i = 0; i < bytes.length; i++) {
            lfo2Rate += (bytes[i] * Math.pow(16, i));
        }
        program.setLfo2Rate(lfo2Rate / 100.0);

        bytes = new byte[2];
        in.read(bytes);
        int lfo2PulseWidth = bytes[0] + (bytes[1] * 16);
        program.setLfo2PulseWidth(lfo2PulseWidth);

        in.read(bytes);
        int lfo2Phase = bytes[0] + (bytes[1] * 16);
        program.setLfo2Phase(lfo2Phase);

        in.read(bytes);
        int lfo2Depth = bytes[0] + (bytes[1] * 16);
        program.setLfo2Depth(lfo2Depth);

        in.read(bytes);
        int lfo2OnLevel = bytes[0] + (bytes[1] * 16);
        program.setLfo2OnLevel(lfo2OnLevel);

        in.read(bytes);
        int lfo2OnSource = bytes[0] + (bytes[1] * 16);
        program.setLfo2OnSource(lfo2OnSource);

        // random controller
        bytes = new byte[2];
        in.read(bytes);
        int randomLow = bytes[0] + (bytes[1] * 16);
        program.setRandomLow(randomLow);

        in.read(bytes);
        int randomHigh = bytes[0] + (bytes[1] * 16);
        program.setRandomHigh(randomHigh);

        bytes = new byte[4];
        in.read(bytes);
        int randomRate = 0;
        for (int i = 0; i < bytes.length; i++) {
            randomRate += (bytes[i] * Math.pow(16, i));
        }
        program.setRandomRate(randomRate / 100.0);

        // TODO what is this?
        in.read(new byte[2]);

        // a/b data
        bytes = new byte[2];
        in.read(bytes);
        int abMode = bytes[0] + (bytes[1] * 16);
        program.setABMode(abMode);

        in.read(bytes);
        int aRate = bytes[0] + (bytes[1] * 16);
        program.setARate(aRate);

        in.read(bytes);
        int bRate = bytes[0] + (bytes[1] * 16);
        program.setBRate(bRate);

        in.read(bytes);
        int abOnLevel = bytes[0] + (bytes[1] * 16);
        program.setABOnLevel(abOnLevel);

        in.read(bytes);
        int abOnSource = bytes[0] + (bytes[1] * 16);
        program.setABOnSource(abOnSource);

        // envelope generator data
        bytes = new byte[2];
        in.read(bytes);
        int envGenSrc1 = bytes[0] + (bytes[1] * 16);
        program.setEnvelopeGeneratorSrc1(envGenSrc1);

        in.read(bytes);
        int envGenSrc2 = bytes[0] + (bytes[1] * 16);
        program.setEnvelopeGeneratorSrc2(envGenSrc2);

        in.read(bytes);
        int envGenATrim = bytes[0] + (bytes[1] * 16);
        program.setEnvelopeGeneratorATrim(envGenATrim);

        in.read(bytes);
        int envGenResponse = bytes[0] + (bytes[1] * 16);
        program.setEnvelopeGeneratorResponse(envGenResponse);

        // noise gate
        bytes = new byte[2];
        in.read(bytes);
        int noiseGateEnable = bytes[0] + (bytes[1] * 16);

        in.read(bytes);
        int noiseGateThreshold = bytes[0] + (bytes[1] * 16);

        in.read(bytes);
        int noiseGateOffset = bytes[0] + (bytes[1] * 16);

        bytes = new byte[4];
        in.read(bytes);
        int noiseGateHTime = 0;
        for (int i = 0; i < bytes.length; i++) {
            noiseGateHTime += (bytes[i] * Math.pow(16, i));
        }

        in.read(bytes);
        int noiseGateATime = 0;
        for (int i = 0; i < bytes.length; i++) {
            noiseGateATime += (bytes[i] * Math.pow(16, i));
        }

        in.read(bytes);
        int noiseGateRTime = 0;
        for (int i = 0; i < bytes.length; i++) {
            noiseGateRTime += (bytes[i] * Math.pow(16, i));
        }

        bytes = new byte[2];
        in.read(bytes);
        int noiseGateAttenuation = bytes[0] + (bytes[1] * 16);

        in.read(bytes);
        int noiseGateDelay = bytes[0] + (bytes[1] * 16);

        in.read(bytes);
        int noiseGateSend = bytes[0] + (bytes[1] * 16);

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
        bytes = new byte[2];
        in.read(bytes);
        int bypassState = bytes[0] + (bytes[1] * 16);
        program.setBypassState(bypassState);

        // Speaker Simulator
        bytes = new byte[2];
        in.read(bytes);
        int speakerSimulatorEnable = bytes[0] + (bytes[1] * 16);
        program.setSpeakerSimulatorEnable(speakerSimulatorEnable);

        in.read(bytes);
        int speakerSimulatorCabinet = bytes[0] + (bytes[1] * 16);
        program.setSpeakerSimulatorCabinet(speakerSimulatorCabinet);

        // Mix
        bytes = new byte[2];
        in.read(bytes);
        int postLevel = (byte) (bytes[0] + (bytes[1] * 16));
        program.setPostLevel(postLevel);

        bytes = new byte[2];
        in.read(bytes);
        int postBypassLevel = (byte) (bytes[0] + (bytes[1] * 16));
        program.setPostBypassLevel(postBypassLevel);

        bytes = new byte[2];
        in.read(bytes);
        int postMix = bytes[0] + (bytes[1] * 16);
        program.setPostMix(postMix);

        bytes = new byte[2];
        in.read(bytes);
        int sendLevel = (byte) (bytes[0] + (bytes[1] * 16));
        program.setSendLevel(sendLevel);

        bytes = new byte[2];
        in.read(bytes);
        int sendBypassLevel = (byte) (bytes[0] + (bytes[1] * 16));
        program.setSendBypassLevel(sendBypassLevel);

        // unused
        in.read(new byte[2]);

        // TODO what is this?
        in.read(new byte[4]);

        bytes = new byte[4];
        in.read(bytes);
        int controlLevels = 0;
        for (int i = 0; i < bytes.length; i++) {
            controlLevels += (bytes[i] * Math.pow(16, i));
        }

        if (controlLevels != 4) {
            throw new ParseException("Expect 4 control levels for a program dump");
        }

        in.read(bytes);
        int controlLevel0 = 0;
        for (int i = 0; i < bytes.length; i++) {
            controlLevel0 += (bytes[i] * Math.pow(16, i));
        }

        in.read(bytes);
        int controlLevel1 = 0;
        for (int i = 0; i < bytes.length; i++) {
            controlLevel1 += (bytes[i] * Math.pow(16, i));
        }

        if (controlLevel0 != 0x01 || controlLevel1 != 0x0A) {
            throw new ParseException("Expect ProgramDump control tree path");
        }

        in.read(bytes);
        int controlLevel2 = 0;
        for (int i = 0; i < bytes.length; i++) {
            controlLevel2 += (bytes[i] * Math.pow(16, i));
        }

        in.read(bytes);
        int controlLevel3 = 0;
        for (int i = 0; i < bytes.length; i++) {
            controlLevel3 += (bytes[i] * Math.pow(16, i));
        }

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
        byte[] bytes = new byte[2];
        in.read(bytes);
        int source = bytes[0] + (bytes[1] * 16);

        in.read(bytes);
        int sourceMin = bytes[0] + (bytes[1] * 16);

        in.read(bytes);
        int sourceMid = bytes[0] + (bytes[1] * 16);

        in.read(bytes);
        int sourceMax = bytes[0] + (bytes[1] * 16);

        in.read(bytes);
        int destinationEffect = bytes[0] + (bytes[1] * 16);

        in.read(bytes);
        int destinationParameter = bytes[0] + (bytes[1] * 16);

        bytes = new byte[4];
        in.read(bytes);
        int destinationMin = 0;
        // what is this logic?
        if (bytes[2] == 0xf && bytes[3] == 0xf) {
            destinationMin = bytes[0] + (bytes[1] * 16);
        } else {
            for (int i = 0; i < 4; i++) {
                destinationMin += (bytes[i] * Math.pow(16, i));
            }
        }

        // TODO find out what goes here
        bytes = new byte[2];
        in.read(bytes);

        bytes = new byte[2];
        in.read(bytes);
        int destinationMid = bytes[0] + (bytes[1] * 16);

        bytes = new byte[4];
        in.read(bytes);
        int destinationMax = 0;
        for (int i = 0; i < 4; i++) {
            destinationMax += (bytes[i] * Math.pow(16, i));
        }

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
}
