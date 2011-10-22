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
public class EchoDualTest {
    private EchoDual echoDual;

    @Before
    public void setUp() {
        echoDual = new EchoDual();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(EchoDual.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", echoDual.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", echoDual.getParameter(1).getUnit());
    }

    @Test
    public void testTime1() {
        echoDual.setTime1(new FrequencyRate(0.5));
        assertEquals("Hz", echoDual.getParameter(2).getUnit());
    }

    @Test
    public void testTime2() {
        echoDual.setTime2(new FrequencyRate(0.5));
        assertEquals("Hz", echoDual.getParameter(3).getUnit());
    }

    @Test
    public void testLevel1() {
        assertEquals("dB", echoDual.getParameter(4).getUnit());
    }

    @Test
    public void testLevel2() {
        assertEquals("dB", echoDual.getParameter(5).getUnit());
    }

    @Test
    public void testFeedback1() {
        assertEquals("%", echoDual.getParameter(6).getUnit());
    }

    @Test
    public void testFeedback2() {
        assertEquals("%", echoDual.getParameter(7).getUnit());
    }

    @Test
    public void testDamp1() {
        assertEquals("%", echoDual.getParameter(8).getUnit());
    }

    @Test
    public void testDamp2() {
        assertEquals("%", echoDual.getParameter(9).getUnit());
    }

    @Test
    public void testClear() {
        assertEquals("OnOff", echoDual.getParameter(10).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(echoDual.getParameter(11));
    }
}
