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

/**
 * Various helper methods for printing.
 *
 * @author Carl Green
 */
public class Util {

    private static final String[] DELAY_INSERTS = {
        "Effect 1", "Effect 2", "Chorus", "Delay", "Reverb", "EQ", "Gain"
    };

    private static final double[] REVERB_DELAY_TIMES = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.41
    };

    private static final double[] REVERB_RT_HC = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12.8
    };

    /**
     * @return String representation of insert position.
     */
    public static String delayInsertToString(final int delayInsert) {
        return DELAY_INSERTS[delayInsert];
    }

    /**
     * @return String representation of delay time index.
     */
    public static double reverbDelayTimeToString(final int reverbDelayTime) {
        return REVERB_DELAY_TIMES[reverbDelayTime];
    }

    /**
     * @return String representation of Rt HC index.
     */
    public static double reverbRtHCToString(final int reverbRtHC) {
        return REVERB_RT_HC[reverbRtHC];
    }

    /**
     * @return postive numbers prefixed with '+' and negative numbers prefixed with '-'.
     */
    public static String signInt(final int i) {
        return i > 0 ? "+" + Integer.toString(i) : Integer.toString(i);
    }

}
