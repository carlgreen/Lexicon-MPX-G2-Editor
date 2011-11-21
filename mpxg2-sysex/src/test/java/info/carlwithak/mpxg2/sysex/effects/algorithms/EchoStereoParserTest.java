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
import info.carlwithak.mpxg2.model.effects.algorithms.EchoStereo;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Carl Green
 */
public class EchoStereoParserTest {

    @Test
    public void testParse_DetuneTrem() throws ParseException {
        byte[] effectParameters = {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 3, 0, 0, 1, 0, 0, 0, 0, 14, 12, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoStereo echoStereo = EchoStereoParser.parse(effectParameters);
        assertEquals(0, (int) echoStereo.getMix().getValue());
        assertEquals(0, (int) echoStereo.getLevel().getValue());
        assertEquals(new BeatRate("Time", 1, 1), echoStereo.getTime());
        assertEquals(0, echoStereo.getFeedback());
        assertEquals(3, echoStereo.getInsert());
        assertEquals(16, echoStereo.getDamp());
        assertFalse(echoStereo.isClear());
    }

    @Test
    public void testParse_RoundTrem() throws ParseException {
        byte[] effectParameters = {4, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 3, 0, 0, 1, 0, 0, 0, 0, 13, 13, 3, 0, 9, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoStereo echoStereo = EchoStereoParser.parse(effectParameters);
        assertEquals(20, (int) echoStereo.getMix().getValue());
        assertEquals(0, (int) echoStereo.getLevel().getValue());
        assertEquals(new BeatRate("Time", 1, 1), echoStereo.getTime());
        assertEquals(0, echoStereo.getFeedback());
        assertEquals(3, echoStereo.getInsert());
        assertEquals(16, echoStereo.getDamp());
        assertFalse(echoStereo.isClear());
    }
}
