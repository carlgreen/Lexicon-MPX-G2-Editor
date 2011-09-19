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

/**
 * Class to parse parameter data for Ambience effect.
 *
 * @author Carl Green
 */
public class AmbienceParser {

    public static Ambience parse(byte[] reverbParameters) {
        Ambience ambience = new Ambience();

        int mix = reverbParameters[0] + reverbParameters[1] * 16;
        ambience.setMix(mix);

        int level = (byte) (reverbParameters[2] + reverbParameters[3] * 16);
        ambience.setLevel(level);

        double size = (reverbParameters[4] + reverbParameters[5] * 16) / 2.0 + 4;
        ambience.setSize(size);

        int link = reverbParameters[6] + reverbParameters[7] * 16;
        ambience.setLink(link);

        int diff = (reverbParameters[8] + reverbParameters[9] * 16) * 2;
        ambience.setDiff(diff);

        int preDelay = reverbParameters[10] + reverbParameters[11] * 16;
        ambience.setPreDelay(preDelay);

        int delayTime = reverbParameters[12] + reverbParameters[13] * 16;
        ambience.setDelayTime(delayTime);

        int delayLevel = reverbParameters[14] + reverbParameters[15] * 16;
        ambience.setDelayLevel(delayLevel);

        int rtHC = reverbParameters[16] + reverbParameters[17] * 16;
        ambience.setRtHC(rtHC);

        return ambience;
    }
}
