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

import org.hamcrest.Matcher;
import info.carlwithak.mpxg2.model.parameters.TapMsRate;
import info.carlwithak.mpxg2.model.parameters.Rate;
import org.hamcrest.Description;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsTapMs.tapMs;
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
public class IsTapMsTest {
    private final TapMsRate tapMs = new TapMsRate(null, null);
    private final Matcher<Rate> isTapMs = tapMs(1);
    private final Matcher<Rate> nullIsTapMs = tapMs(null);

    @Test
    public void testMatches() {
        assertThat(isTapMs.matches(1), is(false));
        tapMs.setMs(1);
        assertThat(isTapMs.matches(tapMs), is(true));
        tapMs.setMs(2);
        assertThat(isTapMs.matches(tapMs), is(false));
        tapMs.setMs(null);
        assertThat(isTapMs.matches(tapMs), is(false));
        assertThat(nullIsTapMs.matches(tapMs), is(true));
    }

    @Test
    public void testDescription() {
        Description d = mock(Description.class);
        when(d.appendText(any(String.class))).thenReturn(d);
        isTapMs.describeTo(d);
        verify(d).appendValue(1);
    }

}
