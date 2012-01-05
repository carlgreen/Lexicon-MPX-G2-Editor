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

import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;
import info.carlwithak.mpxg2.printing.ReverbSpredPrinter;

import static info.carlwithak.mpxg2.printing.Util.reverbDecayToString;

/**
 *
 * @author Carl Green
 */
public class PlatePrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Plate plate = (Plate) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(plate.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(plate.getLevel())).append("\n");
        sb.append("    Size: ").append(ParameterPrinter.print(plate.getSize())).append("\n");
        sb.append("    Link: ").append(ParameterPrinter.print(plate.isLink())).append("\n");
        sb.append("    Diff: ").append(ParameterPrinter.print(plate.getDiff())).append("\n");
        sb.append("    P Dly: ").append(ParameterPrinter.print(plate.getPreDelay())).append("\n");
        sb.append("    Bass: ").append(ParameterPrinter.print(plate.getBass())).append("\n");
        sb.append("    Decay: ").append(reverbDecayToString(plate.isLink().getValue(), plate.getSize().getValue(), plate.getDecay().getValue())).append("s\n");
        sb.append("    Xovr: ").append(ParameterPrinter.print(plate.getXovr())).append("\n");
        sb.append("    Rt HC: ").append(ParameterPrinter.print(plate.getRtHC())).append("\n");
        sb.append("    Shape: ").append(ParameterPrinter.print(plate.getShape())).append("\n");
        sb.append("    Spred: ").append(ReverbSpredPrinter.reverbSpredToString(plate.isLink().getValue(), plate.getSize().getValue(), plate.getSpred().getValue())).append("\n");
        return sb.toString();
    }
}
