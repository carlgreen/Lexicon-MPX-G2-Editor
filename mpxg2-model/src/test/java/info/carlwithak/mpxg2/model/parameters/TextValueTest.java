/*
 *  Copyright (C) 2012 Carl Green
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

package info.carlwithak.mpxg2.model.parameters;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class TextValueTest {
    private final TextValue value = new TextValue("some name", 3);
    private final TextValue nullValue = new TextValue("some name", 3);

    @Before
    public void setup() {
        value.setValue("x");
        nullValue.setValue(null);
    }

    @Test
    public void testGetName() {
        assertThat(value.getName(), is("some name"));
    }

    @Test
    public void testGetMaxValue() {
        assertThat(value.getMaxLength(), is(3));
    }

    @Test
    public void testGetAndSetValue() {
        assertThat(nullValue.getValue(), is(nullValue()));
        nullValue.setValue("e");
        assertThat(nullValue.getValue(), is("e"));
    }

    @Test
    public void testIsSet() {
        assertThat(value.isSet(), is(true));
        assertThat(nullValue.isSet(), is(false));
    }

    @Test
    public void testGetDisplayString() {
        assertThat(value.getDisplayString(), is("x"));
    }

}
