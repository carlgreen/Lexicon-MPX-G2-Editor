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

import info.carlwithak.mpxg2.model.effects.algorithms.EchoMono;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ParameterPrinter;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.delayInsertToString;
import static info.carlwithak.mpxg2.printing.Util.onOffToString;
import static info.carlwithak.mpxg2.printing.Util.signInt;

/**
 *
 * @author Carl Green
 */
public class EchoMonoPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        EchoMono echoMono = (EchoMono) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(echoMono.getMix()).append("%\n");
        sb.append("    Level: ").append(signInt(echoMono.getLevel())).append("dB\n");
        sb.append("    Time: ").append(ParameterPrinter.print(echoMono.getTime())).append("\n");
        sb.append("    Feedback: ").append(signInt(echoMono.getFeedback())).append("%\n");
        sb.append("    Insert: ").append(delayInsertToString(echoMono.getInsert())).append("\n");
        sb.append("    Damp: ").append(echoMono.getDamp()).append("%\n");
        sb.append("    Clear: ").append(onOffToString(echoMono.isClear())).append("\n");
        return sb.toString();
    }

}
