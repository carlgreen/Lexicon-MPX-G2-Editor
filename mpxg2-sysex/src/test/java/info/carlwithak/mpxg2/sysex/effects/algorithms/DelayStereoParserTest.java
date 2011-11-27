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
import info.carlwithak.mpxg2.model.effects.algorithms.DelayStereo;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Carl Green
 */
public class DelayStereoParserTest {

    @Test
    public void testParse_TremoWah() throws ParseException {
        byte[] effectParameters = {4, 1, 0, 0, 2, 0, 4, 0, 1, 0, 4, 1, 3, 0, 0, 0, 0, 0, 0, 0, 14, 12, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DelayStereo delayStereo = DelayStereoParser.parse(effectParameters);
        assertEquals(20, (int) delayStereo.getMix().getValue());
        assertEquals(0, (int) delayStereo.getLevel().getValue());
        assertEquals(new BeatRate("Time", 2, 4), delayStereo.getTime());
        assertEquals(20, (int) delayStereo.getFeedback().getValue());
        assertEquals(3, delayStereo.getInsert());
        assertFalse(delayStereo.isClear().getValue());
    }
}