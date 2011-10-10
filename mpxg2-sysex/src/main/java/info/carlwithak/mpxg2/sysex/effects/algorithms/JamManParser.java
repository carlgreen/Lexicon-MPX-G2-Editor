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

import info.carlwithak.mpxg2.model.effects.algorithms.JamMan;
import info.carlwithak.mpxg2.sysex.Util;

/**
 * Class to parse parameter data for JamMan effect.
 *
 * @author Carl Green
 */
public class JamManParser {

    public static JamMan parse(byte[] effectParameters) {
        JamMan jamMan = new JamMan();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        jamMan.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        jamMan.setLevel(level);

        int size = 0;
        for (int i = 0; i < 4; i++) {
            size += (effectParameters[4 + i] * Math.pow(16, i));
        }
        jamMan.setSize(size);

        int feedback = (byte) (effectParameters[8] + effectParameters[9] * 16);
        jamMan.setFeedback(feedback);

        int insert = (byte) (effectParameters[10] + effectParameters[11] * 16);
        jamMan.setInsert(insert);

        int clear = (byte) (effectParameters[12] + effectParameters[13] * 16);
        jamMan.setClear(Util.parseBoolean(clear));

        int layer = (byte) (effectParameters[14] + effectParameters[15] * 16);
        jamMan.setLayer(Util.parseBoolean(layer));

        int replace = (byte) (effectParameters[16] + effectParameters[17] * 16);
        jamMan.setReplace(Util.parseBoolean(replace));

        int delay = (byte) (effectParameters[18] + effectParameters[19] * 16);
        jamMan.setDelay(Util.parseBoolean(delay));

        int mute = (byte) (effectParameters[20] + effectParameters[21] * 16);
        jamMan.setMute(Util.parseBoolean(mute));

        return jamMan;
    }

}
