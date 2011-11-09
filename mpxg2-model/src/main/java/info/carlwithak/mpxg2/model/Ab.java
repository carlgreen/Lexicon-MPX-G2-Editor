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
public class Ab {
    private int mode;
    private GenericValue<Integer> aRate = new GenericValue<Integer>("ARate", "", 0, 100);
    private GenericValue<Integer> bRate = new GenericValue<Integer>("BRate", "", 0, 100);
    private GenericValue<Integer> onLevel = new GenericValue<Integer>("OnLvl", "", 0, 127);
    private int onSource;

    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 1:
                parameter = aRate;
                break;
            case 2:
                parameter = bRate;
                break;
            case 3:
                parameter = onLevel;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(final int mode) {
        this.mode = mode;
    }

    public int getARate() {
        return aRate.getValue();
    }

    public void setARate(final int aRate) {
        this.aRate.setValue(aRate);
    }

    public int getBRate() {
        return bRate.getValue();
    }

    public void setBRate(final int bRate) {
        this.bRate.setValue(bRate);
    }

    public int getOnLevel() {
        return onLevel.getValue();
    }

    public void setOnLevel(int onLevel) {
        this.onLevel.setValue(onLevel);
    }

    public int getOnSource() {
        return onSource;
    }

    public void setOnSource(final int onSource) {
        this.onSource = onSource;
    }

}
