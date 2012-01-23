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

import info.carlwithak.mpxg2.model.effects.algorithms.FlangerMono;
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
public class FlangerMonoParserTest {

    @Test
    public void testParse_Stomp() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 5, 0, 0, 0, 0, 0, 4, 1, 14, 1, 4, 12, 14, 1, 0, 0, 0, 0, 4, 6, 8, 8, 11, 2, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        FlangerMono flangerMono = FlangerMonoParser.parse(effectParameters);
        assertThat(flangerMono.mix, is(value(100)));
        assertThat(flangerMono.level, is(value(0)));
        assertThat(flangerMono.getRate(), is(frequency(0.05)));
        assertThat(flangerMono.getPulseWidth(), is(value(20)));
        assertThat(flangerMono.getDepth(), is(value(30)));
        assertThat(flangerMono.getResonance(), is(value(-60)));
        assertThat(flangerMono.getBlend(), is(value(30)));
    }
}
