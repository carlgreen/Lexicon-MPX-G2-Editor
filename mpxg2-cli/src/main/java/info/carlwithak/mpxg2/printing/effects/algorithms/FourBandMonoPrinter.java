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
        sb.append(printParameter(fourBandMono.getGain1()));
        sb.append(printParameter(fourBandMono.getFc1()));
        sb.append(printParameter(fourBandMono.getQ1()));
        sb.append(printParameter(fourBandMono.getMode1()));
        sb.append(printParameter(fourBandMono.getGain2()));
        sb.append(printParameter(fourBandMono.getFc2()));
        sb.append(printParameter(fourBandMono.getQ2()));
        sb.append(printParameter(fourBandMono.getMode2()));
        sb.append(printParameter(fourBandMono.getGain3()));
        sb.append(printParameter(fourBandMono.getFc3()));
        sb.append(printParameter(fourBandMono.getQ3()));
        sb.append(printParameter(fourBandMono.getMode3()));
        sb.append(printParameter(fourBandMono.getGain4()));
        sb.append(printParameter(fourBandMono.getFc4()));
        sb.append(printParameter(fourBandMono.getQ4()));
        sb.append(printParameter(fourBandMono.getMode4()));
        return sb.toString();
    }

}
