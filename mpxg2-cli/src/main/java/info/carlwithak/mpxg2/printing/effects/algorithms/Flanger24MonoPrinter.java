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

import info.carlwithak.mpxg2.model.effects.algorithms.Flanger24Mono;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;
import info.carlwithak.mpxg2.printing.PrintException;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class Flanger24MonoPrinter implements Printer {

    @Override
    public String print(Object algorithm) throws PrintException {
        Flanger24Mono flanger24Mono = (Flanger24Mono) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(flanger24Mono.getMix()));
        sb.append(printParameter(flanger24Mono.getLevel()));
        sb.append(printParameter(flanger24Mono.getRate()));
        sb.append(printParameter(flanger24Mono.getPulseWidth()));
        sb.append(printParameter(flanger24Mono.getDepth()));
        sb.append(printParameter(flanger24Mono.getResonance()));
        sb.append(printParameter(flanger24Mono.getGlide()));
        sb.append(printParameter(flanger24Mono.getBlend()));
        return sb.toString();
    }

}
