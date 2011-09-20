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
 * The Audio Routing section of the program data defines how the audio data
 * moves in and around the system for the current program.
 *
 * @author Carl Green
 */
public class RoutingData {
    /**
     * This is the “Effect Type” for the particular block.
     */
    private int effectId;
    /**
     * This defines the connector used for this block if the "routing" field
     * places it in the upper signal path:
     * 0. Stereo
     * 1. Left Only
     * 2. Right Only
     * 3. Left to Mono
     * 4. Right to Mono
     */
    private int upperInputConnection;
    /**
     * This defines the connector used for this block if the "routing" field
     * places it in the lower signal path.
     */
    private int lowerInputConnection;
    /**
     * This defines how this block deals with the upper lower audio paths:
     * 0. The effect is on the upper signal path only.
     * 1. The effect is on the lower signal path only.
     * 2. The signal from the upper and lower paths is summed and fed into the
     *    effect. The output results in a single path.
     * 3. A single (upper) path outputs to the upper and lower paths
     *    simultaneously.
     */
    private int routing;
    /**
     * This defines if the block is on a single path (0) or double path.
     */
    private int pathType;

    public int getEffectId() {
        return effectId;
    }

    public void setEffectId(int effectId) {
        this.effectId = effectId;
    }

    public int getUpperInputConnection() {
        return upperInputConnection;
    }

    public void setUpperInputConnection(int upperInputConnection) {
        this.upperInputConnection = upperInputConnection;
    }

    public int getLowerInputConnection() {
        return lowerInputConnection;
    }

    public void setLowerInputConnection(int lowerInputConnection) {
        this.lowerInputConnection = lowerInputConnection;
    }

    public int getRouting() {
        return routing;
    }

    public void setRouting(int routing) {
        this.routing = routing;
    }

    public int getPathType() {
        return pathType;
    }

    public void setPathType(int pathType) {
        this.pathType = pathType;
    }
}
