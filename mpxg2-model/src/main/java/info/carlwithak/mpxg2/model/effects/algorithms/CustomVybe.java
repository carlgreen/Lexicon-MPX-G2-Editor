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
import info.carlwithak.mpxg2.model.parameters.Rate;

/**
 * Class for Custom Vybe parameters.
 *
 * @author Carl Green
 */
public class CustomVybe extends Effect {
    private static final String NAME = "Custom Vybe";

    private Rate rate;
    private GenericValue<Integer> pulseWidth = new GenericValue<Integer>("PW", "%", 0, 100);
    private GenericValue<Integer> depth = new GenericValue<Integer>("Depth", "%", 0, 100);

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
                parameter = rate;
                break;
            case 3:
                parameter = pulseWidth;
                break;
            case 4:
                parameter = depth;
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

    public GenericValue<Integer> getPulseWidth() {
        return pulseWidth;
    }

    public GenericValue<Integer> getDepth() {
        return depth;
    }

}
