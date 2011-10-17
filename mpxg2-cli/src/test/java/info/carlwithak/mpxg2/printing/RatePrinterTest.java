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

import info.carlwithak.mpxg2.model.BeatRate;
import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.TapMsRate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Tests for RatePrinter.
 *
 * @author Carl Green
 */
public class RatePrinterTest {

    @Test(expected = PrintException.class)
    public void testPrintInvalidRateType() throws PrintException {
        Rate rate = mock(Rate.class);
        RatePrinter.print(rate);
    }

    @Test
    public void testPrintFrequencyRate() throws PrintException {
        Rate rate = new FrequencyRate(2.3);

        String expected = "2.30Hz";
        String actual = RatePrinter.print(rate);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintBeatRate() throws PrintException {
        Rate rate = new BeatRate(3, 7);

        String expected = "3:7";
        String actual = RatePrinter.print(rate);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintTapMsRate() throws PrintException {
        Rate rate = new TapMsRate(200);

        String expected = "200ms";
        String actual = RatePrinter.print(rate);

        assertEquals(expected, actual);
    }
}
