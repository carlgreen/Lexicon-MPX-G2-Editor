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

import info.carlwithak.mpxg2.model.effects.algorithms.ChorusDetuneMono;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class ChorusDetuneMonoParserTest {

    @Test
    public void testParse() {
        byte[] effectParameters = {2, 3, 6, 0, 10, 0, 10, 0, 0, 0, 13, 2, 14, 1, 8, 3, 0, 0, 0, 0, 6, 3, 0, 0, 13, 14, 0, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ChorusDetuneMono detuneMono = ChorusDetuneMonoParser.parse(effectParameters);
        assertEquals(50, (int) detuneMono.getMix().getValue());
        assertEquals(6, (int) detuneMono.getLevel().getValue());
        assertEquals(10, (int) detuneMono.getTune().getValue());
        assertEquals(10, detuneMono.getOptimize());
        assertEquals(0, (int) detuneMono.getPreDelay().getValue());
    }
}
