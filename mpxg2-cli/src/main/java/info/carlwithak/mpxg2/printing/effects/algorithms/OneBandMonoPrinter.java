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

import info.carlwithak.mpxg2.model.effects.algorithms.OneBandMono;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.eqModeToString;

/**
 *
 * @author Carl Green
 */
public class OneBandMonoPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        OneBandMono oneBandMono = (OneBandMono) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(oneBandMono.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(oneBandMono.getLevel())).append("\n");
        sb.append("    Gain: ").append(ParameterPrinter.print(oneBandMono.getGain())).append("\n");
        sb.append("    Fc: ").append(ParameterPrinter.print(oneBandMono.getFc())).append("\n");
        sb.append("    Q: ").append(ParameterPrinter.print(oneBandMono.getQ())).append("\n");
        sb.append("    Mode: ").append(eqModeToString(oneBandMono.getMode().getValue())).append("\n");
        return sb.toString();
    }

}
