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

import info.carlwithak.mpxg2.model.effects.algorithms.Ambience;
import info.carlwithak.mpxg2.sysex.Util;

/**
 * Class to parse parameter data for Ambience effect.
 *
 * @author Carl Green
 */
public class AmbienceParser {

    public static Ambience parse(byte[] effectParameters) {
        Ambience ambience = new Ambience();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        ambience.getMix().setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        ambience.getLevel().setValue(level);

        double size = (effectParameters[4] + effectParameters[5] * 16) / 2.0 + 4;
        ambience.getSize().setValue(size);

        int link = effectParameters[6] + effectParameters[7] * 16;
        ambience.getLink().setValue(Util.parseBoolean(link));

        int diff = (effectParameters[8] + effectParameters[9] * 16) * 2;
        ambience.getDiff().setValue(diff);

        int preDelay = effectParameters[10] + effectParameters[11] * 16;
        ambience.getPreDelay().setValue(preDelay);

        int decayTime = effectParameters[12] + effectParameters[13] * 16;
        ambience.getDecayTime().setValue(decayTime);

        int decayLevel = effectParameters[14] + effectParameters[15] * 16;
        ambience.getDecayLevel().setValue(decayLevel);

        int rtHC = effectParameters[16] + effectParameters[17] * 16;
        ambience.getRtHC().setValue(rtHC);

        return ambience;
    }
}
