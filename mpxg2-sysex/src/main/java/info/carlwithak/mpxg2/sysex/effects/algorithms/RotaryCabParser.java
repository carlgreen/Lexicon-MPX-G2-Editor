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

import info.carlwithak.mpxg2.model.effects.algorithms.RotaryCab;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import java.util.Arrays;

/**
 * Class to parse parameter data for Rotary Cab effect.
 *
 * @author Carl Green
 */
public class RotaryCabParser {

    public static RotaryCab parse(byte[] effectParameters) throws ParseException {
        RotaryCab rotaryCab = new RotaryCab();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        rotaryCab.getMix().setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        rotaryCab.getLevel().setValue(level);

        rotaryCab.setRate1(RateParser.parse("Rate1", Arrays.copyOfRange(effectParameters, 4, 10)));

        int depth1 = (byte) (effectParameters[10] + effectParameters[11] * 16);
        rotaryCab.getDepth1().setValue(depth1);

        rotaryCab.setRate2(RateParser.parse("Rate2", Arrays.copyOfRange(effectParameters, 12, 18)));

        int depth2 = (byte) (effectParameters[18] + effectParameters[19] * 16);
        rotaryCab.getDepth2().setValue(depth2);

        int resonance = (byte) (effectParameters[20] + effectParameters[21] * 16);
        rotaryCab.getResonance().setValue(resonance);

        int width = (byte) (effectParameters[22] + effectParameters[23] * 16);
        rotaryCab.getWidth().setValue(width);

        int balance = (byte) (effectParameters[24] + effectParameters[25] * 16);
        rotaryCab.getBalance().setValue(balance);

        return rotaryCab;
    }
}
