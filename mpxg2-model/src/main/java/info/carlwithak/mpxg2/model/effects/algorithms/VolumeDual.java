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
import info.carlwithak.mpxg2.model.effects.Chorus;

/**
 * Class for Volume (D) parameters.
 *
 * @author Carl Green
 */
public class VolumeDual extends Chorus {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Vol-L", "Vol-R"
    };

    private GenericValue<Integer> volumeLeft = new GenericValue<Integer>("%", 0, 100);
    private GenericValue<Integer> volumeRight = new GenericValue<Integer>("%", 0, 100);

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
    }

    @Override
    public String getParameterUnit(final int parameterIndex) {
        Parameter parameter = getParameter(parameterIndex);
        String unit = parameter.getUnit();
        if (parameter instanceof GenericValue && ((GenericValue) parameter).getMinValue() instanceof Integer && ((GenericValue<Integer>) parameter).getMinValue() < 0) {
            unit += '-';
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
                parameter = volumeLeft;
                break;
            case 3:
                parameter = volumeRight;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public int getVolumeLeft() {
        return volumeLeft.getValue();
    }

    public void setVolumeLeft(int volumeLeft) {
        this.volumeLeft.setValue(volumeLeft);
    }

    public int getVolumeRight() {
        return volumeRight.getValue();
    }

    public void setVolumeRight(int volumeRight) {
        this.volumeRight.setValue(volumeRight);
    }
}
