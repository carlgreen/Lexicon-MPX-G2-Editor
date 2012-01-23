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

import info.carlwithak.mpxg2.model.effects.algorithms.DiatonicHmy;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class DiatonicHmyParserTest {

    @Test
    public void testParse_EMajMin3() {
        byte[] effectParameters = {4, 6, 0, 0, 4, 0, 0, 0, 0, 1, 10, 0, 13, 10, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DiatonicHmy diatonicHmy = DiatonicHmyParser.parse(effectParameters);
        assertThat(diatonicHmy.mix, is(value(100)));
        assertThat(diatonicHmy.level, is(value(0)));
        assertThat(diatonicHmy.getKey(), is(value(4))); // E
        assertThat(diatonicHmy.getScale(), is(value(0))); // Major
        assertThat(diatonicHmy.getInterval(), is(value(16))); // +3rd
        assertThat(diatonicHmy.getOptimize(), is(value(10)));
        assertThat(diatonicHmy.getThreshold(), is(value(-83)));
        assertThat(diatonicHmy.getSource(), is(value(1))); // Guitar Input
    }

    @Test
    public void testParse_EDorMix3() {
        byte[] effectParameters = {4, 6, 0, 0, 4, 0, 4, 0, 0, 1, 10, 0, 13, 10, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DiatonicHmy diatonicHmy = DiatonicHmyParser.parse(effectParameters);
        assertThat(diatonicHmy.mix, is(value(100)));
        assertThat(diatonicHmy.level, is(value(0)));
        assertThat(diatonicHmy.getKey(), is(value(4))); // E
        assertThat(diatonicHmy.getScale(), is(value(4))); // Mixo
        assertThat(diatonicHmy.getInterval(), is(value(16))); // +3rd
        assertThat(diatonicHmy.getOptimize(), is(value(10)));
        assertThat(diatonicHmy.getThreshold(), is(value(-83)));
        assertThat(diatonicHmy.getSource(), is(value(1))); // Guitar Input
    }
}
