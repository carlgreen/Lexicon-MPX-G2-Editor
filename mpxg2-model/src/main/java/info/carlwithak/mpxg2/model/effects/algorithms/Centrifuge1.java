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
import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.effects.Chorus;

/**
 * Class for Centrifuge1 parameters.
 *
 * @author Carl Green
 */
public class Centrifuge1 extends Chorus {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Rate1", "PW 1", "Sync", "Dpth1", "Rate2", "PW 2", "Sync2", "Dpth2", "Res"
    };

    private Rate rate1;
    private GenericValue<Integer> pulseWidth1 = new GenericValue<Integer>("PW 1", "%", 0, 100);
    private GenericValue<Integer> sync1 = new GenericValue<Integer>("Sync1", "", -120, 120);
    private GenericValue<Integer> depth1 = new GenericValue<Integer>("Dpth1", "%", 0, 100);
    private Rate rate2;
    private GenericValue<Integer> pulseWidth2 = new GenericValue<Integer>("PW 2", "%", 0, 100);
    private GenericValue<Integer> sync2 = new GenericValue<Integer>("Sync2", "", -120, 120);
    private GenericValue<Integer> depth2 = new GenericValue<Integer>("Dpth2", "%", 0, 100);
    private GenericValue<Integer> resonance = new GenericValue<Integer>("Res", "", -100, 100);

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
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
                parameter = rate1;
                break;
            case 3:
                parameter = pulseWidth1;
                break;
            case 4:
                parameter = sync1;
                break;
            case 5:
                parameter = depth1;
                break;
            case 6:
                parameter = rate2;
                break;
            case 7:
                parameter = pulseWidth2;
                break;
            case 8:
                parameter = sync2;
                break;
            case 9:
                parameter = depth2;
                break;
            case 10:
                parameter = resonance;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public Rate getRate1() {
        return rate1;
    }

    public void setRate1(Rate rate1) {
        this.rate1 = rate1;
    }

    public int getPulseWidth1() {
        return pulseWidth1.getValue();
    }

    public void setPulseWidth1(int pulseWidth1) {
        this.pulseWidth1.setValue(pulseWidth1);
    }

    public int getSync1() {
        return sync1.getValue();
    }

    public void setSync1(int sync1) {
        this.sync1.setValue(sync1);
    }

    public int getDepth1() {
        return depth1.getValue();
    }

    public void setDepth1(int depth1) {
        this.depth1.setValue(depth1);
    }

    public Rate getRate2() {
        return rate2;
    }

    public void setRate2(Rate rate2) {
        this.rate2 = rate2;
    }

    public int getPulseWidth2() {
        return pulseWidth2.getValue();
    }

    public void setPulseWidth2(int pulseWidth2) {
        this.pulseWidth2.setValue(pulseWidth2);
    }

    public int getSync2() {
        return sync2.getValue();
    }

    public void setSync2(int sync2) {
        this.sync2.setValue(sync2);
    }

    public int getDepth2() {
        return depth2.getValue();
    }

    public void setDepth2(int depth2) {
        this.depth2.setValue(depth2);
    }

    public int getResonance() {
        return resonance.getValue();
    }

    public void setResonance(int resonance) {
        this.resonance.setValue(resonance);
    }
}