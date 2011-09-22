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

/**
 * Class to parse parameter data for Echo (M) effect.
 *
 * @author Carl Green
 */
public class EchoMonoParser {

    public static EchoMono parse(byte[] delayParameters) {
        EchoMono echoMono = new EchoMono();

        int mix = delayParameters[0] + delayParameters[1] * 16;
        echoMono.setMix(mix);

        int level = (byte) (delayParameters[2] + delayParameters[3] * 16);
        echoMono.setLevel(level);

        int timeEchoes = delayParameters[4] + delayParameters[5] * 16;
        echoMono.setTimeEchoes(timeEchoes);

        int timeBeat = delayParameters[6] + delayParameters[7] * 16;
        echoMono.setTimeBeat(timeBeat);

        // TODO time units?

        int feedback = (byte) (delayParameters[10] + delayParameters[11] * 16);
        echoMono.setFeedback(feedback);

        int insert = delayParameters[12] + delayParameters[13] * 16;
        echoMono.setInsert(insert);

        int damp = delayParameters[14] + delayParameters[15] * 16;
        echoMono.setDamp(damp);

        int clear = delayParameters[16] + delayParameters[17] * 16;
        echoMono.setClear(clear);

        return echoMono;
    }
}
