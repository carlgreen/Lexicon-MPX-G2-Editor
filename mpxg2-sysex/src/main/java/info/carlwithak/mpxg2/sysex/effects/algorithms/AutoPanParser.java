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

import info.carlwithak.mpxg2.model.effects.algorithms.AutoPan;

/**
 * Class to parse parameter data for Auto Pan effect.
 *
 * @author Carl Green
 */
public class AutoPanParser {

    public static AutoPan parse(byte[] effectParameters) {
        AutoPan autoPan = new AutoPan();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        autoPan.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        autoPan.setLevel(level);

        int rate = 0;
        for (int i = 0; i < 6; i++) {
            rate += (effectParameters[4 + i] * Math.pow(16, i));
        }
        autoPan.setRate(rate / 100.0);

        int pulseWidth = (byte) (effectParameters[10] + effectParameters[11] * 16);
        autoPan.setPulseWidth(pulseWidth);

        int depth = (byte) (effectParameters[12] + effectParameters[13] * 16);
        autoPan.setDepth(depth);

        int phase = (byte) (effectParameters[14] + effectParameters[15] * 16);
        autoPan.setPhase(phase);

        return autoPan;
    }

}
