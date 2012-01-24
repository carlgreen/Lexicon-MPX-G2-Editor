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

import info.carlwithak.mpxg2.model.effects.algorithms.RotaryCab;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class RotaryCabPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        RotaryCab rotaryCab = (RotaryCab) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(rotaryCab.mix));
        sb.append(printParameter(rotaryCab.level));
        sb.append(printParameter(rotaryCab.getRate1()));
        sb.append(printParameter(rotaryCab.depth1));
        sb.append(printParameter(rotaryCab.getRate2()));
        sb.append(printParameter(rotaryCab.depth2));
        sb.append(printParameter(rotaryCab.resonance));
        sb.append(printParameter(rotaryCab.width));
        sb.append(printParameter(rotaryCab.balance));
        return sb.toString();
    }

}
