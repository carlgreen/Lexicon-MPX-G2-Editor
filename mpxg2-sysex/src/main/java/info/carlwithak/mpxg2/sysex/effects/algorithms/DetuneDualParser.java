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

    public static DetuneDual parse(byte[] effect1Parameters) {
        DetuneDual detuneDual = new DetuneDual();

        int mix = effect1Parameters[0] + effect1Parameters[1] * 16;
        detuneDual.setMix(mix);

        int level = effect1Parameters[2] + effect1Parameters[3] * 16;
        detuneDual.setLevel(level);

        int tune1 = effect1Parameters[4] + effect1Parameters[5] * 16;
        detuneDual.setTune1(tune1);

        int optimize = effect1Parameters[6] + effect1Parameters[7] * 16;
        detuneDual.setOptimize(optimize);

        int tune2 = effect1Parameters[8] + effect1Parameters[9] * 16;
        detuneDual.setTune2(tune2);

        int preDelay = effect1Parameters[10] + effect1Parameters[11] * 16;
        detuneDual.setPreDelay(preDelay);

        return detuneDual;
    }
}
