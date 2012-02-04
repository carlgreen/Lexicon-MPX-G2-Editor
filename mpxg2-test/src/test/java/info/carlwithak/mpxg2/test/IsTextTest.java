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
import info.carlwithak.mpxg2.model.parameters.TextValue;
import org.hamcrest.Description;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsText.text;
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
public class IsTextTest {
    private final TextValue text = new TextValue(null, 20);
    private final Matcher<TextValue> isText = text("something");
    private final Matcher<TextValue> nullIsText = text(null);

    @Test
    public void testMatches() {
        assertThat(isText.matches("something"), is(false));
        text.setValue("something");
        assertThat(isText.matches(text), is(true));
        text.setValue("something else");
        assertThat(isText.matches(text), is(false));
        text.setValue(null);
        assertThat(isText.matches(text), is(false));
        assertThat(nullIsText.matches(text), is(true));
    }

    @Test
    public void testDescription() {
        Description d = mock(Description.class);
        when(d.appendText(any(String.class))).thenReturn(d);
        isText.describeTo(d);
        verify(d).appendValue("something");
    }

}
