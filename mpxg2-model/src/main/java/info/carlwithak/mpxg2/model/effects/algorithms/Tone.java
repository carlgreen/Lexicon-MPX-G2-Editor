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

import info.carlwithak.mpxg2.model.effects.Gain;

/**
 * Class for Tone parameters.
 *
 * @author Carl Green
 */
public class Tone extends Gain {
    private static final String[] PARAMETER_NAMES = {
        "Lo", "Mid", "Hi", "InLvl", "Level"
    };
    private static final String[] PARAMETER_UNITS = {
        "", "", "", "", ""
    };

    private int lo;
    private int mid;
    private int hi;
    private int inLevel;
    private int level;

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
    }

    @Override
    public String getParameterUnit(final int parameterIndex) {
        return PARAMETER_UNITS[parameterIndex];
    }

    public int getLo() {
        return lo;
    }

    public void setLo(int lo) {
        this.lo = lo;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getHi() {
        return hi;
    }

    public void setHi(int hi) {
        this.hi = hi;
    }

    public int getInLevel() {
        return inLevel;
    }

    public void setInLevel(int inLevel) {
        this.inLevel = inLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
