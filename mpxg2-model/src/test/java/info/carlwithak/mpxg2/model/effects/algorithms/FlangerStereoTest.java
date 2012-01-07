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
public class FlangerStereoTest {
    private FlangerStereo flangerStereo;

    @Before
    public void setUp() {
        flangerStereo = new FlangerStereo();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(FlangerStereo.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", flangerStereo.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", flangerStereo.getParameter(1).getUnit());
    }

    @Test
    public void testRate() {
        flangerStereo.setRate(new FrequencyRate("Rate", 0.5));
        assertEquals("Rate", flangerStereo.getParameter(2).getName());
        assertEquals("Hz", flangerStereo.getParameter(2).getUnit());
    }

    @Test
    public void testPulseWidth() {
        assertEquals("%", flangerStereo.getParameter(3).getUnit());
    }

    @Test
    public void testDepth() {
        assertEquals("%", flangerStereo.getParameter(4).getUnit());
    }

    @Test
    public void testPhase() {
        assertEquals("°", flangerStereo.getParameter(5).getUnit());
    }

    @Test
    public void testRes() {
        assertEquals("%", flangerStereo.getParameter(6).getUnit());
    }

    @Test
    public void testBlend() {
        assertEquals("%", flangerStereo.getParameter(7).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(flangerStereo.getParameter(8));
    }
}
