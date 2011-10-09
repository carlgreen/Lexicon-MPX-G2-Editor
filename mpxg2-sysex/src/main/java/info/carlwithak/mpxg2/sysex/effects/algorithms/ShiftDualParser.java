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

import info.carlwithak.mpxg2.model.effects.algorithms.ShiftDual;
import info.carlwithak.mpxg2.sysex.Util;

/**
 * Class to parse parameter data for Shift (D) effect.
 *
 * @author Carl Green
 */
public class ShiftDualParser {

    public static ShiftDual parse(byte[] effectParameters) {
        ShiftDual shiftDual = new ShiftDual();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        shiftDual.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        shiftDual.setLevel(level);

        int tune1 = 0;
        for (int i = 0; i < 4; i++) {
            tune1 += (effectParameters[4 + i] * Math.pow(16, i));
        }
        shiftDual.setTune1(Util.wrapInteger(tune1));

        int optimize = effectParameters[8] + effectParameters[9] * 16;
        shiftDual.setOptimize(optimize);

        int tune2 = 0;
        for (int i = 0; i < 4; i++) {
            tune2 += (effectParameters[10 + i] * Math.pow(16, i));
        }
        shiftDual.setTune2(Util.wrapInteger(tune2));

        int glide = effectParameters[14] + effectParameters[15] * 16;
        shiftDual.setGlide(Util.parseBoolean(glide));

        return shiftDual;
    }
}