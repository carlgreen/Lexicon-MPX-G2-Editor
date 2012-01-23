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

import info.carlwithak.mpxg2.model.effects.algorithms.DetuneDual;

/**
 * Class to parse parameter data for Detune (D) effect.
 *
 * @author Carl Green
 */
public class DetuneDualParser {

    public static DetuneDual parse(byte[] effectParameters) {
        DetuneDual detuneDual = new DetuneDual();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        detuneDual.mix.setValue(mix);

        int level = effectParameters[2] + effectParameters[3] * 16;
        detuneDual.level.setValue(level);

        int tune1 = effectParameters[4] + effectParameters[5] * 16;
        detuneDual.getTune1().setValue(tune1);

        int optimize = effectParameters[6] + effectParameters[7] * 16;
        detuneDual.getOptimize().setValue(optimize);

        int tune2 = effectParameters[8] + effectParameters[9] * 16;
        detuneDual.getTune2().setValue(tune2);

        int preDelay = effectParameters[10] + effectParameters[11] * 16;
        detuneDual.getPreDelay().setValue(preDelay);

        return detuneDual;
    }
}
