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

import java.lang.reflect.Field;
import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Carl Green
 */
public class ReverbSpredValueDataTest {

    private static final double[] TOP = {
        25.6, 27.2, 28.8,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0, // 10
        43.2, 44.8,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0, // 20
        0,
        0,
        0,
        0,
        65.6,
        0,
        0,
        0,
        0,
        0, // 30
        0,
        76.8,
        0,
        80.0,
        0,
        0,
        84.8, 86.4,
        0,
        89.65, // 40
        0,
        0,
        0,
        96.0,
        0,
        0,
        0,
        102.6, 104.0,
        0,
        107.2,
        0,
        110.4, 112.0,
        0,
        0,
        0,
        118.4, 120.0,
        0,
        123.2, 124.8, 126.4,
        0,
        0,
        0,
        132.8,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        147.21,
        0,
        0,
        0,
        0,
        0,
        0,
        158.4,
        0,
        0,
        0,
        0,
        0,
        168.0,
        0,
        0,
        0,
        0,
        0,
        0,
        179.25,
        0,
        182.4, 184.0,
        0, // 100
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        236.8
    };

    @Test
    public void stuff() throws ReflectiveOperationException {
        final Field f = ReverbSpredValue.class.getDeclaredField("REVERB_SPRED");
        f.setAccessible(true);
        final int[][] reverbSpred = (int[][]) f.get(null);
        for (int i = 0; i < TOP.length; i++) {
            int[] x = reverbSpred[i];
            if (x.length == 0) {
                continue;
            }
            int[] y = new int[x.length];
            for (int j = 0; j < x.length; j++) {
                y[j] = (int) (j * TOP[i] / x.length);
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
