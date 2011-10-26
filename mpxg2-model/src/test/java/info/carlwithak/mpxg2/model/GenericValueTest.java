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

package info.carlwithak.mpxg2.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Carl Green
 */
public class GenericValueTest {
    private GenericValue<String> genericValue;

    @Before
    public void setUp() {
        genericValue = new GenericValue<String>("some name", "a unit", "c", "f");
    }

    @Test
    public void testGetName() {
        assertEquals("some name", genericValue.getName());
    }

    @Test
    public void testGetUnit() {
        assertEquals("a unit", genericValue.getUnit());
    }

    @Test
    public void testGetMinValue() {
        assertEquals("c", genericValue.getMinValue());
    }

    @Test
    public void testGetMaxValue() {
        assertEquals("f", genericValue.getMaxValue());
    }

    @Test
    public void testGetAndSetValue() {
        assertNull(genericValue.getValue());
        genericValue.setValue("e");
        assertEquals("e", genericValue.getValue());
    }
}
