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

import info.carlwithak.mpxg2.model.effects.algorithms.RedComp;
import info.carlwithak.mpxg2.sysex.ParseException;

/**
 * Class to parse parameter data for Red Comp effect.
 *
 * @author Carl Green
 */
public class RedCompParser {

    public static RedComp parse(byte[] effectParameters) throws ParseException {
        RedComp redComp = new RedComp();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        redComp.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        redComp.setLevel(level);

        int sense = (byte) (effectParameters[4] + effectParameters[5] * 16);
        redComp.setSensitivity(sense);

        return redComp;
    }

}
