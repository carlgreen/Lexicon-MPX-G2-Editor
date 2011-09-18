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

    public int getSource() {
        return source;
    }

    public void setSource(final int source) {
        this.source = source;
    }

    public int getSourceMin() {
        return sourceMin;
    }

    public void setSourceMin(final int sourceMin) {
        this.sourceMin = sourceMin;
    }

    public int getSourceMid() {
        return sourceMid;
    }

    public void setSourceMid(final int sourceMid) {
        this.sourceMid = sourceMid;
    }

    public int getSourceMax() {
        return sourceMax;
    }

    public void setSourceMax(final int sourceMax) {
        this.sourceMax = sourceMax;
    }

    public int getDestinationEffect() {
        return destinationEffect;
    }

    public void setDestinationEffect(final int destinationEffect) {
        this.destinationEffect = destinationEffect;
    }

    public int getDestinationParameter() {
        return destinationParameter;
    }

    public void setDestinationParameter(final int destinationParameter) {
        this.destinationParameter = destinationParameter;
    }

    public int getDestinationMin() {
        return destinationMin;
    }

    public void setDestinationMin(final int destinationMin) {
        this.destinationMin = destinationMin;
    }

    public int getDestinationMid() {
        return destinationMid;
    }

    public void setDestinationMid(final int destinationMid) {
        this.destinationMid = destinationMid;
    }

    public int getDestinationMax() {
        return destinationMax;
    }

    public void setDestinationMax(final int destinationMax) {
        this.destinationMax = destinationMax;
    }
}
