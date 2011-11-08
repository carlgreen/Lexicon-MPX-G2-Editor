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
import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.Knob;
import info.carlwithak.mpxg2.model.Lfo;
import info.carlwithak.mpxg2.model.Random;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for ProgramPrinter.
 *
 * @author carl
 */
public class ProgramPrinterTest {

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
