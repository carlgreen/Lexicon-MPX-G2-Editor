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
public class PostMixTest {
    final private PostMix postMix = new PostMix();

    @Test
    public void testMix() {
        assertThat(postMix.getParameter(0).getName(), is("Mix"));
    }

    @Test
    public void testLevel() {
        assertThat(postMix.getParameter(1).getName(), is("Level"));
    }

    @Test
    public void testBypassLevel() {
        assertThat(postMix.getParameter(2).getName(), is("Bypass Level"));
    }

    @Test
    public void testInvalid() {
        assertThat(postMix.getParameter(3), is(nullValue()));
    }

}
