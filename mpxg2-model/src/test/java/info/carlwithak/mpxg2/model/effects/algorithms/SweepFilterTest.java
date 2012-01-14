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

package info.carlwithak.mpxg2.model.effects.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Carl Green
 */
public class SweepFilterTest {
    private SweepFilter sweepFilter = new SweepFilter();

    @Test
    public void testMix() {
        assertEquals("%", sweepFilter.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", sweepFilter.getParameter(1).getUnit());
    }

    @Test
    public void testFc() {
        assertEquals("Hz", sweepFilter.getParameter(2).getUnit());
    }

    @Test
    public void testFRes() {
        assertEquals("", sweepFilter.getParameter(3).getUnit());
    }

    @Test
    public void testMod() {
        assertEquals("Hz", sweepFilter.getParameter(4).getUnit());
    }

    @Test
    public void testScale() {
        assertEquals("%", sweepFilter.getParameter(5).getUnit());
    }

    @Test
    public void testPan() {
        assertEquals("LCR", sweepFilter.getParameter(6).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(sweepFilter.getParameter(7));
    }
}
