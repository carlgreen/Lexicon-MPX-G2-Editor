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

import info.carlwithak.mpxg2.printing.PrintException;
import info.carlwithak.mpxg2.printing.RatePrinter;
import info.carlwithak.mpxg2.model.effects.algorithms.Centrifuge1;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;

import static info.carlwithak.mpxg2.printing.Util.signInt;

/**
 *
 * @author Carl Green
 */
public class Centrifuge1Printer implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Centrifuge1 centrifuge1 = (Centrifuge1) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(centrifuge1.getMix()).append("%\n");
        sb.append("    Level: ").append(signInt(centrifuge1.getLevel())).append("dB\n");
        sb.append("    Rate1: ").append(RatePrinter.print(centrifuge1.getRate1())).append("\n");
        sb.append("    PW 1: ").append(centrifuge1.getPulseWidth1()).append("%\n");
        sb.append("    Sync1: ").append(signInt(centrifuge1.getSync1())).append("\n");
        sb.append("    Depth1: ").append(centrifuge1.getDepth1()).append("%\n");
        sb.append("    Rate2: ").append(RatePrinter.print(centrifuge1.getRate2())).append("\n");
        sb.append("    PW 2: ").append(centrifuge1.getPulseWidth2()).append("%\n");
        sb.append("    Sync2: ").append(signInt(centrifuge1.getSync2())).append("\n");
        sb.append("    Depth2: ").append(centrifuge1.getDepth2()).append("%\n");
        sb.append("    Res: ").append(signInt(centrifuge1.getResonance())).append("%\n");
        return sb.toString();
    }

}
