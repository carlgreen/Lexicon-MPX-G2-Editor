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

    public int getGain1() {
        return gain1.getValue();
    }

    public void setGain1(final int gain1) {
        this.gain1.setValue(gain1);
    }

    public int getGain2() {
        return gain2.getValue();
    }

    public void setGain2(final int gain2) {
        this.gain2.setValue(gain2);
    }

    public int getGain3() {
        return gain3.getValue();
    }

    public void setGain3(final int gain3) {
        this.gain3.setValue(gain3);
    }

    public int getGain4() {
        return gain4.getValue();
    }

    public void setGain4(final int gain4) {
        this.gain4.setValue(gain4);
    }

    public int getFc1() {
        return fc1.getValue();
    }

    public void setFc1(final int fc1) {
        this.fc1.setValue(fc1);
    }

    public int getFc2() {
        return fc2.getValue();
    }

    public void setFc2(final int fc2) {
        this.fc2.setValue(fc2);
    }

    public int getFc3() {
        return fc3.getValue();
    }

    public void setFc3(final int fc3) {
        this.fc3.setValue(fc3);
    }

    public int getFc4() {
        return fc4.getValue();
    }

    public void setFc4(final int fc4) {
        this.fc4.setValue(fc4);
    }

    public double getQ1() {
        return q1.getValue();
    }

    public void setQ1(final double q1) {
        this.q1.setValue(q1);
    }

    public double getQ2() {
        return q2.getValue();
    }

    public void setQ2(final double q2) {
        this.q2.setValue(q2);
    }

    public double getQ3() {
        return q3.getValue();
    }

    public void setQ3(final double q3) {
        this.q3.setValue(q3);
    }

    public double getQ4() {
        return q4.getValue();
    }

    public void setQ4(final double q4) {
        this.q4.setValue(q4);
    }

    public int getMode1() {
        return mode1.getValue();
    }

    public void setMode1(final int mode1) {
        this.mode1.setValue(mode1);
    }

    public int getMode2() {
        return mode2.getValue();
    }

    public void setMode2(final int mode2) {
        this.mode2.setValue(mode2);
    }

    public int getMode3() {
        return mode3.getValue();
    }

    public void setMode3(final int mode3) {
        this.mode3.setValue(mode3);
    }

    public int getMode4() {
        return mode4.getValue();
    }

    public void setMode4(final int mode4) {
        this.mode4.setValue(mode4);
    }
}
