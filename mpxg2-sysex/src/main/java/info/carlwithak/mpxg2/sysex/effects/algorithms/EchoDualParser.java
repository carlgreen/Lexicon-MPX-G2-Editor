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

import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;

/**
 * Class to parse parameter data for Echo (D) effect.
 *
 * @author Carl Green
 */
public class EchoDualParser {

    public static EchoDual parse(byte[] delayParameters) {
        EchoDual echoDual = new EchoDual();

        int mix = delayParameters[0] + delayParameters[1] * 16;
        echoDual.setMix(mix);

        int level = (byte) (delayParameters[2] + delayParameters[3] * 16);
        echoDual.setLevel(level);

        int time1Echoes = delayParameters[4] + delayParameters[5] * 16;
        echoDual.setTime1Echoes(time1Echoes);

        int time1Beat = delayParameters[6] + delayParameters[7] * 16;
        echoDual.setTime1Beat(time1Beat);

        // TODO time1 units?

        int time2Echoes = delayParameters[10] + delayParameters[11] * 16;
        echoDual.setTime2Echoes(time2Echoes);

        int time2Beat = delayParameters[12] + delayParameters[13] * 16;
        echoDual.setTime2Beat(time2Beat);

        // TODO time2 units?

        int level1 = delayParameters[16] + delayParameters[17] * 16;
        echoDual.setLevel1(level1);

        int level2 = delayParameters[18] + delayParameters[19] * 16;
        echoDual.setLevel2(level2);

        int feedback1 = (byte) (delayParameters[20] + delayParameters[21] * 16);
        echoDual.setFeedback1(feedback1);

        int insert = delayParameters[22] + delayParameters[23] * 16;
        echoDual.setInsert(insert);

        int feedback2 = (byte) (delayParameters[24] + delayParameters[25] * 16);
        echoDual.setFeedback2(feedback2);

        int damp1 = delayParameters[26] + delayParameters[27] * 16;
        echoDual.setDamp1(damp1);

        int damp2 = delayParameters[28] + delayParameters[29] * 16;
        echoDual.setDamp2(damp2);

        int clear = delayParameters[30] + delayParameters[31] * 16;
        echoDual.setClear(clear);

        return echoDual;
    }
}
