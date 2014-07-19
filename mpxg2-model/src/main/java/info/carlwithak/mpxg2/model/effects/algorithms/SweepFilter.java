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
import info.carlwithak.mpxg2.model.parameters.PanValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class for SweepFilter parameters.
 *
 * @author Carl Green
 */
public class SweepFilter extends Effect {
    private static final String NAME = "SweepFilter";

    public final GenericValue<Integer> fc = new GenericValue<>("Fc", "Hz", 20, 20000);
    public final GenericValue<Integer> fRes = new GenericValue<>("FRes", "", 1, 100);
    public final GenericValue<Integer> mod = new GenericValue<>("Mod", "Hz", 20, 20000);
    public final GenericValue<Integer> scale = new GenericValue<>("Scale", "%", -100, 100);
    public final PanValue pan = new PanValue("Pan", -50, 50);

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
                parameter = fc;
                break;
            case 3:
                parameter = fRes;
                break;
            case 4:
                parameter = mod;
                break;
            case 5:
                parameter = scale;
                break;
            case 6:
                parameter = pan;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

}
