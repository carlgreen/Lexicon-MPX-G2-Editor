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

import info.carlwithak.mpxg2.model.effects.algorithms.DelayStereo;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsBeat.beat;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class DelayStereoParserTest {

    @Test
    public void testParse_TremoWah() throws ParseException {
        byte[] effectParameters = {4, 1, 0, 0, 2, 0, 4, 0, 1, 0, 4, 1, 3, 0, 0, 0, 0, 0, 0, 0, 14, 12, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DelayStereo delayStereo = DelayStereoParser.parse(effectParameters);
        assertThat(delayStereo.getMix(), is(value(20)));
        assertThat(delayStereo.getLevel(), is(value(0)));
        assertThat(delayStereo.getTime(), is(beat(2, 4)));
        assertThat(delayStereo.getFeedback(), is(value(20)));
        assertThat(delayStereo.getInsert(), is(value(3)));
        assertThat(delayStereo.getClear(), is(value(false)));
    }
}