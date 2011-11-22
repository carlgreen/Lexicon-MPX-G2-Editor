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

import info.carlwithak.mpxg2.model.effects.algorithms.TremoloMono;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

/**
 *
 * @author Carl Green
 */
public class TremoloMonoPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        TremoloMono tremoloMono = (TremoloMono) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(tremoloMono.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(tremoloMono.getLevel())).append("\n");
        sb.append("    Rate: ").append(ParameterPrinter.print(tremoloMono.getRate())).append("\n");
        sb.append("    PW: ").append(ParameterPrinter.print(tremoloMono.getPulseWidth())).append("\n");
        sb.append("    Depth: ").append(ParameterPrinter.print(tremoloMono.getDepth())).append("\n");
        return sb.toString();
    }

}