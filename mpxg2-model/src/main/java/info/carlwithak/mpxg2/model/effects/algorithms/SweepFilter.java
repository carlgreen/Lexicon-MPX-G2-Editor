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
 * Class for SweepFilter parameters.
 *
 * @author Carl Green
 */
public class SweepFilter extends Effect {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Fc", "FRes", "Mod", "Scale", "Pan"
    };
    private static final String[] PARAMETER_UNITS = {
        "%", "dB", "Hz", "", "Hz", "-%", "Pan"
    };

    private int fc;
    private int fRes;
    private int mod;
    private int scale;
    private int pan;

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
    }

    @Override
    public String getParameterUnit(final int parameterIndex) {
        return PARAMETER_UNITS[parameterIndex];
    }

    public int getFc() {
        return fc;
    }

    public void setFc(final int fc) {
        this.fc = fc;
    }

    public int getFRes() {
        return fRes;
    }

    public void setFRes(final int fRes) {
        this.fRes = fRes;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(final int mod) {
        this.mod = mod;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(final int scale) {
        this.scale = scale;
    }

    public int getPan() {
        return pan;
    }

    public void setPan(final int pan) {
        this.pan = pan;
    }

}
