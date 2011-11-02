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

import info.carlwithak.mpxg2.model.effects.algorithms.DiatonicHmy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class DiatonicHmyParserTest {

    @Test
    public void testParse_EMajMin3() {
        byte[] effectParameters = {4, 6, 0, 0, 4, 0, 0, 0, 0, 1, 10, 0, 13, 10, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DiatonicHmy diatonicHmy = DiatonicHmyParser.parse(effectParameters);
        assertEquals(100, diatonicHmy.getMix());
        assertEquals(0, diatonicHmy.getLevel());
        assertEquals(4, diatonicHmy.getKey()); // E
        assertEquals(0, diatonicHmy.getScale()); // Major
        assertEquals(16, diatonicHmy.getInterval()); // +3rd
        assertEquals(10, diatonicHmy.getOptimize());
        assertEquals(-83, diatonicHmy.getThreshold());
        assertEquals(1, diatonicHmy.getSource()); // Guitar Input
    }

    @Test
    public void testParse_EDorMix3() {
        byte[] effectParameters = {4, 6, 0, 0, 4, 0, 4, 0, 0, 1, 10, 0, 13, 10, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DiatonicHmy diatonicHmy = DiatonicHmyParser.parse(effectParameters);
        assertEquals(100, diatonicHmy.getMix());
        assertEquals(0, diatonicHmy.getLevel());
        assertEquals(4, diatonicHmy.getKey()); // E
        assertEquals(4, diatonicHmy.getScale()); // Mixo
        assertEquals(16, diatonicHmy.getInterval()); // +3rd
        assertEquals(10, diatonicHmy.getOptimize());
        assertEquals(-83, diatonicHmy.getThreshold());
        assertEquals(1, diatonicHmy.getSource()); // Guitar Input
    }
}
