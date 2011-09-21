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

    private Program program;
    private StringBuilder upper = new StringBuilder();
    private StringBuilder lower = new StringBuilder();

    private RoutingPrinter(final Program program) {
        this.program = program;
    }

    private String print() {
        printRoute(program.getRouting0());
        printRoute(program.getRouting1());
        printRoute(program.getRouting2());
        printRoute(program.getRouting3());
        printRoute(program.getRouting4());
        printRoute(program.getRouting5());
        printRoute(program.getRouting6());
        printRoute(program.getRouting7());
        printRoute(program.getRouting8());

        if (!lower.toString().trim().isEmpty()) {
            upper.append("\n").append(lower.toString().replaceAll("\\s+$", ""));
        }
        return upper.toString();
    }

    private void printRoute(final RoutingData route) {
        if (route.getEffectId() != 8) {
            // incoming connections
            upper.append(routingInputConnectionToString(route.getUpperInputConnection()));
            if (route.getPathType() == 0) {
                lower.append(' ');
            } else {
                lower.append('=');
            }
        }

        int routing = route.getRouting();
        if (routing == 1) {
            upper.append(ROUTING_INPUT_CONNECTIONS[0]);
            lower.append(routingEffectIdToString(route.getEffectId()));
        } else {
            upper.append(routingEffectIdToString(route.getEffectId()));
            if (routing == 2 || routing == 3) {
                lower.append('|');
            } else if (route.getPathType() == 1) {
                lower.append('=');
            } else {
                lower.append(' ');
            }
        }
    }

    static String print(final Program program) {
        return new RoutingPrinter(program).print();
    }

    private static String routingEffectIdToString(final int routingEffectId) {
        return ROUTING_EFFECT_IDS[routingEffectId];
    }

    private static String routingInputConnectionToString(final int routingInputConnection) {
        return ROUTING_INPUT_CONNECTIONS[routingInputConnection];
    }
}
