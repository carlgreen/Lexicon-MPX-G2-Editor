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

import info.carlwithak.mpxg2.model.effects.algorithms.Aerosol;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.signInt;

/**
 *
 * @author Carl Green
 */
public class AerosolPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Aerosol aerosol = (Aerosol) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(aerosol.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(aerosol.getLevel())).append("\n");
        sb.append("    Rate1: ").append(ParameterPrinter.print(aerosol.getRate1())).append("\n");
        sb.append("    PW 1: ").append(aerosol.getPulseWidth1()).append("%\n");
        sb.append("    Depth1: ").append(aerosol.getDepth1()).append("%\n");
        sb.append("    Rate2: ").append(ParameterPrinter.print(aerosol.getRate2())).append("\n");
        sb.append("    PW 2: ").append(aerosol.getPulseWidth2()).append("%\n");
        sb.append("    Depth2: ").append(aerosol.getDepth2()).append("%\n");
        sb.append("    Res 1: ").append(signInt(aerosol.getResonance1())).append("\n");
        sb.append("    Res 2: ").append(signInt(aerosol.getResonance2())).append("\n");
        return sb.toString();
    }

}
