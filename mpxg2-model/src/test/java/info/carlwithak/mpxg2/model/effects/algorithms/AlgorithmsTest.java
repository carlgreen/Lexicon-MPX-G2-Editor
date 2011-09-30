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

/**
 * Run a java bean test for each algorithm class.
 *
 * @author Carl Green
 */
public class AlgorithmsTest {

    @Test
    public void testAmbienceAlgorithm() throws IntrospectionException {
        testBean(Ambience.class);
    }

    @Test
    public void testAutoPanAlgorithm() throws IntrospectionException {
        testBean(AutoPan.class);
    }

    @Test
    public void testChamberAlgorithm() throws IntrospectionException {
        testBean(Chamber.class);
    }

    @Test
    public void testChorusAlgorithm() throws IntrospectionException {
        testBean(ChorusAlgorithm.class);
    }

    @Test
    public void testDelayDualAlgorithm() throws IntrospectionException {
        testBean(DelayDual.class);
    }

    @Test
    public void testDetuneDualAlgorithm() throws IntrospectionException {
        testBean(DetuneDual.class);
    }

    @Test
    public void testDetuneMonoAlgorithm() throws IntrospectionException {
        testBean(DetuneMono.class);
    }

    @Test
    public void testEchoMonoAlgorithm() throws IntrospectionException {
        testBean(EchoMono.class);
    }

    @Test
    public void testEchoDualAlgorithm() throws IntrospectionException {
        testBean(EchoDual.class);
    }

    @Test
    public void testEqPedalVolAlgorithm() throws IntrospectionException {
        testBean(EqPedalVol.class);
    }

    @Test
    public void testFlangerStereoAlgorithm() throws IntrospectionException {
        testBean(FlangerStereo.class);
    }

    @Test
    public void testOverdriveAlgorithm() throws IntrospectionException {
        testBean(Overdrive.class);
    }

    @Test
    public void testPannerAlgorithm() throws IntrospectionException {
        testBean(Panner.class);
    }

    @Test
    public void testPedalVolAlgorithm() throws IntrospectionException {
        testBean(PedalVol.class);
    }

    @Test
    public void testPedalWah1Algorithm() throws IntrospectionException {
        testBean(PedalWah1.class);
    }

    @Test
    public void testPedalWah2Algorithm() throws IntrospectionException {
        testBean(PedalWah2.class);
    }

    @Test
    public void testPlateAlgorithm() throws IntrospectionException {
        testBean(Plate.class);
    }

    @Test
    public void testScreamerAlgorithm() throws IntrospectionException {
        testBean(Screamer.class);
    }

    @Test
    public void testShiftDualAlgorithm() throws IntrospectionException {
        testBean(ShiftDual.class);
    }

    @Test
    public void testToneAlgorithm() throws IntrospectionException {
        testBean(Tone.class);
    }

    @Test
    public void testUniVybeAlgorithm() throws IntrospectionException {
        testBean(UniVybe.class);
    }

    @Test
    public void testVolumeMonoAlgorithm() throws IntrospectionException {
        testBean(VolumeMono.class);
    }

    @Test
    public void testWah1Algorithm() throws IntrospectionException {
        testBean(Wah1.class);
    }
}
