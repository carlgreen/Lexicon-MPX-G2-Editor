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
public class DecayTimeValueTest {
    private final GenericValue<Boolean> link = new GenericValue<Boolean>("Link", "OnOff", false, true);
    private final GenericValue<Double> size = new GenericValue<Double>("Size", "m", 4.0, 35.0);
    private final DecayTimeValue value = new DecayTimeValue("Decay", link, size);

    @Test
    public void testDecayLevelValueToString_noLink() {
        link.setValue(false);
        value.setValue(0);

        size.setValue(5.0);
        assertThat(value.toString(), is("0.29s"));

        size.setValue(17.0);
        assertThat(value.toString(), is("0.29s"));
    }

    @Test
    public void testDecayLevelValueToString_Link0() {
        link.setValue(true);
        size.setValue(5.0);

        value.setValue(0);
        assertThat(value.toString(), is("0.07s"));

        value.setValue(63);
        assertThat(value.toString(), is("6.58s"));
    }

    @Test
    public void testDecayLevelValueToString_Link1() {
        link.setValue(true);
        size.setValue(12.0);

        value.setValue(0);
        assertThat(value.toString(), is("0.09s"));

        value.setValue(63);
        assertThat(value.toString(), is("13.1s"));
    }

    @Test
    public void testDecayLevelValueToString_Link2() {
        link.setValue(true);
        size.setValue(27.5);

        value.setValue(0);
        assertThat(value.toString(), is("0.12s"));

        value.setValue(63);
        assertThat(value.toString(), is("19.6s"));
    }

    @Test
    public void testDecayLevelValueToString_Link3() {
        link.setValue(true);
        size.setValue(35.0);

        value.setValue(0);
        assertThat(value.toString(), is("0.14s"));

        value.setValue(63);
        assertThat(value.toString(), is("26.2s"));
    }

    @Test
    public void testDecayLevelValueToString_Link6() {
        link.setValue(true);
        size.setValue(53.0);

        value.setValue(0);
        assertThat(value.toString(), is("0.21s"));

        value.setValue(41);
        assertThat(value.toString(), is("1.67s"));

        value.setValue(63);
        assertThat(value.toString(), is("45.8s"));
    }

    @Test
    public void testDecayLevelValueToString_Link9() {
        link.setValue(true);
        size.setValue(76.0);

        value.setValue(0);
        assertThat(value.toString(), is("0.29s"));

        value.setValue(63);
        assertThat(value.toString(), is("65.4s"));
    }

}
