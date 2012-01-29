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

import info.carlwithak.mpxg2.model.effects.algorithms.Centrifuge2;
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
public class Centrifuge2ParserTest {

    @Test
    public void testParse() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 3, 5, 0, 0, 0, 0, 2, 3, 10, 5, 7, 3, 1, 9, 1, 0, 0, 0, 2, 3, 10, 5, 15, 3, 0, 0, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Centrifuge2 centrifuge2 = Centrifuge2Parser.parse(effectParameters);
        assertThat(centrifuge2.mix, is(value(100)));
        assertThat(centrifuge2.level, is(value(0)));
        assertThat(centrifuge2.getRate1(), is(frequency(0.83)));
        assertThat(centrifuge2.pulseWidth1, is(value(50)));
        assertThat(centrifuge2.sync1, is(value(90)));
        assertThat(centrifuge2.depth1, is(value(55)));
        assertThat(centrifuge2.getRate2(), is(frequency(4.01)));
        assertThat(centrifuge2.pulseWidth2, is(value(50)));
        assertThat(centrifuge2.sync2, is(value(90)));
        assertThat(centrifuge2.depth2, is(value(63)));
        assertThat(centrifuge2.resonance, is(value(0)));
    }

}
