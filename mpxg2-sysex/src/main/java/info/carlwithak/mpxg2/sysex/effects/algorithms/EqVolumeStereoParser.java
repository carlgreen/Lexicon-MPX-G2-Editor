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

import info.carlwithak.mpxg2.model.effects.algorithms.EqVolumeStereo;

/**
 * Class to parse parameter data for Volume (S) effect.
 *
 * @author Carl Green
 */
public class EqVolumeStereoParser {

    public static EqVolumeStereo parse(byte[] effectParameters) {
        EqVolumeStereo volumeStereo = new EqVolumeStereo();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        volumeStereo.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        volumeStereo.setLevel(level);

        int volume = (byte) (effectParameters[4] + effectParameters[5] * 16);
        volumeStereo.setVolume(volume);

        return volumeStereo;
    }

}