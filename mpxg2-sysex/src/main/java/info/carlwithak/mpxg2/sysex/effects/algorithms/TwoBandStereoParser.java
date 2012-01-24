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

import info.carlwithak.mpxg2.model.effects.algorithms.TwoBandStereo;

/**
 * Class to parse parameter data for 2-Band (S) effect.
 *
 * @author Carl Green
 */
public class TwoBandStereoParser {

    public static TwoBandStereo parse(byte[] effectParameters) {
        TwoBandStereo twoBandStereo = new TwoBandStereo();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        twoBandStereo.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        twoBandStereo.level.setValue(level);

        int gain1 = (byte) (effectParameters[4] + effectParameters[5] * 16);
        twoBandStereo.gain1.setValue(gain1);

        int fc1 = 0;
        for (int i = 0; i < 4; i++) {
            fc1 += (effectParameters[6 + i] * Math.pow(16, i));
        }
        twoBandStereo.fc1.setValue(fc1);

        int q1 = (byte) (effectParameters[10] + effectParameters[11] * 16);
        twoBandStereo.q1.setValue(q1 / 10.0);

        int mode1 = (byte) (effectParameters[12] + effectParameters[13] * 16);
        twoBandStereo.mode1.setValue(mode1);

        int gain2 = (byte) (effectParameters[14] + effectParameters[15] * 16);
        twoBandStereo.gain2.setValue(gain2);

        int fc2 = 0;
        for (int i = 0; i < 4; i++) {
            fc2 += (effectParameters[16 + i] * Math.pow(16, i));
        }
        twoBandStereo.fc2.setValue(fc2);

        int q2 = (byte) (effectParameters[20] + effectParameters[21] * 16);
        twoBandStereo.q2.setValue(q2 / 10.0);

        int mode2 = (byte) (effectParameters[22] + effectParameters[23] * 16);
        twoBandStereo.mode2.setValue(mode2);

        return twoBandStereo;
    }
}
