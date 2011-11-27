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

package info.carlwithak.mpxg2.sysex.effects.algorithms;

import info.carlwithak.mpxg2.model.effects.algorithms.Overdrive;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class OverdriveParserTest {

    @Test
    public void testParse_PowerChords() {
        byte[] effectParameters = {4, 0, 8, 0, 0, 0, 8, 15, 0, 0, 0, 2, 8, 2, 5, 1, 12, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Overdrive overdrive = OverdriveParser.parse(effectParameters);
        assertEquals(4, (int) overdrive.getLo().getValue());
        assertEquals(8, (int) overdrive.getMid().getValue());
        assertEquals(0, (int) overdrive.getHi().getValue());
        assertEquals(-8, (int) overdrive.getInLevel().getValue());
        assertEquals(0, (int) overdrive.getLoCut().getValue());
        assertEquals(32, (int) overdrive.getFeel().getValue());
        assertEquals(40, (int) overdrive.getDrive().getValue());
        assertEquals(21, (int) overdrive.getTone().getValue());
        assertEquals(44, (int) overdrive.getLevel().getValue());
    }
}
