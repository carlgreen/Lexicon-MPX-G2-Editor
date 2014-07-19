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

import info.carlwithak.mpxg2.model.parameters.GenericValue;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test some of the more complex methods in Util.
 *
 * @author Carl Green
 */
public class UtilTest {

    @Test
    public void testPrintParameter() {
        GenericValue<Integer> parameter = new GenericValue<>("Name", "u", 0, 1);
        parameter.setValue(1);
        assertThat(Util.printParameter(parameter), is("    Name: 1u\n"));
    }

    @Test
    public void testPrintParameterWithoutValue() {
        GenericValue<Integer> parameter = new GenericValue<>("Name", "u", 0, 1);
        parameter.setValue(null);
        assertThat(Util.printParameter(parameter), is("    Name: --\n"));
    }

}
