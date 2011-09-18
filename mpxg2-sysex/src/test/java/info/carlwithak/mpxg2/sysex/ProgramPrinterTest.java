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

package info.carlwithak.mpxg2.sysex;

import java.io.File;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for ProgramPrinter.
 *
 * @author carl
 */
public class ProgramPrinterTest {

    /**
     * Test printing a textual representation of the program.
     *
     * TODO would be good not to use SysexParser.parseProgram()?
     */
    @Test
    public void testPrintG2Blue() throws Exception {
        String expected =
                "G2 Blue\n" +
                "  Guitar Style: Blues, Clean, Jazz, Rock\n" +
                "  Effect Type: Chorus, Delay, Gain, Reverb, Wah\n" +
                "  Application Type: Amp Input + FX Loop\n" +
                "  Effect Routing: I=1=2=G=C=D=R=E=O\n" + // TODO indicate that EQ is not available
                "  Effect 1: UniVybe (on)\n" +
                "    Toe Switch: on=bypass\n" +
                "    Mix: 100%\n" +
                "    Level: 0dB\n" +
                "    Rate: 20\n" +
                "  Effect 2: Pedal Wah 1 (off)\n" +
                "    Toe Switch: off=bypass\n" +
                "    Mix: 100%\n" +
                "    Level: 0dB\n" +
                "    Bass: 19\n" +
                "    Type: Model C\n" +
                "    Resp: 100\n" +
                "    Gain: +10\n" +
                "  Chorus: Pedal Vol (on)\n" +
                "    Toe Switch: on=bypass\n" +
                "    Mix: 100%\n" +
                "    Level: 0dB\n" +
                "  Delay: Echo (D) (on)\n" +
                "    Toe Switch: disabled\n" +
                "    Mix: 2%\n" +
                "    Level: +1dB\n" +
                "    Time1: 4:4\n" +
                "    Time2: 2:1\n" +
                "    Level1: 0dB\n" +
                "    Level2: 0dB\n" +
                "    Feedback1: +1%\n" +
                "    Insert: delay\n" +
                "    Feedback2: +1%\n" +
                "    Damp1: 20%\n" +
                "    Damp2: 20%\n" +
                "    Clear: off\n" +
                "  Reverb: Ambience (off)\n" +
                "    Toe Switch: off=bypass\n" +
                "    Mix: 18%\n" +
                "    Level: 0dB\n" +
                "    Size: 24.5m\n" +
                "    Link: on\n" +
                "    Diff: 60%\n" +
                "    Pre Delay: 7ms\n" +
                "    Delay Time: 1.41s\n" +
                "    Delay Level: off\n" +
                "    Rt HC: 12.8k\n" +
                "  Gain: Screamer (off)\n" +
                "    Toe Switch: disabled\n" +
                "    Lo: +2\n" +
                "    Mid: +1\n" +
                "    Hi: +3\n" +
                "    Drive: 22\n" +
                "    Tone: 25\n" +
                "    Level: 57\n" +
                "  Softrow:\n" +
                "    1: Gain Drive\n" +
                "    2: Gain Tone\n" +
                "    3: Gain Level\n" +
                "    4: Effect 1 Rate\n" +
                "    5: Delay Time1\n" +
                "    6: Reverb Mix\n" +
                "    7: Reverb Size\n" +
                "    8: Reverb P Dly\n" +
                "    9: Reverb DTime\n" +
                "    10: Reverb D Lvl\n" +
                "  Patching:\n" +
                "    Patch 1:\n" +
                "      Source: Ctls A/B\n" +
                "        Min: 0\n" +
                "        Mid: --\n" +
                "        Max: 127\n" +
                "      Destination: Delay Mix\n" +
                "        Min: 2%\n" +
                "        Mid: --\n" +
                "        Max: 30%\n" +
                "    Patch 2:\n" +
                "      Source: Ctls A/B\n" +
                "        Min: 0\n" +
                "        Mid: --\n" +
                "        Max: 127\n" +
                "      Destination: Delay Time2\n" +
                "        Min: 4:1\n" +
                "        Mid: --\n" +
                "        Max: 4:2\n" +
                "    Patch 3:\n" +
                "      Source: Ctls A/B\n" +
                "        Min: 0\n" +
                "        Mid: --\n" +
                "        Max: 127\n" +
                "      Destination: Delay Fbk 1\n" +
                "        Min: 1%\n" +
                "        Mid: --\n" +
                "        Max: 15%\n" +
                "    Patch 4:\n" +
                "      Source: Ctls A/B\n" +
                "        Min: 0\n" +
                "        Mid: --\n" +
                "        Max: 127\n" +
                "      Destination: Delay Fbk 2\n" +
                "        Min: 1%\n" +
                "        Mid: --\n" +
                "        Max: 4%\n" +
                "    Patch 5:\n" +
                "      Source: Midi Toe\n" +
                "        Min: 0\n" +
                "        Mid: --\n" +
                "        Max: 127\n" +
                "      Destination: Send Level\n" +
                "        Min: 0\n" +
                "        Mid: --\n" +
                "        Max: +6";
        // TODO: controllers, tempo, mix, speakersim, noisegate
        File preset = new File(this.getClass().getClassLoader().getResource("001_G2_Blue.syx").toURI());
        Program program = SysexParser.parseProgram(preset);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

}
