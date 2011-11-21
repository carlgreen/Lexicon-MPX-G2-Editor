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
import info.carlwithak.mpxg2.model.GenericValue;
import info.carlwithak.mpxg2.model.Parameter;
import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.TapMsRate;
import java.text.DecimalFormat;

/**
 * Class to print out a parameter correctly depending on the type.
 *
 * @author Carl Green
 */
public class ParameterPrinter {

    private static final DecimalFormat DECIMAL_2DP = new DecimalFormat("0.00");

    public static String print(Parameter parameter) throws PrintException {
        String result;
        if (parameter instanceof Rate) {
            if (parameter instanceof FrequencyRate) {
                FrequencyRate frequencyRate = (FrequencyRate) parameter;
                result = DECIMAL_2DP.format(frequencyRate.getFrequency()) + "Hz";
            } else if (parameter instanceof BeatRate) {
                BeatRate beatRate = (BeatRate) parameter;
                result = beatRate.getMeasures() + ":" + beatRate.getBeats();
            } else if (parameter instanceof TapMsRate) {
                TapMsRate tapMsRate = (TapMsRate) parameter;
                result = tapMsRate.getMs() + "ms";
            } else {
                throw new PrintException("Invalid rate type: " + parameter.getClass());
            }
        } else if (parameter instanceof GenericValue) {
            GenericValue value = (GenericValue) parameter;
            result = value.getValue() + value.getUnit();
        } else {
            throw new PrintException("Invalid parameter type: " + parameter.getClass());
        }
        return result;
    }
}
