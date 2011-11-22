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
        assertEquals(100, (int) sweepFilter.getMix().getValue());
        assertEquals(6, (int) sweepFilter.getLevel().getValue());
        assertEquals(88, (int) sweepFilter.getFc().getValue());
        assertEquals(34, (int) sweepFilter.getFRes().getValue());
        assertEquals(2120, (int) sweepFilter.getMod().getValue());
        assertEquals(50, (int) sweepFilter.getScale().getValue());
        assertEquals(0, (int) sweepFilter.getPan().getValue());
    }

    @Test
    public void testParse_TechnoChords() {
        byte[] effectParameters = {4, 6, 0, 0, 4, 1, 0, 0, 4, 2, 4, 14, 7, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SweepFilter sweepFilter = SweepFilterParser.parse(effectParameters);
        assertEquals(100, (int) sweepFilter.getMix().getValue());
        assertEquals(0, (int) sweepFilter.getLevel().getValue());
        assertEquals(20, (int) sweepFilter.getFc().getValue());
        assertEquals(36, (int) sweepFilter.getFRes().getValue());
        assertEquals(2020, (int) sweepFilter.getMod().getValue());
        assertEquals(49, (int) sweepFilter.getScale().getValue());
        assertEquals(0, (int) sweepFilter.getPan().getValue());
    }
}
