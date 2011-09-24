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

import info.carlwithak.mpxg2.model.effects.algorithms.DetuneDual;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;

import static info.carlwithak.mpxg2.printing.Util.signInt;

/**
 *
 * @author Carl Green
 */
public class DetuneDualPrinter implements Printer {

    @Override
    public String print(Object algorithm) {
        DetuneDual detuneDual = (DetuneDual) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(detuneDual.getMix()).append("%\n");
        sb.append("    Level: ").append(signInt(detuneDual.getLevel())).append("dB\n");
        sb.append("    Tune1: ").append(detuneDual.getTune1()).append("\n");
        sb.append("    Optimize: ").append(detuneDual.getOptimize()).append("ms\n");
        sb.append("    Tune2: ").append(detuneDual.getTune2()).append("\n");
        sb.append("    P Dly: ").append(detuneDual.getPreDelay()).append("ms\n");
        return sb.toString();
    }

}
