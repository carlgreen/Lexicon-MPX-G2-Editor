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

import info.carlwithak.mpxg2.model.effects.algorithms.Comb1;
import org.junit.Test;

import static info.carlwithak.mpxg2.test.IsValue.value;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class Comb1ParserTest {

    @Test
    public void testParse_MicPlacement() {
        byte[] effectParameters = {4, 6, 0, 0, 4, 6, 0, 0, 4, 6, 9, 1, 0, 0, 14, 1, 4, 6, 0, 0, 0, 0, 4, 6, 8, 8, 11, 2, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Comb1 comb1 = Comb1Parser.parse(effectParameters);
        assertThat(comb1.mix, is(value(100)));
        assertThat(comb1.level, is(value(0)));
        assertThat(comb1.loCut, is(value(100)));
        assertThat(comb1.hiCut, is(value(6500)));
        assertThat(comb1.comb, is(value(0)));
        assertThat(comb1.notch, is(value(30)));
    }

}
