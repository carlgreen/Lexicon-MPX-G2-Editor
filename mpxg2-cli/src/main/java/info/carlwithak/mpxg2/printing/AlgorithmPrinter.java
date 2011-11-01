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
import info.carlwithak.mpxg2.model.effects.algorithms.BlueComp;
import info.carlwithak.mpxg2.model.effects.algorithms.Centrifuge1;
import info.carlwithak.mpxg2.model.effects.algorithms.Chamber;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusAlgorithm;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusVolumeDual;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayMono;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.DetuneDual;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusDetuneMono;
import info.carlwithak.mpxg2.model.effects.algorithms.Distortion;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoMono;
import info.carlwithak.mpxg2.model.effects.algorithms.EqPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.FlangerStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.Hall;
import info.carlwithak.mpxg2.model.effects.algorithms.JamMan;
import info.carlwithak.mpxg2.model.effects.algorithms.OctaBuzz;
import info.carlwithak.mpxg2.model.effects.algorithms.OrangePhase;
import info.carlwithak.mpxg2.model.effects.algorithms.Overdrive;
import info.carlwithak.mpxg2.model.effects.algorithms.Panner;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah1;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah2;
import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import info.carlwithak.mpxg2.model.effects.algorithms.Preamp;
import info.carlwithak.mpxg2.model.effects.algorithms.RedComp;
import info.carlwithak.mpxg2.model.effects.algorithms.RotaryCab;
import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;
import info.carlwithak.mpxg2.model.effects.algorithms.ShiftDual;
import info.carlwithak.mpxg2.model.effects.algorithms.SweepFilter;
import info.carlwithak.mpxg2.model.effects.algorithms.Tone;
import info.carlwithak.mpxg2.model.effects.algorithms.TremoloMono;
import info.carlwithak.mpxg2.model.effects.algorithms.UniVybe;
import info.carlwithak.mpxg2.model.effects.algorithms.VolumeMono;
import info.carlwithak.mpxg2.model.effects.algorithms.Wah1;
import info.carlwithak.mpxg2.model.effects.algorithms.Wah2;
import info.carlwithak.mpxg2.printing.effects.algorithms.AmbiencePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.AutoPanPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.BlueCompPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.Centrifuge1Printer;
import info.carlwithak.mpxg2.printing.effects.algorithms.ChamberPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.ChorusPedalVolPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.ChorusPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.DelayDualPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.DelayMonoPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.DelayStereoPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.DetuneDualPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.DetuneMonoPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.DistortionPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.EchoDualPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.EchoMonoPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.EqPedalVolPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.FlangerStereoPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.HallPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.JamManPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.OctaBuzzPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.OrangePhasePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.OverdrivePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.PannerPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.PedalWah1Printer;
import info.carlwithak.mpxg2.printing.effects.algorithms.PedalWah2Printer;
import info.carlwithak.mpxg2.printing.effects.algorithms.PlatePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.PreampPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.RedCompPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.RotaryCabPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.ScreamerPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.ShiftDualPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.SweepFilterPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.TonePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.TremoloMonoPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.UniVybePrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.VolumeDualPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.VolumeMonoPrinter;
import info.carlwithak.mpxg2.printing.effects.algorithms.Wah1Printer;
import info.carlwithak.mpxg2.printing.effects.algorithms.Wah2Printer;
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
    private static final HashMap<Class, Printer> PRINTERS = new HashMap<Class, Printer>();
    static {
       PRINTERS.put(ShiftDual.class, new ShiftDualPrinter());
       PRINTERS.put(Panner.class, new PannerPrinter());
       PRINTERS.put(AutoPan.class, new AutoPanPrinter());
       PRINTERS.put(TremoloMono.class, new TremoloMonoPrinter());
       PRINTERS.put(UniVybe.class, new UniVybePrinter());
       PRINTERS.put(OrangePhase.class, new OrangePhasePrinter());
       PRINTERS.put(RedComp.class, new RedCompPrinter());
       PRINTERS.put(BlueComp.class, new BlueCompPrinter());
       PRINTERS.put(OctaBuzz.class, new OctaBuzzPrinter());
       PRINTERS.put(SweepFilter.class, new SweepFilterPrinter());
       PRINTERS.put(Wah1.class, new Wah1Printer());
       PRINTERS.put(Wah2.class, new Wah2Printer());
       PRINTERS.put(PedalWah1.class, new PedalWah1Printer());
       PRINTERS.put(PedalWah2.class, new PedalWah2Printer());
       PRINTERS.put(VolumeMono.class, new VolumeMonoPrinter());
       PRINTERS.put(ChorusAlgorithm.class, new ChorusPrinter());
       PRINTERS.put(ChorusDetuneMono.class, new DetuneMonoPrinter());
       PRINTERS.put(ChorusVolumeDual.class, new VolumeDualPrinter());
       PRINTERS.put(ChorusPedalVol.class, new ChorusPedalVolPrinter());
       PRINTERS.put(DetuneDual.class, new DetuneDualPrinter());
       PRINTERS.put(FlangerStereo.class, new FlangerStereoPrinter());
       PRINTERS.put(RotaryCab.class, new RotaryCabPrinter());
       PRINTERS.put(Centrifuge1.class, new Centrifuge1Printer());
       PRINTERS.put(DelayMono.class, new DelayMonoPrinter());
       PRINTERS.put(DelayStereo.class, new DelayStereoPrinter());
       PRINTERS.put(DelayDual.class, new DelayDualPrinter());
       PRINTERS.put(EchoMono.class, new EchoMonoPrinter());
       PRINTERS.put(EchoDual.class, new EchoDualPrinter());
       PRINTERS.put(JamMan.class, new JamManPrinter());
       PRINTERS.put(Chamber.class, new ChamberPrinter());
       PRINTERS.put(Hall.class, new HallPrinter());
       PRINTERS.put(Plate.class, new PlatePrinter());
       PRINTERS.put(Ambience.class, new AmbiencePrinter());
       PRINTERS.put(EqPedalVol.class, new EqPedalVolPrinter());
       PRINTERS.put(Tone.class, new TonePrinter());
       PRINTERS.put(Screamer.class, new ScreamerPrinter());
       PRINTERS.put(Overdrive.class, new OverdrivePrinter());
       PRINTERS.put(Distortion.class, new DistortionPrinter());
       PRINTERS.put(Preamp.class, new PreampPrinter());
    };

    static String print(Object algorithm) throws PrintException {
        if (!PRINTERS.containsKey(algorithm.getClass())) {
            throw new PrintException("No printer found for " + algorithm.getClass());
        }
        return PRINTERS.get(algorithm.getClass()).print(algorithm);
    }

}
