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

import info.carlwithak.mpxg2.model.effects.algorithms.TwoBandMono;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;

import static info.carlwithak.mpxg2.printing.Util.eqModeToString;
import static info.carlwithak.mpxg2.printing.Util.signInt;

/**
 *
 * @author Carl Green
 */
public class TwoBandMonoPrinter implements Printer {

    @Override
    public String print(Object algorithm) {
        TwoBandMono twoBandMono = (TwoBandMono) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append("    Mix: ").append(twoBandMono.getMix()).append("%\n");
        sb.append("    Level: ").append(signInt(twoBandMono.getLevel())).append("dB\n");
        sb.append("    Gain1: ").append(signInt(twoBandMono.getGain1())).append("\n");
        sb.append("    Fc 1: ").append(twoBandMono.getFc1()).append("\n");
        sb.append("    Q 1: ").append(twoBandMono.getQ1()).append("\n");
        sb.append("    Mode1: ").append(eqModeToString(twoBandMono.getMode1())).append("\n");
        sb.append("    Gain2: ").append(signInt(twoBandMono.getGain2())).append("\n");
        sb.append("    Fc 2: ").append(twoBandMono.getFc2()).append("\n");
        sb.append("    Q 2: ").append(twoBandMono.getQ2()).append("\n");
        sb.append("    Mode2: ").append(eqModeToString(twoBandMono.getMode2())).append("\n");
        return sb.toString();
    }

}