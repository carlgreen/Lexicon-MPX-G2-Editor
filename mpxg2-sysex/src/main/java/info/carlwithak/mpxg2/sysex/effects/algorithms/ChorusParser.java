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

import info.carlwithak.mpxg2.model.effects.algorithms.ChorusAlgorithm;

/**
 * Class to parse parameter data for Chorus effect.
 *
 * @author Carl Green
 */
public class ChorusParser {

    public static ChorusAlgorithm parse(byte[] effectParameters) {
        ChorusAlgorithm chorus = new ChorusAlgorithm();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        chorus.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        chorus.setLevel(level);

        int rate1 = 0;
        for (int i = 0; i < 6; i++) {
            rate1 += (effectParameters[4 + i] * Math.pow(16, i));
        }
        chorus.setRate1(rate1 / 100.0);

        int pulseWidth1 = (byte) (effectParameters[10] + effectParameters[11] * 16);
        chorus.setPulseWidth1(pulseWidth1);

        int depth1 = (byte) (effectParameters[12] + effectParameters[13] * 16);
        chorus.setDepth1(depth1);

        int rate2 = 0;
        for (int i = 0; i < 6; i++) {
            rate2 += (effectParameters[14 + i] * Math.pow(16, i));
        }
        chorus.setRate2(rate2 / 100.0);

        int pulseWidth2 = (byte) (effectParameters[20] + effectParameters[21] * 16);
        chorus.setPulseWidth2(pulseWidth2);

        int depth2 = (byte) (effectParameters[22] + effectParameters[23] * 16);
        chorus.setDepth2(depth2);

        int resonance1 = (byte) (effectParameters[24] + effectParameters[25] * 16);
        chorus.setResonance1(resonance1);

        int resonance2 = (byte) (effectParameters[26] + effectParameters[27] * 16);
        chorus.setResonance2(resonance2);

        return chorus;
    }
}