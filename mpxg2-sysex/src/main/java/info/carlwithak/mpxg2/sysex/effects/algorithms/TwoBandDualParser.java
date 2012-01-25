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

import info.carlwithak.mpxg2.model.effects.algorithms.TwoBandDual;

/**
 * Class to parse parameter data for 2-Band (D) effect.
 *
 * @author Carl Green
 */
public class TwoBandDualParser {

    public static TwoBandDual parse(byte[] effectParameters) {
        TwoBandDual twoBandDual = new TwoBandDual();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        twoBandDual.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        twoBandDual.level.setValue(level);

        int gainLeft1 = (byte) (effectParameters[4] + effectParameters[5] * 16);
        twoBandDual.gainLeft1.setValue(gainLeft1);

        int fcLeft1 = 0;
        for (int i = 0; i < 4; i++) {
            fcLeft1 += (effectParameters[6 + i] * Math.pow(16, i));
        }
        twoBandDual.fcLeft1.setValue(fcLeft1);

        int qLeft1 = (byte) (effectParameters[10] + effectParameters[11] * 16);
        twoBandDual.qLeft1.setValue(qLeft1 / 10.0);

        int modeLeft1 = (byte) (effectParameters[12] + effectParameters[13] * 16);
        twoBandDual.modeLeft1.setValue(modeLeft1);

        int gainLeft2 = (byte) (effectParameters[14] + effectParameters[15] * 16);
        twoBandDual.gainLeft2.setValue(gainLeft2);

        int fcLeft2 = 0;
        for (int i = 0; i < 4; i++) {
            fcLeft2 += (effectParameters[16 + i] * Math.pow(16, i));
        }
        twoBandDual.fcLeft2.setValue(fcLeft2);

        int qLeft2 = (byte) (effectParameters[20] + effectParameters[21] * 16);
        twoBandDual.qLeft2.setValue(qLeft2 / 10.0);

        int modeLeft2 = (byte) (effectParameters[22] + effectParameters[23] * 16);
        twoBandDual.modeLeft2.setValue(modeLeft2);

        int gainRight1 = (byte) (effectParameters[24] + effectParameters[25] * 16);
        twoBandDual.gainRight1.setValue(gainRight1);

        int fcRight1 = 0;
        for (int i = 0; i < 4; i++) {
            fcRight1 += (effectParameters[26 + i] * Math.pow(16, i));
        }
        twoBandDual.fcRight1.setValue(fcRight1);

        int qRight1 = (byte) (effectParameters[30] + effectParameters[31] * 16);
        twoBandDual.qRight1.setValue(qRight1 / 10.0);

        int modeRight1 = (byte) (effectParameters[32] + effectParameters[33] * 16);
        twoBandDual.modeRight1.setValue(modeRight1);

        int gainRight2 = (byte) (effectParameters[34] + effectParameters[35] * 16);
        twoBandDual.gainRight2.setValue(gainRight2);

        int fcRight2 = 0;
        for (int i = 0; i < 4; i++) {
            fcRight2 += (effectParameters[36 + i] * Math.pow(16, i));
        }
        twoBandDual.fcRight2.setValue(fcRight2);

        int qRight2 = (byte) (effectParameters[40] + effectParameters[41] * 16);
        twoBandDual.qRight2.setValue(qRight2 / 10.0);

        int modeRight2 = (byte) (effectParameters[42] + effectParameters[43] * 16);
        twoBandDual.modeRight2.setValue(modeRight2);

        return twoBandDual;
    }

}
