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

package info.carlwithak.mpxg2.printing;

import info.carlwithak.mpxg2.model.effects.algorithms.Ambience;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah1;
import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;
import info.carlwithak.mpxg2.model.effects.algorithms.UniVybe;
import info.carlwithak.mpxg2.printing.effects.algorithms.AmbiencePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.EchoDualPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.PedalVolPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.PedalWah1Printer;
import info.carlwithak.mpxg2.printing.effects.algorithms.ScreamerPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.UniVybePrinter;
import java.util.HashMap;

/**
 * Delegates the printing of an algorithm to a class designed for that
 * particular algorithm.
 *
 * @author Carl Green
 */
public class AlgorithmPrinter {

    /**
     * Printers for specific algorithms should implement this.
     */
    public interface Printer {
        String print(Object algorithm);
    }

    /**
     * Mapping between algorithms and their printers. Is there a better way?
     */
    private static final HashMap<Class, Printer> PRINTERS = new HashMap<Class, Printer>() {{
       put(UniVybe.class, new UniVybePrinter());
       put(PedalWah1.class, new PedalWah1Printer());
       put(PedalVol.class, new PedalVolPrinter());
       put(EchoDual.class, new EchoDualPrinter());
       put(Ambience.class, new AmbiencePrinter());
       put(Screamer.class, new ScreamerPrinter());
    }};

    static String print(Object algorithm) throws PrintException {
        if (!PRINTERS.containsKey(algorithm.getClass())) {
            throw new PrintException("No printer found for " + algorithm.getClass());
        }
        return PRINTERS.get(algorithm.getClass()).print(algorithm);
    }

}
