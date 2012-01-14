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

import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class PlateParserTest {

    @Test
    public void testParse_GuitarSolo() {
        byte[] effectParameters = {4, 6, 6, 0, 5, 2, 1, 0, 1, 2, 9, 10, 5, 0, 2, 3, 0, 1, 13, 2, 4, 2, 14, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Plate plate = PlateParser.parse(effectParameters);
        assertThat(plate.getMix(), is(value(100)));
        assertThat(plate.getLevel(), is(value(6)));
        assertThat(plate.getSize(), is(value(22.5)));
        assertThat(plate.getLink(), is(value(true)));
        assertThat(plate.getDiff(), is(value(66)));
        assertThat(plate.getPreDelay(), is(value(169)));
        assertThat(plate.getBass(), is(value(5))); // 1.2X is number 5 in list
        assertThat(plate.getDecay(), is(value(50))); // 1.30s is number 50 in list
        assertThat(plate.getXovr(), is(value(16))); // 986 is number 16 in list
        assertThat(plate.getRtHC(), is(value(45))); // 19.4k is number 45 in list for this size
        assertThat(plate.getShape(), is(value(36)));
        assertThat(plate.getSpred(), is(value(222))); // 73 is number 222 in list for this size
    }

    @Test
    public void testParse_VybeFlange() {
        byte[] effectParameters = {12, 1, 0, 0, 9, 1, 1, 0, 13, 2, 10, 0, 0, 0, 0, 0, 0, 1, 1, 2, 10, 3, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Plate plate = PlateParser.parse(effectParameters);
        assertThat(plate.getMix(), is(value(28)));
        assertThat(plate.getLevel(), is(value(0)));
        assertThat(plate.getSize(), is(value(16.5)));
        assertThat(plate.getLink(), is(value(true)));
        assertThat(plate.getDiff(), is(value(90)));
        assertThat(plate.getPreDelay(), is(value(10)));
        assertThat(plate.getBass(), is(value(0))); // 0.2X is number 0 in list
        assertThat(plate.getDecay(), is(value(0))); // 0.09s is number 0 in list for this size
        assertThat(plate.getXovr(), is(value(16))); // 986 is number 16 in list
        assertThat(plate.getRtHC(), is(value(33))); // 8.8k is number 33 in list
        assertThat(plate.getShape(), is(value(58)));
        assertThat(plate.getSpred(), is(value(254))); // 65 is number 254 in list for this size
    }
}
