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

package info.carlwithak.mpxg2.printing;

import info.carlwithak.mpxg2.model.DataObject;
import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.model.RoutingData;

/**
 * Class to print out a program's routing nicely.
 *
 * @author Carl Green
 */
public class RoutingPrinter {

    private static final String[] ROUTING_EFFECT_IDS_ACTIVE = {
        "1", "2", "C", "D", "R", "E", "G", "O", "I"
    };
    private static final String[] ROUTING_EFFECT_IDS_INACTIVE = {
        "₁", "₂", "c", "d", "r", "e", "g"
    };

    private static final String[] ROUTING_INPUT_CONNECTIONS = {
        "=", "-", "_", "\\", "/"
    };

    private final Program program;
    private final StringBuilder upper = new StringBuilder();
    private final StringBuilder lower = new StringBuilder();

    private RoutingPrinter(final Program program) {
        this.program = program;
    }

    private String print() throws PrintException {
        printRoute(new RoutingData[] {
            program.getRouting0(), program.getRouting1(), program.getRouting2(),
            program.getRouting3(), program.getRouting4(), program.getRouting5(),
            program.getRouting6(), program.getRouting7(), program.getRouting8()
        });

        if (!lower.toString().trim().isEmpty()) {
            upper.append("\n").append(lower.toString().replaceAll("\\s+$", ""));
        }
        return upper.toString();
    }

    private void printRoute(final RoutingData[] routes) throws PrintException {
        for (int i = 0; i < routes.length; i++) {
            RoutingData route = routes[i];
            if (i > 0) {
                // incoming connections
                if (route.getRouting() != 1) {
                    upper.append(routingInputConnectionToString(route.getUpperInputConnection()));
                } else {
                    upper.append(getNextUpperInputConnection(routes, i) == 0 ? '=' : '-');
                }
                if (route.getPathType() == 0) {
                    lower.append(' ');
                } else {
                    lower.append(routingInputConnectionToString(route.getLowerInputConnection()));
                }
            }

            int routing = route.getRouting();
            if (routing == 1) {
                // find next upper effect input and derive from that
                upper.append(getNextUpperInputConnection(routes, i) == 0 ? '=' : '-');
                lower.append(routingEffectIdToString(route.getEffectId(), program));
            } else {
                upper.append(routingEffectIdToString(route.getEffectId(), program));
                if (routing == 2 || routing == 3) {
                    lower.append('|');
                } else if (route.getPathType() == 1) {
                    lower.append('=');
                } else {
                    lower.append(' ');
                }
            }
        }
    }

    /**
     * @param routes array of RoutingData to step through
     * @param currentConnection position of current connection in routes
     * @return routing type of next upper connection
     * @throws PrintException if the routing information is not valid
     */
    private static int getNextUpperInputConnection(final RoutingData[] routes, final int currentConnection) throws PrintException {
        RoutingData nextRoute = null;
        for (int j = currentConnection + 1; j < routes.length; j++) {
            if (routes[j].getRouting() != 1) {
                nextRoute = routes[j];
                break;
            }
        }
        if (nextRoute == null) {
            throw new PrintException("No following Upper Input Connection found");
        }
        return nextRoute.getUpperInputConnection();
    }

    static String print(final Program program) throws PrintException {
        return new RoutingPrinter(program).print();
    }

    private static String routingEffectIdToString(final int routingEffectId, final Program program) {
        final DataObject effect = program.getEffect(routingEffectId);
        return effect == null && routingEffectId < ROUTING_EFFECT_IDS_INACTIVE.length
                ? ROUTING_EFFECT_IDS_INACTIVE[routingEffectId]
                : ROUTING_EFFECT_IDS_ACTIVE[routingEffectId];
    }

    private static String routingInputConnectionToString(final int routingInputConnection) {
        return ROUTING_INPUT_CONNECTIONS[routingInputConnection];
    }
}
