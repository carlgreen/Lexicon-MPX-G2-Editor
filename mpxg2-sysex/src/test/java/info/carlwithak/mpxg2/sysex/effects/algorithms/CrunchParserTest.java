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

import info.carlwithak.mpxg2.model.effects.algorithms.Crunch;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class CrunchParserTest {

    @Test
    public void testParse_TremAutoWah() throws ParseException {
        byte[] effectParameters = {6, 0, 12, 0, 15, 0, 0, 0, 2, 3, 0, 2, 8, 2, 5, 1, 9, 2, 0, 0, 13, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Crunch crunch = CrunchParser.parse(effectParameters);
        assertThat(crunch.getLo(), is(value(6)));
        assertThat(crunch.getMid(), is(value(12)));
        assertThat(crunch.getHi(), is(value(15)));
        assertThat(crunch.getInLevel(), is(value(0)));
        assertThat(crunch.getLevel(), is(value(50)));
    }
}
