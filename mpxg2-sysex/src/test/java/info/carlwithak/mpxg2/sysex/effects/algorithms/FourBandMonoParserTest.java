/*
 *  Copyright (C) 2012 Carl Green
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

import info.carlwithak.mpxg2.model.effects.algorithms.FourBandMono;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class FourBandMonoParserTest {

    @Test
    public void testParse_PhoneFilter() {
        byte[] effectParameters = {4, 6, 0, 0, 8, 11, 4, 3, 3, 0, 7, 0, 0, 0, 6, 0, 0, 11, 4, 0, 9, 1, 0, 0, 10, 0, 4, 10, 6, 0, 15, 0, 1, 0, 8, 11, 8, 13, 14, 0, 7, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        FourBandMono fourBandMono = FourBandMonoParser.parse(effectParameters);
        assertThat(fourBandMono.getMix(), is(value(100)));
        assertThat(fourBandMono.getLevel(), is(value(0)));
        assertThat(fourBandMono.getGain1(), is(value(-72)));
        assertThat(fourBandMono.getFc1(), is(value(820)));
        assertThat(fourBandMono.getQ1(), is(value(0.7)));
        assertThat(fourBandMono.getMode1(), is(value(0))); // LShlf
        assertThat(fourBandMono.getGain2(), is(value(6)));
        assertThat(fourBandMono.getFc2(), is(value(1200)));
        assertThat(fourBandMono.getQ2(), is(value(2.5)));
        assertThat(fourBandMono.getMode2(), is(value(0))); // LShlf
        assertThat(fourBandMono.getGain3(), is(value(10)));
        assertThat(fourBandMono.getFc3(), is(value(1700)));
        assertThat(fourBandMono.getQ3(), is(value(1.5)));
        assertThat(fourBandMono.getMode3(), is(value(1))); // Band
        assertThat(fourBandMono.getGain4(), is(value(-72)));
        assertThat(fourBandMono.getFc4(), is(value(3800)));
        assertThat(fourBandMono.getQ4(), is(value(0.7)));
        assertThat(fourBandMono.getMode4(), is(value(2))); // HShlf
    }

}
