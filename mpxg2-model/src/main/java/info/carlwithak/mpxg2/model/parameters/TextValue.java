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

package info.carlwithak.mpxg2.model.parameters;

/**
 *
 * @author Carl Green
 */
public class TextValue implements Parameter {
    private final String name;
    private final int maxLength;
    private String value;

    public TextValue(final String name, final int maxLength) {
        this.name = name;
        this.maxLength = maxLength;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUnit() {
        return null;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    @Override
    public boolean isSet() {
        return value != null;
    }

    @Override
    public String getDisplayString() {
        return value;
    }

}
