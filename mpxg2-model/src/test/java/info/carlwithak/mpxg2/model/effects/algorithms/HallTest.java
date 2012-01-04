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

import info.carlwithak.mpxg2.model.Util;
import java.beans.IntrospectionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Carl Green
 */
public class HallTest {
    private Hall hall;

    @Before
    public void setUp() {
        hall = new Hall();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(Hall.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", hall.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", hall.getParameter(1).getUnit());
    }

    @Test
    public void testSize() {
        assertEquals("m", hall.getParameter(2).getUnit());
    }

    @Test
    public void testLink() {
        assertEquals("OnOff", hall.getParameter(3).getUnit());
    }

    @Test
    public void testDiff() {
        assertEquals("%", hall.getParameter(4).getUnit());
    }

    @Test
    public void testPreDelay() {
        assertEquals("ms", hall.getParameter(5).getUnit());
    }

    @Test
    public void testBass() {
        assertEquals("X", hall.getParameter(6).getUnit());
    }

    @Test
    public void testDecay() {
        assertEquals("s", hall.getParameter(7).getUnit());
    }

    @Test
    public void testXovr() {
        assertEquals("Hz", hall.getParameter(8).getUnit());
    }

    @Test
    public void testRtHC() {
        assertEquals("Hz", hall.getParameter(9).getUnit());
    }

    @Test
    public void testShape() {
        assertEquals("", hall.getParameter(10).getUnit());
    }

    @Test
    public void testSpred() {
        assertEquals("", hall.getParameter(11).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(hall.getParameter(12));
    }
}
