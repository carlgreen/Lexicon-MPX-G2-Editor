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

import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class PlateParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {4, 6, 6, 0, 5, 2, 1, 0, 1, 2, 9, 10, 5, 0, 2, 3, 0, 1, 13, 2, 4, 2, 14, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Plate plate = PlateParser.parse(effectParameters);
        assertEquals(100, plate.getMix());
        assertEquals(6, plate.getLevel());
        assertEquals(22.5, plate.getSize(), 0.01);
        assertEquals(1, plate.getLink());
        assertEquals(66, plate.getDiff());
        assertEquals(169, plate.getPreDelay());
        assertEquals(5, plate.getBass()); // 1.2X is number 5 in list
        assertEquals(50, plate.getDecay()); // 1.30s is number 50 in list
        assertEquals(16, plate.getXovr()); // 986 is number 16 in list
        assertEquals(45, plate.getRtHC()); // 19.4k is number 45 in list for this size
        assertEquals(36, plate.getShape());
        assertEquals(222, plate.getSpred()); // 73 is number 222 in list for this size
    }
}
