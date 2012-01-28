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

import info.carlwithak.mpxg2.model.effects.algorithms.DetuneStereo;

/**
 * Class to parse parameter data for Detune (S) effect.
 *
 * @author Carl Green
 */
public class DetuneStereoParser {

    public static DetuneStereo parse(byte[] effectParameters) {
        DetuneStereo detuneStereo = new DetuneStereo();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        detuneStereo.mix.setValue(mix);

        int level = effectParameters[2] + effectParameters[3] * 16;
        detuneStereo.level.setValue(level);

        int tune = effectParameters[4] + effectParameters[5] * 16;
        detuneStereo.tune.setValue(tune);

        int optimize = effectParameters[6] + effectParameters[7] * 16;
        detuneStereo.optimize.setValue(optimize);

        int preDelay = effectParameters[8] + effectParameters[9] * 16;
        detuneStereo.preDelay.setValue(preDelay);

        return detuneStereo;
    }

}
