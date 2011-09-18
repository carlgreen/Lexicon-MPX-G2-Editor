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
                "        Max: +6\n" +
                "  Controllers:\n" +
                "    Knob:\n" +
                "      Value: 50\n" +
                "      Low: 0\n" +
                "      High: 100\n" +
                "      Name: Delay Adj\n" +
                "    LFO 1:\n" +
                "      Mode: On\n" +
                "      Rate: 0.60Hz\n" +
                "      PW: 50%\n" +
                "      Phase: 0\n" +
                "      Depth: 100%\n" +
                "      On Level: 64\n" +
                "      On Source: none\n" +
                "    LFO 2:\n" +
                "      Mode: On\n" +
                "      Rate: 0.92Hz\n" +
                "      PW: 50%\n" +
                "      Phase: 0\n" +
                "      Depth: 100%\n" +
                "      On Level: 64\n" +
                "      On Source: none\n" +
                "    Random:\n" +
                "      Low: 0\n" +
                "      High: 127\n" +
                "      Rate: 1.00Hz\n" +
                "    A/B:\n" +
                "      Mode: Trigger\n" +
                "      A Rate: 100\n" +
                "      B Rate: 100\n" +
                "      On Level: 64\n" +
                "      On Source: none\n" +
                "    Envelope:\n" +
                "      Src1: off\n" +
                "      Src2: off\n" +
                "      A Trim: 100\n" +
                "      Resp: 64\n" +
                "  Mix:\n" +
                "    Send:\n" +
                "      Level: 0\n" +
                "      Bypass Level: 0\n" +
                "    Post:\n" +
                "      Mix: 100%\n" +
                "      Level: 0dB\n" +
                "      Bypass Level: 0dB\n" +
                "    FX1:\n" +
                "      Mix: 100%\n" +
                "      Level: 0dB\n" +
                "    FX2:\n" +
                "      Mix: 100%\n" +
                "      Level: 0dB\n" +
                "    Chorus:\n" +
                "      Mix: 100%\n" +
                "      Level: 0dB\n" +
                "    Delay:\n" +
                "      Mix: 2%\n" +
                "      Level: +1dB\n" +
                "    Reverb:\n" +
                "      Mix: 18%\n" +
                "      Level: 0dB\n" +
                "  Tempo:\n" +
                "    Rate: 120 BPM\n" +
                "    Source: internal\n" +
                "    Beat Value: quarter\n" +
                "    Tap Average: 2 beats\n" +
                "    Tap Source: none";
        // TODO: speakersim, noisegate
        File preset = new File(this.getClass().getClassLoader().getResource("001_G2_Blue.syx").toURI());
        Program program = SysexParser.parseProgram(preset);
        String actual = ProgramPrinter.print(program);
        assertEquals(expected, actual);
    }

}
