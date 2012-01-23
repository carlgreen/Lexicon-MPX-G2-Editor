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

import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsBeat.beat;
import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class DelayDualParserTest {

    @Test
    public void testParse_PowerChords() throws ParseException {
        byte[] effectParameters = {9, 1, 0, 0, 3, 0, 4, 0, 1, 0, 4, 0, 3, 0, 1, 0, 0, 0, 0, 0, 14, 12, 2, 3, 10, 0, 3, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DelayDual delayDual = DelayDualParser.parse(effectParameters);
        assertThat(delayDual.mix, is(value(25)));
        assertThat(delayDual.level, is(value(0)));
        assertThat(delayDual.getTime1(), is(beat(3, 4)));
        assertThat(delayDual.getTime2(), is(beat(4, 3)));
        assertThat(delayDual.getLevel1(), is(value(0)));
        assertThat(delayDual.getLevel2(), is(value(0)));
        assertThat(delayDual.getPan1(), is(value(-50)));
        assertThat(delayDual.getPan2(), is(value(50)));
        assertThat(delayDual.getFeedback1(), is(value(10)));
        assertThat(delayDual.getInsert(), is(value(3)));
        assertThat(delayDual.getFeedback2(), is(value(10)));
        assertThat(delayDual.getXFbk1(), is(value(0)));
        assertThat(delayDual.getXFbk2(), is(value(0)));
        assertThat(delayDual.getClear(), is(value(false)));
    }

    @Test
    public void testParse() throws ParseException {
        byte[] effectParameters = {3, 1, 0, 0, 1, 0, 1, 0, 1, 0, 4, 0, 3, 0, 1, 0, 0, 0, 0, 0, 14, 12, 2, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        DelayDual delayDual = DelayDualParser.parse(effectParameters);
        assertThat(delayDual.mix, is(value(19)));
        assertThat( delayDual.level, is(value(0)));
        assertThat(delayDual.getTime1(), is(beat(1, 1)));
        assertThat(delayDual.getTime2(), is(beat(4, 3)));
        assertThat(delayDual.getLevel1(), is(value(0)));
        assertThat(delayDual.getLevel2(), is(value(0)));
        assertThat(delayDual.getPan1(), is(value(-50)));
        assertThat(delayDual.getPan2(), is(value(50)));
        assertThat(delayDual.getFeedback1(), is(value(0)));
        assertThat(delayDual.getInsert(), is(value(3)));
        assertThat(delayDual.getFeedback2(), is(value(0)));
        assertThat(delayDual.getXFbk1(), is(value(0)));
        assertThat(delayDual.getXFbk2(), is(value(0)));
        assertThat(delayDual.getClear(), is(value(false)));
    }
}
