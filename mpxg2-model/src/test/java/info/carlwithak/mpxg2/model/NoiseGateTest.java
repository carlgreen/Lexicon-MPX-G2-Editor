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
package info.carlwithak.mpxg2.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class NoiseGateTest {
    final private NoiseGate noiseGate = new NoiseGate();

    @Test
    public void testEnable() {
        assertThat(noiseGate.getParameter(0).getName(), is("Enable"));
    }

    @Test
    public void testSend() {
        assertThat(noiseGate.getParameter(1).getName(), is("Send"));
    }

    @Test
    public void testThreshold() {
        assertThat(noiseGate.getParameter(2).getName(), is("Thrsh"));
    }

    @Test
    public void testAttenuation() {
        assertThat(noiseGate.getParameter(3).getName(), is("Atten"));
    }

    @Test
    public void testOffset() {
        assertThat(noiseGate.getParameter(4).getName(), is("Offset"));
    }

    @Test
    public void testATime() {
        assertThat(noiseGate.getParameter(5).getName(), is("ATime"));
    }

    @Test
    public void testHTime() {
        assertThat(noiseGate.getParameter(6).getName(), is("HTime"));
    }

    @Test
    public void testRTime() {
        assertThat(noiseGate.getParameter(7).getName(), is("RTime"));
    }

    @Test
    public void testDelay() {
        assertThat(noiseGate.getParameter(8).getName(), is("Delay"));
    }

    @Test
    public void testInvalid() {
        assertThat(noiseGate.getParameter(9), is(nullValue()));
    }

}
