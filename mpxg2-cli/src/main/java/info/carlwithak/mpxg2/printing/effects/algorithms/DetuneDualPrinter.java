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

import info.carlwithak.mpxg2.model.effects.algorithms.DetuneDual;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class DetuneDualPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        DetuneDual detuneDual = (DetuneDual) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(detuneDual.mix));
        sb.append(printParameter(detuneDual.level));
        sb.append(printParameter(detuneDual.tune1));
        sb.append(printParameter(detuneDual.optimize));
        sb.append(printParameter(detuneDual.tune2));
        sb.append(printParameter(detuneDual.preDelay));
        return sb.toString();
    }

}
