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

import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.Util;
import java.beans.IntrospectionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Carl Green
 */
public class EchoMonoTest {
    private EchoMono echoMono;

    @Before
    public void setUp() {
        echoMono = new EchoMono();
    }

    @Test
    public void testBean() throws IntrospectionException {
        Util.testBean(EchoMono.class);
    }

    @Test
    public void testMix() {
        assertEquals("%", echoMono.getParameter(0).getUnit());
    }

    @Test
    public void testLevel() {
        assertEquals("dB", echoMono.getParameter(1).getUnit());
    }

    @Test
    public void testTime() {
        echoMono.setTime(new FrequencyRate(0.5));
        assertEquals("Hz", echoMono.getParameter(2).getUnit());
    }

    @Test
    public void testFeedback() {
        assertEquals("%", echoMono.getParameter(3).getUnit());
    }

    @Test
    public void testDamp() {
        assertEquals("%", echoMono.getParameter(4).getUnit());
    }

    @Test
    public void testClear() {
        assertEquals("OnOff", echoMono.getParameter(5).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(echoMono.getParameter(6));
    }
}
