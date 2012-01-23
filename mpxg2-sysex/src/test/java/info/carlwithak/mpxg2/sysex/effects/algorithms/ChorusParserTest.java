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

import info.carlwithak.mpxg2.model.effects.algorithms.ChorusAlgorithm;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsFrequency.frequency;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class ChorusParserTest {

    @Test
    public void testParse_Cordovox() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 14, 3, 0, 0, 0, 0, 13, 2, 14, 1, 8, 3, 0, 0, 0, 0, 6, 3, 0, 0, 13, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ChorusAlgorithm chorus = ChorusParser.parse(effectParameters);
        assertThat(chorus.mix, is(value(100)));
        assertThat(chorus.level, is(value(0)));
        assertThat(chorus.getRate1(), is(frequency(0.62)));
        assertThat(chorus.getPulseWidth1(), is(value(45)));
        assertThat(chorus.getDepth1(), is(value(30)));
        assertThat(chorus.getRate2(), is(frequency(0.56)));
        assertThat(chorus.getPulseWidth2(), is(value(54)));
        assertThat(chorus.getDepth2(), is(value(0)));
        assertThat(chorus.getResonance1(), is(value(-19)));
        assertThat(chorus.getResonance2(), is(value(0)));
    }
}
