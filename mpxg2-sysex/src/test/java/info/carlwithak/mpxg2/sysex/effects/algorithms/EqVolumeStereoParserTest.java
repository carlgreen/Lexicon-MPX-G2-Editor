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

import info.carlwithak.mpxg2.model.effects.algorithms.EqVolumeStereo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class EqVolumeStereoParserTest {

    @Test
    public void testParse_RoundTrem() {
        byte[] effectParameters = {4, 6, 0, 0, 0, 0, 4, 6, 14, 4, 15, 4, 0, 0, 6, 0, 0, 11, 4, 0, 9, 1, 0, 0, 10, 0, 4, 10, 6, 0, 15, 0, 1, 0, 8, 11, 8, 13, 14, 0, 7, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EqVolumeStereo volumeStereo = EqVolumeStereoParser.parse(effectParameters);
        assertEquals(100, volumeStereo.getMix());
        assertEquals(0, volumeStereo.getLevel());
        assertEquals(0, volumeStereo.getVolume());
    }
}