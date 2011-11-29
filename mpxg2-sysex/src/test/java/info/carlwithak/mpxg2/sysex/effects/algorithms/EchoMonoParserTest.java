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

import info.carlwithak.mpxg2.model.effects.algorithms.EchoMono;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsBeat.beat;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class EchoMonoParserTest {

    @Test
    public void testParse_VybeFlange() throws ParseException {
        byte[] effectParameters = {6, 0, 1, 0, 4, 0, 4, 0, 1, 0, 1, 15, 3, 0, 4, 1, 0, 0, 0, 0, 6, 15, 3, 0, 15, 0, 9, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoMono echoMono = EchoMonoParser.parse(effectParameters);
        assertThat(echoMono.getMix(), is(value(6)));
        assertThat(echoMono.getLevel(), is(value(1)));
        assertThat(echoMono.getTime(), is(beat(4, 4)));
        assertThat(echoMono.getFeedback(), is(value(-15)));
        assertEquals(3, echoMono.getInsert());
        assertThat(echoMono.getDamp(), is(value(20)));
        assertThat(echoMono.isClear(), is(value(false)));
    }
}
