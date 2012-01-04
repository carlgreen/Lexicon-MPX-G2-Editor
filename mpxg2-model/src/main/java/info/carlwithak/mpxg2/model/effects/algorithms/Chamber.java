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
 * Class for Chamber parameters.
 *
 * @author Carl Green
 */
public class Chamber extends Reverb {
    private static final String NAME = "Chamber";

    private GenericValue<Double> size = new GenericValue<Double>("Size", "m", 4.0, 35.0);
    private GenericValue<Boolean> link = new GenericValue<Boolean>("Link", "OnOff", false, true);
    private GenericValue<Integer> diff = new GenericValue<Integer>("Diff", "%", 0, 100);
    private GenericValue<Integer> preDelay = new GenericValue<Integer>("P Dly", "ms", 0, 250);
    private GenericValue<Integer> bass = new GenericValue<Integer>("Bass", "X", 0, 255); // 0.2 - 4.0
    private GenericValue<Integer> decay = new GenericValue<Integer>("Decay", "s", 0, 255); // 0.07 - 65.4
    private GenericValue<Integer> xovr = new GenericValue<Integer>("Xovr", "Hz", 0, 255); // 30 - 24700
    private GenericValue<Integer> rtHC = new GenericValue<Integer>("Rt HC", "Hz", 0, 255); // 525 - 24700
    private GenericValue<Integer> shape = new GenericValue<Integer>("Shape", "", 0, 255);
    private GenericValue<Integer> spred = new GenericValue<Integer>("Spred", "", 0, 255);

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

    public GenericValue<Double> getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size.setValue(size);
    }

    public GenericValue<Boolean> isLink() {
        return link;
    }

    public void setLink(boolean link) {
        this.link.setValue(link);
    }

    public GenericValue<Integer> getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff.setValue(diff);
    }

    public GenericValue<Integer> getPreDelay() {
        return preDelay;
    }

    public void setPreDelay(int preDelay) {
        this.preDelay.setValue(preDelay);
    }

    public GenericValue<Integer> getBass() {
        return bass;
    }

    public void setBass(int bass) {
        this.bass.setValue(bass);
    }

    public GenericValue<Integer> getDecay() {
        return decay;
    }

    public void setDecay(int decay) {
        this.decay.setValue(decay);
    }

    public GenericValue<Integer> getXovr() {
        return xovr;
    }

    public void setXovr(int xovr) {
        this.xovr.setValue(xovr);
    }

    public GenericValue<Integer> getRtHC() {
        return rtHC;
    }

    public void setRtHC(int rtHC) {
        this.rtHC.setValue(rtHC);
    }

    public GenericValue<Integer> getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape.setValue(shape);
    }

    public GenericValue<Integer> getSpred() {
        return spred;
    }

    public void setSpred(int spred) {
        this.spred.setValue(spred);
    }

}
