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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for ProgramPrinter.
 *
 * @author carl
 */
public class ProgramPrinterTest {
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
