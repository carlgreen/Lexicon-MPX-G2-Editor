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
import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.effects.Chorus;

/**
 * Class for Flanger (M) parameters.
 *
 * @author Carl Green
 */
public class FlangerMono extends Chorus {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Rate", "PW", "Depth", "Res", "Blend"
    };

    private Rate rate;
    private GenericValue<Integer> pulseWidth = new GenericValue<Integer>("%", 0, 100);
    private GenericValue<Integer> depth = new GenericValue<Integer>("%", 0, 100);
    private GenericValue<Integer> resonance = new GenericValue<Integer>("", -100, 100);
    private GenericValue<Integer> blend = new GenericValue<Integer>("%", 0, 100);

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
                parameter = rate;
                break;
            case 3:
                parameter = pulseWidth;
                break;
            case 4:
                parameter = depth;
                break;
            case 5:
                parameter = resonance;
                break;
            case 6:
                parameter = blend;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public int getPulseWidth() {
        return pulseWidth.getValue();
    }

    public void setPulseWidth(int pulseWidth) {
        this.pulseWidth.setValue(pulseWidth);
    }

    public int getDepth() {
        return depth.getValue();
    }

    public void setDepth(int depth) {
        this.depth.setValue(depth);
    }

    public int getResonance() {
        return resonance.getValue();
    }

    public void setResonance(int resonance) {
        this.resonance.setValue(resonance);
    }

    public int getBlend() {
        return blend.getValue();
    }

    public void setBlend(int blend) {
        this.blend.setValue(blend);
    }
}
