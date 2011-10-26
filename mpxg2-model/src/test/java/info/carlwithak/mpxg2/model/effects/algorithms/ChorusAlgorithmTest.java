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
public class ChorusAlgorithmTest {
    private ChorusAlgorithm chorus;

    @Before
    public void setUp() {
        chorus = new ChorusAlgorithm();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(ChorusAlgorithm.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", chorus.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", chorus.getParameter(1).getUnit());
    }

    @Test
    public void testRate1() {
        chorus.setRate1(new FrequencyRate("Rate1", 0.5));
        assertEquals("Rate1", chorus.getParameter(2).getName());
        assertEquals("Hz", chorus.getParameter(2).getUnit());
    }

    @Test
    public void testPulseWidth1() {
        assertEquals("%", chorus.getParameter(3).getUnit());
    }

    @Test
    public void testDepth1() {
        assertEquals("%", chorus.getParameter(4).getUnit());
    }

    @Test
    public void testRate2() {
        chorus.setRate2(new FrequencyRate("Rate2", 0.5));
        assertEquals("Rate2", chorus.getParameter(5).getName());
        assertEquals("Hz", chorus.getParameter(5).getUnit());
    }

    @Test
    public void testPulseWidth2() {
        assertEquals("%", chorus.getParameter(6).getUnit());
    }

    @Test
    public void testDepth2() {
        assertEquals("%", chorus.getParameter(7).getUnit());
    }

    @Test
    public void testRes1() {
        assertEquals("", chorus.getParameter(8).getUnit());
    }

    @Test
    public void testRes2() {
        assertEquals("", chorus.getParameter(9).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(chorus.getParameter(10));
    }
}
