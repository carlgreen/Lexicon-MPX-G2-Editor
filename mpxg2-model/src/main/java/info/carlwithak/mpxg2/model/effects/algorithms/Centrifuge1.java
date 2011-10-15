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

import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.effects.Chorus;

/**
 * Class for Centrifuge1 parameters.
 *
 * @author Carl Green
 */
public class Centrifuge1 extends Chorus {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Rate1", "PW 1", "Sync", "Dpth1", "Rate2", "PW 2", "Dpth2", "Res"
    };
    private static final String[] PARAMETER_UNITS = {
        "%", "-dB", "100Hz", "%", "-", "%", "100Hz", "%", "-", "%", ""
    };

    private Rate rate1;
    private int pulseWidth1;
    private int sync1;
    private int depth1;
    private Rate rate2;
    private int pulseWidth2;
    private int sync2;
    private int depth2;
    private int resonance;

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
    }

    @Override
    public String getParameterUnit(final int parameterIndex) {
        return PARAMETER_UNITS[parameterIndex];
    }

    public Rate getRate1() {
        return rate1;
    }

    public void setRate1(Rate rate1) {
        this.rate1 = rate1;
    }

    public int getPulseWidth1() {
        return pulseWidth1;
    }

    public void setPulseWidth1(int pulseWidth1) {
        this.pulseWidth1 = pulseWidth1;
    }

    public int getSync1() {
        return sync1;
    }

    public void setSync1(int sync1) {
        this.sync1 = sync1;
    }

    public int getDepth1() {
        return depth1;
    }

    public void setDepth1(int depth1) {
        this.depth1 = depth1;
    }

    public Rate getRate2() {
        return rate2;
    }

    public void setRate2(Rate rate2) {
        this.rate2 = rate2;
    }

    public int getPulseWidth2() {
        return pulseWidth2;
    }

    public void setPulseWidth2(int pulseWidth2) {
        this.pulseWidth2 = pulseWidth2;
    }

    public int getSync2() {
        return sync2;
    }

    public void setSync2(int sync2) {
        this.sync2 = sync2;
    }

    public int getDepth2() {
        return depth2;
    }

    public void setDepth2(int depth2) {
        this.depth2 = depth2;
    }

    public int getResonance() {
        return resonance;
    }

    public void setResonance(int resonance) {
        this.resonance = resonance;
    }
}