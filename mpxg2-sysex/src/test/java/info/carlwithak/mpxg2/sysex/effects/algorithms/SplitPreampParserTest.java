/*
 *  Copyright (C) 2012 Carl Green
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

import info.carlwithak.mpxg2.model.effects.algorithms.SplitPreamp;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class SplitPreampParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {3, 0, 4, 0, 10, 0, 0, 0, 2, 0, 0, 2, 14, 1, 9, 1, 0, 0, 12, 0, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SplitPreamp splitPreamp = SplitPreampParser.parse(effectParameters);
        assertThat(splitPreamp.lo, is(value(3)));
        assertThat(splitPreamp.mid, is(value(4)));
        assertThat(splitPreamp.hi, is(value(10)));
        assertThat(splitPreamp.inLevel, is(value(0)));
        assertThat(splitPreamp.loCut, is(value(2)));
        assertThat(splitPreamp.feel, is(value(32)));
        assertThat(splitPreamp.drive, is(value(30)));
        assertThat(splitPreamp.tone, is(value(25)));
        assertThat(splitPreamp.bass, is(value(0)));
        assertThat(splitPreamp.treble, is(value(12)));
        assertThat(splitPreamp.level, is(value(54)));
    }

}
