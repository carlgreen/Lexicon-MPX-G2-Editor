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

import info.carlwithak.mpxg2.model.effects.algorithms.OneBandStereo;

/**
 *
 * @author Carl Green
 */
public class OneBandStereoParser {

    public static OneBandStereo parse(byte[] effectParameters) {
        OneBandStereo oneBandStereo = new OneBandStereo();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        oneBandStereo.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        oneBandStereo.level.setValue(level);

        int gain = (byte) (effectParameters[4] + effectParameters[5] * 16);
        oneBandStereo.gain.setValue(gain);

        int fc = 0;
        for (int i = 0; i < 4; i++) {
            fc += (effectParameters[6 + i] * Math.pow(16, i));
        }
        oneBandStereo.fc.setValue(fc);

        int q = (byte) (effectParameters[10] + effectParameters[11] * 16);
        oneBandStereo.q.setValue(q / 10.0);

        int mode = (byte) (effectParameters[12] + effectParameters[13] * 16);
        oneBandStereo.mode.setValue(mode);

        return oneBandStereo;
    }

}
