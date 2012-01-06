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
 * Class to hold information about the A/B controller.
 *
 * @author Carl Green
 */
public class Ab implements DataObject {
    private AbModeValue mode = new AbModeValue("Mode");
    private GenericValue<Integer> aRate = new GenericValue<Integer>("ARate", "", 0, 100);
    private GenericValue<Integer> bRate = new GenericValue<Integer>("BRate", "", 0, 100);
    private GenericValue<Integer> onLevel = new GenericValue<Integer>("OnLvl", "", 0, 127);
    private OnSourceValue onSource = new OnSourceValue("OnSrc");

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = mode;
                break;
            case 1:
                parameter = aRate;
                break;
            case 2:
                parameter = bRate;
                break;
            case 3:
                parameter = onLevel;
                break;
            case 4:
                parameter = onSource;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public AbModeValue getMode() {
        return mode;
    }

    public void setMode(final int mode) {
        this.mode.setValue(mode);
    }

    public GenericValue<Integer> getARate() {
        return aRate;
    }

    public void setARate(final int aRate) {
        this.aRate.setValue(aRate);
    }

    public GenericValue<Integer> getBRate() {
        return bRate;
    }

    public void setBRate(final int bRate) {
        this.bRate.setValue(bRate);
    }

    public GenericValue<Integer> getOnLevel() {
        return onLevel;
    }

    public void setOnLevel(int onLevel) {
        this.onLevel.setValue(onLevel);
    }

    public OnSourceValue getOnSource() {
        return onSource;
    }

    public void setOnSource(final int onSource) {
        this.onSource.setValue(onSource);
    }

}
