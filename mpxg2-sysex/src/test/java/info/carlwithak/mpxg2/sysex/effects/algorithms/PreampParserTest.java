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

import info.carlwithak.mpxg2.model.effects.algorithms.Preamp;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class PreampParserTest {

    @Test
    public void testParse_RotaryCab() {
        byte[] effectParameters = {7, 0, 3, 0, 0, 0, 11, 15, 0, 0, 0, 2, 7, 1, 6, 1, 0, 0, 0, 0, 13, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Preamp preamp = PreampParser.parse(effectParameters);
        assertThat(preamp.lo, is(value(7)));
        assertThat(preamp.mid, is(value(3)));
        assertThat(preamp.hi, is(value(0)));
        assertThat(preamp.inLevel, is(value(-5)));
        assertThat(preamp.loCut, is(value(0)));
        assertThat(preamp.feel, is(value(32)));
        assertThat(preamp.drive, is(value(23)));
        assertThat(preamp.tone, is(value(22)));
        assertThat(preamp.bass, is(value(0)));
        assertThat(preamp.treble, is(value(0)));
        assertThat(preamp.level, is(value(45)));
    }
}
