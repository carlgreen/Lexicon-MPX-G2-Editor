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
import info.carlwithak.mpxg2.model.effects.algorithms.DelayMono;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Carl Green
 */
public class DelayMonoParserTest {

    @Test
    public void testParse_TremoWah() throws ParseException {
        byte[] effectParameters = {10, 0, 0, 0, 4, 0, 3, 0, 1, 0, 10, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DelayMono delayMono = DelayMonoParser.parse(effectParameters);
        assertEquals(10, delayMono.getMix());
        assertEquals(0, delayMono.getLevel());
        assertEquals(new BeatRate(4, 3), delayMono.getTime());
        assertEquals(10, delayMono.getFeedback());
        assertEquals(3, delayMono.getInsert());
        assertFalse(delayMono.isClear());
    }
}