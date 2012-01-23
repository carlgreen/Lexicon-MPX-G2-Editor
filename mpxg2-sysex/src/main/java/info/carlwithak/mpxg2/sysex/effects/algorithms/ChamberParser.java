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

import info.carlwithak.mpxg2.model.effects.algorithms.Chamber;
import info.carlwithak.mpxg2.sysex.Util;

/**
 * Class to parse parameter data for Chamber effect.
 *
 * @author Carl Green
 */
public class ChamberParser {

    public static Chamber parse(byte[] effectParameters) {
        Chamber chamber = new Chamber();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        chamber.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        chamber.level.setValue(level);

        double size = (effectParameters[4] + effectParameters[5] * 16) / 2.0 + 4;
        chamber.getSize().setValue(size);

        int link = effectParameters[6] + effectParameters[7] * 16;
        chamber.getLink().setValue(Util.parseBoolean(link));

        int diff = (effectParameters[8] + effectParameters[9] * 16) * 2;
        chamber.getDiff().setValue(diff);

        int preDelay = effectParameters[10] + effectParameters[11] * 16;
        chamber.getPreDelay().setValue(preDelay);

        int bass = effectParameters[12] + effectParameters[13] * 16;
        chamber.getBass().setValue(bass);

        int decay = effectParameters[14] + effectParameters[15] * 16;
        chamber.getDecay().setValue(decay);

        int xovr = effectParameters[16] + effectParameters[17] * 16;
        chamber.getXovr().setValue(xovr);

        int rtHC = effectParameters[18] + effectParameters[19] * 16;
        chamber.getRtHC().setValue(rtHC);

        int shape = effectParameters[20] + effectParameters[21] * 16;
        chamber.getShape().setValue(shape);

        int spred = effectParameters[22] + effectParameters[23] * 16;
        chamber.getSpred().setValue(spred);

        return chamber;
    }
}
