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
public class PlateTest {
    private final Plate plate = new Plate();

    @Test
    public void testMix() {
        assertEquals("%", plate.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", plate.getParameter(1).getUnit());
    }

    @Test
    public void testSize() {
        assertEquals("m", plate.getParameter(2).getUnit());
    }

    @Test
    public void testLink() {
        assertEquals("OnOff", plate.getParameter(3).getUnit());
    }

    @Test
    public void testDiff() {
        assertEquals("%", plate.getParameter(4).getUnit());
    }

    @Test
    public void testPreDelay() {
        assertEquals("ms", plate.getParameter(5).getUnit());
    }

    @Test
    public void testBass() {
        assertEquals("X", plate.getParameter(6).getUnit());
    }

    @Test
    public void testDecay() {
        assertEquals("s", plate.getParameter(7).getUnit());
    }

    @Test
    public void testXovr() {
        assertEquals("Hz", plate.getParameter(8).getUnit());
    }

    @Test
    public void testRtHC() {
        assertEquals("Hz", plate.getParameter(9).getUnit());
    }

    @Test
    public void testShape() {
        assertEquals("", plate.getParameter(10).getUnit());
    }

    @Test
    public void testSpred() {
        assertEquals("", plate.getParameter(11).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(plate.getParameter(12));
    }
}
