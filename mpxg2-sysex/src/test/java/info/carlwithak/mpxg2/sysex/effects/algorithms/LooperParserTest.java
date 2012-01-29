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

import info.carlwithak.mpxg2.model.effects.algorithms.Looper;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsTapMs.tapMs;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class LooperParserTest {

    @Test
    public void testParse() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 0, 13, 7, 0, 4, 0, 10, 5, 3, 0, 4, 6, 0, 0, 4, 6, 4, 6, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Looper looper = LooperParser.parse(effectParameters);
        assertThat(looper.mix, is(value(100)));
        assertThat(looper.level, is(value(0)));
        assertThat(looper.getTime(), is(tapMs(2000)));
        assertThat(looper.inMix, is(value(90)));
        assertThat(looper.feedbackInsert, is(value(3)));
        assertThat(looper.sensitivity, is(value(100)));
        assertThat(looper.pan, is(value(0)));
        assertThat(looper.release, is(value(100)));
        assertThat(looper.attack, is(value(100)));
        assertThat(looper.clear, is(value(false)));
    }

}
