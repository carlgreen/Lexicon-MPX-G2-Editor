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

import info.carlwithak.mpxg2.model.effects.algorithms.Wah2;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class Wah2ParserTest {

    @Test
    public void testParse_TremoWah() {
        byte[] effectParameters = {4, 6, 6, 0, 2, 3, 0, 0, 0, 0, 4, 6, 10, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Wah2 wah2 = Wah2Parser.parse(effectParameters);
        assertThat(wah2.getMix(), is(value(100)));
        assertThat(wah2.getLevel(), is(value(6)));
        assertThat(wah2.getSweep(), is(value(50)));
        assertThat(wah2.getBass(), is(value(0)));
        assertEquals(0, wah2.getType());
        assertThat(wah2.getResponse(), is(value(100)));
        assertThat(wah2.getGain(), is(value(10)));
    }
}
