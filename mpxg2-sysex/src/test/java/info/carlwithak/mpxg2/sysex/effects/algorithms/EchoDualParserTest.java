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

import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsBeat.beat;
import static info.carlwithak.mpxg2.test.IsTapMs.tapMs;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class EchoDualParserTest {

    @Test
    public void testParse_G2Blue() throws ParseException {
        byte[] effectParameters = {2, 0, 1, 0, 4, 0, 4, 0, 1, 0, 2, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 3, 0, 1, 0, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertThat(echoDual.getMix(), is(value(2)));
        assertThat(echoDual.getLevel(), is(value(1)));
        assertThat(echoDual.getTime1(), is(beat(4, 4)));
        assertThat(echoDual.getTime2(), is(beat(2, 1)));
        assertThat(echoDual.getLevel1(), is(value(0)));
        assertThat(echoDual.getLevel2(), is(value(0)));
        assertThat(echoDual.getFeedback1(), is(value(1)));
        assertThat(echoDual.getInsert(), is(value(3)));
        assertThat(echoDual.getFeedback2(), is(value(1)));
        assertThat(echoDual.getDamp1(), is(value(20)));
        assertThat(echoDual.getDamp2(), is(value(20)));
        assertThat(echoDual.getClear(), is(value(false)));
    }

    @Test
    public void testParse_GuitarSolo() throws ParseException {
        byte[] effectParameters = {4, 6, 5, 0, 1, 0, 1, 0, 1, 0, 3, 0, 2, 0, 1, 0, 0, 0, 0, 0, 6, 15, 3, 0, 15, 0, 9, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertThat(echoDual.getMix(), is(value(100)));
        assertThat(echoDual.getLevel(), is(value(5)));
        assertThat(echoDual.getTime1(), is(beat(1, 1)));
        assertThat(echoDual.getTime2(), is(beat(3, 2)));
        assertThat(echoDual.getLevel1(), is(value(0)));
        assertThat(echoDual.getLevel2(), is(value(0)));
        assertThat(echoDual.getFeedback1(), is(value(-10)));
        assertThat(echoDual.getInsert(), is(value(3)));
        assertThat(echoDual.getFeedback2(), is(value(15)));
        assertThat(echoDual.getDamp1(), is(value(25)));
        assertThat(echoDual.getDamp2(), is(value(25)));
        assertThat(echoDual.getClear(), is(value(false)));
    }

    @Test
    public void testParse_Cordovox() throws ParseException {
        byte[] effectParameters = {14, 1, 0, 0, 1, 0, 1, 0, 1, 0, 4, 0, 3, 0, 1, 0, 0, 0, 0, 0, 6, 15, 3, 0, 12, 14, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertThat(echoDual.getMix(), is(value(30)));
        assertThat(echoDual.getLevel(), is(value(0)));
        assertThat(echoDual.getTime1(), is(beat(1, 1)));
        assertThat(echoDual.getTime2(), is(beat(4, 3)));
        assertThat(echoDual.getLevel1(), is(value(0)));
        assertThat(echoDual.getLevel2(), is(value(0)));
        assertThat(echoDual.getFeedback1(), is(value(-10)));
        assertThat(echoDual.getInsert(), is(value(3)));
        assertThat(echoDual.getFeedback2(), is(value(-20)));
        assertThat(echoDual.getDamp1(), is(value(20)));
        assertThat(echoDual.getDamp2(), is(value(20)));
        assertThat(echoDual.getClear(), is(value(false)));
    }

    @Test
    public void testParse_SlideComp() throws ParseException {
        byte[] effectParameters = {2, 1, 0, 0, 8, 12, 0, 0, 4, 0, 12, 2, 1, 0, 4, 0, 0, 0, 0, 0, 1, 15, 3, 0, 12, 14, 4, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        EchoDual echoDual = EchoDualParser.parse(effectParameters);
        assertThat(echoDual.getMix(), is(value(18)));
        assertThat(echoDual.getLevel(), is(value(0)));
        assertThat(echoDual.getTime1(), is(tapMs(200)));
        assertThat(echoDual.getTime2(), is(tapMs(300)));
        assertThat(echoDual.getLevel1(), is(value(0)));
        assertThat(echoDual.getLevel2(), is(value(0)));
        assertThat(echoDual.getFeedback1(), is(value(-15)));
        assertThat(echoDual.getInsert(), is(value(3)));
        assertThat(echoDual.getFeedback2(), is(value(-20)));
        assertThat(echoDual.getDamp1(), is(value(20)));
        assertThat(echoDual.getDamp2(), is(value(20)));
        assertThat(echoDual.getClear(), is(value(false)));
    }
}
