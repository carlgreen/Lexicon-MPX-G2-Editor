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

import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah1;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.signInt;
import static info.carlwithak.mpxg2.printing.Util.wahTypeToString;

/**
 *
 * @author Carl Green
 */
public class PedalWah1Printer implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        PedalWah1 pedalWah1 = (PedalWah1) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(pedalWah1.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(pedalWah1.getLevel())).append("\n");
        sb.append("    Bass: ").append(pedalWah1.getBass()).append("\n");
        sb.append("    Type: ").append(wahTypeToString(pedalWah1.getType())).append("\n");
        sb.append("    Resp: ").append(pedalWah1.getResponse()).append("\n");
        sb.append("    Gain: ").append(signInt(pedalWah1.getGain())).append("\n");
        return sb.toString();
    }

}
