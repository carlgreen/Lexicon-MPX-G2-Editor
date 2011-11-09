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
package info.carlwithak.mpxg2.model;

import java.beans.IntrospectionException;
import org.junit.Test;

import static info.carlwithak.mpxg2.model.Util.testBean;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test Ab using bean tester.
 *
 * @author Carl Green
 */
public class AbTest {
    private Ab ab = new Ab();

    @Test
    public void testAb() throws IntrospectionException {
        testBean(Ab.class);
    }

    @Test
    public void testBRate() {
        assertEquals("", ab.getParameter(1).getUnit());
    }

    @Test
    public void testARate() {
        assertEquals("", ab.getParameter(2).getUnit());
    }

    @Test
    public void testOnLevel() {
        assertEquals("", ab.getParameter(3).getUnit());
    }

    @Test
    public void testInvalid() {
        assertNull(ab.getParameter(0));
        assertNull(ab.getParameter(4));
    }

}
