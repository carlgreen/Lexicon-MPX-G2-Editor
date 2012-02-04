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

import info.carlwithak.mpxg2.model.parameters.Parameter;
import info.carlwithak.mpxg2.model.parameters.SourceValue;
import java.util.Locale;

/**
 * The Patching system in the MPX G2 allows both internal and external control
 * sources to control program parameters. Each program contains 5 Patches which
 * each takes a single control source to control a single parameter.
 *
 * @author Carl Green
 */
public class Patch {
    /**
     * Cannot select PATCHING, SOFTROW, MISC, SPKRSIM, TOE_PATCHES, AUDIO_ROUTE
     * or ALG_SELECT.
     */
    enum PatchDestination {
        EFFECT_1, EFFECT_2, CHORUS, DELAY, REVERB, EQ, GAIN,
        CTLS_KNOB, CTLS_LFO1("LFO1"), CTLS_LFO2("LFO2"), CTLS_RAND("Rand"), CTLS_AB, CTLS_ENV,
        PATCHING, SOFTROW, POST, SEND, MISC, SPKRSIM, NGATE("NGat"), TEMPO,
        TOE_PATCHES, AUDIO_ROUTE, ALG_SELECT, BYPASS("Byp");

        private final String displayName;

        private PatchDestination() {
            String name = name();
            this.displayName = name.substring(0, 1) + name.substring(1).toLowerCase(Locale.ENGLISH).replace('_', ' ');
        }

        private PatchDestination(final String displayName) {
            this.displayName = displayName;
        }

        private String getDisplayName() {
            return displayName;
        }
    }

    public final SourceValue source = new SourceValue("Patch Source");
    private Integer sourceMin;
    private Integer sourceMid;
    private Integer sourceMax;
    private PatchDestination destinationEffect;
    private int destinationParameter;
    private Parameter destinationMin;
    private Parameter destinationMid;
    private Parameter destinationMax;

    public Patch() {
        source.setValue(0);
    }

    public Integer getSourceMin() {
        return sourceMin;
    }

    public void setSourceMin(final Integer sourceMin) {
        this.sourceMin = sourceMin;
    }

    public Integer getSourceMid() {
        return sourceMid;
    }

    public void setSourceMid(final Integer sourceMid) {
        this.sourceMid = sourceMid;
    }

    public Integer getSourceMax() {
        return sourceMax;
    }

    public void setSourceMax(final Integer sourceMax) {
        this.sourceMax = sourceMax;
    }

    public Integer getDestinationEffectIndex() {
        return destinationEffect == null ? null : destinationEffect.ordinal();
    }

    public String getDestinationEffectName() {
        return destinationEffect == null ? null : destinationEffect.getDisplayName();
    }

    public void setDestinationEffect(final Integer destinationEffect) {
        this.destinationEffect = destinationEffect == null ? null : PatchDestination.values()[destinationEffect];
    }

    public int getDestinationParameter() {
        return destinationParameter;
    }

    public void setDestinationParameter(final int destinationParameter) {
        this.destinationParameter = destinationParameter;
    }

    public Parameter getDestinationMin() {
        return destinationMin;
    }

    public void setDestinationMin(final Parameter destinationMin) {
        this.destinationMin = destinationMin;
    }

    public Parameter getDestinationMid() {
        return destinationMid;
    }

    public void setDestinationMid(final Parameter destinationMid) {
        this.destinationMid = destinationMid;
    }

    public Parameter getDestinationMax() {
        return destinationMax;
    }

    public void setDestinationMax(final Parameter destinationMax) {
        this.destinationMax = destinationMax;
    }
}
