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

import info.carlwithak.mpxg2.model.effects.algorithms.Gate;
import info.carlwithak.mpxg2.sysex.Util;

/**
 * Class to parse parameter data for Gate effect.
 *
 * @author Carl Green
 */
public class GateParser {

    public static Gate parse(byte[] effectParameters) {
        Gate gate = new Gate();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        gate.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        gate.level.setValue(level);

        int time = (byte) (effectParameters[4] + effectParameters[5] * 16);
        gate.time.setValue(time);

        int link = effectParameters[6] + effectParameters[7] * 16;
        gate.link.setValue(Util.parseBoolean(link));

        int diff = (effectParameters[8] + effectParameters[9] * 16) * 2;
        gate.diff.setValue(diff);

        int preDelay = effectParameters[10] + effectParameters[11] * 16;
        gate.preDelay.setValue(preDelay);

        int loSlope = effectParameters[12] + effectParameters[13] * 16;
        gate.loSlope.setValue(loSlope - 16);

        int hiSlope = effectParameters[14] + effectParameters[15] * 16;
        gate.hiSlope.setValue(hiSlope - 16);

        int xovr = effectParameters[16] + effectParameters[17] * 16;
        gate.xovr.setValue(xovr);

        int rtHC = effectParameters[18] + effectParameters[19] * 16;
        gate.rtHC.setValue(rtHC);

        int shape = effectParameters[20] + effectParameters[21] * 16;
        gate.shape.setValue(shape);

        int spred = effectParameters[22] + effectParameters[23] * 16;
        gate.spred.setValue(spred);

        return gate;
    }

}
