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
import info.carlwithak.mpxg2.model.TapMsRate;
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
        assertEquals(2, (int) echoDual.getMix().getValue());
        assertEquals(1, (int) echoDual.getLevel().getValue());
        assertEquals(new BeatRate("Time1", 4, 4), echoDual.getTime1());
        assertEquals(new BeatRate("Time2", 2, 1), echoDual.getTime2());
        assertEquals(0, (int) echoDual.getLevel1().getValue());
        assertEquals(0, (int) echoDual.getLevel2().getValue());
        assertEquals(1, (int) echoDual.getFeedback1().getValue());
        assertEquals(3, echoDual.getInsert());
        assertEquals(1, (int) echoDual.getFeedback2().getValue());
        assertEquals(20, (int) echoDual.getDamp1().getValue());
        assertEquals(20, (int) echoDual.getDamp2().getValue());
        assertFalse(echoDual.isClear().getValue());
    }

    @Test
    public void testParse_GuitarSolo() throws ParseException {
        byte[] effectParameters = {4, 6, 5, 0, 1, 0, 1, 0, 1, 0, 3, 0, 2, 0, 1, 0, 0, 0, 0, 0, 6, 15, 3, 0, 15, 0, 9, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertEquals(100, (int) echoDual.getMix().getValue());
        assertEquals(5, (int) echoDual.getLevel().getValue());
        assertEquals(new BeatRate("Time1", 1, 1), echoDual.getTime1());
        assertEquals(new BeatRate("Time2", 3, 2), echoDual.getTime2());
        assertEquals(0, (int) echoDual.getLevel1().getValue());
        assertEquals(0, (int) echoDual.getLevel2().getValue());
        assertEquals(-10, (int) echoDual.getFeedback1().getValue());
        assertEquals(3, echoDual.getInsert());
        assertEquals(15, (int) echoDual.getFeedback2().getValue());
        assertEquals(25, (int) echoDual.getDamp1().getValue());
        assertEquals(25, (int) echoDual.getDamp2().getValue());
        assertFalse(echoDual.isClear().getValue());
    }

    @Test
    public void testParse_Cordovox() throws ParseException {
        byte[] effectParameters = {14, 1, 0, 0, 1, 0, 1, 0, 1, 0, 4, 0, 3, 0, 1, 0, 0, 0, 0, 0, 6, 15, 3, 0, 12, 14, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertEquals(30, (int) echoDual.getMix().getValue());
        assertEquals(0, (int) echoDual.getLevel().getValue());
        assertEquals(new BeatRate("Time1", 1, 1), echoDual.getTime1());
        assertEquals(new BeatRate("Time2", 4, 3), echoDual.getTime2());
        assertEquals(0, (int) echoDual.getLevel1().getValue());
        assertEquals(0, (int) echoDual.getLevel2().getValue());
        assertEquals(-10, (int) echoDual.getFeedback1().getValue());
        assertEquals(3, echoDual.getInsert());
        assertEquals(-20, (int) echoDual.getFeedback2().getValue());
        assertEquals(20, (int) echoDual.getDamp1().getValue());
        assertEquals(20, (int) echoDual.getDamp2().getValue());
        assertFalse(echoDual.isClear().getValue());
    }

    @Test
    public void testParse_SlideComp() throws ParseException {
        byte[] effectParameters = {2, 1, 0, 0, 8, 12, 0, 0, 4, 0, 12, 2, 1, 0, 4, 0, 0, 0, 0, 0, 1, 15, 3, 0, 12, 14, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertEquals(18, (int) echoDual.getMix().getValue());
        assertEquals(0, (int) echoDual.getLevel().getValue());
        assertEquals(new TapMsRate("Time1", 200), echoDual.getTime1());
        assertEquals(new TapMsRate("Time2", 300), echoDual.getTime2());
        assertEquals(0, (int) echoDual.getLevel1().getValue());
        assertEquals(0, (int) echoDual.getLevel2().getValue());
        assertEquals(-15, (int) echoDual.getFeedback1().getValue());
        assertEquals(3, echoDual.getInsert());
        assertEquals(-20, (int) echoDual.getFeedback2().getValue());
        assertEquals(20, (int) echoDual.getDamp1().getValue());
        assertEquals(20, (int) echoDual.getDamp2().getValue());
        assertFalse(echoDual.isClear().getValue());
    }
}
