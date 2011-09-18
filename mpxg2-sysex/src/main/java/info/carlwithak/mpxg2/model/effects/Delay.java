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

package info.carlwithak.mpxg2.model.effects;

/**
 * Base class for Delay effects.
 *
 * @author Carl Green
 */
public class Delay {
    private int mix;
    private int level;
    private int time1Echoes;
    private int time1Beat;
    private int time2Echoes;
    private int time2Beat;
    private int level1;
    private int level2;
    private int feedback1;
    private int insert;
    private int feedback2;
    private int damp1;
    private int damp2;
    private int clear;

    public int getMix() {
        return mix;
    }

    public void setMix(int mix) {
        this.mix = mix;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public int getClear() {
        return clear;
    }

    public void setClear(int clear) {
        this.clear = clear;
    }
}
