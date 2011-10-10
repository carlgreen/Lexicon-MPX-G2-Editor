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

import info.carlwithak.mpxg2.model.effects.algorithms.Hall;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carl Green
 */
public class HallParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {4, 1, 0, 0, 2, 6, 1, 0, 8, 2, 9, 1, 5, 0, 9, 2, 15, 0, 15, 1, 14, 6, 13, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Hall hall = HallParser.parse(effectParameters);
        assertEquals(20, hall.getMix());
        assertEquals(0, hall.getLevel());
        assertEquals(53.0, hall.getSize(), 0.01);
        assertTrue(hall.isLink());
        assertEquals(80, hall.getDiff());
        assertEquals(25, hall.getPreDelay());
        assertEquals(5, hall.getBass()); // 1.2X is number 5 in list
        assertEquals(41, hall.getDecay()); // 1.67s is number 41 in list
        assertEquals(15, hall.getXovr()); // 818 is number 15 in list
        assertEquals(31, hall.getRtHC()); // 7.9k is number 31 in list for this size
        assertEquals(110, hall.getShape());
        assertEquals(125, hall.getSpred()); // 89 is number 125 in list for this size
    }
}
