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

import info.carlwithak.mpxg2.model.effects.algorithms.Chamber;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class ChamberParserTest {

    @Test
    public void testParse_Cordovox() {
        byte[] effectParameters = {12, 1, 0, 0, 8, 2, 1, 0, 11, 0, 0, 0, 6, 0, 15, 2, 0, 1, 2, 2, 14, 3, 8, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Chamber chamber = ChamberParser.parse(effectParameters);
        assertThat(chamber.getMix(), is(value(28)));
        assertThat(chamber.getLevel(), is(value(0)));
        assertThat(chamber.getSize(), is(value(24.0)));
        assertThat(chamber.isLink(), is(value(true)));
        assertThat(chamber.getDiff(), is(value(22)));
        assertThat(chamber.getPreDelay(), is(value(0)));
        assertThat(chamber.getBass(), is(value(6))); // 1.5X is number 6 in list
        assertThat(chamber.getDecay(), is(value(47))); // 1.05s is number 47 in list for this size
        assertThat(chamber.getXovr(), is(value(16))); // 986 is number 16 in list
        assertThat(chamber.getRtHC(), is(value(34))); // 9.3k is number 34 in list
        assertThat(chamber.getShape(), is(value(62)));
        assertThat(chamber.getSpred(), is(value(120))); // 42 is number 120 in list for this size
    }

    @Test
    public void testParse_PowerChords() {
        byte[] effectParameters = {3, 2, 0, 0, 0, 3, 1, 0, 13, 2, 2, 5, 5, 0, 3, 2, 15, 0, 4, 2, 14, 3, 8, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Chamber chamber = ChamberParser.parse(effectParameters);
        assertThat(chamber.getMix(), is(value(35)));
        assertThat(chamber.getLevel(), is(value(0)));
        assertThat(chamber.getSize(), is(value(28.0)));
        assertThat(chamber.isLink(), is(value(true)));
        assertThat(chamber.getDiff(), is(value(90)));
        assertThat(chamber.getPreDelay(), is(value(82)));
        assertThat(chamber.getBass(), is(value(5))); // 1.2X is number 5 in list
        assertThat(chamber.getDecay(), is(value(35))); // 0.73s is number 35 in list
        assertThat(chamber.getXovr(), is(value(15))); // 818 is number 15 in list
        assertThat(chamber.getRtHC(), is(value(36))); // 10.4k is number 36 in list
        assertThat(chamber.getShape(), is(value(62)));
        assertThat(chamber.getSpred(), is(value(120))); // 48 is number 120 in list for this size
    }
}
