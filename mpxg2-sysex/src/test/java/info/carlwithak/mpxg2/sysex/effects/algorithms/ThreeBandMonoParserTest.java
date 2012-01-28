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

import info.carlwithak.mpxg2.model.effects.algorithms.ThreeBandMono;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class ThreeBandMonoParserTest {

    @Test
    public void testParse_CountryRock() {
        byte[] effectParameters = {4, 6, 0, 0, 4, 0, 12, 2, 1, 0, 5, 0, 0, 0, 4, 0, 0, 11, 4, 0, 10, 0, 1, 0, 6, 0, 0, 7, 7, 1, 5, 0, 1, 0, 2, 14, 4, 10, 6, 0, 7, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ThreeBandMono threeBandMono = ThreeBandMonoParser.parse(effectParameters);
        assertThat(threeBandMono.mix, is(value(100)));
        assertThat(threeBandMono.level, is(value(0)));
        assertThat(threeBandMono.gain1, is(value(4)));
        assertThat(threeBandMono.fc1, is(value(300)));
        assertThat(threeBandMono.q1, is(value(0.5)));
        assertThat(threeBandMono.mode1, is(value(0))); // LShlf
        assertThat(threeBandMono.gain2, is(value(4)));
        assertThat(threeBandMono.fc2, is(value(1200)));
        assertThat(threeBandMono.q2, is(value(1.0)));
        assertThat(threeBandMono.mode2, is(value(1))); // Band
        assertThat(threeBandMono.gain3, is(value(6)));
        assertThat(threeBandMono.fc3, is(value(6000)));
        assertThat(threeBandMono.q3, is(value(0.5)));
        assertThat(threeBandMono.mode3, is(value(1))); // Band
    }

}
