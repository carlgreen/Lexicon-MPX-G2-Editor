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

import info.carlwithak.mpxg2.model.effects.Effect;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.IntervalValue;
import info.carlwithak.mpxg2.model.parameters.KeyValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;
import info.carlwithak.mpxg2.model.parameters.ScaleValue;
import info.carlwithak.mpxg2.model.parameters.SourceValue;

/**
 * Class for Diatonic Hmy parameters.
 *
 * @author Carl Green
 */
public class DiatonicHmy extends Effect {
    private static final String NAME = "Diatonic Hmy";

    public final KeyValue key = new KeyValue("Key");
    public final ScaleValue scale = new ScaleValue("Scale");
    public final IntervalValue interval = new IntervalValue("Int");
    public final GenericValue<Integer> optimize = new GenericValue<Integer>("Optimize", "", 0, 100);
    public final GenericValue<Integer> threshold = new GenericValue<Integer>("Thrsh", "dB", -83, 0);
    public final SourceValue source = new SourceValue("Src");

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

}
