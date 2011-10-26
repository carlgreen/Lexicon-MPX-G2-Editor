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
import info.carlwithak.mpxg2.model.effects.Reverb;

/**
 * Class for Hall parameters.
 *
 * @author Carl Green
 */
public class Hall extends Reverb {
    private static final String[] PARAMETER_NAMES = {
        "Mix", "Level", "Size", "Link", "Diff", "P Dly", "Bass", "Decay", "Xovr", "Rt HC", "Shape", "Spred"
    };

    private GenericValue<Double> size = new GenericValue<Double>("m", 20.0, 76.0);
    private GenericValue<Boolean> link = new GenericValue<Boolean>("OnOff", false, true);
    private GenericValue<Integer> diff = new GenericValue<Integer>("%", 0, 100);
    private GenericValue<Integer> preDelay = new GenericValue<Integer>("ms", 0, 250);
    private GenericValue<Integer> bass = new GenericValue<Integer>("x", 0, 255); // 0.2 - 4.0
    private GenericValue<Integer> decay = new GenericValue<Integer>("s", 0, 255); // 0.12 - 65.4
    private GenericValue<Integer> xovr = new GenericValue<Integer>("Hz", 0, 255); // 30 - 24700
    private GenericValue<Integer> rtHC = new GenericValue<Integer>("Hz", 0, 255); // 525 - 24700
    private GenericValue<Integer> shape = new GenericValue<Integer>("", 0, 255);
    private GenericValue<Integer> spred = new GenericValue<Integer>("", 0, 255);

    @Override
    public String getParameterName(final int destinationParameter) {
        return PARAMETER_NAMES[destinationParameter];
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
                parameter = size;
                break;
            case 3:
                parameter = link;
                break;
            case 4:
                parameter = diff;
                break;
            case 5:
                parameter = preDelay;
                break;
            case 6:
                parameter = bass;
                break;
            case 7:
                parameter = decay;
                break;
            case 8:
                parameter = xovr;
                break;
            case 9:
                parameter = rtHC;
                break;
            case 10:
                parameter = shape;
                break;
            case 11:
                parameter = spred;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public double getSize() {
        return size.getValue();
    }

    public void setSize(double size) {
        this.size.setValue(size);
    }

    public boolean isLink() {
        return link.getValue();
    }

    public void setLink(boolean link) {
        this.link.setValue(link);
    }

    public int getDiff() {
        return diff.getValue();
    }

    public void setDiff(int diff) {
        this.diff.setValue(diff);
    }

    public int getPreDelay() {
        return preDelay.getValue();
    }

    public void setPreDelay(int preDelay) {
        this.preDelay.setValue(preDelay);
    }

    public int getBass() {
        return bass.getValue();
    }

    public void setBass(int bass) {
        this.bass.setValue(bass);
    }

    public int getDecay() {
        return decay.getValue();
    }

    public void setDecay(int decay) {
        this.decay.setValue(decay);
    }

    public int getXovr() {
        return xovr.getValue();
    }

    public void setXovr(int xovr) {
        this.xovr.setValue(xovr);
    }

    public int getRtHC() {
        return rtHC.getValue();
    }

    public void setRtHC(int rtHC) {
        this.rtHC.setValue(rtHC);
    }

    public int getShape() {
        return shape.getValue();
    }

    public void setShape(int shape) {
        this.shape.setValue(shape);
    }

    public int getSpred() {
        return spred.getValue();
    }

    public void setSpred(int spred) {
        this.spred.setValue(spred);
    }

}
