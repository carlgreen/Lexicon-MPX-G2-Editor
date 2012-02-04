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

import info.carlwithak.mpxg2.model.effects.algorithms.Ambience;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsOnOff.on;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class AmbienceParserTest {

    @Test
    public void testParse_G2Blue() {
        byte[] effectParameters = {2, 1, 0, 0, 9, 2, 1, 0, 14, 1, 7, 0, 3, 3, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Ambience ambience = AmbienceParser.parse(effectParameters);
        assertThat(ambience.mix, is(value(18)));
        assertThat(ambience.level, is(value(0)));
        assertThat(ambience.size, is(value(24.5)));
        assertThat(ambience.link, is(on()));
        assertThat(ambience.diff, is(value(60)));
        assertThat(ambience.preDelay, is(value(7)));
        assertThat(ambience.decayTime, is(value(51))); // 1.41s is number 51 in list
        assertThat(ambience.decayLevel, is(value(0)));
        assertThat(ambience.rtHC, is(value(12))); // 12.8k is number 12 in list
    }
}
