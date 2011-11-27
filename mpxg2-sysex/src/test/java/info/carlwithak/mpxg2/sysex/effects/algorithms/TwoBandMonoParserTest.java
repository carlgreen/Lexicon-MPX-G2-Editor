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

import info.carlwithak.mpxg2.model.effects.algorithms.TwoBandMono;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class TwoBandMonoParserTest {

    @Test
    public void testParse_SpaceEcho() {
        byte[] effectParameters = {4, 6, 0, 0, 11, 15, 8, 12, 0, 0, 7, 0, 0, 0, 9, 15, 8, 8, 3, 1, 7, 0, 2, 0, 10, 0, 4, 10, 6, 0, 15, 0, 1, 0, 8, 11, 8, 13, 14, 0, 7, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        TwoBandMono twoBandMono = TwoBandMonoParser.parse(effectParameters);
        assertEquals(100, (int) twoBandMono.getMix().getValue());
        assertEquals(0, (int) twoBandMono.getLevel().getValue());
        assertEquals(-5, (int) twoBandMono.getGain1().getValue());
        assertEquals(200, (int) twoBandMono.getFc1().getValue());
        assertEquals(0.7, twoBandMono.getQ1().getValue(), 0.01);
        assertEquals(0, (int) twoBandMono.getMode1().getValue()); // LShlf
        assertEquals(-7, (int) twoBandMono.getGain2().getValue());
        assertEquals(5000, (int) twoBandMono.getFc2().getValue());
        assertEquals(0.7, twoBandMono.getQ2().getValue(), 0.01);
        assertEquals(2, (int) twoBandMono.getMode2().getValue()); // HShlf
    }
}
