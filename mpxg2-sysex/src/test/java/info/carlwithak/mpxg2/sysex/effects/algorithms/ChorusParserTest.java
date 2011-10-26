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
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusAlgorithm;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class ChorusParserTest {

    @Test
    public void testParse_Cordovox() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 14, 3, 0, 0, 0, 0, 13, 2, 14, 1, 8, 3, 0, 0, 0, 0, 6, 3, 0, 0, 13, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ChorusAlgorithm chorus = ChorusParser.parse(effectParameters);
        assertEquals(100, chorus.getMix());
        assertEquals(0, chorus.getLevel());
        assertEquals(new FrequencyRate("Rate1", 0.62), chorus.getRate1());
        assertEquals(45, chorus.getPulseWidth1());
        assertEquals(30, chorus.getDepth1());
        assertEquals(new FrequencyRate("Rate2", 0.56), chorus.getRate2());
        assertEquals(54, chorus.getPulseWidth2());
        assertEquals(0, chorus.getDepth2());
        assertEquals(-19, chorus.getResonance1());
        assertEquals(0, chorus.getResonance2());
    }
}
