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

import info.carlwithak.mpxg2.model.effects.algorithms.BlueComp;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class BlueCompParserTest {

    @Test
    public void testParse_AnotherBrick() {
        byte[] effectParameters = {4, 6, 6, 0, 5, 0, 4, 14, 5, 0, 4, 1, 0, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        BlueComp blueComp = BlueCompParser.parse(effectParameters);
        assertThat(blueComp.mix, is(value(100)));
        assertThat(blueComp.level, is(value(6)));
        assertThat(blueComp.sensitivity, is(value(5)));
        assertThat(blueComp.threshold, is(value(-28)));
        assertThat(blueComp.gain, is(value(5)));
        assertThat(blueComp.attackTime, is(value(20)));
        assertThat(blueComp.releaseTime, is(value(100)));
    }

    @Test
    public void testParse_SlideComp() {
        byte[] effectParameters = {4, 6, 0, 0, 10, 0, 13, 13, 0, 0, 4, 4, 0, 0, 14, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        BlueComp blueComp = BlueCompParser.parse(effectParameters);
        assertThat(blueComp.mix, is(value(100)));
        assertThat(blueComp.level, is(value(0)));
        assertThat(blueComp.sensitivity, is(value(10)));
        assertThat(blueComp.threshold, is(value(-35)));
        assertThat(blueComp.gain, is(value(0)));
        assertThat(blueComp.attackTime, is(value(68)));
        assertThat(blueComp.releaseTime, is(value(190)));
    }
}
