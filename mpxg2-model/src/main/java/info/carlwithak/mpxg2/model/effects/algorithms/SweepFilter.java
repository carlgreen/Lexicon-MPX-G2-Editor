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

    private GenericValue<Integer> fc = new GenericValue<Integer>("Fc", "Hz", 20, 20000);
    private GenericValue<Integer> fRes = new GenericValue<Integer>("FRes", "", 1, 100);
    private GenericValue<Integer> mod = new GenericValue<Integer>("Mod", "Hz", 20, 20000);
    private GenericValue<Integer> scale = new GenericValue<Integer>("Scale", "%", -100, 100);
    private GenericValue<Integer> pan = new GenericValue<Integer>("Pan", "LCR", -50, 50);

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
                parameter = fc;
                break;
            case 3:
                parameter = fRes;
                break;
            case 4:
                parameter = mod;
                break;
            case 5:
                parameter = scale;
                break;
            case 6:
                parameter = pan;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public int getFc() {
        return fc.getValue();
    }

    public void setFc(final int fc) {
        this.fc.setValue(fc);
    }

    public int getFRes() {
        return fRes.getValue();
    }

    public void setFRes(final int fRes) {
        this.fRes.setValue(fRes);
    }

    public int getMod() {
        return mod.getValue();
    }

    public void setMod(final int mod) {
        this.mod.setValue(mod);
    }

    public int getScale() {
        return scale.getValue();
    }

    public void setScale(final int scale) {
        this.scale.setValue(scale);
    }

    public int getPan() {
        return pan.getValue();
    }

    public void setPan(final int pan) {
        this.pan.setValue(pan);
    }

}
