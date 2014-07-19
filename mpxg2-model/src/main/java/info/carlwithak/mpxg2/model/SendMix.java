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
public class SendMix implements DataObject {
    private final GenericValue<Integer> sendLevel = new GenericValue<>("Level", "", -56, 0);
    private final GenericValue<Integer> sendBypassLevel = new GenericValue<>("Bypass Level", "", -56, 0);

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = sendLevel;
                break;
            case 1:
                parameter = sendBypassLevel;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getSendLevel() {
        return sendLevel;
    }

    public GenericValue<Integer> getSendBypassLevel() {
        return sendBypassLevel;
    }

}
