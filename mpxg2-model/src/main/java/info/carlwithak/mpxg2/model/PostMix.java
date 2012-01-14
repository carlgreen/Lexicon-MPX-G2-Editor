/*
 *  Copyright (C) 2012 Carl Green
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

package info.carlwithak.mpxg2.model;

import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 *
 * @author Carl Green
 */
public class PostMix implements DataObject {
    private GenericValue<Integer> postMix = new GenericValue<Integer>("Mix", "%", 0, 100);
    private GenericValue<Integer> postLevel = new GenericValue<Integer>("Level", "dB", -90, 6);
    private GenericValue<Integer> postBypassLevel = new GenericValue<Integer>("Bypass Level", "dB", -90, 6);

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = postMix;
                break;
            case 1:
                parameter = postLevel;
                break;
            case 2:
                parameter = postBypassLevel;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getPostMix() {
        return postMix;
    }

    public GenericValue<Integer> getPostLevel() {
        return postLevel;
    }

    public GenericValue<Integer> getPostBypassLevel() {
        return postBypassLevel;
    }

}
