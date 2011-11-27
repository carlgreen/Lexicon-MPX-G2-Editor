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
        assertEquals(28, (int) chamber.getMix().getValue());
        assertEquals(0, (int) chamber.getLevel().getValue());
        assertEquals(24.0, chamber.getSize().getValue(), 0.01);
        assertTrue(chamber.isLink().getValue());
        assertEquals(22, (int) chamber.getDiff().getValue());
        assertEquals(0, (int) chamber.getPreDelay().getValue());
        assertEquals(6, (int) chamber.getBass().getValue()); // 1.5X is number 6 in list
        assertEquals(47, (int) chamber.getDecay().getValue()); // 1.05s is number 47 in list for this size
        assertEquals(16, (int) chamber.getXovr().getValue()); // 986 is number 16 in list
        assertEquals(34, (int) chamber.getRtHC().getValue()); // 9.3k is number 34 in list
        assertEquals(62, (int) chamber.getShape().getValue());
        assertEquals(120, (int) chamber.getSpred().getValue()); // 42 is number 120 in list for this size
    }

    @Test
    public void testParse_PowerChords() {
        byte[] effectParameters = {3, 2, 0, 0, 0, 3, 1, 0, 13, 2, 2, 5, 5, 0, 3, 2, 15, 0, 4, 2, 14, 3, 8, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Chamber chamber = ChamberParser.parse(effectParameters);
        assertEquals(35, (int) chamber.getMix().getValue());
        assertEquals(0, (int) chamber.getLevel().getValue());
        assertEquals(28.0, chamber.getSize().getValue(), 0.01);
        assertTrue(chamber.isLink().getValue());
        assertEquals(90, (int) chamber.getDiff().getValue());
        assertEquals(82, (int) chamber.getPreDelay().getValue());
        assertEquals(5, (int) chamber.getBass().getValue()); // 1.2X is number 5 in list
        assertEquals(35, (int) chamber.getDecay().getValue()); // 0.73s is number 35 in list
        assertEquals(15, (int) chamber.getXovr().getValue()); // 818 is number 15 in list
        assertEquals(36, (int) chamber.getRtHC().getValue()); // 10.4k is number 36 in list
        assertEquals(62, (int) chamber.getShape().getValue());
        assertEquals(120, (int) chamber.getSpred().getValue()); // 48 is number 120 in list for this size
    }
}
