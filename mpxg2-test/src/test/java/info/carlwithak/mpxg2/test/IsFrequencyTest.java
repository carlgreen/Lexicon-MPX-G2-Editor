/*
 *  Copyright (C) 2012 Carl Green
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

package info.carlwithak.mpxg2.test;

import info.carlwithak.mpxg2.model.parameters.FrequencyRate;
import info.carlwithak.mpxg2.model.parameters.Rate;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsFrequency.frequency;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Carl Green
 */
public class IsFrequencyTest {
    private final FrequencyRate frequency = new FrequencyRate(null, null);
    private final Matcher<Rate> isFrequency = frequency(1.0);
    private final Matcher<Rate> nullIsFrequency = frequency(null);

    @Test
    public void testMatches() {
        assertThat(isFrequency.matches(1.0), is(false));
        frequency.setFrequency(1.0);
        assertThat(isFrequency.matches(frequency), is(true));
        frequency.setFrequency(1.1);
        assertThat(isFrequency.matches(frequency), is(false));
        frequency.setFrequency(null);
        assertThat(isFrequency.matches(frequency), is(false));
        assertThat(nullIsFrequency.matches(frequency), is(true));
    }

    @Test
    public void testDescription() {
        Description d = mock(Description.class);
        when(d.appendText(any(String.class))).thenReturn(d);
        isFrequency.describeTo(d);
        verify(d).appendValue(1.0);
    }

}
