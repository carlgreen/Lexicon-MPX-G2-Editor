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

import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class ScreamerParserTest {

    @Test
    public void testParse_G2Blue() {
        byte[] effectParameters = {2, 0, 1, 0, 3, 0, 6, 1, 9, 1, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Screamer screamer = ScreamerParser.parse(effectParameters);
        assertEquals(2, screamer.getLo());
        assertEquals(1, screamer.getMid());
        assertEquals(3, screamer.getHi());
        assertEquals(22, screamer.getDrive());
        assertEquals(25, screamer.getTone());
        assertEquals(57, screamer.getLevel());
    }

    @Test
    public void testParse_GuitarSolo() {
        byte[] effectParameters = {5, 0, 0, 0, 0, 0, 8, 2, 5, 1, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Screamer screamer = ScreamerParser.parse(effectParameters);
        assertEquals(5, screamer.getLo());
        assertEquals(0, screamer.getMid());
        assertEquals(0, screamer.getHi());
        assertEquals(40, screamer.getDrive());
        assertEquals(21, screamer.getTone());
        assertEquals(39, screamer.getLevel());
    }

    @Test
    public void testParse_VybeFlange() {
        byte[] effectParameters = {0, 0, 1, 0, 0, 0, 13, 1, 3, 1, 5, 3, 8, 2, 5, 1, 12, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Screamer screamer = ScreamerParser.parse(effectParameters);
        assertEquals(0, screamer.getLo());
        assertEquals(1, screamer.getMid());
        assertEquals(0, screamer.getHi());
        assertEquals(29, screamer.getDrive());
        assertEquals(19, screamer.getTone());
        assertEquals(53, screamer.getLevel());
    }
}
