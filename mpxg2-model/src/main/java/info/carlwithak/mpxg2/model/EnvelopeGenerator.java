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

import info.carlwithak.mpxg2.model.parameters.EnvelopeGeneratorSourceValue;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class to hold information about the Envelope Generator controller.
 *
 * @author Carl Green
 */
public class EnvelopeGenerator implements DataObject {
    private final EnvelopeGeneratorSourceValue src1 = new EnvelopeGeneratorSourceValue("Src1");
    private final EnvelopeGeneratorSourceValue src2 = new EnvelopeGeneratorSourceValue("Src2");
    private final GenericValue<Integer> aTrim = new GenericValue<>("ATrim", "", 0, 100);
    private final GenericValue<Integer> response = new GenericValue<>("Resp", "", 0, 100);

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = src1;
                break;
            case 1:
                parameter = src2;
                break;
            case 2:
                parameter = aTrim;
                break;
            case 3:
                parameter = response;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public EnvelopeGeneratorSourceValue getSrc1() {
        return src1;
    }

    public EnvelopeGeneratorSourceValue getSrc2() {
        return src2;
    }

    public GenericValue<Integer> getATrim() {
        return aTrim;
    }

    public GenericValue<Integer> getResponse() {
        return response;
    }

}
