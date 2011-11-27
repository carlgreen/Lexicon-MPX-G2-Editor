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
        assertEquals(25, (int) delayDual.getMix().getValue());
        assertEquals(0, (int) delayDual.getLevel().getValue());
        assertEquals(new BeatRate("Time1", 3, 4), delayDual.getTime1());
        assertEquals(new BeatRate("Time2", 4, 3), delayDual.getTime2());
        assertEquals(0, (int) delayDual.getLevel1().getValue());
        assertEquals(0, (int) delayDual.getLevel2().getValue());
        assertEquals(-50, (int) delayDual.getPan1().getValue());
        assertEquals(50, (int) delayDual.getPan2().getValue());
        assertEquals(10, (int) delayDual.getFeedback1().getValue());
        assertEquals(3, delayDual.getInsert());
        assertEquals(10, (int) delayDual.getFeedback2().getValue());
        assertEquals(0, (int) delayDual.getXFbk1().getValue());
        assertEquals(0, (int) delayDual.getXFbk2().getValue());
        assertFalse(delayDual.isClear().getValue());
    }

    @Test
    public void testParse() throws ParseException {
        byte[] effectParameters = {3, 1, 0, 0, 1, 0, 1, 0, 1, 0, 4, 0, 3, 0, 1, 0, 0, 0, 0, 0, 14, 12, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DelayDual delayDual = DelayDualParser.parse(effectParameters);
        assertEquals(19, (int) delayDual.getMix().getValue());
        assertEquals(0, (int) delayDual.getLevel().getValue());
        assertEquals(new BeatRate("Time1", 1, 1), delayDual.getTime1());
        assertEquals(new BeatRate("Time2", 4, 3), delayDual.getTime2());
        assertEquals(0, (int) delayDual.getLevel1().getValue());
        assertEquals(0, (int) delayDual.getLevel2().getValue());
        assertEquals(-50, (int) delayDual.getPan1().getValue());
        assertEquals(50, (int) delayDual.getPan2().getValue());
        assertEquals(0, (int) delayDual.getFeedback1().getValue());
        assertEquals(3, delayDual.getInsert());
        assertEquals(0, (int) delayDual.getFeedback2().getValue());
        assertEquals(0, (int) delayDual.getXFbk1().getValue());
        assertEquals(0, (int) delayDual.getXFbk2().getValue());
        assertFalse(delayDual.isClear().getValue());
    }
}
