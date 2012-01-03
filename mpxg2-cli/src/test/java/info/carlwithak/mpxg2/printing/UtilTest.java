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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test some of the more complex methods in Util.
 *
 * @author Carl Green
 */
public class UtilTest {

    @Test
    public void testReverbDecayToString_noLink() {
        boolean link = false;
        int reverbDecay = 0;

        double size = 5.0;
        String expected = "0.29";
        String actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);

        // check size doesn't matter
        size = 17.0;
        actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);
    }

    @Test
    public void testReverbDecayToString_Link0() {
        boolean link = true;
        double size = 5.0;

        int reverbDecay = 0;
        String expected = "0.07";
        String actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);

        reverbDecay = 63;
        expected = "6.58";
        actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);
    }

    @Test
    public void testReverbDecayToString_Link1() {
        boolean link = true;
        double size = 12.0;

        int reverbDecay = 0;
        String expected = "0.09";
        String actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);

        reverbDecay = 63;
        expected = "13.1";
        actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);
    }

    @Test
    public void testReverbDecayToString_Link2() {
        boolean link = true;
        double size = 27.5;

        int reverbDecay = 0;
        String expected = "0.12";
        String actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);

        reverbDecay = 63;
        expected = "19.6";
        actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);
    }

    @Test
    public void testReverbDecayToString_Link3() {
        boolean link = true;
        double size = 35.0;

        int reverbDecay = 0;
        String expected = "0.14";
        String actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);

        reverbDecay = 63;
        expected = "26.2";
        actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);
    }

    @Test
    public void testReverbDecayToString_Link6() {
        boolean link = true;
        double size = 53.0;

        int reverbDecay = 0;
        String expected = "0.21";
        String actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);

        reverbDecay = 41;
        expected = "1.67";
        actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);

        reverbDecay = 63;
        expected = "45.8";
        actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);
    }

    @Test
    public void testReverbDecayToString_Link9() {
        boolean link = true;
        double size = 76.0;

        int reverbDecay = 0;
        String expected = "0.29";
        String actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);

        reverbDecay = 63;
        expected = "65.4";
        actual = Util.reverbDecayToString(link, size, reverbDecay);
        assertEquals(expected, actual);
    }

    @Test
    public void testReverbDelayLevelToString() {
        int delayLevel = 0;
        String expected = "Off";
        String actual = Util.reverbDelayLevelToString(delayLevel);
        assertEquals(expected, actual);

        delayLevel = 1;
        expected = "-48dB";
        actual = Util.reverbDelayLevelToString(delayLevel);
        assertEquals(expected, actual);

        delayLevel = 24;
        expected = "-1dB";
        actual = Util.reverbDelayLevelToString(delayLevel);
        assertEquals(expected, actual);

        delayLevel = 25;
        expected = "Full";
        actual = Util.reverbDelayLevelToString(delayLevel);
        assertEquals(expected, actual);
    }

    @Test
    public void testSignInt() {
        // standard stuff
        assertEquals("+1", Util.signInt(1));
        assertEquals("0", Util.signInt(0));
        assertEquals("-1", Util.signInt(-1));

        // wrapping
        assertEquals("-500", Util.signInt(65036));
        assertEquals("-8", Util.signInt(65528));
    }

    @Test
    public void testPanToString() {
        assertEquals("10L", Util.panToString(-10));
        assertEquals("C", Util.panToString(0));
        assertEquals("10R", Util.panToString(10));
    }

    @Test
    public void testPhaseToString() {
        assertEquals("0°", Util.phaseToString(0));
        assertEquals("90°", Util.phaseToString(1));
        assertEquals("180°", Util.phaseToString(2));
        assertEquals("270°", Util.phaseToString(3));
    }

    @Test
    public void testOnOffToString_Int() {
        assertEquals("Off", Util.onOffToString(0));
        assertEquals("On", Util.onOffToString(1));
    }

    @Test
    public void testOnOffToString_Boolean() {
        assertEquals("Off", Util.onOffToString(false));
        assertEquals("On", Util.onOffToString(true));
    }

    @Test
    public void testWahTypeToString() {
        assertEquals("Model C", Util.wahTypeToString(0));
        assertEquals("Model V", Util.wahTypeToString(1));
    }

    @Test
    public void testEqModeToString() {
        assertEquals("LShlf", Util.eqModeToString(0));
        assertEquals("Band", Util.eqModeToString(1));
        assertEquals("HShlf", Util.eqModeToString(2));
    }
}
