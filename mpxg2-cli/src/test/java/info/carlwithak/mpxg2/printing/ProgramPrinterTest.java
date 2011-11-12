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
import info.carlwithak.mpxg2.model.BeatRate;
import info.carlwithak.mpxg2.model.EnvelopeGenerator;
import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.Knob;
import info.carlwithak.mpxg2.model.Lfo;
import info.carlwithak.mpxg2.model.Patch;
import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.model.Random;
import info.carlwithak.mpxg2.model.effects.algorithms.OneBandMono;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals("Acoustic", ProgramPrinter.printGuitarStyles(program));

        program.setIsBass(true);
        assertEquals("Acoustic, Bass", ProgramPrinter.printGuitarStyles(program));

        program.setIsBlues(true);
        assertEquals("Acoustic, Bass, Blues", ProgramPrinter.printGuitarStyles(program));

        program.setIsClean(true);
        assertEquals("Acoustic, Bass, Blues, Clean", ProgramPrinter.printGuitarStyles(program));

        program.setIsCountry(true);
        assertEquals("Acoustic, Bass, Blues, Clean, Country", ProgramPrinter.printGuitarStyles(program));

        program.setIsJazz(true);
        assertEquals("Acoustic, Bass, Blues, Clean, Country, Jazz", ProgramPrinter.printGuitarStyles(program));

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
        patch.setDestinationMin(0);
        patch.setDestinationMid(0x8000);
        patch.setDestinationMax(24);

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
        patch.setDestinationMin(0);
        patch.setDestinationMid(0x8000);
        patch.setDestinationMax(6);

        Program program = new Program();

        String expected = "    Patch 1:\n      Source: Ctls Knob\n        Min: 0\n        Mid: --\n        Max: 25\n      Destination: Send Level\n        Min: 0\n        Mid: --\n        Max: +6\n";
        String actual = ProgramPrinter.printPatch(program, patch, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPatchParameter_BeatRate() throws PrintException {
        String patchDestinationUnit = ":";
        int parameterValue = 7 + 4 * 256;

        String expected = "7:4";
        String actual = ProgramPrinter.formatPatchParameter(patchDestinationUnit, parameterValue, null, null, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPatchParameter_Frequency() throws PrintException {
        String patchDestinationUnit = "Hz";

        int parameterValue = 10;
        String expected = "10Hz";
        String actual = ProgramPrinter.formatPatchParameter(patchDestinationUnit, parameterValue, null, null, null);
        assertEquals(expected, actual);

        patchDestinationUnit = "100Hz";
        expected = "0.10Hz";
        actual = ProgramPrinter.formatPatchParameter(patchDestinationUnit, parameterValue, null, null, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPatchParameter_Boolean() throws PrintException {
        String patchDestinationUnit = "OnOff";

        int parameterValue = 0;
        String expected = "Off";
        String actual = ProgramPrinter.formatPatchParameter(patchDestinationUnit, parameterValue, null, null, null);
        assertEquals(expected, actual);

        parameterValue = 1;
        expected = "On";
        actual = ProgramPrinter.formatPatchParameter(patchDestinationUnit, parameterValue, null, null, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatPatchParameter_Normal() throws PrintException {
        String patchDestinationUnit = "X";
        int parameterValue = 1;
        String expected = "1X";
        String actual = ProgramPrinter.formatPatchParameter(patchDestinationUnit, parameterValue, null, null, null);
        assertEquals(expected, actual);

        patchDestinationUnit = "-X";
        expected = "+1X";
        actual = ProgramPrinter.formatPatchParameter(patchDestinationUnit, parameterValue, null, null, null);
        assertEquals(expected, actual);
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
        
        String expected = "      Mode: On\n      Rate: 0.60Hz\n      PW: 50%\n      Phase: 0\n      Depth: 100%\n      On Level: 64\n      On Source: none\n";
        String actual = ProgramPrinter.printLfo(lfo);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintRandom() throws PrintException {
        Random random = new Random();
        random.setLow(0);
        random.setHigh(50);
        random.setRate(new BeatRate("Rate", 3, 1));

        String expected = "      Low: 0\n      High: 50\n      Rate: 3:1\n";
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

        String expected = "      Mode: Trigger\n      A Rate: 100\n      B Rate: 10\n      On Level: 64\n      On Source: none\n";
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

        String expected = "      Src1: In\n      Src2: Off\n      A Trim: 17\n      Resp: 100\n";
        String actual = ProgramPrinter.printEnvelopeGenerator(envelopeGenerator);
        assertEquals(expected, actual);
    }

    @Test
    public void testBeatValueToString() {
        assertEquals("eighth", ProgramPrinter.beatValueToString(0));
        assertEquals("dotted quarter", ProgramPrinter.beatValueToString(3));
        assertEquals("2 beats", ProgramPrinter.beatValueToString(4));
        assertEquals("16 beats", ProgramPrinter.beatValueToString(18));
        assertEquals("126 beats", ProgramPrinter.beatValueToString(128));
    }

    @Test
    public void testSpeakerSimulatorCabinetToString() {
        assertEquals("Combo1Brite", ProgramPrinter.speakerSimulatorCabinetToString(0));
        assertEquals("Combo1Norml", ProgramPrinter.speakerSimulatorCabinetToString(1));
        assertEquals("Combo1Dark", ProgramPrinter.speakerSimulatorCabinetToString(3));
        assertEquals("Stack2Warm", ProgramPrinter.speakerSimulatorCabinetToString(14));
    }
}
