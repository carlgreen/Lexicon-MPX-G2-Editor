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
public class BeatRateTest {

    private BeatRate beatRate;
    private BeatRate sameBeatRate;
    private BeatRate differentBeatRate;

    @Before
    public void setup() {
        beatRate = new BeatRate("a", 1, 2);
        sameBeatRate = new BeatRate("b", 1, 2);
        differentBeatRate = new BeatRate("c", 2, 1);
    }

    @Test
    public void testGetName() {
        assertEquals("a", beatRate.getName());
    }

    @Test
    public void testGetUnit() {
        assertEquals(":", beatRate.getUnit());
    }

    @Test
    public void testGetAndSetMeasures() {
        assertEquals(1, beatRate.getMeasures());

        beatRate.setMeasures(3);
        assertEquals(3, beatRate.getMeasures());
    }

    @Test
    public void testGetAndSetBeats() {
        assertEquals(2, beatRate.getBeats());

        beatRate.setBeats(4);
        assertEquals(4, beatRate.getBeats());
    }

    @Test
    public void testEquals() {
        assertFalse(beatRate.equals(null));
        assertFalse(beatRate.equals("something else"));
        assertTrue(beatRate.equals(sameBeatRate));
        assertFalse(beatRate.equals(differentBeatRate));
        differentBeatRate.setMeasures(1);
        assertFalse(beatRate.equals(differentBeatRate));
    }

    @Test
    public void testHashCode() {
        assertEquals(beatRate.hashCode(), sameBeatRate.hashCode());
        assertNotSame(beatRate.hashCode(), differentBeatRate.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("BeatRate{measures=1,beats=2}", beatRate.toString());
    }
}
