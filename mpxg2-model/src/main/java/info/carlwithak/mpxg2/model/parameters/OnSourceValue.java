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
public class OnSourceValue extends GenericValue<Integer> {

    private final static String[] ON_SOURCES = {
        "None", "Off", "On", "Knob", "Puls1", "Tri1", "Sine1", "Cos1", "Puls2",
        "Tri2", "Sine2", "Cos2", "Rand", "Env", "InLvl", "RnLvl", "A/B", "ATrg",
        "BTrg", "ABTrg", "Pedal", "Tog1", "Tog2", "Tog3", "Sw1", "Sw2", "Sw3",
        "CC1", "CC2", "CC3", "CC4", "CC5", "CC6", "CC7", "CC8", "CC9", "CC10",
        "CC11", "CC12", "CC13", "CC14", "CC15", "CC16", "CC17", "CC18", "CC19",
        "CC20", "CC21", "CC22", "CC23", "CC24", "CC25", "CC26", "CC27", "CC28",
        "CC29", "CC30", "CC31", "CC32", "CC33", "CC34", "CC35", "CC36", "CC37",
        "CC38", "CC39", "CC40", "CC41", "CC42", "CC43", "CC44", "CC45", "CC46",
        "CC47", "CC48", "CC49", "CC50", "CC51", "CC52", "CC53", "CC54", "CC55",
        "CC56", "CC57", "CC58", "CC59", "CC60", "CC61", "CC62", "CC63", "CC64",
        "CC65", "CC66", "CC67", "CC68", "CC69", "CC70", "CC71", "CC72", "CC73",
        "CC74", "CC75", "CC76", "CC77", "CC78", "CC79", "CC80", "CC81", "CC82",
        "CC83", "CC84", "CC85", "CC86", "CC87", "CC88", "CC89", "CC90", "CC91",
        "CC92", "CC93", "CC94", "CC95", "CC96", "CC97", "CC98", "CC99", "CC100",
        "CC101", "CC102", "CC103", "CC104", "CC105", "CC106", "CC107", "CC108",
        "CC109", "CC110", "CC111", "CC112", "CC113", "CC114", "CC115", "CC116",
        "CC117", "CC118", "CC119", "Bend", "Touch", "Vel", "Last♪", "Low♪",
        "High♪", "Tempo", "Cmds", "Gate", "Trig", "LGate", "TSw", "Toe"
    };

    public OnSourceValue(final String name) {
        super(name, "", 0, 158);
    }

    @Override
    public String getDisplayString() {
        return ON_SOURCES[getValue()];
    }

}
