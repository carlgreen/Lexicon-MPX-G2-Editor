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

import info.carlwithak.mpxg2.model.effects.Chorus;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;
import info.carlwithak.mpxg2.model.parameters.Rate;

/**
 * Class for Flanger24 (M) parameters.
 *
 * @author Carl Green
 */
public class Flanger24Mono extends Chorus {
    private static final String NAME = "Flanger24 (M)";

    private Rate rate;
    public final GenericValue<Integer> pulseWidth = new GenericValue<>("PW", "%", 0, 100);
    public final GenericValue<Integer> depth = new GenericValue<>("Depth", "%", 0, 100);
    public final GenericValue<Integer> resonance = new GenericValue<>("Res", "%", -100, 100);
    public final GenericValue<Integer> glide = new GenericValue<>("Glide", "", 0, 100);
    public final GenericValue<Integer> blend = new GenericValue<>("Blend", "%", 0, 100);

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
                parameter = rate;
                break;
            case 3:
                parameter = pulseWidth;
                break;
            case 4:
                parameter = depth;
                break;
            case 5:
                parameter = resonance;
                break;
            case 6:
                parameter = glide;
                break;
            case 7:
                parameter = blend;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

}
