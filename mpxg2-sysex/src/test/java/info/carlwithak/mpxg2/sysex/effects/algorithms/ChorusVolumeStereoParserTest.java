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

import info.carlwithak.mpxg2.model.effects.algorithms.ChorusVolumeStereo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class ChorusVolumeStereoParserTest {

    @Test
    public void testParse_WahUni() {
        byte[] effectParameters = {4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 13, 2, 14, 1, 8, 3, 0, 0, 0, 0, 6, 3, 0, 0, 13, 14, 0, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ChorusVolumeStereo volumeStereo = ChorusVolumeStereoParser.parse(effectParameters);
        assertEquals(100, volumeStereo.getMix());
        assertEquals(0, volumeStereo.getLevel());
        assertEquals(0, volumeStereo.getVolume());
    }
}
