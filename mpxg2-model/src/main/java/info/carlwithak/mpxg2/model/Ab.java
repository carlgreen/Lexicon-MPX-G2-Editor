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
    private int aRate;
    private int bRate;
    private int onLevel;
    private int onSource;

    public int getMode() {
        return mode;
    }

    public void setMode(final int mode) {
        this.mode = mode;
    }

    public int getARate() {
        return aRate;
    }

    public void setARate(final int aRate) {
        this.aRate = aRate;
    }

    public int getBRate() {
        return bRate;
    }

    public void setBRate(final int bRate) {
        this.bRate = bRate;
    }

    public int getOnLevel() {
        return onLevel;
    }

    public void setOnLevel(final int onLevel) {
        this.onLevel = onLevel;
    }

    public int getOnSource() {
        return onSource;
    }

    public void setOnSource(final int onSource) {
        this.onSource = onSource;
    }

}
