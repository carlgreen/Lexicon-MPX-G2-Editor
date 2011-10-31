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
import java.beans.IntrospectionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Carl Green
 */
public class TwoBandStereoTest {
    private TwoBandStereo twoBandStereo;

    @Before
    public void setUp() {
        twoBandStereo = new TwoBandStereo();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(TwoBandStereo.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", twoBandStereo.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", twoBandStereo.getParameter(1).getUnit());
    }

    @Test
    public void testGain1() {
        assertEquals("dB", twoBandStereo.getParameter(2).getUnit());
    }

    @Test
    public void testGain2() {
        assertEquals("dB", twoBandStereo.getParameter(3).getUnit());
    }

    @Test
    public void testFc1() {
        assertEquals("Hz", twoBandStereo.getParameter(4).getUnit());
    }

    @Test
    public void testFc2() {
        assertEquals("Hz", twoBandStereo.getParameter(5).getUnit());
    }

    @Test
    public void testQ1() {
        assertEquals("", twoBandStereo.getParameter(6).getUnit());
    }

    @Test
    public void testQ2() {
        assertEquals("", twoBandStereo.getParameter(7).getUnit());
    }

    @Test
    public void testMode1() {
        assertEquals("", twoBandStereo.getParameter(8).getUnit());
    }

    @Test
    public void testMode2() {
        assertEquals("", twoBandStereo.getParameter(9).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(twoBandStereo.getParameter(10));
    }
}
