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
    public void testParse_TremoWah() {
        byte[] effectParameters = {4, 1, 0, 0, 2, 6, 1, 0, 8, 2, 9, 1, 5, 0, 9, 2, 15, 0, 15, 1, 14, 6, 13, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Hall hall = HallParser.parse(effectParameters);
        assertEquals(20, (int) hall.getMix().getValue());
        assertEquals(0, (int) hall.getLevel().getValue());
        assertEquals(53.0, hall.getSize().getValue(), 0.01);
        assertTrue(hall.isLink().getValue());
        assertEquals(80, (int) hall.getDiff().getValue());
        assertEquals(25, (int) hall.getPreDelay().getValue());
        assertEquals(5, (int) hall.getBass().getValue()); // 1.2X is number 5 in list
        assertEquals(41, (int) hall.getDecay().getValue()); // 1.67s is number 41 in list
        assertEquals(15, (int) hall.getXovr().getValue()); // 818 is number 15 in list
        assertEquals(31, (int) hall.getRtHC().getValue()); // 7.9k is number 31 in list for this size
        assertEquals(110, (int) hall.getShape().getValue());
        assertEquals(125, (int) hall.getSpred().getValue()); // 89 is number 125 in list for this size
    }
}
