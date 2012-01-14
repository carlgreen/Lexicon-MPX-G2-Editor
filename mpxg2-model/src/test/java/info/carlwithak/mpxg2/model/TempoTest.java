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

package info.carlwithak.mpxg2.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class TempoTest {
    final private Tempo tempo = new Tempo();

    @Test
    public void testRate() {
        assertThat(tempo.getParameter(0).getName(), is("Rate"));
    }

    @Test
    public void testSource() {
        assertThat(tempo.getParameter(1).getName(), is("Source"));
    }

    @Test
    public void testBeatValue() {
        assertThat(tempo.getParameter(2).getName(), is("Beat Value"));
    }

    @Test
    public void testTapSource() {
        assertThat(tempo.getParameter(3).getName(), is("Tap Source"));
    }

    @Test
    public void testAverage() {
        assertThat(tempo.getParameter(4).getName(), is("Tap Average"));
    }

    @Test
    public void testSourceLevel() {
        assertThat(tempo.getParameter(5).getName(), is("Scr Level"));
    }

    @Test
    public void testInvalid() {
        assertThat(tempo.getParameter(6), is(nullValue()));
    }

}
