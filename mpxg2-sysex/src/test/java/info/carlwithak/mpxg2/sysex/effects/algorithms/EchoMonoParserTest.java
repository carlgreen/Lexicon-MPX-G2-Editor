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

import info.carlwithak.mpxg2.model.effects.algorithms.EchoMono;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class EchoMonoParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {6, 0, 1, 0, 4, 0, 4, 0, 1, 0, 1, 15, 3, 0, 4, 1, 0, 0, 0, 0, 6, 15, 3, 0, 15, 0, 9, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoMono echoMono = EchoMonoParser.parse(effectParameters);
        assertEquals(6, echoMono.getMix());
        assertEquals(1, echoMono.getLevel());
        assertEquals(4, echoMono.getTimeEchoes());
        assertEquals(4, echoMono.getTimeBeat());
        assertEquals(-15, echoMono.getFeedback());
        assertEquals(3, echoMono.getInsert());
        assertEquals(20, echoMono.getDamp());
        assertEquals(0, echoMono.getClear());
    }
}
