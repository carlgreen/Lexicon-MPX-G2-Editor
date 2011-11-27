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
import info.carlwithak.mpxg2.model.effects.algorithms.EchoMono;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Carl Green
 */
public class EchoMonoParserTest {

    @Test
    public void testParse_VybeFlange() throws ParseException {
        byte[] effectParameters = {6, 0, 1, 0, 4, 0, 4, 0, 1, 0, 1, 15, 3, 0, 4, 1, 0, 0, 0, 0, 6, 15, 3, 0, 15, 0, 9, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoMono echoMono = EchoMonoParser.parse(effectParameters);
        assertEquals(6, (int) echoMono.getMix().getValue());
        assertEquals(1, (int) echoMono.getLevel().getValue());
        assertEquals(new BeatRate("Time", 4, 4), echoMono.getTime());
        assertEquals(-15, (int) echoMono.getFeedback().getValue());
        assertEquals(3, echoMono.getInsert());
        assertEquals(20, (int) echoMono.getDamp().getValue());
        assertFalse(echoMono.isClear().getValue());
    }
}
