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

import info.carlwithak.mpxg2.model.effects.algorithms.Phaser;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.RateParser;
import java.util.Arrays;

/**
 * Class to parse parameter data for Phaser effect.
 *
 * @author Carl Green
 */
public class PhaserParser {

    public static Phaser parse(byte[] effectParameters) throws ParseException {
        Phaser phaser = new Phaser();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        phaser.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        phaser.level.setValue(level);

        phaser.setRate(RateParser.parse("Rate", Arrays.copyOfRange(effectParameters, 4, 10)));

        int pulseWidth = effectParameters[10] + effectParameters[11] * 16;
        phaser.pulseWidth.setValue(pulseWidth);

        int depth = effectParameters[12] + effectParameters[13] * 16;
        phaser.depth.setValue(depth);

        int resonance = effectParameters[14] + effectParameters[15] * 16;
        phaser.resonance.setValue(resonance);

        return phaser;
    }

}
