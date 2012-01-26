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

import info.carlwithak.mpxg2.model.effects.algorithms.Comb1;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class Comb1Printer implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Comb1 comb1 = (Comb1) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(comb1.mix));
        sb.append(printParameter(comb1.level));
        sb.append(printParameter(comb1.loCut));
        sb.append(printParameter(comb1.hiCut));
        sb.append(printParameter(comb1.comb));
        sb.append(printParameter(comb1.notch));
        return sb.toString();
    }

}
