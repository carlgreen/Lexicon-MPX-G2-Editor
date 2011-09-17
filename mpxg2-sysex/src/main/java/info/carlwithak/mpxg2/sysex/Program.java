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

import info.carlwithak.mpxg2.sysex.effects.Chorus;
import info.carlwithak.mpxg2.sysex.effects.Delay;
import info.carlwithak.mpxg2.sysex.effects.Effect1;
import info.carlwithak.mpxg2.sysex.effects.Effect2;
import info.carlwithak.mpxg2.sysex.effects.Eq;
import info.carlwithak.mpxg2.sysex.effects.Gain;
import info.carlwithak.mpxg2.sysex.effects.Reverb;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author carl
 */
public class Program {
    private Effect1 effect1;
    private Effect2 effect2;
    private Chorus chorus;
    private Delay delay;
    private Reverb reverb;
    private Eq eq;
    private Gain gain;

    // effect types
    private boolean isChorus;
    private boolean isDelay;
    private boolean isDistortion;
    private boolean isEq;
    private boolean isFlanger;
    private boolean isGain;
    private boolean isMod;
    private boolean isOverdrive;
    private boolean isPhaser;
    private boolean isPitch;
    private boolean isReverb;
    private boolean isSpeakerSim;
    private boolean isWah;
    private boolean isPrePost;
    private boolean isStandAlone;
    private boolean isInline;

    // guitar styles
    private boolean isAcoustic;
    private boolean isBass;
    private boolean isBlues;
    private boolean isClean;
    private boolean isCountry;
    private boolean isJazz;
    private boolean isRock;

    private String routing;

    private int effect1ToePatch;
    private int effect2ToePatch;
    private int chorusToePatch;
    private int delayToePatch;
    private int reverbToePatch;
    private int eqToePatch;
    private int gainToePatch;

    private int effect1Algorithm;
    private int effect2Algorithm;
    private int chorusAlgorithm;
    private int delayAlgorithm;
    private int reverbAlgorithm;
    private int eqAlgorithm;
    private int gainAlgorithm;

    private String programName;

    // effects status
    private boolean effect1On;
    private boolean effect2On;
    private boolean chorusOn;
    private boolean delayOn;
    private boolean reverbOn;
    private boolean eqOn;
    private boolean gainOn;
    private boolean insertOn;

    // soft row
    private List<SoftRowItem> softRow = Arrays.asList(null, null, null, null, null, null, null, null, null, null);

    // tempo
    private int tempo;
    private int tempoSource;
    private int beatValue;
    private int tapSource;
    private int tapAverage;
    private int tapSourceLevel;

    // patching
    private int patch1Source;
    private int patch1SourceMin;
    private int patch1SourceMid;
    private int patch1SourceMax;
    private int patch1DestinationEffect;
    private int patch1DestinationParameter;
    private int patch1DestinationMin;
    private int patch1DestinationMid;
    private int patch1DestinationMax;
    private int patch2Source;
    private int patch2SourceMin;
    private int patch2SourceMid;
    private int patch2SourceMax;
    private int patch2DestinationEffect;
    private int patch2DestinationParameter;
    private int patch2DestinationMin;
    private int patch2DestinationMid;
    private int patch2DestinationMax;
    private int patch3Source;
    private int patch3SourceMin;
    private int patch3SourceMid;
    private int patch3SourceMax;
    private int patch3DestinationEffect;
    private int patch3DestinationParameter;
    private int patch3DestinationMin;
    private int patch3DestinationMid;
    private int patch3DestinationMax;
    private int patch4Source;
    private int patch4SourceMin;
    private int patch4SourceMid;
    private int patch4SourceMax;
    private int patch4DestinationEffect;
    private int patch4DestinationParameter;
    private int patch4DestinationMin;
    private int patch4DestinationMid;
    private int patch4DestinationMax;
    private int patch5Source;
    private int patch5SourceMin;
    private int patch5SourceMid;
    private int patch5SourceMax;
    private int patch5DestinationEffect;
    private int patch5DestinationParameter;
    private int patch5DestinationMin;
    private int patch5DestinationMid;
    private int patch5DestinationMax;

    // controllers
    private int knobValue;
    private int knobLow;
    private int knobHigh;
    private String knobName;
    private int lfo1Mode;
    private double lfo1Rate;
    private int lfo1PulseWidth;
    private int lfo1Phase;
    private int lfo1Depth;
    private int lfo1OnLevel;
    private int lfo1OnSource;
    private int lfo2Mode;
    private double lfo2Rate;
    private int lfo2PulseWidth;
    private int lfo2Phase;
    private int lfo2Depth;
    private int lfo2OnLevel;
    private int lfo2OnSource;
    private int randomLow;
    private int randomHigh;
    private double randomRate;
    private int abMode;
    private int aRate;
    private int bRate;
    private int abOnLevel;
    private int abOnSource;
    private int envelopeGeneratorSrc1;
    private int envelopeGeneratorSrc2;
    private int envelopeGeneratorATrim;
    private int envelopeGeneratorResponse;

    // noise gate
    private int noiseGateEnable;
    private int noiseGateSend;
    private int noiseGateThreshold;
    private int noiseGateAttenuation;
    private int noiseGateOffset;
    private int noiseGateATime;
    private int noiseGateHTime;
    private int noiseGateRTime;
    private int noiseGateDelay;

    private int bypassState;

    // speaker simulator
    private int speakerSimulatorEnable;
    private int speakerSimulatorCabinet;

    // mix
    private int sendLevel;
    private int sendBypassLevel;
    private int postMix;
    private int postLevel;
    private int postBypassLevel;

    private int programNumber;

    Effect1 getEffect1() {
        return effect1;
    }

    void setEffect1(final Effect1 effect1) {
        this.effect1 = effect1;
    }

    Effect2 getEffect2() {
        return effect2;
    }

    void setEffect2(final Effect2 effect2) {
        this.effect2 = effect2;
    }

    Chorus getChorus() {
        return chorus;
    }

    void setChorus(final Chorus chorus) {
        this.chorus = chorus;
    }

    Delay getDelay() {
        return delay;
    }

    void setDelay(final Delay delay) {
        this.delay = delay;
    }

    Reverb getReverb() {
        return reverb;
    }

    void setReverb(final Reverb reverb) {
        this.reverb = reverb;
    }

    Eq getEq() {
        return eq;
    }

    void setEq(final Eq eq) {
        this.eq = eq;
    }

    Gain getGain() {
        return gain;
    }

    void setGain(final Gain gain) {
        this.gain = gain;
    }

    boolean isChorus() {
        return isChorus;
    }

    void setIsChorus(boolean isChorus) {
        this.isChorus = isChorus;
    }

    boolean isDelay() {
        return isDelay;
    }

    void setIsDelay(boolean isDelay) {
        this.isDelay = isDelay;
    }

    boolean isDistortion() {
        return isDistortion;
    }

    void setIsDistortion(boolean isDistortion) {
        this.isDistortion = isDistortion;
    }

    boolean isEq() {
        return isEq;
    }

    void setIsEq(boolean isEq) {
        this.isEq = isEq;
    }

    boolean isFlanger() {
        return isFlanger;
    }

    void setIsFlanger(boolean isFlanger) {
        this.isFlanger = isFlanger;
    }

    boolean isGain() {
        return isGain;
    }

    void setIsGain(boolean isGain) {
        this.isGain = isGain;
    }

    boolean isMod() {
        return isMod;
    }

    void setIsMod(boolean isMod) {
        this.isMod = isMod;
    }

    boolean isOverdrive() {
        return isOverdrive;
    }

    void setIsOverdrive(boolean isOverdrive) {
        this.isOverdrive = isOverdrive;
    }

    boolean isPhaser() {
        return isPhaser;
    }

    void setIsPhaser(boolean isPhaser) {
        this.isPhaser = isPhaser;
    }

    boolean isPitch() {
        return isPitch;
    }

    void setIsPitch(boolean isPitch) {
        this.isPitch = isPitch;
    }

    boolean isReverb() {
        return isReverb;
    }

    void setIsReverb(boolean isReverb) {
        this.isReverb = isReverb;
    }

    boolean isSpeakerSim() {
        return isSpeakerSim;
    }

    void setIsSpeakerSim(boolean isSpeakerSim) {
        this.isSpeakerSim = isSpeakerSim;
    }

    boolean isWah() {
        return isWah;
    }

    void setIsWah(boolean isWah) {
        this.isWah = isWah;
    }

    boolean isPrePost() {
        return isPrePost;
    }

    void setIsPrePost(boolean isPrePost) {
        this.isPrePost = isPrePost;
    }

    boolean isStandAlone() {
        return isStandAlone;
    }

    void setIsStandAlone(boolean isStandAlone) {
        this.isStandAlone = isStandAlone;
    }

    boolean isInline() {
        return isInline;
    }

    void setIsInline(boolean isInline) {
        this.isInline = isInline;
    }

    boolean isAcoustic() {
        return isAcoustic;
    }

    void setIsAcoustic(boolean isAcoustic) {
        this.isAcoustic = isAcoustic;
    }

    boolean isBass() {
        return isBass;
    }

    void setIsBass(boolean isBass) {
        this.isBass = isBass;
    }

    boolean isBlues() {
        return isBlues;
    }

    void setIsBlues(boolean isBlues) {
        this.isBlues = isBlues;
    }

    boolean isClean() {
        return isClean;
    }

    void setIsClean(boolean isClean) {
        this.isClean = isClean;
    }

    boolean isCountry() {
        return isCountry;
    }

    void setIsCountry(boolean isCountry) {
        this.isCountry = isCountry;
    }

    boolean isJazz() {
        return isJazz;
    }

    void setIsJazz(boolean isJazz) {
        this.isJazz = isJazz;
    }

    boolean isRock() {
        return isRock;
    }

    void setIsRock(boolean isRock) {
        this.isRock = isRock;
    }

    String getRouting() {
        return routing;
    }

    void setRouting(final String routing) {
        this.routing = routing;
    }

    int getEffect1ToePatch() {
        return effect1ToePatch;
    }

    void setEffect1ToePatch(final int effect1ToePatch) {
        this.effect1ToePatch = effect1ToePatch;
    }

    int getEffect2ToePatch() {
        return effect2ToePatch;
    }

    void setEffect2ToePatch(final int effect2ToePatch) {
        this.effect2ToePatch = effect2ToePatch;
    }

    int getChorusToePatch() {
        return chorusToePatch;
    }

    void setChorusToePatch(final int chorusToePatch) {
        this.chorusToePatch = chorusToePatch;
    }

    int getDelayToePatch() {
        return delayToePatch;
    }

    void setDelayToePatch(final int delayToePatch) {
        this.delayToePatch = delayToePatch;
    }

    int getReverbToePatch() {
        return reverbToePatch;
    }

    void setReverbToePatch(final int reverbToePatch) {
        this.reverbToePatch = reverbToePatch;
    }

    int getEqToePatch() {
        return eqToePatch;
    }

    void setEqToePatch(final int eqToePatch) {
        this.eqToePatch = eqToePatch;
    }

    int getGainToePatch() {
        return gainToePatch;
    }

    void setGainToePatch(final int gainToePatch) {
        this.gainToePatch = gainToePatch;
    }

    int getEffect1Algorithm() {
        return effect1Algorithm;
    }

    void setEffect1Algorithm(final int effect1Algorithm) {
        this.effect1Algorithm = effect1Algorithm;
    }

    int getEffect2Algorithm() {
        return effect2Algorithm;
    }

    void setEffect2Algorithm(final int effect2Algorithm) {
        this.effect2Algorithm = effect2Algorithm;
    }

    int getChorusAlgorithm() {
        return chorusAlgorithm;
    }

    void setChorusAlgorithm(final int chorusAlgorithm) {
        this.chorusAlgorithm = chorusAlgorithm;
    }

    int getDelayAlgorithm() {
        return delayAlgorithm;
    }

    void setDelayAlgorithm(final int delayAlgorithm) {
        this.delayAlgorithm = delayAlgorithm;
    }

    int getReverbAlgorithm() {
        return reverbAlgorithm;
    }

    void setReverbAlgorithm(final int reverbAlgorithm) {
        this.reverbAlgorithm = reverbAlgorithm;
    }

    int getEqAlgorithm() {
        return eqAlgorithm;
    }

    void setEqAlgorithm(final int eqAlgorithm) {
        this.eqAlgorithm = eqAlgorithm;
    }

    int getGainAlgorithm() {
        return gainAlgorithm;
    }

    void setGainAlgorithm(final int gainAlgorithm) {
        this.gainAlgorithm = gainAlgorithm;
    }

    String getProgramName() {
        return programName;
    }

    void setProgramName(final String programName) {
        this.programName = programName;
    }

    boolean isEffect1On() {
        return effect1On;
    }

    void setEffect1On(final boolean effect1On) {
        this.effect1On = effect1On;
    }

    boolean isEffect2On() {
        return effect2On;
    }

    void setEffect2On(final boolean effect2On) {
        this.effect2On = effect2On;
    }

    boolean isChorusOn() {
        return chorusOn;
    }

    void setChorusOn(final boolean chorusOn) {
        this.chorusOn = chorusOn;
    }

    boolean isDelayOn() {
        return delayOn;
    }

    void setDelayOn(final boolean delayOn) {
        this.delayOn = delayOn;
    }

    boolean isReverbOn() {
        return reverbOn;
    }

    void setReverbOn(final boolean reverbOn) {
        this.reverbOn = reverbOn;
    }

    boolean isEqOn() {
        return eqOn;
    }

    void setEqOn(final boolean eqOn) {
        this.eqOn = eqOn;
    }

    boolean isGainOn() {
        return gainOn;
    }

    void setGainOn(final boolean gainOn) {
        this.gainOn = gainOn;
    }

    boolean isInsertOn() {
        return insertOn;
    }

    void setInsertOn(final boolean insertOn) {
        this.insertOn = insertOn;
    }

    int getSoftRowEffectType(final int softRowPosition) {
        return this.softRow.get(softRowPosition).getEffectType();
    }

    void setSoftRowEffectType(final int softRowPosition, final int softRowEffectType) {
        if (this.softRow.get(softRowPosition) == null) {
            this.softRow.set(softRowPosition, new SoftRowItem());
        }
        this.softRow.get(softRowPosition).setEffectType(softRowEffectType);
    }

    int getSoftRowParameter(final int softRowPosition) {
        return this.softRow.get(softRowPosition).getParameter();
    }

    void setSoftRowParameter(final int softRowPosition, final int softRowParameter) {
        this.softRow.get(softRowPosition).setParameter(softRowParameter);
    }

    int getTempo() {
        return tempo;
    }

    void setTempo(final int tempo) {
        this.tempo = tempo;
    }

    int getTempoSource() {
        return tempoSource;
    }

    void setTempoSource(final int tempoSource) {
        this.tempoSource = tempoSource;
    }

    int getBeatValue() {
        return beatValue;
    }

    void setBeatValue(final int beatValue) {
        this.beatValue = beatValue;
    }

    int getTapSource() {
        return tapSource;
    }

    void setTapSource(final int tapSource) {
        this.tapSource = tapSource;
    }

    int getTapAverage() {
        return tapAverage;
    }

    void setTapAverage(final int tapAverage) {
        this.tapAverage = tapAverage;
    }

    int getTapSourceLevel() {
        return tapSourceLevel;
    }

    void setTapSourceLevel(final int tapSourceLevel) {
        this.tapSourceLevel = tapSourceLevel;
    }

    int getPatch1Source() {
        return patch1Source;
    }

    void setPatch1Source(final int patch1Source) {
        this.patch1Source = patch1Source;
    }

    int getPatch1SourceMin() {
        return patch1SourceMin;
    }

    void setPatch1SourceMin(final int patch1SourceMin) {
        this.patch1SourceMin = patch1SourceMin;
    }

    int getPatch1SourceMid() {
        return patch1SourceMid;
    }

    void setPatch1SourceMid(final int patch1SourceMid) {
        this.patch1SourceMid = patch1SourceMid;
    }

    int getPatch1SourceMax() {
        return patch1SourceMax;
    }

    void setPatch1SourceMax(final int patch1SourceMax) {
        this.patch1SourceMax = patch1SourceMax;
    }

    int getPatch1DestinationEffect() {
        return patch1DestinationEffect;
    }

    void setPatch1DestinationEffect(final int patch1DestinationEffect) {
        this.patch1DestinationEffect = patch1DestinationEffect;
    }

    int getPatch1DestinationParameter() {
        return patch1DestinationParameter;
    }

    void setPatch1DestinationParameter(final int patch1DestinationParameter) {
        this.patch1DestinationParameter = patch1DestinationParameter;
    }

    int getPatch1DestinationMin() {
        return patch1DestinationMin;
    }

    void setPatch1DestinationMin(final int patch1DestinationMin) {
        this.patch1DestinationMin = patch1DestinationMin;
    }

    int getPatch1DestinationMid() {
        return patch1DestinationMid;
    }

    void setPatch1DestinationMid(final int patch1DestinationMid) {
        this.patch1DestinationMid = patch1DestinationMid;
    }

    int getPatch1DestinationMax() {
        return patch1DestinationMax;
    }

    void setPatch1DestinationMax(final int patch1DestinationMax) {
        this.patch1DestinationMax = patch1DestinationMax;
    }

    int getPatch2Source() {
        return patch2Source;
    }

    void setPatch2Source(final int patch2Source) {
        this.patch2Source = patch2Source;
    }

    int getPatch2SourceMin() {
        return patch2SourceMin;
    }

    void setPatch2SourceMin(final int patch2SourceMin) {
        this.patch2SourceMin = patch2SourceMin;
    }

    int getPatch2SourceMid() {
        return patch2SourceMid;
    }

    void setPatch2SourceMid(final int patch2SourceMid) {
        this.patch2SourceMid = patch2SourceMid;
    }

    int getPatch2SourceMax() {
        return patch2SourceMax;
    }

    void setPatch2SourceMax(final int patch2SourceMax) {
        this.patch2SourceMax = patch2SourceMax;
    }

    int getPatch2DestinationEffect() {
        return patch2DestinationEffect;
    }

    void setPatch2DestinationEffect(final int patch2DestinationEffect) {
        this.patch2DestinationEffect = patch2DestinationEffect;
    }

    int getPatch2DestinationParameter() {
        return patch2DestinationParameter;
    }

    void setPatch2DestinationParameter(final int patch2DestinationParameter) {
        this.patch2DestinationParameter = patch2DestinationParameter;
    }

    int getPatch2DestinationMin() {
        return patch2DestinationMin;
    }

    void setPatch2DestinationMin(final int patch2DestinationMin) {
        this.patch2DestinationMin = patch2DestinationMin;
    }

    int getPatch2DestinationMid() {
        return patch2DestinationMid;
    }

    void setPatch2DestinationMid(final int patch2DestinationMid) {
        this.patch2DestinationMid = patch2DestinationMid;
    }

    int getPatch2DestinationMax() {
        return patch2DestinationMax;
    }

    void setPatch2DestinationMax(final int patch2DestinationMax) {
        this.patch2DestinationMax = patch2DestinationMax;
    }

    int getPatch3Source() {
        return patch3Source;
    }

    void setPatch3Source(final int patch3Source) {
        this.patch3Source = patch3Source;
    }

    int getPatch3SourceMin() {
        return patch3SourceMin;
    }

    void setPatch3SourceMin(final int patch3SourceMin) {
        this.patch3SourceMin = patch3SourceMin;
    }

    int getPatch3SourceMid() {
        return patch3SourceMid;
    }

    void setPatch3SourceMid(final int patch3SourceMid) {
        this.patch3SourceMid = patch3SourceMid;
    }

    int getPatch3SourceMax() {
        return patch3SourceMax;
    }

    void setPatch3SourceMax(final int patch3SourceMax) {
        this.patch3SourceMax = patch3SourceMax;
    }

    int getPatch3DestinationEffect() {
        return patch3DestinationEffect;
    }

    void setPatch3DestinationEffect(final int patch3DestinationEffect) {
        this.patch3DestinationEffect = patch3DestinationEffect;
    }

    int getPatch3DestinationParameter() {
        return patch3DestinationParameter;
    }

    void setPatch3DestinationParameter(final int patch3DestinationParameter) {
        this.patch3DestinationParameter = patch3DestinationParameter;
    }

    int getPatch3DestinationMin() {
        return patch3DestinationMin;
    }

    void setPatch3DestinationMin(final int patch3DestinationMin) {
        this.patch3DestinationMin = patch3DestinationMin;
    }

    int getPatch3DestinationMid() {
        return patch3DestinationMid;
    }

    void setPatch3DestinationMid(final int patch3DestinationMid) {
        this.patch3DestinationMid = patch3DestinationMid;
    }

    int getPatch3DestinationMax() {
        return patch3DestinationMax;
    }

    void setPatch3DestinationMax(final int patch3DestinationMax) {
        this.patch3DestinationMax = patch3DestinationMax;
    }

    int getPatch4Source() {
        return patch4Source;
    }

    void setPatch4Source(final int patch4Source) {
        this.patch4Source = patch4Source;
    }

    int getPatch4SourceMin() {
        return patch4SourceMin;
    }

    void setPatch4SourceMin(final int patch4SourceMin) {
        this.patch4SourceMin = patch4SourceMin;
    }

    int getPatch4SourceMid() {
        return patch4SourceMid;
    }

    void setPatch4SourceMid(final int patch4SourceMid) {
        this.patch4SourceMid = patch4SourceMid;
    }

    int getPatch4SourceMax() {
        return patch4SourceMax;
    }

    void setPatch4SourceMax(final int patch4SourceMax) {
        this.patch4SourceMax = patch4SourceMax;
    }

    int getPatch4DestinationEffect() {
        return patch4DestinationEffect;
    }

    void setPatch4DestinationEffect(final int patch4DestinationEffect) {
        this.patch4DestinationEffect = patch4DestinationEffect;
    }

    int getPatch4DestinationParameter() {
        return patch4DestinationParameter;
    }

    void setPatch4DestinationParameter(final int patch4DestinationParameter) {
        this.patch4DestinationParameter = patch4DestinationParameter;
    }

    int getPatch4DestinationMin() {
        return patch4DestinationMin;
    }

    void setPatch4DestinationMin(final int patch4DestinationMin) {
        this.patch4DestinationMin = patch4DestinationMin;
    }

    int getPatch4DestinationMid() {
        return patch4DestinationMid;
    }

    void setPatch4DestinationMid(final int patch4DestinationMid) {
        this.patch4DestinationMid = patch4DestinationMid;
    }

    int getPatch4DestinationMax() {
        return patch4DestinationMax;
    }

    void setPatch4DestinationMax(final int patch4DestinationMax) {
        this.patch4DestinationMax = patch4DestinationMax;
    }

    int getPatch5Source() {
        return patch5Source;
    }

    void setPatch5Source(final int patch5Source) {
        this.patch5Source = patch5Source;
    }

    int getPatch5SourceMin() {
        return patch5SourceMin;
    }

    void setPatch5SourceMin(final int patch5SourceMin) {
        this.patch5SourceMin = patch5SourceMin;
    }

    int getPatch5SourceMid() {
        return patch5SourceMid;
    }

    void setPatch5SourceMid(final int patch5SourceMid) {
        this.patch5SourceMid = patch5SourceMid;
    }

    int getPatch5SourceMax() {
        return patch5SourceMax;
    }

    void setPatch5SourceMax(final int patch5SourceMax) {
        this.patch5SourceMax = patch5SourceMax;
    }

    int getPatch5DestinationEffect() {
        return patch5DestinationEffect;
    }

    void setPatch5DestinationEffect(final int patch5DestinationEffect) {
        this.patch5DestinationEffect = patch5DestinationEffect;
    }

    int getPatch5DestinationParameter() {
        return patch5DestinationParameter;
    }

    void setPatch5DestinationParameter(final int patch5DestinationParameter) {
        this.patch5DestinationParameter = patch5DestinationParameter;
    }

    int getPatch5DestinationMin() {
        return patch5DestinationMin;
    }

    void setPatch5DestinationMin(final int patch5DestinationMin) {
        this.patch5DestinationMin = patch5DestinationMin;
    }

    int getPatch5DestinationMid() {
        return patch5DestinationMid;
    }

    void setPatch5DestinationMid(final int patch5DestinationMid) {
        this.patch5DestinationMid = patch5DestinationMid;
    }

    int getPatch5DestinationMax() {
        return patch5DestinationMax;
    }

    void setPatch5DestinationMax(final int patch5DestinationMax) {
        this.patch5DestinationMax = patch5DestinationMax;
    }

    int getKnobValue() {
        return knobValue;
    }

    void setKnobValue(final int knobValue) {
        this.knobValue = knobValue;
    }

    int getKnobLow() {
        return knobLow;
    }

    void setKnobLow(final int knobLow) {
        this.knobLow = knobLow;
    }

    int getKnobHigh() {
        return knobHigh;
    }

    void setKnobHigh(final int knobHigh) {
        this.knobHigh = knobHigh;
    }

    String getKnobName() {
        return knobName;
    }

    void setKnobName(final String knobName) {
        this.knobName = knobName;
    }

    int getLfo1Mode() {
        return lfo1Mode;
    }

    void setLfo1Mode(final int lfo1Mode) {
        this.lfo1Mode = lfo1Mode;
    }

    double getLfo1Rate() {
        return lfo1Rate;
    }

    void setLfo1Rate(final double lfo1Rate) {
        this.lfo1Rate = lfo1Rate;
    }

    int getLfo1PulseWidth() {
        return lfo1PulseWidth;
    }

    void setLfo1PulseWidth(final int lfo1PulseWidth) {
        this.lfo1PulseWidth = lfo1PulseWidth;
    }

    int getLfo1Phase() {
        return lfo1Phase;
    }

    void setLfo1Phase(final int lfo1Phase) {
        this.lfo1Phase = lfo1Phase;
    }

    int getLfo1Depth() {
        return lfo1Depth;
    }

    void setLfo1Depth(final int lfo1Depth) {
        this.lfo1Depth = lfo1Depth;
    }

    int getLfo1OnLevel() {
        return lfo1OnLevel;
    }

    void setLfo1OnLevel(final int lfo1OnLevel) {
        this.lfo1OnLevel = lfo1OnLevel;
    }

    int getLfo1OnSource() {
        return lfo1OnSource;
    }

    void setLfo1OnSource(final int lfo1OnSource) {
        this.lfo1OnSource = lfo1OnSource;
    }

    int getLfo2Mode() {
        return lfo2Mode;
    }

    void setLfo2Mode(final int lfo2Mode) {
        this.lfo2Mode = lfo2Mode;
    }

    double getLfo2Rate() {
        return lfo2Rate;
    }

    void setLfo2Rate(final double lfo2Rate) {
        this.lfo2Rate = lfo2Rate;
    }

    int getLfo2PulseWidth() {
        return lfo2PulseWidth;
    }

    void setLfo2PulseWidth(final int lfo2PulseWidth) {
        this.lfo2PulseWidth = lfo2PulseWidth;
    }

    int getLfo2Phase() {
        return lfo2Phase;
    }

    void setLfo2Phase(final int lfo2Phase) {
        this.lfo2Phase = lfo2Phase;
    }

    int getLfo2Depth() {
        return lfo2Depth;
    }

    void setLfo2Depth(final int lfo2Depth) {
        this.lfo2Depth = lfo2Depth;
    }

    int getLfo2OnLevel() {
        return lfo2OnLevel;
    }

    void setLfo2OnLevel(final int lfo2OnLevel) {
        this.lfo2OnLevel = lfo2OnLevel;
    }

    int getLfo2OnSource() {
        return lfo2OnSource;
    }

    void setLfo2OnSource(final int lfo2OnSource) {
        this.lfo2OnSource = lfo2OnSource;
    }

    int getRandomLow() {
        return randomLow;
    }

    void setRandomLow(final int randomLow) {
        this.randomLow = randomLow;
    }

    int getRandomHigh() {
        return randomHigh;
    }

    void setRandomHigh(final int randomHigh) {
        this.randomHigh = randomHigh;
    }

    double getRandomRate() {
        return randomRate;
    }

    void setRandomRate(final double randomRate) {
        this.randomRate = randomRate;
    }

    int getABMode() {
        return abMode;
    }

    void setABMode(final int abMode) {
        this.abMode = abMode;
    }

    int getARate() {
        return aRate;
    }

    void setARate(final int aRate) {
        this.aRate = aRate;
    }

    int getBRate() {
        return bRate;
    }

    void setBRate(final int bRate) {
        this.bRate = bRate;
    }

    int getABOnLevel() {
        return abOnLevel;
    }

    void setABOnLevel(final int abOnLevel) {
        this.abOnLevel = abOnLevel;
    }

    int getABOnSource() {
        return abOnSource;
    }

    void setABOnSource(final int abOnSource) {
        this.abOnSource = abOnSource;
    }

    int getEnvelopeGeneratorSrc1() {
        return envelopeGeneratorSrc1;
    }

    void setEnvelopeGeneratorSrc1(final int envelopeGeneratorSrc1) {
        this.envelopeGeneratorSrc1 = envelopeGeneratorSrc1;
    }

    int getEnvelopeGeneratorSrc2() {
        return envelopeGeneratorSrc2;
    }

    void setEnvelopeGeneratorSrc2(final int envelopeGeneratorSrc2) {
        this.envelopeGeneratorSrc2 = envelopeGeneratorSrc2;
    }

    int getEnvelopeGeneratorATrim() {
        return envelopeGeneratorATrim;
    }

    void setEnvelopeGeneratorATrim(final int envelopeGeneratorATrim) {
        this.envelopeGeneratorATrim = envelopeGeneratorATrim;
    }

    int getEnvelopeGeneratorResponse() {
        return envelopeGeneratorResponse;
    }

    void setEnvelopeGeneratorResponse(final int envelopeGeneratorResponse) {
        this.envelopeGeneratorResponse = envelopeGeneratorResponse;
    }

    int getNoiseGateEnable() {
        return noiseGateEnable;
    }

    void setNoiseGateEnable(final int noiseGateEnable) {
        this.noiseGateEnable = noiseGateEnable;
    }

    int getNoiseGateSend() {
        return noiseGateSend;
    }

    void setNoiseGateSend(final int noiseGateSend) {
        this.noiseGateSend = noiseGateSend;
    }

    int getNoiseGateThreshold() {
        return noiseGateThreshold;
    }

    void setNoiseGateThreshold(final int noiseGateThreshold) {
        this.noiseGateThreshold = noiseGateThreshold;
    }

    int getNoiseGateAttenuation() {
        return noiseGateAttenuation;
    }

    void setNoiseGateAttenuation(final int noiseGateAttenuation) {
        this.noiseGateAttenuation = noiseGateAttenuation;
    }

    int getNoiseGateOffset() {
        return noiseGateOffset;
    }

    void setNoiseGateOffset(final int noiseGateOffset) {
        this.noiseGateOffset = noiseGateOffset;
    }

    int getNoiseGateATime() {
        return noiseGateATime;
    }

    void setNoiseGateATime(final int noiseGateATime) {
        this.noiseGateATime = noiseGateATime;
    }

    int getNoiseGateHTime() {
        return noiseGateHTime;
    }

    void setNoiseGateHTime(final int noiseGateHTime) {
        this.noiseGateHTime = noiseGateHTime;
    }

    int getNoiseGateRTime() {
        return noiseGateRTime;
    }

    void setNoiseGateRTime(final int noiseGateRTime) {
        this.noiseGateRTime = noiseGateRTime;
    }

    int getNoiseGateDelay() {
        return noiseGateDelay;
    }

    void setNoiseGateDelay(final int noiseGateDelay) {
        this.noiseGateDelay = noiseGateDelay;
    }

    int getBypassState() {
        return bypassState;
    }

    void setBypassState(final int bypassState) {
        this.bypassState = bypassState;
    }

    int getSpeakerSimulatorEnable() {
        return speakerSimulatorEnable;
    }

    void setSpeakerSimulatorEnable(final int speakerSimulatorEnable) {
        this.speakerSimulatorEnable = speakerSimulatorEnable;
    }

    int getSpeakerSimulatorCabinet() {
        return speakerSimulatorCabinet;
    }

    void setSpeakerSimulatorCabinet(final int speakerSimulatorCabinet) {
        this.speakerSimulatorCabinet = speakerSimulatorCabinet;
    }

    int getSendLevel() {
        return sendLevel;
    }

    void setSendLevel(final int sendLevel) {
        this.sendLevel = sendLevel;
    }

    int getSendBypassLevel() {
        return sendBypassLevel;
    }

    void setSendBypassLevel(final int sendBypassLevel) {
        this.sendBypassLevel = sendBypassLevel;
    }

    int getPostMix() {
        return postMix;
    }

    void setPostMix(final int postMix) {
        this.postMix = postMix;
    }

    int getPostLevel() {
        return postLevel;
    }

    void setPostLevel(final int postLevel) {
        this.postLevel = postLevel;
    }

    int getPostBypassLevel() {
        return postBypassLevel;
    }

    void setPostBypassLevel(final int postBypassLevel) {
        this.postBypassLevel = postBypassLevel;
    }

    int getProgramNumber() {
        return programNumber;
    }

    void setProgramNumber(final int programNumber) {
        this.programNumber = programNumber;
    }
}
