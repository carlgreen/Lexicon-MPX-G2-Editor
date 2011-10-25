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
 * Class for Wah 2 parameters.
 *
 * @author Carl Green
 */
public class Wah2 extends Effect {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Sweep", "Bass", "Resp", "Gain"
    };

    private GenericValue<Integer> sweep = new GenericValue<Integer>("", 0, 100);
    private GenericValue<Integer> bass = new GenericValue<Integer>("", 0, 100);
    private int type;
    private GenericValue<Integer> response = new GenericValue<Integer>("", 0, 100);
    private GenericValue<Integer> gain = new GenericValue<Integer>("dB", -72, 24);

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
                parameter = sweep;
                break;
            case 3:
                parameter = bass;
                break;
            case 4:
                parameter = response;
                break;
            case 5:
                parameter = gain;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public int getSweep() {
        return sweep.getValue();
    }

    public void setSweep(int sweep) {
        this.sweep.setValue(sweep);
    }

    public int getBass() {
        return bass.getValue();
    }

    public void setBass(int bass) {
        this.bass.setValue(bass);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getResponse() {
        return response.getValue();
    }

    public void setResponse(int response) {
        this.response.setValue(response);
    }

    public int getGain() {
        return gain.getValue();
    }

    public void setGain(int gain) {
        this.gain.setValue(gain);
    }
}
