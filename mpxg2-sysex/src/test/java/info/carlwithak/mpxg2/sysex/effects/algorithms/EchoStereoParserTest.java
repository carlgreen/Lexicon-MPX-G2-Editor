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

import info.carlwithak.mpxg2.model.effects.algorithms.EchoStereo;
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
public class EchoStereoParserTest {

    @Test
    public void testParse_DetuneTrem() throws ParseException {
        byte[] effectParameters = {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 3, 0, 0, 1, 0, 0, 0, 0, 14, 12, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoStereo echoStereo = EchoStereoParser.parse(effectParameters);
        assertThat(echoStereo.getMix(), is(value(0)));
        assertThat(echoStereo.getLevel(), is(value(0)));
        assertThat(echoStereo.getTime(), is(beat(1, 1)));
        assertThat(echoStereo.getFeedback(), is(value(0)));
        assertThat(echoStereo.getInsert(), is(value(3)));
        assertThat(echoStereo.getDamp(), is(value(16)));
        assertThat(echoStereo.isClear(), is(value(false)));
    }

    @Test
    public void testParse_RoundTrem() throws ParseException {
        byte[] effectParameters = {4, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 3, 0, 0, 1, 0, 0, 0, 0, 13, 13, 3, 0, 9, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoStereo echoStereo = EchoStereoParser.parse(effectParameters);
        assertThat(echoStereo.getMix(), is(value(20)));
        assertThat(echoStereo.getLevel(), is(value(0)));
        assertThat(echoStereo.getTime(), is(beat(1, 1)));
        assertThat(echoStereo.getFeedback(), is(value(0)));
        assertThat(echoStereo.getInsert(), is(value(3)));
        assertThat(echoStereo.getDamp(), is(value(16)));
        assertThat(echoStereo.isClear(), is(value(false)));
    }
}
