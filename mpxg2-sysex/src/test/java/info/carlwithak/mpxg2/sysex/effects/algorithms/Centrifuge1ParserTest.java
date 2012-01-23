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

import info.carlwithak.mpxg2.model.effects.algorithms.Centrifuge1;
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
public class Centrifuge1ParserTest {

    @Test
    public void testParse_VHRig() throws ParseException {
        byte[] effectParameters = {4, 6, 6, 0, 12, 3, 0, 0, 0, 0, 13, 2, 8, 7, 4, 6, 4, 6, 0, 0, 0, 0, 4, 6, 8, 8, 11, 2, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Centrifuge1 centrifuge1 = Centrifuge1Parser.parse(effectParameters);
        assertThat(centrifuge1.mix, is(value(100)));
        assertThat(centrifuge1.level, is(value(6)));
        assertThat(centrifuge1.getRate1(), is(frequency(0.60)));
        assertThat(centrifuge1.getPulseWidth1(), is(value(45)));
        assertThat(centrifuge1.getSync1(), is(value(120)));
        assertThat(centrifuge1.getDepth1(), is(value(100)));
        assertThat(centrifuge1.getRate2(), is(frequency(1.00)));
        assertThat(centrifuge1.getPulseWidth2(), is(value(100)));
        assertThat(centrifuge1.getSync2(), is(value(-120)));
        assertThat(centrifuge1.getDepth2(), is(value(43)));
        assertThat(centrifuge1.getResonance(), is(value(100)));
    }
}
