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

import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;

import static info.carlwithak.mpxg2.printing.Util.delayInsertToString;
import static info.carlwithak.mpxg2.printing.Util.signInt;

/**
 *
 * @author Carl Green
 */
public class EchoDualPrinter implements Printer {

    @Override
    public String print(Object algorithm) {
        EchoDual echoDual = (EchoDual) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(echoDual.getMix()).append("%\n");
        sb.append("    Level: ").append(signInt(echoDual.getLevel())).append("dB\n");
        sb.append("    Time1: ").append(echoDual.getTime1Echoes()).append(":").append(echoDual.getTime1Beat()).append("\n");
        sb.append("    Time2: ").append(echoDual.getTime2Echoes()).append(":").append(echoDual.getTime2Beat()).append("\n");
        sb.append("    Level1: ").append(signInt(echoDual.getLevel1())).append("dB\n");
        sb.append("    Level2: ").append(signInt(echoDual.getLevel2())).append("dB\n");
        sb.append("    Feedback1: ").append(signInt(echoDual.getFeedback1())).append("%\n");
        sb.append("    Insert: ").append(delayInsertToString(echoDual.getInsert())).append("\n");
        sb.append("    Feedback2: ").append(signInt(echoDual.getFeedback2())).append("%\n");
        sb.append("    Damp1: ").append(echoDual.getDamp1()).append("%\n");
        sb.append("    Damp2: ").append(echoDual.getDamp2()).append("%\n");
        sb.append("    Clear: ").append(echoDual.getClear() == 0 ? "off" : "on").append("\n");
        return sb.toString();
    }

}