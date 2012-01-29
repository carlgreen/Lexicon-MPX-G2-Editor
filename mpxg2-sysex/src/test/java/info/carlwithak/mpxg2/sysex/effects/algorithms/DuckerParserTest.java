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

import info.carlwithak.mpxg2.model.effects.algorithms.Ducker;
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
public class DuckerParserTest {

    @Test
    public void testParse() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 14, 5, 1, 0, 4, 0, 6, 14, 3, 0, 4, 6, 10, 0, 0, 0, 4, 6, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Ducker ducker = DuckerParser.parse(effectParameters);
        assertThat(ducker.mix, is(value(100)));
        assertThat(ducker.level, is(value(0)));
        assertThat(ducker.getTime(), is(tapMs(350)));
        assertThat(ducker.feedback, is(value(-26)));
        assertThat(ducker.feedbackInsert, is(value(3)));
        assertThat(ducker.sensitivity, is(value(100)));
        assertThat(ducker.release, is(value(10)));
        assertThat(ducker.clear, is(value(false)));
    }

}
