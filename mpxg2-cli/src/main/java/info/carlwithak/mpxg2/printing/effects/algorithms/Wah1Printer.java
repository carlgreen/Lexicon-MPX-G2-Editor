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

import info.carlwithak.mpxg2.model.effects.algorithms.Wah1;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.signInt;
import static info.carlwithak.mpxg2.printing.Util.wahTypeToString;

/**
 *
 * @author Carl Green
 */
public class Wah1Printer implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Wah1 wah1 = (Wah1) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(wah1.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(wah1.getLevel())).append("\n");
        sb.append("    Sweep: ").append(wah1.getSweep()).append("\n");
        sb.append("    Bass: ").append(wah1.getBass()).append("\n");
        sb.append("    Type: ").append(wahTypeToString(wah1.getType())).append("\n");
        sb.append("    Resp: ").append(wah1.getResponse()).append("\n");
        sb.append("    Gain: ").append(signInt(wah1.getGain())).append("\n");
        return sb.toString();
    }

}
