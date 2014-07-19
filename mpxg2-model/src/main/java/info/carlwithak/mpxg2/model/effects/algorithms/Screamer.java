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

package info.carlwithak.mpxg2.model.effects.algorithms;

import info.carlwithak.mpxg2.model.effects.Gain;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class for Screamer parameters.
 *
 * @author Carl Green
 */
public class Screamer extends Gain {
    private static final String NAME = "Screamer";

    public final GenericValue<Integer> lo = new GenericValue<>("Lo", "dB", -5, 5);
    public final GenericValue<Integer> mid = new GenericValue<>("Mid", "dB", -5, 5);
    public final GenericValue<Integer> hi = new GenericValue<>("Hi", "dB", 0, 5);
    public final GenericValue<Integer> drive = new GenericValue<>("Drive", "", 0, 40);
    public final GenericValue<Integer> tone = new GenericValue<>("Tone", "", 0, 25);
    public final GenericValue<Integer> level = new GenericValue<>("Level", "dB", 0, 64);

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = lo;
                break;
            case 1:
                parameter = mid;
                break;
            case 2:
                parameter = hi;
                break;
            case 3:
                parameter = drive;
                break;
            case 4:
                parameter = tone;
                break;
            case 5:
                parameter = level;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

}
