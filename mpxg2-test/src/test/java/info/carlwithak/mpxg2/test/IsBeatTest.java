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

import info.carlwithak.mpxg2.model.parameters.BeatRate;
import info.carlwithak.mpxg2.model.parameters.Rate;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsBeat.beat;
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
public class IsBeatTest {
    private final BeatRate beat = new BeatRate(null, null, null);
    private final Matcher<Rate> isBeat = beat(1, 2);
    private final Matcher<Rate> nullIsBeat = beat(null, null);

    @Test
    public void testMatches() {
        assertThat(isBeat.matches(1), is(false));
        beat.setMeasures(1);
        beat.setBeats(2);
        assertThat(isBeat.matches(beat), is(true));
        beat.setMeasures(1);
        beat.setBeats(1);
        assertThat(isBeat.matches(beat), is(false));
        beat.setMeasures(2);
        beat.setBeats(1);
        assertThat(isBeat.matches(beat), is(false));
        beat.setMeasures(null);
        beat.setBeats(null);
        assertThat(isBeat.matches(beat), is(false));
        assertThat(nullIsBeat.matches(beat), is(true));
    }

    @Test
    public void testDescription() {
        final Description d = mock(Description.class);
        when(d.appendText(any(String.class))).thenReturn(d);
        isBeat.describeTo(d);
        verify(d).appendValue("1:2");
    }

}
