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

import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah2;

/**
 * Class to parse parameter data for Wah 1 effect.
 *
 * @author Carl Green
 */
public class PedalWah2Parser {

    public static PedalWah2 parse(byte[] effectParameters) {
        PedalWah2 pedalWah2 = new PedalWah2();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        pedalWah2.mix.setValue(mix);

        int level = effectParameters[2] + effectParameters[3] * 16;
        pedalWah2.level.setValue(level);

        int bass = effectParameters[4] + effectParameters[5] * 16;
        pedalWah2.bass.setValue(bass);

        int type = effectParameters[6] + effectParameters[7] * 16;
        pedalWah2.type.setValue(type);

        int response = effectParameters[8] + effectParameters[9] * 16;
        pedalWah2.response.setValue(response);

        int gain = effectParameters[10] + effectParameters[11] * 16;
        pedalWah2.gain.setValue(gain);

        return pedalWah2;
    }
}
