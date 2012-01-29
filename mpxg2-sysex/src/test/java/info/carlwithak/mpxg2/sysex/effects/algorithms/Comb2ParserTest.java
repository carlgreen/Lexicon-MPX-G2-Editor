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

import info.carlwithak.mpxg2.model.effects.algorithms.Comb2;
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
public class Comb2ParserTest {

    @Test
    public void testParse() throws ParseException {
        byte[] effectParameters = {2, 3, 0, 0, 12, 2, 1, 0, 0, 3, 1, 1, 12, 9, 7, 15, 0, 0, 0, 0, 11, 3, 8, 1, 1, 0, 0, 0, 0, 0, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Comb2 comb2 = Comb2Parser.parse(effectParameters);
        assertThat(comb2.mix, is(value(50)));
        assertThat(comb2.level, is(value(0)));
        assertThat(comb2.loCut, is(value(300)));
        assertThat(comb2.hiCut, is(value(4400)));
        assertThat(comb2.notch, is(value(-100)));
        assertThat(comb2.getRate(), is(frequency(2.47)));
        assertThat(comb2.pulseWidth, is(value(59)));
        assertThat(comb2.depth, is(value(24)));
        assertThat(comb2.resonance, is(value(1)));
        assertThat(comb2.phase, is(value(0)));
    }

}
