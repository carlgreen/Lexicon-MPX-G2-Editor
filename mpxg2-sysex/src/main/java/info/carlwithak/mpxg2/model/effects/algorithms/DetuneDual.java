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

import info.carlwithak.mpxg2.model.effects.Effect;

/**
 * Class for Detune (D) parameters.
 *
 * @author Carl Green
 */
public class DetuneDual extends Effect {
    private int tune1;
    private int optimize;
    private int tune2;
    private int preDelay;

    public int getTune1() {
        return tune1;
    }

    public void setTune1(int tune1) {
        this.tune1 = tune1;
    }

    public int getOptimize() {
        return optimize;
    }

    public void setOptimize(int optimize) {
        this.optimize = optimize;
    }

    public int getTune2() {
        return tune2;
    }

    public void setTune2(int tune2) {
        this.tune2 = tune2;
    }

    public int getPreDelay() {
        return preDelay;
    }

    public void setPreDelay(int preDelay) {
        this.preDelay = preDelay;
    }
}