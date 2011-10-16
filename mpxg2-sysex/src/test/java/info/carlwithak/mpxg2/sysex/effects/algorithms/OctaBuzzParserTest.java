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

import info.carlwithak.mpxg2.model.effects.algorithms.OctaBuzz;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class OctaBuzzParserTest {

    @Test
    public void testParse_KissTheSky() {
        byte[] effectParameters = {4, 6, 3, 0, 10, 0, 13, 13, 0, 0, 4, 4, 0, 0, 14, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        OctaBuzz octaBuzz = OctaBuzzParser.parse(effectParameters);
        assertEquals(100, octaBuzz.getMix());
        assertEquals(3, octaBuzz.getLevel());
    }
}
