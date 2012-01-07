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
    private final GenericValue<Boolean> link = new GenericValue<Boolean>("Link", "OnOff", false, true);
    private final GenericValue<Double> size = new GenericValue<Double>("Size", "m", 4.0, 35.0);
    private final ReverbSpredValue value = new ReverbSpredValue("Spred", link, size);
    private final boolean linkValue;
    private final double sizeValue;
    private final int index;
    private final String display;

    public ReverbSpredValueTest(final boolean linkValue, final double sizeValue, final int index, final String display) {
        this.linkValue = linkValue;
        this.sizeValue = sizeValue;
        this.index = index;
        this.display = display;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
            /* no link */
            { false, 5.0, 0, "0" },
            { false, 17.0, 127, "127" },
            { false, 17.0, 255, "255" },
            /* size 4.0 */
            { true, 4.0, 0, "0" },
            { true, 4.0, 9, "0" },
            { true, 4.0, 10, "1" },
            { true, 4.0, 249, "24" },
            { true, 4.0, 255, "25" },
            /* size 22.5 */
            { true, 22.5, 0, "0" },
            { true, 22.5, 3, "0" },
            { true, 22.5, 4, "1" },
            { true, 22.5, 222, "73" },
            { true, 22.5, 253, "83" },
            { true, 22.5, 254, "84" },
            { true, 22.5, 255, "84" },
            /* size 24.0 */
            { true, 24.0, 0, "0" },
            { true, 24.0, 2, "0" },
            { true, 24.0, 3, "1" },
            { true, 24.0, 120, "42" },
            { true, 24.0, 254, "88" },
            { true, 24.0, 255, "89" },
            /* size 28.0 */
            { true, 28.0, 0, "0" },
            { true, 28.0, 2, "0" },
            { true, 28.0, 3, "1" },
            { true, 28.0, 120, "48" },
            { true, 28.0, 254, "101" },
            { true, 28.0, 255, "102" },
            /* size 35.0 */
            { true, 35.0, 0, "0" },
            { true, 35.0, 2, "0" },
            { true, 35.0, 3, "1" },
            { true, 35.0, 39, "19" },
            { true, 35.0, 41, "19" },
            { true, 35.0, 254, "123" },
            { true, 35.0, 255, "124" },
            /* size 53.0 */
            { true, 53.0, 0, "0" },
            { true, 53.0, 1, "0" },
            { true, 53.0, 2, "1" },
            { true, 53.0, 125, "89" },
            { true, 53.0, 254, "180" },
            { true, 53.0, 255, "181" },
            /* size 53.5 */
            { true, 53.5, 164, "117" }
        });
    }

    @Test
    public void testGetDisplayString() {
        link.setValue(linkValue);
        size.setValue(sizeValue);
        value.setValue(index);
        assertThat(value.getDisplayString(), is(display));
    }

}
