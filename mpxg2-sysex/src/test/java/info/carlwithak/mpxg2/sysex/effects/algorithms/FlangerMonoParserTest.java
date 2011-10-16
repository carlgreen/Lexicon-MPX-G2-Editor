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
import info.carlwithak.mpxg2.model.effects.algorithms.FlangerMono;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class FlangerMonoParserTest {

    @Test
    public void testParse_Stomp() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 5, 0, 0, 0, 0, 0, 4, 1, 14, 1, 4, 12, 14, 1, 0, 0, 0, 0, 4, 6, 8, 8, 11, 2, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        FlangerMono flangerMono = FlangerMonoParser.parse(effectParameters);
        assertEquals(100, flangerMono.getMix());
        assertEquals(0, flangerMono.getLevel());
        assertEquals(new FrequencyRate(0.05), flangerMono.getRate());
        assertEquals(20, flangerMono.getPulseWidth());
        assertEquals(30, flangerMono.getDepth());
        assertEquals(-60, flangerMono.getResonance());
        assertEquals(30, flangerMono.getBlend());
    }
}
