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

package info.carlwithak.mpxg2.printing.effects.algorithms;

import info.carlwithak.mpxg2.model.effects.algorithms.ChorusAlgorithm;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class ChorusPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        ChorusAlgorithm chorus = (ChorusAlgorithm) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(chorus.mix));
        sb.append(printParameter(chorus.level));
        sb.append(printParameter(chorus.getRate1()));
        sb.append(printParameter(chorus.pulseWidth1));
        sb.append(printParameter(chorus.depth1));
        sb.append(printParameter(chorus.getRate2()));
        sb.append(printParameter(chorus.pulseWidth2));
        sb.append(printParameter(chorus.depth2));
        sb.append(printParameter(chorus.resonance1));
        sb.append(printParameter(chorus.resonance2));
        return sb.toString();
    }

}
