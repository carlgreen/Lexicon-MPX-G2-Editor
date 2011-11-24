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

import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.effects.algorithms.Flanger24Mono;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class Flanger24MonoParserTest {

    @Test
    public void testParse_Stomp() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 15, 1, 0, 0, 0, 0, 2, 3, 4, 2, 2, 14, 2, 3, 2, 3, 7, 3, 12, 3, 4, 12, 12, 3, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Flanger24Mono flanger24Mono = Flanger24MonoParser.parse(effectParameters);
        assertEquals(100, (int) flanger24Mono.getMix().getValue());
        assertEquals(0, (int) flanger24Mono.getLevel().getValue());
        assertEquals(new FrequencyRate("Rate", 0.31), flanger24Mono.getRate());
        assertEquals(50, (int) flanger24Mono.getPulseWidth().getValue());
        assertEquals(36, (int) flanger24Mono.getDepth().getValue());
        assertEquals(-30, (int) flanger24Mono.getResonance().getValue());
        assertEquals(50, (int) flanger24Mono.getGlide().getValue());
        assertEquals(50, (int) flanger24Mono.getBlend().getValue());
    }
}
