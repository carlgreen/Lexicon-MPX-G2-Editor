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

import info.carlwithak.mpxg2.model.effects.Effect;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class for Blue Comp parameters.
 *
 * @author Carl Green
 */
public class BlueComp extends Effect {
    private static final String NAME = "Blue Comp";

    public final GenericValue<Integer> sensitivity = new GenericValue<Integer>("Sense", "dB", -90, 6);
    public final GenericValue<Integer> threshold = new GenericValue<Integer>("Thrsh", "dB", -72, 24);
    public final GenericValue<Integer> gain = new GenericValue<Integer>("Gain", "dB", -83, 0);
    public final GenericValue<Integer> attackTime = new GenericValue<Integer>("ATime", "ms", 0, 2000);
    public final GenericValue<Integer> releaseTime = new GenericValue<Integer>("RTime", "ms", 0, 2000);

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
                parameter = sensitivity;
                break;
            case 3:
                parameter = threshold;
                break;
            case 4:
                parameter = gain;
                break;
            case 5:
                parameter = attackTime;
                break;
            case 6:
                parameter = releaseTime;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

}
