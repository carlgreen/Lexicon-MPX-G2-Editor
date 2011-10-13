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
import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Carl Green
 */
public class EchoDualParserTest {

    @Test
    public void testParse_G2Blue() throws ParseException {
        byte[] effectParameters = {2, 0, 1, 0, 4, 0, 4, 0, 1, 0, 2, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 3, 0, 1, 0, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertEquals(2, echoDual.getMix());
        assertEquals(1, echoDual.getLevel());
        assertEquals(new BeatRate(4, 4), echoDual.getTime1());
        assertEquals(new BeatRate(2, 1), echoDual.getTime2());
        assertEquals(0, echoDual.getLevel1());
        assertEquals(0, echoDual.getLevel2());
        assertEquals(1, echoDual.getFeedback1());
        assertEquals(3, echoDual.getInsert());
        assertEquals(1, echoDual.getFeedback2());
        assertEquals(20, echoDual.getDamp1());
        assertEquals(20, echoDual.getDamp2());
        assertFalse(echoDual.isClear());
    }

    @Test
    public void testParse_GuitarSolo() throws ParseException {
        byte[] effectParameters = {4, 6, 5, 0, 1, 0, 1, 0, 1, 0, 3, 0, 2, 0, 1, 0, 0, 0, 0, 0, 6, 15, 3, 0, 15, 0, 9, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertEquals(100, echoDual.getMix());
        assertEquals(5, echoDual.getLevel());
        assertEquals(new BeatRate(1, 1), echoDual.getTime1());
        assertEquals(new BeatRate(3, 2), echoDual.getTime2());
        assertEquals(0, echoDual.getLevel1());
        assertEquals(0, echoDual.getLevel2());
        assertEquals(-10, echoDual.getFeedback1());
        assertEquals(3, echoDual.getInsert());
        assertEquals(15, echoDual.getFeedback2());
        assertEquals(25, echoDual.getDamp1());
        assertEquals(25, echoDual.getDamp2());
        assertFalse(echoDual.isClear());
    }

    @Test
    public void testParse_Cordovox() throws ParseException {
        byte[] effectParameters = {14, 1, 0, 0, 1, 0, 1, 0, 1, 0, 4, 0, 3, 0, 1, 0, 0, 0, 0, 0, 6, 15, 3, 0, 12, 14, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertEquals(30, echoDual.getMix());
        assertEquals(0, echoDual.getLevel());
        assertEquals(new BeatRate(1, 1), echoDual.getTime1());
        assertEquals(new BeatRate(4, 3), echoDual.getTime2());
        assertEquals(0, echoDual.getLevel1());
        assertEquals(0, echoDual.getLevel2());
        assertEquals(-10, echoDual.getFeedback1());
        assertEquals(3, echoDual.getInsert());
        assertEquals(-20, echoDual.getFeedback2());
        assertEquals(20, echoDual.getDamp1());
        assertEquals(20, echoDual.getDamp2());
        assertFalse(echoDual.isClear());
    }
}
