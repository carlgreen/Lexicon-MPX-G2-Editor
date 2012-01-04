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

import info.carlwithak.mpxg2.model.effects.algorithms.DiatonicHmy;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

/**
 *
 * @author Carl Green
 */
public class DiatonicHmyPrinter implements Printer {
    private static final String[] SCALES = {
        "Major", "Dor", "Phry", "Lyd", "Mixo", "Minor", "Loc"
    };
    private static final String[] INTERVALS = {
        "@Oct", "@7th", "@6th", "@5th", "@4th", "@3rd", "@2nd",
        "-oct", "-7th", "-6th", "-5th", "-4th", "-3rd", "-2nd",
        "uni", "+2nd", "+3rd", "+4th", "+5th", "+6th", "+7th",
        "+oct", "*2nd", "*3rd", "*4th", "*5th"
    };
    /**
     * TODO could probably combine with noise gate inputs
     */
    private final static String[] SOURCES = {
        "", "Guitar Input", "Returns Only"
    };

    @Override
    public String print(Object algorithm) throws PrintException {
        DiatonicHmy diatonicHmy = (DiatonicHmy) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(diatonicHmy.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(diatonicHmy.getLevel())).append("\n");
        sb.append("    Key: ").append(ParameterPrinter.print(diatonicHmy.getKey())).append("\n");
        sb.append("    Scale: ").append(scaleToString(diatonicHmy.getScale().getValue())).append("\n");
        sb.append("    Int: ").append(intervalToString(diatonicHmy.getInterval().getValue())).append("\n");
        sb.append("    Optimize: ").append(ParameterPrinter.print(diatonicHmy.getOptimize())).append("\n");
        sb.append("    Thrsh: ").append(ParameterPrinter.print(diatonicHmy.getThreshold())).append("\n");
        sb.append("    Src: ").append(sourceToString(diatonicHmy.getSource().getValue())).append("\n");
        return sb.toString();
    }

    private static String scaleToString(final int scale) {
        return SCALES[scale];
    }

    private static String intervalToString(final int interval) {
        return INTERVALS[interval];
    }

    private static String sourceToString(final int source) {
        return SOURCES[source];
    }
}
