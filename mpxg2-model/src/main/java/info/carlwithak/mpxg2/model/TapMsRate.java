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
 *
 * @author Carl Green
 */
public class TapMsRate implements Rate {
    // TODO surely this has no place here
    private String name;
    private int ms;

    public TapMsRate(final String name, final int ms) {
        this.name = name;
        this.ms = ms;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final String getUnit() {
        return "ms";
    }

    public int getMs() {
        return ms;
    }

    public void setMs(final int ms) {
        this.ms = ms;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TapMsRate other = (TapMsRate) obj;
        if (this.ms != other.ms) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.ms;
        return hash;
    }

    @Override
    public String toString() {
        return "TapMsRate{" + "ms=" + ms + '}';
    }

}
