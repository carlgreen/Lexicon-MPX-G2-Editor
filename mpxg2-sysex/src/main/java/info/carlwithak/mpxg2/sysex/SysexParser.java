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

        // skip 224 bytes of data for now
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

        // skip 58 bytes of data for now
        for (int i = 0; i < 58 * 2; i++) {
            in.read();
        }

        // read program name
        bytes = new byte[24];
        in.read(bytes);
        StringBuilder sb = new StringBuilder(12);
        for (int i = 0; i < bytes.length; i += 2) {
            char c = (char) (bytes[i] + (bytes[i + 1] * 16));
            sb.append(c);
        }
        program.setProgramName(sb.toString().trim());

        in.close();

        return program;
    }
}
