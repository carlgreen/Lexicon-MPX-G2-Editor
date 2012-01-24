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

import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import info.carlwithak.mpxg2.sysex.Util;
import java.util.Arrays;

/**
 * Class to parse parameter data for Delay (D) effect.
 *
 * @author Carl Green
 */
public class DelayDualParser {

    public static DelayDual parse(byte[] effectParameters) throws ParseException {
        DelayDual delayDual = new DelayDual();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        delayDual.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        delayDual.level.setValue(level);

        delayDual.setTime1(RateParser.parse("Time1", Arrays.copyOfRange(effectParameters, 4, 10)));

        delayDual.setTime2(RateParser.parse("Time2", Arrays.copyOfRange(effectParameters, 10, 16)));

        int level1 = effectParameters[16] + effectParameters[17] * 16;
        delayDual.level1.setValue(level1);

        int level2 = effectParameters[18] + effectParameters[19] * 16;
        delayDual.level2.setValue(level2);

        int pan1 = (byte) (effectParameters[20] + effectParameters[21] * 16);
        delayDual.pan1.setValue(pan1);

        int pan2 = (byte) (effectParameters[22] + effectParameters[23] * 16);
        delayDual.pan2.setValue(pan2);

        int feedback1 = (byte) (effectParameters[24] + effectParameters[25] * 16);
        delayDual.feedback1.setValue(feedback1);

        int insert = effectParameters[26] + effectParameters[27] * 16;
        delayDual.insert.setValue(insert);

        int feedback2 = (byte) (effectParameters[28] + effectParameters[29] * 16);
        delayDual.feedback2.setValue(feedback2);

        int xFbk1 = effectParameters[30] + effectParameters[31] * 16;
        delayDual.xFbk1.setValue(xFbk1);

        int xFbk2 = effectParameters[32] + effectParameters[33] * 16;
        delayDual.xFbk2.setValue(xFbk2);

        int clear = effectParameters[34] + effectParameters[35] * 16;
        delayDual.clear.setValue(Util.parseBoolean(clear));

        return delayDual;
    }
}
