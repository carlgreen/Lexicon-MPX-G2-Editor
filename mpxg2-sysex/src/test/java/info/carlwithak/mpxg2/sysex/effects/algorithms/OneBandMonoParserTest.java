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

import info.carlwithak.mpxg2.model.effects.algorithms.OneBandMono;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class OneBandMonoParserTest {

    @Test
    public void testParse_OctaWah() {
        byte[] effectParameters = {4, 6, 0, 0, 9, 0, 9, 8, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        OneBandMono oneBandMono = OneBandMonoParser.parse(effectParameters);
        assertEquals(100, (int) oneBandMono.getMix().getValue());
        assertEquals(0, (int) oneBandMono.getLevel().getValue());
        assertEquals(9, (int) oneBandMono.getGain().getValue());
        assertEquals(393, (int) oneBandMono.getFc().getValue());
        assertEquals(0.1, oneBandMono.getQ().getValue(), 0.01);
        assertEquals(0, (int) oneBandMono.getMode().getValue());
    }
}
