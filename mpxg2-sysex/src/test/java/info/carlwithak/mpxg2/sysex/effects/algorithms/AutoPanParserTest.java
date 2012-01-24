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

import info.carlwithak.mpxg2.model.effects.algorithms.AutoPan;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsBeat.beat;
import static info.carlwithak.mpxg2.test.IsFrequency.frequency;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class AutoPanParserTest {

    @Test
    public void testParse_Cordovox1() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 4, 0, 0, 0, 0, 0, 2, 3, 4, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        AutoPan autoPan = AutoPanParser.parse(effectParameters);
        assertThat(autoPan.mix, is(value(100)));
        assertThat(autoPan.level, is(value(0)));
        assertThat(autoPan.getRate(), is(frequency(0.04)));
        assertThat(autoPan.pulseWidth, is(value(50)));
        assertThat(autoPan.depth, is(value(100)));
        assertThat(autoPan.phase, is(value(1))); // 0, 90, 180, 270 degrees
    }

    @Test
    public void testParse_Cordovox2() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 4, 6, 0, 0, 0, 0, 2, 3, 4, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        AutoPan autoPan = AutoPanParser.parse(effectParameters);
        assertThat(autoPan.mix, is(value(100)));
        assertThat(autoPan.level, is(value(0)));
        assertThat(autoPan.getRate(), is(frequency(1.00)));
        assertThat(autoPan.pulseWidth, is(value(50)));
        assertThat(autoPan.depth, is(value(100)));
        assertThat(autoPan.phase, is(value(3))); // 0, 90, 180, 270 degrees
    }

    @Test
    public void testParse_VybeFlange() throws ParseException {
        byte[] effectParameters = {4, 6, 3, 0, 1, 0, 2, 0, 1, 0, 2, 3, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        AutoPan autoPan = AutoPanParser.parse(effectParameters);
        assertThat(autoPan.mix, is(value(100)));
        assertThat(autoPan.level, is(value(3)));
        assertThat(autoPan.getRate(), is(beat(1, 2)));
        assertThat(autoPan.pulseWidth, is(value(50)));
        assertThat(autoPan.depth, is(value(100)));
        assertThat(autoPan.phase, is(value(0))); // 0, 90, 180, 270 degrees
    }
}
