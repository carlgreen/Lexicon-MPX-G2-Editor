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

import info.carlwithak.mpxg2.model.effects.algorithms.Wah2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class Wah2ParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {4, 6, 6, 0, 2, 3, 0, 0, 0, 0, 4, 6, 10, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Wah2 wah2 = Wah2Parser.parse(effectParameters);
        assertEquals(100, wah2.getMix());
        assertEquals(6, wah2.getLevel());
        assertEquals(50, wah2.getSweep());
        assertEquals(0, wah2.getBass());
        assertEquals(0, wah2.getType());
        assertEquals(100, wah2.getResponse());
        assertEquals(10, wah2.getGain());
    }
}
