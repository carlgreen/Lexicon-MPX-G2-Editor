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

/**
 * Class for Delay (D) parameters.
 *
 * @author Carl Green
 */
public class DelayDual extends Delay {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Time", "Fbk", "Damp", "Clear"
    };
    private static final String[] PARAMETER_UNITS = {
        "%", "dB", ":", ":", "Lvl 1", "Lvl 2", "Pan", "Pan", "-%", "-%", "%", "%", "Clear"
    };

    private int time1Echoes;
    private int time1Beat;
    private int time2Echoes;
    private int time2Beat;
    private int level1;
    private int level2;
    private int pan1;
    private int pan2;
    private int feedback1;
    private int insert;
    private int feedback2;
    private int xFbk1;
    private int xFbk2;
    private boolean clear;

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
    }

    @Override
    public String getParameterUnit(final int parameterIndex) {
        return PARAMETER_UNITS[parameterIndex];
    }

    public int getTime1Echoes() {
        return time1Echoes;
    }

    public void setTime1Echoes(int time1Echoes) {
        this.time1Echoes = time1Echoes;
    }

    public int getTime1Beat() {
        return time1Beat;
    }

    public void setTime1Beat(int time1Beat) {
        this.time1Beat = time1Beat;
    }

    public int getTime2Echoes() {
        return time2Echoes;
    }

    public void setTime2Echoes(int time2Echoes) {
        this.time2Echoes = time2Echoes;
    }

    public int getTime2Beat() {
        return time2Beat;
    }

    public void setTime2Beat(int time2Beat) {
        this.time2Beat = time2Beat;
    }

    public int getLevel1() {
        return level1;
    }

    public void setLevel1(int level1) {
        this.level1 = level1;
    }

    public int getLevel2() {
        return level2;
    }

    public void setLevel2(int level2) {
        this.level2 = level2;
    }

    public int getPan1() {
        return pan1;
    }

    public void setPan1(int pan1) {
        this.pan1 = pan1;
    }

    public int getPan2() {
        return pan2;
    }

    public void setPan2(int pan2) {
        this.pan2 = pan2;
    }

    public int getFeedback1() {
        return feedback1;
    }

    public void setFeedback1(int feedback1) {
        this.feedback1 = feedback1;
    }

    public int getInsert() {
        return insert;
    }

    public void setInsert(int insert) {
        this.insert = insert;
    }

    public int getFeedback2() {
        return feedback2;
    }

    public void setFeedback2(int feedback2) {
        this.feedback2 = feedback2;
    }

    public int getXFbk1() {
        return xFbk1;
    }

    public void setXFbk1(int xFbk1) {
        this.xFbk1 = xFbk1;
    }

    public int getXFbk2() {
        return xFbk2;
    }

    public void setXFbk2(int xFbk2) {
        this.xFbk2 = xFbk2;
    }

    public boolean isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }
}
