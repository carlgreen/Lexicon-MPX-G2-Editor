/*
 *  Copyright (C) 2012 Carl Green
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

package info.carlwithak.mpxg2.model.parameters;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
@RunWith(Parameterized.class)
public class ReverbSpredValueTest {
    private final OnOffValue link = new OnOffValue("Link");
    private final GenericValue<Double> size = new GenericValue<>("Size", "m", 4.0, 35.0);
    private final ReverbTimeValue time = new ReverbTimeValue("Time");
    private ReverbSpredValue value;
    private final boolean linkValue;
    private final Double sizeValue;
    private final Integer timeValue;
    private final int index;
    private final String display;

    public ReverbSpredValueTest(final boolean linkValue, final Double sizeValue, final Integer timeValue, final int index, final String display) {
        this.linkValue = linkValue;
        this.sizeValue = sizeValue;
        this.timeValue = timeValue;
        this.index = index;
        this.display = display;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            /* no link */
            { false, 5.0, null, 0, "0" },
            { false, 17.0, null, 127, "127" },
            { false, 17.0, null, 255, "255" },
            /* size 4.0 */
            { true, 4.0, null, 0, "0" },
            { true, 4.0, null, 9, "0" },
            { true, 4.0, null, 10, "1" },
            { true, 4.0, null, 249, "24" },
            { true, 4.0, null, 255, "25" },
            /* size 22.5 */
            { true, 22.5, null, 0, "0" },
            { true, 22.5, null, 3, "0" },
            { true, 22.5, null, 4, "1" },
            { true, 22.5, null, 222, "73" },
            { true, 22.5, null, 253, "83" },
            { true, 22.5, null, 254, "84" },
            { true, 22.5, null, 255, "84" },
            /* size 24.0 */
            { true, 24.0, null, 0, "0" },
            { true, 24.0, null, 2, "0" },
            { true, 24.0, null, 3, "1" },
            { true, 24.0, null, 120, "42" },
            { true, 24.0, null, 254, "88" },
            { true, 24.0, null, 255, "89" },
            /* size 28.0 */
            { true, 28.0, null, 0, "0" },
            { true, 28.0, null, 2, "0" },
            { true, 28.0, null, 3, "1" },
            { true, 28.0, null, 120, "48" },
            { true, 28.0, null, 254, "101" },
            { true, 28.0, null, 255, "102" },
            /* size 35.0 */
            { true, 35.0, null, 0, "0" },
            { true, 35.0, null, 2, "0" },
            { true, 35.0, null, 3, "1" },
            { true, 35.0, null, 39, "19" },
            { true, 35.0, null, 41, "19" },
            { true, 35.0, null, 254, "123" },
            { true, 35.0, null, 255, "124" },
            /* size 53.0 */
            { true, 53.0, null, 0, "0" },
            { true, 53.0, null, 1, "0" },
            { true, 53.0, null, 2, "1" },
            { true, 53.0, null, 125, "89" },
            { true, 53.0, null, 254, "180" },
            { true, 53.0, null, 255, "181" },
            /* size 53.5 */
            { true, 53.5, null, 164, "117" },
            /* time 140ms (0) */
            { true, null, 0, 0, "0" },
            { true, null, 0, 9, "0" },
            { true, null, 0, 10, "1" },
            { true, null, 0, 255, "25" },
            /* time 145ms (1) */
            { true, null, 1, 0, "0" },
            { true, null, 1, 9, "0" },
            { true, null, 1, 10, "1" },
            { true, null, 1, 255, "27" },
            /* time 195ms (11) */
            { true, null, 11, 0, "0" },
            { true, null, 11, 5, "0" },
            { true, null, 11, 6, "1" },
            { true, null, 11, 231, "38" },
            { true, null, 11, 254, "42" },
            { true, null, 11, 255, "43" },
        });
    }

    @Test
    public void testGetDisplayString() {
        link.setValue(linkValue);
        size.setValue(sizeValue);
        time.setValue(timeValue);
        if (sizeValue != null) {
            value = new ReverbSpredValue("Spred", link, size);
        } else if (timeValue != null) {
            value = new ReverbSpredValue("Spred", link, time);
        }
        value.setValue(index);
        assertThat(value.getDisplayString(), is(display));
    }

}
