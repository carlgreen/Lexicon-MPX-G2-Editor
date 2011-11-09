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

/**
 * Class to hold information about the LFO controllers.
 *
 * @author Carl Green
 */
public class Lfo {
    private GenericValue<Integer> mode = new GenericValue<Integer>("Mode", "", 0, 6);
    private Rate rate;
    private GenericValue<Integer> pulseWidth = new GenericValue<Integer>("PW", "%", 0, 100);
    private GenericValue<Integer> phase = new GenericValue<Integer>("Phase", "", -120, 120);
    private GenericValue<Integer> depth = new GenericValue<Integer>("Depth", "%", 0, 100);
    private GenericValue<Integer> onLevel = new GenericValue<Integer>("OnLvl", "", 0, 127);
    private GenericValue<Integer> onSource = new GenericValue<Integer>("OnSrc", "", 0, 127); // TODO not sure what this goes up to

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

    public int getMode() {
        return mode.getValue();
    }

    public void setMode(int mode) {
        this.mode.setValue(mode);
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public int getPulseWidth() {
        return pulseWidth.getValue();
    }

    public void setPulseWidth(int pulseWidth) {
        this.pulseWidth.setValue(pulseWidth);
    }

    public int getPhase() {
        return phase.getValue();
    }

    public void setPhase(int phase) {
        this.phase.setValue(phase);
    }

    public int getDepth() {
        return depth.getValue();
    }

    public void setDepth(int depth) {
        this.depth.setValue(depth);
    }

    public int getOnLevel() {
        return onLevel.getValue();
    }

    public void setOnLevel(int onLevel) {
        this.onLevel.setValue(onLevel);
    }

    public int getOnSource() {
        return onSource.getValue();
    }

    public void setOnSource(final int onSource) {
        this.onSource.setValue(onSource);
    }
}
