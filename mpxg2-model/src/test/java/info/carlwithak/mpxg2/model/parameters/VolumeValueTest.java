/*
 * Copyright (C) 2012 Carl Green
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
public class VolumeValueTest {
    private final VolumeValue value = new VolumeValue("Level", -90, 6);
    private final int index;
    private final String display;

    public VolumeValueTest(final int index, final String display) {
        this.index = index;
        this.display = display;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
            { -90, "Off" },
            { -89, "-89dB" },
            { 0, "0dB" },
            { 6, "+6dB" }
        });
    }

    @Test
    public void testGetDisplayString() {
        value.setValue(index);
        assertThat(value.getDisplayString(), is(display));
    }
    
}
