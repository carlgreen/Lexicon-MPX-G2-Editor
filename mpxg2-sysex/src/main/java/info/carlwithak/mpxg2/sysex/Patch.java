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

package info.carlwithak.mpxg2.sysex;

/**
 * The Patching system in the MPX G2 allows both internal and external control
 * sources to control program parameters. Each program contains 5 Patches which
 * each takes a single control source to control a single parameter.
 *
 * @author Carl Green
 */
public class Patch {
    private int source;
    private int sourceMin;
    private int sourceMid;
    private int sourceMax;
    private int destinationEffect;
    private int destinationParameter;
    private int destinationMin;
    private int destinationMid;
    private int destinationMax;

    int getSource() {
        return source;
    }

    void setSource(final int source) {
        this.source = source;
    }

    int getSourceMin() {
        return sourceMin;
    }

    void setSourceMin(final int sourceMin) {
        this.sourceMin = sourceMin;
    }

    int getSourceMid() {
        return sourceMid;
    }

    void setSourceMid(final int sourceMid) {
        this.sourceMid = sourceMid;
    }

    int getSourceMax() {
        return sourceMax;
    }

    void setSourceMax(final int sourceMax) {
        this.sourceMax = sourceMax;
    }

    int getDestinationEffect() {
        return destinationEffect;
    }

    void setDestinationEffect(final int destinationEffect) {
        this.destinationEffect = destinationEffect;
    }

    int getDestinationParameter() {
        return destinationParameter;
    }

    void setDestinationParameter(final int destinationParameter) {
        this.destinationParameter = destinationParameter;
    }

    int getDestinationMin() {
        return destinationMin;
    }

    void setDestinationMin(final int destinationMin) {
        this.destinationMin = destinationMin;
    }

    int getDestinationMid() {
        return destinationMid;
    }

    void setDestinationMid(final int destinationMid) {
        this.destinationMid = destinationMid;
    }

    int getDestinationMax() {
        return destinationMax;
    }

    void setDestinationMax(final int destinationMax) {
        this.destinationMax = destinationMax;
    }
}
