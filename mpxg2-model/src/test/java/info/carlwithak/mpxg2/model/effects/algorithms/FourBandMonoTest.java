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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Carl Green
 */
public class FourBandMonoTest {
    private final FourBandMono fourBandMono = new FourBandMono();

    @Test
    public void testMix() {
        assertEquals("%", fourBandMono.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", fourBandMono.getParameter(1).getUnit());
    }

    @Test
    public void testGain1() {
        assertEquals("dB", fourBandMono.getParameter(2).getUnit());
    }

    @Test
    public void testGain2() {
        assertEquals("dB", fourBandMono.getParameter(3).getUnit());
    }

    @Test
    public void testGain3() {
        assertEquals("dB", fourBandMono.getParameter(4).getUnit());
    }

    @Test
    public void testGain4() {
        assertEquals("dB", fourBandMono.getParameter(5).getUnit());
    }

    @Test
    public void testFc1() {
        assertEquals("Hz", fourBandMono.getParameter(6).getUnit());
    }

    @Test
    public void testFc2() {
        assertEquals("Hz", fourBandMono.getParameter(7).getUnit());
    }

    @Test
    public void testFc3() {
        assertEquals("Hz", fourBandMono.getParameter(8).getUnit());
    }

    @Test
    public void testFc4() {
        assertEquals("Hz", fourBandMono.getParameter(9).getUnit());
    }

    @Test
    public void testQ1() {
        assertEquals("", fourBandMono.getParameter(10).getUnit());
    }

    @Test
    public void testQ2() {
        assertEquals("", fourBandMono.getParameter(11).getUnit());
    }

    @Test
    public void testQ3() {
        assertEquals("", fourBandMono.getParameter(12).getUnit());
    }

    @Test
    public void testQ4() {
        assertEquals("", fourBandMono.getParameter(13).getUnit());
    }

    @Test
    public void testMode1() {
        assertEquals("", fourBandMono.getParameter(14).getUnit());
    }

    @Test
    public void testMode2() {
        assertEquals("", fourBandMono.getParameter(15).getUnit());
    }

    @Test
    public void testMode3() {
        assertEquals("", fourBandMono.getParameter(16).getUnit());
    }

    @Test
    public void testMode4() {
        assertEquals("", fourBandMono.getParameter(17).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(fourBandMono.getParameter(18));
    }
}
