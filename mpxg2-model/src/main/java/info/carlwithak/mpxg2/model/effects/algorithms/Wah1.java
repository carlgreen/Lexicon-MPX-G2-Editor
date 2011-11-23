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
 * Class for Wah 1 parameters.
 *
 * @author Carl Green
 */
public class Wah1 extends Effect {
    private static final String NAME = "Wah  1";

    private GenericValue<Integer> sweep = new GenericValue<Integer>("Sweep", "", 0, 100);
    private GenericValue<Integer> bass = new GenericValue<Integer>("Bass", "", 0, 100);
    private int type;
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

    public void setSweep(int sweep) {
        this.sweep.setValue(sweep);
    }

    public GenericValue<Integer> getBass() {
        return bass;
    }

    public void setBass(int bass) {
        this.bass.setValue(bass);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public GenericValue<Integer> getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response.setValue(response);
    }

    public GenericValue<Integer> getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain.setValue(gain);
    }
}
