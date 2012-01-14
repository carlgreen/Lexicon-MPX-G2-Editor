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
public class GateTest {
    private Gate gate = new Gate();

    @Test
    public void testMix() {
        assertEquals("%", gate.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", gate.getParameter(1).getUnit());
    }

    @Test
    public void testTime() {
        assertEquals("ms", gate.getParameter(2).getUnit());
    }

    @Test
    public void testLink() {
        assertEquals("OnOff", gate.getParameter(3).getUnit());
    }

    @Test
    public void testDiff() {
        assertEquals("%", gate.getParameter(4).getUnit());
    }

    @Test
    public void testPreDelay() {
        assertEquals("ms", gate.getParameter(5).getUnit());
    }

    @Test
    public void testLoSlp() {
        assertEquals("", gate.getParameter(6).getUnit());
    }

    @Test
    public void testHiSlp() {
        assertEquals("", gate.getParameter(7).getUnit());
    }

    @Test
    public void testXovr() {
        assertEquals("Hz", gate.getParameter(8).getUnit());
    }

    @Test
    public void testRtHC() {
        assertEquals("Hz", gate.getParameter(9).getUnit());
    }

    @Test
    public void testShape() {
        assertEquals("", gate.getParameter(10).getUnit());
    }

    @Test
    public void testSpred() {
        assertEquals("", gate.getParameter(11).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(gate.getParameter(12));
    }
}
