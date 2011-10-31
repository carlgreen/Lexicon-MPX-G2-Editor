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
public class ShiftDualTest {
    private ShiftDual shiftDual;

    @Before
    public void setUp() {
        shiftDual = new ShiftDual();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(ShiftDual.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", shiftDual.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", shiftDual.getParameter(1).getUnit());
    }

    @Test
    public void testTune1() {
        assertEquals("", shiftDual.getParameter(2).getUnit());
    }

    @Test
    public void testTune2() {
        assertEquals("", shiftDual.getParameter(3).getUnit());
    }

    @Test
    public void testGlide() {
        assertEquals("OnOff", shiftDual.getParameter(4).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(shiftDual.getParameter(5));
    }
}