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
package info.carlwithak.mpxg2.model.effects.algorithms;

import java.beans.IntrospectionException;
import org.junit.Test;

import static info.carlwithak.mpxg2.model.Util.testBean;
import static org.junit.Assert.assertEquals;

/**
 * Run a java bean test for each algorithm class.
 *
 * @author Carl Green
 */
public class AlgorithmsTest {

    @Test
    public void testAmbienceAlgorithm() throws IntrospectionException {
        testBean(Ambience.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new Ambience().getParameterName(0));
        assertEquals("%", new Ambience().getParameterUnit(0));
    }

    @Test
    public void testAutoPanAlgorithm() throws IntrospectionException {
        testBean(AutoPan.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new AutoPan().getParameterName(0));
        assertEquals("%", new AutoPan().getParameterUnit(0));
    }

    @Test
    public void testBlueCompAlgorithm() throws IntrospectionException {
        testBean(BlueComp.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new BlueComp().getParameterName(0));
        assertEquals("%", new BlueComp().getParameterUnit(0));
    }

    @Test
    public void testCentrifuge1Algorithm() throws IntrospectionException {
        testBean(Centrifuge1.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new Centrifuge1().getParameterName(0));
        assertEquals("%", new Centrifuge1().getParameterUnit(0));
    }

    @Test
    public void testChamberAlgorithm() throws IntrospectionException {
        testBean(Chamber.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new Chamber().getParameterName(0));
        assertEquals("%", new Chamber().getParameterUnit(0));
    }

    @Test
    public void testChorusAlgorithm() throws IntrospectionException {
        testBean(ChorusAlgorithm.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new ChorusAlgorithm().getParameterName(0));
        assertEquals("%", new ChorusAlgorithm().getParameterUnit(0));
    }

    @Test
    public void testDelayDualAlgorithm() throws IntrospectionException {
        testBean(DelayDual.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new DelayDual().getParameterName(0));
        assertEquals("%", new DelayDual().getParameterUnit(0));
    }

    @Test
    public void testDelayMonoAlgorithm() throws IntrospectionException {
        testBean(DelayMono.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new DelayMono().getParameterName(0));
        assertEquals("%", new DelayMono().getParameterUnit(0));
    }

    @Test
    public void testDelayStereoAlgorithm() throws IntrospectionException {
        testBean(DelayStereo.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new DelayStereo().getParameterName(0));
        assertEquals("%", new DelayStereo().getParameterUnit(0));
    }

    @Test
    public void testDetuneDualAlgorithm() throws IntrospectionException {
        testBean(DetuneDual.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new DetuneDual().getParameterName(0));
        assertEquals("%", new DetuneDual().getParameterUnit(0));
    }

    @Test
    public void testDetuneMonoAlgorithm() throws IntrospectionException {
        testBean(DetuneMono.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new DetuneMono().getParameterName(0));
        assertEquals("%", new DetuneMono().getParameterUnit(0));
    }

    @Test
    public void testDistortionAlgorithm() throws IntrospectionException {
        testBean(Distortion.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Lo", new Distortion().getParameterName(0));
        assertEquals("", new Distortion().getParameterUnit(0));
    }

    @Test
    public void testEchoMonoAlgorithm() throws IntrospectionException {
        testBean(EchoMono.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new EchoMono().getParameterName(0));
        assertEquals("%", new EchoMono().getParameterUnit(0));
    }

    @Test
    public void testEchoDualAlgorithm() throws IntrospectionException {
        testBean(EchoDual.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new EchoDual().getParameterName(0));
        assertEquals("%", new EchoDual().getParameterUnit(0));
    }

    @Test
    public void testEqPedalVolAlgorithm() throws IntrospectionException {
        testBean(EqPedalVol.class);
    }

    @Test
    public void testFlangerStereoAlgorithm() throws IntrospectionException {
        testBean(FlangerStereo.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new FlangerStereo().getParameterName(0));
        assertEquals("%", new FlangerStereo().getParameterUnit(0));
    }

    @Test
    public void testHallAlgorithm() throws IntrospectionException {
        testBean(Hall.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new Hall().getParameterName(0));
        assertEquals("%", new Hall().getParameterUnit(0));
    }

    @Test
    public void testJamManAlgorithm() throws IntrospectionException {
        testBean(JamMan.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new JamMan().getParameterName(0));
        assertEquals("%", new JamMan().getParameterUnit(0));
    }

    @Test
    public void testOctaBuzzAlgorithm() throws IntrospectionException {
        testBean(OctaBuzz.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new OctaBuzz().getParameterName(0));
        assertEquals("%", new OctaBuzz().getParameterUnit(0));
    }

    @Test
    public void testOverdriveAlgorithm() throws IntrospectionException {
        testBean(Overdrive.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Lo", new Overdrive().getParameterName(0));
        assertEquals("", new Overdrive().getParameterUnit(0));
    }

    @Test
    public void testOrangePhaseAlgorithm() throws IntrospectionException {
        testBean(OrangePhase.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new OrangePhase().getParameterName(0));
        assertEquals("%", new OrangePhase().getParameterUnit(0));
    }

    @Test
    public void testPannerAlgorithm() throws IntrospectionException {
        testBean(Panner.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new Panner().getParameterName(0));
        assertEquals("%", new Panner().getParameterUnit(0));
    }

    @Test
    public void testPedalVolAlgorithm() throws IntrospectionException {
        testBean(PedalVol.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new PedalVol().getParameterName(0));
        assertEquals("%", new PedalVol().getParameterUnit(0));
    }

    @Test
    public void testPedalWah1Algorithm() throws IntrospectionException {
        testBean(PedalWah1.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new PedalWah1().getParameterName(0));
        assertEquals("%", new PedalWah1().getParameterUnit(0));
    }

    @Test
    public void testPedalWah2Algorithm() throws IntrospectionException {
        testBean(PedalWah2.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new PedalWah2().getParameterName(0));
        assertEquals("%", new PedalWah2().getParameterUnit(0));
    }

    @Test
    public void testPlateAlgorithm() throws IntrospectionException {
        testBean(Plate.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new Plate().getParameterName(0));
        assertEquals("%", new Plate().getParameterUnit(0));
    }

    @Test
    public void testPreampAlgorithm() throws IntrospectionException {
        testBean(Preamp.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Lo", new Preamp().getParameterName(0));
        assertEquals("", new Preamp().getParameterUnit(0));
    }

    @Test
    public void testRedCompAlgorithm() throws IntrospectionException {
        testBean(RedComp.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new RedComp().getParameterName(0));
        assertEquals("%", new RedComp().getParameterUnit(0));
    }

    @Test
    public void testRotaryCabAlgorithm() throws IntrospectionException {
        testBean(RotaryCab.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new RotaryCab().getParameterName(0));
        assertEquals("%", new RotaryCab().getParameterUnit(0));
    }

    @Test
    public void testScreamerAlgorithm() throws IntrospectionException {
        testBean(Screamer.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Lo", new Screamer().getParameterName(0));
        assertEquals("", new Screamer().getParameterUnit(0));
    }

    @Test
    public void testShiftDualAlgorithm() throws IntrospectionException {
        testBean(ShiftDual.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new ShiftDual().getParameterName(0));
        assertEquals("%", new ShiftDual().getParameterUnit(0));
    }

    @Test
    public void testSweepFilterAlgorithm() throws IntrospectionException {
        testBean(SweepFilter.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new SweepFilter().getParameterName(0));
        assertEquals("%", new SweepFilter().getParameterUnit(0));
    }

    @Test
    public void testToneAlgorithm() throws IntrospectionException {
        testBean(Tone.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Lo", new Tone().getParameterName(0));
        assertEquals("", new Tone().getParameterUnit(0));
    }

    @Test
    public void testTremoloMonoAlgorithm() throws IntrospectionException {
        testBean(TremoloMono.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new TremoloMono().getParameterName(0));
        assertEquals("%", new TremoloMono().getParameterUnit(0));
    }

    @Test
    public void testUniVybeAlgorithm() throws IntrospectionException {
        testBean(UniVybe.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new UniVybe().getParameterName(0));
        assertEquals("%", new UniVybe().getParameterUnit(0));
    }

    @Test
    public void testVolumeMonoAlgorithm() throws IntrospectionException {
        testBean(VolumeMono.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new VolumeMono().getParameterName(0));
        assertEquals("%", new VolumeMono().getParameterUnit(0));
    }

    @Test
    public void testVolumeDualAlgorithm() throws IntrospectionException {
        testBean(VolumeDual.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new VolumeDual().getParameterName(0));
        assertEquals("%", new VolumeDual().getParameterUnit(0));
    }

    @Test
    public void testWah1Algorithm() throws IntrospectionException {
        testBean(Wah1.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new Wah1().getParameterName(0));
        assertEquals("%", new Wah1().getParameterUnit(0));
    }

    @Test
    public void testWah2Algorithm() throws IntrospectionException {
        testBean(Wah2.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Mix", new Wah2().getParameterName(0));
        assertEquals("%", new Wah2().getParameterUnit(0));
    }
}
