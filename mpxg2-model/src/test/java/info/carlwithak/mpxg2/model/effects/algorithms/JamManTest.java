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
public class JamManTest {
    private final JamMan jamMan = new JamMan();

    @Test
    public void testMix() {
        assertEquals("%", jamMan.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", jamMan.getParameter(1).getUnit());
    }

    @Test
    public void testSize() {
        assertEquals("ms", jamMan.getParameter(2).getUnit());
    }

    @Test
    public void testFeedback() {
        assertEquals("%", jamMan.getParameter(3).getUnit());
    }

    @Test
    public void testClear() {
        assertEquals("OnOff", jamMan.getParameter(4).getUnit());
    }

    @Test
    public void testLayer() {
        assertEquals("OnOff", jamMan.getParameter(5).getUnit());
    }

    @Test
    public void testReplace() {
        assertEquals("OnOff", jamMan.getParameter(6).getUnit());
    }

    @Test
    public void testDelay() {
        assertEquals("OnOff", jamMan.getParameter(7).getUnit());
    }

    @Test
    public void testMute() {
        assertEquals("OnOff", jamMan.getParameter(8).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(jamMan.getParameter(9));
    }
}
