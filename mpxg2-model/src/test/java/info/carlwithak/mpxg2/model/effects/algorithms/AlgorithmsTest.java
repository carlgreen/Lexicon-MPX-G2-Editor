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
    public void testDistortionAlgorithm() throws IntrospectionException {
        testBean(Distortion.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Lo", new Distortion().getParameterName(0));
        assertEquals("", new Distortion().getParameterUnit(0));
    }

    @Test
    public void testOverdriveAlgorithm() throws IntrospectionException {
        testBean(Overdrive.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Lo", new Overdrive().getParameterName(0));
        assertEquals("", new Overdrive().getParameterUnit(0));
    }

    @Test
    public void testPreampAlgorithm() throws IntrospectionException {
        testBean(Preamp.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Lo", new Preamp().getParameterName(0));
        assertEquals("", new Preamp().getParameterUnit(0));
    }

    @Test
    public void testScreamerAlgorithm() throws IntrospectionException {
        testBean(Screamer.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Lo", new Screamer().getParameterName(0));
        assertEquals("", new Screamer().getParameterUnit(0));
    }

    @Test
    public void testToneAlgorithm() throws IntrospectionException {
        testBean(Tone.class);

        // token test of getParameterName() and getParameterUnit()
        assertEquals("Lo", new Tone().getParameterName(0));
        assertEquals("", new Tone().getParameterUnit(0));
    }
}
