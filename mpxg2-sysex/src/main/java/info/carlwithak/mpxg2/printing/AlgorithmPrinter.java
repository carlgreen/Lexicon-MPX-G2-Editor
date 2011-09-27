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
import info.carlwithak.mpxg2.model.effects.algorithms.AutoPan;
import info.carlwithak.mpxg2.model.effects.algorithms.Chamber;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusAlgorithm;
import info.carlwithak.mpxg2.model.effects.algorithms.DetuneDual;
import info.carlwithak.mpxg2.model.effects.algorithms.DetuneMono;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.model.effects.algorithms.EqPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.Panner;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah1;
import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;
import info.carlwithak.mpxg2.model.effects.algorithms.ShiftDual;
import info.carlwithak.mpxg2.model.effects.algorithms.Tone;
import info.carlwithak.mpxg2.model.effects.algorithms.UniVybe;
import info.carlwithak.mpxg2.model.effects.algorithms.VolumeMono;
import info.carlwithak.mpxg2.model.effects.algorithms.Wah1;
import info.carlwithak.mpxg2.printing.effects.algorithms.AmbiencePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.AutoPanPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.ChamberPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.ChorusPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.DetuneDualPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.DetuneMonoPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.EchoDualPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.EqPedalVolPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.PannerPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.PedalVolPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.PedalWah1Printer;
import info.carlwithak.mpxg2.printing.effects.algorithms.PlatePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.ScreamerPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.ShiftDualPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.TonePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.UniVybePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.VolumeMonoPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.Wah1Printer;
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
        String print(Object algorithm) throws PrintException;
    }

    /**
     * Mapping between algorithms and their printers. Is there a better way?
     */
    private static final HashMap<Class, Printer> PRINTERS = new HashMap<Class, Printer>() {{
       put(ShiftDual.class, new ShiftDualPrinter());
       put(Panner.class, new PannerPrinter());
       put(AutoPan.class, new AutoPanPrinter());
       put(UniVybe.class, new UniVybePrinter());
       put(Wah1.class, new Wah1Printer());
       put(PedalWah1.class, new PedalWah1Printer());
       put(VolumeMono.class, new VolumeMonoPrinter());
       put(PedalVol.class, new PedalVolPrinter());
       put(ChorusAlgorithm.class, new ChorusPrinter());
       put(DetuneMono.class, new DetuneMonoPrinter());
       put(DetuneDual.class, new DetuneDualPrinter());
       put(EchoDual.class, new EchoDualPrinter());
       put(Chamber.class, new ChamberPrinter());
       put(Plate.class, new PlatePrinter());
       put(Ambience.class, new AmbiencePrinter());
       put(EqPedalVol.class, new EqPedalVolPrinter());
       put(Tone.class, new TonePrinter());
       put(Screamer.class, new ScreamerPrinter());
    }};

    static String print(Object algorithm) throws PrintException {
        if (!PRINTERS.containsKey(algorithm.getClass())) {
            throw new PrintException("No printer found for " + algorithm.getClass());
        }
        return PRINTERS.get(algorithm.getClass()).print(algorithm);
    }

}
