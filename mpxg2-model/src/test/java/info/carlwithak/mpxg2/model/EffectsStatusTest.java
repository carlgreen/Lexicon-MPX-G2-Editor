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
public class EffectsStatusTest {
    final private EffectsStatus effectsStatus = new EffectsStatus();

    @Test
    public void testEffect1() {
        assertThat(effectsStatus.getParameter(0).getName(), is("FX1"));
    }

    @Test
    public void testEffect2() {
        assertThat(effectsStatus.getParameter(1).getName(), is("FX2"));
    }

    @Test
    public void testChorus() {
        assertThat(effectsStatus.getParameter(2).getName(), is("Chrs"));
    }

    @Test
    public void testDelay() {
        assertThat(effectsStatus.getParameter(3).getName(), is("Dly"));
    }

    @Test
    public void testReverb() {
        assertThat(effectsStatus.getParameter(4).getName(), is("Rvb"));
    }

    @Test
    public void testEq() {
        assertThat(effectsStatus.getParameter(5).getName(), is("EQ"));
    }

    @Test
    public void testGain() {
        assertThat(effectsStatus.getParameter(6).getName(), is("Gain"));
    }

    @Test
    public void testInsert() {
        assertThat(effectsStatus.getParameter(7).getName(), is("Ins"));
    }

    @Test
    public void testInvalid() {
        assertThat(effectsStatus.getParameter(8), is(nullValue()));
    }

}
