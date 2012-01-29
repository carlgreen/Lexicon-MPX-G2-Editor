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

import info.carlwithak.mpxg2.model.effects.algorithms.Orbits;
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
public class OrbitsParserTest {

    @Test
    public void testParse() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 4, 6, 0, 0, 0, 0, 13, 2, 6, 10, 2, 3, 1, 0, 1, 0, 0, 0, 7, 3, 10, 5, 2, 3, 6, 15, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Orbits orbits = OrbitsParser.parse(effectParameters);
        assertThat(orbits.mix, is(value(100)));
        assertThat(orbits.level, is(value(0)));
        assertThat(orbits.getRate1(), is(frequency(1.00)));
        assertThat(orbits.pulseWidth1, is(value(45)));
        assertThat(orbits.sync1, is(value(-90)));
        assertThat(orbits.depth1, is(value(50)));
        assertThat(orbits.getRate2(), is(frequency(2.57)));
        assertThat(orbits.pulseWidth2, is(value(55)));
        assertThat(orbits.sync2, is(value(90)));
        assertThat(orbits.depth2, is(value(50)));
        assertThat(orbits.resonance, is(value(-10)));
        assertThat(orbits.width, is(value(66)));
    }

}
