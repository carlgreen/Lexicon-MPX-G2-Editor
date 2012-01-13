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

package info.carlwithak.mpxg2.model.parameters;

/**
 * Holds a rate measure in things (eg cycles, echoes) per beat.
 *
 * @author Carl Green
 */
public class BeatRate implements Rate {

    private String name;
    private Integer measures;
    private Integer beats;

    public BeatRate(final String name, final Integer measures, final Integer beats) {
        this.name = name;
        this.measures = measures;
        this.beats = beats;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final String getUnit() {
        return ":";
    }

    public Integer getMeasures() {
        return measures;
    }

    public void setMeasures(final Integer measures) {
        this.measures = measures;
    }

    public Integer getBeats() {
        return beats;
    }

    public void setBeats(final Integer beats) {
        this.beats = beats;
    }

    @Override
    public boolean isSet() {
        return getMeasures() != null || getBeats() != null;
    }

    @Override
    public String getDisplayString() {
        return getMeasures() + ":" + getBeats();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BeatRate other = (BeatRate) obj;
        if (this.measures == null) {
            return other.measures == null;
        }
        if (!this.measures.equals(other.measures)) {
            return false;
        }
        if (this.beats == null) {
            return other.beats == null;
        }
        if (!this.beats.equals(other.beats)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.measures;
        hash = 59 * hash + this.beats;
        return hash;
    }

    @Override
    public String toString() {
        return "BeatRate{" + "measures=" + measures + ",beats=" + beats + '}';
    }
}
