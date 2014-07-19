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

package info.carlwithak.mpxg2.model;

import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.LfoModeValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;
import info.carlwithak.mpxg2.model.parameters.Rate;
import info.carlwithak.mpxg2.model.parameters.SourceValue;

/**
 * Class to hold information about the LFO controllers.
 *
 * @author Carl Green
 */
public class Lfo implements DataObject {
    private final LfoModeValue mode = new LfoModeValue("Mode");
    private Rate rate;
    private final GenericValue<Integer> pulseWidth = new GenericValue<Integer>("PW", "%", 0, 100);
    private final GenericValue<Integer> phase = new GenericValue<Integer>("Phase", "", -120, 120);
    private final GenericValue<Integer> depth = new GenericValue<Integer>("Depth", "%", 0, 100);
    private final GenericValue<Integer> onLevel = new GenericValue<Integer>("OnLvl", "", 0, 127);
    private final SourceValue onSource = new SourceValue("OnSrc");

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = mode;
                break;
            case 1:
                parameter = rate;
                break;
            case 2:
                parameter = pulseWidth;
                break;
            case 3:
                parameter = phase;
                break;
            case 4:
                parameter = depth;
                break;
            case 5:
                parameter = onLevel;
                break;
            case 6:
                parameter = onSource;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public LfoModeValue getMode() {
        return mode;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public GenericValue<Integer> getPulseWidth() {
        return pulseWidth;
    }

    public GenericValue<Integer> getPhase() {
        return phase;
    }

    public GenericValue<Integer> getDepth() {
        return depth;
    }

    public GenericValue<Integer> getOnLevel() {
        return onLevel;
    }

    public SourceValue getOnSource() {
        return onSource;
    }

}
