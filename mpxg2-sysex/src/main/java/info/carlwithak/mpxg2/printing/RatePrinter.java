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

package info.carlwithak.mpxg2.printing;

import info.carlwithak.mpxg2.model.BeatRate;
import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.Rate;
import java.text.DecimalFormat;

/**
 * Class to print out a rate correctly depending on the type.
 *
 * @author Carl Green
 */
public class RatePrinter {

    private static final DecimalFormat DECIMAL_2DP = new DecimalFormat("0.00");

    static String print(Rate rate) throws PrintException {
        String result;
        if (rate instanceof FrequencyRate) {
            FrequencyRate frequencyRate = (FrequencyRate) rate;
            result = DECIMAL_2DP.format(frequencyRate.getFrequency()) + "Hz";
        } else if (rate instanceof BeatRate) {
            BeatRate beatRate = (BeatRate) rate;
            result = beatRate.getMeasures() + ":" + beatRate.getBeats();
        } else {
            throw new PrintException("Invalid rate type: " + rate.getClass());
        }
        return result;
    }

}
