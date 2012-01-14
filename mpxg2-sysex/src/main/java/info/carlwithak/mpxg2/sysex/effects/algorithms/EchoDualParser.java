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

import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import info.carlwithak.mpxg2.sysex.Util;
import java.util.Arrays;

/**
 * Class to parse parameter data for Echo (D) effect.
 *
 * @author Carl Green
 */
public class EchoDualParser {

    public static EchoDual parse(byte[] effectParameters) throws ParseException {
        EchoDual echoDual = new EchoDual();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        echoDual.getMix().setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        echoDual.getLevel().setValue(level);

        echoDual.setTime1(RateParser.parse("Time1", Arrays.copyOfRange(effectParameters, 4, 10)));

        echoDual.setTime2(RateParser.parse("Time2", Arrays.copyOfRange(effectParameters, 10, 16)));

        int level1 = effectParameters[16] + effectParameters[17] * 16;
        echoDual.setLevel1(level1);

        int level2 = effectParameters[18] + effectParameters[19] * 16;
        echoDual.setLevel2(level2);

        int feedback1 = (byte) (effectParameters[20] + effectParameters[21] * 16);
        echoDual.setFeedback1(feedback1);

        int insert = effectParameters[22] + effectParameters[23] * 16;
        echoDual.setInsert(insert);

        int feedback2 = (byte) (effectParameters[24] + effectParameters[25] * 16);
        echoDual.setFeedback2(feedback2);

        int damp1 = effectParameters[26] + effectParameters[27] * 16;
        echoDual.setDamp1(damp1);

        int damp2 = effectParameters[28] + effectParameters[29] * 16;
        echoDual.setDamp2(damp2);

        int clear = effectParameters[30] + effectParameters[31] * 16;
        echoDual.setClear(Util.parseBoolean(clear));

        return echoDual;
    }
}
