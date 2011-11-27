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
        assertEquals(2, (int) screamer.getLo().getValue());
        assertEquals(1, (int) screamer.getMid().getValue());
        assertEquals(3, (int) screamer.getHi().getValue());
        assertEquals(22, (int) screamer.getDrive().getValue());
        assertEquals(25, (int) screamer.getTone().getValue());
        assertEquals(57, (int) screamer.getLevel().getValue());
    }

    @Test
    public void testParse_GuitarSolo() {
        byte[] effectParameters = {5, 0, 0, 0, 0, 0, 8, 2, 5, 1, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Screamer screamer = ScreamerParser.parse(effectParameters);
        assertEquals(5, (int) screamer.getLo().getValue());
        assertEquals(0, (int) screamer.getMid().getValue());
        assertEquals(0, (int) screamer.getHi().getValue());
        assertEquals(40, (int) screamer.getDrive().getValue());
        assertEquals(21, (int) screamer.getTone().getValue());
        assertEquals(39, (int) screamer.getLevel().getValue());
    }

    @Test
    public void testParse_VybeFlange() {
        byte[] effectParameters = {0, 0, 1, 0, 0, 0, 13, 1, 3, 1, 5, 3, 8, 2, 5, 1, 12, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Screamer screamer = ScreamerParser.parse(effectParameters);
        assertEquals(0, (int) screamer.getLo().getValue());
        assertEquals(1, (int) screamer.getMid().getValue());
        assertEquals(0, (int) screamer.getHi().getValue());
        assertEquals(29, (int) screamer.getDrive().getValue());
        assertEquals(19, (int) screamer.getTone().getValue());
        assertEquals(53, (int) screamer.getLevel().getValue());
    }
}
