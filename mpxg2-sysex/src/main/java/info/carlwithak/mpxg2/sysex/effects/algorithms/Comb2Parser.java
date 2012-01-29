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

import info.carlwithak.mpxg2.model.effects.algorithms.Comb2;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import java.util.Arrays;

/**
 * Class to parse parameter data for Comb 2 effect.
 *
 * @author Carl Green
 */
public class Comb2Parser {

    public static Comb2 parse(byte[] effectParameters) throws ParseException {
        Comb2 comb2 = new Comb2();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        comb2.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        comb2.level.setValue(level);

        int loCut = 0;
        for (int i = 0; i < 4; i++) {
            loCut += (effectParameters[4 + i] * Math.pow(16, i));
        }
        comb2.loCut.setValue(loCut);

        int hiCut = 0;
        for (int i = 0; i < 4; i++) {
            hiCut += (effectParameters[8 + i] * Math.pow(16, i));
        }
        comb2.hiCut.setValue(hiCut);

        int notch = (byte) (effectParameters[12] + effectParameters[13] * 16);
        comb2.notch.setValue(notch);

        comb2.setRate(RateParser.parse("Rate", Arrays.copyOfRange(effectParameters, 14, 20)));

        int pulseWidth = (byte) (effectParameters[20] + effectParameters[21] * 16);
        comb2.pulseWidth.setValue(pulseWidth);

        int depth = (byte) (effectParameters[22] + effectParameters[23] * 16);
        comb2.depth.setValue(depth);

        int resonance = (byte) (effectParameters[24] + effectParameters[25] * 16);
        comb2.resonance.setValue(resonance);

        int phase = (byte) (effectParameters[26] + effectParameters[27] * 16);
        comb2.phase.setValue(phase);

        return comb2;
    }

}
