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

import info.carlwithak.mpxg2.model.effects.algorithms.SweepFilter;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class SweepFilterPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        SweepFilter sweepFilter = (SweepFilter) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(sweepFilter.mix));
        sb.append(printParameter(sweepFilter.level));
        sb.append(printParameter(sweepFilter.fc));
        sb.append(printParameter(sweepFilter.fRes));
        sb.append(printParameter(sweepFilter.mod));
        sb.append(printParameter(sweepFilter.scale));
        sb.append(printParameter(sweepFilter.pan));
        return sb.toString();
    }

}
