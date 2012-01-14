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

package info.carlwithak.mpxg2.model.effects.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Carl Green
 */
public class RedCompTest {
    private RedComp redComp = new RedComp();

    @Test
    public void testMix() {
        assertEquals("%", redComp.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", redComp.getParameter(1).getUnit());
    }

    @Test
    public void testSensitivity() {
        assertEquals("", redComp.getParameter(2).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(redComp.getParameter(3));
    }
}
