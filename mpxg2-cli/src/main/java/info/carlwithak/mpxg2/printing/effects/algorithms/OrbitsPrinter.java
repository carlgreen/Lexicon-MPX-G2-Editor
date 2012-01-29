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

import info.carlwithak.mpxg2.model.effects.algorithms.Orbits;
import info.carlwithak.mpxg2.printing.AlgorithmPrinter.Printer;

import static info.carlwithak.mpxg2.printing.Util.printParameter;

/**
 *
 * @author Carl Green
 */
public class OrbitsPrinter implements Printer {

    @Override
    public String print(Object algorithm) {
        Orbits orbits = (Orbits) algorithm;
        StringBuilder sb = new StringBuilder();
        sb.append(printParameter(orbits.mix));
        sb.append(printParameter(orbits.level));
        sb.append(printParameter(orbits.getRate1()));
        sb.append(printParameter(orbits.pulseWidth1));
        sb.append(printParameter(orbits.sync1));
        sb.append(printParameter(orbits.depth1));
        sb.append(printParameter(orbits.getRate2()));
        sb.append(printParameter(orbits.pulseWidth2));
        sb.append(printParameter(orbits.sync2));
        sb.append(printParameter(orbits.depth2));
        sb.append(printParameter(orbits.resonance));
        sb.append(printParameter(orbits.width));
        return sb.toString();
    }

}
