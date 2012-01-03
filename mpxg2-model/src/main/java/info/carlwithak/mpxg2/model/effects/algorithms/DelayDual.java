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
import info.carlwithak.mpxg2.model.PanValue;
import info.carlwithak.mpxg2.model.Parameter;
import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.effects.Delay;

/**
 * Class for Delay (D) parameters.
 *
 * @author Carl Green
 */
public class DelayDual extends Delay {
    private static final String NAME = "Delay (D)";

    private Rate time1;
    private Rate time2;
    private GenericValue<Integer> level1 = new GenericValue<Integer>("Lvl 1", "dB", -90, 6);
    private GenericValue<Integer> level2 = new GenericValue<Integer>("Lvl 2", "dB", -90, 6);
    private PanValue pan1 = new PanValue("Pan 1", -50, 50);
    private PanValue pan2 = new PanValue("Pan 2", -50, 50);
    private GenericValue<Integer> feedback1 = new GenericValue<Integer>("Fbk 1", "%", -100, 100);
    private InsertPosition insert = new InsertPosition("Fbk insert");
    private GenericValue<Integer> feedback2 = new GenericValue<Integer>("Fbk 2", "%", -100, 100);
    private GenericValue<Integer> xFbk1 = new GenericValue<Integer>("XFbk1", "%", -100, 100);
    private GenericValue<Integer> xFbk2 = new GenericValue<Integer>("XFbk2", "%", -100, 100);
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
                parameter = time1;
                break;
            case 3:
                parameter = time2;
                break;
            case 4:
                parameter = level1;
                break;
            case 5:
                parameter = level2;
                break;
            case 6:
                parameter = pan1;
                break;
            case 7:
                parameter = pan2;
                break;
            case 8:
                parameter = feedback1;
                break;
            case 9:
                parameter = feedback2;
                break;
            case 10:
                parameter = xFbk1;
                break;
            case 11:
                parameter = xFbk2;
                break;
            case 12:
                parameter = clear;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public Rate getTime1() {
        return time1;
    }

    public void setTime1(Rate time1) {
        this.time1 = time1;
    }

    public Rate getTime2() {
        return time2;
    }

    public void setTime2(Rate time2) {
        this.time2 = time2;
    }

    public GenericValue<Integer> getLevel1() {
        return level1;
    }

    public void setLevel1(int level1) {
        this.level1.setValue(level1);
    }

    public GenericValue<Integer> getLevel2() {
        return level2;
    }

    public void setLevel2(int level2) {
        this.level2.setValue(level2);
    }

    public PanValue getPan1() {
        return pan1;
    }

    public void setPan1(int pan1) {
        this.pan1.setValue(pan1);
    }

    public PanValue getPan2() {
        return pan2;
    }

    public void setPan2(int pan2) {
        this.pan2.setValue(pan2);
    }

    public GenericValue<Integer> getFeedback1() {
        return feedback1;
    }

    public void setFeedback1(int feedback1) {
        this.feedback1.setValue(feedback1);
    }

    public InsertPosition getInsert() {
        return insert;
    }

    public void setInsert(int insert) {
        this.insert.setValue(insert);
    }

    public GenericValue<Integer> getFeedback2() {
        return feedback2;
    }

    public void setFeedback2(int feedback2) {
        this.feedback2.setValue(feedback2);
    }

    public GenericValue<Integer> getXFbk1() {
        return xFbk1;
    }

    public void setXFbk1(int xFbk1) {
        this.xFbk1.setValue(xFbk1);
    }

    public GenericValue<Integer> getXFbk2() {
        return xFbk2;
    }

    public void setXFbk2(int xFbk2) {
        this.xFbk2.setValue(xFbk2);
    }

    public GenericValue<Boolean> isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear.setValue(clear);
    }
}
