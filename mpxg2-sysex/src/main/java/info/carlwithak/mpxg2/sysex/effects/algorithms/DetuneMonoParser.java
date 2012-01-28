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

import info.carlwithak.mpxg2.model.effects.algorithms.DetuneMono;

/**
 * Class to parse parameter data for Detune (D) effect.
 *
 * @author Carl Green
 */
public class DetuneMonoParser {

    public static DetuneMono parse(byte[] effectParameters) {
        DetuneMono detuneMono = new DetuneMono();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        detuneMono.mix.setValue(mix);

        int level = effectParameters[2] + effectParameters[3] * 16;
        detuneMono.level.setValue(level);

        int tune = effectParameters[4] + effectParameters[5] * 16;
        detuneMono.tune.setValue(tune);

        int optimize = effectParameters[6] + effectParameters[7] * 16;
        detuneMono.optimize.setValue(optimize);

        int preDelay = effectParameters[8] + effectParameters[9] * 16;
        detuneMono.preDelay.setValue(preDelay);

        return detuneMono;
    }

}
