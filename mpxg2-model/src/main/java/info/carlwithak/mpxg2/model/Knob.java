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

package info.carlwithak.mpxg2.model;

import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;
import info.carlwithak.mpxg2.model.parameters.TextValue;

/**
 *
 * @author Carl Green
 */
public class Knob implements DataObject {
    private final GenericValue<Integer> value = new GenericValue<Integer>("Value", "", 0, 127);
    private final GenericValue<Integer> low = new GenericValue<Integer>("Low", "", 0, 127);
    private final GenericValue<Integer> high = new GenericValue<Integer>("High", "", 0, 127);
    private final TextValue name = new TextValue("Name", 12);

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = value;
                break;
            case 1:
                parameter = low;
                break;
            case 2:
                parameter = high;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getValue() {
        return value;
    }

    public GenericValue<Integer> getLow() {
        return low;
    }

    public GenericValue<Integer> getHigh() {
        return high;
    }

    public TextValue getName() {
        return name;
    }

}
