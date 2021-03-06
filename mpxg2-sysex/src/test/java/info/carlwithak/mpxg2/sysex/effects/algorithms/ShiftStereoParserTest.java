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

import info.carlwithak.mpxg2.model.effects.algorithms.ShiftStereo;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsOnOff.on;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class ShiftStereoParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {4, 6, 0, 0, 8, 3, 15, 15, 2, 3, 1, 0, 15, 15, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ShiftStereo shiftStereo = ShiftStereoParser.parse(effectParameters);
        assertThat(shiftStereo.mix, is(value(100)));
        assertThat(shiftStereo.level, is(value(0)));
        assertThat(shiftStereo.tune, is(value(-200)));
        assertThat(shiftStereo.optimize, is(value(50)));
        assertThat(shiftStereo.glide, is(on()));
    }

}
