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
 * Class for Distortion parameters.
 *
 * @author Carl Green
 */
public class Distortion extends Gain {
    private static final String[] PARAMETER_NAMES = {
        "Lo", "Mid", "Hi", "Drive", "Tone", "Bass", "Trebl", "Level"
    };

    private GenericValue<Integer> lo = new GenericValue<Integer>("dB", -25, 18);
    private GenericValue<Integer> mid = new GenericValue<Integer>("dB", -25, 18);
    private GenericValue<Integer> hi = new GenericValue<Integer>("dB", 0, 18);
    private GenericValue<Integer> drive = new GenericValue<Integer>("", 0, 50);
    private GenericValue<Integer> tone = new GenericValue<Integer>("", 0, 25);
    private GenericValue<Integer> bass = new GenericValue<Integer>("dB", -25, 25);
    private GenericValue<Integer> treble = new GenericValue<Integer>("dB", -25, 25);
    private GenericValue<Integer> level = new GenericValue<Integer>("dB", 0, 64);

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
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
                parameter = bass;
                break;
            case 6:
                parameter = treble;
                break;
            case 7:
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

    public int getDrive() {
        return drive.getValue();
    }

    public void setDrive(int drive) {
        this.drive.setValue(drive);
    }

    public int getTone() {
        return tone.getValue();
    }

    public void setTone(int tone) {
        this.tone.setValue(tone);
    }

    public int getBass() {
        return bass.getValue();
    }

    public void setBass(int bass) {
        this.bass.setValue(bass);
    }

    public int getTreble() {
        return treble.getValue();
    }

    public void setTreble(int treble) {
        this.treble.setValue(treble);
    }

    public int getLevel() {
        return level.getValue();
    }

    public void setLevel(int level) {
        this.level.setValue(level);
    }
}
