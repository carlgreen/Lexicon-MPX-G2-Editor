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

    public static Panner parse(byte[] effect1Parameters) {
        Panner panner = new Panner();

        int mix = effect1Parameters[0] + effect1Parameters[1] * 16;
        panner.setMix(mix);

        int level = (byte) (effect1Parameters[2] + effect1Parameters[3] * 16);
        panner.setLevel(level);

        int pan1 = (byte) (effect1Parameters[4] + effect1Parameters[5] * 16);
        panner.setPan1(pan1);

        int pan2 = (byte) (effect1Parameters[6] + effect1Parameters[7] * 16);
        panner.setPan2(pan2);

        return panner;
    }
}
