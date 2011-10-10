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

import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.effects.Delay;

/**
 * Class for Echo (D) parameters.
 *
 * @author Carl Green
 */
public class EchoDual extends Delay {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Time1", "Time2", "Lvl 1", "Lvl 2", "Fbk 1", "Fbk 2", "Damp1", "Damp2", "Clear"
    };
    private static final String[] PARAMETER_UNITS = {
        "%", "-dB", ":", ":", "Lvl 1", "Lvl 2", "-%", "-%", "%", "%", "Clear"
    };

    private Rate time1;
    private Rate time2;
    private int level1;
    private int level2;
    private int feedback1;
    private int insert;
    private int feedback2;
    private int damp1;
    private int damp2;
    private boolean clear;

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
    }

    @Override
    public String getParameterUnit(final int parameterIndex) {
        return PARAMETER_UNITS[parameterIndex];
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

    public int getDamp1() {
        return damp1;
    }

    public void setDamp1(int damp1) {
        this.damp1 = damp1;
    }

    public int getDamp2() {
        return damp2;
    }

    public void setDamp2(int damp2) {
        this.damp2 = damp2;
    }

    public boolean isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }
}
