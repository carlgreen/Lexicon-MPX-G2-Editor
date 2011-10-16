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

import info.carlwithak.mpxg2.model.effects.algorithms.SweepFilter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class SweepFilterParserTest {

    @Test
    public void testParse_EnvFilterLP() {
        byte[] effectParameters = {4, 6, 6, 0, 8, 5, 0, 0, 2, 2, 8, 4, 8, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SweepFilter sweepFilter = SweepFilterParser.parse(effectParameters);
        assertEquals(100, sweepFilter.getMix());
        assertEquals(6, sweepFilter.getLevel());
        assertEquals(88, sweepFilter.getFc());
        assertEquals(34, sweepFilter.getFRes());
        assertEquals(2120, sweepFilter.getMod());
        assertEquals(50, sweepFilter.getScale());
        assertEquals(0, sweepFilter.getPan());
    }

    @Test
    public void testParse_TechnoChords() {
        byte[] effectParameters = {4, 6, 0, 0, 4, 1, 0, 0, 4, 2, 4, 14, 7, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SweepFilter sweepFilter = SweepFilterParser.parse(effectParameters);
        assertEquals(100, sweepFilter.getMix());
        assertEquals(0, sweepFilter.getLevel());
        assertEquals(20, sweepFilter.getFc());
        assertEquals(36, sweepFilter.getFRes());
        assertEquals(2020, sweepFilter.getMod());
        assertEquals(49, sweepFilter.getScale());
        assertEquals(0, sweepFilter.getPan());
    }
}
