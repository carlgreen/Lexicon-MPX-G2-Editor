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

import info.carlwithak.mpxg2.model.effects.Reverb;

/**
 * Class for Plate parameters.
 *
 * @author Carl Green
 */
public class Plate extends Reverb {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Size", "Link", "Diff", "P Dly", "Bass", "Decay", "Xovr", "Rt HC", "Shape", "Spred"
    };
    private static final String[] PARAMETER_UNITS = {
        "%", "-dB", "Size", "Link", "Diff", "P Dly", "Bass", "s", "Xovr", "Rt HC", "Shape", "Spred"
    };

    private double size;
    private int link;
    private int diff;
    private int preDelay;
    private int bass;
    private int decay;
    private int xovr;
    private int rtHC;
    private int shape;
    private int spred;

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
    }

    @Override
    public String getParameterUnit(final int parameterIndex) {
        return PARAMETER_UNITS[parameterIndex];
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public int getPreDelay() {
        return preDelay;
    }

    public void setPreDelay(int preDelay) {
        this.preDelay = preDelay;
    }

    public int getBass() {
        return bass;
    }

    public void setBass(int bass) {
        this.bass = bass;
    }

    public int getDecay() {
        return decay;
    }

    public void setDecay(int decay) {
        this.decay = decay;
    }

    public int getXovr() {
        return xovr;
    }

    public void setXovr(int xovr) {
        this.xovr = xovr;
    }

    public int getRtHC() {
        return rtHC;
    }

    public void setRtHC(int rtHC) {
        this.rtHC = rtHC;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public int getSpred() {
        return spred;
    }

    public void setSpred(int spred) {
        this.spred = spred;
    }

}
