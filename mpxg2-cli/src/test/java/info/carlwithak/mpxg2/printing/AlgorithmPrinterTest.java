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

import info.carlwithak.mpxg2.model.effects.algorithms.Aerosol;
import info.carlwithak.mpxg2.model.effects.algorithms.Ambience;
import info.carlwithak.mpxg2.model.effects.algorithms.AutoPan;
import info.carlwithak.mpxg2.model.effects.algorithms.BlueComp;
import info.carlwithak.mpxg2.model.effects.algorithms.Centrifuge1;
import info.carlwithak.mpxg2.model.effects.algorithms.Chamber;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusAlgorithm;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusDetuneMono;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusVolumeDual;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusVolumeMono;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusVolumeStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.Crossover;
import info.carlwithak.mpxg2.model.effects.algorithms.Crunch;
import info.carlwithak.mpxg2.model.effects.algorithms.CustomVybe;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayMono;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.DetuneDual;
import info.carlwithak.mpxg2.model.effects.algorithms.DiatonicHmy;
import info.carlwithak.mpxg2.model.effects.algorithms.Distortion;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoMono;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.EqPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.EqVolumeDual;
import info.carlwithak.mpxg2.model.effects.algorithms.EqVolumeMono;
import info.carlwithak.mpxg2.model.effects.algorithms.EqVolumeStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.Flanger24Mono;
import info.carlwithak.mpxg2.model.effects.algorithms.FlangerMono;
import info.carlwithak.mpxg2.model.effects.algorithms.FlangerStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.FourBandMono;
import info.carlwithak.mpxg2.model.effects.algorithms.Hall;
import info.carlwithak.mpxg2.model.effects.algorithms.JamMan;
import info.carlwithak.mpxg2.model.effects.algorithms.OctaBuzz;
import info.carlwithak.mpxg2.model.effects.algorithms.OneBandMono;
import info.carlwithak.mpxg2.model.effects.algorithms.OrangePhase;
import info.carlwithak.mpxg2.model.effects.algorithms.Overdrive;
import info.carlwithak.mpxg2.model.effects.algorithms.Panner;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah1;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah2;
import info.carlwithak.mpxg2.model.effects.algorithms.Phaser;
import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import info.carlwithak.mpxg2.model.effects.algorithms.Preamp;
import info.carlwithak.mpxg2.model.effects.algorithms.RedComp;
import info.carlwithak.mpxg2.model.effects.algorithms.RotaryCab;
import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;
import info.carlwithak.mpxg2.model.effects.algorithms.ShiftDual;
import info.carlwithak.mpxg2.model.effects.algorithms.ShiftMono;
import info.carlwithak.mpxg2.model.effects.algorithms.SweepFilter;
import info.carlwithak.mpxg2.model.effects.algorithms.Tone;
import info.carlwithak.mpxg2.model.effects.algorithms.TremoloMono;
import info.carlwithak.mpxg2.model.effects.algorithms.TremoloStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.TwoBandDual;
import info.carlwithak.mpxg2.model.effects.algorithms.TwoBandMono;
import info.carlwithak.mpxg2.model.effects.algorithms.TwoBandStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.UniVybe;
import info.carlwithak.mpxg2.model.effects.algorithms.VolumeDual;
import info.carlwithak.mpxg2.model.effects.algorithms.VolumeMono;
import info.carlwithak.mpxg2.model.effects.algorithms.VolumeStereo;
import info.carlwithak.mpxg2.model.effects.algorithms.Wah1;
import info.carlwithak.mpxg2.model.effects.algorithms.Wah2;
import info.carlwithak.mpxg2.model.parameters.BeatRate;
import info.carlwithak.mpxg2.model.parameters.FrequencyRate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests AlgorithmPrinter and all the implementation of AlgorithmPrinter.Printer.
 *
 * @author Carl Green
 */
public class AlgorithmPrinterTest {

    @Test(expected=PrintException.class)
    public void testPrintInvalidAlgorithm() throws PrintException {
        String notAnAlgorithm = "Not an algorithm";
        AlgorithmPrinter.print(notAnAlgorithm);
    }

    @Test
    public void testPrintShiftMono() throws PrintException {
        ShiftMono shiftMono = new ShiftMono();
        shiftMono.mix.setValue(100);
        shiftMono.level.setValue(-90);
        shiftMono.tune.setValue(-1200);
        shiftMono.optimize.setValue(50);
        shiftMono.glide.setValue(true);

        // TODO level should be 'Off'
        String expected = "    Mix: 100%\n    Level: -90dB\n    Tune: -1200\n    Optimize: 50\n    Glide: On\n";
        String actual = AlgorithmPrinter.print(shiftMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintShiftDual() throws PrintException {
        ShiftDual shiftDual = new ShiftDual();
        shiftDual.mix.setValue(100);
        shiftDual.level.setValue(6);
        shiftDual.tune1.setValue(-1200);
        shiftDual.optimize.setValue(10);
        shiftDual.tune2.setValue(-500);
        shiftDual.glide.setValue(true);

        String expected = "    Mix: 100%\n    Level: +6dB\n    Tune1: -1200\n    Optimize: 10\n    Tune2: -500\n    Glide: On\n";
        String actual = AlgorithmPrinter.print(shiftDual);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintDiatonicHmy() throws PrintException {
        DiatonicHmy diatonicHmy = new DiatonicHmy();
        diatonicHmy.mix.setValue(100);
        diatonicHmy.level.setValue(0);
        diatonicHmy.key.setValue(4);
        diatonicHmy.scale.setValue(0);
        diatonicHmy.interval.setValue(16);
        diatonicHmy.optimize.setValue(10);
        diatonicHmy.threshold.setValue(-83);
        diatonicHmy.source.setValue(1);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Key: E\n    Scale: Major\n    Int: +3rd\n    Optimize: 10\n    Thrsh: -83dB\n    Src: Guitar Input\n";
        String actual = AlgorithmPrinter.print(diatonicHmy);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPanner() throws PrintException {
        Panner panner = new Panner();
        panner.mix.setValue(100);
        panner.level.setValue(-24);
        panner.pan1.setValue(-50);
        panner.pan2.setValue(50);

        String expected = "    Mix: 100%\n    Level: -24dB\n    Pan 1: 50L\n    Pan 2: 50R\n";
        String actual = AlgorithmPrinter.print(panner);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAutoPan() throws PrintException {
        AutoPan autoPan = new AutoPan();
        autoPan.mix.setValue(100);
        autoPan.level.setValue(0);
        autoPan.setRate(new FrequencyRate("Rate", 1.0));
        autoPan.pulseWidth.setValue(50);
        autoPan.depth.setValue(100);
        autoPan.phase.setValue(3);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Rate: 1.00Hz\n    PW: 50%\n    Depth: 100%\n    Phase: 270°\n";
        String actual = AlgorithmPrinter.print(autoPan);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintTremoloMono() throws PrintException {
        TremoloMono tremoloMono = new TremoloMono();
        tremoloMono.mix.setValue(100);
        tremoloMono.level.setValue(6);
        tremoloMono.setRate(new BeatRate("Rate", 7, 4));
        tremoloMono.pulseWidth.setValue(30);
        tremoloMono.depth.setValue(100);

        String expected = "    Mix: 100%\n    Level: +6dB\n    Rate: 7:4\n    PW: 30%\n    Depth: 100%\n";
        String actual = AlgorithmPrinter.print(tremoloMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintTremoloStereo() throws PrintException {
        TremoloStereo tremoloStereo = new TremoloStereo();
        tremoloStereo.mix.setValue(100);
        tremoloStereo.level.setValue(0);
        tremoloStereo.setRate(new FrequencyRate("Rate", 3.0));
        tremoloStereo.pulseWidth.setValue(50);
        tremoloStereo.depth.setValue(100);
        tremoloStereo.phase.setValue(3);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Rate: 3.00Hz\n    PW: 50%\n    Depth: 100%\n    Phase: 270°\n";
        String actual = AlgorithmPrinter.print(tremoloStereo);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintUniVybe() throws PrintException {
        UniVybe univybe = new UniVybe();
        univybe.mix.setValue(100);
        univybe.level.setValue(0);
        univybe.rate.setValue(20);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Rate: 20\n";
        String actual = AlgorithmPrinter.print(univybe);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintCustomVybe() throws PrintException {
        CustomVybe customVybe = new CustomVybe();
        customVybe.mix.setValue(100);
        customVybe.level.setValue(0);
        customVybe.setRate(new FrequencyRate("Rate", 0.97));
        customVybe.pulseWidth.setValue(46);
        customVybe.depth.setValue(45);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Rate: 0.97Hz\n    PW: 46%\n    Depth: 45%\n";
        String actual = AlgorithmPrinter.print(customVybe);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPhaser() throws PrintException {
        Phaser phaser = new Phaser();
        phaser.mix.setValue(100);
        phaser.level.setValue(0);
        phaser.setRate(new FrequencyRate("Rate", 0.83));
        phaser.pulseWidth.setValue(50);
        phaser.depth.setValue(100);
        phaser.resonance.setValue(30);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Rate: 0.83Hz\n    PW: 50%\n    Depth: 100%\n    Res: +30%\n";
        String actual = AlgorithmPrinter.print(phaser);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintRedComp() throws PrintException {
        RedComp redComp = new RedComp();
        redComp.mix.setValue(100);
        redComp.level.setValue(6);
        redComp.sensitivity.setValue(70);

        String expected = "    Mix: 100%\n    Level: +6dB\n    Sense: 70\n";
        String actual = AlgorithmPrinter.print(redComp);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintBlueComp() throws PrintException {
        BlueComp blueComp = new BlueComp();
        blueComp.mix.setValue(100);
        blueComp.level.setValue(6);
        blueComp.sensitivity.setValue(5);
        blueComp.threshold.setValue(-28);
        blueComp.gain.setValue(5);
        blueComp.attackTime.setValue(20);
        blueComp.releaseTime.setValue(100);

        String expected = "    Mix: 100%\n    Level: +6dB\n    Sense: +5dB\n    Thrsh: -28dB\n    Gain: +5dB\n    ATime: 20ms\n    RTime: 100ms\n";
        String actual = AlgorithmPrinter.print(blueComp);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintOrangePhase() throws PrintException {
        OrangePhase orangePhase = new OrangePhase();
        orangePhase.mix.setValue(100);
        orangePhase.level.setValue(0);
        orangePhase.rate.setValue(20);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Rate: 20\n";
        String actual = AlgorithmPrinter.print(orangePhase);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintOctaBuzz() throws PrintException {
        OctaBuzz octaBuzz = new OctaBuzz();
        octaBuzz.mix.setValue(100);
        octaBuzz.level.setValue(3);

        String expected = "    Mix: 100%\n    Level: +3dB\n";
        String actual = AlgorithmPrinter.print(octaBuzz);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintSweepFilter() throws PrintException {
        SweepFilter sweepFilter = new SweepFilter();
        sweepFilter.mix.setValue(100);
        sweepFilter.level.setValue(6);
        sweepFilter.fc.setValue(88);
        sweepFilter.fRes.setValue(34);
        sweepFilter.mod.setValue(2120);
        sweepFilter.scale.setValue(50);
        sweepFilter.pan.setValue(0);

        String expected = "    Mix: 100%\n    Level: +6dB\n    Fc: 88Hz\n    FRes: 34\n    Mod: 2120Hz\n    Scale: +50%\n    Pan: C\n";
        String actual = AlgorithmPrinter.print(sweepFilter);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintWah1() throws PrintException {
        Wah1 wah1 = new Wah1();
        wah1.mix.setValue(100);
        wah1.level.setValue(0);
        wah1.sweep.setValue(50);
        wah1.bass.setValue(19);
        wah1.type.setValue(0);
        wah1.response.setValue(100);
        wah1.gain.setValue(10);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Sweep: 50\n    Bass: 19\n    Type: Model C\n    Resp: 100\n    Gain: +10dB\n";
        String actual = AlgorithmPrinter.print(wah1);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintWah2() throws PrintException {
        Wah2 wah2 = new Wah2();
        wah2.mix.setValue(100);
        wah2.level.setValue(6);
        wah2.sweep.setValue(50);
        wah2.bass.setValue(0);
        wah2.type.setValue(0);
        wah2.response.setValue(100);
        wah2.gain.setValue(10);

        String expected = "    Mix: 100%\n    Level: +6dB\n    Sweep: 50\n    Bass: 0\n    Type: Model C\n    Resp: 100\n    Gain: +10dB\n";
        String actual = AlgorithmPrinter.print(wah2);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPedalWah1() throws PrintException {
        PedalWah1 pedalWah1 = new PedalWah1();
        pedalWah1.mix.setValue(100);
        pedalWah1.level.setValue(0);
        pedalWah1.bass.setValue(19);
        pedalWah1.type.setValue(0);
        pedalWah1.response.setValue(100);
        pedalWah1.gain.setValue(10);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Bass: 19\n    Type: Model C\n    Resp: 100\n    Gain: +10dB\n";
        String actual = AlgorithmPrinter.print(pedalWah1);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPedalWah2() throws PrintException {
        PedalWah2 pedalWah2 = new PedalWah2();
        pedalWah2.mix.setValue(100);
        pedalWah2.level.setValue(0);
        pedalWah2.bass.setValue(10);
        pedalWah2.type.setValue(0);
        pedalWah2.response.setValue(100);
        pedalWah2.gain.setValue(6);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Bass: 10\n    Type: Model C\n    Resp: 100\n    Gain: +6dB\n";
        String actual = AlgorithmPrinter.print(pedalWah2);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintVolumeMono() throws PrintException {
        VolumeMono volumeMono = new VolumeMono();
        volumeMono.mix.setValue(100);
        volumeMono.level.setValue(0);
        volumeMono.volume.setValue(60);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Volume: 60%\n";
        String actual = AlgorithmPrinter.print(volumeMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintVolumeStereo() throws PrintException {
        VolumeStereo volumeStereo = new VolumeStereo();
        volumeStereo.mix.setValue(100);
        volumeStereo.level.setValue(0);
        volumeStereo.volume.setValue(0);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Volume: 0%\n";
        String actual = AlgorithmPrinter.print(volumeStereo);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintVolumeDual() throws PrintException {
        VolumeDual volumeDual = new VolumeDual();
        volumeDual.mix.setValue(100);
        volumeDual.level.setValue(0);
        volumeDual.volumeLeft.setValue(100);
        volumeDual.volumeRight.setValue(100);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Vol-L: 100%\n    Vol-R: 100%\n";
        String actual = AlgorithmPrinter.print(volumeDual);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPedalVol() throws PrintException {
        PedalVol pedalVol = new PedalVol();
        pedalVol.mix.setValue(100);
        pedalVol.level.setValue(0);

        String expected = "    Mix: 100%\n    Level: 0dB\n";
        String actual = AlgorithmPrinter.print(pedalVol);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintChorus() throws PrintException {
        ChorusAlgorithm chorus = new ChorusAlgorithm();
        chorus.mix.setValue(100);
        chorus.level.setValue(0);
        chorus.setRate1(new FrequencyRate("Rate1", 0.62));
        chorus.pulseWidth1.setValue(45);
        chorus.depth1.setValue(30);
        chorus.setRate2(new FrequencyRate("Rate2", 0.56));
        chorus.pulseWidth2.setValue(54);
        chorus.depth2.setValue(0);
        chorus.resonance1.setValue(-19);
        chorus.resonance2.setValue(0);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Rate1: 0.62Hz\n    PW 1: 45%\n    Dpth1: 30%\n    Rate2: 0.56Hz\n    PW 2: 54%\n    Dpth2: 0%\n    Res 1: -19\n    Res 2: 0\n";
        String actual = AlgorithmPrinter.print(chorus);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintChorusDetuneMono() throws PrintException {
        ChorusDetuneMono detuneMono = new ChorusDetuneMono();
        detuneMono.mix.setValue(100);
        detuneMono.level.setValue(3);
        detuneMono.tune.setValue(7);
        detuneMono.optimize.setValue(10);
        detuneMono.preDelay.setValue(22);

        String expected = "    Mix: 100%\n    Level: +3dB\n    Tune: 7\n    Optimize: 10ms\n    P Dly: 22ms\n";
        String actual = AlgorithmPrinter.print(detuneMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintDetuneDual() throws PrintException {
        DetuneDual detuneDual = new DetuneDual();
        detuneDual.mix.setValue(100);
        detuneDual.level.setValue(3);
        detuneDual.tune1.setValue(7);
        detuneDual.optimize.setValue(10);
        detuneDual.tune2.setValue(5);
        detuneDual.preDelay.setValue(22);

        String expected = "    Mix: 100%\n    Level: +3dB\n    Tune1: 7\n    Optimize: 10ms\n    Tune2: 5\n    P Dly: 22ms\n";
        String actual = AlgorithmPrinter.print(detuneDual);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintFlangerMono() throws PrintException {
        FlangerMono flangerMono = new FlangerMono();
        flangerMono.mix.setValue(100);
        flangerMono.level.setValue(0);
        flangerMono.setRate(new FrequencyRate("Rate", 0.05));
        flangerMono.pulseWidth.setValue(20);
        flangerMono.depth.setValue(30);
        flangerMono.resonance.setValue(-60);
        flangerMono.blend.setValue(30);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Rate: 0.05Hz\n    PW: 20%\n    Depth: 30%\n    Res: -60%\n    Blend: 30%\n";
        String actual = AlgorithmPrinter.print(flangerMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintFlanger24Mono() throws PrintException {
        Flanger24Mono flanger24Mono = new Flanger24Mono();
        flanger24Mono.mix.setValue(100);
        flanger24Mono.level.setValue(0);
        flanger24Mono.setRate(new FrequencyRate("Rate", 0.31));
        flanger24Mono.pulseWidth.setValue(50);
        flanger24Mono.depth.setValue(36);
        flanger24Mono.resonance.setValue(-30);
        flanger24Mono.glide.setValue(50);
        flanger24Mono.blend.setValue(50);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Rate: 0.31Hz\n    PW: 50%\n    Depth: 36%\n    Res: -30%\n    Glide: 50\n    Blend: 50%\n";
        String actual = AlgorithmPrinter.print(flanger24Mono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintFlangerStereo() throws PrintException {
        FlangerStereo flangerStereo = new FlangerStereo();
        flangerStereo.mix.setValue(67);
        flangerStereo.level.setValue(1);
        flangerStereo.setRate(new BeatRate("Rate", 1, 4));
        flangerStereo.pulseWidth.setValue(50);
        flangerStereo.depth.setValue(62);
        flangerStereo.phase.setValue(1);
        flangerStereo.resonance.setValue(20);
        flangerStereo.blend.setValue(0);

        String expected = "    Mix: 67%\n    Level: +1dB\n    Rate: 1:4\n    PW: 50%\n    Depth: 62%\n    Phase: 90°\n    Res: +20%\n    Blend: 0%\n";
        String actual = AlgorithmPrinter.print(flangerStereo);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintRotaryCab() throws PrintException {
        RotaryCab rotaryCab = new RotaryCab();
        rotaryCab.mix.setValue(100);
        rotaryCab.level.setValue(4);
        rotaryCab.setRate1(new FrequencyRate("Rate1", 5.73));
        rotaryCab.depth1.setValue(43);
        rotaryCab.setRate2(new FrequencyRate("Rate2", 5.73));
        rotaryCab.depth2.setValue(36);
        rotaryCab.resonance.setValue(0);
        rotaryCab.width.setValue(100);
        rotaryCab.balance.setValue(-20);

        String expected = "    Mix: 100%\n    Level: +4dB\n    Rate1: 5.73Hz\n    Dpth1: 43%\n    Rate2: 5.73Hz\n    Dpth2: 36%\n    Res: 0\n    Width: 100%\n    Bal: -20\n";
        String actual = AlgorithmPrinter.print(rotaryCab);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAerosol() throws PrintException {
        Aerosol aerosol = new Aerosol();
        aerosol.mix.setValue(100);
        aerosol.level.setValue(0);
        aerosol.setRate1(new FrequencyRate("Rate1", 0.26));
        aerosol.pulseWidth1.setValue(45);
        aerosol.depth1.setValue(70);
        aerosol.setRate2(new FrequencyRate("Rate2", 0.26));
        aerosol.pulseWidth2.setValue(55);
        aerosol.depth2.setValue(60);
        aerosol.resonance1.setValue(-60);
        aerosol.resonance2.setValue(60);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Rate1: 0.26Hz\n    PW 1: 45%\n    Dpth1: 70%\n    Rate2: 0.26Hz\n    PW 2: 55%\n    Dpth2: 60%\n    Res 1: -60\n    Res 2: +60\n";
        String actual = AlgorithmPrinter.print(aerosol);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintCentrifuge1() throws PrintException {
        Centrifuge1 centrifuge1 = new Centrifuge1();
        centrifuge1.mix.setValue(100);
        centrifuge1.level.setValue(6);
        centrifuge1.setRate1(new FrequencyRate("Rate1", 0.6));
        centrifuge1.pulseWidth1.setValue(45);
        centrifuge1.sync1.setValue(120);
        centrifuge1.depth1.setValue(100);
        centrifuge1.setRate2(new FrequencyRate("Rate2", 1.0));
        centrifuge1.pulseWidth2.setValue(100);
        centrifuge1.sync2.setValue(-120);
        centrifuge1.depth2.setValue(43);
        centrifuge1.resonance.setValue(100);

        String expected = "    Mix: 100%\n    Level: +6dB\n    Rate1: 0.60Hz\n    PW 1: 45%\n    Sync1: +120\n    Dpth1: 100%\n    Rate2: 1.00Hz\n    PW 2: 100%\n    Sync2: -120\n    Dpth2: 43%\n    Res: +100%\n";
        String actual = AlgorithmPrinter.print(centrifuge1);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintChorusVolumeMono() throws PrintException {
        ChorusVolumeMono volumeMono = new ChorusVolumeMono();
        volumeMono.mix.setValue(100);
        volumeMono.level.setValue(0);
        volumeMono.volume.setValue(100);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Volume: 100%\n";
        String actual = AlgorithmPrinter.print(volumeMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintChorusVolumeStereo() throws PrintException {
        ChorusVolumeStereo volumeStereo = new ChorusVolumeStereo();
        volumeStereo.mix.setValue(100);
        volumeStereo.level.setValue(0);
        volumeStereo.volume.setValue(0);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Volume: 0%\n";
        String actual = AlgorithmPrinter.print(volumeStereo);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintChorusVolumeDual() throws PrintException {
        ChorusVolumeDual volumeDual = new ChorusVolumeDual();
        volumeDual.mix.setValue(100);
        volumeDual.level.setValue(0);
        volumeDual.volumeLeft.setValue(80);
        volumeDual.volumeRight.setValue(90);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Vol-L: 80%\n    Vol-R: 90%\n";
        String actual = AlgorithmPrinter.print(volumeDual);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintChorusPedalVol() throws PrintException {
        ChorusPedalVol pedalVol = new ChorusPedalVol();
        pedalVol.mix.setValue(100);
        pedalVol.level.setValue(0);

        String expected = "    Mix: 100%\n    Level: 0dB\n";
        String actual = AlgorithmPrinter.print(pedalVol);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintDelayMono() throws PrintException {
        DelayMono delayMono = new DelayMono();
        delayMono.mix.setValue(10);
        delayMono.level.setValue(0);
        delayMono.setTime(new BeatRate("Time", 4, 3));
        delayMono.feedback.setValue(10);
        delayMono.insert.setValue(3);
        delayMono.clear.setValue(false);

        String expected = "    Mix: 10%\n    Level: 0dB\n    Time: 4:3\n    Fbk: +10%\n    Fbk insert: Delay\n    Clear: Off\n";
        String actual = AlgorithmPrinter.print(delayMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintDelayStereo() throws PrintException {
        DelayStereo delayStereo = new DelayStereo();
        delayStereo.mix.setValue(20);
        delayStereo.level.setValue(0);
        delayStereo.setTime(new BeatRate("Time", 2, 4));
        delayStereo.feedback.setValue(20);
        delayStereo.insert.setValue(3);
        delayStereo.clear.setValue(false);

        String expected = "    Mix: 20%\n    Level: 0dB\n    Time: 2:4\n    Fbk: +20%\n    Fbk insert: Delay\n    Clear: Off\n";
        String actual = AlgorithmPrinter.print(delayStereo);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintDelayDual() throws PrintException {
        DelayDual delayDual = new DelayDual();
        delayDual.mix.setValue(25);
        delayDual.level.setValue(0);
        delayDual.setTime1(new BeatRate("Time1", 3, 4));
        delayDual.setTime2(new BeatRate("Time2", 4, 3));
        delayDual.level1.setValue(0);
        delayDual.level2.setValue(0);
        delayDual.pan1.setValue(-50);
        delayDual.pan2.setValue(50);
        delayDual.feedback1.setValue(10);
        delayDual.insert.setValue(3);
        delayDual.feedback2.setValue(10);
        delayDual.xFbk1.setValue(0);
        delayDual.xFbk2.setValue(0);
        delayDual.clear.setValue(false);

        String expected = "    Mix: 25%\n    Level: 0dB\n    Time1: 3:4\n    Time2: 4:3\n    Lvl 1: 0dB\n    Lvl 2: 0dB\n    Pan 1: 50L\n    Pan 2: 50R\n    Fbk 1: +10%\n    Fbk insert: Delay\n    Fbk 2: +10%\n    XFbk1: 0%\n    XFbk2: 0%\n    Clear: Off\n";
        String actual = AlgorithmPrinter.print(delayDual);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintEchoMono() throws PrintException {
        EchoMono echoMono = new EchoMono();
        echoMono.mix.setValue(6);
        echoMono.level.setValue(1);
        echoMono.setTime(new BeatRate("Time", 4, 4));
        echoMono.feedback.setValue(-15);
        echoMono.insert.setValue(3);
        echoMono.damp.setValue(20);
        echoMono.clear.setValue(false);

        String expected = "    Mix: 6%\n    Level: +1dB\n    Time: 4:4\n    Fbk: -15%\n    Fbk insert: Delay\n    Damp: 20%\n    Clear: Off\n";
        String actual = AlgorithmPrinter.print(echoMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintEchoStereo() throws PrintException {
        EchoStereo echoStereo = new EchoStereo();
        echoStereo.mix.setValue(0);
        echoStereo.level.setValue(0);
        echoStereo.setTime(new BeatRate("Time", 1, 1));
        echoStereo.feedback.setValue(0);
        echoStereo.insert.setValue(3);
        echoStereo.damp.setValue(16);
        echoStereo.clear.setValue(false);

        String expected = "    Mix: 0%\n    Level: 0dB\n    Time: 1:1\n    Fbk: 0%\n    Fbk insert: Delay\n    Damp: 16%\n    Clear: Off\n";
        String actual = AlgorithmPrinter.print(echoStereo);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintEchoDual() throws PrintException {
        EchoDual echoDual = new EchoDual();
        echoDual.mix.setValue(2);
        echoDual.level.setValue(1);
        echoDual.setTime1(new BeatRate("Time1", 4, 4));
        echoDual.setTime2(new BeatRate("Time2", 2, 1));
        echoDual.level1.setValue(0);
        echoDual.level2.setValue(0);
        echoDual.feedback1.setValue(1);
        echoDual.insert.setValue(3);
        echoDual.feedback2.setValue(1);
        echoDual.damp1.setValue(20);
        echoDual.damp2.setValue(20);
        echoDual.clear.setValue(false);

        String expected = "    Mix: 2%\n    Level: +1dB\n    Time1: 4:4\n    Time2: 2:1\n    Lvl 1: 0dB\n    Lvl 2: 0dB\n    Fbk 1: +1%\n    Fbk insert: Delay\n    Fbk 2: +1%\n    Damp1: 20%\n    Damp2: 20%\n    Clear: Off\n";
        String actual = AlgorithmPrinter.print(echoDual);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintJamMan() throws PrintException {
        JamMan jamMan = new JamMan();
        jamMan.mix.setValue(100);
        jamMan.level.setValue(0);
        jamMan.size.setValue(250);
        jamMan.feedback.setValue(0);
        jamMan.insert.setValue(3);
        jamMan.clear.setValue(false);
        jamMan.layer.setValue(false);
        jamMan.replace.setValue(false);
        jamMan.delay.setValue(false);
        jamMan.mute.setValue(false);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Size: 250ms\n    Fbk: 0%\n    Fbk insert: Delay\n    Clear: Off\n    Layer: Off\n    Replc: Off\n    Delay: Off\n    MuteS: Off\n";
        String actual = AlgorithmPrinter.print(jamMan);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintChamber() throws PrintException {
        Chamber chamber = new Chamber();
        chamber.mix.setValue(28);
        chamber.level.setValue(0);
        chamber.size.setValue(24.0);
        chamber.link.setValue(true);
        chamber.diff.setValue(22);
        chamber.preDelay.setValue(0);
        chamber.bass.setValue(6);
        chamber.decay.setValue(47);
        chamber.xovr.setValue(16);
        chamber.rtHC.setValue(34);
        chamber.shape.setValue(62);
        chamber.spred.setValue(120);

        String expected = "    Mix: 28%\n    Level: 0dB\n    Size: 24.0m\n    Link: On\n    Diff: 22%\n    P Dly: 0ms\n    Bass: 1.5X\n    Decay: 1.05s\n    Xovr: 986Hz\n    Rt HC: 9.3kHz\n    Shape: 62\n    Spred: 42\n";
        String actual = AlgorithmPrinter.print(chamber);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintHall() throws PrintException {
        Hall hall = new Hall();
        hall.mix.setValue(20);
        hall.level.setValue(0);
        hall.size.setValue(53.0);
        hall.link.setValue(true);
        hall.diff.setValue(80);
        hall.preDelay.setValue(25);
        hall.bass.setValue(5);
        hall.decay.setValue(41);
        hall.xovr.setValue(15);
        hall.rtHC.setValue(31);
        hall.shape.setValue(110);
        hall.spred.setValue(125);

        String expected = "    Mix: 20%\n    Level: 0dB\n    Size: 53.0m\n    Link: On\n    Diff: 80%\n    P Dly: 25ms\n    Bass: 1.2X\n    Decay: 1.67s\n    Xovr: 818Hz\n    Rt HC: 7.9kHz\n    Shape: 110\n    Spred: 89\n";
        String actual = AlgorithmPrinter.print(hall);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPlate() throws PrintException {
        Plate plate = new Plate();
        plate.mix.setValue(100);
        plate.level.setValue(6);
        plate.size.setValue(22.5);
        plate.link.setValue(true);
        plate.diff.setValue(66);
        plate.preDelay.setValue(169);
        plate.bass.setValue(5);
        plate.decay.setValue(50);
        plate.xovr.setValue(16);
        plate.rtHC.setValue(45);
        plate.shape.setValue(36);
        plate.spred.setValue(222);

        String expected = "    Mix: 100%\n    Level: +6dB\n    Size: 22.5m\n    Link: On\n    Diff: 66%\n    P Dly: 169ms\n    Bass: 1.2X\n    Decay: 1.30s\n    Xovr: 986Hz\n    Rt HC: 19.4kHz\n    Shape: 36\n    Spred: 73\n";
        String actual = AlgorithmPrinter.print(plate);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAmbience() throws PrintException {
        Ambience ambience = new Ambience();
        ambience.mix.setValue(18);
        ambience.level.setValue(0);
        ambience.size.setValue(24.5);
        ambience.link.setValue(true);
        ambience.diff.setValue(60);
        ambience.preDelay.setValue(7);
        ambience.decayTime.setValue(51);
        ambience.decayLevel.setValue(0);
        ambience.rtHC.setValue(12);

        String expected = "    Mix: 18%\n    Level: 0dB\n    Size: 24.5m\n    Link: On\n    Diff: 60%\n    P Dly: 7ms\n    DTime: 1.41s\n    D Lvl: Off\n    Rt HC: 12.8kHz\n";
        String actual = AlgorithmPrinter.print(ambience);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintOneBandMono() throws PrintException {
        OneBandMono oneBandMono = new OneBandMono();
        oneBandMono.mix.setValue(100);
        oneBandMono.level.setValue(0);
        oneBandMono.gain.setValue(9);
        oneBandMono.fc.setValue(393);
        oneBandMono.q.setValue(0.1);
        oneBandMono.mode.setValue(0);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Gain: +9dB\n    Fc: 393Hz\n    Q: 0.1\n    Mode: LShlf\n";
        String actual = AlgorithmPrinter.print(oneBandMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintTwoBandMono() throws PrintException {
        TwoBandMono twoBandMono = new TwoBandMono();
        twoBandMono.mix.setValue(100);
        twoBandMono.level.setValue(0);
        twoBandMono.gain1.setValue(-5);
        twoBandMono.fc1.setValue(200);
        twoBandMono.q1.setValue(0.7);
        twoBandMono.mode1.setValue(0);
        twoBandMono.gain2.setValue(-7);
        twoBandMono.fc2.setValue(5000);
        twoBandMono.q2.setValue(0.7);
        twoBandMono.mode2.setValue(2);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Gain1: -5dB\n    Fc 1: 200Hz\n    Q 1: 0.7\n    Mode1: LShlf\n    Gain2: -7dB\n    Fc 2: 5000Hz\n    Q 2: 0.7\n    Mode2: HShlf\n";
        String actual = AlgorithmPrinter.print(twoBandMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintFourBandMono() throws PrintException {
        FourBandMono fourBandMono = new FourBandMono();
        fourBandMono.mix.setValue(100);
        fourBandMono.level.setValue(0);
        fourBandMono.gain1.setValue(-72);
        fourBandMono.fc1.setValue(820);
        fourBandMono.q1.setValue(0.7);
        fourBandMono.mode1.setValue(0);
        fourBandMono.gain2.setValue(6);
        fourBandMono.fc2.setValue(1200);
        fourBandMono.q2.setValue(2.5);
        fourBandMono.mode2.setValue(0);
        fourBandMono.gain3.setValue(10);
        fourBandMono.fc3.setValue(1700);
        fourBandMono.q3.setValue(1.5);
        fourBandMono.mode3.setValue(1);
        fourBandMono.gain4.setValue(-72);
        fourBandMono.fc4.setValue(3800);
        fourBandMono.q4.setValue(0.7);
        fourBandMono.mode4.setValue(2);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Gain1: -72dB\n    Fc 1: 820Hz\n    Q 1: 0.7\n    Mode1: LShlf\n    Gain2: +6dB\n    Fc 2: 1200Hz\n    Q 2: 2.5\n    Mode2: LShlf\n    Gain3: +10dB\n    Fc 3: 1700Hz\n    Q 3: 1.5\n    Mode3: Band\n    Gain4: -72dB\n    Fc 4: 3800Hz\n    Q 4: 0.7\n    Mode4: HShlf\n";
        String actual = AlgorithmPrinter.print(fourBandMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintTwoBandStereo() throws PrintException {
        TwoBandStereo twoBandStereo = new TwoBandStereo();
        twoBandStereo.mix.setValue(100);
        twoBandStereo.level.setValue(-2);
        twoBandStereo.gain1.setValue(5);
        twoBandStereo.fc1.setValue(5050);
        twoBandStereo.q1.setValue(0.1);
        twoBandStereo.mode1.setValue(0);
        twoBandStereo.gain2.setValue(8);
        twoBandStereo.fc2.setValue(20);
        twoBandStereo.q2.setValue(0.1);
        twoBandStereo.mode2.setValue(1);

        String expected = "    Mix: 100%\n    Level: -2dB\n    Gain1: +5dB\n    Fc 1: 5050Hz\n    Q 1: 0.1\n    Mode1: LShlf\n    Gain2: +8dB\n    Fc 2: 20Hz\n    Q 2: 0.1\n    Mode2: Band\n";
        String actual = AlgorithmPrinter.print(twoBandStereo);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintTwoBandDual() throws PrintException {
        TwoBandDual twoBandDual = new TwoBandDual();
        twoBandDual.mix.setValue(100);
        twoBandDual.level.setValue(0);
        twoBandDual.gainLeft1.setValue(-30);
        twoBandDual.fcLeft1.setValue(110);
        twoBandDual.qLeft1.setValue(0.7);
        twoBandDual.modeLeft1.setValue(0);
        twoBandDual.gainLeft2.setValue(-30);
        twoBandDual.fcLeft2.setValue(850);
        twoBandDual.qLeft2.setValue(0.7);
        twoBandDual.modeLeft2.setValue(2);
        twoBandDual.gainRight1.setValue(-30);
        twoBandDual.fcRight1.setValue(110);
        twoBandDual.qRight1.setValue(0.7);
        twoBandDual.modeRight1.setValue(0);
        twoBandDual.gainRight2.setValue(-30);
        twoBandDual.fcRight2.setValue(1700);
        twoBandDual.qRight2.setValue(0.7);
        twoBandDual.modeRight2.setValue(2);

        String expected = "    Mix: 100%\n    Level: 0dB\n    G-L1: -30dB\n    F-L1: 110Hz\n    Q-L1: 0.7\n    M-L1: LShlf\n    G-L2: -30dB\n    F-L2: 850Hz\n    Q-L2: 0.7\n    M-L2: HShlf\n    G-R1: -30dB\n    F-R1: 110Hz\n    Q-R1: 0.7\n    M-R1: LShlf\n    G-R2: -30dB\n    F-R2: 1700Hz\n    Q-R2: 0.7\n    M-R2: HShlf\n";
        String actual = AlgorithmPrinter.print(twoBandDual);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintCrossover() throws PrintException {
        Crossover crossover = new Crossover();
        crossover.mix.setValue(100);
        crossover.level.setValue(0);
        crossover.fc.setValue(3000);
        crossover.balance.setValue(4);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Fc: 3000Hz\n    Bal: +4\n";
        String actual = AlgorithmPrinter.print(crossover);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintEqVolumeMono() throws PrintException {
        EqVolumeMono volumeMono = new EqVolumeMono();
        volumeMono.mix.setValue(100);
        volumeMono.level.setValue(0);
        volumeMono.volume.setValue(100);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Volume: 100%\n";
        String actual = AlgorithmPrinter.print(volumeMono);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintEqVolumeStereo() throws PrintException {
        EqVolumeStereo volumeStereo = new EqVolumeStereo();
        volumeStereo.mix.setValue(100);
        volumeStereo.level.setValue(0);
        volumeStereo.volume.setValue(0);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Volume: 0%\n";
        String actual = AlgorithmPrinter.print(volumeStereo);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintEqVolumeDual() throws PrintException {
        EqVolumeDual volumeDual = new EqVolumeDual();
        volumeDual.mix.setValue(100);
        volumeDual.level.setValue(0);
        volumeDual.volumeLeft.setValue(0);
        volumeDual.volumeRight.setValue(100);

        String expected = "    Mix: 100%\n    Level: 0dB\n    Vol-L: 0%\n    Vol-R: 100%\n";
        String actual = AlgorithmPrinter.print(volumeDual);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintEqPedalVol() throws PrintException {
        EqPedalVol pedalVol = new EqPedalVol();
        pedalVol.mix.setValue(100);
        pedalVol.level.setValue(0);

        String expected = "    Mix: 100%\n    Level: 0dB\n";
        String actual = AlgorithmPrinter.print(pedalVol);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintTone() throws PrintException {
        Tone tone = new Tone();
        tone.lo.setValue(25);
        tone.mid.setValue(10);
        tone.hi.setValue(20);
        tone.inLevel.setValue(0);
        tone.level.setValue(55);

        String expected = "    Lo: +25dB\n    Mid: +10dB\n    Hi: +20dB\n    InLvl: 0dB\n    Level: 55dB\n";
        String actual = AlgorithmPrinter.print(tone);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintCrunch() throws PrintException {
        Crunch crunch = new Crunch();
        crunch.lo.setValue(6);
        crunch.mid.setValue(12);
        crunch.hi.setValue(15);
        crunch.inLevel.setValue(0);
        crunch.level.setValue(50);

        String expected = "    Lo: +6dB\n    Mid: +12dB\n    Hi: 15dB\n    InLvl: 0dB\n    Level: 50dB\n";
        String actual = AlgorithmPrinter.print(crunch);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintScreamer() throws PrintException {
        Screamer screamer = new Screamer();
        screamer.lo.setValue(2);
        screamer.mid.setValue(1);
        screamer.hi.setValue(3);
        screamer.drive.setValue(22);
        screamer.tone.setValue(25);
        screamer.level.setValue(57);

        String expected = "    Lo: +2dB\n    Mid: +1dB\n    Hi: 3dB\n    Drive: 22\n    Tone: 25\n    Level: 57dB\n";
        String actual = AlgorithmPrinter.print(screamer);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintOverdrive() throws PrintException {
        Overdrive overdrive = new Overdrive();
        overdrive.lo.setValue(4);
        overdrive.mid.setValue(8);
        overdrive.hi.setValue(0);
        overdrive.inLevel.setValue(-8);
        overdrive.loCut.setValue(0);
        overdrive.feel.setValue(32);
        overdrive.drive.setValue(40);
        overdrive.tone.setValue(21);
        overdrive.level.setValue(44);

        String expected = "    Lo: +4dB\n    Mid: +8dB\n    Hi: 0dB\n    InLvl: -8dB\n    LoCut: 0\n    Feel: 32\n    Drive: 40\n    Tone: 21\n    Level: 44dB\n";
        String actual = AlgorithmPrinter.print(overdrive);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintDistortion() throws PrintException {
        Distortion distortion = new Distortion();
        distortion.lo.setValue(0);
        distortion.mid.setValue(4);
        distortion.hi.setValue(11);
        distortion.drive.setValue(25);
        distortion.tone.setValue(21);
        distortion.bass.setValue(7);
        distortion.treble.setValue(6);
        distortion.level.setValue(40);

        String expected = "    Lo: 0dB\n    Mid: +4dB\n    Hi: 11dB\n    Drive: 25\n    Tone: 21\n    Bass: +7dB\n    Trebl: +6dB\n    Level: 40dB\n";
        String actual = AlgorithmPrinter.print(distortion);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPreamp() throws PrintException {
        Preamp preamp = new Preamp();
        preamp.lo.setValue(7);
        preamp.mid.setValue(3);
        preamp.hi.setValue(0);
        preamp.inLevel.setValue(-5);
        preamp.loCut.setValue(0);
        preamp.feel.setValue(32);
        preamp.drive.setValue(23);
        preamp.tone.setValue(22);
        preamp.bass.setValue(0);
        preamp.treble.setValue(0);
        preamp.level.setValue(45);

        String expected = "    Lo: +7dB\n    Mid: +3dB\n    Hi: 0dB\n    InLvl: -5dB\n    LoCut: 0\n    Feel: 32\n    Drive: 23\n    Tone: 22\n    Bass: 0dB\n    Trebl: 0dB\n    Level: 45dB\n";
        String actual = AlgorithmPrinter.print(preamp);

        assertEquals(expected, actual);
    }
}
