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

import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;

/**
 * Class to parse parameter data for Screamer effect.
 *
 * @author Carl Green
 */
public class ScreamerParser {

    public static Screamer parse(byte[] effectParameters) {
        Screamer screamer = new Screamer();

        int lo = effectParameters[0] + effectParameters[1] * 16;
        screamer.setLo(lo);

        int mid = (byte) (effectParameters[2] + effectParameters[3] * 16);
        screamer.setMid(mid);

        int hi = (byte) (effectParameters[4] + effectParameters[5] * 16);
        screamer.setHi(hi);

        int drive = (byte) (effectParameters[6] + effectParameters[7] * 16);
        screamer.setDrive(drive);

        int tone = (byte) (effectParameters[8] + effectParameters[9] * 16);
        screamer.setTone(tone);

        int level = (byte) (effectParameters[10] + effectParameters[11] * 16);
        screamer.setLevel(level);

        return screamer;
    }
}
