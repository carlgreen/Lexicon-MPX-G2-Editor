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
import info.carlwithak.mpxg2.model.parameters.WahType;

/**
 * Class for Wah 2 parameters.
 *
 * @author Carl Green
 */
public class Wah2 extends Effect {
    private static final String NAME = "Wah  2";

    private GenericValue<Integer> sweep = new GenericValue<Integer>("Sweep", "", 0, 100);
    private GenericValue<Integer> bass = new GenericValue<Integer>("Bass", "", 0, 100);
    private WahType type = new WahType();
    private GenericValue<Integer> response = new GenericValue<Integer>("Resp", "", 0, 100);
    private GenericValue<Integer> gain = new GenericValue<Integer>("Gain", "dB", -72, 24);

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

    public GenericValue<Integer> getSweep() {
        return sweep;
    }

    public GenericValue<Integer> getBass() {
        return bass;
    }

    public WahType getType() {
        return type;
    }

    public GenericValue<Integer> getResponse() {
        return response;
    }

    public GenericValue<Integer> getGain() {
        return gain;
    }

}
