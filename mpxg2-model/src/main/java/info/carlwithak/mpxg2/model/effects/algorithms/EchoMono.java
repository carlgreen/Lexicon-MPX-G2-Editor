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
 * Class for Echo (M) parameters.
 *
 * @author Carl Green
 */
public class EchoMono extends Delay {
    private static final String[] PARAMETER_UNITS = {
        "%", "dB", ":", "-%", "%", "Clear"
    };

    private int timeEchoes;
    private int timeBeat;
    private int feedback;
    private int insert;
    private int damp;
    private int clear;

    public String getParameterUnit(final int parameterIndex) {
        return PARAMETER_UNITS[parameterIndex];
    }

    public int getTimeEchoes() {
        return timeEchoes;
    }

    public void setTimeEchoes(int timeEchoes) {
        this.timeEchoes = timeEchoes;
    }

    public int getTimeBeat() {
        return timeBeat;
    }

    public void setTimeBeat(int timeBeat) {
        this.timeBeat = timeBeat;
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public int getInsert() {
        return insert;
    }

    public void setInsert(int insert) {
        this.insert = insert;
    }

    public int getDamp() {
        return damp;
    }

    public void setDamp(int damp) {
        this.damp = damp;
    }

    public int getClear() {
        return clear;
    }

    public void setClear(int clear) {
        this.clear = clear;
    }
}
