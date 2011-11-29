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

import info.carlwithak.mpxg2.model.effects.algorithms.Aerosol;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsFrequency.frequency;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class AerosolParserTest {

    @Test
    public void testParse_ToeWahAero() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 10, 1, 0, 0, 0, 0, 13, 2, 6, 4, 10, 1, 0, 0, 0, 0, 7, 3, 12, 3, 4, 12, 12, 3, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Aerosol aerosol = AerosolParser.parse(effectParameters);
        assertThat(aerosol.getMix(), is(value(100)));
        assertThat(aerosol.getLevel(), is(value(0)));
        assertThat(aerosol.getRate1(), is(frequency(0.26)));
        assertThat(aerosol.getPulseWidth1(), is(value(45)));
        assertThat(aerosol.getDepth1(), is(value(70)));
        assertThat(aerosol.getRate2(), is(frequency(0.26)));
        assertThat(aerosol.getPulseWidth2(), is(value(55)));
        assertThat(aerosol.getDepth2(), is(value(60)));
        assertThat(aerosol.getResonance1(), is(value(-60)));
        assertThat(aerosol.getResonance2(), is(value(60)));
    }
}
