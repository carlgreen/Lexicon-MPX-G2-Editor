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

package info.carlwithak.mpxg2.sysex;

/**
 * Various helper methods for parsing SysEx data.
 *
 * @author Carl Green
 */
public class Util {

    /**
     * @param value
     * @return true if value is 1, otherwise false
     */
    public static boolean parseBoolean(final int value) {
        return value == 1;
    }

    /**
     * @param value
     * @return value wrapped if it is larger than 32768
     */
    public static int wrapInteger(final int value) {
        return value > 32768 ? value - 65536 : value;
    }

    /**
     * @param value
     * @return value unwrapped if it is negative
     */
    public static int unwrapByte(final int value) {
        return value < 0 ? 256 + value : value;
    }
}
