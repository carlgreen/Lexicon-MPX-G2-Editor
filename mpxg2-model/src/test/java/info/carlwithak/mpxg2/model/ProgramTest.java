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

import info.carlwithak.mpxg2.model.effects.Chorus;
import info.carlwithak.mpxg2.model.effects.Delay;
import info.carlwithak.mpxg2.model.effects.Eq;
import info.carlwithak.mpxg2.model.effects.Gain;
import info.carlwithak.mpxg2.model.effects.Reverb;
import java.beans.IntrospectionException;
import org.junit.Before;
import org.junit.Test;

import static info.carlwithak.mpxg2.model.Util.testBean;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Test Program using bean tester where possible. Hard code other tests.
 *
 * @author Carl Green
 */
public class ProgramTest {

    Program program;

    @Before
    public void setup() {
        program = new Program();
    }

    @Test
    public void testProgram() throws IntrospectionException {
        testBean(Program.class);
    }

    /**
     * conflicts with isChorus.
     */
    @Test
    public void testChorus() {
        Chorus chorus = mock(Chorus.class);
        assertNull(program.getChorus());
        program.setChorus(chorus);
        assertEquals(chorus, program.getChorus());
    }

    /**
     * conflicts with isDelay.
     */
    @Test
    public void testDelay() {
        Delay delay = mock(Delay.class);
        assertNull(program.getDelay());
        program.setDelay(delay);
        assertEquals(delay, program.getDelay());
    }

    /**
     * conflicts with isReverb.
     */
    @Test
    public void testReverb() {
        Reverb reverb = mock(Reverb.class);
        assertNull(program.getReverb());
        program.setReverb(reverb);
        assertEquals(reverb, program.getReverb());
    }

    /**
     * conflicts with isEq.
     */
    @Test
    public void testEq() {
        Eq eq = new Eq();
        assertNull(program.getEq());
        program.setEq(eq);
        assertEquals(eq, program.getEq());
    }

    /**
     * conflicts with isGain.
     */
    @Test
    public void testGain() {
        Gain gain = new Gain() {
        };
        assertNull(program.getGain());
        program.setGain(gain);
        assertEquals(gain, program.getGain());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsChorus() {
        assertFalse(program.isChorus());
        program.setIsChorus(true);
        assertTrue(program.isChorus());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsDelay() {
        assertFalse(program.isDelay());
        program.setIsDelay(true);
        assertTrue(program.isDelay());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsDistortion() {
        assertFalse(program.isDistortion());
        program.setIsDistortion(true);
        assertTrue(program.isDistortion());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsEq() {
        assertFalse(program.isEq());
        program.setIsEq(true);
        assertTrue(program.isEq());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsFlanger() {
        assertFalse(program.isFlanger());
        program.setIsFlanger(true);
        assertTrue(program.isFlanger());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsGain() {
        assertFalse(program.isGain());
        program.setIsGain(true);
        assertTrue(program.isGain());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsMod() {
        assertFalse(program.isMod());
        program.setIsMod(true);
        assertTrue(program.isMod());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsOverdrive() {
        assertFalse(program.isOverdrive());
        program.setIsOverdrive(true);
        assertTrue(program.isOverdrive());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsPhaser() {
        assertFalse(program.isPhaser());
        program.setIsPhaser(true);
        assertTrue(program.isPhaser());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsPitch() {
        assertFalse(program.isPitch());
        program.setIsPitch(true);
        assertTrue(program.isPitch());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsReverb() {
        assertFalse(program.isReverb());
        program.setIsReverb(true);
        assertTrue(program.isReverb());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsSpeakerSim() {
        assertFalse(program.isSpeakerSim());
        program.setIsSpeakerSim(true);
        assertTrue(program.isSpeakerSim());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsWah() {
        assertFalse(program.isWah());
        program.setIsWah(true);
        assertTrue(program.isWah());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsPrePost() {
        assertFalse(program.isPrePost());
        program.setIsPrePost(true);
        assertTrue(program.isPrePost());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsStandAlone() {
        assertFalse(program.isStandAlone());
        program.setIsStandAlone(true);
        assertTrue(program.isStandAlone());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsInline() {
        assertFalse(program.isInline());
        program.setIsInline(true);
        assertTrue(program.isInline());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsAcoustic() {
        assertFalse(program.isAcoustic());
        program.setIsAcoustic(true);
        assertTrue(program.isAcoustic());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsBass() {
        assertFalse(program.isBass());
        program.setIsBass(true);
        assertTrue(program.isBass());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsBlues() {
        assertFalse(program.isBlues());
        program.setIsBlues(true);
        assertTrue(program.isBlues());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsClean() {
        assertFalse(program.isClean());
        program.setIsClean(true);
        assertTrue(program.isClean());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsCountry() {
        assertFalse(program.isCountry());
        program.setIsCountry(true);
        assertTrue(program.isCountry());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsJazz() {
        assertFalse(program.isJazz());
        program.setIsJazz(true);
        assertTrue(program.isJazz());
    }

    /**
     * setter incorrectly named.
     */
    @Test
    public void testIsRock() {
        assertFalse(program.isRock());
        program.setIsRock(true);
        assertTrue(program.isRock());
    }

    /**
     * too complex for automatic testing.
     */
    @Test
    public void testSoftRowEffectTypeAndParameter() {
        program.setSoftRowEffectType(0, 13);
        assertEquals(13, program.getSoftRowEffectType(0));
        program.setSoftRowEffectType(0, 14);
        assertEquals(14, program.getSoftRowEffectType(0));
        program.setSoftRowParameter(0, 7);
        assertEquals(7, program.getSoftRowParameter(0));
    }
}
