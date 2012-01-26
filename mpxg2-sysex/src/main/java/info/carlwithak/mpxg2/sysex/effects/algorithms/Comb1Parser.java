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

import info.carlwithak.mpxg2.model.effects.algorithms.Comb1;

/**
 * Class to parse parameter data for Comb 1 effect.
 *
 * @author Carl Green
 */
public class Comb1Parser {

    public static Comb1 parse(byte[] effectParameters) {
        Comb1 comb1 = new Comb1();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        comb1.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        comb1.level.setValue(level);

        int loCut = 0;
        for (int i = 0; i < 4; i++) {
            loCut += (effectParameters[4 + i] * Math.pow(16, i));
        }
        comb1.loCut.setValue(loCut);

        int hiCut = 0;
        for (int i = 0; i < 4; i++) {
            hiCut += (effectParameters[8 + i] * Math.pow(16, i));
        }
        comb1.hiCut.setValue(hiCut);

        int comb = (byte) (effectParameters[12] + effectParameters[13] * 16);
        comb1.comb.setValue(comb);

        int notch = (byte) (effectParameters[14] + effectParameters[15] * 16);
        comb1.notch.setValue(notch);

        return comb1;
    }

}
