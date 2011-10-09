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

import info.carlwithak.mpxg2.model.effects.algorithms.Hall;

/**
 * Class to parse parameter data for Hall effect.
 *
 * @author Carl Green
 */
public class HallParser {

    public static Hall parse(byte[] effectParameters) {
        Hall hall = new Hall();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        hall.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        hall.setLevel(level);

        double size = (effectParameters[4] + effectParameters[5] * 16) / 2.0 + 4;
        hall.setSize(size);

        int link = effectParameters[6] + effectParameters[7] * 16;
        hall.setLink(link);

        int diff = (effectParameters[8] + effectParameters[9] * 16) * 2;
        hall.setDiff(diff);

        int preDelay = effectParameters[10] + effectParameters[11] * 16;
        hall.setPreDelay(preDelay);

        int bass = effectParameters[12] + effectParameters[13] * 16;
        hall.setBass(bass);

        int decay = effectParameters[14] + effectParameters[15] * 16;
        hall.setDecay(decay);

        int xovr = effectParameters[16] + effectParameters[17] * 16;
        hall.setXovr(xovr);

        int rtHC = effectParameters[18] + effectParameters[19] * 16;
        hall.setRtHC(rtHC);

        int shape = effectParameters[20] + effectParameters[21] * 16;
        hall.setShape(shape);

        int spred = effectParameters[22] + effectParameters[23] * 16;
        hall.setSpred(spred);

        return hall;
    }
}
