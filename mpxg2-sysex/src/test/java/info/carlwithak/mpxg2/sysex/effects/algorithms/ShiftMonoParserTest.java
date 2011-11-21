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

import info.carlwithak.mpxg2.model.effects.algorithms.ShiftMono;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carl Green
 */
public class ShiftMonoParserTest {

    @Test
    public void testParse_OctaveFuzz() {
        byte[] effectParameters = {4, 6, 6, 10, 0, 5, 11, 15, 2, 3, 1, 0, 15, 15, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ShiftMono shiftMono = ShiftMonoParser.parse(effectParameters);
        assertEquals(100, (int) shiftMono.getMix().getValue());
        assertEquals(-90, (int) shiftMono.getLevel().getValue()); // Off
        assertEquals(-1200, shiftMono.getTune());
        assertEquals(50, shiftMono.getOptimize());
        assertTrue(shiftMono.isGlide());
    }
}
