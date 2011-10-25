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

import info.carlwithak.mpxg2.model.GenericValue;
import info.carlwithak.mpxg2.model.Parameter;
import info.carlwithak.mpxg2.model.effects.Effect;

/**
 * Class for Panner parameters.
 *
 * @author Carl Green
 */
public class Panner extends Effect {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Pan1", "Pan2"
    };

    private GenericValue<Integer> pan1 = new GenericValue<Integer>("LCR", -50, 50);
    private GenericValue<Integer> pan2 = new GenericValue<Integer>("LCR", -50, 50);

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
    }

    @Override
    public String getParameterUnit(final int parameterIndex) {
        Parameter parameter = getParameter(parameterIndex);
        String unit = parameter.getUnit();
        if (parameter instanceof GenericValue && ((GenericValue) parameter).getMinValue() instanceof Integer && ((GenericValue<Integer>) parameter).getMinValue() < 0) {
            unit = '-' + unit;
        }
        return unit;
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
                parameter = pan1;
                break;
            case 3:
                parameter = pan2;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public int getPan1() {
        return pan1.getValue();
    }

    public void setPan1(int pan1) {
        this.pan1.setValue(pan1);
    }

    public int getPan2() {
        return pan2.getValue();
    }

    public void setPan2(int pan2) {
        this.pan2.setValue(pan2);
    }
}
