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

import info.carlwithak.mpxg2.model.effects.algorithms.FlangerStereo;
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
public class FlangerStereoParserTest {

    @Test
    public void testParse_VybeFlange() throws ParseException {
        byte[] effectParameters = {3, 4, 1, 0, 1, 0, 4, 0, 1, 0, 2, 3, 14, 3, 1, 0, 4, 1, 0, 0, 6, 3, 0, 0, 13, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        FlangerStereo flangerStereo = FlangerStereoParser.parse(effectParameters);
        assertThat(flangerStereo.mix, is(value(67)));
        assertThat(flangerStereo.level, is(value(1)));
        assertThat(flangerStereo.getRate(), is(beat(1, 4)));
        assertThat(flangerStereo.getPulseWidth(), is(value(50)));
        assertThat(flangerStereo.getDepth(), is(value(62)));
        assertThat(flangerStereo.getPhase(), is(value(1))); // 0, 90, 180, 270 degrees
        assertThat(flangerStereo.getResonance(), is(value(20)));
        assertThat(flangerStereo.getBlend(), is(value(0)));
    }
}
