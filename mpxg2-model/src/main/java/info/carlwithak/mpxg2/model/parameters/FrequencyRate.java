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
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Holds a rate measure in hertz.
 *
 * @author Carl Green
 */
public class FrequencyRate implements Rate {

    private static final DecimalFormat DECIMAL_2DP = new DecimalFormat("0.00");

    private final String name;
    private Double frequency;

    public FrequencyRate(final String name, final Double frequency) {
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

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(final Double frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean isSet() {
        return getFrequency() != null;
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
        if (this.frequency == null || other.frequency == null) {
            return this.frequency == null && other.frequency == null;
        }
        return new EqualsBuilder().append(this.frequency.doubleValue(), other.frequency.doubleValue()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(5, 13)
                .append(this.frequency.doubleValue())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("frequency", frequency)
                .toString();
    }
}
