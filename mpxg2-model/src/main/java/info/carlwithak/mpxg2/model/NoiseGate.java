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
 * The Noise Gate blocks signal from being output at the Send jack and/or from
 * feeding the "Post" signal path (anything after the Gain block in the routing
 * diagram).
 *
 * @author Carl Green
 */
public class NoiseGate {
    private int enable;
    private boolean send;
    private int threshold;
    private int attenuation;
    private int offset;
    private int aTime;
    private int hTime;
    private int rTime;
    private int delay;

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getAttenuation() {
        return attenuation;
    }

    public void setAttenuation(int attenuation) {
        this.attenuation = attenuation;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getATime() {
        return aTime;
    }

    public void setATime(int aTime) {
        this.aTime = aTime;
    }

    public int getHTime() {
        return hTime;
    }

    public void setHTime(int hTime) {
        this.hTime = hTime;
    }

    public int getRTime() {
        return rTime;
    }

    public void setRTime(int rTime) {
        this.rTime = rTime;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

}
