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

import info.carlwithak.mpxg2.model.effects.algorithms.TwoBandDual;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;


/**
 *
 * @author Carl Green
 */
public class TwoBandDualPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        TwoBandDual twoBandDual = (TwoBandDual) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(twoBandDual.mix));
        sb.append(printParameter(twoBandDual.level));
        sb.append(printParameter(twoBandDual.gainLeft1));
        sb.append(printParameter(twoBandDual.fcLeft1));
        sb.append(printParameter(twoBandDual.qLeft1));
        sb.append(printParameter(twoBandDual.modeLeft1));
        sb.append(printParameter(twoBandDual.gainLeft2));
        sb.append(printParameter(twoBandDual.fcLeft2));
        sb.append(printParameter(twoBandDual.qLeft2));
        sb.append(printParameter(twoBandDual.modeLeft2));
        sb.append(printParameter(twoBandDual.gainRight1));
        sb.append(printParameter(twoBandDual.fcRight1));
        sb.append(printParameter(twoBandDual.qRight1));
        sb.append(printParameter(twoBandDual.modeRight1));
        sb.append(printParameter(twoBandDual.gainRight2));
        sb.append(printParameter(twoBandDual.fcRight2));
        sb.append(printParameter(twoBandDual.qRight2));
        sb.append(printParameter(twoBandDual.modeRight2));
        return sb.toString();
    }

}
