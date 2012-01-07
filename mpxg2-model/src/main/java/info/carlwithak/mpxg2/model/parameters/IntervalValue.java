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

/**
 * Holds an interval in the range -2Oct to Oct+ 5th.
 *
 * @author Carl Green
 */
public class IntervalValue extends GenericValue<Integer> {
    private static final String[] INTERVALS = {
        "@Oct", "@7th", "@6th", "@5th", "@4th", "@3rd", "@2nd",
        "-oct", "-7th", "-6th", "-5th", "-4th", "-3rd", "-2nd",
        "uni", "+2nd", "+3rd", "+4th", "+5th", "+6th", "+7th",
        "+oct", "*2nd", "*3rd", "*4th", "*5th"
    };

    public IntervalValue(final String name) {
        super(name, "", 0, 25);
    }

    @Override
    public String getDisplayString() {
        return INTERVALS[getValue()];
    }

}
