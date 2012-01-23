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

import info.carlwithak.mpxg2.model.effects.algorithms.JamMan;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class JamManParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {4, 6, 0, 0, 10, 15, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        JamMan jamMan = JamManParser.parse(effectParameters);
        assertThat(jamMan.mix, is(value(100)));
        assertThat(jamMan.level, is(value(0)));
        assertThat(jamMan.getSize(), is(value(250)));
        assertThat(jamMan.getFeedback(), is(value(0)));
        assertThat(jamMan.getInsert(), is(value(3)));
        assertThat(jamMan.getClear(), is(value(false)));
        assertThat(jamMan.getLayer(), is(value(false)));
        assertThat(jamMan.getReplace(), is(value(false)));
        assertThat(jamMan.getDelay(), is(value(false)));
        assertThat(jamMan.getMute(), is(value(false)));
    }
}
