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

import info.carlwithak.mpxg2.model.effects.algorithms.AutoPan;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;
import info.carlwithak.mpxg2.printing.RatePrinter;

/**
 *
 * @author Carl Green
 */
public class AutoPanPrinter implements Printer {

    private static final String[] PHASES = {"0", "90", "180", "270"};

    @Override
    public String print(Object algorithm) throws PrintException {
        AutoPan autoPan = (AutoPan) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(autoPan.getMix()).append("%\n");
        sb.append("    Level: ").append(autoPan.getLevel()).append("dB\n");
        sb.append("    Rate: ").append(RatePrinter.print(autoPan.getRate())).append("\n");
        sb.append("    PW: ").append(autoPan.getPulseWidth()).append("%\n");
        sb.append("    Depth: ").append(autoPan.getDepth()).append("%\n");
        sb.append("    Phase: ").append(phaseToString(autoPan.getPhase())).append("°\n");
        return sb.toString();
    }

    private static String phaseToString(final int phase) {
        return PHASES[phase];
    }
}
