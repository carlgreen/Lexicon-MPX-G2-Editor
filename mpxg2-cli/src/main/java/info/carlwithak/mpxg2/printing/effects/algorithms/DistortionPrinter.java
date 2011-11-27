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

import info.carlwithak.mpxg2.model.effects.algorithms.Distortion;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

/**
 *
 * @author Carl Green
 */
public class DistortionPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Distortion distortion = (Distortion) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Lo: ").append(ParameterPrinter.print(distortion.getLo())).append("\n");
        sb.append("    Mid: ").append(ParameterPrinter.print(distortion.getMid())).append("\n");
        sb.append("    Hi: ").append(ParameterPrinter.print(distortion.getHi())).append("\n");
        sb.append("    Drive: ").append(ParameterPrinter.print(distortion.getDrive())).append("\n");
        sb.append("    Tone: ").append(ParameterPrinter.print(distortion.getTone())).append("\n");
        sb.append("    Bass: ").append(ParameterPrinter.print(distortion.getBass())).append("\n");
        sb.append("    Trebl: ").append(ParameterPrinter.print(distortion.getTreble())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(distortion.getLevel())).append("\n");
        return sb.toString();
    }

}
