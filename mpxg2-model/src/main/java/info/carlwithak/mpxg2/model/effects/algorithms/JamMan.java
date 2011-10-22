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
import info.carlwithak.mpxg2.model.effects.Delay;

/**
 * Class for JamMan parameters.
 *
 * @author Carl Green
 */
public class JamMan extends Delay {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Size", "Fbk", "Clear", "Layer", "Replc", "Delay", "MuteS"
    };

    private GenericValue<Integer> size = new GenericValue<Integer>("ms", 0, 20000);
    private GenericValue<Integer> feedback = new GenericValue<Integer>("%", -100, 100);
    private int insert;
    private GenericValue<Boolean> clear = new GenericValue<Boolean>("OnOff", false, true);
    private GenericValue<Boolean> layer = new GenericValue<Boolean>("OnOff", false, true);
    private GenericValue<Boolean> replace = new GenericValue<Boolean>("OnOff", false, true);
    private GenericValue<Boolean> delay = new GenericValue<Boolean>("OnOff", false, true);
    private GenericValue<Boolean> mute = new GenericValue<Boolean>("OnOff", false, true);

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
    }

    @Override
    public String getParameterUnit(final int parameterIndex) {
        Parameter parameter = getParameter(parameterIndex);
        String unit = parameter.getUnit();
        if (parameter instanceof GenericValue && ((GenericValue) parameter).getMinValue() instanceof Integer && ((GenericValue<Integer>) parameter).getMinValue() < 0) {
            unit = '-' + unit;
        }
        return unit;
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

    public int getSize() {
        return size.getValue();
    }

    public void setSize(int size) {
        this.size.setValue(size);
    }

    public int getFeedback() {
        return feedback.getValue();
    }

    public void setFeedback(int feedback) {
        this.feedback.setValue(feedback);
    }

    public int getInsert() {
        return insert;
    }

    public void setInsert(int insert) {
        this.insert = insert;
    }

    public boolean isClear() {
        return clear.getValue();
    }

    public void setClear(boolean clear) {
        this.clear.setValue(clear);
    }

    public boolean isLayer() {
        return layer.getValue();
    }

    public void setLayer(boolean layer) {
        this.layer.setValue(layer);
    }

    public boolean isReplace() {
        return replace.getValue();
    }

    public void setReplace(boolean replace) {
        this.replace.setValue(replace);
    }

    public boolean isDelay() {
        return delay.getValue();
    }

    public void setDelay(boolean delay) {
        this.delay.setValue(delay);
    }

    public boolean isMute() {
        return mute.getValue();
    }

    public void setMute(boolean mute) {
        this.mute.setValue(mute);
    }

}
