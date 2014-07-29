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
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class ReverbSpredValueDataTest {

    @Test
    public void stuff() {
        for (int i = 0; i < ReverbSpredValue.TOP.length; i++) {
            int[] x = ReverbSpredValue.getRaw(i);
            if (x.length == 0) {
                continue;
            }
            int[] y = new int[x.length];
            for (int j = 0; j < x.length; j++) {
                y[j] = (int) (j * ReverbSpredValue.TOP[i] / x.length);
            }
            System.out.println(i + " up to " + x[x.length - 1]);
            if (!Arrays.equals(x, y)) {
                System.out.println(Arrays.toString(x));
                System.out.println(Arrays.toString(y));
                for (int k = 0; k < x.length; k++) {
                    if (x[k] != y[k]) {
                        System.out.println(x[k] + " vs " + y[k]);
                        break;
                    }
                }
            }
            assertThat(x, is(y));
        }
    }
}
