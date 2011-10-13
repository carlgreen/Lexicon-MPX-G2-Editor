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

import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.ReverbSpredPrinter;

import static info.carlwithak.mpxg2.printing.Util.onOffToString;
import static info.carlwithak.mpxg2.printing.Util.reverbBassToString;
import static info.carlwithak.mpxg2.printing.Util.reverbDecayToString;
import static info.carlwithak.mpxg2.printing.Util.reverbRtHCToString;
import static info.carlwithak.mpxg2.printing.Util.reverbXovrToString;
import static info.carlwithak.mpxg2.printing.Util.signInt;

/**
 *
 * @author Carl Green
 */
public class PlatePrinter implements Printer {

    @Override
    public String print(Object algorithm) {
        Plate plate = (Plate) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(plate.getMix()).append("%\n");
        sb.append("    Level: ").append(signInt(plate.getLevel())).append("dB\n");
        sb.append("    Size: ").append(plate.getSize()).append("m\n");
        sb.append("    Link: ").append(onOffToString(plate.isLink())).append("\n");
        sb.append("    Diff: ").append(plate.getDiff()).append("%\n");
        sb.append("    Pre Delay: ").append(plate.getPreDelay()).append("ms\n");
        sb.append("    Bass: ").append(reverbBassToString(plate.getBass())).append("X\n");
        sb.append("    Decay: ").append(reverbDecayToString(plate.isLink(), plate.getSize(), plate.getDecay())).append("s\n");
        sb.append("    Xovr: ").append(reverbXovrToString(plate.getXovr())).append("\n");
        sb.append("    Rt HC: ").append(reverbRtHCToString(plate.getRtHC())).append("\n");
        sb.append("    Shape: ").append(plate.getShape()).append("\n");
        sb.append("    Spred: ").append(ReverbSpredPrinter.reverbSpredToString(plate.isLink(), plate.getSize(), plate.getSpred())).append("\n");
        return sb.toString();
    }
}
