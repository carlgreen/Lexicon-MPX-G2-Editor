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

import info.carlwithak.mpxg2.model.effects.algorithms.Chamber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carl Green
 */
public class ChamberParserTest {

    @Test
    public void testParse_Cordovox() {
        byte[] effectParameters = {12, 1, 0, 0, 8, 2, 1, 0, 11, 0, 0, 0, 6, 0, 15, 2, 0, 1, 2, 2, 14, 3, 8, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Chamber chamber = ChamberParser.parse(effectParameters);
        assertEquals(28, chamber.getMix());
        assertEquals(0, chamber.getLevel());
        assertEquals(24.0, chamber.getSize(), 0.01);
        assertTrue(chamber.isLink());
        assertEquals(22, chamber.getDiff());
        assertEquals(0, chamber.getPreDelay());
        assertEquals(6, chamber.getBass()); // 1.5X is number 6 in list
        assertEquals(47, chamber.getDecay()); // 1.05s is number 47 in list for this size
        assertEquals(16, chamber.getXovr()); // 986 is number 16 in list
        assertEquals(34, chamber.getRtHC()); // 9.3k is number 34 in list
        assertEquals(62, chamber.getShape());
        assertEquals(120, chamber.getSpred()); // 42 is number 120 in list for this size
    }

    @Test
    public void testParse_PowerChords() {
        byte[] effectParameters = {3, 2, 0, 0, 0, 3, 1, 0, 13, 2, 2, 5, 5, 0, 3, 2, 15, 0, 4, 2, 14, 3, 8, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Chamber chamber = ChamberParser.parse(effectParameters);
        assertEquals(35, chamber.getMix());
        assertEquals(0, chamber.getLevel());
        assertEquals(28.0, chamber.getSize(), 0.01);
        assertTrue(chamber.isLink());
        assertEquals(90, chamber.getDiff());
        assertEquals(82, chamber.getPreDelay());
        assertEquals(5, chamber.getBass()); // 1.2X is number 5 in list
        assertEquals(35, chamber.getDecay()); // 0.73s is number 35 in list
        assertEquals(15, chamber.getXovr()); // 818 is number 15 in list
        assertEquals(36, chamber.getRtHC()); // 10.4k is number 36 in list
        assertEquals(62, chamber.getShape());
        assertEquals(120, chamber.getSpred()); // 48 is number 120 in list for this size
    }
}
