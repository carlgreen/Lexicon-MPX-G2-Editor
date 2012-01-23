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

import info.carlwithak.mpxg2.model.effects.algorithms.SweepFilter;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class SweepFilterParserTest {

    @Test
    public void testParse_EnvFilterLP() {
        byte[] effectParameters = {4, 6, 6, 0, 8, 5, 0, 0, 2, 2, 8, 4, 8, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SweepFilter sweepFilter = SweepFilterParser.parse(effectParameters);
        assertThat(sweepFilter.mix, is(value(100)));
        assertThat(sweepFilter.level, is(value(6)));
        assertThat(sweepFilter.getFc(), is(value(88)));
        assertThat(sweepFilter.getFRes(), is(value(34)));
        assertThat(sweepFilter.getMod(), is(value(2120)));
        assertThat(sweepFilter.getScale(), is(value(50)));
        assertThat(sweepFilter.getPan(), is(value(0)));
    }

    @Test
    public void testParse_TechnoChords() {
        byte[] effectParameters = {4, 6, 0, 0, 4, 1, 0, 0, 4, 2, 4, 14, 7, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SweepFilter sweepFilter = SweepFilterParser.parse(effectParameters);
        assertThat(sweepFilter.mix, is(value(100)));
        assertThat(sweepFilter.level, is(value(0)));
        assertThat(sweepFilter.getFc(), is(value(20)));
        assertThat(sweepFilter.getFRes(), is(value(36)));
        assertThat(sweepFilter.getMod(), is(value(2020)));
        assertThat(sweepFilter.getScale(), is(value(49)));
        assertThat(sweepFilter.getPan(), is(value(0)));
    }
}
