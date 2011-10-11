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

import info.carlwithak.mpxg2.model.effects.algorithms.Ambience;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;

import static info.carlwithak.mpxg2.printing.Util.onOffToLowerString;
import static info.carlwithak.mpxg2.printing.Util.reverbDelayTimeToString;
import static info.carlwithak.mpxg2.printing.Util.reverbAmbienceRtHCToString;
import static info.carlwithak.mpxg2.printing.Util.signInt;

/**
 *
 * @author Carl Green
 */
public class AmbiencePrinter implements Printer {

    @Override
    public String print(Object algorithm) {
        Ambience ambience = (Ambience) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(ambience.getMix()).append("%\n");
        sb.append("    Level: ").append(signInt(ambience.getLevel())).append("dB\n");
        sb.append("    Size: ").append(ambience.getSize()).append("m\n");
        sb.append("    Link: ").append(onOffToLowerString(ambience.isLink())).append("\n");
        sb.append("    Diff: ").append(ambience.getDiff()).append("%\n");
        sb.append("    Pre Delay: ").append(ambience.getPreDelay()).append("ms\n");
        sb.append("    Delay Time: ").append(reverbDelayTimeToString(ambience.getDelayTime())).append("s\n");
        sb.append("    Delay Level: ").append(onOffToLowerString(ambience.getDelayLevel())).append("\n");
        sb.append("    Rt HC: ").append(reverbAmbienceRtHCToString(ambience.getRtHC())).append("k\n");
        return sb.toString();
    }

}