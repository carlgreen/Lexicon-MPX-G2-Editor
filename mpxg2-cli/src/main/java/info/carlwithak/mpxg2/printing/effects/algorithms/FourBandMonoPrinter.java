/*
 *  Copyright (C) 2012 Carl Green
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

import info.carlwithak.mpxg2.model.effects.algorithms.FourBandMono;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class FourBandMonoPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        FourBandMono fourBandMono = (FourBandMono) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(fourBandMono.mix));
        sb.append(printParameter(fourBandMono.level));
        sb.append(printParameter(fourBandMono.gain1));
        sb.append(printParameter(fourBandMono.fc1));
        sb.append(printParameter(fourBandMono.q1));
        sb.append(printParameter(fourBandMono.mode1));
        sb.append(printParameter(fourBandMono.gain2));
        sb.append(printParameter(fourBandMono.fc2));
        sb.append(printParameter(fourBandMono.q2));
        sb.append(printParameter(fourBandMono.mode2));
        sb.append(printParameter(fourBandMono.gain3));
        sb.append(printParameter(fourBandMono.fc3));
        sb.append(printParameter(fourBandMono.q3));
        sb.append(printParameter(fourBandMono.mode3));
        sb.append(printParameter(fourBandMono.gain4));
        sb.append(printParameter(fourBandMono.fc4));
        sb.append(printParameter(fourBandMono.q4));
        sb.append(printParameter(fourBandMono.mode4));
        return sb.toString();
    }

}
