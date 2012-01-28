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

import info.carlwithak.mpxg2.model.effects.algorithms.TestTone;

/**
 * Class to parse parameter data for Test Tone effect.
 *
 * @author Carl Green
 */
public class TestToneParser {

    public static TestTone parse(byte[] effectParameters) {
        TestTone testTone = new TestTone();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        testTone.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        testTone.level.setValue(level);

        int note = (byte) (effectParameters[4] + effectParameters[5] * 16);
        testTone.note.setValue(note);

        int balance = (byte) (effectParameters[6] + effectParameters[7] * 16);
        testTone.balance.setValue(balance);

        return testTone;
    }

}
