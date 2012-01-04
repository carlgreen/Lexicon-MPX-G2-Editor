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
import info.carlwithak.mpxg2.model.EqModeValue;
import info.carlwithak.mpxg2.model.FrequencyRate;
import info.carlwithak.mpxg2.model.GenericValue;
import info.carlwithak.mpxg2.model.InsertPosition;
import info.carlwithak.mpxg2.model.KeyValue;
import info.carlwithak.mpxg2.model.PanValue;
import info.carlwithak.mpxg2.model.PhaseValue;
import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.ScaleValue;
import info.carlwithak.mpxg2.model.TapMsRate;
import info.carlwithak.mpxg2.model.WahType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

/**
 * Tests for ParameterPrinter.
 *
 * @author Carl Green
 */
public class ParameterPrinterTest {

    @Test(expected = PrintException.class)
    public void testPrintInvalidRateType() throws PrintException {
        Rate rate = mock(Rate.class);
        ParameterPrinter.print(rate);
    }

    @Test
    public void testPrintFrequencyRate() throws PrintException {
        Rate rate = new FrequencyRate("Rate", 2.3);

        String expected = "2.30Hz";
        String actual = ParameterPrinter.print(rate);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintBeatRate() throws PrintException {
        Rate rate = new BeatRate("Rate", 3, 7);

        String expected = "3:7";
        String actual = ParameterPrinter.print(rate);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintTapMsRate() throws PrintException {
        Rate rate = new TapMsRate("Rate", 200);

        String expected = "200ms";
        String actual = ParameterPrinter.print(rate);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintInsertPosition() throws PrintException {
        InsertPosition insert = new InsertPosition("Fbk");
        insert.setValue(3);

        String expected = "Delay";
        String actual = ParameterPrinter.print(insert);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintWahType() throws PrintException {
        WahType type = new WahType();
        type.setValue(1);

        String expected = "Model V";
        String actual = ParameterPrinter.print(type);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintOnOffValue() throws PrintException {
        GenericValue<Boolean> value = new GenericValue<Boolean>("Glide", "OnOff", false, true);
        value.setValue(true);

        String expected = "On";
        String actual = ParameterPrinter.print(value);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPanValue() throws PrintException {
        PanValue value = new PanValue("Pan", -5, 5);

        value.setValue(-5);
        assertThat(ParameterPrinter.print(value), is("5L"));

        value.setValue(0);
        assertThat(ParameterPrinter.print(value), is("C"));

        value.setValue(5);
        assertThat(ParameterPrinter.print(value), is("5R"));
    }

    @Test
    public void testPrintPhaseValue() throws PrintException {
        PhaseValue value = new PhaseValue("Phase");

        value.setValue(0);
        assertThat(ParameterPrinter.print(value), is("0°"));

        value.setValue(3);
        assertThat(ParameterPrinter.print(value), is("270°"));
    }

    @Test
    public void testPrintEqModeValue() throws PrintException {
        EqModeValue value = new EqModeValue("Mode");

        value.setValue(0);
        assertThat(ParameterPrinter.print(value), is("LShlf"));

        value.setValue(1);
        assertThat(ParameterPrinter.print(value), is("Band"));

        value.setValue(2);
        assertThat(ParameterPrinter.print(value), is("HShlf"));
    }

    @Test
    public void testPrintKeyValue() throws PrintException {
        KeyValue value = new KeyValue("Key");

        value.setValue(0);
        assertThat(ParameterPrinter.print(value), is("C"));

        value.setValue(11);
        assertThat(ParameterPrinter.print(value), is("B"));
    }

    @Test
    public void testPrintScaleValue() throws PrintException {
        ScaleValue value = new ScaleValue("Scale");

        value.setValue(0);
        assertThat(ParameterPrinter.print(value), is("Major"));

        value.setValue(6);
        assertThat(ParameterPrinter.print(value), is("Loc"));
    }

    @Test
    public void testPrintGenericValue() throws PrintException {
        GenericValue<Integer> value = new GenericValue<Integer>("PW 1", "%", 0, 100);
        value.setValue(45);

        String expected = "45%";
        String actual = ParameterPrinter.print(value);

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintSignedGenericValue() throws PrintException {
        GenericValue<Integer> value = new GenericValue<Integer>("Level", "dB", -90, 6);
        value.setValue(6);

        String expected = "+6dB";
        String actual = ParameterPrinter.print(value);

        assertEquals(expected, actual);
    }
}
