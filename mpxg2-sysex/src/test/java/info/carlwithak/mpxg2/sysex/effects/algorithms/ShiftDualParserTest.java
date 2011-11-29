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

import info.carlwithak.mpxg2.model.effects.algorithms.ShiftDual;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class ShiftDualParserTest {

    @Test
    public void testParse_PowerChords() {
        byte[] effectParameters = {4, 6, 6, 0, 0, 5, 11, 15, 10, 0, 12, 0, 14, 15, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ShiftDual shiftDual = ShiftDualParser.parse(effectParameters);
        assertThat(shiftDual.getMix(), is(value(100)));
        assertThat(shiftDual.getLevel(), is(value(6)));
        assertThat(shiftDual.getTune1(), is(value(-1200)));
        assertEquals(10, shiftDual.getOptimize());
        assertThat(shiftDual.getTune2(), is(value(-500)));
        assertThat(shiftDual.isGlide(), is(value(true)));
    }
}
