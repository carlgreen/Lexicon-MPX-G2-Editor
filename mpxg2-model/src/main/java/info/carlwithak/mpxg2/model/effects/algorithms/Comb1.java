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
import info.carlwithak.mpxg2.model.effects.Chorus;

/**
 * Class for Comb 1 parameters.
 *
 * @author Carl Green
 */
public class Comb1 extends Chorus {
    private static final String NAME = "Comb 1";

    private GenericValue<Integer> loCut = new GenericValue<Integer>("LoCut", "Hz", 100, 100000);
    private GenericValue<Integer> hiCut = new GenericValue<Integer>("HiCut", "Hz", 100, 100000);
    private GenericValue<Integer> comb = new GenericValue<Integer>("Comb", "", 0, 100);
    private GenericValue<Integer> notch = new GenericValue<Integer>("Notch", "", -100, 100);

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
}