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

package info.carlwithak.mpxg2.sysex.effects.algorithms;

import info.carlwithak.mpxg2.model.effects.algorithms.JamMan;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Carl Green
 */
public class JamManParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {4, 6, 0, 0, 10, 15, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        JamMan jamMan = JamManParser.parse(effectParameters);
        assertEquals(100, (int) jamMan.getMix().getValue());
        assertEquals(0, (int) jamMan.getLevel().getValue());
        assertEquals(250, (int) jamMan.getSize().getValue());
        assertEquals(0, (int) jamMan.getFeedback().getValue());
        assertEquals(3, jamMan.getInsert());
        assertFalse(jamMan.isClear().getValue());
        assertFalse(jamMan.isLayer().getValue());
        assertFalse(jamMan.isReplace().getValue());
        assertFalse(jamMan.isDelay().getValue());
        assertFalse(jamMan.isMute().getValue());
    }
}
