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

package info.carlwithak.mpxg2.model.parameters;

/**
 *
 * @author Carl Green
 */
public class InsertPosition extends GenericValue<Integer> {

    private static final String[] DELAY_INSERTS = {
        "Effect 1", "Effect 2", "Chorus", "Delay", "Reverb", "EQ", "Gain"
    };

    public InsertPosition(final String name) {
        super(name, "", 0, 5);
    }

    @Override
    public String getDisplayString() {
        return DELAY_INSERTS[getValue()];
    }

}
