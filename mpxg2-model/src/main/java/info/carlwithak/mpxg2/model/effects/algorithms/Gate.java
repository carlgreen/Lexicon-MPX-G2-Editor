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
import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;

/**
 * Class for Gate parameters.
 *
 * @author Carl Green
 */
public class Gate extends Reverb {
    private static final String NAME = "Gate";

    private GenericValue<Integer> time = new GenericValue<Integer>("Time", "ms", 140, 700);
    private OnOffValue link = new OnOffValue("Link");
    private GenericValue<Integer> diff = new GenericValue<Integer>("Diff", "%", 0, 100);
    private GenericValue<Integer> preDelay = new GenericValue<Integer>("P Dly", "ms", 0, 250);
    private GenericValue<Integer> loSlope = new GenericValue<Integer>("LoSlp", "", -16, 16);
    private GenericValue<Integer> hiSlope = new GenericValue<Integer>("HiSlp", "", -16, 16);
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
                parameter = time;
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
                parameter = loSlope;
                break;
            case 7:
                parameter = hiSlope;
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

    public GenericValue<Integer> getTime() {
        return time;
    }

    public OnOffValue isLink() {
        return link;
    }

    public GenericValue<Integer> getDiff() {
        return diff;
    }

    public GenericValue<Integer> getPreDelay() {
        return preDelay;
    }

    public GenericValue<Integer> getLoSlope() {
        return loSlope;
    }

    public GenericValue<Integer> getHiSlope() {
        return hiSlope;
    }

    public GenericValue<Integer> getXovr() {
        return xovr;
    }

    public GenericValue<Integer> getRtHC() {
        return rtHC;
    }

    public GenericValue<Integer> getShape() {
        return shape;
    }

    public GenericValue<Integer> getSpred() {
        return spred;
    }

}
