/*
 *  Copyright (C) 2012 Carl Green
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

package info.carlwithak.mpxg2.model;

import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.Parameter;
import info.carlwithak.mpxg2.model.parameters.SourceValue;
import info.carlwithak.mpxg2.model.parameters.TempoBeatValue;
import info.carlwithak.mpxg2.model.parameters.TempoSourceValue;

/**
 *
 * @author Carl Green
 */
public class Tempo implements DataObject {
    private GenericValue<Integer> rate = new GenericValue<Integer>("Rate", " BPM", 41, 400);
    private TempoSourceValue source = new TempoSourceValue("Source");
    private TempoBeatValue beatValue = new TempoBeatValue("Beat Value");
    private SourceValue tapSource = new SourceValue("Tap Source");
    private GenericValue<Integer> tapAverage = new GenericValue<Integer>("Tap Average", " beats", 2, 8);
    private GenericValue<Integer> tapSourceLevel = new GenericValue<Integer>("Tap Source Level", "", 0, 127);

    @Override
    public Parameter getParameter(final int parameterIndex) {
        Parameter parameter;
        switch (parameterIndex) {
            case 0:
                parameter = rate;
                break;
            case 1:
                parameter = source;
                break;
            case 2:
                parameter = beatValue;
                break;
            case 3:
                parameter = tapSource;
                break;
            case 4:
                parameter = tapAverage;
                break;
            case 5:
                parameter = tapSourceLevel;
                break;
            default:
                parameter = null;
        }
        return parameter;
    }

    public GenericValue<Integer> getRate() {
        return rate;
    }

    public TempoSourceValue getSource() {
        return source;
    }

    public TempoBeatValue getBeatValue() {
        return beatValue;
    }

    public SourceValue getTapSource() {
        return tapSource;
    }

    public GenericValue<Integer> getTapAverage() {
        return tapAverage;
    }

    public GenericValue<Integer> getTapSourceLevel() {
        return tapSourceLevel;
    }

}
