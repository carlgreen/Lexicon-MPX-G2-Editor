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

import info.carlwithak.mpxg2.model.effects.algorithms.Aerosol;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import java.util.Arrays;

/**
 * Class to parse parameter data for Aerosol effect.
 *
 * @author Carl Green
 */
public class AerosolParser {

    public static Aerosol parse(byte[] effectParameters) throws ParseException {
        Aerosol aerosol = new Aerosol();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        aerosol.getMix().setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        aerosol.getLevel().setValue(level);

        aerosol.setRate1(RateParser.parse("Rate1", Arrays.copyOfRange(effectParameters, 4, 10)));

        int pulseWidth1 = (byte) (effectParameters[10] + effectParameters[11] * 16);
        aerosol.setPulseWidth1(pulseWidth1);

        int depth1 = (byte) (effectParameters[12] + effectParameters[13] * 16);
        aerosol.setDepth1(depth1);

        aerosol.setRate2(RateParser.parse("Rate2", Arrays.copyOfRange(effectParameters, 14, 20)));

        int pulseWidth2 = (byte) (effectParameters[20] + effectParameters[21] * 16);
        aerosol.setPulseWidth2(pulseWidth2);

        int depth2 = (byte) (effectParameters[22] + effectParameters[23] * 16);
        aerosol.setDepth2(depth2);

        int resonance1 = (byte) (effectParameters[24] + effectParameters[25] * 16);
        aerosol.setResonance1(resonance1);

        int resonance2 = (byte) (effectParameters[26] + effectParameters[27] * 16);
        aerosol.setResonance2(resonance2);

        return aerosol;
    }
}
