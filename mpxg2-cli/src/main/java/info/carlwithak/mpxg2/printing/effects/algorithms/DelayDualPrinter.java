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

import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.panToString;

/**
 *
 * @author Carl Green
 */
public class DelayDualPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        DelayDual delayDual = (DelayDual) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(delayDual.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(delayDual.getLevel())).append("\n");
        sb.append("    Time1: ").append(ParameterPrinter.print(delayDual.getTime1())).append("\n");
        sb.append("    Time2: ").append(ParameterPrinter.print(delayDual.getTime2())).append("\n");
        sb.append("    Lvl 1: ").append(ParameterPrinter.print(delayDual.getLevel1())).append("\n");
        sb.append("    Lvl 2: ").append(ParameterPrinter.print(delayDual.getLevel2())).append("\n");
        sb.append("    Pan 1: ").append(panToString(delayDual.getPan1().getValue())).append("\n");
        sb.append("    Pan 2: ").append(panToString(delayDual.getPan2().getValue())).append("\n");
        sb.append("    Fbk 1: ").append(ParameterPrinter.print(delayDual.getFeedback1())).append("\n");
        sb.append("    Fbk insert: ").append(ParameterPrinter.print(delayDual.getInsert())).append("\n");
        sb.append("    Fbk 2: ").append(ParameterPrinter.print(delayDual.getFeedback2())).append("\n");
        sb.append("    XFbk1: ").append(ParameterPrinter.print(delayDual.getXFbk1())).append("\n");
        sb.append("    XFbk2: ").append(ParameterPrinter.print(delayDual.getXFbk2())).append("\n");
        sb.append("    Clear: ").append(ParameterPrinter.print(delayDual.isClear())).append("\n");
        return sb.toString();
    }
}
