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

package info.carlwithak.mpxg2.sysex.effects.algorithms;

import info.carlwithak.mpxg2.model.BeatRate;
import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.effects.algorithms.AutoPan;
import info.carlwithak.mpxg2.sysex.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Carl Green
 */
public class AutoPanParserTest {

    @Test
    public void testParse_Cordovox1() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 4, 0, 0, 0, 0, 0, 2, 3, 4, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        AutoPan autoPan = AutoPanParser.parse(effectParameters);
        assertEquals(100, (int) autoPan.getMix().getValue());
        assertEquals(0, (int) autoPan.getLevel().getValue());
        assertEquals(new FrequencyRate("Rate", 0.04), autoPan.getRate());
        assertEquals(50, (int) autoPan.getPulseWidth().getValue());
        assertEquals(100, (int) autoPan.getDepth().getValue());
        assertEquals(1, (int) autoPan.getPhase().getValue()); // 0, 90, 180, 270 degrees
    }

    @Test
    public void testParse_Cordovox2() throws ParseException {
        byte[] effectParameters = {4, 6, 0, 0, 4, 6, 0, 0, 0, 0, 2, 3, 4, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        AutoPan autoPan = AutoPanParser.parse(effectParameters);
        assertEquals(100, (int) autoPan.getMix().getValue());
        assertEquals(0, (int) autoPan.getLevel().getValue());
        assertEquals(new FrequencyRate("Rate", 1.00), autoPan.getRate());
        assertEquals(50, (int) autoPan.getPulseWidth().getValue());
        assertEquals(100, (int) autoPan.getDepth().getValue());
        assertEquals(3, (int) autoPan.getPhase().getValue()); // 0, 90, 180, 270 degrees
    }

    @Test
    public void testParse_VybeFlange() throws ParseException {
        byte[] effectParameters = {4, 6, 3, 0, 1, 0, 2, 0, 1, 0, 2, 3, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        AutoPan autoPan = AutoPanParser.parse(effectParameters);
        assertEquals(100, (int) autoPan.getMix().getValue());
        assertEquals(3, (int) autoPan.getLevel().getValue());
        assertEquals(new BeatRate("Rate", 1, 2), autoPan.getRate());
        assertEquals(50, (int) autoPan.getPulseWidth().getValue());
        assertEquals(100, (int) autoPan.getDepth().getValue());
        assertEquals(0, (int) autoPan.getPhase().getValue()); // 0, 90, 180, 270 degrees
    }
}
