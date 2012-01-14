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
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class for 4-Band (M) parameters.
 *
 * @author Carl Green
 */
public class FourBandMono extends Eq {
    private static final String NAME = "4-Band (M)";

    private GenericValue<Integer> gain1 = new GenericValue<Integer>("Gain", "dB", -72, 24);
    private GenericValue<Integer> gain2 = new GenericValue<Integer>("Gain", "dB", -72, 24);
    private GenericValue<Integer> gain3 = new GenericValue<Integer>("Gain", "dB", -72, 24);
    private GenericValue<Integer> gain4 = new GenericValue<Integer>("Gain", "dB", -72, 24);
    private GenericValue<Integer> fc1 = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Integer> fc2 = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Integer> fc3 = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Integer> fc4 = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Double> q1 = new GenericValue<Double>("Q", "", 0.1, 10.0);
    private GenericValue<Double> q2 = new GenericValue<Double>("Q", "", 0.1, 10.0);
    private GenericValue<Double> q3 = new GenericValue<Double>("Q", "", 0.1, 10.0);
    private GenericValue<Double> q4 = new GenericValue<Double>("Q", "", 0.1, 10.0);
    private GenericValue<Integer> mode1 = new GenericValue<Integer>("Mode", "", 0, 2);
    private GenericValue<Integer> mode2 = new GenericValue<Integer>("Mode", "", 0, 2);
    private GenericValue<Integer> mode3 = new GenericValue<Integer>("Mode", "", 0, 2);
    private GenericValue<Integer> mode4 = new GenericValue<Integer>("Mode", "", 0, 2);

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
                parameter = gain3;
                break;
            case 5:
                parameter = gain4;
                break;
            case 6:
                parameter = fc1;
                break;
            case 7:
                parameter = fc2;
                break;
            case 8:
                parameter = fc3;
                break;
            case 9:
                parameter = fc4;
                break;
            case 10:
                parameter = q1;
                break;
            case 11:
                parameter = q2;
                break;
            case 12:
                parameter = q3;
                break;
            case 13:
                parameter = q4;
                break;
            case 14:
                parameter = mode1;
                break;
            case 15:
                parameter = mode2;
                break;
            case 16:
                parameter = mode3;
                break;
            case 17:
                parameter = mode4;
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

    public GenericValue<Integer> getGain3() {
        return gain3;
    }

    public GenericValue<Integer> getGain4() {
        return gain4;
    }

    public GenericValue<Integer> getFc1() {
        return fc1;
    }

    public GenericValue<Integer> getFc2() {
        return fc2;
    }

    public GenericValue<Integer> getFc3() {
        return fc3;
    }

    public GenericValue<Integer> getFc4() {
        return fc4;
    }

    public GenericValue<Double> getQ1() {
        return q1;
    }

    public GenericValue<Double> getQ2() {
        return q2;
    }

    public GenericValue<Double> getQ3() {
        return q3;
    }

    public GenericValue<Double> getQ4() {
        return q4;
    }

    public GenericValue<Integer> getMode1() {
        return mode1;
    }

    public GenericValue<Integer> getMode2() {
        return mode2;
    }

    public GenericValue<Integer> getMode3() {
        return mode3;
    }

    public GenericValue<Integer> getMode4() {
        return mode4;
    }

}
