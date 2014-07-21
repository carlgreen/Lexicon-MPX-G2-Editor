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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Carl Green
 */
public class TapMsRate implements Rate {

    private final String name;
    private Integer ms;

    public TapMsRate(final String name, final Integer ms) {
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

    public Integer getMs() {
        return ms;
    }

    public void setMs(final Integer ms) {
        this.ms = ms;
    }

    @Override
    public boolean isSet() {
        return getMs() != null;
    }

    @Override
    public String getDisplayString() {
        return getMs() + "ms";
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
        return new EqualsBuilder()
                .append(this.ms, other.ms)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(7, 53)
                .append(this.ms)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("ms", ms)
                .toString();
    }

}
