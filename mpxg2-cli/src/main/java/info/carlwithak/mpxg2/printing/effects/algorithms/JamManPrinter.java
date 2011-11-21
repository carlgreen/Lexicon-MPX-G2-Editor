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

import info.carlwithak.mpxg2.model.effects.algorithms.JamMan;
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
public class JamManPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        JamMan jamMan = (JamMan) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ParameterPrinter.print(jamMan.getMix())).append("\n");
        sb.append("    Level: ").append(ParameterPrinter.print(jamMan.getLevel())).append("\n");
        sb.append("    Size: ").append(jamMan.getSize()).append("ms\n");
        sb.append("    Feedback: ").append(signInt(jamMan.getFeedback())).append("%\n");
        sb.append("    Insert: ").append(delayInsertToString(jamMan.getInsert())).append("\n");
        sb.append("    Clear: ").append(onOffToString(jamMan.isClear())).append("\n");
        sb.append("    Layer: ").append(onOffToString(jamMan.isLayer())).append("\n");
        sb.append("    Replace: ").append(onOffToString(jamMan.isReplace())).append("\n");
        sb.append("    Delay: ").append(onOffToString(jamMan.isDelay())).append("\n");
        sb.append("    Mute: ").append(onOffToString(jamMan.isMute())).append("\n");
        return sb.toString();
    }

}
