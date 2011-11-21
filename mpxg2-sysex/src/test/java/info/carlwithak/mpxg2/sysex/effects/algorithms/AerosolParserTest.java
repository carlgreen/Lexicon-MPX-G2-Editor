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
import info.carlwithak.mpxg2.model.effects.algorithms.Aerosol;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class AerosolParserTest {

    @Test
    public void testParse_ToeWahAero() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 10, 1, 0, 0, 0, 0, 13, 2, 6, 4, 10, 1, 0, 0, 0, 0, 7, 3, 12, 3, 4, 12, 12, 3, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Aerosol aerosol = AerosolParser.parse(effectParameters);
        assertEquals(100, (int) aerosol.getMix().getValue());
        assertEquals(0, (int) aerosol.getLevel().getValue());
        assertEquals(new FrequencyRate("Rate1", 0.26), aerosol.getRate1());
        assertEquals(45, aerosol.getPulseWidth1());
        assertEquals(70, aerosol.getDepth1());
        assertEquals(new FrequencyRate("Rate2", 0.26), aerosol.getRate2());
        assertEquals(55, aerosol.getPulseWidth2());
        assertEquals(60, aerosol.getDepth2());
        assertEquals(-60, aerosol.getResonance1());
        assertEquals(60, aerosol.getResonance2());
    }
}
