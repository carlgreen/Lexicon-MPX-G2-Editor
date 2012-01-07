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
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class for Screamer parameters.
 *
 * @author Carl Green
 */
public class Screamer extends Gain {
    private static final String NAME = "Screamer";

    private GenericValue<Integer> lo = new GenericValue<Integer>("Lo", "dB", -5, 5);
    private GenericValue<Integer> mid = new GenericValue<Integer>("Mid", "dB", -5, 5);
    private GenericValue<Integer> hi = new GenericValue<Integer>("Hi", "dB", 0, 5);
    private GenericValue<Integer> drive = new GenericValue<Integer>("Drive", "", 0, 40);
    private GenericValue<Integer> tone = new GenericValue<Integer>("Tone", "", 0, 25);
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
                parameter = drive;
                break;
            case 4:
                parameter = tone;
                break;
            case 5:
                parameter = level;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getLo() {
        return lo;
    }

    public void setLo(int lo) {
        this.lo.setValue(lo);
    }

    public GenericValue<Integer> getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid.setValue(mid);
    }

    public GenericValue<Integer> getHi() {
        return hi;
    }

    public void setHi(int hi) {
        this.hi.setValue(hi);
    }

    public GenericValue<Integer> getDrive() {
        return drive;
    }

    public void setDrive(int drive) {
        this.drive.setValue(drive);
    }

    public GenericValue<Integer> getTone() {
        return tone;
    }

    public void setTone(int tone) {
        this.tone.setValue(tone);
    }

    public GenericValue<Integer> getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level.setValue(level);
    }
}
