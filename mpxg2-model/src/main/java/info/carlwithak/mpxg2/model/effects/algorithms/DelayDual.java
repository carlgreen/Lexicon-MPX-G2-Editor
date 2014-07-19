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
import info.carlwithak.mpxg2.model.parameters.PanValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;
import info.carlwithak.mpxg2.model.parameters.Rate;

/**
 * Class for Delay (D) parameters.
 *
 * @author Carl Green
 */
public class DelayDual extends Delay {
    private static final String NAME = "Delay (D)";

    private Rate time1;
    private Rate time2;
    public final GenericValue<Integer> level1 = new GenericValue<>("Lvl 1", "dB", -90, 6);
    public final GenericValue<Integer> level2 = new GenericValue<>("Lvl 2", "dB", -90, 6);
    public final PanValue pan1 = new PanValue("Pan 1", -50, 50);
    public final PanValue pan2 = new PanValue("Pan 2", -50, 50);
    public final GenericValue<Integer> feedback1 = new GenericValue<>("Fbk 1", "%", -100, 100);
    public final InsertPosition insert = new InsertPosition("Fbk insert");
    public final GenericValue<Integer> feedback2 = new GenericValue<>("Fbk 2", "%", -100, 100);
    public final GenericValue<Integer> xFbk1 = new GenericValue<>("XFbk1", "%", -100, 100);
    public final GenericValue<Integer> xFbk2 = new GenericValue<>("XFbk2", "%", -100, 100);
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
                parameter = time1;
                break;
            case 3:
                parameter = time2;
                break;
            case 4:
                parameter = level1;
                break;
            case 5:
                parameter = level2;
                break;
            case 6:
                parameter = pan1;
                break;
            case 7:
                parameter = pan2;
                break;
            case 8:
                parameter = feedback1;
                break;
            case 9:
                parameter = feedback2;
                break;
            case 10:
                parameter = xFbk1;
                break;
            case 11:
                parameter = xFbk2;
                break;
            case 12:
                parameter = clear;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public Rate getTime1() {
        return time1;
    }

    public void setTime1(Rate time1) {
        this.time1 = time1;
    }

    public Rate getTime2() {
        return time2;
    }

    public void setTime2(Rate time2) {
        this.time2 = time2;
    }

}
