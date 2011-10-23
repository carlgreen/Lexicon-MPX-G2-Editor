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
import info.carlwithak.mpxg2.model.effects.Eq;

/**
 * Class for 1-Band (M) parameters.
 *
 * @author Carl Green
 */
public class OneBandMono extends Eq {
    private GenericValue<Integer> gain = new GenericValue<Integer>("dB", -72, 24);
    private GenericValue<Integer> fc = new GenericValue<Integer>("Hz", 20, 20000);
    private GenericValue<Double> q = new GenericValue<Double>("", 0.1, 10.0);
    private GenericValue<Integer> mode = new GenericValue<Integer>("", 0, 2);

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
            case 1:
                parameter = super.getParameter(parameterIndex);
                break;
            case 2:
                parameter = gain;
                break;
            case 3:
                parameter = fc;
                break;
            case 4:
                parameter = q;
                break;
            case 5:
                parameter = mode;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public int getGain() {
        return gain.getValue();
    }

    public void setGain(final int gain) {
        this.gain.setValue(gain);
    }

    public int getFc() {
        return fc.getValue();
    }

    public void setFc(final int fc) {
        this.fc.setValue(fc);
    }

    public double getQ() {
        return q.getValue();
    }

    public void setQ(final double q) {
        this.q.setValue(q);
    }

    public int getMode() {
        return mode.getValue();
    }

    public void setMode(final int mode) {
        this.mode.setValue(mode);
    }
}
