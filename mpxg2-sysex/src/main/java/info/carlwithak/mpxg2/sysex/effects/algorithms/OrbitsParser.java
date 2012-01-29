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

import info.carlwithak.mpxg2.model.effects.algorithms.Orbits;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import java.util.Arrays;

/**
 * Class to parse parameter data for Orbits effect.
 *
 * @author Carl Green
 */
public class OrbitsParser {

    public static Orbits parse(byte[] effectParameters) throws ParseException {
        Orbits orbits = new Orbits();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        orbits.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        orbits.level.setValue(level);

        orbits.setRate1(RateParser.parse("Rate1", Arrays.copyOfRange(effectParameters, 4, 10)));

        int pulseWidth1 = (byte) (effectParameters[10] + effectParameters[11] * 16);
        orbits.pulseWidth1.setValue(pulseWidth1);

        int sync1 = (byte) (effectParameters[12] + effectParameters[13] * 16);
        orbits.sync1.setValue(sync1);

        int depth1 = (byte) (effectParameters[14] + effectParameters[15] * 16);
        orbits.depth1.setValue(depth1);

        orbits.setRate2(RateParser.parse("Rate2", Arrays.copyOfRange(effectParameters, 16, 22)));

        int pulseWidth2 = (byte) (effectParameters[22] + effectParameters[23] * 16);
        orbits.pulseWidth2.setValue(pulseWidth2);

        int sync2 = (byte) (effectParameters[24] + effectParameters[25] * 16);
        orbits.sync2.setValue(sync2);

        int depth2 = (byte) (effectParameters[26] + effectParameters[27] * 16);
        orbits.depth2.setValue(depth2);

        int resonance = (byte) (effectParameters[28] + effectParameters[29] * 16);
        orbits.resonance.setValue(resonance);

        int width = (byte) (effectParameters[30] + effectParameters[31] * 16);
        orbits.width.setValue(width);

        return orbits;
    }

}
