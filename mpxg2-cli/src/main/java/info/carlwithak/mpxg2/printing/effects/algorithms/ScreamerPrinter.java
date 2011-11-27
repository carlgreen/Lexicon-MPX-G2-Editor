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

import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

/**
 *
 * @author Carl Green
 */
public class ScreamerPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Screamer screamer = (Screamer) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Lo: ").append(ParameterPrinter.print(screamer.getLo())).append("\n");
        sb.append("    Mid: ").append(ParameterPrinter.print(screamer.getMid())).append("\n");
        sb.append("    Hi: ").append(ParameterPrinter.print(screamer.getHi())).append("\n");
        sb.append("    Drive: ").append(ParameterPrinter.print(screamer.getDrive())).append("\n");
        sb.append("    Tone: ").append(ParameterPrinter.print(screamer.getTone())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(screamer.getLevel())).append("\n");
        return sb.toString();
    }

}
