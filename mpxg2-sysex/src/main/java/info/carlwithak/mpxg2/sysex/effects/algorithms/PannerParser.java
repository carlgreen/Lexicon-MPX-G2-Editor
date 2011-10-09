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

import info.carlwithak.mpxg2.model.effects.algorithms.Panner;

/**
 * Class to parse parameter data for Panner effect.
 *
 * @author Carl Green
 */
public class PannerParser {

    public static Panner parse(byte[] effectParameters) {
        Panner panner = new Panner();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        panner.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        panner.setLevel(level);

        int pan1 = (byte) (effectParameters[4] + effectParameters[5] * 16);
        panner.setPan1(pan1);

        int pan2 = (byte) (effectParameters[6] + effectParameters[7] * 16);
        panner.setPan2(pan2);

        return panner;
    }
}
