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

import info.carlwithak.mpxg2.model.effects.Delay;
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.InsertPosition;
import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;
import info.carlwithak.mpxg2.model.parameters.Rate;

/**
 * Class for Echo (S) parameters.
 *
 * @author Carl Green
 */
public class EchoStereo extends Delay {
    private static final String NAME = "Echo (S)";

    private Rate time;
    public final GenericValue<Integer> feedback = new GenericValue<>("Fbk", "%", -100, 100);
    public final InsertPosition insert = new InsertPosition("Fbk insert");
    public final GenericValue<Integer> damp = new GenericValue<>("Damp", "%", 0, 100);
    public final OnOffValue clear = new OnOffValue("Clear");

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
                parameter = time;
                break;
            case 3:
                parameter = feedback;
                break;
            case 4:
                parameter = damp;
                break;
            case 5:
                parameter = clear;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public Rate getTime() {
        return time;
    }

    public void setTime(Rate time) {
        this.time = time;
    }

}
