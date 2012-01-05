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
public class AmbienceHighCutValue extends GenericValue<Integer> {

    private static final double[] REVERB_AMBIENCE_RT_HC = {
        0.5, 1.0, 1.6, 2.2, 2.9, 3.6, 4.4, 5.5, 6.3, 7.5, 8.9, 10.6, 12.8, 15.9, 21.2
    };

    public AmbienceHighCutValue(final String name) {
        super(name, "kHz", 0, 48);
    }

    @Override
    public String toString() {
        return REVERB_AMBIENCE_RT_HC[getValue()] + getUnit();
    }

}
