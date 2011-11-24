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
public class Centrifuge1Test {
    private Centrifuge1 centrifuge1;

    @Before
    public void setUp() {
        centrifuge1 = new Centrifuge1();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(Centrifuge1.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", centrifuge1.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", centrifuge1.getParameter(1).getUnit());
    }

    @Test
    public void testRate1() {
        centrifuge1.setRate1(new FrequencyRate("Rate1", 0.5));
        assertEquals("Rate1", centrifuge1.getParameter(2).getName());
        assertEquals("Hz", centrifuge1.getParameter(2).getUnit());
    }

    @Test
    public void testPulseWidth1() {
        assertEquals("%", centrifuge1.getParameter(3).getUnit());
    }

    @Test
    public void testSync1() {
        assertEquals("", centrifuge1.getParameter(4).getUnit());
    }

    @Test
    public void testDepth1() {
        assertEquals("%", centrifuge1.getParameter(5).getUnit());
    }

    @Test
    public void testRate2() {
        centrifuge1.setRate2(new FrequencyRate("Rate2", 0.5));
        assertEquals("Rate2", centrifuge1.getParameter(6).getName());
        assertEquals("Hz", centrifuge1.getParameter(6).getUnit());
    }

    @Test
    public void testPulseWidth2() {
        assertEquals("%", centrifuge1.getParameter(7).getUnit());
    }

    @Test
    public void testSync2() {
        assertEquals("", centrifuge1.getParameter(8).getUnit());
    }

    @Test
    public void testDepth2() {
        assertEquals("%", centrifuge1.getParameter(9).getUnit());
    }

    @Test
    public void testRes() {
        assertEquals("%", centrifuge1.getParameter(10).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(centrifuge1.getParameter(11));
    }
}
