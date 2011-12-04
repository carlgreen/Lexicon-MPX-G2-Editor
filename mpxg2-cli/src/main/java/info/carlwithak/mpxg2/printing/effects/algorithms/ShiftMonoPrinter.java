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

import info.carlwithak.mpxg2.model.effects.algorithms.ShiftMono;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

/**
 *
 * @author Carl Green
 */
public class ShiftMonoPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        ShiftMono shiftMono = (ShiftMono) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(shiftMono.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(shiftMono.getLevel())).append("\n");
        sb.append("    Tune: ").append(ParameterPrinter.print(shiftMono.getTune())).append("\n");
        sb.append("    Optimize: ").append(ParameterPrinter.print(shiftMono.getOptimize())).append("\n");
        sb.append("    Glide: ").append(ParameterPrinter.print(shiftMono.isGlide())).append("\n");
        return sb.toString();
    }

}
