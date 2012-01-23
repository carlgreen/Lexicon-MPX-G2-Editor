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

package info.carlwithak.mpxg2.model.effects;

import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Base class for Effect 1 and 2 effects.
 *
 * @author Carl Green
 */
public abstract class Effect implements EffectObject {
    public final GenericValue<Integer> mix = new GenericValue<Integer>("Mix", "%", 0, 100);
    public final GenericValue<Integer> level = new GenericValue<Integer>("Level", "dB", -90, 6);

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = mix;
                break;
            case 1:
                parameter = level;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

}
