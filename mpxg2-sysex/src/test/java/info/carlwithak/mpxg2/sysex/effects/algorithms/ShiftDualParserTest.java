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

import info.carlwithak.mpxg2.model.effects.algorithms.ShiftDual;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carl Green
 */
public class ShiftDualParserTest {

    @Test
    public void testParse_PowerChords() {
        byte[] effectParameters = {4, 6, 6, 0, 0, 5, 11, 15, 10, 0, 12, 0, 14, 15, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ShiftDual shiftDual = ShiftDualParser.parse(effectParameters);
        assertEquals(100, (int) shiftDual.getMix().getValue());
        assertEquals(6, (int) shiftDual.getLevel().getValue());
        assertEquals(-1200, shiftDual.getTune1());
        assertEquals(10, shiftDual.getOptimize());
        assertEquals(-500, shiftDual.getTune2());
        assertTrue(shiftDual.isGlide());
    }
}
