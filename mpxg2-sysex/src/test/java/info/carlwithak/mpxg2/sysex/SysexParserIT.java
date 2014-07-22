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
import info.carlwithak.mpxg2.model.EffectsStatus;
import info.carlwithak.mpxg2.model.EnvelopeGenerator;
import info.carlwithak.mpxg2.model.Knob;
import info.carlwithak.mpxg2.model.Lfo;
import info.carlwithak.mpxg2.model.NoiseGate;
import info.carlwithak.mpxg2.model.Patch;
import info.carlwithak.mpxg2.model.PostMix;
import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.model.Random;
import info.carlwithak.mpxg2.model.RoutingData;
import info.carlwithak.mpxg2.model.SendMix;
import info.carlwithak.mpxg2.model.Tempo;
import info.carlwithak.mpxg2.model.effects.algorithms.Ambience;
import info.carlwithak.mpxg2.model.effects.algorithms.AutoPan;
import info.carlwithak.mpxg2.model.effects.algorithms.BlueComp;
import info.carlwithak.mpxg2.model.effects.algorithms.Chamber;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusAlgorithm;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusVolumeDual;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.DetuneDual;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoMono;
import info.carlwithak.mpxg2.model.effects.algorithms.EqPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.FlangerStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.Hall;
import info.carlwithak.mpxg2.model.effects.algorithms.Overdrive;
import info.carlwithak.mpxg2.model.effects.algorithms.Panner;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah1;
import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;
import info.carlwithak.mpxg2.model.effects.algorithms.ShiftDual;
import info.carlwithak.mpxg2.model.effects.algorithms.SweepFilter;
import info.carlwithak.mpxg2.model.effects.algorithms.Tone;
import info.carlwithak.mpxg2.model.effects.algorithms.TremoloMono;
import info.carlwithak.mpxg2.model.effects.algorithms.UniVybe;
import info.carlwithak.mpxg2.model.effects.algorithms.VolumeMono;
import info.carlwithak.mpxg2.model.effects.algorithms.Wah2;
import info.carlwithak.mpxg2.model.parameters.BeatRate;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.test.IsValue;
import java.io.File;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsBeat.beat;
import static info.carlwithak.mpxg2.test.IsFrequency.frequency;
import static info.carlwithak.mpxg2.test.IsOnOff.off;
import static info.carlwithak.mpxg2.test.IsOnOff.on;
import static info.carlwithak.mpxg2.test.IsText.text;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carl Green
 */
public class SysexParserIT {

    @Test
    @SuppressWarnings("unchecked")
    public void testParseG2Blue() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("001_G2_Blue.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof UniVybe);
        assertTrue(program.getEffect2() instanceof PedalWah1);
        assertTrue(program.getChorus() instanceof ChorusPedalVol);
        assertTrue(program.getDelay() instanceof EchoDual);
        assertTrue(program.getReverb() instanceof Ambience);
        assertNull(program.getEq()); // no eq
        assertTrue(program.getGain() instanceof Screamer);

        // effect types
        assertTrue(program.isChorus());
        assertTrue(program.isDelay());
        assertFalse(program.isDistortion());
        assertFalse(program.isEq());
        assertFalse(program.isFlanger());
        assertTrue(program.isGain());
        assertFalse(program.isMod());
        assertFalse(program.isOverdrive());
        assertFalse(program.isPhaser());
        assertFalse(program.isPitch());
        assertTrue(program.isReverb());
        assertFalse(program.isSpeakerSim());
        assertTrue(program.isWah());
        assertTrue(program.isPrePost());
        assertFalse(program.isStandAlone());
        assertFalse(program.isInline());

        // guitar styles
        assertFalse(program.isAcoustic());
        assertFalse(program.isBass());
        assertTrue(program.isBlues());
        assertTrue(program.isClean());
        assertFalse(program.isCountry());
        assertTrue(program.isJazz());
        assertTrue(program.isRock());

        RoutingData routing = program.getRouting0();
        assertEquals(8, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting1();
        assertEquals(0, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting2();
        assertEquals(1, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting3();
        assertEquals(6, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting4();
        assertEquals(2, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting5();
        assertEquals(3, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting6();
        assertEquals(4, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting7();
        assertEquals(5, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting8();
        assertEquals(7, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());

        assertEquals(2, program.getEffect1ToePatch());
        assertEquals(1, program.getEffect2ToePatch());
        assertEquals(2, program.getChorusToePatch());
        assertEquals(0, program.getDelayToePatch());
        assertEquals(1, program.getReverbToePatch());
        assertEquals(0, program.getEqToePatch());
        assertEquals(0, program.getGainToePatch());

        assertTrue(program.getEffect1() instanceof UniVybe);
        assertTrue(program.getEffect2() instanceof PedalWah1);
        assertTrue(program.getChorus() instanceof ChorusPedalVol);
        assertTrue(program.getDelay() instanceof EchoDual);
        assertTrue(program.getReverb() instanceof Ambience);
        assertNull(program.getEq());
        assertTrue(program.getGain() instanceof Screamer);

        assertThat(program.getProgramName(), is(text("G2 Blue")));

        EffectsStatus effectsStatus = program.getEffectsStatus();
        assertThat(effectsStatus.getEffect1On(), is(on()));
        assertThat(effectsStatus.getEffect2On(), is(off()));
        assertThat(effectsStatus.getChorusOn(), is(on()));
        assertThat(effectsStatus.getDelayOn(), is(on()));
        assertThat(effectsStatus.getReverbOn(), is(off()));
        assertThat(effectsStatus.getEqOn(), is(off()));
        assertThat(effectsStatus.getGainOn(), is(off()));
        assertThat(effectsStatus.getInsertOn(), is(on()));

        assertEquals(6, program.getSoftRowEffectType(0));
        assertEquals(3, program.getSoftRowParameter(0));
        assertEquals(6, program.getSoftRowEffectType(1));
        assertEquals(4, program.getSoftRowParameter(1));
        assertEquals(6, program.getSoftRowEffectType(2));
        assertEquals(5, program.getSoftRowParameter(2));
        assertEquals(0, program.getSoftRowEffectType(3));
        assertEquals(2, program.getSoftRowParameter(3));
        assertEquals(3, program.getSoftRowEffectType(4));
        assertEquals(2, program.getSoftRowParameter(4));
        assertEquals(4, program.getSoftRowEffectType(5));
        assertEquals(0, program.getSoftRowParameter(5));
        assertEquals(4, program.getSoftRowEffectType(6));
        assertEquals(2, program.getSoftRowParameter(6));
        assertEquals(4, program.getSoftRowEffectType(7));
        assertEquals(5, program.getSoftRowParameter(7));
        assertEquals(4, program.getSoftRowEffectType(8));
        assertEquals(6, program.getSoftRowParameter(8));
        assertEquals(4, program.getSoftRowEffectType(9));
        assertEquals(7, program.getSoftRowParameter(9));

        Tempo tempo = program.getTempo();
        assertThat(tempo.getRate(), is(value(120)));
        assertThat(tempo.getSource(), is(value(0)));
        assertThat(tempo.getBeatValue(), is(value(2))); // quater note
        assertThat(tempo.getTapSource(), is(value(0)));
        assertThat(tempo.getTapAverage(), is(value(2)));
        assertThat(tempo.getTapSourceLevel(), is(value(64)));

        Patch patch1 = program.getPatch(1);
        assertThat(patch1.source, is(value(16))); // Ctls A/B, see SourceValue.SOURCES
        assertThat(patch1.getSourceMin(), is(0));
        assertNull(patch1.getSourceMid());
        assertThat(patch1.getSourceMax(), is(127));
        assertThat(patch1.getDestinationEffectIndex(), is(3));
        assertEquals(0, patch1.getDestinationParameter());
        assertThat(((GenericValue<Integer>) patch1.getDestinationMin()), is(value(2)));
        assertThat(((GenericValue<Integer>) patch1.getDestinationMid()), is(IsValue.<Integer>value(null)));
        assertThat(((GenericValue<Integer>) patch1.getDestinationMax()), is(value(30)));
        Patch patch2 = program.getPatch(2);
        assertThat(patch2.source, is(value(16))); // Ctls A/B, see SourceValue.SOURCES
        assertThat(patch2.getSourceMin(), is(0));
        assertNull(patch2.getSourceMid());
        assertThat(patch2.getSourceMax(), is(127));
        assertThat(patch2.getDestinationEffectIndex(), is(3));
        assertEquals(3, patch2.getDestinationParameter());
        assertThat((BeatRate) patch2.getDestinationMin(), is(beat(4, 1)));
        assertThat((BeatRate) patch2.getDestinationMid(), is(beat(null, null)));
        assertThat((BeatRate) patch2.getDestinationMax(), is(beat(4, 2)));
        Patch patch3 = program.getPatch(3);
        assertThat(patch3.source, is(value(16))); // Ctls A/B, see SourceValue.SOURCES
        assertThat(patch3.getSourceMin(), is(0));
        assertNull(patch3.getSourceMid());
        assertThat(patch3.getSourceMax(), is(127));
        assertThat(patch3.getDestinationEffectIndex(), is(3));
        assertEquals(6, patch3.getDestinationParameter());
        assertThat(((GenericValue<Integer>) patch3.getDestinationMin()), is(value(1)));
        assertThat(((GenericValue<Integer>) patch3.getDestinationMid()), is(IsValue.<Integer>value(null)));
        assertThat(((GenericValue<Integer>) patch3.getDestinationMax()), is(value(15)));
        Patch patch4 = program.getPatch(4);
        assertThat(patch4.source, is(value(16))); // Ctls A/B, see SourceValue.SOURCES
        assertThat(patch4.getSourceMin(), is(0));
        assertNull(patch4.getSourceMid());
        assertThat(patch4.getSourceMax(), is(127));
        assertThat(patch4.getDestinationEffectIndex(), is(3));
        assertEquals(7, patch4.getDestinationParameter());
        assertThat(((GenericValue<Integer>) patch4.getDestinationMin()), is(value(1)));
        assertThat(((GenericValue<Integer>) patch4.getDestinationMid()), is(IsValue.<Integer>value(null)));
        assertThat(((GenericValue<Integer>) patch4.getDestinationMax()), is(value(4)));
        Patch patch5 = program.getPatch(5);
        assertThat(patch5.source, is(value(157))); // MIDI Toe, see SourceValue.SOURCES
        assertThat(patch5.getSourceMin(), is(0));
        assertNull(patch5.getSourceMid());
        assertThat(patch5.getSourceMax(), is(127));
        assertThat(patch5.getDestinationEffectIndex(), is(16));
        assertEquals(0, patch5.getDestinationParameter());
        assertThat(((GenericValue<Integer>) patch5.getDestinationMin()), is(value(0)));
        assertThat(((GenericValue<Integer>) patch5.getDestinationMid()), is(IsValue.<Integer>value(null)));
        assertThat(((GenericValue<Integer>) patch5.getDestinationMax()), is(value(6)));

        Knob knob = program.getKnob();
        assertThat(knob.getValue(), is(value(50)));
        assertThat(knob.getLow(), is(value(0)));
        assertThat(knob.getHigh(), is(value(100)));
        assertThat(knob.getName(), is(text("Delay Adj")));

        Lfo lfo1 = program.getLfo1();
        assertThat(lfo1.getMode(), is(value(1)));
        assertThat(lfo1.getRate(), is(frequency(0.60)));
        assertThat(lfo1.getPulseWidth(), is(value(50)));
        assertThat(lfo1.getPhase(), is(value(0)));
        assertThat(lfo1.getDepth(), is(value(100)));
        assertThat(lfo1.getOnLevel(), is(value(64)));
        assertThat(lfo1.getOnSource(), is(value(0)));

        Lfo lfo2 = program.getLfo2();
        assertThat(lfo2.getMode(), is(value(1)));
        assertThat(lfo2.getRate(), is(frequency(0.92)));
        assertThat(lfo2.getPulseWidth(), is(value(50)));
        assertThat(lfo2.getPhase(), is(value(0)));
        assertThat(lfo2.getDepth(), is(value(100)));
        assertThat(lfo2.getOnLevel(), is(value(64)));
        assertThat(lfo2.getOnSource(), is(value(0)));

        Random random = program.getRandom();
        assertThat(random.getLow(), is(value(0)));
        assertThat(random.getHigh(), is(value(127)));
        assertThat(random.getRate(), is(frequency(1.0)));

        Ab ab = program.getAb();
        assertThat(ab.getMode(), is(value(0)));
        assertThat(ab.getARate(), is(value(100)));
        assertThat(ab.getBRate(), is(value(100)));
        assertThat(ab.getOnLevel(), is(value(64)));
        assertThat(ab.getOnSource(), is(value(0)));

        EnvelopeGenerator envelopeGenerator = program.getEnvelopeGenerator();
        assertThat(envelopeGenerator.getSrc1(), is(value(0)));
        assertThat(envelopeGenerator.getSrc2(), is(value(0)));
        assertThat(envelopeGenerator.getATrim(), is(value(100)));
        assertThat(envelopeGenerator.getResponse(), is(value(64)));

        NoiseGate noiseGate = program.getNoiseGate();
        assertThat(noiseGate.getEnable(), is(value(1)));
        assertThat(noiseGate.getSend(), is(on()));
        assertThat(noiseGate.getThreshold(), is(value(-83)));
        assertThat(noiseGate.getAttenuation(), is(value(-85)));
        assertThat(noiseGate.getOffset(), is(value(-3)));
        assertThat(noiseGate.getATime(), is(value(0)));
        assertThat(noiseGate.getHTime(), is(value(100)));
        assertThat(noiseGate.getRTime(), is(value(100)));
        assertThat(noiseGate.getDelay(), is(value(0)));
        

        assertEquals(0, program.getBypassState());

        assertThat(program.isSpeakerSimulatorEnable(), is(off()));
        assertThat(program.getSpeakerSimulatorCabinet(), is(value(1)));

        SendMix sendMix = program.getSendMix();
        assertThat(sendMix.getSendLevel(), is(value(0)));
        assertThat(sendMix.getSendBypassLevel(), is(value(0)));
        PostMix postMix = program.getPostMix();
        assertThat(postMix.getPostMix(), is(value(100)));
        assertThat(postMix.getPostLevel(), is(value(0)));
        assertThat(postMix.getPostBypassLevel(), is(value(0)));

        assertEquals(301, program.getProgramNumber()); // 301 is the active program
    }

    @Test
    public void testParseGuitarSolo() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("002_Guitar_Solo.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof DetuneDual);
        assertTrue(program.getEffect2() instanceof Panner);
        assertNull(program.getChorus()); // no chorus
        assertTrue(program.getDelay() instanceof EchoDual);
        assertTrue(program.getReverb() instanceof Plate);
        assertTrue(program.getGain() instanceof Screamer);

        RoutingData routing = program.getRouting0();
        assertEquals(8, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting1();
        assertEquals(5, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting2();
        assertEquals(2, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting3();
        assertEquals(6, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting4();
        assertEquals(0, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(3, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting5();
        assertEquals(3, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(1, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting6();
        assertEquals(4, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting7();
        assertEquals(1, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(2, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting8();
        assertEquals(7, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
    }

    @Test
    public void testParseCordovox() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("003_Cordovox.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof AutoPan);
        assertTrue(program.getEffect2() instanceof AutoPan);
        assertTrue(program.getChorus() instanceof ChorusAlgorithm);
        assertTrue(program.getDelay() instanceof EchoDual);
        assertTrue(program.getReverb() instanceof Chamber);
        assertTrue(program.getEq() instanceof EqPedalVol);
        assertTrue(program.getGain() instanceof Tone);

        RoutingData routing = program.getRouting0();
        assertEquals(8, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting1();
        assertEquals(5, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting2();
        assertEquals(6, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting3();
        assertEquals(2, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(3, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting4();
        assertEquals(0, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(4, routing.getLowerInputConnection());
        assertEquals(1, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting5();
        assertEquals(1, routing.getEffectId());
        assertEquals(3, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting6();
        assertEquals(3, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting7();
        assertEquals(4, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(1, routing.getPathType());
        routing = program.getRouting8();
        assertEquals(7, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(2, routing.getRouting());
        assertEquals(1, routing.getPathType());
    }

    @Test
    public void testParsePowerChords() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("004_Power_Chords.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof ShiftDual);
        assertTrue(program.getDelay() instanceof DelayDual);
        assertTrue(program.getReverb() instanceof Chamber);
        assertTrue(program.getGain() instanceof Overdrive);
    }

    @Test
    public void testParseVybeFlange() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("005_Vybe_Flange.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof UniVybe);
        assertTrue(program.getEffect2() instanceof AutoPan);
        assertTrue(program.getChorus() instanceof FlangerStereo);
        assertTrue(program.getDelay() instanceof EchoMono);
        assertTrue(program.getReverb() instanceof Plate);
        assertTrue(program.getEq() instanceof EqPedalVol);
        assertTrue(program.getGain() instanceof Screamer);
    }

    @Test
    public void testParseAnotherBrick() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("006_AnotherBrick.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect2() instanceof BlueComp);

        assertThat(program.getProgramName(), is(text("AnotherBrick")));
    }

    @Test
    public void testParseEnvFilterLP() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("007_EnvFilter_LP.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof SweepFilter);

        assertThat(program.getProgramName(), is(text("EnvFilter LP")));
    }

    @Test
    public void testParseTremoWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("008_TremoWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof TremoloMono);
        assertTrue(program.getEffect2() instanceof Wah2);
        assertTrue(program.getChorus() instanceof ChorusVolumeDual);
        assertTrue(program.getDelay() instanceof DelayStereo);
        assertTrue(program.getReverb() instanceof Hall);

        assertThat(program.getProgramName(), is(text("TremoWah")));

        Knob knob = program.getKnob();
        assertThat(knob.getValue(), is(value(50)));
        assertThat(knob.getLow(), is(value(0)));
        assertThat(knob.getHigh(), is(value(100)));
        assertThat(knob.getName(), is(text("Delay Adj")));

        Lfo lfo1 = program.getLfo1();
        assertThat(lfo1.getMode(), is(value(1)));
        assertThat(lfo1.getRate(), is(beat(1, 4)));
        assertThat(lfo1.getPulseWidth(), is(value(50)));
        assertThat(lfo1.getPhase(), is(value(0)));
        assertThat(lfo1.getDepth(), is(value(100)));
        assertThat(lfo1.getOnLevel(), is(value(64)));
        assertThat(lfo1.getOnSource(), is(value(0)));

        Lfo lfo2 = program.getLfo2();
        assertThat(lfo2.getMode(), is(value(1)));
        assertThat(lfo2.getRate(), is(beat(1, 4)));
        assertThat(lfo2.getPulseWidth(), is(value(50)));
        assertThat(lfo2.getPhase(), is(value(0)));
        assertThat(lfo2.getDepth(), is(value(100)));
        assertThat(lfo2.getOnLevel(), is(value(64)));
        assertThat(lfo2.getOnSource(), is(value(0)));

        Random random = program.getRandom();
        assertThat(random.getLow(), is(value(0)));
        assertThat(random.getHigh(), is(value(127)));
        assertThat(random.getRate(), is(frequency(1.0)));

        Ab ab = program.getAb();
        assertThat(ab.getMode(), is(value(0)));
        assertThat(ab.getARate(), is(value(100)));
        assertThat(ab.getBRate(), is(value(100)));
        assertThat(ab.getOnLevel(), is(value(64)));
        assertThat(ab.getOnSource(), is(value(0)));

        EnvelopeGenerator envelopeGenerator = program.getEnvelopeGenerator();
        assertThat(envelopeGenerator.getSrc1(), is(value(0)));
        assertThat(envelopeGenerator.getSrc2(), is(value(0)));
        assertThat(envelopeGenerator.getATrim(), is(value(100)));
        assertThat(envelopeGenerator.getResponse(), is(value(64)));
    }

    @Test
    public void testParseJamMan() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("009_JamMan.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("JamMan")));
    }

    @Test
    public void testParseVHRig() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("010_VH_Rig.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("VH Rig")));
    }

    @Test
    public void testParseRotaryCab() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("011_Rotary_Cab.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Rotary Cab")));
    }

    @Test
    public void testParseLittleWing() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("012_Little_Wing.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Little Wing")));
    }

    @Test
    public void testParseTechnoChords() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("013_TechnoChords.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("TechnoChords")));
    }

    @Test
    public void testParsePedalSwell() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("014_Pedal_Swell.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Pedal Swell")));
    }

    @Test
    public void testParseSlideComp() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("015_Slide_Comp.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Slide Comp")));
    }

    @Test
    public void testParseKissTheSky() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("016_Kiss_the_Sky.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Kiss the Sky")));
    }

    @Test
    public void testParseUnchained() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("017_Unchained.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Unchained")));
    }

    @Test
    public void testParseStomp() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("018_Stomp!.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Stomp!")));
    }

    @Test
    public void testParseOctaWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("019_OctaWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("OctaWah")));
    }

    @Test
    public void testParseWahUni() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("020_Wah_&_Uni.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Wah & Uni")));
    }

    @Test
    public void testParseToeWahFlng() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("021_ToeWah_Flng.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("ToeWah/Flng")));
    }

    @Test
    public void testParseToeWahPhas() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("022_ToeWah_Phas.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("ToeWah/Phas")));
    }

    @Test
    public void testParseToeWahChrs() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("023_ToeWah_Chrs.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("ToeWah/Chrs")));
    }

    @Test
    public void testParseToeWahAero() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("024_ToeWah_Aero.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("ToeWah/Aero")));
    }

    @Test
    public void testParseToeWahUni() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("025_ToeWah_Uni.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("ToeWah/Uni")));
    }

    @Test
    public void testParseWahFlange() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("026_Wah_&_Flange.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Wah & Flange")));
    }

    @Test
    public void testParseWahPhaser() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("027_Wah_&_Phaser.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Wah & Phaser")));
    }

    @Test
    public void testParseWahChorus() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("028_Wah_&_Chorus.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Wah & Chorus")));
    }

    @Test
    public void testParseWahAero() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("029_Wah_&_Aero.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Wah & Aero")));
    }

    @Test
    public void testParseChrsDlyRvb() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("030_ChrsDlyRvb+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("ChrsDlyRvb+")));
    }

    @Test
    public void testParseTSChorus() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("031_TS_Chorus+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("TS Chorus+")));
    }

    @Test
    public void testParseTSDelay() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("032_TS_Delay+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("TS Delay+")));
    }

    @Test
    public void testParseTSChrsDly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("033_TS_ChrsDly+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("TS ChrsDly+")));
    }

    @Test
    public void testParseTSReverb() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("034_TS_Reverb+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("TS Reverb+")));
    }

    @Test
    public void testParseTSChrsRvb() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("035_TS_ChrsRvb+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("TS ChrsRvb+")));
    }

    @Test
    public void testParseCompChorus() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("036_CompChorus+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("CompChorus+")));
    }

    @Test
    public void testParseCompDelay() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("037_CompDelay+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("CompDelay+")));
    }

    @Test
    public void testParseCompChrsDly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("038_CompChrsDly+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("CompChrsDly+")));
    }

    @Test
    public void testParseCompChrsRvb() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("039_CompChrsRvb+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("CompChrsRvb+")));
    }

    @Test
    public void testParsePitchCascade() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("040_PitchCascade.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("PitchCascade")));
    }

    @Test
    public void testParsePdlOctaves() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("041_Pdl_Octaves.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Pdl Octaves")));
    }

    @Test
    public void testParsePdl2nds() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("042_Pdl_2nds.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Pdl 2nds")));
    }

    @Test
    public void testParsePdl2_3_b3_3() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("043_Pdl_2-3_b3-3.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Pdl 2~3 b3~3")));
    }

    @Test
    public void testParsePdl2_3_3_4() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("044_Pdl_2-3_3-4.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Pdl 2~3  3~4")));
    }

    @Test
    public void testParsePdl4_5_5_6() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("045_Pdl_4-5_5-6.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Pdl 4~5 5~6")));
    }

    @Test
    public void testParseOctaves() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("046_Octaves.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Octaves")));
    }

    @Test
    public void testParse4ths5ths() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("047_4ths_&_5ths.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("4ths & 5ths")));
    }

    @Test
    public void testParseEMajMin3() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("048_E_Maj_Min_3.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("E Maj/Min 3")));
    }

    @Test
    public void testParseEDorMix3() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("049_E_Dor_Mix_3.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("E Dor/Mix 3")));
    }

    @Test
    public void testParseDetuneTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("050_Detune+Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Detune+Trem")));
    }

    @Test
    public void testParseSquareTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("051_Square_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Square Trem")));
    }

    @Test
    public void testParseTremAutoWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("052_Trem_AutoWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Trem~AutoWah")));
    }

    @Test
    public void testParseEnvTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("053_Env_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Env Trem")));
    }

    @Test
    public void testParseEnvAutoWahs() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("054_Env_AutoWahs.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Env AutoWahs")));
    }

    @Test
    public void testParseChaosDance() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("055_Chaos_Dance.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Chaos Dance")));
    }

    @Test
    public void testParseRoundTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("056_Round_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Round Trem")));
    }

    @Test
    public void testParseTapAutoWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("057_Tap_AutoWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Tap AutoWah")));
    }

    @Test
    public void testParseVerbolo() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("058_Verbolo.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Verbolo")));
    }

    @Test
    public void testParseDynaChrsTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("059_DynaChrsTrem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("DynaChrsTrem")));
    }

    @Test
    public void testParseUnivybe() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("060_Univybe.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Univybe")));
    }

    @Test
    public void testParseOctaveFuzz() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("061_Octave_Fuzz.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Octave Fuzz")));
    }

    @Test
    public void testParsePhaser() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("062_Phaser.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Phaser")));
    }

    @Test
    public void testParseEnvFilter() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("063_EnvFilter.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("EnvFilter")));
    }

    @Test
    public void testParseCWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("064_C-Wah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("C-Wah")));
    }

    @Test
    public void testParseBlueComp() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("065_Blue_Comp.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Blue Comp")));
    }

    @Test
    public void testParseVintageTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("066_Vintage_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Vintage Trem")));
    }

    @Test
    public void testParseIPSTapeSlap() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("067_IPS_TapeSlap.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("IPS TapeSlap")));
    }

    @Test
    public void testParseSpaceEcho() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("068_Space_Echo.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Space Echo")));
    }

    @Test
    public void testParseOctabuzz() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("069_Octabuzz.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Octabuzz")));
    }

    @Test
    public void testParseOrangePhase() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("070_OrangePhase.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("OrangePhase")));
    }

    @Test
    public void testParseGrayFlange() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("071_Gray_Flange.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Gray Flange")));
    }

    @Test
    public void testParseRedComp() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("072_Red_Comp.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Red Comp")));
    }

    @Test
    public void testParseSHPedal() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("073_S_H_Pedal.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("S/H Pedal")));
    }

    @Test
    public void testParseVWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("074_V-Wah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("V-Wah")));
    }

    @Test
    public void testParseModernTrem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("075_Modern_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Modern Trem")));
    }

    @Test
    public void testParseTapEcho() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("076_Tap_Echo.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Tap Echo")));
    }

    @Test
    public void testParseEnvWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("077_Env_Wah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Env Wah")));
    }

    @Test
    public void testParseStereoChorus() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("078_StereoChorus.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("StereoChorus")));
    }

    @Test
    public void testParseClasscDetune() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("079_ClasscDetune.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("ClasscDetune")));
    }

    @Test
    public void testParseToneBoost() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("080_Tone_Boost.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Tone Boost")));
    }

    @Test
    public void testParseCrunchBoost() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("081_Crunch_Boost.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Crunch Boost")));
    }

    @Test
    public void testParseTSLead() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("082_TS_Lead.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("TS Lead")));
    }

    @Test
    public void testParseTSBoost() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("083_TS_Boost.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("TS Boost")));
    }

    @Test
    public void testParseODLead() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("084_OD_Lead.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("OD Lead")));
    }

    @Test
    public void testParseODBoost() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("085_OD_Boost.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("OD Boost")));
    }

    @Test
    public void testParseDistLead() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("086_Dist_Lead.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Dist Lead")));
    }

    @Test
    public void testParseDistBoost() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("087_Dist_Boost.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Dist Boost")));
    }

    @Test
    public void testParseFuzz1() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("088_Fuzz_1.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Fuzz 1")));
    }

    @Test
    public void testParseFuzz2() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("089_Fuzz_2.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Fuzz 2")));
    }

    @Test
    public void testParseJamChrs() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("090_Jam_Chrs+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Jam Chrs+")));
    }

    @Test
    public void testParseJam1Uni() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("091_Jam_1__Uni+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Jam 1  Uni+")));
    }

    @Test
    public void testParseJam1SH() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("092_Jam_1_S&H+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Jam 1 S&H+")));
    }

    @Test
    public void testParseJam1Env() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("093_Jam_1_Env+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Jam 1 Env+")));
    }

    @Test
    public void testParseJam1Cordovox() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("094_Jam1Cordovox.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Jam1Cordovox")));
    }

    @Test
    public void testParseJam2Flange() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("095_Jam_2_Flange.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Jam 2 Flange")));
    }

    @Test
    public void testParseJam2Phase() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("096_Jam_2_Phase.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Jam 2 Phase")));
    }

    @Test
    public void testParseJam2Pitch() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("097_Jam_2_Pitch+.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Jam 2 Pitch+")));
    }

    @Test
    public void testParseJam2Trem() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("098_Jam_2_Trem.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Jam 2 Trem")));
    }

    @Test
    public void testParseJam2AutoWah() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("099_Jam2AutoWah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Jam2AutoWah")));
    }

    @Test
    public void testParseVintageRig_InputOnly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("100_VintageRig.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("VintageRig")));
    }

    @Test
    public void testParsePdlOctaves_InputOnly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("101_Pdl_Octaves.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Pdl Octaves")));
    }

    @Test
    public void testParseTechnoChords_InputOnly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("102_TechnoChords.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("TechnoChords")));
    }

    @Test
    public void testParseCordovox_InputOnly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("103_Cordovox.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Cordovox")));
    }

    @Test
    public void testParseAnalogEcho_InputOnly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("104_Analog__Echo.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Analog  Echo")));
    }

    @Test
    public void testParseWahUni_InputOnly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("105_Wah_&_Uni.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Wah & Uni")));
    }

    @Test
    public void testParseEnvFilterLP_InputOnly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("106_EnvFilter_LP.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("EnvFilter LP")));
    }

    @Test
    public void testParseInfiniteEcho_InputOnly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("107_InfiniteEcho.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("InfiniteEcho")));
    }

    @Test
    public void testParseFuzzWah_InputOnly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("108_Fuzz_Wah.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("Fuzz Wah")));
    }

    @Test
    public void testParseJamMan_InputOnly() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("109_JamMan.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertThat(program.getProgramName(), is(text("JamMan")));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testParseCleanSlate() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("250_Clean_Slate.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        // effect types
        assertFalse(program.isChorus());
        assertTrue(program.isDelay());
        assertFalse(program.isDistortion());
        assertFalse(program.isEq());
        assertFalse(program.isFlanger());
        assertTrue(program.isGain());
        assertFalse(program.isMod());
        assertFalse(program.isOverdrive());
        assertFalse(program.isPhaser());
        assertTrue(program.isPitch());
        assertFalse(program.isReverb());
        assertFalse(program.isSpeakerSim());
        assertFalse(program.isWah());
        assertFalse(program.isPrePost());
        assertTrue(program.isStandAlone());
        assertFalse(program.isInline());

        // guitar styles
        assertFalse(program.isAcoustic());
        assertFalse(program.isBass());
        assertTrue(program.isBlues());
        assertTrue(program.isClean());
        assertFalse(program.isCountry());
        assertTrue(program.isJazz());
        assertTrue(program.isRock());

        RoutingData routing = program.getRouting0();
        assertEquals(8, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting1();
        assertEquals(0, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting2();
        assertEquals(1, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting3();
        assertEquals(6, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting4();
        assertEquals(5, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting5();
        assertEquals(2, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting6();
        assertEquals(3, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting7();
        assertEquals(4, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting8();
        assertEquals(7, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());

        assertEquals(0, program.getEffect1ToePatch());
        assertEquals(0, program.getEffect2ToePatch());
        assertEquals(0, program.getChorusToePatch());
        assertEquals(0, program.getDelayToePatch());
        assertEquals(0, program.getReverbToePatch());
        assertEquals(0, program.getEqToePatch());
        assertEquals(0, program.getGainToePatch());

        assertNull(program.getEffect1());
        assertNull(program.getEffect2());
        assertNull(program.getChorus());
        assertNull(program.getDelay());
        assertNull(program.getReverb());
        assertNull(program.getEq());
        assertNull(program.getGain());

        assertThat(program.getProgramName(), is(text("Clean Slate")));

        EffectsStatus effectsStatus = program.getEffectsStatus();
        assertThat(effectsStatus.getEffect1On(), is(off()));
        assertThat(effectsStatus.getEffect2On(), is(off()));
        assertThat(effectsStatus.getChorusOn(), is(off()));
        assertThat(effectsStatus.getDelayOn(), is(off()));
        assertThat(effectsStatus.getReverbOn(), is(off()));
        assertThat(effectsStatus.getEqOn(), is(off()));
        assertThat(effectsStatus.getGainOn(), is(off()));
        assertThat(effectsStatus.getInsertOn(), is(on()));

        Tempo tempo = program.getTempo();
        assertThat(tempo.getRate(), is(value(120)));
        assertThat(tempo.getSource(), is(value(0)));
        assertThat(tempo.getBeatValue(), is(value(2))); // quater note
        assertThat(tempo.getTapSource(), is(value(0)));
        assertThat(tempo.getTapAverage(), is(value(2)));
        assertThat(tempo.getTapSourceLevel(), is(value(64)));

        Patch patch1 = program.getPatch(1);
        assertThat(patch1.source, is(value(0)));
        assertThat(patch1.getSourceMin(), is(0));
        assertNull(patch1.getSourceMid());
        assertThat(patch1.getSourceMax(), is(127));
        assertNull(patch1.getDestinationEffectIndex());
        assertEquals(255, patch1.getDestinationParameter());
        assertThat((GenericValue<Integer>) patch1.getDestinationMin(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch1.getDestinationMid(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch1.getDestinationMax(), is(nullValue()));
        Patch patch2 = program.getPatch(2);
        assertThat(patch2.source, is(value(0)));
        assertThat(patch2.getSourceMin(), is(0));
        assertNull(patch2.getSourceMid());
        assertThat(patch2.getSourceMax(), is(127));
        assertNull(patch2.getDestinationEffectIndex());
        assertEquals(255, patch2.getDestinationParameter());
        assertThat((GenericValue<Integer>) patch2.getDestinationMin(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch2.getDestinationMid(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch2.getDestinationMax(), is(nullValue()));
        Patch patch3 = program.getPatch(3);
        assertThat(patch3.source, is(value(0)));
        assertThat(patch3.getSourceMin(), is(0));
        assertNull(patch3.getSourceMid());
        assertThat(patch3.getSourceMax(), is(127));
        assertNull(patch3.getDestinationEffectIndex());
        assertEquals(255, patch3.getDestinationParameter());
        assertThat((GenericValue<Integer>) patch3.getDestinationMin(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch3.getDestinationMid(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch3.getDestinationMax(), is(nullValue()));
        Patch patch4 = program.getPatch(4);
        assertThat(patch4.source, is(value(0)));
        assertThat(patch4.getSourceMin(), is(0));
        assertNull(patch4.getSourceMid());
        assertThat(patch4.getSourceMax(), is(127));
        assertNull(patch4.getDestinationEffectIndex());
        assertEquals(255, patch4.getDestinationParameter());
        assertThat((GenericValue<Integer>) patch4.getDestinationMin(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch4.getDestinationMid(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch4.getDestinationMax(), is(nullValue()));
        Patch patch5 = program.getPatch(5);
        assertThat(patch5.source, is(value(0)));
        assertThat(patch5.getSourceMin(), is(0));
        assertNull(patch5.getSourceMid());
        assertThat(patch5.getSourceMax(), is(127));
        assertNull(patch5.getDestinationEffectIndex());
        assertEquals(255, patch5.getDestinationParameter());
        assertThat((GenericValue<Integer>) patch5.getDestinationMin(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch5.getDestinationMid(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch5.getDestinationMax(), is(nullValue()));

        Knob knob = program.getKnob();
        assertThat(knob.getValue(), is(value(50)));
        assertThat(knob.getLow(), is(value(0)));
        assertThat(knob.getHigh(), is(value(100)));
        assertThat(knob.getName(), is(text("Delay Adj")));

        Lfo lfo1 = program.getLfo1();
        assertThat(lfo1.getMode(), is(value(1)));
        assertThat(lfo1.getRate(), is(frequency(0.60)));
        assertThat(lfo1.getPulseWidth(), is(value(50)));
        assertThat(lfo1.getPhase(), is(value(0)));
        assertThat(lfo1.getDepth(), is(value(100)));
        assertThat(lfo1.getOnLevel(), is(value(64)));
        assertThat(lfo1.getOnSource(), is(value(0)));

        Lfo lfo2 = program.getLfo2();
        assertThat(lfo2.getMode(), is(value(1)));
        assertThat(lfo2.getRate(), is(frequency(0.92)));
        assertThat(lfo2.getPulseWidth(), is(value(50)));
        assertThat(lfo2.getPhase(), is(value(0)));
        assertThat(lfo2.getDepth(), is(value(100)));
        assertThat(lfo2.getOnLevel(), is(value(64)));
        assertThat(lfo2.getOnSource(), is(value(0)));

        Random random = program.getRandom();
        assertThat(random.getLow(), is(value(0)));
        assertThat(random.getHigh(), is(value(127)));
        assertThat(random.getRate(), is(frequency(1.0)));

        Ab ab = program.getAb();
        assertThat(ab.getMode(), is(value(0)));
        assertThat(ab.getARate(), is(value(100)));
        assertThat(ab.getBRate(), is(value(100)));
        assertThat(ab.getOnLevel(), is(value(64)));
        assertThat(ab.getOnSource(), is(value(0)));

        EnvelopeGenerator envelopeGenerator = program.getEnvelopeGenerator();
        assertThat(envelopeGenerator.getSrc1(), is(value(0)));
        assertThat(envelopeGenerator.getSrc2(), is(value(0)));
        assertThat(envelopeGenerator.getATrim(), is(value(100)));
        assertThat(envelopeGenerator.getResponse(), is(value(64)));

        NoiseGate noiseGate = program.getNoiseGate();
        assertThat(noiseGate.getEnable(), is(value(0)));
        assertThat(noiseGate.getSend(), is(off()));
        assertThat(noiseGate.getThreshold(), is(value(-83)));
        assertThat(noiseGate.getAttenuation(), is(value(-80)));
        assertThat(noiseGate.getOffset(), is(value(-3)));
        assertThat(noiseGate.getATime(), is(value(0)));
        assertThat(noiseGate.getHTime(), is(value(100)));
        assertThat(noiseGate.getRTime(), is(value(100)));
        assertThat(noiseGate.getDelay(), is(value(0)));

        assertEquals(0, program.getBypassState());

        assertThat(program.isSpeakerSimulatorEnable(), is(off()));
        assertThat(program.getSpeakerSimulatorCabinet(), is(value(1)));

        SendMix sendMix = program.getSendMix();
        assertThat(sendMix.getSendLevel(), is(value(0)));
        assertThat(sendMix.getSendBypassLevel(), is(value(0)));
        PostMix postMix = program.getPostMix();
        assertThat(postMix.getPostMix(), is(value(100)));
        assertThat(postMix.getPostLevel(), is(value(0)));
        assertThat(postMix.getPostBypassLevel(), is(value(0)));

        assertEquals(301, program.getProgramNumber()); // 301 is the active program
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testParseUnityGain() throws Exception {
        File preset = new File(this.getClass().getClassLoader().getResource("249_Unity_Gain.syx").toURI());
        Program program = SysexParser.parsePrograms(preset).get(0);

        assertTrue(program.getEffect1() instanceof VolumeMono);

        // effect types
        assertFalse(program.isChorus());
        assertTrue(program.isDelay());
        assertFalse(program.isDistortion());
        assertFalse(program.isEq());
        assertFalse(program.isFlanger());
        assertTrue(program.isGain());
        assertFalse(program.isMod());
        assertFalse(program.isOverdrive());
        assertFalse(program.isPhaser());
        assertTrue(program.isPitch());
        assertFalse(program.isReverb());
        assertFalse(program.isSpeakerSim());
        assertFalse(program.isWah());
        assertFalse(program.isPrePost());
        assertTrue(program.isStandAlone());
        assertFalse(program.isInline());

        // guitar styles
        assertFalse(program.isAcoustic());
        assertFalse(program.isBass());
        assertTrue(program.isBlues());
        assertTrue(program.isClean());
        assertFalse(program.isCountry());
        assertTrue(program.isJazz());
        assertTrue(program.isRock());

        RoutingData routing = program.getRouting0();
        assertEquals(8, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting1();
        assertEquals(0, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting2();
        assertEquals(1, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting3();
        assertEquals(6, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting4();
        assertEquals(5, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting5();
        assertEquals(2, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting6();
        assertEquals(3, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting7();
        assertEquals(4, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());
        routing = program.getRouting8();
        assertEquals(7, routing.getEffectId());
        assertEquals(0, routing.getUpperInputConnection());
        assertEquals(0, routing.getLowerInputConnection());
        assertEquals(0, routing.getRouting());
        assertEquals(0, routing.getPathType());

        assertEquals(0, program.getEffect1ToePatch());
        assertEquals(0, program.getEffect2ToePatch());
        assertEquals(0, program.getChorusToePatch());
        assertEquals(0, program.getDelayToePatch());
        assertEquals(0, program.getReverbToePatch());
        assertEquals(0, program.getEqToePatch());
        assertEquals(0, program.getGainToePatch());

        assertTrue(program.getEffect1() instanceof VolumeMono);
        assertNull(program.getEffect2());
        assertNull(program.getChorus());
        assertNull(program.getDelay());
        assertNull(program.getReverb());
        assertNull(program.getEq());
        assertNull(program.getGain());

        assertThat(program.getProgramName(), is(text("Unity Gain")));

        EffectsStatus effectsStatus = program.getEffectsStatus();
        assertThat(effectsStatus.getEffect1On(), is(on()));
        assertThat(effectsStatus.getEffect2On(), is(off()));
        assertThat(effectsStatus.getChorusOn(), is(off()));
        assertThat(effectsStatus.getDelayOn(), is(off()));
        assertThat(effectsStatus.getReverbOn(), is(off()));
        assertThat(effectsStatus.getEqOn(), is(off()));
        assertThat(effectsStatus.getGainOn(), is(off()));
        assertThat(effectsStatus.getInsertOn(), is(on()));

        Tempo tempo = program.getTempo();
        assertThat(tempo.getRate(), is(value(170)));
        assertThat(tempo.getSource(), is(value(0)));
        assertThat(tempo.getBeatValue(), is(value(2))); // quater note
        assertThat(tempo.getTapSource(), is(value(0)));
        assertThat(tempo.getTapAverage(), is(value(2)));
        assertThat(tempo.getTapSourceLevel(), is(value(64)));

        Patch patch1 = program.getPatch(1);
        assertThat(patch1.source, is(value(0)));
        assertThat(patch1.getSourceMin(), is(0));
        assertNull(patch1.getSourceMid());
        assertThat(patch1.getSourceMax(), is(127));
        assertNull(patch1.getDestinationEffectIndex());
        assertEquals(255, patch1.getDestinationParameter());
        assertThat((GenericValue<Integer>) patch1.getDestinationMin(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch1.getDestinationMid(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch1.getDestinationMax(), is(nullValue()));
        Patch patch2 = program.getPatch(2);
        assertThat(patch2.source, is(value(0)));
        assertThat(patch2.getSourceMin(), is(0));
        assertNull(patch2.getSourceMid());
        assertThat(patch2.getSourceMax(), is(127));
        assertNull(patch2.getDestinationEffectIndex());
        assertEquals(255, patch2.getDestinationParameter());
        assertThat((GenericValue<Integer>) patch2.getDestinationMin(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch2.getDestinationMid(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch2.getDestinationMax(), is(nullValue()));
        Patch patch3 = program.getPatch(3);
        assertThat(patch3.source, is(value(0)));
        assertThat(patch3.getSourceMin(), is(0));
        assertNull(patch3.getSourceMid());
        assertThat(patch3.getSourceMax(), is(127));
        assertNull(patch3.getDestinationEffectIndex());
        assertEquals(255, patch3.getDestinationParameter());
        assertThat((GenericValue<Integer>) patch3.getDestinationMin(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch3.getDestinationMid(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch3.getDestinationMax(), is(nullValue()));
        Patch patch4 = program.getPatch(4);
        assertThat(patch4.source, is(value(0)));
        assertThat(patch4.getSourceMin(), is(0));
        assertNull(patch4.getSourceMid());
        assertThat(patch4.getSourceMax(), is(127));
        assertNull(patch4.getDestinationEffectIndex());
        assertEquals(255, patch4.getDestinationParameter());
        assertThat((GenericValue<Integer>) patch4.getDestinationMin(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch4.getDestinationMid(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch4.getDestinationMax(), is(nullValue()));
        Patch patch5 = program.getPatch(5);
        assertThat(patch5.source, is(value(0)));
        assertThat(patch5.getSourceMin(), is(0));
        assertNull(patch5.getSourceMid());
        assertThat(patch5.getSourceMax(), is(127));
        assertNull(patch5.getDestinationEffectIndex());
        assertEquals(255, patch5.getDestinationParameter());
        assertThat((GenericValue<Integer>) patch5.getDestinationMin(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch5.getDestinationMid(), is(nullValue()));
        assertThat((GenericValue<Integer>) patch5.getDestinationMax(), is(nullValue()));

        Knob knob = program.getKnob();
        assertThat(knob.getValue(), is(value(50)));
        assertThat(knob.getLow(), is(value(0)));
        assertThat(knob.getHigh(), is(value(100)));
        assertThat(knob.getName(), is(text("Delay Adj")));

        Lfo lfo1 = program.getLfo1();
        assertThat(lfo1.getMode(), is(value(1)));
        assertThat(lfo1.getRate(), is(frequency(0.60)));
        assertThat(lfo1.getPulseWidth(), is(value(50)));
        assertThat(lfo1.getPhase(), is(value(0)));
        assertThat(lfo1.getDepth(), is(value(100)));
        assertThat(lfo1.getOnLevel(), is(value(64)));
        assertThat(lfo1.getOnSource(), is(value(0)));

        Lfo lfo2 = program.getLfo2();
        assertThat(lfo2.getMode(), is(value(1)));
        assertThat(lfo2.getRate(), is(frequency(0.92)));
        assertThat(lfo2.getPulseWidth(), is(value(50)));
        assertThat(lfo2.getPhase(), is(value(0)));
        assertThat(lfo2.getDepth(), is(value(100)));
        assertThat(lfo2.getOnLevel(), is(value(64)));
        assertThat(lfo2.getOnSource(), is(value(0)));

        Random random = program.getRandom();
        assertThat(random.getLow(), is(value(0)));
        assertThat(random.getHigh(), is(value(127)));
        assertThat(random.getRate(), is(frequency(1.0)));

        Ab ab = program.getAb();
        assertThat(ab.getMode(), is(value(0)));
        assertThat(ab.getARate(), is(value(100)));
        assertThat(ab.getBRate(), is(value(100)));
        assertThat(ab.getOnLevel(), is(value(64)));
        assertThat(ab.getOnSource(), is(value(0)));

        EnvelopeGenerator envelopeGenerator = program.getEnvelopeGenerator();
        assertThat(envelopeGenerator.getSrc1(), is(value(0)));
        assertThat(envelopeGenerator.getSrc2(), is(value(0)));
        assertThat(envelopeGenerator.getATrim(), is(value(100)));
        assertThat(envelopeGenerator.getResponse(), is(value(64)));

        NoiseGate noiseGate = program.getNoiseGate();
        assertThat(noiseGate.getEnable(), is(value(0)));
        assertThat(noiseGate.getSend(), is(off()));
        assertThat(noiseGate.getThreshold(), is(value(-83)));
        assertThat(noiseGate.getAttenuation(), is(value(-80)));
        assertThat(noiseGate.getOffset(), is(value(-3)));
        assertThat(noiseGate.getATime(), is(value(0)));
        assertThat(noiseGate.getHTime(), is(value(100)));
        assertThat(noiseGate.getRTime(), is(value(100)));
        assertThat(noiseGate.getDelay(), is(value(0)));

        assertEquals(0, program.getBypassState());

        assertThat(program.isSpeakerSimulatorEnable(), is(off()));
        assertThat(program.getSpeakerSimulatorCabinet(), is(value(1)));

        SendMix sendMix = program.getSendMix();
        assertThat(sendMix.getSendLevel(), is(value(0)));
        assertThat(sendMix.getSendBypassLevel(), is(value(0)));
        PostMix postMix = program.getPostMix();
        assertThat(postMix.getPostMix(), is(value(100)));
        assertThat(postMix.getPostLevel(), is(value(0)));
        assertThat(postMix.getPostBypassLevel(), is(value(0)));

        assertEquals(301, program.getProgramNumber()); // 301 is the active program
    }
}
