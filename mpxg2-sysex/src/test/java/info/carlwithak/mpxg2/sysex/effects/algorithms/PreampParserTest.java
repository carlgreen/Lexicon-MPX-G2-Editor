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

import info.carlwithak.mpxg2.model.effects.algorithms.Preamp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class PreampParserTest {

    @Test
    public void testParse_RotaryCab() {
        byte[] effectParameters = {7, 0, 3, 0, 0, 0, 11, 15, 0, 0, 0, 2, 7, 1, 6, 1, 0, 0, 0, 0, 13, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Preamp preamp = PreampParser.parse(effectParameters);
        assertEquals(7, preamp.getLo());
        assertEquals(3, preamp.getMid());
        assertEquals(0, preamp.getHi());
        assertEquals(-5, preamp.getInLevel());
        assertEquals(0, preamp.getLoCut());
        assertEquals(32, preamp.getFeel());
        assertEquals(23, preamp.getDrive());
        assertEquals(22, preamp.getTone());
        assertEquals(0, preamp.getBass());
        assertEquals(0, preamp.getTreble());
        assertEquals(45, preamp.getLevel());
    }
}
