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
public class DigiDrive2Test {
    private DigiDrive2 digiDrive2 = new DigiDrive2();

    @Test
    public void testMix() {
        assertEquals("%", digiDrive2.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", digiDrive2.getParameter(1).getUnit());
    }

    @Test
    public void testDrive() {
        assertEquals("", digiDrive2.getParameter(2).getUnit());
    }

    @Test
    public void testLow() {
        assertEquals("dB", digiDrive2.getParameter(3).getUnit());
    }

    @Test
    public void testMid() {
        assertEquals("dB", digiDrive2.getParameter(4).getUnit());
    }

    @Test
    public void testHigh() {
        assertEquals("dB", digiDrive2.getParameter(5).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(digiDrive2.getParameter(6));
    }
}
