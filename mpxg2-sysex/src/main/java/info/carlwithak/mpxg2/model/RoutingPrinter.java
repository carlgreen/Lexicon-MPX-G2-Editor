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
 * Class to print out a program's routing nicely.
 *
 * @author Carl Green
 */
public class RoutingPrinter {

    private static final String[] ROUTING_EFFECT_IDS = {
        "1", "2", "C", "D", "R", "E", "G", "O", "I"
    };

    private static final String[] ROUTING_INPUT_CONNECTIONS = {
        "=", "-", "_", "\\", "/"
    };

    static String print(Program program) {
        StringBuilder sb = new StringBuilder();
        sb.append(routingEffectIdToString(program.getRouting0().getEffectId()));
        sb.append(routingInputConnectionToString(program.getRouting1().getUpperInputConnection()));
        sb.append(routingEffectIdToString(program.getRouting1().getEffectId()));
        sb.append(routingInputConnectionToString(program.getRouting2().getUpperInputConnection()));
        sb.append(routingEffectIdToString(program.getRouting2().getEffectId()));
        sb.append(routingInputConnectionToString(program.getRouting3().getUpperInputConnection()));
        sb.append(routingEffectIdToString(program.getRouting3().getEffectId()));
        sb.append(routingInputConnectionToString(program.getRouting4().getUpperInputConnection()));
        sb.append(routingEffectIdToString(program.getRouting4().getEffectId()));
        sb.append(routingInputConnectionToString(program.getRouting5().getUpperInputConnection()));
        sb.append(routingEffectIdToString(program.getRouting5().getEffectId()));
        sb.append(routingInputConnectionToString(program.getRouting6().getUpperInputConnection()));
        sb.append(routingEffectIdToString(program.getRouting6().getEffectId()));
        sb.append(routingInputConnectionToString(program.getRouting7().getUpperInputConnection()));
        sb.append(routingEffectIdToString(program.getRouting7().getEffectId()));
        sb.append(routingInputConnectionToString(program.getRouting8().getUpperInputConnection()));
        sb.append(routingEffectIdToString(program.getRouting8().getEffectId()));
        return sb.toString();
    }

    private static String routingEffectIdToString(final int routingEffectId) {
        return ROUTING_EFFECT_IDS[routingEffectId];
    }

    private static String routingInputConnectionToString(final int routingInputConnection) {
        return ROUTING_INPUT_CONNECTIONS[routingInputConnection];
    }
}
