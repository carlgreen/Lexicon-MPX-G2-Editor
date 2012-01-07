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
import info.carlwithak.mpxg2.model.parameters.Rate;

/**
 * Class to hold information about the Random controller.
 *
 * @author Carl Green
 */
public class Random implements DataObject {
    private GenericValue<Integer> low = new GenericValue<Integer>("RndLo", "", 0, 127);
    private GenericValue<Integer> high = new GenericValue<Integer>("RndHi", "", 0, 127);
    private Rate rate;

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = low;
                break;
            case 1:
                parameter = high;
                break;
            case 2:
                parameter = rate;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low.setValue(low);
    }

    public GenericValue<Integer> getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high.setValue(high);
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

}
