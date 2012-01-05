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
public class ReverbSpredValueTest {
    private final GenericValue<Boolean> link = new GenericValue<Boolean>("Link", "OnOff", false, true);
    private final GenericValue<Double> size = new GenericValue<Double>("Size", "m", 4.0, 35.0);
    private final ReverbSpredValue value = new ReverbSpredValue("Spred", link, size);

    /**
     * Test spred conversion when link is off. Size shouldn't matter.
     */
    @Test
    public void testReverbSpredValueToString_noLink() {
        link.setValue(false);
        value.setValue(0);

        size.setValue(5.0);
        assertThat(value.toString(), is("0"));

        // check size doesn't matter
        size.setValue(17.0);
        value.setValue(127);
        assertThat(value.toString(), is("127"));

        value.setValue(255);
        assertThat(value.toString(), is("255"));
    }

    /**
     * Test spred conversion when link is on and size is 4.0.
     */
    @Test
    public void testReverbSpredValueToString_size4() {
        link.setValue(true);
        size.setValue(4.0);

        value.setValue(0);
        assertThat(value.toString(), is("0"));

        value.setValue(9);
        assertThat(value.toString(), is("0"));

        value.setValue(10);
        assertThat(value.toString(), is("1"));

        value.setValue(249);
        assertThat(value.toString(), is("24"));

        value.setValue(255);
        assertThat(value.toString(), is("25"));
    }

    /**
     * Test spred conversion when link is on and size is 22.5.
     */
    @Test
    public void testReverbSpredValueToString_size22_5() {
        link.setValue(true);
        size.setValue(22.5);

        value.setValue(0);
        assertThat(value.toString(), is("0"));

        value.setValue(3);
        assertThat(value.toString(), is("0"));

        value.setValue(4);
        assertThat(value.toString(), is("1"));

        value.setValue(222);
        assertThat(value.toString(), is("73"));

        value.setValue(253);
        assertThat(value.toString(), is("83"));

        value.setValue(254);
        assertThat(value.toString(), is("84"));

        value.setValue(255);
        assertThat(value.toString(), is("84"));
    }

    /**
     * Test spred conversion when link is on and size is 24.0.
     */
    @Test
    public void testReverbSpredValueToString_size24() {
        link.setValue(true);
        size.setValue(24.0);

        value.setValue(0);
        assertThat(value.toString(), is("0"));

        value.setValue(2);
        assertThat(value.toString(), is("0"));

        value.setValue(3);
        assertThat(value.toString(), is("1"));

        value.setValue(120);
        assertThat(value.toString(), is("42"));

        value.setValue(254);
        assertThat(value.toString(), is("88"));

        value.setValue(255);
        assertThat(value.toString(), is("89"));
    }

    /**
     * Test spred conversion when link is on and size is 28.0.
     */
    @Test
    public void testReverbSpredValueToString_size28() {
        link.setValue(true);
        size.setValue(28.0);

        value.setValue(0);
        assertThat(value.toString(), is("0"));

        value.setValue(2);
        assertThat(value.toString(), is("0"));

        value.setValue(3);
        assertThat(value.toString(), is("1"));

        value.setValue(120);
        assertThat(value.toString(), is("48"));

        value.setValue(254);
        assertThat(value.toString(), is("101"));

        value.setValue(255);
        assertThat(value.toString(), is("102"));
    }

    /**
     * Test spred conversion when link is on and size is 35.0.
     */
    @Test
    public void testReverbSpredValueToString_size35() {
        link.setValue(true);
        size.setValue(35.0);

        value.setValue(0);
        assertThat(value.toString(), is("0"));

        value.setValue(2);
        assertThat(value.toString(), is("0"));

        value.setValue(3);
        assertThat(value.toString(), is("1"));

        value.setValue(39);
        assertThat(value.toString(), is("19"));

        value.setValue(41);
        assertThat(value.toString(), is("19"));

        value.setValue(254);
        assertThat(value.toString(), is("123"));

        value.setValue(255);
        assertThat(value.toString(), is("124"));
    }

    /**
     * Test spred conversion when link is on and size is 53.0.
     */
    @Test
    public void testReverbSpredValueToString_size53() {
        link.setValue(true);
        size.setValue(53.0);

        value.setValue(0);
        assertThat(value.toString(), is("0"));

        value.setValue(1);
        assertThat(value.toString(), is("0"));

        value.setValue(2);
        assertThat(value.toString(), is("1"));

        value.setValue(125);
        assertThat(value.toString(), is("89"));

        value.setValue(254);
        assertThat(value.toString(), is("180"));

        value.setValue(255);
        assertThat(value.toString(), is("181"));
    }

    /**
     * Test spred conversion when link is on and size is 53.5.
     */
    @Test
    public void testReverbSpredValueToString_size53_5() {
        link.setValue(true);
        size.setValue(53.5);
        value.setValue(164);
        assertThat(value.toString(), is("117"));
    }

}
