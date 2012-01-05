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

package info.carlwithak.mpxg2.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class PanValueTest {

    @Test
    public void testGetDisplayString() {
        PanValue value = new PanValue("Pan", -10, 10);

        value.setValue(-10);
        assertThat(value.getDisplayString(), is("10L"));

        value.setValue(0);
        assertThat(value.getDisplayString(), is("C"));

        value.setValue(10);
        assertThat(value.getDisplayString(), is("10R"));
    }

}
