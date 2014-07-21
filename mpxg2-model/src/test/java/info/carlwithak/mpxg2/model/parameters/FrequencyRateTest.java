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
public class FrequencyRateTest {

    private FrequencyRate freqRate;
    private FrequencyRate sameFreqRate;
    private FrequencyRate differentFreqRate;
    private FrequencyRate nullFreqRate;

    @Before
    public void setup() {
        freqRate = new FrequencyRate("a", 1.0);
        sameFreqRate = new FrequencyRate("b", 1.0);
        differentFreqRate = new FrequencyRate("c", 2.0);
        nullFreqRate = new FrequencyRate("d", null);
    }

    @Test
    public void testGetName() {
        assertEquals("a", freqRate.getName());
    }

    @Test
    public void testGetAndSetFrequency() {
        assertEquals(1.0, freqRate.getFrequency(), 0.01);

        freqRate.setFrequency(3.0);
        assertEquals(3.0, freqRate.getFrequency(), 0.01);
    }

    @Test
    public void testIsSet() {
        assertThat(freqRate.isSet(), is(true));
        assertThat(nullFreqRate.isSet(), is(false));
    }

    @Test
    public void testGetDisplayString() {
        assertThat(freqRate.getDisplayString(), is("1.00Hz"));
    }

    @Test
    public void testEquals() {
        assertFalse(freqRate.equals(null));
        assertFalse(freqRate.equals("something else"));
        assertTrue(freqRate.equals(sameFreqRate));
        assertFalse(freqRate.equals(differentFreqRate));

        assertThat(freqRate.equals(nullFreqRate), is(false));
        assertThat(nullFreqRate.equals(freqRate), is(false));
        assertThat(nullFreqRate.equals(nullFreqRate), is(true));
    }

    @Test
    public void testHashCode() {
        assertEquals(freqRate.hashCode(), sameFreqRate.hashCode());
        assertNotSame(freqRate.hashCode(), differentFreqRate.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("FrequencyRate[frequency=1.0]", freqRate.toString());
    }
}
