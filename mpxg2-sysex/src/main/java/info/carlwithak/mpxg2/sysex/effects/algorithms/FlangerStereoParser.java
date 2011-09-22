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

import info.carlwithak.mpxg2.model.effects.algorithms.FlangerStereo;

/**
 * Class to parse parameter data for Flanger (S) effect.
 *
 * @author Carl Green
 */
public class FlangerStereoParser {

    public static FlangerStereo parse(byte[] effectParameters) {
        FlangerStereo flangerStereo = new FlangerStereo();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        flangerStereo.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        flangerStereo.setLevel(level);

        int rate = 0;
        for (int i = 0; i < 6; i++) {
            rate += (effectParameters[4 + i] * Math.pow(16, i));
        }
        flangerStereo.setRate(rate / 100.0);

        int pulseWidth = (byte) (effectParameters[10] + effectParameters[11] * 16);
        flangerStereo.setPulseWidth(pulseWidth);

        int depth = (byte) (effectParameters[12] + effectParameters[13] * 16);
        flangerStereo.setDepth(depth);

        int phase = (byte) (effectParameters[14] + effectParameters[15] * 16);
        flangerStereo.setPhase(phase);

        int resonance = (byte) (effectParameters[16] + effectParameters[17] * 16);
        flangerStereo.setResonance(resonance);

        int blend = (byte) (effectParameters[18] + effectParameters[19] * 16);
        flangerStereo.setBlend(blend);

        return flangerStereo;
    }

}