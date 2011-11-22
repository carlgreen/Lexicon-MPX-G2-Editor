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
 * Class for Diatonic Hmy parameters.
 *
 * @author Carl Green
 */
public class DiatonicHmy extends Effect {
    private static final String NAME = "Diatonic Hmy";

    private GenericValue<Integer> key = new GenericValue<Integer>("Key", "", 0, 11); // C - B
    private GenericValue<Integer> scale = new GenericValue<Integer>("Scale", "", 0, 6); // Major, Dorian, Phyrgian, Lydian, Mixolydian, Minor, Locrian
    private GenericValue<Integer> interval = new GenericValue<Integer>("Int", "", 0, 25); // -2Oct to Oct+ 5th
    private GenericValue<Integer> optimize = new GenericValue<Integer>("Optimize", "", 0, 100);
    private GenericValue<Integer> threshold = new GenericValue<Integer>("Thrsh", "dB", -83, 0);
    private GenericValue<Integer> source = new GenericValue<Integer>("Src", "", 0, 1); // Guitar In, Returns Input

    @Override
    public String getName() {
        return NAME;
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
                parameter = key;
                break;
            case 3:
                parameter = scale;
                break;
            case 4:
                parameter = interval;
                break;
            case 5:
                parameter = threshold;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key.setValue(key);
    }

    public GenericValue<Integer> getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale.setValue(scale);
    }

    public GenericValue<Integer> getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval.setValue(interval);
    }

    public GenericValue<Integer> getOptimize() {
        return optimize;
    }

    public void setOptimize(int optimize) {
        this.optimize.setValue(optimize);
    }

    public GenericValue<Integer> getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold.setValue(threshold);
    }

    public GenericValue<Integer> getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source.setValue(source);
    }
}