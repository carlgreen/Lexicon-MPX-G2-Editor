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

package info.carlwithak.mpxg2.printing.effects.algorithms;

import info.carlwithak.mpxg2.model.effects.algorithms.Centrifuge2;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class Centrifuge2Printer implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Centrifuge2 centrifuge2 = (Centrifuge2) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(centrifuge2.mix));
        sb.append(printParameter(centrifuge2.level));
        sb.append(printParameter(centrifuge2.getRate1()));
        sb.append(printParameter(centrifuge2.pulseWidth1));
        sb.append(printParameter(centrifuge2.sync1));
        sb.append(printParameter(centrifuge2.depth1));
        sb.append(printParameter(centrifuge2.getRate2()));
        sb.append(printParameter(centrifuge2.pulseWidth2));
        sb.append(printParameter(centrifuge2.sync2));
        sb.append(printParameter(centrifuge2.depth2));
        sb.append(printParameter(centrifuge2.resonance));
        return sb.toString();
    }

}
