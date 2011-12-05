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

import info.carlwithak.mpxg2.model.effects.algorithms.Ambience;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.onOffToString;
import static info.carlwithak.mpxg2.printing.Util.reverbDelayTimeToString;
import static info.carlwithak.mpxg2.printing.Util.reverbAmbienceRtHCToString;

/**
 *
 * @author Carl Green
 */
public class AmbiencePrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Ambience ambience = (Ambience) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(ambience.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(ambience.getLevel())).append("\n");
        sb.append("    Size: ").append(ParameterPrinter.print(ambience.getSize())).append("\n");
        sb.append("    Link: ").append(ParameterPrinter.print(ambience.isLink())).append("\n");
        sb.append("    Diff: ").append(ParameterPrinter.print(ambience.getDiff())).append("\n");
        sb.append("    P Dly: ").append(ParameterPrinter.print(ambience.getPreDelay())).append("\n");
        sb.append("    DTime: ").append(reverbDelayTimeToString(ambience.getDelayTime().getValue())).append("s\n");
        // TODO this is not an On/Off kind of situation
        sb.append("    D Lvl: ").append(onOffToString(ambience.getDelayLevel().getValue())).append("\n");
        sb.append("    Rt HC: ").append(reverbAmbienceRtHCToString(ambience.getRtHC().getValue())).append("k\n");
        return sb.toString();
    }

}
