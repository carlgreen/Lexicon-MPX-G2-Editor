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
import info.carlwithak.mpxg2.model.effects.algorithms.RotaryCab;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class RotaryCabParserTest {

    @Test
    public void testParse_RotaryCab() throws ParseException {
        byte[] effectParameters = {4, 6, 4, 0, 13, 3, 2, 0, 0, 0, 11, 2, 13, 3, 2, 0, 0, 0, 4, 2, 0, 0, 4, 6, 12, 14, 11, 2, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        RotaryCab rotaryCab = RotaryCabParser.parse(effectParameters);
        assertEquals(100, (int) rotaryCab.getMix().getValue());
        assertEquals(4, (int) rotaryCab.getLevel().getValue());
        assertEquals(new FrequencyRate("Rate1", 5.73), rotaryCab.getRate1());
        assertEquals(43, (int) rotaryCab.getDepth1().getValue());
        assertEquals(new FrequencyRate("Rate2", 5.73), rotaryCab.getRate2());
        assertEquals(36, (int) rotaryCab.getDepth2().getValue());
        assertEquals(0, (int) rotaryCab.getResonance().getValue());
        assertEquals(100, (int) rotaryCab.getWidth().getValue());
        assertEquals(-20, (int) rotaryCab.getBalance().getValue());
    }
}
