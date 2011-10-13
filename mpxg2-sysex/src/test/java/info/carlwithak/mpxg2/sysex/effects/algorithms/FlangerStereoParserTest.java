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

import info.carlwithak.mpxg2.model.BeatRate;
import info.carlwithak.mpxg2.model.effects.algorithms.FlangerStereo;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class FlangerStereoParserTest {

    @Test
    public void testParse_VybeFlange() throws ParseException {
        byte[] effectParameters = {3, 4, 1, 0, 1, 0, 4, 0, 1, 0, 2, 3, 14, 3, 1, 0, 4, 1, 0, 0, 6, 3, 0, 0, 13, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        FlangerStereo flangerStereo = FlangerStereoParser.parse(effectParameters);
        assertEquals(67, flangerStereo.getMix());
        assertEquals(1, flangerStereo.getLevel());
        assertEquals(new BeatRate(1, 4), flangerStereo.getRate());
        assertEquals(50, flangerStereo.getPulseWidth());
        assertEquals(62, flangerStereo.getDepth());
        assertEquals(1, flangerStereo.getPhase()); // 0, 90, 180, 270 degrees
        assertEquals(20, flangerStereo.getResonance());
        assertEquals(0, flangerStereo.getBlend());
    }
}
