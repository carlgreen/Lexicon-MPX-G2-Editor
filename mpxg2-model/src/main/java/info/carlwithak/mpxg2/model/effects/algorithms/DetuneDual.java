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
 * Class for Detune (D) parameters.
 *
 * @author Carl Green
 */
public class DetuneDual extends Effect {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Tune1", "Tune2", "P Dly"
    };

    private GenericValue<Integer> tune1 = new GenericValue<Integer>("", 0, 100);
    private int optimize;
    private GenericValue<Integer> tune2 = new GenericValue<Integer>("", 0, 100);
    private GenericValue<Integer> preDelay = new GenericValue<Integer>("ms", 0, 70);

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
                parameter = tune1;
                break;
            case 3:
                parameter = tune2;
                break;
            case 4:
                parameter = preDelay;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public int getTune1() {
        return tune1.getValue();
    }

    public void setTune1(int tune1) {
        this.tune1.setValue(tune1);
    }

    public int getOptimize() {
        return optimize;
    }

    public void setOptimize(int optimize) {
        this.optimize = optimize;
    }

    public int getTune2() {
        return tune2.getValue();
    }

    public void setTune2(int tune2) {
        this.tune2.setValue(tune2);
    }

    public int getPreDelay() {
        return preDelay.getValue();
    }

    public void setPreDelay(int preDelay) {
        this.preDelay.setValue(preDelay);
    }
}
