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

import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.effects.algorithms.TremoloStereo;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class TremoloStereoParserTest {

    @Test
    public void testParse_Verbolo() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 12, 2, 1, 0, 0, 0, 2, 3, 4, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        TremoloStereo tremoloStereo = TremoloStereoParser.parse(effectParameters);
        assertEquals(100, tremoloStereo.getMix());
        assertEquals(0, tremoloStereo.getLevel());
        assertEquals(new FrequencyRate("Rate", 3.0), tremoloStereo.getRate());
        assertEquals(50, tremoloStereo.getPulseWidth());
        assertEquals(100, tremoloStereo.getDepth());
        assertEquals(3, tremoloStereo.getPhase()); // 270°
    }
}
