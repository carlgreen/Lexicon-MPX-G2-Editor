/*
 *  Copyright (C) 2012 Carl Green
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

package info.carlwithak.mpxg2.model;

import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 *
 * @author Carl Green
 */
public class EffectsStatus implements DataObject {
    private OnOffValue effect1On = new OnOffValue("FX1");
    private OnOffValue effect2On = new OnOffValue("FX2");
    private OnOffValue chorusOn = new OnOffValue("Chrs");
    private OnOffValue delayOn = new OnOffValue("Dly");
    private OnOffValue reverbOn = new OnOffValue("Rvb");
    private OnOffValue eqOn = new OnOffValue("EQ");
    private OnOffValue gainOn = new OnOffValue("Gain");
    private OnOffValue insertOn = new OnOffValue("Ins");

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = effect1On;
                break;
            case 1:
                parameter = effect2On;
                break;
            case 2:
                parameter = chorusOn;
                break;
            case 3:
                parameter = delayOn;
                break;
            case 4:
                parameter = reverbOn;
                break;
            case 5:
                parameter = eqOn;
                break;
            case 6:
                parameter = gainOn;
                break;
            case 7:
                parameter = insertOn;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public OnOffValue getEffect1On() {
        return effect1On;
    }

    public void setEffect1On(final boolean effect1On) {
        this.effect1On.setValue(effect1On);
    }

    public OnOffValue getEffect2On() {
        return effect2On;
    }

    public void setEffect2On(final boolean effect2On) {
        this.effect2On.setValue(effect2On);
    }

    public OnOffValue getChorusOn() {
        return chorusOn;
    }

    public void setChorusOn(final boolean chorusOn) {
        this.chorusOn.setValue(chorusOn);
    }

    public OnOffValue getDelayOn() {
        return delayOn;
    }

    public void setDelayOn(final boolean delayOn) {
        this.delayOn.setValue(delayOn);
    }

    public OnOffValue getReverbOn() {
        return reverbOn;
    }

    public void setReverbOn(final boolean reverbOn) {
        this.reverbOn.setValue(reverbOn);
    }

    public OnOffValue getEqOn() {
        return eqOn;
    }

    public void setEqOn(final boolean eqOn) {
        this.eqOn.setValue(eqOn);
    }

    public OnOffValue getGainOn() {
        return gainOn;
    }

    public void setGainOn(final boolean gainOn) {
        this.gainOn.setValue(gainOn);
    }

    public OnOffValue getInsertOn() {
        return insertOn;
    }

    public void setInsertOn(final boolean insertOn) {
        this.insertOn.setValue(insertOn);
    }

}
