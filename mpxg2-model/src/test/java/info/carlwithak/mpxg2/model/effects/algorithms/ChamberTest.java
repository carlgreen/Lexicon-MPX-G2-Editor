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
public class ChamberTest {
    private Chamber chamber;

    @Before
    public void setUp() {
        chamber = new Chamber();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(Chamber.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", chamber.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", chamber.getParameter(1).getUnit());
    }

    @Test
    public void testSize() {
        assertEquals("m", chamber.getParameter(2).getUnit());
    }

    @Test
    public void testLink() {
        assertEquals("OnOff", chamber.getParameter(3).getUnit());
    }

    @Test
    public void testDiff() {
        assertEquals("%", chamber.getParameter(4).getUnit());
    }

    @Test
    public void testPreDelay() {
        assertEquals("ms", chamber.getParameter(5).getUnit());
    }

    @Test
    public void testBass() {
        assertEquals("X", chamber.getParameter(6).getUnit());
    }

    @Test
    public void testDecay() {
        assertEquals("s", chamber.getParameter(7).getUnit());
    }

    @Test
    public void testXovr() {
        assertEquals("Hz", chamber.getParameter(8).getUnit());
    }

    @Test
    public void testRtHC() {
        assertEquals("Hz", chamber.getParameter(9).getUnit());
    }

    @Test
    public void testShape() {
        assertEquals("", chamber.getParameter(10).getUnit());
    }

    @Test
    public void testSpred() {
        assertEquals("", chamber.getParameter(11).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(chamber.getParameter(12));
    }
}
