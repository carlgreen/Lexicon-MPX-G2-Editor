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
import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class for Shift (D) parameters.
 *
 * @author Carl Green
 */
public class ShiftDual extends Effect {
    private static final String NAME = "Shift (D)";

    public final GenericValue<Integer> tune1 = new GenericValue<>("Tune1", "", -4800, 1900); // cents
    public final GenericValue<Integer> optimize = new GenericValue<>("Optimize", "", 0, 100);
    public final GenericValue<Integer> tune2 = new GenericValue<>("Tune2", "", -4800, 1900); // cents
    public final OnOffValue glide = new OnOffValue("Glide");

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
                parameter = tune1;
                break;
            case 3:
                parameter = tune2;
                break;
            case 4:
                parameter = glide;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

}
