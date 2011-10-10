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

import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Carl Green
 */
public class EchoDualParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {2, 0, 1, 0, 4, 0, 4, 0, 1, 0, 2, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 3, 0, 1, 0, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertEquals(2, echoDual.getMix());
        assertEquals(1, echoDual.getLevel());
        assertEquals(4, echoDual.getTime1Echoes());
        assertEquals(4, echoDual.getTime1Beat());
        assertEquals(2, echoDual.getTime2Echoes());
        assertEquals(1, echoDual.getTime2Beat());
        assertEquals(0, echoDual.getLevel1());
        assertEquals(0, echoDual.getLevel2());
        assertEquals(1, echoDual.getFeedback1());
        assertEquals(3, echoDual.getInsert());
        assertEquals(1, echoDual.getFeedback2());
        assertEquals(20, echoDual.getDamp1());
        assertEquals(20, echoDual.getDamp2());
        assertFalse(echoDual.isClear());
    }
}
