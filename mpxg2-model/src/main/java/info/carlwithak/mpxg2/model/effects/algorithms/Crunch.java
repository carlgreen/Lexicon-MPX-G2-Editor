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
import info.carlwithak.mpxg2.model.effects.Gain;

/**
 * Class for Crunch parameters.
 *
 * @author Carl Green
 */
public class Crunch extends Gain {
    private static final String NAME = "Crunch";

    private GenericValue<Integer> lo = new GenericValue<Integer>("Lo", "dB", -25, 25);
    private GenericValue<Integer> mid = new GenericValue<Integer>("Mid", "dB", -25, 25);
    private GenericValue<Integer> hi = new GenericValue<Integer>("Hi", "dB", 0, 50);
    private GenericValue<Integer> inLevel = new GenericValue<Integer>("InLvl", "dB", -64, 0);
    private GenericValue<Integer> level = new GenericValue<Integer>("Level", "dB", 0, 64);

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = lo;
                break;
            case 1:
                parameter = mid;
                break;
            case 2:
                parameter = hi;
                break;
            case 3:
                parameter = inLevel;
                break;
            case 4:
                parameter = level;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public int getLo() {
        return lo.getValue();
    }

    public void setLo(int lo) {
        this.lo.setValue(lo);
    }

    public int getMid() {
        return mid.getValue();
    }

    public void setMid(int mid) {
        this.mid.setValue(mid);
    }

    public int getHi() {
        return hi.getValue();
    }

    public void setHi(int hi) {
        this.hi.setValue(hi);
    }

    public int getInLevel() {
        return inLevel.getValue();
    }

    public void setInLevel(int inLevel) {
        this.inLevel.setValue(inLevel);
    }

    public int getLevel() {
        return level.getValue();
    }

    public void setLevel(int level) {
        this.level.setValue(level);
    }
}