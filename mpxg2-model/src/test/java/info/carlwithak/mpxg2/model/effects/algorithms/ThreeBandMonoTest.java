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
public class ThreeBandMonoTest {
    private ThreeBandMono threeBandMono;

    @Before
    public void setUp() {
        threeBandMono = new ThreeBandMono();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(ThreeBandMono.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", threeBandMono.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", threeBandMono.getParameter(1).getUnit());
    }

    @Test
    public void testGain1() {
        assertEquals("dB", threeBandMono.getParameter(2).getUnit());
    }

    @Test
    public void testGain2() {
        assertEquals("dB", threeBandMono.getParameter(3).getUnit());
    }

    @Test
    public void testGain3() {
        assertEquals("dB", threeBandMono.getParameter(4).getUnit());
    }

    @Test
    public void testFc1() {
        assertEquals("Hz", threeBandMono.getParameter(5).getUnit());
    }

    @Test
    public void testFc2() {
        assertEquals("Hz", threeBandMono.getParameter(6).getUnit());
    }

    @Test
    public void testFc3() {
        assertEquals("Hz", threeBandMono.getParameter(7).getUnit());
    }

    @Test
    public void testQ1() {
        assertEquals("", threeBandMono.getParameter(8).getUnit());
    }

    @Test
    public void testQ2() {
        assertEquals("", threeBandMono.getParameter(9).getUnit());
    }

    @Test
    public void testQ3() {
        assertEquals("", threeBandMono.getParameter(10).getUnit());
    }

    @Test
    public void testMode1() {
        assertEquals("", threeBandMono.getParameter(11).getUnit());
    }

    @Test
    public void testMode2() {
        assertEquals("", threeBandMono.getParameter(12).getUnit());
    }

    @Test
    public void testMode3() {
        assertEquals("", threeBandMono.getParameter(13).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(threeBandMono.getParameter(14));
    }
}
