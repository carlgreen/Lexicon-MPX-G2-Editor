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
import info.carlwithak.mpxg2.model.effects.algorithms.FlangerStereo;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;

import static info.carlwithak.mpxg2.printing.Util.signInt;

/**
 *
 * @author Carl Green
 */
public class FlangerStereoPrinter implements Printer {

    private static final String[] PHASES = {"0", "90", "180", "270"};

    @Override
    public String print(Object algorithm) throws PrintException {
        FlangerStereo flangerStereo = (FlangerStereo) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(flangerStereo.getMix()).append("%\n");
        sb.append("    Level: ").append(signInt(flangerStereo.getLevel())).append("dB\n");
        sb.append("    Rate: ").append(RatePrinter.print(flangerStereo.getRate())).append("\n");
        sb.append("    PW: ").append(flangerStereo.getPulseWidth()).append("%\n");
        sb.append("    Depth: ").append(flangerStereo.getDepth()).append("%\n");
        sb.append("    Phase: ").append(phaseToString(flangerStereo.getPhase())).append("°\n");
        sb.append("    Res: ").append(signInt(flangerStereo.getResonance())).append("%\n");
        sb.append("    Blend: ").append(flangerStereo.getBlend()).append("\n");
        return sb.toString();
    }

    private static String phaseToString(final int phase) {
        return PHASES[phase];
    }

}