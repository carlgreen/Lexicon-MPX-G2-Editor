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

import info.carlwithak.mpxg2.model.effects.algorithms.Distortion;

/**
 * Class to parse parameter data for Distortion effect.
 *
 * @author Carl Green
 */
public class DistortionParser {

    public static Distortion parse(byte[] effectParameters) {
        Distortion distortion = new Distortion();

        int lo = effectParameters[0] + effectParameters[1] * 16;
        distortion.getLo().setValue(lo);

        int mid = (byte) (effectParameters[2] + effectParameters[3] * 16);
        distortion.getMid().setValue(mid);

        int hi = (byte) (effectParameters[4] + effectParameters[5] * 16);
        distortion.getHi().setValue(hi);

        int drive = (byte) (effectParameters[6] + effectParameters[7] * 16);
        distortion.getDrive().setValue(drive);

        int tone = (byte) (effectParameters[8] + effectParameters[9] * 16);
        distortion.getTone().setValue(tone);

        int bass = (byte) (effectParameters[10] + effectParameters[11] * 16);
        distortion.getBass().setValue(bass);

        int treble = (byte) (effectParameters[12] + effectParameters[13] * 16);
        distortion.getTreble().setValue(treble);

        int level = (byte) (effectParameters[14] + effectParameters[15] * 16);
        distortion.getLevel().setValue(level);

        return distortion;
    }
}
