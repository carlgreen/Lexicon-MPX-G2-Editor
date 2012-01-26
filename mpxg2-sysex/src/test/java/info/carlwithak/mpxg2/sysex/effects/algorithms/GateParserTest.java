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

import info.carlwithak.mpxg2.model.effects.algorithms.Gate;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class GateParserTest {

    @Test
    public void testParse_GatedVerb() {
        byte[] effectParameters = {2, 3, 6, 0, 1, 0, 1, 0, 1, 2, 0, 0, 0, 1, 0, 1, 3, 1, 9, 2, 2, 1, 7, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Gate gate = GateParser.parse(effectParameters);
        assertThat(gate.mix, is(value(50)));
        assertThat(gate.level, is(value(6)));
        assertThat(gate.time, is(value(1))); // 145 is number 1 in list
        assertThat(gate.link, is(value(true)));
        assertThat(gate.diff, is(value(66)));
        assertThat(gate.preDelay, is(value(0)));
        assertThat(gate.loSlope, is(value(0)));
        assertThat(gate.hiSlope, is(value(0)));
        assertThat(gate.xovr, is(value(19))); // 1.5k is number 19 in list
        assertThat(gate.rtHC, is(value(41))); // 14.1k is number 41 in list for this size
        assertThat(gate.shape, is(value(18)));
        assertThat(gate.spred, is(value(231))); // 24 is number 231 in list for this size
    }

}
