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
public class SplitPreampTest {
    private final SplitPreamp splitPreamp = new SplitPreamp();

    @Test
    public void testLo() {
        assertEquals("dB", splitPreamp.getParameter(0).getUnit());
    }

    @Test
    public void testMid() {
        assertEquals("dB", splitPreamp.getParameter(1).getUnit());
    }

    @Test
    public void testHi() {
        assertEquals("dB", splitPreamp.getParameter(2).getUnit());
    }

    @Test
    public void testInLvl() {
        assertEquals("dB", splitPreamp.getParameter(3).getUnit());
    }

    @Test
    public void testLoCut() {
        assertEquals("", splitPreamp.getParameter(4).getUnit());
    }

    @Test
    public void testFeel() {
        assertEquals("", splitPreamp.getParameter(5).getUnit());
    }

    @Test
    public void testDrive() {
        assertEquals("", splitPreamp.getParameter(6).getUnit());
    }

    @Test
    public void testTone() {
        assertEquals("", splitPreamp.getParameter(7).getUnit());
    }

    @Test
    public void testBass() {
        assertEquals("dB", splitPreamp.getParameter(8).getUnit());
    }

    @Test
    public void testTreble() {
        assertEquals("dB", splitPreamp.getParameter(9).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", splitPreamp.getParameter(10).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(splitPreamp.getParameter(11));
    }
}
