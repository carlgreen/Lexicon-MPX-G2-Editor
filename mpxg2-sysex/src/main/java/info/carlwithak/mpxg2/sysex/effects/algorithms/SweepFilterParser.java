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

import info.carlwithak.mpxg2.model.effects.algorithms.SweepFilter;

/**
 * Class to parse parameter data for SweepFilter effect.
 *
 * @author Carl Green
 */
public class SweepFilterParser {

    public static SweepFilter parse(byte[] effectParameters) {
        SweepFilter sweepFilter = new SweepFilter();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        sweepFilter.getMix().setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        sweepFilter.getLevel().setValue(level);

        int fc = 0;
        for (int i = 0; i < 4; i++) {
            fc += (effectParameters[4 + i] * Math.pow(16, i));
        }
        sweepFilter.setFc(fc);

        int fRes = (byte) (effectParameters[8] + effectParameters[9] * 16);
        sweepFilter.setFRes(fRes);

        int mod = 0;
        for (int i = 0; i < 4; i++) {
            mod += (effectParameters[10 + i] * Math.pow(16, i));
        }
        sweepFilter.setMod(mod);

        int scale = (byte) (effectParameters[14] + effectParameters[15] * 16);
        sweepFilter.setScale(scale);

        int pan = (byte) (effectParameters[16] + effectParameters[17] * 16);
        sweepFilter.setPan(pan);

        return sweepFilter;
    }

}