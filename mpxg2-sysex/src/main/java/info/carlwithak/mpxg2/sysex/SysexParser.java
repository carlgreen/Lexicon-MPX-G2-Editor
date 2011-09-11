package info.carlwithak.mpxg2.sysex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author carl
 */
public class SysexParser {

    private static final int SYSEX_ID_START = 0xf0;
    private static final int LEXICON_MANUFACTURER_ID = 0x06;
    private static final int MPXG2_PRODUCT_ID = 0x0f;
    private static final int DATA_MESSAGE_TYPE = 0x01;
    // effect type constants
    private static final int EFFECT_TYPE_CHORUS = 0x0001;
    private static final int EFFECT_TYPE_DELAY = 0x0002;
    private static final int EFFECT_TYPE_DISTORTION = 0x0004;
    private static final int EFFECT_TYPE_EQ = 0x0008;
    private static final int EFFECT_TYPE_FLANGER = 0x0010;
    private static final int EFFECT_TYPE_GAIN = 0x0020;
    private static final int EFFECT_TYPE_MOD = 0x0040;
    private static final int EFFECT_TYPE_OVERDRIVE = 0x0080;
    private static final int EFFECT_TYPE_PHASER = 0x0100;
    private static final int EFFECT_TYPE_PITCH = 0x0200;
    private static final int EFFECT_TYPE_REVERB = 0x0400;
    private static final int EFFECT_TYPE_SPEAKERSIM = 0x0800;
    private static final int EFFECT_TYPE_WAH = 0x1000;
    private static final int APP_TYPE_PREPOST = 0x2000;
    private static final int APP_TYPE_STANDALONE = 0x4000;
    private static final int APP_TYPE_INLINE = 0x8000;
    // guitar style constants
    private static final int GUITAR_STYLE_ACOUSTIC = 0x02;
    private static final int GUITAR_STYLE_BASS = 0x04;
    private static final int GUITAR_STYLE_BLUES = 0x08;
    private static final int GUITAR_STYLE_CLEAN = 0x10;
    private static final int GUITAR_STYLE_COUNTRY = 0x20;
    private static final int GUITAR_STYLE_JAZZ = 0x40;
    private static final int GUITAR_STYLE_ROCK = 0x80;

    /**
     * Parse a Program dumped in SysEx format.
     *
     * See {@link http://www.stecrecords.com/gear/mpxg2/doc/MPXG2_MIDI_Impl.htm}
     */
    static Program parseProgram(final File preset) throws IOException, ParseException {
        InputStream in = new FileInputStream(preset);

        Program program = new Program();

        int b;
        if ((b = in.read()) != SYSEX_ID_START) {
            throw new ParseException("Invalid Sysex ID (start)");
        }
        if ((b = in.read()) != LEXICON_MANUFACTURER_ID) {
            throw new ParseException("Invalid Manufacturer ID");
        }
        if ((b = in.read()) != MPXG2_PRODUCT_ID) {
            throw new ParseException("Invalid Product ID");
        }
        b = in.read();
        @SuppressWarnings("unused")
        int deviceId = b;

        if ((b = in.read()) != DATA_MESSAGE_TYPE) {
            throw new ParseException("Invalid Message Type");
        }

        byte[] bytes = new byte[4];
        in.read(bytes);
        @SuppressWarnings("unused")
        int objectSize = 0;
        for (int i = 0; i < bytes.length; i++) {
            objectSize += (bytes[i] * Math.pow(16, i));
        }

        // TODO skip 224 bytes of data for now
        for (int i = 0; i < 224 * 2; i++) {
            in.read();
        }

        bytes = new byte[6];
        in.read(bytes);

        int effectTypes = 0;
        for (int i = 0; i < 4; i++) {
            effectTypes += (bytes[i] * Math.pow(16, i));
        }
        program.setIsChorus((effectTypes & EFFECT_TYPE_CHORUS) == EFFECT_TYPE_CHORUS);
        program.setIsDelay((effectTypes & EFFECT_TYPE_DELAY) == EFFECT_TYPE_DELAY);
        program.setIsDistortion((effectTypes & EFFECT_TYPE_DISTORTION) == EFFECT_TYPE_DISTORTION);
        program.setIsEq((effectTypes & EFFECT_TYPE_EQ) == EFFECT_TYPE_EQ);
        program.setIsFlanger((effectTypes & EFFECT_TYPE_FLANGER) == EFFECT_TYPE_FLANGER);
        program.setIsGain((effectTypes & EFFECT_TYPE_GAIN) == EFFECT_TYPE_GAIN);
        program.setIsMod((effectTypes & EFFECT_TYPE_MOD) == EFFECT_TYPE_MOD);
        program.setIsOverdrive((effectTypes & EFFECT_TYPE_OVERDRIVE) == EFFECT_TYPE_OVERDRIVE);
        program.setIsPhaser((effectTypes & EFFECT_TYPE_PHASER) == EFFECT_TYPE_PHASER);
        program.setIsPitch((effectTypes & EFFECT_TYPE_PITCH) == EFFECT_TYPE_PITCH);
        program.setIsReverb((effectTypes & EFFECT_TYPE_REVERB) == EFFECT_TYPE_REVERB);
        program.setIsSpeakerSim((effectTypes & EFFECT_TYPE_SPEAKERSIM) == EFFECT_TYPE_SPEAKERSIM);
        program.setIsWah((effectTypes & EFFECT_TYPE_WAH) == EFFECT_TYPE_WAH);
        program.setIsPrePost((effectTypes & APP_TYPE_PREPOST) == APP_TYPE_PREPOST);
        program.setIsStandAlone((effectTypes & APP_TYPE_STANDALONE) == APP_TYPE_STANDALONE);
        program.setIsInline((effectTypes & APP_TYPE_INLINE) == APP_TYPE_INLINE);

        int guitarStyle = 0;
        for (int i = 0; i < 2; i++) {
            guitarStyle += (bytes[i + 4] * Math.pow(16, i));
        }
        program.setIsAcoustic((guitarStyle & GUITAR_STYLE_ACOUSTIC) == GUITAR_STYLE_ACOUSTIC);
        program.setIsBass((guitarStyle & GUITAR_STYLE_BASS) == GUITAR_STYLE_BASS);
        program.setIsBlues((guitarStyle & GUITAR_STYLE_BLUES) == GUITAR_STYLE_BLUES);
        program.setIsClean((guitarStyle & GUITAR_STYLE_CLEAN) == GUITAR_STYLE_CLEAN);
        program.setIsCountry((guitarStyle & GUITAR_STYLE_COUNTRY) == GUITAR_STYLE_COUNTRY);
        program.setIsJazz((guitarStyle & GUITAR_STYLE_JAZZ) == GUITAR_STYLE_JAZZ);
        program.setIsRock((guitarStyle & GUITAR_STYLE_ROCK) == GUITAR_STYLE_ROCK);

        StringBuilder sb = new StringBuilder(17);
        for (int i = 0; i < 9; i++) {
            bytes = new byte[10];
            in.read(bytes);
            int effect = bytes[0] + bytes[1] * 16;
            @SuppressWarnings("unused")
            int upperInputConn = bytes[2] + bytes[3] * 16;
            @SuppressWarnings("unused")
            int lowerInputConn = bytes[4] + bytes[5] * 16;
            @SuppressWarnings("unused")
            int routing = bytes[6] + bytes[7] * 16;
            @SuppressWarnings("unused")
            int pathType = bytes[8] + bytes[9] * 16;
            switch (effect) {
                case 0:
                    sb.append("=1");
                    break;
                case 1:
                    sb.append("=2");
                    break;
                case 2:
                    sb.append("=C");
                    break;
                case 3:
                    sb.append("=D");
                    break;
                case 4:
                    sb.append("=R");
                    break;
                case 5:
                    sb.append("=E");
                    break;
                case 6:
                    sb.append("=G");
                    break;
                case 7:
                    sb.append("=O");
                    break;
                case 8:
                    sb.append("I");
                    break;
            }
        }
        program.setRouting(sb.toString());

        // TODO skip 7 bytes of data for now
        for (int i = 0; i < 7 * 2; i++) {
            in.read();
        }

        for (int i = 0; i < 6; i++) {
            bytes = new byte[2];
            in.read(bytes);
            // this doesn't seem right - file contains 0xb1
            //int algorithmNumber = bytes[0] + bytes[1] * 16;
            int algorithmNumber = Integer.parseInt(Integer.toString(bytes[0]), 16);
            switch (i) {
                case 0:
                    program.setEffect1Algorithm(algorithmNumber);
                    break;
                case 1:
                    program.setEffect2Algorithm(algorithmNumber);
                    break;
                case 2:
                    program.setChorusAlgorithm(algorithmNumber);
                    break;
                case 3:
                    program.setDelayAlgorithm(algorithmNumber);
                    break;
                case 4:
                    program.setReverbAlgorithm(algorithmNumber);
                    break;
                case 5:
                    program.setEqAlgorithm(algorithmNumber);
                    break;
            }
        }

        // read program name
        bytes = new byte[24];
        in.read(bytes);
        sb = new StringBuilder(12);
        for (int i = 0; i < bytes.length; i += 2) {
            char c = (char) (bytes[i] + (bytes[i + 1] * 16));
            sb.append(c);
        }
        program.setProgramName(sb.toString().trim());

        // TODO skip 22 bytes of data for now
        for (int i = 0; i < 22 * 2; i++) {
            in.read();
        }

        // tempo
        bytes = new byte[4];
        in.read(bytes);
        int tempo = 0;
        for (int i = 0; i < 4; i++) {
            tempo += (bytes[i] * Math.pow(16, i));
        }
        program.setTempo(tempo);

        bytes = new byte[2];
        in.read(bytes);
        int tempoSource = bytes[0] + (bytes[1] * 16);
        program.setTempoSource(tempoSource);

        in.read(bytes);
        int beatValue = bytes[0] + (bytes[1] * 16);
        program.setBeatValue(beatValue);

        in.read(bytes);
        int tapSource = bytes[0] + (bytes[1] * 16);
        program.setTapSource(tapSource);

        in.read(bytes);
        int tapAverage = bytes[0] + (bytes[1] * 16);
        program.setTapAverage(tapAverage);

        in.read(bytes);
        int tapSourceLevel = bytes[0] + (bytes[1] * 16);
        program.setTapSourceLevel(tapSourceLevel);

        // unused
        in.read(new byte[2]);

        // TODO skip 60 bytes of patch data for now
        for (int i = 0; i < 60 * 2; i++) {
            in.read();
        }

        // knob controller
        bytes = new byte[2];
        in.read(bytes);
        int knobValue = bytes[0] + (bytes[1] * 16);
        program.setKnobValue(knobValue);

        in.read(bytes);
        int knobLow = bytes[0] + (bytes[1] * 16);
        program.setKnobLow(knobLow);

        in.read(bytes);
        int knobHigh = bytes[0] + (bytes[1] * 16);
        program.setKnobHigh(knobHigh);

        bytes = new byte[18];
        in.read(bytes);
        StringBuilder programName = new StringBuilder(9);
        for (int i = 0; i < bytes.length; i += 2) {
            char c = (char) (bytes[i] + (bytes[i + 1] * 16));
            programName.append(c);
        }
        program.setKnobName(programName.toString());

        // lfo 1 controller
        bytes = new byte[2];
        in.read(bytes);
        int lfo1Mode = bytes[0] + (bytes[1] * 16);
        program.setLfo1Mode(lfo1Mode);

        bytes = new byte[6];
        in.read(bytes);
        int lfo1Rate = 0;
        for (int i = 0; i < bytes.length; i++) {
            lfo1Rate += (bytes[i] * Math.pow(16, i));
        }
        program.setLfo1Rate(lfo1Rate / 100.0);

        bytes = new byte[2];
        in.read(bytes);
        int lfo1PulseWidth = bytes[0] + (bytes[1] * 16);
        program.setLfo1PulseWidth(lfo1PulseWidth);

        in.read(bytes);
        int lfo1Phase = bytes[0] + (bytes[1] * 16);
        program.setLfo1Phase(lfo1Phase);

        in.read(bytes);
        int lfo1Depth = bytes[0] + (bytes[1] * 16);
        program.setLfo1Depth(lfo1Depth);

        in.read(bytes);
        int lfo1OnLevel = bytes[0] + (bytes[1] * 16);
        program.setLfo1OnLevel(lfo1OnLevel);

        in.read(bytes);
        int lfo1OnSource = bytes[0] + (bytes[1] * 16);
        program.setLfo1OnSource(lfo1OnSource);

        // lfo 2 controller
        bytes = new byte[2];
        in.read(bytes);
        int lfo2Mode = bytes[0] + (bytes[1] * 16);
        program.setLfo2Mode(lfo2Mode);

        bytes = new byte[6];
        in.read(bytes);
        int lfo2Rate = 0;
        for (int i = 0; i < bytes.length; i++) {
            lfo2Rate += (bytes[i] * Math.pow(16, i));
        }
        program.setLfo2Rate(lfo2Rate / 100.0);

        bytes = new byte[2];
        in.read(bytes);
        int lfo2PulseWidth = bytes[0] + (bytes[1] * 16);
        program.setLfo2PulseWidth(lfo2PulseWidth);

        in.read(bytes);
        int lfo2Phase = bytes[0] + (bytes[1] * 16);
        program.setLfo2Phase(lfo2Phase);

        in.read(bytes);
        int lfo2Depth = bytes[0] + (bytes[1] * 16);
        program.setLfo2Depth(lfo2Depth);

        in.read(bytes);
        int lfo2OnLevel = bytes[0] + (bytes[1] * 16);
        program.setLfo2OnLevel(lfo2OnLevel);

        in.read(bytes);
        int lfo2OnSource = bytes[0] + (bytes[1] * 16);
        program.setLfo2OnSource(lfo2OnSource);

        // random controller
        bytes = new byte[2];
        in.read(bytes);
        int randomLow = bytes[0] + (bytes[1] * 16);
        program.setRandomLow(randomLow);

        in.read(bytes);
        int randomHigh = bytes[0] + (bytes[1] * 16);
        program.setRandomHigh(randomHigh);

        bytes = new byte[4];
        in.read(bytes);
        int randomRate = 0;
        for (int i = 0; i < bytes.length; i++) {
            randomRate += (bytes[i] * Math.pow(16, i));
        }
        program.setRandomRate(randomRate / 100.0);

        // TODO what is this?
        in.read(new byte[2]);

        // a/b data
        bytes = new byte[2];
        in.read(bytes);
        int abMode = bytes[0] + (bytes[1] * 16);
        program.setABMode(abMode);

        in.read(bytes);
        int aRate = bytes[0] + (bytes[1] * 16);
        program.setARate(aRate);

        in.read(bytes);
        int bRate = bytes[0] + (bytes[1] * 16);
        program.setBRate(bRate);

        in.read(bytes);
        int abOnLevel = bytes[0] + (bytes[1] * 16);
        program.setABOnLevel(abOnLevel);

        in.read(bytes);
        int abOnSource = bytes[0] + (bytes[1] * 16);
        program.setABOnSource(abOnSource);

        in.close();

        return program;
    }
}
