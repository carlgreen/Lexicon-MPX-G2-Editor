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

import info.carlwithak.mpxg2.model.effects.algorithms.Centrifuge1;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import java.util.Arrays;

/**
 * Class to parse parameter data for Centrifuge1 effect.
 *
 * @author Carl Green
 */
public class Centrifuge1Parser {

    public static Centrifuge1 parse(byte[] effectParameters) throws ParseException {
        Centrifuge1 centrifuge1 = new Centrifuge1();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        centrifuge1.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        centrifuge1.level.setValue(level);

        centrifuge1.setRate1(RateParser.parse("Rate1", Arrays.copyOfRange(effectParameters, 4, 10)));

        int pulseWidth1 = (byte) (effectParameters[10] + effectParameters[11] * 16);
        centrifuge1.pulseWidth1.setValue(pulseWidth1);

        int sync1 = (byte) (effectParameters[12] + effectParameters[13] * 16);
        centrifuge1.sync1.setValue(sync1);

        int depth1 = (byte) (effectParameters[14] + effectParameters[15] * 16);
        centrifuge1.depth1.setValue(depth1);

        centrifuge1.setRate2(RateParser.parse("Rate2", Arrays.copyOfRange(effectParameters, 16, 22)));

        int pulseWidth2 = (byte) (effectParameters[22] + effectParameters[23] * 16);
        centrifuge1.pulseWidth2.setValue(pulseWidth2);

        int sync2 = (byte) (effectParameters[24] + effectParameters[25] * 16);
        centrifuge1.sync2.setValue(sync2);

        int depth2 = (byte) (effectParameters[26] + effectParameters[27] * 16);
        centrifuge1.depth2.setValue(depth2);

        int resonance = (byte) (effectParameters[28] + effectParameters[29] * 16);
        centrifuge1.resonance.setValue(resonance);

        return centrifuge1;
    }
}
