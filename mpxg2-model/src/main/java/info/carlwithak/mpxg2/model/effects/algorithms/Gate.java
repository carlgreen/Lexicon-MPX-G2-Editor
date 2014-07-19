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

import info.carlwithak.mpxg2.model.effects.Reverb;
import info.carlwithak.mpxg2.model.parameters.CrossoverValue;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.HighCutValue;
import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;
import info.carlwithak.mpxg2.model.parameters.ReverbSpredValue;
import info.carlwithak.mpxg2.model.parameters.ReverbTimeValue;

/**
 * Class for Gate parameters.
 *
 * @author Carl Green
 */
public class Gate extends Reverb {
    private static final String NAME = "Gate";

    public final ReverbTimeValue time = new ReverbTimeValue("Time");
    public final OnOffValue link = new OnOffValue("Link");
    public final GenericValue<Integer> diff = new GenericValue<>("Diff", "%", 0, 100);
    public final GenericValue<Integer> preDelay = new GenericValue<>("P Dly", "ms", 0, 250);
    public final GenericValue<Integer> loSlope = new GenericValue<>("LoSlp", "", -16, 16);
    public final GenericValue<Integer> hiSlope = new GenericValue<>("HiSlp", "", -16, 16);
    public final CrossoverValue xovr = new CrossoverValue("Xovr");
    public final HighCutValue rtHC = new HighCutValue("Rt HC");
    public final GenericValue<Integer> shape = new GenericValue<>("Shape", "", 0, 255);
    public final ReverbSpredValue spred = new ReverbSpredValue("Spred", link, time);

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
                parameter = time;
                break;
            case 3:
                parameter = link;
                break;
            case 4:
                parameter = diff;
                break;
            case 5:
                parameter = preDelay;
                break;
            case 6:
                parameter = loSlope;
                break;
            case 7:
                parameter = hiSlope;
                break;
            case 8:
                parameter = xovr;
                break;
            case 9:
                parameter = rtHC;
                break;
            case 10:
                parameter = shape;
                break;
            case 11:
                parameter = spred;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

}
