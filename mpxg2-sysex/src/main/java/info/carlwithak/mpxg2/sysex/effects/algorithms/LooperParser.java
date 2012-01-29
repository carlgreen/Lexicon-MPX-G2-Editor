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

import info.carlwithak.mpxg2.model.effects.algorithms.Looper;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import info.carlwithak.mpxg2.sysex.Util;
import java.util.Arrays;

/**
 * Class to parse parameter data for Looper effect.
 *
 * @author Carl Green
 */
public class LooperParser {

    public static Looper parse(byte[] effectParameters) throws ParseException {
        Looper looper = new Looper();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        looper.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        looper.level.setValue(level);

        looper.setTime(RateParser.parse("Time", Arrays.copyOfRange(effectParameters, 4, 10)));

        int inMix = (byte) (effectParameters[10] + effectParameters[11] * 16);
        looper.inMix.setValue(inMix);

        int feedbackInsert = (byte) (effectParameters[12] + effectParameters[13] * 16);
        looper.feedbackInsert.setValue(feedbackInsert);

        int sensitivity = (byte) (effectParameters[14] + effectParameters[15] * 16);
        looper.sensitivity.setValue(sensitivity);

        int pan = (byte) (effectParameters[16] + effectParameters[17] * 16);
        looper.pan.setValue(pan);

        int release = (byte) (effectParameters[18] + effectParameters[19] * 16);
        looper.release.setValue(release);

        int attack = (byte) (effectParameters[20] + effectParameters[21] * 16);
        looper.attack.setValue(attack);

        int clear = (byte) (effectParameters[22] + effectParameters[23] * 16);
        looper.clear.setValue(Util.parseBoolean(clear));

        return looper;
    }

}
