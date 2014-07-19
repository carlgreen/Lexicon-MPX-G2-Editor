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

import info.carlwithak.mpxg2.model.parameters.FrequencyRate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Carl Green
 */
public class DelayDualTest {
    private final DelayDual delayDual = new DelayDual();

    @Test
    public void testMix() {
        assertEquals("%", delayDual.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", delayDual.getParameter(1).getUnit());
    }

    @Test
    public void testTime1() {
        delayDual.setTime1(new FrequencyRate("Time1", 0.5));
        assertEquals("Time1", delayDual.getParameter(2).getName());
        assertEquals("Hz", delayDual.getParameter(2).getUnit());
    }

    @Test
    public void testTime2() {
        delayDual.setTime2(new FrequencyRate("Time2", 0.5));
        assertEquals("Time2", delayDual.getParameter(3).getName());
        assertEquals("Hz", delayDual.getParameter(3).getUnit());
    }

    @Test
    public void testLevel1() {
        assertEquals("dB", delayDual.getParameter(4).getUnit());
    }

    @Test
    public void testLevel2() {
        assertEquals("dB", delayDual.getParameter(5).getUnit());
    }

    @Test
    public void testPan1() {
        assertEquals("LCR", delayDual.getParameter(6).getUnit());
    }

    @Test
    public void testPan2() {
        assertEquals("LCR", delayDual.getParameter(7).getUnit());
    }

    @Test
    public void testFeedback1() {
        assertEquals("%", delayDual.getParameter(8).getUnit());
    }

    @Test
    public void testFeedback2() {
        assertEquals("%", delayDual.getParameter(9).getUnit());
    }

    @Test
    public void testXFbk1() {
        assertEquals("%", delayDual.getParameter(10).getUnit());
    }

    @Test
    public void testXFbk2() {
        assertEquals("%", delayDual.getParameter(11).getUnit());
    }

    @Test
    public void testClear() {
        assertEquals("OnOff", delayDual.getParameter(12).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(delayDual.getParameter(13));
    }
}
