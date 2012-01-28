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

import info.carlwithak.mpxg2.model.effects.algorithms.DigiDrive2;

/**
 * Class to parse parameter data for DigiDrive2 effect.
 *
 * @author Carl Green
 */
public class DigiDrive2Parser {

    public static DigiDrive2 parse(byte[] effectParameters) {
        DigiDrive2 digiDrive2 = new DigiDrive2();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        digiDrive2.mix.setValue(mix);

        int level = effectParameters[2] + effectParameters[3] * 16;
        digiDrive2.level.setValue(level);

        int drive = effectParameters[4] + effectParameters[5] * 16;
        digiDrive2.drive.setValue(drive);

        int low = (byte) (effectParameters[6] + effectParameters[7] * 16);
        digiDrive2.low.setValue(low);

        int mid = (byte) (effectParameters[8] + effectParameters[9] * 16);
        digiDrive2.mid.setValue(mid);

        int high = (byte) (effectParameters[10] + effectParameters[11] * 16);
        digiDrive2.high.setValue(high);

        return digiDrive2;
    }

}
