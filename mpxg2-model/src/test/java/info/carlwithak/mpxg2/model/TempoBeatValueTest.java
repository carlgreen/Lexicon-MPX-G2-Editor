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
public class TempoBeatValueTest {

    @Test
    public void testGetDisplayString() {
        TempoBeatValue value = new TempoBeatValue("Beat Value");

        value.setValue(0);
        assertThat(value.getDisplayString(), is("eighth"));

        value.setValue(3);
        assertThat(value.getDisplayString(), is("dotted quarter"));

        value.setValue(4);
        assertThat(value.getDisplayString(), is("2 beats"));

        value.setValue(18);
        assertThat(value.getDisplayString(), is("16 beats"));

        value.setValue(128);
        assertThat(value.getDisplayString(), is("126 beats"));
    }

}
