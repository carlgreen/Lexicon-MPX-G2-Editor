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

package info.carlwithak.mpxg2.model;

/**
 * Holds a rate measure in things (eg cycles, echoes) per beat.
 *
 * @author Carl Green
 */
public class BeatRate implements Rate {
    private int measures;
    private int beats;

    public BeatRate(final int measures, final int beats) {
        this.measures = measures;
        this.beats = beats;
    }

    public int getMeasures() {
        return measures;
    }

    public void setMeasures(final int measures) {
        this.measures = measures;
    }

    public int getBeats() {
        return beats;
    }

    public void setBeats(final int beats) {
        this.beats = beats;
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
        if (this.measures != other.measures) {
            return false;
        }
        if (this.beats != other.beats) {
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
