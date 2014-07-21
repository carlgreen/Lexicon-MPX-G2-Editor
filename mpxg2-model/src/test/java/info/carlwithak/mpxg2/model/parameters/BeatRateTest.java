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
package info.carlwithak.mpxg2.model.parameters;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carl Green
 */
public class BeatRateTest {

    private BeatRate beatRate;
    private BeatRate sameBeatRate;
    private BeatRate differentBeatRate;
    private BeatRate nullMeasureBeatRate;
    private BeatRate nullBeatBeatRate;
    private BeatRate nullBeatRate;

    @Before
    public void setup() {
        beatRate = new BeatRate("a", 1, 2);
        sameBeatRate = new BeatRate("b", 1, 2);
        differentBeatRate = new BeatRate("c", 2, 1);
        nullMeasureBeatRate = new BeatRate("d", null, 2);
        nullBeatBeatRate = new BeatRate("e", 1, null);
        nullBeatRate = new BeatRate("f", null, null);
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
        assertThat(beatRate.getMeasures(), is(1));

        beatRate.setMeasures(3);
        assertThat(beatRate.getMeasures(), is(3));
    }

    @Test
    public void testGetAndSetBeats() {
        assertThat(beatRate.getBeats(), is(2));

        beatRate.setBeats(4);
        assertThat(beatRate.getBeats(), is(4));
    }

    @Test
    public void testIsSet() {
        assertThat(nullBeatRate.isSet(), is(false));
        assertThat(nullMeasureBeatRate.isSet(), is(true));
        assertThat(nullBeatBeatRate.isSet(), is(true));
    }

    @Test
    public void testGetDisplayString() {
        assertThat(beatRate.getDisplayString(), is("1:2"));
    }

    @Test
    public void testEquals() {
        assertFalse(beatRate.equals(null));
        assertFalse(beatRate.equals("something else"));
        assertTrue(beatRate.equals(sameBeatRate));
        assertFalse(beatRate.equals(differentBeatRate));
        differentBeatRate.setMeasures(1);
        assertFalse(beatRate.equals(differentBeatRate));

        assertThat(nullMeasureBeatRate.equals(nullMeasureBeatRate), is(true));
        assertThat(beatRate.equals(nullMeasureBeatRate), is(false));
        assertThat(nullMeasureBeatRate.equals(beatRate), is(false));

        assertThat(nullBeatBeatRate.equals(nullBeatBeatRate), is(true));
        assertThat(beatRate.equals(nullBeatBeatRate), is(false));
        assertThat(nullBeatBeatRate.equals(beatRate), is(false));

        assertThat(nullBeatRate.equals(nullBeatRate), is(true));
    }

    @Test
    public void testHashCode() {
        assertEquals(beatRate.hashCode(), sameBeatRate.hashCode());
        assertNotSame(beatRate.hashCode(), differentBeatRate.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("BeatRate[measures=1,beats=2]", beatRate.toString());
    }
}
