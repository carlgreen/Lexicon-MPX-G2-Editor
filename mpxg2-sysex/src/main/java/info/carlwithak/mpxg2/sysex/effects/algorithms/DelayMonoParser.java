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

import info.carlwithak.mpxg2.model.effects.algorithms.DelayMono;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import info.carlwithak.mpxg2.sysex.Util;
import java.util.Arrays;

/**
 * Class to parse parameter data for Delay (M) effect.
 *
 * @author Carl Green
 */
public class DelayMonoParser {

    public static DelayMono parse(byte[] effectParameters) throws ParseException {
        DelayMono delayMono = new DelayMono();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        delayMono.getMix().setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        delayMono.getLevel().setValue(level);

        delayMono.setTime(RateParser.parse("Time", Arrays.copyOfRange(effectParameters, 4, 10)));

        int feedback = (byte) (effectParameters[10] + effectParameters[11] * 16);
        delayMono.getFeedback().setValue(feedback);

        int insert = effectParameters[12] + effectParameters[13] * 16;
        delayMono.getInsert().setValue(insert);

        int clear = effectParameters[14] + effectParameters[15] * 16;
        delayMono.getClear().setValue(Util.parseBoolean(clear));

        return delayMono;
    }
}
