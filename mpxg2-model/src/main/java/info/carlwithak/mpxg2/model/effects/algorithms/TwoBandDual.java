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
 * Class for 2-Band (D) parameters.
 *
 * @author Carl Green
 */
public class TwoBandDual extends Eq {
    private static final String NAME = "2-Band (D)";

    private GenericValue<Integer> gainLeft1 = new GenericValue<Integer>("Gain", "dB", -72, 24);
    private GenericValue<Integer> gainLeft2 = new GenericValue<Integer>("Gain", "dB", -72, 24);
    private GenericValue<Integer> fcLeft1 = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Integer> fcLeft2 = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Double> qLeft1 = new GenericValue<Double>("Q", "", 0.1, 10.0);
    private GenericValue<Double> qLeft2 = new GenericValue<Double>("Q", "", 0.1, 10.0);
    private GenericValue<Integer> modeLeft1 = new GenericValue<Integer>("Mode", "", 0, 2);
    private GenericValue<Integer> modeLeft2 = new GenericValue<Integer>("Mode", "", 0, 2);
    private GenericValue<Integer> gainRight1 = new GenericValue<Integer>("Gain", "dB", -72, 24);
    private GenericValue<Integer> gainRight2 = new GenericValue<Integer>("Gain", "dB", -72, 24);
    private GenericValue<Integer> fcRight1 = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Integer> fcRight2 = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Double> qRight1 = new GenericValue<Double>("Q", "", 0.1, 10.0);
    private GenericValue<Double> qRight2 = new GenericValue<Double>("Q", "", 0.1, 10.0);
    private GenericValue<Integer> modeRight1 = new GenericValue<Integer>("Mode", "", 0, 2);
    private GenericValue<Integer> modeRight2 = new GenericValue<Integer>("Mode", "", 0, 2);

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
                parameter = gainLeft1;
                break;
            case 3:
                parameter = gainLeft2;
                break;
            case 4:
                parameter = fcLeft1;
                break;
            case 5:
                parameter = fcLeft2;
                break;
            case 6:
                parameter = qLeft1;
                break;
            case 7:
                parameter = qLeft2;
                break;
            case 8:
                parameter = modeLeft1;
                break;
            case 9:
                parameter = modeLeft2;
                break;
            case 10:
                parameter = gainRight1;
                break;
            case 11:
                parameter = gainRight2;
                break;
            case 12:
                parameter = fcRight1;
                break;
            case 13:
                parameter = fcRight2;
                break;
            case 14:
                parameter = qRight1;
                break;
            case 15:
                parameter = qRight2;
                break;
            case 16:
                parameter = modeRight1;
                break;
            case 17:
                parameter = modeRight2;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getGainLeft1() {
        return gainLeft1;
    }

    public void setGainLeft1(final int gainLeft1) {
        this.gainLeft1.setValue(gainLeft1);
    }

    public GenericValue<Integer> getGainLeft2() {
        return gainLeft2;
    }

    public void setGainLeft2(final int gainLeft2) {
        this.gainLeft2.setValue(gainLeft2);
    }

    public GenericValue<Integer> getFcLeft1() {
        return fcLeft1;
    }

    public void setFcLeft1(final int fcLeft1) {
        this.fcLeft1.setValue(fcLeft1);
    }

    public GenericValue<Integer> getFcLeft2() {
        return fcLeft2;
    }

    public void setFcLeft2(final int fcLeft2) {
        this.fcLeft2.setValue(fcLeft2);
    }

    public GenericValue<Double> getQLeft1() {
        return qLeft1;
    }

    public void setQLeft1(final double qLeft1) {
        this.qLeft1.setValue(qLeft1);
    }

    public GenericValue<Double> getQLeft2() {
        return qLeft2;
    }

    public void setQLeft2(final double qLeft2) {
        this.qLeft2.setValue(qLeft2);
    }

    public GenericValue<Integer> getModeLeft1() {
        return modeLeft1;
    }

    public void setModeLeft1(final int modeLeft1) {
        this.modeLeft1.setValue(modeLeft1);
    }

    public GenericValue<Integer> getModeLeft2() {
        return modeLeft2;
    }

    public void setModeLeft2(final int modeLeft2) {
        this.modeLeft2.setValue(modeLeft2);
    }

    public GenericValue<Integer> getGainRight1() {
        return gainRight1;
    }

    public void setGainRight1(final int gainRight1) {
        this.gainRight1.setValue(gainRight1);
    }

    public GenericValue<Integer> getGainRight2() {
        return gainRight2;
    }

    public void setGainRight2(final int gainRight2) {
        this.gainRight2.setValue(gainRight2);
    }

    public GenericValue<Integer> getFcRight1() {
        return fcRight1;
    }

    public void setFcRight1(final int fcRight1) {
        this.fcRight1.setValue(fcRight1);
    }

    public GenericValue<Integer> getFcRight2() {
        return fcRight2;
    }

    public void setFcRight2(final int fcRight2) {
        this.fcRight2.setValue(fcRight2);
    }

    public GenericValue<Double> getQRight1() {
        return qRight1;
    }

    public void setQRight1(final double qRight1) {
        this.qRight1.setValue(qRight1);
    }

    public GenericValue<Double> getQRight2() {
        return qRight2;
    }

    public void setQRight2(final double qRight2) {
        this.qRight2.setValue(qRight2);
    }

    public GenericValue<Integer> getModeRight1() {
        return modeRight1;
    }

    public void setModeRight1(final int modeRight1) {
        this.modeRight1.setValue(modeRight1);
    }

    public GenericValue<Integer> getModeRight2() {
        return modeRight2;
    }

    public void setModeRight2(final int modeRight2) {
        this.modeRight2.setValue(modeRight2);
    }
}
