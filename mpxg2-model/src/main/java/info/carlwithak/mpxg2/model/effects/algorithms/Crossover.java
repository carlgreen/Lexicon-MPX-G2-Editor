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
import info.carlwithak.mpxg2.model.effects.Eq;

/**
 * Class for Crossover parameters.
 *
 * @author Carl Green
 */
public class Crossover extends Eq {
    private static final String NAME = "Crossover";

    private GenericValue<Integer> fc = new GenericValue<Integer>("Fc", "Hz", 100, 10000);
    private GenericValue<Integer> balance = new GenericValue<Integer>("Bal", "", -50, 50);

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
                parameter = fc;
                break;
            case 3:
                parameter = balance;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc.setValue(fc);
    }

    public GenericValue<Integer> getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance.setValue(balance);
    }

}
