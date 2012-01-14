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

import info.carlwithak.mpxg2.model.effects.algorithms.Wah2;

/**
 * Class to parse parameter data for Wah 2 effect.
 *
 * @author Carl Green
 */
public class Wah2Parser {

    public static Wah2 parse(byte[] effectParameters) {
        Wah2 wah2 = new Wah2();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        wah2.getMix().setValue(mix);

        int level = effectParameters[2] + effectParameters[3] * 16;
        wah2.getLevel().setValue(level);

        int sweep = effectParameters[4] + effectParameters[5] * 16;
        wah2.setSweep(sweep);

        int bass = effectParameters[6] + effectParameters[7] * 16;
        wah2.setBass(bass);

        int type = effectParameters[8] + effectParameters[9] * 16;
        wah2.setType(type);

        int response = effectParameters[10] + effectParameters[11] * 16;
        wah2.setResponse(response);

        int gain = effectParameters[12] + effectParameters[13] * 16;
        wah2.setGain(gain);

        return wah2;
    }
}
