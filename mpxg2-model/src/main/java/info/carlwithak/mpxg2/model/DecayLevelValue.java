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

package info.carlwithak.mpxg2.model;

/**
 *
 * @author Carl Green
 */
public class DecayLevelValue extends GenericValue<Integer> {

    private static final int[] REVERB_DECAY_LEVEL = {
        -48, -42, -39, -36, -33, -30, -27,
        -24, -22, -20, -18, -16, -14, -12, -10,
        -9, -8, -7, -6, -5, -4, -3, -2, -1
    };

    public DecayLevelValue(final String name) {
        super(name, "dB", 0, 25);
    }

    @Override
    public String getDisplayString() {
        final int val = getValue() - 1; // remove 1 as 'Off' is the first value
        if (val == -1) {
            return "Off";
        } else if (val == REVERB_DECAY_LEVEL.length) {
            return "Full";
        } else {
            return REVERB_DECAY_LEVEL[val] + getUnit();
        }
    }

}
