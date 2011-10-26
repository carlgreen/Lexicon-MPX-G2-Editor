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
 * Class for Detune (M) parameters.
 *
 * @author Carl Green
 */
public class DetuneMono extends Chorus {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Tune", "P Dly"
    };

    private GenericValue<Integer> tune = new GenericValue<Integer>("", 0, 100);
    private int optimize;
    private GenericValue<Integer> preDelay = new GenericValue<Integer>("ms", 0, 35);

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
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
                parameter = tune;
                break;
            case 3:
                parameter = preDelay;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public int getTune() {
        return tune.getValue();
    }

    public void setTune(int tune) {
        this.tune.setValue(tune);
    }

    public int getOptimize() {
        return optimize;
    }

    public void setOptimize(int optimize) {
        this.optimize = optimize;
    }

    public int getPreDelay() {
        return preDelay.getValue();
    }

    public void setPreDelay(int preDelay) {
        this.preDelay.setValue(preDelay);
    }
}
