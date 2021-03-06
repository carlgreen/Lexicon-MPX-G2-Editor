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

import info.carlwithak.mpxg2.model.effects.algorithms.Overdrive;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class OverdriveParserTest {

    @Test
    public void testParse_PowerChords() {
        byte[] effectParameters = {4, 0, 8, 0, 0, 0, 8, 15, 0, 0, 0, 2, 8, 2, 5, 1, 12, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Overdrive overdrive = OverdriveParser.parse(effectParameters);
        assertThat(overdrive.lo, is(value(4)));
        assertThat(overdrive.mid, is(value(8)));
        assertThat(overdrive.hi, is(value(0)));
        assertThat(overdrive.inLevel, is(value(-8)));
        assertThat(overdrive.loCut, is(value(0)));
        assertThat(overdrive.feel, is(value(32)));
        assertThat(overdrive.drive, is(value(40)));
        assertThat(overdrive.tone, is(value(21)));
        assertThat(overdrive.level, is(value(44)));
    }
}
