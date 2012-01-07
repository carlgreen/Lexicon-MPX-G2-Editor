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

import info.carlwithak.mpxg2.model.parameters.GenericValue;
import info.carlwithak.mpxg2.model.parameters.NoiseGateEnableValue;
import info.carlwithak.mpxg2.model.parameters.OnOffValue;

/**
 * The Noise Gate blocks signal from being output at the Send jack and/or from
 * feeding the "Post" signal path (anything after the Gain block in the routing
 * diagram).
 *
 * @author Carl Green
 */
public class NoiseGate {
    private NoiseGateEnableValue enable = new NoiseGateEnableValue("Enable");
    private OnOffValue send = new OnOffValue("Send");
    private GenericValue<Integer> threshold = new GenericValue<Integer>("Thrsh", "dB", 0, 0);
    private GenericValue<Integer> attenuation = new GenericValue<Integer>("Atten", "dB", 0, 0);
    private GenericValue<Integer> offset = new GenericValue<Integer>("Offset", "dB", 0, 0);
    private GenericValue<Integer> aTime = new GenericValue<Integer>("ATime", "", 0, 0);
    private GenericValue<Integer> hTime = new GenericValue<Integer>("HTime", "", 0, 0);
    private GenericValue<Integer> rTime = new GenericValue<Integer>("RTime", "", 0, 0);
    private GenericValue<Integer> delay = new GenericValue<Integer>("Delay", "", 0, 0);

    public NoiseGateEnableValue getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable.setValue(enable);
    }

    public OnOffValue isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send.setValue(send);
    }

    public GenericValue<Integer> getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold.setValue(threshold);
    }

    public GenericValue<Integer> getAttenuation() {
        return attenuation;
    }

    public void setAttenuation(int attenuation) {
        this.attenuation.setValue(attenuation);
    }

    public GenericValue<Integer> getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset.setValue(offset);
    }

    public GenericValue<Integer> getATime() {
        return aTime;
    }

    public void setATime(int aTime) {
        this.aTime.setValue(aTime);
    }

    public GenericValue<Integer> getHTime() {
        return hTime;
    }

    public void setHTime(int hTime) {
        this.hTime.setValue(hTime);
    }

    public GenericValue<Integer> getRTime() {
        return rTime;
    }

    public void setRTime(int rTime) {
        this.rTime.setValue(rTime);
    }

    public GenericValue<Integer> getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay.setValue(delay);
    }

}
