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

import info.carlwithak.mpxg2.model.effects.algorithms.Crunch;

/**
 * Class to parse parameter data for Crunch effect.
 *
 * @author Carl Green
 */
public class CrunchParser {

    public static Crunch parse(byte[] effectParameters) {
        Crunch crunch = new Crunch();

        int lo = effectParameters[0] + effectParameters[1] * 16;
        crunch.lo.setValue(lo);

        int mid = (byte) (effectParameters[2] + effectParameters[3] * 16);
        crunch.mid.setValue(mid);

        int hi = (byte) (effectParameters[4] + effectParameters[5] * 16);
        crunch.hi.setValue(hi);

        int inLevel = (byte) (effectParameters[6] + effectParameters[7] * 16);
        crunch.inLevel.setValue(inLevel);

        int level = (byte) (effectParameters[8] + effectParameters[9] * 16);
        crunch.level.setValue(level);

        return crunch;
    }
}
