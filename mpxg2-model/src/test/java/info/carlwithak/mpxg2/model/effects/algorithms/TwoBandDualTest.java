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
public class TwoBandDualTest {
    private final TwoBandDual twoBandDual = new TwoBandDual();

    @Test
    public void testMix() {
        assertEquals("%", twoBandDual.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", twoBandDual.getParameter(1).getUnit());
    }

    @Test
    public void testGainLeft1() {
        assertEquals("dB", twoBandDual.getParameter(2).getUnit());
    }

    @Test
    public void testGainLeft2() {
        assertEquals("dB", twoBandDual.getParameter(3).getUnit());
    }

    @Test
    public void testFcLeft1() {
        assertEquals("Hz", twoBandDual.getParameter(4).getUnit());
    }

    @Test
    public void testFcLeft2() {
        assertEquals("Hz", twoBandDual.getParameter(5).getUnit());
    }

    @Test
    public void testQLeft1() {
        assertEquals("", twoBandDual.getParameter(6).getUnit());
    }

    @Test
    public void testQLeft2() {
        assertEquals("", twoBandDual.getParameter(7).getUnit());
    }

    @Test
    public void testModeLeft1() {
        assertEquals("", twoBandDual.getParameter(8).getUnit());
    }

    @Test
    public void testModeLeft2() {
        assertEquals("", twoBandDual.getParameter(9).getUnit());
    }

    @Test
    public void testGainRight1() {
        assertEquals("dB", twoBandDual.getParameter(10).getUnit());
    }

    @Test
    public void testGainRight2() {
        assertEquals("dB", twoBandDual.getParameter(11).getUnit());
    }

    @Test
    public void testFcRight1() {
        assertEquals("Hz", twoBandDual.getParameter(12).getUnit());
    }

    @Test
    public void testFcRight2() {
        assertEquals("Hz", twoBandDual.getParameter(13).getUnit());
    }

    @Test
    public void testQRight1() {
        assertEquals("", twoBandDual.getParameter(14).getUnit());
    }

    @Test
    public void testQRight2() {
        assertEquals("", twoBandDual.getParameter(15).getUnit());
    }

    @Test
    public void testModeRight1() {
        assertEquals("", twoBandDual.getParameter(16).getUnit());
    }

    @Test
    public void testModeRight2() {
        assertEquals("", twoBandDual.getParameter(17).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(twoBandDual.getParameter(18));
    }
}
