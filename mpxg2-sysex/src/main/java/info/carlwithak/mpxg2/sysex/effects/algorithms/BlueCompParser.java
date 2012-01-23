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

import info.carlwithak.mpxg2.model.effects.algorithms.BlueComp;
import info.carlwithak.mpxg2.sysex.ParseException;

/**
 * Class to parse parameter data for Blue Comp effect.
 *
 * @author Carl Green
 */
public class BlueCompParser {

    public static BlueComp parse(byte[] effectParameters) throws ParseException {
        BlueComp blueComp = new BlueComp();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        blueComp.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        blueComp.level.setValue(level);

        int sense = (byte) (effectParameters[4] + effectParameters[5] * 16);
        blueComp.getSensitivity().setValue(sense);

        int threshold = (byte) (effectParameters[6] + effectParameters[7] * 16);
        blueComp.getThreshold().setValue(threshold);

        int gain = (byte) (effectParameters[8] + effectParameters[9] * 16);
        blueComp.getGain().setValue(gain);

        int attackTime = 0;
        for (int i = 0; i < 4; i++) {
            attackTime += (effectParameters[10 + i] * Math.pow(16, i));
        }
        blueComp.getAttackTime().setValue(attackTime);

        int releaseTime = 0;
        for (int i = 0; i < 4; i++) {
            releaseTime += (effectParameters[14 + i] * Math.pow(16, i));
        }
        blueComp.getReleaseTime().setValue(releaseTime);

        return blueComp;
    }

}
