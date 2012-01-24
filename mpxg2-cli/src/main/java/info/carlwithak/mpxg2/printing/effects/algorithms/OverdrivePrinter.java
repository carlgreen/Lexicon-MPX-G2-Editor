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

import info.carlwithak.mpxg2.model.effects.algorithms.Overdrive;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class OverdrivePrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Overdrive overdrive = (Overdrive) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(overdrive.lo));
        sb.append(printParameter(overdrive.mid));
        sb.append(printParameter(overdrive.hi));
        sb.append(printParameter(overdrive.inLevel));
        sb.append(printParameter(overdrive.loCut));
        sb.append(printParameter(overdrive.feel));
        sb.append(printParameter(overdrive.drive));
        sb.append(printParameter(overdrive.tone));
        sb.append(printParameter(overdrive.level));
        return sb.toString();
    }

}
