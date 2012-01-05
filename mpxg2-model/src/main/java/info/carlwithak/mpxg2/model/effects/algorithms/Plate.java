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

import info.carlwithak.mpxg2.model.BassValue;
import info.carlwithak.mpxg2.model.CrossoverValue;
import info.carlwithak.mpxg2.model.DecayTimeValue;
import info.carlwithak.mpxg2.model.GenericValue;
import info.carlwithak.mpxg2.model.HighCutValue;
import info.carlwithak.mpxg2.model.OnOffValue;
import info.carlwithak.mpxg2.model.Parameter;
import info.carlwithak.mpxg2.model.ReverbSpredValue;
import info.carlwithak.mpxg2.model.effects.Reverb;

/**
 * Class for Plate parameters.
 *
 * @author Carl Green
 */
public class Plate extends Reverb {
    private static final String NAME = "Plate";

    private GenericValue<Double> size = new GenericValue<Double>("Size", "m", 4.0, 76.0);
    private OnOffValue link = new OnOffValue("Link");
    private GenericValue<Integer> diff = new GenericValue<Integer>("Diff", "%", 0, 100);
    private GenericValue<Integer> preDelay = new GenericValue<Integer>("P Dly", "ms", 0, 250);
    private BassValue bass = new BassValue("Bass");
    private DecayTimeValue decay = new DecayTimeValue("Decay", link, size);
    private CrossoverValue xovr = new CrossoverValue("Xovr");
    private HighCutValue rtHC = new HighCutValue("Rt HC");
    private GenericValue<Integer> shape = new GenericValue<Integer>("Shape", "", 0, 255);
    private ReverbSpredValue spred = new ReverbSpredValue("Spred", link, size);

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

    public OnOffValue isLink() {
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

    public BassValue getBass() {
        return bass;
    }

    public void setBass(int bass) {
        this.bass.setValue(bass);
    }

    public DecayTimeValue getDecay() {
        return decay;
    }

    public void setDecay(int decay) {
        this.decay.setValue(decay);
    }

    public CrossoverValue getXovr() {
        return xovr;
    }

    public void setXovr(int xovr) {
        this.xovr.setValue(xovr);
    }

    public HighCutValue getRtHC() {
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

    public ReverbSpredValue getSpred() {
        return spred;
    }

    public void setSpred(int spred) {
        this.spred.setValue(spred);
    }

}
