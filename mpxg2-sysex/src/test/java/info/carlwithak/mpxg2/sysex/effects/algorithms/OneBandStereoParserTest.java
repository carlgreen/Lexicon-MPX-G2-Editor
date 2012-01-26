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

import info.carlwithak.mpxg2.model.effects.algorithms.OneBandStereo;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class OneBandStereoParserTest {

    @Test
    public void testParse_PCM60Room() {
        byte[] effectParameters = {4, 6, 0, 0, 8, 11, 8, 15, 10, 2, 7, 0, 2, 0, 6, 15, 8, 8, 3, 1, 6, 0, 2, 0, 2, 14, 14, 6, 0, 0, 7, 0, 0, 0, 2, 14, 4, 10, 6, 0, 7, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        OneBandStereo oneBandStereo = OneBandStereoParser.parse(effectParameters);
        assertThat(oneBandStereo.mix, is(value(100)));
        assertThat(oneBandStereo.level, is(value(0)));
        assertThat(oneBandStereo.gain, is(value(-72)));
        assertThat(oneBandStereo.fc, is(value(11000)));
        assertThat(oneBandStereo.q, is(value(0.7)));
        assertThat(oneBandStereo.mode, is(value(2)));
    }

}
