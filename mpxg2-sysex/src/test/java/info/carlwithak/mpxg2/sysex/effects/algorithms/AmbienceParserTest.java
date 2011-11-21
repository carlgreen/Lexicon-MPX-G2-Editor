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

import info.carlwithak.mpxg2.model.effects.algorithms.Ambience;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carl Green
 */
public class AmbienceParserTest {

    @Test
    public void testParse_G2Blue() {
        byte[] effectParameters = {2, 1, 0, 0, 9, 2, 1, 0, 14, 1, 7, 0, 3, 3, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Ambience ambience = AmbienceParser.parse(effectParameters);
        assertEquals(18, (int) ambience.getMix().getValue());
        assertEquals(0, (int) ambience.getLevel().getValue());
        assertEquals(24.5, ambience.getSize(), 0.01);
        assertTrue(ambience.isLink());
        assertEquals(60, ambience.getDiff());
        assertEquals(7, ambience.getPreDelay());
        assertEquals(51, ambience.getDelayTime()); // 1.41s is number 51 in list
        assertEquals(0, ambience.getDelayLevel());
        assertEquals(12, ambience.getRtHC()); // 12.8k is number 12 in list
    }
}
