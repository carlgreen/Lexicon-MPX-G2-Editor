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

import info.carlwithak.mpxg2.model.effects.Eq;
import info.carlwithak.mpxg2.model.parameters.EqModeValue;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class for 2-Band (M) parameters.
 *
 * @author Carl Green
 */
public class TwoBandMono extends Eq {
    private static final String NAME = "2-Band (M)";

    private GenericValue<Integer> gain1 = new GenericValue<Integer>("Gain1", "dB", -72, 24);
    private GenericValue<Integer> gain2 = new GenericValue<Integer>("Gain2", "dB", -72, 24);
    private GenericValue<Integer> fc1 = new GenericValue<Integer>("Fc 1", "Hz", 20, 20000);
    private GenericValue<Integer> fc2 = new GenericValue<Integer>("Fc 2", "Hz", 20, 20000);
    private GenericValue<Double> q1 = new GenericValue<Double>("Q 1", "", 0.1, 10.0);
    private GenericValue<Double> q2 = new GenericValue<Double>("Q 2", "", 0.1, 10.0);
    private EqModeValue mode1 = new EqModeValue("Mode1");
    private EqModeValue mode2 = new EqModeValue("Mode2");

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
                parameter = gain1;
                break;
            case 3:
                parameter = gain2;
                break;
            case 4:
                parameter = fc1;
                break;
            case 5:
                parameter = fc2;
                break;
            case 6:
                parameter = q1;
                break;
            case 7:
                parameter = q2;
                break;
            case 8:
                parameter = mode1;
                break;
            case 9:
                parameter = mode2;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getGain1() {
        return gain1;
    }

    public GenericValue<Integer> getGain2() {
        return gain2;
    }

    public GenericValue<Integer> getFc1() {
        return fc1;
    }

    public GenericValue<Integer> getFc2() {
        return fc2;
    }

    public GenericValue<Double> getQ1() {
        return q1;
    }

    public GenericValue<Double> getQ2() {
        return q2;
    }

    public EqModeValue getMode1() {
        return mode1;
    }

    public EqModeValue getMode2() {
        return mode2;
    }

}
