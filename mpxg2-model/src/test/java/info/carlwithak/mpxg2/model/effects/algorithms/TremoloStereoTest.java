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
public class TremoloStereoTest {
    private TremoloStereo tremoloStereo = new TremoloStereo();

    @Test
    public void testMix() {
        assertEquals("%", tremoloStereo.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", tremoloStereo.getParameter(1).getUnit());
    }

    @Test
    public void testRate() {
        tremoloStereo.setRate(new FrequencyRate("Rate", 0.5));
        assertEquals("Rate", tremoloStereo.getParameter(2).getName());
        assertEquals("Hz", tremoloStereo.getParameter(2).getUnit());
    }

    @Test
    public void testPulseWidth() {
        assertEquals("%", tremoloStereo.getParameter(3).getUnit());
    }

    @Test
    public void testDepth() {
        assertEquals("%", tremoloStereo.getParameter(4).getUnit());
    }

    @Test
    public void testPhase() {
        assertEquals("°", tremoloStereo.getParameter(5).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(tremoloStereo.getParameter(6));
    }
}
