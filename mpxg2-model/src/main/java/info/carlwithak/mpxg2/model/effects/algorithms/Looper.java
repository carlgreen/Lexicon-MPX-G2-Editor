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
import info.carlwithak.mpxg2.model.InsertPosition;
import info.carlwithak.mpxg2.model.OnOffValue;
import info.carlwithak.mpxg2.model.Parameter;
import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.effects.Delay;

/**
 * Class for Looper parameters.
 *
 * @author Carl Green
 */
public class Looper extends Delay {
    private static final String NAME = "Looper";

    private Rate time;
    private GenericValue<Integer> inMix = new GenericValue<Integer>("InMix", "%", 0, 100);
    private InsertPosition feedbackInsert = new InsertPosition("Fbk insert");
    private GenericValue<Integer> sensitivity = new GenericValue<Integer>("Sense", "", 0, 100);
    private GenericValue<Integer> pan = new GenericValue<Integer>("Pan", "LCR", -50, 50);
    private GenericValue<Integer> release = new GenericValue<Integer>("Rls", "", 0, 100);
    private GenericValue<Integer> attack = new GenericValue<Integer>("Atk", "", 0, 100);
    private OnOffValue clear = new OnOffValue("Clear");

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
                parameter = inMix;
                break;
            case 4:
                parameter = sensitivity;
                break;
            case 5:
                parameter = pan;
                break;
            case 6:
                parameter = release;
                break;
            case 7:
                parameter = attack;
                break;
            case 8:
                parameter = clear;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public Rate getTime() {
        return time;
    }

    public void setTime(Rate time) {
        this.time = time;
    }

    public GenericValue<Integer> getInMix() {
        return inMix;
    }

    public void setInMix(int inMix) {
        this.inMix.setValue(inMix);
    }

    public InsertPosition getFeedbackInsert() {
        return feedbackInsert;
    }

    public void setFeedbackInsert(int feedbackInsert) {
        this.feedbackInsert.setValue(feedbackInsert);
    }

    public GenericValue<Integer> getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity.setValue(sensitivity);
    }

    public GenericValue<Integer> getPan() {
        return pan;
    }

    public void setPan(int pan) {
        this.pan.setValue(pan);
    }

    public GenericValue<Integer> getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release.setValue(release);
    }

    public GenericValue<Integer> getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack.setValue(attack);
    }

    public OnOffValue isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear.setValue(clear);
    }
}
