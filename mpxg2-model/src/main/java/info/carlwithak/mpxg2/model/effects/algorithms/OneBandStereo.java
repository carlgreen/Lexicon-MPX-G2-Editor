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

import info.carlwithak.mpxg2.model.effects.Eq;
import info.carlwithak.mpxg2.model.parameters.EqModeValue;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class for 1-Band (S) parameters.
 *
 * @author Carl Green
 */
public class OneBandStereo extends Eq {
    private static final String NAME = "1-Band (S)";

    public final GenericValue<Integer> gain = new GenericValue<>("Gain", "dB", -72, 24);
    public final GenericValue<Integer> fc = new GenericValue<>("Fc", "Hz", 20, 20000);
    public final GenericValue<Double> q = new GenericValue<>("Q", "", 0.1, 10.0);
    public final EqModeValue mode = new EqModeValue("Mode");

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
            case 1:
                parameter = super.getParameter(parameterIndex);
                break;
            case 2:
                parameter = gain;
                break;
            case 3:
                parameter = fc;
                break;
            case 4:
                parameter = q;
                break;
            case 5:
                parameter = mode;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

}
