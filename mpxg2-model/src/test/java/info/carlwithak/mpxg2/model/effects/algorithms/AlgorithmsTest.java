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

        // token test of getParameterUnit()
        assertEquals("%", new Ambience().getParameterUnit(0));
    }

    @Test
    public void testAutoPanAlgorithm() throws IntrospectionException {
        testBean(AutoPan.class);

        // token test of getParameterUnit()
        assertEquals("%", new AutoPan().getParameterUnit(0));
    }

    @Test
    public void testChamberAlgorithm() throws IntrospectionException {
        testBean(Chamber.class);

        // token test of getParameterUnit()
        assertEquals("%", new Chamber().getParameterUnit(0));
    }

    @Test
    public void testChorusAlgorithm() throws IntrospectionException {
        testBean(ChorusAlgorithm.class);

        // token test of getParameterUnit()
        assertEquals("%", new ChorusAlgorithm().getParameterUnit(0));
    }

    @Test
    public void testDelayDualAlgorithm() throws IntrospectionException {
        testBean(DelayDual.class);

        // token test of getParameterUnit()
        assertEquals("%", new DelayDual().getParameterUnit(0));
    }

    @Test
    public void testDetuneDualAlgorithm() throws IntrospectionException {
        testBean(DetuneDual.class);

        // token test of getParameterUnit()
        assertEquals("%", new DetuneDual().getParameterUnit(0));
    }

    @Test
    public void testDetuneMonoAlgorithm() throws IntrospectionException {
        testBean(DetuneMono.class);

        // token test of getParameterUnit()
        assertEquals("%", new DetuneMono().getParameterUnit(0));
    }

    @Test
    public void testEchoMonoAlgorithm() throws IntrospectionException {
        testBean(EchoMono.class);

        // token test of getParameterUnit()
        assertEquals("%", new EchoMono().getParameterUnit(0));
    }

    @Test
    public void testEchoDualAlgorithm() throws IntrospectionException {
        testBean(EchoDual.class);

        // token test of getParameterUnit()
        assertEquals("%", new EchoDual().getParameterUnit(0));
    }

    @Test
    public void testEqPedalVolAlgorithm() throws IntrospectionException {
        testBean(EqPedalVol.class);
    }

    @Test
    public void testFlangerStereoAlgorithm() throws IntrospectionException {
        testBean(FlangerStereo.class);

        // token test of getParameterUnit()
        assertEquals("%", new FlangerStereo().getParameterUnit(0));
    }

    @Test
    public void testOverdriveAlgorithm() throws IntrospectionException {
        testBean(Overdrive.class);
    }

    @Test
    public void testPannerAlgorithm() throws IntrospectionException {
        testBean(Panner.class);

        // token test of getParameterUnit()
        assertEquals("%", new Panner().getParameterUnit(0));
    }

    @Test
    public void testPedalVolAlgorithm() throws IntrospectionException {
        testBean(PedalVol.class);

        // token test of getParameterUnit()
        assertEquals("%", new PedalVol().getParameterUnit(0));
    }

    @Test
    public void testPedalWah1Algorithm() throws IntrospectionException {
        testBean(PedalWah1.class);

        // token test of getParameterUnit()
        assertEquals("%", new PedalWah1().getParameterUnit(0));
    }

    @Test
    public void testPedalWah2Algorithm() throws IntrospectionException {
        testBean(PedalWah2.class);

        // token test of getParameterUnit()
        assertEquals("%", new PedalWah2().getParameterUnit(0));
    }

    @Test
    public void testPlateAlgorithm() throws IntrospectionException {
        testBean(Plate.class);

        // token test of getParameterUnit()
        assertEquals("%", new Plate().getParameterUnit(0));
    }

    @Test
    public void testScreamerAlgorithm() throws IntrospectionException {
        testBean(Screamer.class);
    }

    @Test
    public void testShiftDualAlgorithm() throws IntrospectionException {
        testBean(ShiftDual.class);

        // token test of getParameterUnit()
        assertEquals("%", new ShiftDual().getParameterUnit(0));
    }

    @Test
    public void testToneAlgorithm() throws IntrospectionException {
        testBean(Tone.class);
    }

    @Test
    public void testUniVybeAlgorithm() throws IntrospectionException {
        testBean(UniVybe.class);

        // token test of getParameterUnit()
        assertEquals("%", new UniVybe().getParameterUnit(0));
    }

    @Test
    public void testVolumeMonoAlgorithm() throws IntrospectionException {
        testBean(VolumeMono.class);

        // token test of getParameterUnit()
        assertEquals("%", new VolumeMono().getParameterUnit(0));
    }

    @Test
    public void testWah1Algorithm() throws IntrospectionException {
        testBean(Wah1.class);

        // token test of getParameterUnit()
        assertEquals("%", new Wah1().getParameterUnit(0));
    }
}
