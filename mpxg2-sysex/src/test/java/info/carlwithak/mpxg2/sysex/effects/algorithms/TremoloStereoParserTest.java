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

import info.carlwithak.mpxg2.model.effects.algorithms.TremoloStereo;
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
public class TremoloStereoParserTest {

    @Test
    public void testParse_Verbolo() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 12, 2, 1, 0, 0, 0, 2, 3, 4, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        TremoloStereo tremoloStereo = TremoloStereoParser.parse(effectParameters);
        assertThat(tremoloStereo.getMix(), is(value(100)));
        assertThat(tremoloStereo.getLevel(), is(value(0)));
        assertThat(tremoloStereo.getRate(), is(frequency(3.0)));
        assertThat(tremoloStereo.getPulseWidth(), is(value(50)));
        assertThat(tremoloStereo.getDepth(), is(value(100)));
        assertThat(tremoloStereo.getPhase(), is(value(3))); // 270°
    }
}
