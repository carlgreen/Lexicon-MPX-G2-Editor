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
 * Class for Detune (S) parameters.
 *
 * @author Carl Green
 */
public class DetuneStereo extends Effect {
    private static final String NAME = "Detune (S)";

    private GenericValue<Integer> tune = new GenericValue<Integer>("Tune", "", 0, 100);
    private GenericValue<Integer> optimize = new GenericValue<Integer>("Optimize", "ms", 10, 40);
    private GenericValue<Integer> preDelay = new GenericValue<Integer>("P Dly", "ms", 0, 25);

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

    public GenericValue<Integer> getTune() {
        return tune;
    }

    public void setTune(int tune) {
        this.tune.setValue(tune);
    }

    public GenericValue<Integer> getOptimize() {
        return optimize;
    }

    public void setOptimize(int optimize) {
        this.optimize.setValue(optimize);
    }

    public GenericValue<Integer> getPreDelay() {
        return preDelay;
    }

    public void setPreDelay(int preDelay) {
        this.preDelay.setValue(preDelay);
    }
}
