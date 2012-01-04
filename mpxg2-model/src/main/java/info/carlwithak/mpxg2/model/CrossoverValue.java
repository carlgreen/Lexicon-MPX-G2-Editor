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
public class CrossoverValue extends GenericValue<Integer> {

    private static final String[] REVERB_XOVR = {
        "30", "60", "90", "120", "151", "181", "212", "243", "273", "336", "398",
        "461", "525", "589", "654", "818", "986", "1.1k", "1.3k", "1.5k", "1.6k",
        "1.8k", "2.0k", "2.2k", "2.4k", "2.6k", "2.9k", "3.1k", "3.3k", "3.5k",
        "3.8k", "4.0k", "4.3k", "4.6k", "4.8k", "5.1k", "5.4k", "5.7k", "6.1k",
        "6.4k", "6.8k", "7.1k", "7.5k", "7.9k", "8.4k", "8.8k", "9.3k", "9.9k",
        "10.4k", "11.0k", "11.7k", "12.4k", "13.2k", "14.1k", "15.2k", "16.3k",
        "17.7k", "19.4k", "21.6k", "24.7k"
    };

    public CrossoverValue(final String name) {
        super(name, "Hz", 0, 62);
    }

    @Override
    public String toString() {
        return getValue() == REVERB_XOVR.length ? "Full" : REVERB_XOVR[getValue()] + getUnit();
    }

}
