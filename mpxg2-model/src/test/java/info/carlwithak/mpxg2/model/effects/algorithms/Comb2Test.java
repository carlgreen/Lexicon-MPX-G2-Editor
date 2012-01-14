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

import info.carlwithak.mpxg2.model.parameters.FrequencyRate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Carl Green
 */
public class Comb2Test {
    private Comb2 comb2 = new Comb2();

    @Test
    public void testMix() {
        assertEquals("%", comb2.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", comb2.getParameter(1).getUnit());
    }

    @Test
    public void testLoCut() {
        assertEquals("Hz", comb2.getParameter(2).getUnit());
    }

    @Test
    public void testHiCut() {
        assertEquals("Hz", comb2.getParameter(3).getUnit());
    }

    @Test
    public void testComb() {
        assertEquals("", comb2.getParameter(4).getUnit());
    }

    @Test
    public void testNotch() {
        assertEquals("", comb2.getParameter(5).getUnit());
    }

    @Test
    public void testRate() {
        comb2.setRate(new FrequencyRate("Rate", 0.5));
        assertEquals("Rate", comb2.getParameter(6).getName());
        assertEquals("Hz", comb2.getParameter(6).getUnit());
    }

    @Test
    public void testPulseWidth() {
        assertEquals("%", comb2.getParameter(7).getUnit());
    }

    @Test
    public void testDepth2() {
        assertEquals("%", comb2.getParameter(8).getUnit());
    }

    @Test
    public void testRes() {
        assertEquals("", comb2.getParameter(9).getUnit());
    }

    @Test
    public void testPhase() {
        assertEquals("°", comb2.getParameter(10).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(comb2.getParameter(11));
    }
}
