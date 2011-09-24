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

import info.carlwithak.mpxg2.model.effects.algorithms.Panner;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;

/**
 *
 * @author Carl Green
 */
public class PannerPrinter implements Printer {

    @Override
    public String print(Object algorithm) {
        Panner panner = (Panner) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(panner.getMix()).append("%\n");
        sb.append("    Level: ").append(panner.getLevel()).append("dB\n");
        sb.append("    Pan1: ").append(panToString(panner.getPan1())).append("\n");
        sb.append("    Pan2: ").append(panToString(panner.getPan2())).append("\n");
        return sb.toString();
    }

    private static String panToString(final int pan) {
        String suffix = "";
        if (pan < 0) {
            suffix = "L";
        } else if (pan > 0) {
            suffix = "R";
        }
        return Integer.toString(Math.abs(pan)) + suffix;
    }
}
