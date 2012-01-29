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

import info.carlwithak.mpxg2.model.effects.algorithms.Comb2;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class Comb2Printer implements Printer {

    @Override
    public String print(Object algorithm) {
        Comb2 comb2 = (Comb2) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(comb2.mix));
        sb.append(printParameter(comb2.level));
        sb.append(printParameter(comb2.loCut));
        sb.append(printParameter(comb2.hiCut));
        sb.append(printParameter(comb2.notch));
        sb.append(printParameter(comb2.getRate()));
        sb.append(printParameter(comb2.pulseWidth));
        sb.append(printParameter(comb2.depth));
        sb.append(printParameter(comb2.resonance));
        sb.append(printParameter(comb2.phase));
        return sb.toString();
    }

}
