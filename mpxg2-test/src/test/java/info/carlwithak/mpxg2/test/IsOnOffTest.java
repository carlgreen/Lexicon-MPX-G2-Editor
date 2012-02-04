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
import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import org.hamcrest.Description;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsOnOff.off;
import static info.carlwithak.mpxg2.test.IsOnOff.on;
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
public class IsOnOffTest {
    private final OnOffValue value = new OnOffValue(null);
    private final Matcher<OnOffValue> onValue = on();
    private final Matcher<OnOffValue> offValue = off();

    @Test
    public void testOnMatches() {
        assertThat(onValue.matches(true), is(false));
        value.setValue(true);
        assertThat(onValue.matches(value), is(true));
        value.setValue(false);
        assertThat(onValue.matches(value), is(false));
        value.setValue(null);
        assertThat(onValue.matches(value), is(false));
    }

    @Test
    public void testOffMatches() {
        assertThat(offValue.matches(false), is(false));
        value.setValue(true);
        assertThat(offValue.matches(value), is(false));
        value.setValue(false);
        assertThat(offValue.matches(value), is(true));
        value.setValue(null);
        assertThat(offValue.matches(value), is(false));
    }

    @Test
    public void testOnDescription() {
        Description d = mock(Description.class);
        when(d.appendText(any(String.class))).thenReturn(d);
        onValue.describeTo(d);
        verify(d).appendValue(true);
    }

    @Test
    public void testOffDescription() {
        Description d = mock(Description.class);
        when(d.appendText(any(String.class))).thenReturn(d);
        offValue.describeTo(d);
        verify(d).appendValue(false);
    }

}
