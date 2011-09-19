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

/**
 * Class to parse parameter data for Chamber effect.
 *
 * @author Carl Green
 */
public class ChamberParser {

    public static Chamber parse(byte[] reverbParameters) {
        Chamber chamber = new Chamber();

        int mix = reverbParameters[0] + reverbParameters[1] * 16;
        chamber.setMix(mix);

        int level = (byte) (reverbParameters[2] + reverbParameters[3] * 16);
        chamber.setLevel(level);

        double size = (reverbParameters[4] + reverbParameters[5] * 16) / 2.0 + 4;
        chamber.setSize(size);

        int link = reverbParameters[6] + reverbParameters[7] * 16;
        chamber.setLink(link);

        int diff = (reverbParameters[8] + reverbParameters[9] * 16) * 2;
        chamber.setDiff(diff);

        int preDelay = reverbParameters[10] + reverbParameters[11] * 16;
        chamber.setPreDelay(preDelay);

        int bass = reverbParameters[12] + reverbParameters[13] * 16;
        chamber.setBass(bass);

        int decay = reverbParameters[14] + reverbParameters[15] * 16;
        chamber.setDecay(decay);

        int xovr = reverbParameters[16] + reverbParameters[17] * 16;
        chamber.setXovr(xovr);

        int rtHC = reverbParameters[18] + reverbParameters[19] * 16;
        chamber.setRtHC(rtHC);

        int shape = reverbParameters[20] + reverbParameters[21] * 16;
        chamber.setShape(shape);

        int spred = reverbParameters[22] + reverbParameters[23] * 16;
        chamber.setSpred(spred);

        return chamber;
    }
}
