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
import info.carlwithak.mpxg2.model.IntervalValue;
import info.carlwithak.mpxg2.model.KeyValue;
import info.carlwithak.mpxg2.model.Parameter;
import info.carlwithak.mpxg2.model.ScaleValue;
import info.carlwithak.mpxg2.model.SourceValue;
import info.carlwithak.mpxg2.model.effects.Effect;

/**
 * Class for Diatonic Hmy parameters.
 *
 * @author Carl Green
 */
public class DiatonicHmy extends Effect {
    private static final String NAME = "Diatonic Hmy";

    private KeyValue key = new KeyValue("Key");
    private ScaleValue scale = new ScaleValue("Scale");
    private IntervalValue interval = new IntervalValue("Int");
    private GenericValue<Integer> optimize = new GenericValue<Integer>("Optimize", "", 0, 100);
    private GenericValue<Integer> threshold = new GenericValue<Integer>("Thrsh", "dB", -83, 0);
    private SourceValue source = new SourceValue("Src");

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

    public KeyValue getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key.setValue(key);
    }

    public ScaleValue getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale.setValue(scale);
    }

    public IntervalValue getInterval() {
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

    public SourceValue getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source.setValue(source);
    }
}