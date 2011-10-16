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

import info.carlwithak.mpxg2.model.effects.algorithms.Preamp;

/**
 * Class to parse parameter data for Preamp effect.
 *
 * @author Carl Green
 */
public class PreampParser {

    public static Preamp parse(byte[] effectParameters) {
        Preamp preamp = new Preamp();

        int lo = effectParameters[0] + effectParameters[1] * 16;
        preamp.setLo(lo);

        int mid = (byte) (effectParameters[2] + effectParameters[3] * 16);
        preamp.setMid(mid);

        int hi = (byte) (effectParameters[4] + effectParameters[5] * 16);
        preamp.setHi(hi);

        int inLevel = (byte) (effectParameters[6] + effectParameters[7] * 16);
        preamp.setInLevel(inLevel);

        int loCut = (byte) (effectParameters[8] + effectParameters[9] * 16);
        preamp.setLoCut(loCut);

        int feel = (byte) (effectParameters[10] + effectParameters[11] * 16);
        preamp.setFeel(feel);

        int drive = (byte) (effectParameters[12] + effectParameters[13] * 16);
        preamp.setDrive(drive);

        int tone = (byte) (effectParameters[14] + effectParameters[15] * 16);
        preamp.setTone(tone);

        int bass = (byte) (effectParameters[16] + effectParameters[17] * 16);
        preamp.setBass(bass);

        int treble = (byte) (effectParameters[18] + effectParameters[19] * 16);
        preamp.setTreble(treble);

        int level = (byte) (effectParameters[20] + effectParameters[21] * 16);
        preamp.setLevel(level);

        return preamp;
    }
}