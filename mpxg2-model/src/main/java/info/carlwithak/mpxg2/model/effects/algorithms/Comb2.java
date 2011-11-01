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
import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.effects.Chorus;

/**
 * Class for Comb 2 parameters.
 *
 * @author Carl Green
 */
public class Comb2 extends Chorus {
    private static final String NAME = "Comb 2";

    private GenericValue<Integer> loCut = new GenericValue<Integer>("LoCut", "Hz", 100, 100000);
    private GenericValue<Integer> hiCut = new GenericValue<Integer>("HiCut", "Hz", 100, 100000);
    private GenericValue<Integer> comb = new GenericValue<Integer>("Comb", "", 0, 100);
    private GenericValue<Integer> notch = new GenericValue<Integer>("Notch", "", -100, 100);
    private Rate rate;
    private GenericValue<Integer> pulseWidth = new GenericValue<Integer>("PW", "%", 0, 100);
    private GenericValue<Integer> depth = new GenericValue<Integer>("Dpth", "%", 0, 100);
    private GenericValue<Integer> resonance = new GenericValue<Integer>("Res", "", -100, 100);
    private GenericValue<Integer> phase = new GenericValue<Integer>("Phase", "°", 0, 3);

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
                parameter = loCut;
                break;
            case 3:
                parameter = hiCut;
                break;
            case 4:
                parameter = comb;
                break;
            case 5:
                parameter = notch;
                break;
            case 6:
                parameter = rate;
                break;
            case 7:
                parameter = pulseWidth;
                break;
            case 8:
                parameter = depth;
                break;
            case 9:
                parameter = resonance;
                break;
            case 10:
                parameter = phase;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public int getLoCut() {
        return loCut.getValue();
    }

    public void setLoCut(int loCut) {
        this.loCut.setValue(loCut);
    }

    public int getHiCut() {
        return hiCut.getValue();
    }

    public void setHiCut(int hiCut) {
        this.hiCut.setValue(hiCut);
    }

    public int getComb() {
        return comb.getValue();
    }

    public void setComb(int comb) {
        this.comb.setValue(comb);
    }

    public int getNotch() {
        return notch.getValue();
    }

    public void setNotch(int notch) {
        this.notch.setValue(notch);
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public int getPulseWidth() {
        return pulseWidth.getValue();
    }

    public void setPulseWidth(int pulseWidth) {
        this.pulseWidth.setValue(pulseWidth);
    }

    public int getDepth() {
        return depth.getValue();
    }

    public void setDepth(int depth) {
        this.depth.setValue(depth);
    }

    public int getResonance() {
        return resonance.getValue();
    }

    public void setResonance(int resonance) {
        this.resonance.setValue(resonance);
    }

    public int getPhase() {
        return phase.getValue();
    }

    public void setPhase(int phase) {
        this.phase.setValue(phase);
    }
}