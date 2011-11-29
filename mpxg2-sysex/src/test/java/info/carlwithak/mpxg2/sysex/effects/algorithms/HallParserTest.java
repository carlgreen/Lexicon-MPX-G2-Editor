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

import info.carlwithak.mpxg2.model.effects.algorithms.Hall;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class HallParserTest {

    @Test
    public void testParse_TremoWah() {
        byte[] effectParameters = {4, 1, 0, 0, 2, 6, 1, 0, 8, 2, 9, 1, 5, 0, 9, 2, 15, 0, 15, 1, 14, 6, 13, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Hall hall = HallParser.parse(effectParameters);
        assertThat(hall.getMix(), is(value(20)));
        assertThat(hall.getLevel(), is(value(0)));
        assertThat(hall.getSize(), is(value(53.0)));
        assertThat(hall.isLink(), is(value(true)));
        assertThat(hall.getDiff(), is(value(80)));
        assertThat(hall.getPreDelay(), is(value(25)));
        assertThat(hall.getBass(), is(value(5))); // 1.2X is number 5 in list
        assertThat(hall.getDecay(), is(value(41))); // 1.67s is number 41 in list
        assertThat(hall.getXovr(), is(value(15))); // 818 is number 15 in list
        assertThat(hall.getRtHC(), is(value(31))); // 7.9k is number 31 in list for this size
        assertThat(hall.getShape(), is(value(110)));
        assertThat(hall.getSpred(), is(value(125))); // 89 is number 125 in list for this size
    }
}
