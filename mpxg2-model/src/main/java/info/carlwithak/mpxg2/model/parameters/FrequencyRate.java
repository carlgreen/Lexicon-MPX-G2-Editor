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

import java.text.DecimalFormat;

/**
 * Holds a rate measure in hertz.
 *
 * @author Carl Green
 */
public class FrequencyRate implements Rate {

    private static final DecimalFormat DECIMAL_2DP = new DecimalFormat("0.00");

    private String name;
    private double frequency;

    public FrequencyRate(final String name, final double frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final String getUnit() {
        return "Hz";
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(final double frequency) {
        this.frequency = frequency;
    }

    @Override
    public String getDisplayString() {
        return DECIMAL_2DP.format(getFrequency()) + "Hz";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FrequencyRate other = (FrequencyRate) obj;
        if (Double.doubleToLongBits(this.frequency) != Double.doubleToLongBits(other.frequency)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.frequency) ^ (Double.doubleToLongBits(this.frequency) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "FrequencyRate{" + "frequency=" + frequency + '}';
    }
}
