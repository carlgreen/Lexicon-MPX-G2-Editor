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

import info.carlwithak.mpxg2.model.effects.Effect2;

/**
 * Class for Panner parameters.
 *
 * @author Carl Green
 */
public class Panner extends Effect2 {
    private int pan1;
    private int pan2;

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
}
