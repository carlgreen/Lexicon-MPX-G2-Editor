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
    private GenericValue<Integer> pan1 = new GenericValue<Integer>("Pan 1", "LCR", -50, 50);
    private GenericValue<Integer> pan2 = new GenericValue<Integer>("Pan 2", "LCR", -50, 50);
    private GenericValue<Integer> feedback1 = new GenericValue<Integer>("Fbk 1", "%", -100, 100);
    private int insert;
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

    public int getLevel1() {
        return level1.getValue();
    }

    public void setLevel1(int level1) {
        this.level1.setValue(level1);
    }

    public int getLevel2() {
        return level2.getValue();
    }

    public void setLevel2(int level2) {
        this.level2.setValue(level2);
    }

    public int getPan1() {
        return pan1.getValue();
    }

    public void setPan1(int pan1) {
        this.pan1.setValue(pan1);
    }

    public int getPan2() {
        return pan2.getValue();
    }

    public void setPan2(int pan2) {
        this.pan2.setValue(pan2);
    }

    public int getFeedback1() {
        return feedback1.getValue();
    }

    public void setFeedback1(int feedback1) {
        this.feedback1.setValue(feedback1);
    }

    public int getInsert() {
        return insert;
    }

    public void setInsert(int insert) {
        this.insert = insert;
    }

    public int getFeedback2() {
        return feedback2.getValue();
    }

    public void setFeedback2(int feedback2) {
        this.feedback2.setValue(feedback2);
    }

    public int getXFbk1() {
        return xFbk1.getValue();
    }

    public void setXFbk1(int xFbk1) {
        this.xFbk1.setValue(xFbk1);
    }

    public int getXFbk2() {
        return xFbk2.getValue();
    }

    public void setXFbk2(int xFbk2) {
        this.xFbk2.setValue(xFbk2);
    }

    public boolean isClear() {
        return clear.getValue();
    }

    public void setClear(boolean clear) {
        this.clear.setValue(clear);
    }
}
