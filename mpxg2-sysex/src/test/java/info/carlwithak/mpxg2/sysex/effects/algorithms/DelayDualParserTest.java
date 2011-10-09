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

import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Carl Green
 */
public class DelayDualParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {3, 1, 0, 0, 1, 0, 1, 0, 1, 0, 4, 0, 3, 0, 1, 0, 0, 0, 0, 0, 14, 12, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DelayDual delayDual = DelayDualParser.parse(effectParameters);
        assertEquals(19, delayDual.getMix());
        assertEquals(0, delayDual.getLevel());
        assertEquals(1, delayDual.getTime1Echoes());
        assertEquals(1, delayDual.getTime1Beat());
        assertEquals(4, delayDual.getTime2Echoes());
        assertEquals(3, delayDual.getTime2Beat());
        assertEquals(0, delayDual.getLevel1());
        assertEquals(0, delayDual.getLevel2());
        assertEquals(-50, delayDual.getPan1());
        assertEquals(50, delayDual.getPan2());
        assertEquals(0, delayDual.getFeedback1());
        assertEquals(3, delayDual.getInsert());
        assertEquals(0, delayDual.getFeedback2());
        assertEquals(0, delayDual.getXFbk1());
        assertEquals(0, delayDual.getXFbk2());
        assertFalse(delayDual.isClear());
    }
}
