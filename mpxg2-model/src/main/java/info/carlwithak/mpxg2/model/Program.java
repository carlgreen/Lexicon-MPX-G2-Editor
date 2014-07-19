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

package info.carlwithak.mpxg2.model;

import info.carlwithak.mpxg2.model.effects.Chorus;
import info.carlwithak.mpxg2.model.effects.Delay;
import info.carlwithak.mpxg2.model.effects.Effect;
import info.carlwithak.mpxg2.model.effects.Eq;
import info.carlwithak.mpxg2.model.effects.Gain;
import info.carlwithak.mpxg2.model.effects.Reverb;
import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import info.carlwithak.mpxg2.model.parameters.SpeakerSimulatorCabinetValue;
import info.carlwithak.mpxg2.model.parameters.TextValue;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author carl
 */
public class Program {
    private Effect effect1;
    private Effect effect2;
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

    private RoutingData routing0;
    private RoutingData routing1;
    private RoutingData routing2;
    private RoutingData routing3;
    private RoutingData routing4;
    private RoutingData routing5;
    private RoutingData routing6;
    private RoutingData routing7;
    private RoutingData routing8;

    private int effect1ToePatch;
    private int effect2ToePatch;
    private int chorusToePatch;
    private int delayToePatch;
    private int reverbToePatch;
    private int eqToePatch;
    private int gainToePatch;

    private final TextValue programName = new TextValue("Name", 12);

    private EffectsStatus effectsStatus;

    private final List<SoftRowItem> softRow = Arrays.<SoftRowItem>asList(null, null, null, null, null, null, null, null, null, null);

    private Tempo tempo;

    private final Patch[] patches = new Patch[5];

    // controllers
    private Knob knob;
    private Lfo lfo1;
    private Lfo lfo2;
    private Random random;
    private Ab ab;
    private EnvelopeGenerator envelopeGenerator;

    // noise gate
    private NoiseGate noiseGate;

    private int bypassState;

    // speaker simulator
    private final OnOffValue speakerSimulatorEnable = new OnOffValue("Enable");
    private final SpeakerSimulatorCabinetValue speakerSimulatorCabinet = new SpeakerSimulatorCabinetValue("Cabinet");

    // mix
    private SendMix sendMix;
    private PostMix postMix;

    private int programNumber;

    public Effect getEffect1() {
        return effect1;
    }

    public void setEffect1(final Effect effect1) {
        this.effect1 = effect1;
    }

    public Effect getEffect2() {
        return effect2;
    }

    public void setEffect2(final Effect effect2) {
        this.effect2 = effect2;
    }

    public Chorus getChorus() {
        return chorus;
    }

    public void setChorus(final Chorus chorus) {
        this.chorus = chorus;
    }

    public Delay getDelay() {
        return delay;
    }

    public void setDelay(final Delay delay) {
        this.delay = delay;
    }

    public Reverb getReverb() {
        return reverb;
    }

    public void setReverb(final Reverb reverb) {
        this.reverb = reverb;
    }

    public Eq getEq() {
        return eq;
    }

    public void setEq(final Eq eq) {
        this.eq = eq;
    }

    public Gain getGain() {
        return gain;
    }

    public void setGain(final Gain gain) {
        this.gain = gain;
    }

    public boolean isChorus() {
        return isChorus;
    }

    public void setIsChorus(boolean isChorus) {
        this.isChorus = isChorus;
    }

    public boolean isDelay() {
        return isDelay;
    }

    public void setIsDelay(boolean isDelay) {
        this.isDelay = isDelay;
    }

    public boolean isDistortion() {
        return isDistortion;
    }

    public void setIsDistortion(boolean isDistortion) {
        this.isDistortion = isDistortion;
    }

    public boolean isEq() {
        return isEq;
    }

    public void setIsEq(boolean isEq) {
        this.isEq = isEq;
    }

    public boolean isFlanger() {
        return isFlanger;
    }

    public void setIsFlanger(boolean isFlanger) {
        this.isFlanger = isFlanger;
    }

    public boolean isGain() {
        return isGain;
    }

    public void setIsGain(boolean isGain) {
        this.isGain = isGain;
    }

    public boolean isMod() {
        return isMod;
    }

    public void setIsMod(boolean isMod) {
        this.isMod = isMod;
    }

    public boolean isOverdrive() {
        return isOverdrive;
    }

    public void setIsOverdrive(boolean isOverdrive) {
        this.isOverdrive = isOverdrive;
    }

    public boolean isPhaser() {
        return isPhaser;
    }

    public void setIsPhaser(boolean isPhaser) {
        this.isPhaser = isPhaser;
    }

    public boolean isPitch() {
        return isPitch;
    }

    public void setIsPitch(boolean isPitch) {
        this.isPitch = isPitch;
    }

    public boolean isReverb() {
        return isReverb;
    }

    public void setIsReverb(boolean isReverb) {
        this.isReverb = isReverb;
    }

    public boolean isSpeakerSim() {
        return isSpeakerSim;
    }

    public void setIsSpeakerSim(boolean isSpeakerSim) {
        this.isSpeakerSim = isSpeakerSim;
    }

    public boolean isWah() {
        return isWah;
    }

    public void setIsWah(boolean isWah) {
        this.isWah = isWah;
    }

    public boolean isPrePost() {
        return isPrePost;
    }

    public void setIsPrePost(boolean isPrePost) {
        this.isPrePost = isPrePost;
    }

    public boolean isStandAlone() {
        return isStandAlone;
    }

    public void setIsStandAlone(boolean isStandAlone) {
        this.isStandAlone = isStandAlone;
    }

    public boolean isInline() {
        return isInline;
    }

    public void setIsInline(boolean isInline) {
        this.isInline = isInline;
    }

    public boolean isAcoustic() {
        return isAcoustic;
    }

    public void setIsAcoustic(boolean isAcoustic) {
        this.isAcoustic = isAcoustic;
    }

    public boolean isBass() {
        return isBass;
    }

    public void setIsBass(boolean isBass) {
        this.isBass = isBass;
    }

    public boolean isBlues() {
        return isBlues;
    }

    public void setIsBlues(boolean isBlues) {
        this.isBlues = isBlues;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setIsClean(boolean isClean) {
        this.isClean = isClean;
    }

    public boolean isCountry() {
        return isCountry;
    }

    public void setIsCountry(boolean isCountry) {
        this.isCountry = isCountry;
    }

    public boolean isJazz() {
        return isJazz;
    }

    public void setIsJazz(boolean isJazz) {
        this.isJazz = isJazz;
    }

    public boolean isRock() {
        return isRock;
    }

    public void setIsRock(boolean isRock) {
        this.isRock = isRock;
    }

    public RoutingData getRouting0() {
        return routing0;
    }

    public void setRouting0(RoutingData routing0) {
        this.routing0 = routing0;
    }

    public RoutingData getRouting1() {
        return routing1;
    }

    public void setRouting1(RoutingData routing1) {
        this.routing1 = routing1;
    }

    public RoutingData getRouting2() {
        return routing2;
    }

    public void setRouting2(RoutingData routing2) {
        this.routing2 = routing2;
    }

    public RoutingData getRouting3() {
        return routing3;
    }

    public void setRouting3(RoutingData routing3) {
        this.routing3 = routing3;
    }

    public RoutingData getRouting4() {
        return routing4;
    }

    public void setRouting4(RoutingData routing4) {
        this.routing4 = routing4;
    }

    public RoutingData getRouting5() {
        return routing5;
    }

    public void setRouting5(RoutingData routing5) {
        this.routing5 = routing5;
    }

    public RoutingData getRouting6() {
        return routing6;
    }

    public void setRouting6(RoutingData routing6) {
        this.routing6 = routing6;
    }

    public RoutingData getRouting7() {
        return routing7;
    }

    public void setRouting7(RoutingData routing7) {
        this.routing7 = routing7;
    }

    public RoutingData getRouting8() {
        return routing8;
    }

    public void setRouting8(RoutingData routing8) {
        this.routing8 = routing8;
    }

    public int getEffect1ToePatch() {
        return effect1ToePatch;
    }

    public void setEffect1ToePatch(final int effect1ToePatch) {
        this.effect1ToePatch = effect1ToePatch;
    }

    public int getEffect2ToePatch() {
        return effect2ToePatch;
    }

    public void setEffect2ToePatch(final int effect2ToePatch) {
        this.effect2ToePatch = effect2ToePatch;
    }

    public int getChorusToePatch() {
        return chorusToePatch;
    }

    public void setChorusToePatch(final int chorusToePatch) {
        this.chorusToePatch = chorusToePatch;
    }

    public int getDelayToePatch() {
        return delayToePatch;
    }

    public void setDelayToePatch(final int delayToePatch) {
        this.delayToePatch = delayToePatch;
    }

    public int getReverbToePatch() {
        return reverbToePatch;
    }

    public void setReverbToePatch(final int reverbToePatch) {
        this.reverbToePatch = reverbToePatch;
    }

    public int getEqToePatch() {
        return eqToePatch;
    }

    public void setEqToePatch(final int eqToePatch) {
        this.eqToePatch = eqToePatch;
    }

    public int getGainToePatch() {
        return gainToePatch;
    }

    public void setGainToePatch(final int gainToePatch) {
        this.gainToePatch = gainToePatch;
    }

    public TextValue getProgramName() {
        return programName;
    }

    public EffectsStatus getEffectsStatus() {
        return effectsStatus;
    }

    public void setEffectsStatus(final EffectsStatus effectsStatus) {
        this.effectsStatus = effectsStatus;
    }

    public int getSoftRowEffectType(final int softRowPosition) {
        return this.softRow.get(softRowPosition).getEffectType();
    }

    public void setSoftRowEffectType(final int softRowPosition, final int softRowEffectType) {
        if (this.softRow.get(softRowPosition) == null) {
            this.softRow.set(softRowPosition, new SoftRowItem());
        }
        this.softRow.get(softRowPosition).setEffectType(softRowEffectType);
    }

    public int getSoftRowParameter(final int softRowPosition) {
        return this.softRow.get(softRowPosition).getParameter();
    }

    public void setSoftRowParameter(final int softRowPosition, final int softRowParameter) {
        this.softRow.get(softRowPosition).setParameter(softRowParameter);
    }

    public Tempo getTempo() {
        return tempo;
    }

    public void setTempo(final Tempo tempo) {
        this.tempo = tempo;
    }

    public Patch getPatch(final int patchNo) {
        return patches[patchNo - 1];
    }

    public void setPatch(final int patchNo, final Patch patch) {
        this.patches[patchNo - 1] = patch;
    }

    public Knob getKnob() {
        return knob;
    }

    public void setKnob(final Knob knob) {
        this.knob = knob;
    }

    public Lfo getLfo1() {
        return lfo1;
    }

    public void setLfo1(final Lfo lfo1) {
        this.lfo1 = lfo1;
    }

    public Lfo getLfo2() {
        return lfo2;
    }

    public void setLfo2(final Lfo lfo2) {
        this.lfo2 = lfo2;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(final Random random) {
        this.random = random;
    }

    public Ab getAb() {
        return ab;
    }

    public void setAb(final Ab ab) {
        this.ab = ab;
    }

    public EnvelopeGenerator getEnvelopeGenerator() {
        return envelopeGenerator;
    }

    public void setEnvelopeGenerator(final EnvelopeGenerator envelopeGenerator) {
        this.envelopeGenerator = envelopeGenerator;
    }

    public NoiseGate getNoiseGate() {
        return noiseGate;
    }

    public void setNoiseGate(final NoiseGate noiseGate) {
        this.noiseGate = noiseGate;
    }

    public int getBypassState() {
        return bypassState;
    }

    public void setBypassState(final int bypassState) {
        this.bypassState = bypassState;
    }

    public OnOffValue isSpeakerSimulatorEnable() {
        return speakerSimulatorEnable;
    }

    public void setSpeakerSimulatorEnable(final boolean speakerSimulatorEnable) {
        this.speakerSimulatorEnable.setValue(speakerSimulatorEnable);
    }

    public SpeakerSimulatorCabinetValue getSpeakerSimulatorCabinet() {
        return speakerSimulatorCabinet;
    }

    public void setSpeakerSimulatorCabinet(final int speakerSimulatorCabinet) {
        this.speakerSimulatorCabinet.setValue(speakerSimulatorCabinet);
    }

    public SendMix getSendMix() {
        return sendMix;
    }

    public void setSendMix(final SendMix sendMix) {
        this.sendMix = sendMix;
    }

    public PostMix getPostMix() {
        return postMix;
    }

    public void setPostMix(final PostMix postMix) {
        this.postMix = postMix;
    }

    public int getProgramNumber() {
        return programNumber;
    }

    public void setProgramNumber(final int programNumber) {
        this.programNumber = programNumber;
    }

    public DataObject getEffect(final int effectIndex) {
        DataObject dataObject;
        switch (effectIndex) {
            case 0:
                dataObject = getEffect1();
                break;
            case 1:
                dataObject = getEffect2();
                break;
            case 2:
                dataObject = getChorus();
                break;
            case 3:
                dataObject = getDelay();
                break;
            case 4:
                dataObject = getReverb();
                break;
            case 5:
                dataObject = getEq();
                break;
            case 6:
                dataObject = getGain();
                break;
            case 7:
                dataObject = getKnob();
                break;
            case 8:
                dataObject = getLfo1();
                break;
            case 9:
                dataObject = getLfo2();
                break;
            case 10:
                dataObject = getRandom();
                break;
            case 11:
                dataObject = getAb();
                break;
            case 12:
                dataObject = getEnvelopeGenerator();
                break;
            case 15:
                dataObject = getPostMix();
                break;
            case 16:
                dataObject = getSendMix();
                break;
            case 19:
                dataObject = getNoiseGate();
                break;
            case 20:
                dataObject = getTempo();
                break;
            case 24:
                dataObject = getEffectsStatus();
                break;
            default:
                dataObject = null;
        }
        return dataObject;
    }

}
