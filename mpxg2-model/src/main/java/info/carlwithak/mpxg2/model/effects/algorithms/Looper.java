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
    private int feedbackInsert;
    private GenericValue<Integer> sensitivity = new GenericValue<Integer>("Sense", "", 0, 100);
    private GenericValue<Integer> pan = new GenericValue<Integer>("Pan", "LCR", -50, 50);
    private GenericValue<Integer> release = new GenericValue<Integer>("Rls", "", 0, 100);
    private GenericValue<Integer> attack = new GenericValue<Integer>("Atk", "", 0, 100);
    private GenericValue<Boolean> clear = new GenericValue<Boolean>("Clear", "OnOff", false, true);

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

    public int getInMix() {
        return inMix.getValue();
    }

    public void setInMix(int inMix) {
        this.inMix.setValue(inMix);
    }

    public int getFeedbackInsert() {
        return feedbackInsert;
    }

    public void setFeedbackInsert(int feedbackInsert) {
        this.feedbackInsert = feedbackInsert;
    }

    public int getSensitivity() {
        return sensitivity.getValue();
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity.setValue(sensitivity);
    }

    public int getPan() {
        return pan.getValue();
    }

    public void setPan(int pan) {
        this.pan.setValue(pan);
    }

    public int getRelease() {
        return release.getValue();
    }

    public void setRelease(int release) {
        this.release.setValue(release);
    }

    public int getAttack() {
        return attack.getValue();
    }

    public void setAttack(int attack) {
        this.attack.setValue(attack);
    }

    public boolean isClear() {
        return clear.getValue();
    }

    public void setClear(boolean clear) {
        this.clear.setValue(clear);
    }
}