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
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carl Green
 */
public class PlateParserTest {

    @Test
    public void testParse_GuitarSolo() {
        byte[] effectParameters = {4, 6, 6, 0, 5, 2, 1, 0, 1, 2, 9, 10, 5, 0, 2, 3, 0, 1, 13, 2, 4, 2, 14, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Plate plate = PlateParser.parse(effectParameters);
        assertEquals(100, (int) plate.getMix().getValue());
        assertEquals(6, (int) plate.getLevel().getValue());
        assertEquals(22.5, plate.getSize().getValue(), 0.01);
        assertTrue(plate.isLink().getValue());
        assertEquals(66, (int) plate.getDiff().getValue());
        assertEquals(169, (int) plate.getPreDelay().getValue());
        assertEquals(5, (int) plate.getBass().getValue()); // 1.2X is number 5 in list
        assertEquals(50, (int) plate.getDecay().getValue()); // 1.30s is number 50 in list
        assertEquals(16, (int) plate.getXovr().getValue()); // 986 is number 16 in list
        assertEquals(45, (int) plate.getRtHC().getValue()); // 19.4k is number 45 in list for this size
        assertEquals(36, (int) plate.getShape().getValue());
        assertEquals(222, (int) plate.getSpred().getValue()); // 73 is number 222 in list for this size
    }

    @Test
    public void testParse_VybeFlange() {
        byte[] effectParameters = {12, 1, 0, 0, 9, 1, 1, 0, 13, 2, 10, 0, 0, 0, 0, 0, 0, 1, 1, 2, 10, 3, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Plate plate = PlateParser.parse(effectParameters);
        assertEquals(28, (int) plate.getMix().getValue());
        assertEquals(0, (int) plate.getLevel().getValue());
        assertEquals(16.5, plate.getSize().getValue(), 0.01);
        assertTrue(plate.isLink().getValue());
        assertEquals(90, (int) plate.getDiff().getValue());
        assertEquals(10, (int) plate.getPreDelay().getValue());
        assertEquals(0, (int) plate.getBass().getValue()); // 0.2X is number 0 in list
        assertEquals(0, (int) plate.getDecay().getValue()); // 0.09s is number 0 in list for this size
        assertEquals(16, (int) plate.getXovr().getValue()); // 986 is number 16 in list
        assertEquals(33, (int) plate.getRtHC().getValue()); // 8.8k is number 33 in list
        assertEquals(58, (int) plate.getShape().getValue());
        assertEquals(254, (int) plate.getSpred().getValue()); // 65 is number 254 in list for this size
    }
}
