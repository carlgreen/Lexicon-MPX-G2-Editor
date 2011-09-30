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

package info.carlwithak.mpxg2.model.effects.algorithms;

import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.effects.Chorus;

/**
 * Class for Flanger (S) parameters.
 *
 * @author Carl Green
 */
public class FlangerStereo extends Chorus {
    private Rate rate;
    private int pulseWidth;
    private int depth;
    private int phase;
    private int resonance;
    private int blend;

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public int getPulseWidth() {
        return pulseWidth;
    }

    public void setPulseWidth(int pulseWidth) {
        this.pulseWidth = pulseWidth;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public int getResonance() {
        return resonance;
    }

    public void setResonance(int resonance) {
        this.resonance = resonance;
    }

    public int getBlend() {
        return blend;
    }

    public void setBlend(int blend) {
        this.blend = blend;
    }
}