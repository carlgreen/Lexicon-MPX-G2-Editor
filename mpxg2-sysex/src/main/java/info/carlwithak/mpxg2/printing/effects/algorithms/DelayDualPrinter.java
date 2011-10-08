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

import static info.carlwithak.mpxg2.printing.Util.delayInsertToString;
import static info.carlwithak.mpxg2.printing.Util.onOffToString;
import static info.carlwithak.mpxg2.printing.Util.panToString;
import static info.carlwithak.mpxg2.printing.Util.signInt;

/**
 *
 * @author Carl Green
 */
public class DelayDualPrinter implements Printer {

    @Override
    public String print(Object algorithm) {
        DelayDual delayDual = (DelayDual) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(delayDual.getMix()).append("%\n");
        sb.append("    Level: ").append(signInt(delayDual.getLevel())).append("dB\n");
        sb.append("    Time1: ").append(delayDual.getTime1Echoes()).append(":").append(delayDual.getTime1Beat()).append("\n");
        sb.append("    Time2: ").append(delayDual.getTime2Echoes()).append(":").append(delayDual.getTime2Beat()).append("\n");
        sb.append("    Level1: ").append(signInt(delayDual.getLevel1())).append("dB\n");
        sb.append("    Level2: ").append(signInt(delayDual.getLevel2())).append("dB\n");
        sb.append("    Pan1: ").append(panToString(delayDual.getPan1())).append("\n");
        sb.append("    Pan2: ").append(panToString(delayDual.getPan2())).append("\n");
        sb.append("    Feedback1: ").append(signInt(delayDual.getFeedback1())).append("%\n");
        sb.append("    Insert: ").append(delayInsertToString(delayDual.getInsert())).append("\n");
        sb.append("    Feedback2: ").append(signInt(delayDual.getFeedback2())).append("%\n");
        sb.append("    XFbk1: ").append(signInt(delayDual.getXFbk1())).append("%\n");
        sb.append("    XFbk2: ").append(signInt(delayDual.getXFbk2())).append("%\n");
        sb.append("    Clear: ").append(onOffToString(delayDual.isClear())).append("\n");
        return sb.toString();
    }
}
