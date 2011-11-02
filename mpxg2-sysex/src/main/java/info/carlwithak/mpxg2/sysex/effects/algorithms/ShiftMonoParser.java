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

import info.carlwithak.mpxg2.model.effects.algorithms.ShiftMono;
import info.carlwithak.mpxg2.sysex.Util;

/**
 * Class to parse parameter data for Shift (M) effect.
 *
 * @author Carl Green
 */
public class ShiftMonoParser {

    public static ShiftMono parse(byte[] effectParameters) {
        ShiftMono shiftMono = new ShiftMono();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        shiftMono.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        shiftMono.setLevel(level);

        int tune1 = 0;
        for (int i = 0; i < 4; i++) {
            tune1 += (effectParameters[4 + i] * Math.pow(16, i));
        }
        shiftMono.setTune(Util.wrapInteger(tune1));

        int optimize = effectParameters[8] + effectParameters[9] * 16;
        shiftMono.setOptimize(optimize);

        int glide = effectParameters[10] + effectParameters[11] * 16;
        shiftMono.setGlide(Util.parseBoolean(glide));

        return shiftMono;
    }
}