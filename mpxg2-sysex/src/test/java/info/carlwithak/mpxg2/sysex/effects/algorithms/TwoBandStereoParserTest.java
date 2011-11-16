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

import info.carlwithak.mpxg2.model.effects.algorithms.TwoBandStereo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class TwoBandStereoParserTest {

    @Test
    public void testParse_SpaceEcho() {
        byte[] effectParameters = {4, 6, 14, 15, 5, 0, 10, 11, 3, 1, 1, 0, 0, 0, 8, 0, 4, 1, 0, 0, 1, 0, 1, 0, 10, 0, 4, 10, 6, 0, 15, 0, 1, 0, 8, 11, 8, 13, 14, 0, 7, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        TwoBandStereo twoBandStereo = TwoBandStereoParser.parse(effectParameters);
        assertEquals(100, twoBandStereo.getMix());
        assertEquals(-2, twoBandStereo.getLevel());
        assertEquals(5, twoBandStereo.getGain1());
        assertEquals(5050, twoBandStereo.getFc1());
        assertEquals(0.1, twoBandStereo.getQ1(), 0.01);
        assertEquals(0, twoBandStereo.getMode1()); // LShlf
        assertEquals(8, twoBandStereo.getGain2());
        assertEquals(20, twoBandStereo.getFc2());
        assertEquals(0.1, twoBandStereo.getQ2(), 0.01);
        assertEquals(1, twoBandStereo.getMode2()); // Band
    }
}
