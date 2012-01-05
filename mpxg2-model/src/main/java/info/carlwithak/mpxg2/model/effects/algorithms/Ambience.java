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

import info.carlwithak.mpxg2.model.AmbienceHighCutValue;
import info.carlwithak.mpxg2.model.DecayLevelValue;
import info.carlwithak.mpxg2.model.DecayTimeValue;
import info.carlwithak.mpxg2.model.GenericValue;
import info.carlwithak.mpxg2.model.Parameter;
import info.carlwithak.mpxg2.model.effects.Reverb;

/**
 * Class for Ambience parameters.
 *
 * @author Carl Green
 */
public class Ambience extends Reverb {
    private static final String NAME = "Ambience";

    private GenericValue<Double> size = new GenericValue<Double>("Size", "m", 4.0, 76.0);
    private GenericValue<Boolean> link = new GenericValue<Boolean>("Link", "OnOff", false, true);
    private GenericValue<Integer> diff = new GenericValue<Integer>("Diff", "%", 0, 100);
    private GenericValue<Integer> preDelay = new GenericValue<Integer>("P Dly", "ms", 0, 250);
    private DecayTimeValue decayTime = new DecayTimeValue("DTime", link, size);
    private DecayLevelValue decayLevel = new DecayLevelValue("D Lvl");
    private AmbienceHighCutValue rtHC = new AmbienceHighCutValue("Rt HC");

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

    public GenericValue<Double> getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size.setValue(size);
    }

    public GenericValue<Boolean> isLink() {
        return link;
    }

    public void setLink(boolean link) {
        this.link.setValue(link);
    }

    public GenericValue<Integer> getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff.setValue(diff);
    }

    public GenericValue<Integer> getPreDelay() {
        return preDelay;
    }

    public void setPreDelay(int preDelay) {
        this.preDelay.setValue(preDelay);
    }

    public DecayTimeValue getDecayTime() {
        return decayTime;
    }

    public void setDecayTime(int decayTime) {
        this.decayTime.setValue(decayTime);
    }

    public DecayLevelValue getDecayLevel() {
        return decayLevel;
    }

    public void setDecayLevel(int decayLevel) {
        this.decayLevel.setValue(decayLevel);
    }

    public AmbienceHighCutValue getRtHC() {
        return rtHC;
    }

    public void setRtHC(int rtHC) {
        this.rtHC.setValue(rtHC);
    }
}
