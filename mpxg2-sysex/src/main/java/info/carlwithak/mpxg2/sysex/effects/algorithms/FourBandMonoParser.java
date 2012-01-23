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

import info.carlwithak.mpxg2.model.effects.algorithms.FourBandMono;

/**
 * Class to parse parameter data for 4-Band (M) effect.
 *
 * @author Carl Green
 */
public class FourBandMonoParser {

    public static FourBandMono parse(byte[] effectParameters) {
        FourBandMono fourBandMono = new FourBandMono();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        fourBandMono.getMix().setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        fourBandMono.getLevel().setValue(level);

        int gain1 = (byte) (effectParameters[4] + effectParameters[5] * 16);
        fourBandMono.getGain1().setValue(gain1);

        int fc1 = 0;
        for (int i = 0; i < 4; i++) {
            fc1 += (effectParameters[6 + i] * Math.pow(16, i));
        }
        fourBandMono.getFc1().setValue(fc1);

        int q1 = (byte) (effectParameters[10] + effectParameters[11] * 16);
        fourBandMono.getQ1().setValue(q1 / 10.0);

        int mode1 = (byte) (effectParameters[12] + effectParameters[13] * 16);
        fourBandMono.getMode1().setValue(mode1);

        int gain2 = (byte) (effectParameters[14] + effectParameters[15] * 16);
        fourBandMono.getGain2().setValue(gain2);

        int fc2 = 0;
        for (int i = 0; i < 4; i++) {
            fc2 += (effectParameters[16 + i] * Math.pow(16, i));
        }
        fourBandMono.getFc2().setValue(fc2);

        int q2 = (byte) (effectParameters[20] + effectParameters[21] * 16);
        fourBandMono.getQ2().setValue(q2 / 10.0);

        int mode2 = (byte) (effectParameters[22] + effectParameters[23] * 16);
        fourBandMono.getMode2().setValue(mode2);

        int gain3 = (byte) (effectParameters[24] + effectParameters[25] * 16);
        fourBandMono.getGain3().setValue(gain3);

        int fc3 = 0;
        for (int i = 0; i < 4; i++) {
            fc3 += (effectParameters[26 + i] * Math.pow(16, i));
        }
        fourBandMono.getFc3().setValue(fc3);

        int q3 = (byte) (effectParameters[30] + effectParameters[31] * 16);
        fourBandMono.getQ3().setValue(q3 / 10.0);

        int mode3 = (byte) (effectParameters[32] + effectParameters[33] * 16);
        fourBandMono.getMode3().setValue(mode3);

        int gain4 = (byte) (effectParameters[34] + effectParameters[35] * 16);
        fourBandMono.getGain4().setValue(gain4);

        int fc4 = 0;
        for (int i = 0; i < 4; i++) {
            fc4 += (effectParameters[36 + i] * Math.pow(16, i));
        }
        fourBandMono.getFc4().setValue(fc4);

        int q4 = (byte) (effectParameters[40] + effectParameters[41] * 16);
        fourBandMono.getQ4().setValue(q4 / 10.0);

        int mode4 = (byte) (effectParameters[42] + effectParameters[43] * 16);
        fourBandMono.getMode4().setValue(mode4);

        return fourBandMono;
    }

}
