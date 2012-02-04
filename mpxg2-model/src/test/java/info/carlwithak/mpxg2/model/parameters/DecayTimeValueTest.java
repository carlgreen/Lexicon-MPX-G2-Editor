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
public class DecayTimeValueTest {
    private final OnOffValue link = new OnOffValue("Link");
    private final GenericValue<Double> size = new GenericValue<Double>("Size", "m", 4.0, 35.0);
    private final DecayTimeValue value = new DecayTimeValue("Decay", link, size);
    private final boolean linkValue;
    private final double sizeValue;
    private final int index;
    private final String display;

    public DecayTimeValueTest(final boolean linkValue, final double sizeValue, final int index, final String display) {
        this.linkValue = linkValue;
        this.sizeValue = sizeValue;
        this.index = index;
        this.display = display;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
            /* no link */
            { false, 5.0, 0, "0.29s" },
            { false, 17.0, 0, "0.29s" },
            /* range 0 */
            { true, 5.0, 0, "0.07s" },
            { true, 5.0, 63, "6.58s" },
            /* range 1 */
            { true, 12.0, 0, "0.09s" },
            { true, 12.0, 63, "13.1s" },
            /* range 2 */
            { true, 27.5, 0, "0.12s" },
            { true, 27.5, 63, "19.6s" },
            /* range 3 */
            { true, 35.0, 0, "0.14s" },
            { true, 35.0, 63, "26.2s" },
            /* range 6 */
            { true, 53.0, 0, "0.21s" },
            { true, 53.0, 41, "1.67s" },
            { true, 53.0, 63, "45.8s" },
            /* range 9 */
            { true, 76.0, 0, "0.29s" },
            { true, 76.0, 63, "65.4s" }
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
