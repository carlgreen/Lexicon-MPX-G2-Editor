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

import info.carlwithak.mpxg2.model.effects.algorithms.DiatonicHmy;

/**
 * Class to parse parameter data for DiatonicHmy effect.
 *
 * @author Carl Green
 */
public class DiatonicHmyParser {

    public static DiatonicHmy parse(byte[] effectParameters) {
        DiatonicHmy diatonicHmy = new DiatonicHmy();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        diatonicHmy.getMix().setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        diatonicHmy.getLevel().setValue(level);

        int key = (byte) (effectParameters[4] + effectParameters[5] * 16);
        diatonicHmy.getKey().setValue(key);

        int scale = (byte) (effectParameters[6] + effectParameters[7] * 16);
        diatonicHmy.getScale().setValue(scale);

        int interval = (byte) (effectParameters[8] + effectParameters[9] * 16);
        diatonicHmy.getInterval().setValue(interval);

        int optimize = (byte) (effectParameters[10] + effectParameters[11] * 16);
        diatonicHmy.getOptimize().setValue(optimize);

        int threshold = (byte) (effectParameters[12] + effectParameters[13] * 16);
        diatonicHmy.getThreshold().setValue(threshold);

        int source = (byte) (effectParameters[14] + effectParameters[15] * 16);
        diatonicHmy.getSource().setValue(source);

        return diatonicHmy;
    }

}
