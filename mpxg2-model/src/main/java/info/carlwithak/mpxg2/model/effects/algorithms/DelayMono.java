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
 * Class for Delay (M) parameters.
 *
 * @author Carl Green
 */
public class DelayMono extends Delay {
    private static final String NAME = "Delay (M)";

    private Rate time;
    private GenericValue<Integer> feedback = new GenericValue<Integer>("Fbk", "%", -100, 100);
    private int insert;
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
                parameter = feedback;
                break;
            case 4:
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

    public GenericValue<Integer> getFeedback() {
        return feedback;
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

    public GenericValue<Boolean> isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear.setValue(clear);
    }
}
