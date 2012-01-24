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

import info.carlwithak.mpxg2.model.effects.algorithms.Hall;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class HallPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Hall hall = (Hall) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(hall.mix));
        sb.append(printParameter(hall.level));
        sb.append(printParameter(hall.size));
        sb.append(printParameter(hall.link));
        sb.append(printParameter(hall.diff));
        sb.append(printParameter(hall.preDelay));
        sb.append(printParameter(hall.bass));
        sb.append(printParameter(hall.decay));
        sb.append(printParameter(hall.xovr));
        sb.append(printParameter(hall.rtHC));
        sb.append(printParameter(hall.shape));
        sb.append(printParameter(hall.spred));
        return sb.toString();
    }

}
