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

import info.carlwithak.mpxg2.model.effects.algorithms.FlangerStereo;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import java.util.Arrays;

/**
 * Class to parse parameter data for Flanger (S) effect.
 *
 * @author Carl Green
 */
public class FlangerStereoParser {

    public static FlangerStereo parse(byte[] effectParameters) throws ParseException {
        FlangerStereo flangerStereo = new FlangerStereo();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        flangerStereo.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        flangerStereo.level.setValue(level);

        flangerStereo.setRate(RateParser.parse("Rate", Arrays.copyOfRange(effectParameters, 4, 10)));

        int pulseWidth = (byte) (effectParameters[10] + effectParameters[11] * 16);
        flangerStereo.getPulseWidth().setValue(pulseWidth);

        int depth = (byte) (effectParameters[12] + effectParameters[13] * 16);
        flangerStereo.getDepth().setValue(depth);

        int phase = (byte) (effectParameters[14] + effectParameters[15] * 16);
        flangerStereo.getPhase().setValue(phase);

        int resonance = (byte) (effectParameters[16] + effectParameters[17] * 16);
        flangerStereo.getResonance().setValue(resonance);

        int blend = (byte) (effectParameters[18] + effectParameters[19] * 16);
        flangerStereo.getBlend().setValue(blend);

        return flangerStereo;
    }

}
