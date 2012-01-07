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
import info.carlwithak.mpxg2.model.parameters.FrequencyRate;
import java.beans.IntrospectionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Carl Green
 */
public class AerosolTest {
    private Aerosol aerosol;

    @Before
    public void setUp() {
        aerosol = new Aerosol();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(Aerosol.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", aerosol.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", aerosol.getParameter(1).getUnit());
    }

    @Test
    public void testRate1() {
        aerosol.setRate1(new FrequencyRate("Rate1", 0.5));
        assertEquals("Rate1", aerosol.getParameter(2).getName());
        assertEquals("Hz", aerosol.getParameter(2).getUnit());
    }

    @Test
    public void testPulseWidth1() {
        assertEquals("%", aerosol.getParameter(3).getUnit());
    }

    @Test
    public void testDepth1() {
        assertEquals("%", aerosol.getParameter(4).getUnit());
    }

    @Test
    public void testRate2() {
        aerosol.setRate2(new FrequencyRate("Rate2", 0.5));
        assertEquals("Rate2", aerosol.getParameter(5).getName());
        assertEquals("Hz", aerosol.getParameter(5).getUnit());
    }

    @Test
    public void testPulseWidth2() {
        assertEquals("%", aerosol.getParameter(6).getUnit());
    }

    @Test
    public void testDepth2() {
        assertEquals("%", aerosol.getParameter(7).getUnit());
    }

    @Test
    public void testRes1() {
        assertEquals("", aerosol.getParameter(8).getUnit());
    }

    @Test
    public void testRes2() {
        assertEquals("", aerosol.getParameter(9).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(aerosol.getParameter(10));
    }
}
