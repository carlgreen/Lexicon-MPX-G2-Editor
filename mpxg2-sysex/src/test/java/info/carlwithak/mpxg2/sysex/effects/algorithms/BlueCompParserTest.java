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

import info.carlwithak.mpxg2.model.effects.algorithms.BlueComp;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class BlueCompParserTest {

    @Test
    public void testParse() throws ParseException {
        byte[] effectParameters = {4, 6, 6, 0, 5, 0, 4, 14, 5, 0, 4, 1, 0, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        BlueComp blueComp = BlueCompParser.parse(effectParameters);
        assertEquals(100, blueComp.getMix());
        assertEquals(6, blueComp.getLevel());
        assertEquals(5, blueComp.getSensitivity());
        assertEquals(-28, blueComp.getThreshold());
        assertEquals(5, blueComp.getGain());
        assertEquals(20, blueComp.getAttackTime());
        assertEquals(100, blueComp.getReleaseTime());
    }
}
