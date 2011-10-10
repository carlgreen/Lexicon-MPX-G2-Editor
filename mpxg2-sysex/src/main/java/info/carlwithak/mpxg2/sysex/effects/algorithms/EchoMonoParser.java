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

import info.carlwithak.mpxg2.model.effects.algorithms.EchoMono;
import info.carlwithak.mpxg2.sysex.Util;

/**
 * Class to parse parameter data for Echo (M) effect.
 *
 * @author Carl Green
 */
public class EchoMonoParser {

    public static EchoMono parse(byte[] effectParameters) {
        EchoMono echoMono = new EchoMono();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        echoMono.setMix(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        echoMono.setLevel(level);

        int timeEchoes = effectParameters[4] + effectParameters[5] * 16;
        echoMono.setTimeEchoes(timeEchoes);

        int timeBeat = effectParameters[6] + effectParameters[7] * 16;
        echoMono.setTimeBeat(timeBeat);

        // TODO time units?

        int feedback = (byte) (effectParameters[10] + effectParameters[11] * 16);
        echoMono.setFeedback(feedback);

        int insert = effectParameters[12] + effectParameters[13] * 16;
        echoMono.setInsert(insert);

        int damp = effectParameters[14] + effectParameters[15] * 16;
        echoMono.setDamp(damp);

        int clear = effectParameters[16] + effectParameters[17] * 16;
        echoMono.setClear(Util.parseBoolean(clear));

        return echoMono;
    }
}
