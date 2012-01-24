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
import info.carlwithak.mpxg2.model.parameters.PhaseValue;
import info.carlwithak.mpxg2.model.parameters.Rate;

/**
 * Class for Comb 2 parameters.
 *
 * @author Carl Green
 */
public class Comb2 extends Chorus {
    private static final String NAME = "Comb 2";

    public final GenericValue<Integer> loCut = new GenericValue<Integer>("LoCut", "Hz", 100, 100000);
    public final GenericValue<Integer> hiCut = new GenericValue<Integer>("HiCut", "Hz", 100, 100000);
    public final GenericValue<Integer> comb = new GenericValue<Integer>("Comb", "", 0, 100);
    public final GenericValue<Integer> notch = new GenericValue<Integer>("Notch", "", -100, 100);
    private Rate rate;
    public final GenericValue<Integer> pulseWidth = new GenericValue<Integer>("PW", "%", 0, 100);
    public final GenericValue<Integer> depth = new GenericValue<Integer>("Dpth", "%", 0, 100);
    public final GenericValue<Integer> resonance = new GenericValue<Integer>("Res", "", -100, 100);
    public final PhaseValue phase = new PhaseValue("Phase");

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
                parameter = loCut;
                break;
            case 3:
                parameter = hiCut;
                break;
            case 4:
                parameter = comb;
                break;
            case 5:
                parameter = notch;
                break;
            case 6:
                parameter = rate;
                break;
            case 7:
                parameter = pulseWidth;
                break;
            case 8:
                parameter = depth;
                break;
            case 9:
                parameter = resonance;
                break;
            case 10:
                parameter = phase;
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
