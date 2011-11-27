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
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;
import info.carlwithak.mpxg2.printing.ReverbSpredPrinter;

import static info.carlwithak.mpxg2.printing.Util.reverbBassToString;
import static info.carlwithak.mpxg2.printing.Util.reverbDecayToString;
import static info.carlwithak.mpxg2.printing.Util.reverbRtHCToString;
import static info.carlwithak.mpxg2.printing.Util.reverbXovrToString;

/**
 *
 * @author Carl Green
 */
public class HallPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Hall hall = (Hall) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(hall.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(hall.getLevel())).append("\n");
        sb.append("    Size: ").append(ParameterPrinter.print(hall.getSize())).append("\n");
        sb.append("    Link: ").append(ParameterPrinter.print(hall.isLink())).append("\n");
        sb.append("    Diff: ").append(ParameterPrinter.print(hall.getDiff())).append("\n");
        sb.append("    Pre Delay: ").append(ParameterPrinter.print(hall.getPreDelay())).append("\n");
        sb.append("    Bass: ").append(reverbBassToString(hall.getBass().getValue())).append("X\n");
        sb.append("    Decay: ").append(reverbDecayToString(hall.isLink().getValue(), hall.getSize().getValue(), hall.getDecay().getValue())).append("s\n");
        sb.append("    Xovr: ").append(reverbXovrToString(hall.getXovr().getValue())).append("\n");
        sb.append("    Rt HC: ").append(reverbRtHCToString(hall.getRtHC().getValue())).append("\n");
        sb.append("    Shape: ").append(ParameterPrinter.print(hall.getShape())).append("\n");
        sb.append("    Spred: ").append(ReverbSpredPrinter.reverbSpredToString(hall.isLink().getValue(), hall.getSize().getValue(), hall.getSpred().getValue())).append("\n");
        return sb.toString();
    }
}
