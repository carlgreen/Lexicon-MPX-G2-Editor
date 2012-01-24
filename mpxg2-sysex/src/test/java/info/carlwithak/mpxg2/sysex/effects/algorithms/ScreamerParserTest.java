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

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class ScreamerParserTest {

    @Test
    public void testParse_G2Blue() {
        byte[] effectParameters = {2, 0, 1, 0, 3, 0, 6, 1, 9, 1, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Screamer screamer = ScreamerParser.parse(effectParameters);
        assertThat(screamer.lo, is(value(2)));
        assertThat(screamer.mid, is(value(1)));
        assertThat(screamer.hi, is(value(3)));
        assertThat(screamer.drive, is(value(22)));
        assertThat(screamer.tone, is(value(25)));
        assertThat(screamer.level, is(value(57)));
    }

    @Test
    public void testParse_GuitarSolo() {
        byte[] effectParameters = {5, 0, 0, 0, 0, 0, 8, 2, 5, 1, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Screamer screamer = ScreamerParser.parse(effectParameters);
        assertThat(screamer.lo, is(value(5)));
        assertThat(screamer.mid, is(value(0)));
        assertThat(screamer.hi, is(value(0)));
        assertThat(screamer.drive, is(value(40)));
        assertThat(screamer.tone, is(value(21)));
        assertThat(screamer.level, is(value(39)));
    }

    @Test
    public void testParse_VybeFlange() {
        byte[] effectParameters = {0, 0, 1, 0, 0, 0, 13, 1, 3, 1, 5, 3, 8, 2, 5, 1, 12, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Screamer screamer = ScreamerParser.parse(effectParameters);
        assertThat(screamer.lo, is(value(0)));
        assertThat(screamer.mid, is(value(1)));
        assertThat(screamer.hi, is(value(0)));
        assertThat(screamer.drive, is(value(29)));
        assertThat(screamer.tone, is(value(19)));
        assertThat(screamer.level, is(value(53)));
    }
}
