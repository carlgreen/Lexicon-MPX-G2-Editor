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
import info.carlwithak.mpxg2.model.parameters.AmbienceHighCutValue;
import info.carlwithak.mpxg2.model.parameters.DecayLevelValue;
import info.carlwithak.mpxg2.model.parameters.DecayTimeValue;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class for Ambience parameters.
 *
 * @author Carl Green
 */
public class Ambience extends Reverb {
    private static final String NAME = "Ambience";

    public final GenericValue<Double> size = new GenericValue<>("Size", "m", 4.0, 76.0);
    public final OnOffValue link = new OnOffValue("Link");
    public final GenericValue<Integer> diff = new GenericValue<>("Diff", "%", 0, 100);
    public final GenericValue<Integer> preDelay = new GenericValue<>("P Dly", "ms", 0, 250);
    public final DecayTimeValue decayTime = new DecayTimeValue("DTime", link, size);
    public final DecayLevelValue decayLevel = new DecayLevelValue("D Lvl");
    public final AmbienceHighCutValue rtHC = new AmbienceHighCutValue("Rt HC");

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
                parameter = size;
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
                parameter = decayTime;
                break;
            case 7:
                parameter = decayLevel;
                break;
            case 8:
                parameter = rtHC;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

}
