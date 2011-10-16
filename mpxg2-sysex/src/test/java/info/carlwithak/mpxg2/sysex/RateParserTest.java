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

import info.carlwithak.mpxg2.model.BeatRate;
import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.TapMsRate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for RateParser.
 *
 * @author Carl Green
 */
public class RateParserTest {

    /**
     * Test parse with frequency data.
     */
    @Test
    public void testParseFrequency() throws Exception {
        byte[] bytes0 = {0, 0, 0, 0, 0, 0};
        Rate expected = new FrequencyRate(0.0);
        Rate actual = RateParser.parse(bytes0);
        assertEquals(expected, actual);

        byte[] bytes1 = {4, 6, 0, 0, 0, 0};
        expected = new FrequencyRate(1.0);
        actual = RateParser.parse(bytes1);
        assertEquals(expected, actual);

        byte[] bytes10 = {8, 14, 3, 0, 0, 0};
        expected = new FrequencyRate(10.0);
        actual = RateParser.parse(bytes10);
        assertEquals(expected, actual);
    }

    /**
     * Test parse with cycles:beat data.
     */
    @Test
    public void testParseBeat() throws Exception {
        byte[] bytes11 = {1, 0, 1, 0, 1, 0};
        Rate expected = new BeatRate(1, 1);
        Rate actual = RateParser.parse(bytes11);
        assertEquals(expected, actual);

        byte[] bytes24 = {2, 0, 4, 0, 1, 0};
        expected = new BeatRate(2, 4);
        actual = RateParser.parse(bytes24);
        assertEquals(expected, actual);

        byte[] bytes42 = {4, 0, 2, 0, 1, 0};
        expected = new BeatRate(4, 2);
        actual = RateParser.parse(bytes42);
        assertEquals(expected, actual);
    }

    /**
     * Test parse with tap ms data.
     */
    @Test
    public void testParseTapMs() throws Exception {
        byte[] bytes100 = {4, 6, 0, 0, 4, 0};
        Rate expected = new TapMsRate(100);
        Rate actual = RateParser.parse(bytes100);
        assertEquals(expected, actual);

        byte[] bytes2000 = {0, 13, 7, 0, 4, 0};
        expected = new TapMsRate(2000);
        actual = RateParser.parse(bytes2000);
        assertEquals(expected, actual);
    }

    @Test(expected = ParseException.class)
    public void testInvalidType() throws ParseException {
        byte[] bytes = {0, 0, 0, 0, 5, 0};
        RateParser.parse(bytes);
    }
}
