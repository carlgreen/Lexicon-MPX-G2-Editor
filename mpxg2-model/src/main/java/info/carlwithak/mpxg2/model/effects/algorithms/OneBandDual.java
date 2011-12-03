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
 * Class for 1-Band (D) parameters.
 *
 * @author Carl Green
 */
public class OneBandDual extends Eq {
    private static final String NAME = "1-Band (D)";

    private GenericValue<Integer> gainLeft = new GenericValue<Integer>("Gain", "dB", -72, 24);
    private GenericValue<Integer> fcLeft = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Double> qLeft = new GenericValue<Double>("Q", "", 0.1, 10.0);
    private GenericValue<Integer> modeLeft = new GenericValue<Integer>("Mode", "", 0, 2);
    private GenericValue<Integer> gainRight = new GenericValue<Integer>("Gain", "dB", -72, 24);
    private GenericValue<Integer> fcRight = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Double> qRight = new GenericValue<Double>("Q", "", 0.1, 10.0);
    private GenericValue<Integer> modeRight = new GenericValue<Integer>("Mode", "", 0, 2);

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
                parameter = gainLeft;
                break;
            case 3:
                parameter = fcLeft;
                break;
            case 4:
                parameter = qLeft;
                break;
            case 5:
                parameter = modeLeft;
                break;
            case 6:
                parameter = gainRight;
                break;
            case 7:
                parameter = fcRight;
                break;
            case 8:
                parameter = qRight;
                break;
            case 9:
                parameter = modeRight;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getGainLeft() {
        return gainLeft;
    }

    public void setGainLeft(final int gainLeft) {
        this.gainLeft.setValue(gainLeft);
    }

    public GenericValue<Integer> getFcLeft() {
        return fcLeft;
    }

    public void setFcLeft(final int fcLeft) {
        this.fcLeft.setValue(fcLeft);
    }

    public GenericValue<Double> getQLeft() {
        return qLeft;
    }

    public void setQLeft(final double qLeft) {
        this.qLeft.setValue(qLeft);
    }

    public GenericValue<Integer> getModeLeft() {
        return modeLeft;
    }

    public void setModeLeft(final int modeLeft) {
        this.modeLeft.setValue(modeLeft);
    }

    public GenericValue<Integer> getGainRight() {
        return gainRight;
    }

    public void setGainRight(final int gainRight) {
        this.gainRight.setValue(gainRight);
    }

    public GenericValue<Integer> getFcRight() {
        return fcRight;
    }

    public void setFcRight(final int fcRight) {
        this.fcRight.setValue(fcRight);
    }

    public GenericValue<Double> getQRight() {
        return qRight;
    }

    public void setQRight(final double qRight) {
        this.qRight.setValue(qRight);
    }

    public GenericValue<Integer> getModeRight() {
        return modeRight;
    }

    public void setModeRight(final int modeRight) {
        this.modeRight.setValue(modeRight);
    }
}
