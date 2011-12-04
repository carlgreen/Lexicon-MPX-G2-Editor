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
import info.carlwithak.mpxg2.model.Parameter;
import info.carlwithak.mpxg2.model.effects.Delay;

/**
 * Class for JamMan parameters.
 *
 * @author Carl Green
 */
public class JamMan extends Delay {
    private static final String NAME = "JamMan";

    private GenericValue<Integer> size = new GenericValue<Integer>("Size", "ms", 0, 20000);
    private GenericValue<Integer> feedback = new GenericValue<Integer>("Fbk", "%", -100, 100);
    private InsertPosition insert = new InsertPosition("Fbk insert");
    private GenericValue<Boolean> clear = new GenericValue<Boolean>("Clear", "OnOff", false, true);
    private GenericValue<Boolean> layer = new GenericValue<Boolean>("Layer", "OnOff", false, true);
    private GenericValue<Boolean> replace = new GenericValue<Boolean>("Replc", "OnOff", false, true);
    private GenericValue<Boolean> delay = new GenericValue<Boolean>("Delay", "OnOff", false, true);
    private GenericValue<Boolean> mute = new GenericValue<Boolean>("MuteS", "OnOff", false, true);

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
                parameter = feedback;
                break;
            case 4:
                parameter = clear;
                break;
            case 5:
                parameter = layer;
                break;
            case 6:
                parameter = replace;
                break;
            case 7:
                parameter = delay;
                break;
            case 8:
                parameter = mute;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size.setValue(size);
    }

    public GenericValue<Integer> getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback.setValue(feedback);
    }

    public InsertPosition getInsert() {
        return insert;
    }

    public void setInsert(int insert) {
        this.insert.setValue(insert);
    }

    public GenericValue<Boolean> isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear.setValue(clear);
    }

    public GenericValue<Boolean> isLayer() {
        return layer;
    }

    public void setLayer(boolean layer) {
        this.layer.setValue(layer);
    }

    public GenericValue<Boolean> isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace.setValue(replace);
    }

    public GenericValue<Boolean> isDelay() {
        return delay;
    }

    public void setDelay(boolean delay) {
        this.delay.setValue(delay);
    }

    public GenericValue<Boolean> isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute.setValue(mute);
    }

}
