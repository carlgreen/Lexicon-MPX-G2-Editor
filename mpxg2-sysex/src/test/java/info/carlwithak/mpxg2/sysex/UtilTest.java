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

package info.carlwithak.mpxg2.sysex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carl Green
 */
public class UtilTest {

    @Test
    public void testParseBoolean() {
        assertFalse(Util.parseBoolean(0));
        assertTrue(Util.parseBoolean(1));
    }

    @Test
    public void testWrapInteger() {
        assertEquals(0, Util.wrapInteger(0));
        assertEquals(1, Util.wrapInteger(1));
        assertEquals(1000, Util.wrapInteger(1000));
        assertEquals(-500, Util.wrapInteger(65036));
        assertEquals(-1200, Util.wrapInteger(64336));
    }

}
