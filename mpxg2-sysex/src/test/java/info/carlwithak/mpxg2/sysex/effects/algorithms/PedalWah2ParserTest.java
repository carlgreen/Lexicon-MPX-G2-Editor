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

import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah2;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class PedalWah2ParserTest {

    @Test
    public void testParse_RotaryCab() {
        byte[] effectParameters = {4, 6, 0, 0, 10, 0, 1, 0, 4, 6, 0, 0, 10, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        PedalWah2 pedalWah2 = PedalWah2Parser.parse(effectParameters);
        assertThat(pedalWah2.mix, is(value(100)));
        assertThat(pedalWah2.level, is(value(0)));
        assertThat(pedalWah2.bass, is(value(10)));
        assertThat(pedalWah2.type, is(value(1)));
        assertThat(pedalWah2.response, is(value(100)));
        assertThat(pedalWah2.gain, is(value(0)));
    }
}
