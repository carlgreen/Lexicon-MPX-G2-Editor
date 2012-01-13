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

import info.carlwithak.mpxg2.model.Ab;
import info.carlwithak.mpxg2.model.EnvelopeGenerator;
import info.carlwithak.mpxg2.model.Knob;
import info.carlwithak.mpxg2.model.Lfo;
import info.carlwithak.mpxg2.model.Patch;
import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.model.Random;
import info.carlwithak.mpxg2.model.effects.Chorus;
import info.carlwithak.mpxg2.model.effects.Delay;
import info.carlwithak.mpxg2.model.effects.Effect;
import info.carlwithak.mpxg2.model.effects.Eq;
import info.carlwithak.mpxg2.model.effects.Gain;
import info.carlwithak.mpxg2.model.effects.Reverb;
import info.carlwithak.mpxg2.model.effects.algorithms.OneBandMono;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalVol;
import info.carlwithak.mpxg2.model.parameters.BeatRate;
import info.carlwithak.mpxg2.model.parameters.FrequencyRate;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for ProgramPrinter.
 *
 * @author carl
 */
public class ProgramPrinterTest {
    @Test
    public void testPrintGuitarStyles() {
        Program program = new Program();

        assertEquals("", ProgramPrinter.printGuitarStyles(program));

        program.setIsAcoustic(true);
        program.setIsBass(true);
        program.setIsBlues(true);
        program.setIsClean(true);
        program.setIsCountry(true);
        program.setIsJazz(true);
        program.setIsRock(true);

        assertEquals("Acoustic, Bass, Blues, Clean, Country, Jazz, Rock", ProgramPrinter.printGuitarStyles(program));
    }

    @Test
    public void testPrintEffectTypes() {
        Program program = new Program();

        assertEquals("", ProgramPrinter.printEffectTypes(program));

        program.setIsChorus(true);
        program.setIsDelay(true);
        program.setIsDistortion(true);
        program.setIsEq(true);
        program.setIsFlanger(true);
        program.setIsGain(true);
        program.setIsMod(true);
        program.setIsOverdrive(true);
        program.setIsPhaser(true);
        program.setIsPitch(true);
        program.setIsReverb(true);
        program.setIsSpeakerSim(true);
        program.setIsWah(true);

        assertEquals("Chorus, Delay, Distortion, EQ, Flanger, Gain, Mod, Overdrive, Phaser, Pitch, Reverb, Speaker Sim, Wah", ProgramPrinter.printEffectTypes(program));
    }

    @Test
    public void testPrintApplicationTypes() {
        Program program = new Program();

        assertEquals("", ProgramPrinter.printApplicationTypes(program));

        program.setIsPrePost(true);
        program.setIsStandAlone(true);
        program.setIsInline(true);

        assertEquals("Amp Input + FX Loop, Stand alone, Amp Input Only", ProgramPrinter.printApplicationTypes(program));
    }

    @Test
    public void testPrintProgram() throws PrintException {
        StringBuilder sb = new StringBuilder();
        ProgramPrinter.printProgram(sb, null, null, null, 0);
        assertEquals("", sb.toString());

        sb = new StringBuilder();
        // TODO would be good to mock the effect here
        PedalVol pedalVol = new PedalVol();
        pedalVol.setMix(0);
        pedalVol.setLevel(0);
        OnOffValue effect1Status = new OnOffValue("FX1  Byp");
        effect1Status.setValue(true);
        ProgramPrinter.printProgram(sb, "Effect1", pedalVol, effect1Status, 2);
        assertThat(sb.toString(), containsString("  Effect1: Pedal Vol (On)\n    Toe Switch: on=bypass"));
    }

    @Test
    public void testPrintSoftrow_Knob() throws PrintException {
        Knob knob = new Knob();

        Program program = new Program();
        program.setSoftRowEffectType(0, 7);
        program.setSoftRowParameter(0, 0);
        program.setKnob(knob);

        String expected = "    1: Knob Value\n";
        String actual = ProgramPrinter.printSoftRow(program, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPatch_Knob() throws PrintException {
        OneBandMono oneBandMono = new OneBandMono();

        Patch patch = new Patch();
        patch.setSource(3);
        patch.setSourceMin(0);
        patch.setSourceMax(25);
        patch.setDestinationEffect(5);
        patch.setDestinationParameter(2);
        GenericValue<Integer> destinationMin = new GenericValue<Integer>("Min", "dB", -72, 24);
        destinationMin.setValue(0);
        patch.setDestinationMin(destinationMin);
        GenericValue<Integer> destinationMid = new GenericValue<Integer>("Mid", "dB", -72, 24);
        destinationMid.setValue(null);
        patch.setDestinationMid(destinationMid);
        GenericValue<Integer> destinationMax = new GenericValue<Integer>("Max", "dB", -72, 24);
        destinationMax.setValue(24);
        patch.setDestinationMax(destinationMax);

        Knob knob = new Knob();

        Program program = new Program();
        program.setEq(oneBandMono);
        program.setKnob(knob);

        String expected = "    Patch 1:\n      Source: Ctls Knob\n        Min: 0\n        Mid: --\n        Max: 25\n      Destination: Eq Gain\n        Min: 0dB\n        Mid: --\n        Max: +24dB\n";
        String actual = ProgramPrinter.printPatch(program, patch, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPatch_toSendLevel() throws PrintException {
        Patch patch = new Patch();
        patch.setSource(3);
        patch.setSourceMin(0);
        patch.setSourceMax(25);
        patch.setDestinationEffect(16);
        patch.setDestinationParameter(0);
        GenericValue<Integer> destinationMin = new GenericValue<Integer>("Min", "", -56, 0);
        destinationMin.setValue(0);
        patch.setDestinationMin(destinationMin);
        GenericValue<Integer> destinationMid = new GenericValue<Integer>("Mid", "", -56, 0);
        destinationMid.setValue(null);
        patch.setDestinationMid(destinationMid);
        GenericValue<Integer> destinationMax = new GenericValue<Integer>("Max", "", -56, 0);
        destinationMax.setValue(6);
        patch.setDestinationMax(destinationMax);

        Program program = new Program();

        String expected = "    Patch 1:\n      Source: Ctls Knob\n        Min: 0\n        Mid: --\n        Max: 25\n      Destination: Send Level\n        Min: 0\n        Mid: --\n        Max: +6\n";
        String actual = ProgramPrinter.printPatch(program, patch, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetEffectParameter() {
        Program program = new Program();
        for (int i = 0; i <= 13; i++) {
            assertNull(ProgramPrinter.getEffectParameter(program, i, 0));
        }
        Parameter parameter = mock(Parameter.class);
        program.setEffect1((Effect) when(mock(Effect.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 0, 0));
        program.setEffect2((Effect) when(mock(Effect.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 1, 0));
        program.setChorus((Chorus) when(mock(Chorus.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 2, 0));
        program.setDelay((Delay) when(mock(Delay.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 3, 0));
        program.setReverb((Reverb) when(mock(Reverb.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 4, 0));
        program.setEq((Eq) when(mock(Eq.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 5, 0));
        program.setGain((Gain) when(mock(Gain.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 6, 0));
        program.setKnob((Knob) when(mock(Knob.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 7, 0));
        program.setLfo1((Lfo) when(mock(Lfo.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 8, 0));
        program.setLfo2((Lfo) when(mock(Lfo.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 9, 0));
        program.setRandom((Random) when(mock(Random.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 10, 0));
        program.setAb((Ab) when(mock(Ab.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 11, 0));
        program.setEnvelopeGenerator((EnvelopeGenerator) when(mock(EnvelopeGenerator.class).getParameter(any(Integer.class))).thenReturn(parameter).getMock());
        assertNotNull(ProgramPrinter.getEffectParameter(program, 12, 0));
    }

    @Test
    public void testPrintKnob() {
        Knob knob = new Knob();
        knob.setValue(50);
        knob.setLow(0);
        knob.setHigh(100);
        knob.setName("Delay Adj");

        String expected = "      Value: 50\n      Low: 0\n      High: 100\n      Name: Delay Adj\n";
        String actual = ProgramPrinter.printKnob(knob);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintLfo() throws PrintException {
        Lfo lfo = new Lfo();
        lfo.setMode(1);
        lfo.setRate(new FrequencyRate("Rate", 0.6));
        lfo.setPulseWidth(50);
        lfo.setPhase(0);
        lfo.setDepth(100);
        lfo.setOnLevel(64);
        lfo.setOnSource(0);

        String expected = "      Mode: On\n      Rate: 0.60Hz\n      PW: 50%\n      Phase: 0\n      Depth: 100%\n      OnLvl: 64\n      OnSrc: None\n";
        String actual = ProgramPrinter.printLfo(lfo);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintRandom() throws PrintException {
        Random random = new Random();
        random.setLow(0);
        random.setHigh(50);
        random.setRate(new BeatRate("Rate", 3, 1));

        String expected = "      RndLo: 0\n      RndHi: 50\n      Rate: 3:1\n";
        String actual = ProgramPrinter.printRandom(random);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAb() throws PrintException {
        Ab ab = new Ab();
        ab.setMode(0);
        ab.setARate(100);
        ab.setBRate(10);
        ab.setOnLevel(64);
        ab.setOnSource(0);

        String expected = "      Mode: Trigger\n      ARate: 100\n      BRate: 10\n      OnLvl: 64\n      OnSrc: None\n";
        String actual = ProgramPrinter.printAb(ab);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintEnvelopeGenerator() throws PrintException {
        EnvelopeGenerator envelopeGenerator = new EnvelopeGenerator();
        envelopeGenerator.setSrc1(1);
        envelopeGenerator.setSrc2(0);
        envelopeGenerator.setATrim(17);
        envelopeGenerator.setResponse(100);

        String expected = "      Src1: In\n      Src2: Off\n      ATrim: 17\n      Resp: 100\n";
        String actual = ProgramPrinter.printEnvelopeGenerator(envelopeGenerator);
        assertEquals(expected, actual);
    }

}
