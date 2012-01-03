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

import info.carlwithak.mpxg2.model.effects.algorithms.TwoBandStereo;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.eqModeToString;

/**
 *
 * @author Carl Green
 */
public class TwoBandStereoPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        TwoBandStereo twoBandStereo = (TwoBandStereo) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(twoBandStereo.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(twoBandStereo.getLevel())).append("\n");
        sb.append("    Gain1: ").append(ParameterPrinter.print(twoBandStereo.getGain1())).append("\n");
        sb.append("    Fc 1: ").append(ParameterPrinter.print(twoBandStereo.getFc1())).append("\n");
        sb.append("    Q 1: ").append(ParameterPrinter.print(twoBandStereo.getQ1())).append("\n");
        sb.append("    Mode1: ").append(eqModeToString(twoBandStereo.getMode1().getValue())).append("\n");
        sb.append("    Gain2: ").append(ParameterPrinter.print(twoBandStereo.getGain2())).append("\n");
        sb.append("    Fc 2: ").append(ParameterPrinter.print(twoBandStereo.getFc2())).append("\n");
        sb.append("    Q 2: ").append(ParameterPrinter.print(twoBandStereo.getQ2())).append("\n");
        sb.append("    Mode2: ").append(eqModeToString(twoBandStereo.getMode2().getValue())).append("\n");
        return sb.toString();
    }

}