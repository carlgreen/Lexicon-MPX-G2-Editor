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

import info.carlwithak.mpxg2.model.effects.algorithms.Tone;

/**
 * Class to parse parameter data for Tone effect.
 *
 * @author Carl Green
 */
public class ToneParser {

    public static Tone parse(byte[] effectParameters) {
        Tone tone = new Tone();

        int lo = effectParameters[0] + effectParameters[1] * 16;
        tone.getLo().setValue(lo);

        int mid = (byte) (effectParameters[2] + effectParameters[3] * 16);
        tone.getMid().setValue(mid);

        int hi = (byte) (effectParameters[4] + effectParameters[5] * 16);
        tone.getHi().setValue(hi);

        int inLevel = (byte) (effectParameters[6] + effectParameters[7] * 16);
        tone.getInLevel().setValue(inLevel);

        int level = (byte) (effectParameters[8] + effectParameters[9] * 16);
        tone.getLevel().setValue(level);

        return tone;
    }
}
