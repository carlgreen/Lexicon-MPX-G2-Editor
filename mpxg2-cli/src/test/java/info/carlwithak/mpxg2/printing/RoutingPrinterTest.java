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

import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.model.RoutingData;
import info.carlwithak.mpxg2.model.effects.algorithms.Ambience;
import info.carlwithak.mpxg2.model.effects.algorithms.AutoPan;
import info.carlwithak.mpxg2.model.effects.algorithms.Chamber;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusAlgorithm;
import info.carlwithak.mpxg2.model.effects.algorithms.ChorusPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.DelayDual;
import info.carlwithak.mpxg2.model.effects.algorithms.DetuneDual;
import info.carlwithak.mpxg2.model.effects.algorithms.EchoDual;
import info.carlwithak.mpxg2.model.effects.algorithms.EqPedalVol;
import info.carlwithak.mpxg2.model.effects.algorithms.Overdrive;
import info.carlwithak.mpxg2.model.effects.algorithms.Panner;
import info.carlwithak.mpxg2.model.effects.algorithms.PedalWah1;
import info.carlwithak.mpxg2.model.effects.algorithms.Plate;
import info.carlwithak.mpxg2.model.effects.algorithms.Screamer;
import info.carlwithak.mpxg2.model.effects.algorithms.ShiftDual;
import info.carlwithak.mpxg2.model.effects.algorithms.Tone;
import info.carlwithak.mpxg2.model.effects.algorithms.UniVybe;
import info.carlwithak.mpxg2.model.effects.algorithms.VolumeDual;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for RoutingPrinter.
 *
 * @author Carl Green
 */
public class RoutingPrinterTest {

    /**
     * Test printing a textual representation of the routing.
     *
     * G2 Blue is a simple all along the upper route routing.
     *
     * @throws PrintException if an error is encountered while printing
     */
    @Test
    public void testPrintG2Blue() throws PrintException {
        Program program = new Program();

        RoutingData routing = new RoutingData();
        routing.setEffectId(8);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting0(routing);

        routing = new RoutingData();
        routing.setEffectId(0);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting1(routing);

        routing = new RoutingData();
        routing.setEffectId(1);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting2(routing);

        routing = new RoutingData();
        routing.setEffectId(6);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting3(routing);

        routing = new RoutingData();
        routing.setEffectId(2);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting4(routing);

        routing = new RoutingData();
        routing.setEffectId(3);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting5(routing);

        routing = new RoutingData();
        routing.setEffectId(4);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting6(routing);

        routing = new RoutingData();
        routing.setEffectId(5);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting7(routing);

        routing = new RoutingData();
        routing.setEffectId(7);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting8(routing);

        program.setEffect1(new UniVybe());
        program.setEffect2(new PedalWah1());
        program.setChorus(new ChorusPedalVol());
        program.setDelay(new EchoDual());
        program.setReverb(new Ambience());
        program.setGain(new Screamer());

        String expected = "I=1=2=G=C=D=R=e=O";

        assertEquals(expected, RoutingPrinter.print(program));
    }

    /**
     * Test printing a textual representation of the routing.
     *
     * Guitar Solo splits into the lower route.
     *
     * @throws PrintException if an error is encountered while printing
     */
    @Test
    public void testPrintGuitarSolo() throws PrintException {
        Program program = new Program();

        RoutingData routing = new RoutingData();
        routing.setEffectId(8);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting0(routing);

        routing = new RoutingData();
        routing.setEffectId(5);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting1(routing);

        routing = new RoutingData();
        routing.setEffectId(2);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting2(routing);

        routing = new RoutingData();
        routing.setEffectId(6);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting3(routing);

        routing = new RoutingData();
        routing.setEffectId(0);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(3);
        routing.setPathType(0);
        program.setRouting4(routing);

        routing = new RoutingData();
        routing.setEffectId(3);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(1);
        routing.setPathType(1);
        program.setRouting5(routing);

        routing = new RoutingData();
        routing.setEffectId(4);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(1);
        program.setRouting6(routing);

        routing = new RoutingData();
        routing.setEffectId(1);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(2);
        routing.setPathType(1);
        program.setRouting7(routing);

        routing = new RoutingData();
        routing.setEffectId(7);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting8(routing);

        program.setEffect1(new DetuneDual());
        program.setEffect2(new Panner());
        program.setDelay(new EchoDual());
        program.setReverb(new Plate());
        program.setGain(new Screamer());

        String expected = "I=e=c=G=1===R=2=O\n" +
                          "        |=D===|";
        String actual = RoutingPrinter.print(program);

        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the routing.
     *
     * Cordovox splits and has mono and stereo paths.
     *
     * @throws PrintException if an error is encountered while printing
     */
    @Test
    public void testPrintCordovox() throws PrintException {
        Program program = new Program();

        RoutingData routing = new RoutingData();
        routing.setEffectId(8);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting0(routing);

        routing = new RoutingData();
        routing.setEffectId(5);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting1(routing);

        routing = new RoutingData();
        routing.setEffectId(6);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting2(routing);

        routing = new RoutingData();
        routing.setEffectId(2);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(3);
        routing.setPathType(0);
        program.setRouting3(routing);

        routing = new RoutingData();
        routing.setEffectId(0);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(4);
        routing.setRouting(1);
        routing.setPathType(1);
        program.setRouting4(routing);

        routing = new RoutingData();
        routing.setEffectId(1);
        routing.setUpperInputConnection(3);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(1);
        program.setRouting5(routing);

        routing = new RoutingData();
        routing.setEffectId(3);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(1);
        program.setRouting6(routing);

        routing = new RoutingData();
        routing.setEffectId(4);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(1);
        program.setRouting7(routing);

        routing = new RoutingData();
        routing.setEffectId(7);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(2);
        routing.setPathType(1);
        program.setRouting8(routing);

        program.setEffect1(new AutoPan());
        program.setEffect2(new AutoPan());
        program.setChorus(new ChorusAlgorithm());
        program.setDelay(new EchoDual());
        program.setReverb(new Chamber());
        program.setEq(new EqPedalVol());
        program.setGain(new Tone());

        String expected = "I=E=G=C--\\2=D=R=O\n" +
                          "      |/1=======|";
        String actual = RoutingPrinter.print(program);

        assertEquals(expected, actual);
    }

    /**
     * Test printing a textual representation of the routing.
     *
     * PowerChords has "lower case numbers".
     *
     * @throws PrintException if an error is encountered while printing
     */
    @Test
    public void testPrintPowerChords() throws PrintException {
        Program program = new Program();

        RoutingData routing = new RoutingData();
        routing.setEffectId(8);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting0(routing);

        routing = new RoutingData();
        routing.setEffectId(1);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting1(routing);

        routing = new RoutingData();
        routing.setEffectId(6);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting2(routing);

        routing = new RoutingData();
        routing.setEffectId(5);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting3(routing);

        routing = new RoutingData();
        routing.setEffectId(0);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting4(routing);

        routing = new RoutingData();
        routing.setEffectId(2);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting5(routing);

        routing = new RoutingData();
        routing.setEffectId(3);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting6(routing);

        routing = new RoutingData();
        routing.setEffectId(4);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting7(routing);

        routing = new RoutingData();
        routing.setEffectId(7);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting8(routing);

        program.setEffect1(new ShiftDual());
        program.setDelay(new DelayDual());
        program.setReverb(new Chamber());
        program.setGain(new Overdrive());

        String expected = "I=₂=G=e=1=c=D=R=O";

        assertEquals(expected, RoutingPrinter.print(program));
    }

    /**
     * Test printing a textual representation of the routing.
     *
     * Pitch Cascade has inactive effects on the lower routing.
     *
     * @throws PrintException if an error is encountered while printing
     */
    @Test
    public void testPrintPitchCascase() throws PrintException {
        Program program = new Program();

        RoutingData routing = new RoutingData();
        routing.setEffectId(8);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting0(routing);

        routing = new RoutingData();
        routing.setEffectId(6);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting1(routing);

        routing = new RoutingData();
        routing.setEffectId(1);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(3);
        routing.setPathType(0);
        program.setRouting2(routing);

        routing = new RoutingData();
        routing.setEffectId(5);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(1);
        routing.setPathType(1);
        program.setRouting3(routing);

        routing = new RoutingData();
        routing.setEffectId(3);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(1);
        routing.setPathType(1);
        program.setRouting4(routing);

        routing = new RoutingData();
        routing.setEffectId(0);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(1);
        routing.setPathType(1);
        program.setRouting5(routing);

        routing = new RoutingData();
        routing.setEffectId(2);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(1);
        routing.setPathType(1);
        program.setRouting6(routing);

        routing = new RoutingData();
        routing.setEffectId(4);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(2);
        routing.setPathType(1);
        program.setRouting7(routing);

        routing = new RoutingData();
        routing.setEffectId(7);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting8(routing);

        program.setEffect1(new ShiftDual());
        program.setEffect2(new VolumeDual());
        program.setDelay(new DelayDual());
        program.setReverb(new Ambience());
        program.setEq(new EqPedalVol());
        program.setGain(new Overdrive());

        String expected = "I=G=2=========R=O\n" +
                          "    |=E=D=1=c=|";

        assertEquals(expected, RoutingPrinter.print(program));
    }

    /**
     * Test printing an invalid routing where it splits into two routes but
     * never combines again.
     *
     * @throws PrintException if an error is encountered while printing
     */
    @Test(expected = PrintException.class)
    public void testInvalidRouting() throws PrintException {
        Program program = new Program();

        RoutingData routing = new RoutingData();
        routing.setEffectId(8);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting0(routing);

        routing = new RoutingData();
        routing.setEffectId(5);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting1(routing);

        routing = new RoutingData();
        routing.setEffectId(2);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting2(routing);

        routing = new RoutingData();
        routing.setEffectId(6);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(0);
        routing.setPathType(0);
        program.setRouting3(routing);

        routing = new RoutingData();
        routing.setEffectId(0);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(3);
        routing.setPathType(0);
        program.setRouting4(routing);

        routing = new RoutingData();
        routing.setEffectId(3);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(1);
        routing.setPathType(1);
        program.setRouting5(routing);

        routing = new RoutingData();
        routing.setEffectId(4);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(1);
        routing.setPathType(1);
        program.setRouting6(routing);

        routing = new RoutingData();
        routing.setEffectId(1);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(1);
        routing.setPathType(1);
        program.setRouting7(routing);

        routing = new RoutingData();
        routing.setEffectId(7);
        routing.setUpperInputConnection(0);
        routing.setLowerInputConnection(0);
        routing.setRouting(1);
        routing.setPathType(1);
        program.setRouting8(routing);

        RoutingPrinter.print(program);
    }
}
