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

import info.carlwithak.mpxg2.model.effects.Effect;

/**
 * Class for Blue Comp parameters.
 *
 * @author Carl Green
 */
public class BlueComp extends Effect {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Sense", "Thrsh", "Gain", "ATime", "RTime"
    };
    private static final String[] PARAMETER_UNITS = {
        "%", "dB", "dB", "dB", "dB", "ms", "ms"
    };

    private int sensitivity;
    private int threshold;
    private int gain;
    private int attackTime;
    private int releaseTime;

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
    }

    @Override
    public String getParameterUnit(final int parameterIndex) {
        return PARAMETER_UNITS[parameterIndex];
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(final int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(final int threshold) {
        this.threshold = threshold;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(final int gain) {
        this.gain = gain;
    }

    public int getAttackTime() {
        return attackTime;
    }

    public void setAttackTime(final int attackTime) {
        this.attackTime = attackTime;
    }

    public int getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(final int releaseTime) {
        this.releaseTime = releaseTime;
    }
}
