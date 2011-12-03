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

import info.carlwithak.mpxg2.model.GenericValue;
import info.carlwithak.mpxg2.model.Parameter;
import info.carlwithak.mpxg2.model.effects.Effect;

/**
 * Class for DigiDrive2 parameters.
 *
 * @author Carl Green
 */
public class DigiDrive2 extends Effect {
    private static final String NAME = "DigiDrive2";

    private GenericValue<Integer> drive = new GenericValue<Integer>("Drive", "", 0, 100);
    private GenericValue<Integer> low = new GenericValue<Integer>("Low", "dB", -72, 24);
    private GenericValue<Integer> mid = new GenericValue<Integer>("Mid", "dB", -72, 24);
    private GenericValue<Integer> high = new GenericValue<Integer>("High", "dB", -72, 24);

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
                parameter = drive;
                break;
            case 3:
                parameter = low;
                break;
            case 4:
                parameter = mid;
                break;
            case 5:
                parameter = high;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getDrive() {
        return drive;
    }

    public void setDrive(int drive) {
        this.drive.setValue(drive);
    }

    public GenericValue<Integer> getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low.setValue(low);
    }

    public GenericValue<Integer> getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid.setValue(mid);
    }

    public GenericValue<Integer> getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high.setValue(high);
    }
}
