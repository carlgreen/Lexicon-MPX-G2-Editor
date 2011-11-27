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

import info.carlwithak.mpxg2.model.effects.algorithms.Overdrive;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

/**
 *
 * @author Carl Green
 */
public class OverdrivePrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Overdrive overdrive = (Overdrive) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Lo: ").append(ParameterPrinter.print(overdrive.getLo())).append("\n");
        sb.append("    Mid: ").append(ParameterPrinter.print(overdrive.getMid())).append("\n");
        sb.append("    Hi: ").append(ParameterPrinter.print(overdrive.getHi())).append("\n");
        sb.append("    InLvl: ").append(ParameterPrinter.print(overdrive.getInLevel())).append("\n");
        sb.append("    LoCut: ").append(ParameterPrinter.print(overdrive.getLoCut())).append("\n");
        sb.append("    Feel: ").append(ParameterPrinter.print(overdrive.getFeel())).append("\n");
        sb.append("    Drive: ").append(ParameterPrinter.print(overdrive.getDrive())).append("\n");
        sb.append("    Tone: ").append(ParameterPrinter.print(overdrive.getTone())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(overdrive.getLevel())).append("\n");
        return sb.toString();
    }

}
