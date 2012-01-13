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

package info.carlwithak.mpxg2.sysex;

import info.carlwithak.mpxg2.model.parameters.BeatRate;
import info.carlwithak.mpxg2.model.parameters.FrequencyRate;
import info.carlwithak.mpxg2.model.parameters.Rate;
import info.carlwithak.mpxg2.model.parameters.TapMsRate;

/**
 * Parse appropriate Rate from bytes.
 *
 * @author Carl Green
 */
public class RateParser {

    public static Rate parse(final String name, byte[] rateBytes) throws ParseException {
        Rate rate;
        int rateUnit = rateBytes[4] + rateBytes[5] * 16;
        if (rateUnit == 0) {
            int frequency = 0;
            for (int i = 0; i < 4; i++) {
                frequency += (rateBytes[i] * Math.pow(16, i));
            }
            rate = new FrequencyRate(name, frequency == 0x8000 ? null : frequency / 100.0);
        } else if (rateUnit == 1) {
            int cycles = rateBytes[0] + rateBytes[1] * 16;
            int beats = rateBytes[2] + rateBytes[3] * 16;
            if (beats == 0x80 && cycles == 0x00) {
                rate = new BeatRate(name, null, null);
            } else {
                rate = new BeatRate(name, cycles, beats);
            }
        } else if (rateUnit == 4) {
            int ms = 0;
            for (int i = 0; i < 4; i++) {
                ms += (rateBytes[i] * Math.pow(16, i));
            }
            rate = new TapMsRate(name, ms == 0x8000 ? null : ms);
        } else {
            throw new ParseException("Unexpected rate unit: " + rateUnit);
        }
        return rate;
    }
}
