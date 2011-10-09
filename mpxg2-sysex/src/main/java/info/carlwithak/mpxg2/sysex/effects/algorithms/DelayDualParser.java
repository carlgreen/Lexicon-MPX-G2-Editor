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

import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import info.carlwithak.mpxg2.sysex.Util;

/**
 * Class to parse parameter data for Delay (D) effect.
 *
 * @author Carl Green
 */
public class DelayDualParser {

    public static DelayDual parse(byte[] effectParameters) {
        DelayDual delayDual = new DelayDual();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        delayDual.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        delayDual.setLevel(level);

        int time1Echoes = effectParameters[4] + effectParameters[5] * 16;
        delayDual.setTime1Echoes(time1Echoes);

        int time1Beat = effectParameters[6] + effectParameters[7] * 16;
        delayDual.setTime1Beat(time1Beat);

        // TODO time1 units?

        int time2Echoes = effectParameters[10] + effectParameters[11] * 16;
        delayDual.setTime2Echoes(time2Echoes);

        int time2Beat = effectParameters[12] + effectParameters[13] * 16;
        delayDual.setTime2Beat(time2Beat);

        // TODO time2 units?

        int level1 = effectParameters[16] + effectParameters[17] * 16;
        delayDual.setLevel1(level1);

        int level2 = effectParameters[18] + effectParameters[19] * 16;
        delayDual.setLevel2(level2);

        int pan1 = (byte) (effectParameters[20] + effectParameters[21] * 16);
        delayDual.setPan1(pan1);

        int pan2 = (byte) (effectParameters[22] + effectParameters[23] * 16);
        delayDual.setPan2(pan2);

        int feedback1 = (byte) (effectParameters[24] + effectParameters[25] * 16);
        delayDual.setFeedback1(feedback1);

        int insert = effectParameters[26] + effectParameters[27] * 16;
        delayDual.setInsert(insert);

        int feedback2 = (byte) (effectParameters[28] + effectParameters[29] * 16);
        delayDual.setFeedback2(feedback2);

        int xFbk1 = effectParameters[30] + effectParameters[31] * 16;
        delayDual.setXFbk1(xFbk1);

        int xFbk2 = effectParameters[32] + effectParameters[33] * 16;
        delayDual.setXFbk2(xFbk2);

        int clear = effectParameters[34] + effectParameters[35] * 16;
        delayDual.setClear(Util.parseBoolean(clear));

        return delayDual;
    }
}
