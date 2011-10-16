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

import info.carlwithak.mpxg2.model.effects.Eq;

/**
 * Class for 1-Band (M) parameters.
 *
 * @author Carl Green
 */
public class OneBandMono extends Eq {
    private int gain;
    private int fc;
    private double q;
    private int mode;

    public int getGain() {
        return gain;
    }

    public void setGain(final int gain) {
        this.gain = gain;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(final int fc) {
        this.fc = fc;
    }

    public double getQ() {
        return q;
    }

    public void setQ(final double q) {
        this.q = q;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(final int mode) {
        this.mode = mode;
    }
}
