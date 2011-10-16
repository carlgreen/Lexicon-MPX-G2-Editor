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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carl Green
 */
public class TapMsRateTest {

    private TapMsRate tapMsRate;
    private TapMsRate sameTapMsRate;
    private TapMsRate differentTapMsRate;

    @Before
    public void setup() {
        tapMsRate = new TapMsRate(100);
        sameTapMsRate = new TapMsRate(100);
        differentTapMsRate = new TapMsRate(200);
    }

    @Test
    public void testGetAndSetTapMs() {
        assertEquals(100, tapMsRate.getMs());

        tapMsRate.setMs(300);
        assertEquals(300, tapMsRate.getMs());
    }

    @Test
    public void testEquals() {
        assertFalse(tapMsRate.equals(null));
        assertFalse(tapMsRate.equals("something else"));
        assertTrue(tapMsRate.equals(sameTapMsRate));
        assertFalse(tapMsRate.equals(differentTapMsRate));
    }

    @Test
    public void testHashCode() {
        assertEquals(tapMsRate.hashCode(), sameTapMsRate.hashCode());
        assertNotSame(tapMsRate.hashCode(), differentTapMsRate.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("TapMsRate{ms=100}", tapMsRate.toString());
    }
}
