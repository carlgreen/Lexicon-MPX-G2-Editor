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

import info.carlwithak.mpxg2.model.BeatRate;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Carl Green
 */
public class DelayDualParserTest {

    @Test
    public void testParse_PowerChords() throws ParseException {
        byte[] effectParameters = {9, 1, 0, 0, 3, 0, 4, 0, 1, 0, 4, 0, 3, 0, 1, 0, 0, 0, 0, 0, 14, 12, 2, 3, 10, 0, 3, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DelayDual delayDual = DelayDualParser.parse(effectParameters);
        assertEquals(25, delayDual.getMix());
        assertEquals(0, delayDual.getLevel());
        assertEquals(new BeatRate(3, 4), delayDual.getTime1());
        assertEquals(new BeatRate(4, 3), delayDual.getTime2());
        assertEquals(0, delayDual.getLevel1());
        assertEquals(0, delayDual.getLevel2());
        assertEquals(-50, delayDual.getPan1());
        assertEquals(50, delayDual.getPan2());
        assertEquals(10, delayDual.getFeedback1());
        assertEquals(3, delayDual.getInsert());
        assertEquals(10, delayDual.getFeedback2());
        assertEquals(0, delayDual.getXFbk1());
        assertEquals(0, delayDual.getXFbk2());
        assertFalse(delayDual.isClear());
    }

    @Test
    public void testParse() throws ParseException {
        byte[] effectParameters = {3, 1, 0, 0, 1, 0, 1, 0, 1, 0, 4, 0, 3, 0, 1, 0, 0, 0, 0, 0, 14, 12, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DelayDual delayDual = DelayDualParser.parse(effectParameters);
        assertEquals(19, delayDual.getMix());
        assertEquals(0, delayDual.getLevel());
        assertEquals(new BeatRate(1, 1), delayDual.getTime1());
        assertEquals(new BeatRate(4, 3), delayDual.getTime2());
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
