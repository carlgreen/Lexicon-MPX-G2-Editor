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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 *
 * @author Carl Green
 */
public class GenericValueTest {
    private GenericValue<String> genericValue = new GenericValue<String>("some name", "a unit", "c", "f");

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

    @Test
    public void testGetDisplayString() {
        GenericValue<Integer> signedValue = new GenericValue<Integer>("Level", "dB", 0, 6);

        signedValue.setValue(6);
        assertThat(signedValue.getDisplayString(), is("6dB"));
    }

    @Test
    public void testGetDisplayString_Signed() {
        GenericValue<Integer> signedValue = new GenericValue<Integer>("Level", "dB", -90, 6);

        signedValue.setValue(6);
        assertThat(signedValue.getDisplayString(), is("+6dB"));

        signedValue.setValue(0);
        assertThat(signedValue.getDisplayString(), is("0dB"));

        signedValue.setValue(-6);
        assertThat(signedValue.getDisplayString(), is("-6dB"));
    }

}
