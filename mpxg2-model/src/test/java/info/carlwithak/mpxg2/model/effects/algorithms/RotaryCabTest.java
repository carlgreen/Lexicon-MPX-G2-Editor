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

import info.carlwithak.mpxg2.model.FrequencyRate;
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
public class RotaryCabTest {
    private RotaryCab rotaryCab;

    @Before
    public void setUp() {
        rotaryCab = new RotaryCab();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(RotaryCab.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", rotaryCab.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", rotaryCab.getParameter(1).getUnit());
    }

    @Test
    public void testRate1() {
        rotaryCab.setRate1(new FrequencyRate("Rate1", 0.5));
        assertEquals("Rate1", rotaryCab.getParameter(2).getName());
        assertEquals("Hz", rotaryCab.getParameter(2).getUnit());
    }

    @Test
    public void testDepth1() {
        assertEquals("%", rotaryCab.getParameter(3).getUnit());
    }

    @Test
    public void testRate2() {
        rotaryCab.setRate2(new FrequencyRate("Rate2", 0.5));
        assertEquals("Rate2", rotaryCab.getParameter(4).getName());
        assertEquals("Hz", rotaryCab.getParameter(4).getUnit());
    }

    @Test
    public void testDepth2() {
        assertEquals("%", rotaryCab.getParameter(5).getUnit());
    }

    @Test
    public void testRes() {
        assertEquals("", rotaryCab.getParameter(6).getUnit());
    }

    @Test
    public void testWidth() {
        assertEquals("%", rotaryCab.getParameter(7).getUnit());
    }

    @Test
    public void testBalance() {
        assertEquals("", rotaryCab.getParameter(8).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(rotaryCab.getParameter(9));
    }
}
