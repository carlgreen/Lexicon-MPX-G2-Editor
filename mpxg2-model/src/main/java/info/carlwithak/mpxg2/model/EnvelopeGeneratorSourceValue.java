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

/**
 *
 * @author Carl Green
 */
public class EnvelopeGeneratorSourceValue extends GenericValue<Integer> {

    private final static String[] ENVELOPE_GENERATOR_SOURCES = {
        "Off", "In", "Ret L", "Ret R", "Raw L", "Raw R", "FX 1 L", "FX 1 R",
        "FX 2 L", "FX 2 R", "Chrs L", "Chrs R", "EQ L", "EQ R", "Rvb L", "Rvb R",
        "Dly L", "Dly R", "PreOut", "MainL", "MainR"
    };

    public EnvelopeGeneratorSourceValue(final String name) {
        super(name, "", 0, 20);
    }

    @Override
    public String getDisplayString() {
        return ENVELOPE_GENERATOR_SOURCES[getValue()];
    }

}
