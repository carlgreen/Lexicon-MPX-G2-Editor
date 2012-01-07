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

import info.carlwithak.mpxg2.model.effects.Delay;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.InsertPosition;
import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

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
    private OnOffValue clear = new OnOffValue("Clear");
    private OnOffValue layer = new OnOffValue("Layer");
    private OnOffValue replace = new OnOffValue("Replc");
    private OnOffValue delay = new OnOffValue("Delay");
    private OnOffValue mute = new OnOffValue("MuteS");

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

    public OnOffValue isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear.setValue(clear);
    }

    public OnOffValue isLayer() {
        return layer;
    }

    public void setLayer(boolean layer) {
        this.layer.setValue(layer);
    }

    public OnOffValue isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace.setValue(replace);
    }

    public OnOffValue isDelay() {
        return delay;
    }

    public void setDelay(boolean delay) {
        this.delay.setValue(delay);
    }

    public OnOffValue isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute.setValue(mute);
    }

}
