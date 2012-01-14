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

import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import info.carlwithak.mpxg2.sysex.Util;

/**
 * Class to parse parameter data for Plate effect.
 *
 * @author Carl Green
 */
public class PlateParser {

    public static Plate parse(byte[] effectParameters) {
        Plate plate = new Plate();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        plate.getMix().setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        plate.getLevel().setValue(level);

        double size = (effectParameters[4] + effectParameters[5] * 16) / 2.0 + 4;
        plate.getSize().setValue(size);

        int link = effectParameters[6] + effectParameters[7] * 16;
        plate.getLink().setValue(Util.parseBoolean(link));

        int diff = (effectParameters[8] + effectParameters[9] * 16) * 2;
        plate.getDiff().setValue(diff);

        int preDelay = effectParameters[10] + effectParameters[11] * 16;
        plate.getPreDelay().setValue(preDelay);
        
        int bass = effectParameters[12] + effectParameters[13] * 16;
        plate.getBass().setValue(bass);

        int decay = effectParameters[14] + effectParameters[15] * 16;
        plate.getDecay().setValue(decay);

        int xovr = effectParameters[16] + effectParameters[17] * 16;
        plate.getXovr().setValue(xovr);

        int rtHC = effectParameters[18] + effectParameters[19] * 16;
        plate.getRtHC().setValue(rtHC);

        int shape = effectParameters[20] + effectParameters[21] * 16;
        plate.getShape().setValue(shape);

        int spred = effectParameters[22] + effectParameters[23] * 16;
        plate.getSpred().setValue(spred);

        return plate;
    }
}
