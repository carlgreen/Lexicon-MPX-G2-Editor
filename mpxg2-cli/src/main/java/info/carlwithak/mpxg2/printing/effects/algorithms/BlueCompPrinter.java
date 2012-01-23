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

import info.carlwithak.mpxg2.model.effects.algorithms.BlueComp;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class BlueCompPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        BlueComp blueComp = (BlueComp) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(blueComp.mix));
        sb.append(printParameter(blueComp.level));
        sb.append(printParameter(blueComp.getSensitivity()));
        sb.append(printParameter(blueComp.getThreshold()));
        sb.append(printParameter(blueComp.getGain()));
        sb.append(printParameter(blueComp.getAttackTime()));
        sb.append(printParameter(blueComp.getReleaseTime()));
        return sb.toString();
    }

}
