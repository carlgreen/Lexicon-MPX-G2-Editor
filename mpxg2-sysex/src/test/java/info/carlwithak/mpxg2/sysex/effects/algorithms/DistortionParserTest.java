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

import info.carlwithak.mpxg2.model.effects.algorithms.Distortion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class DistortionParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {0, 0, 4, 0, 11, 0, 9, 1, 5, 1, 7, 0, 6, 0, 8, 2, 14, 2, 12, 0, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Distortion distortion = DistortionParser.parse(effectParameters);
        assertEquals(0, (int) distortion.getLo().getValue());
        assertEquals(4, (int) distortion.getMid().getValue());
        assertEquals(11, (int) distortion.getHi().getValue());
        assertEquals(25, (int) distortion.getDrive().getValue());
        assertEquals(21, (int) distortion.getTone().getValue());
        assertEquals(7, (int) distortion.getBass().getValue());
        assertEquals(6, (int) distortion.getTreble().getValue());
        assertEquals(40, (int) distortion.getLevel().getValue());
    }
}
