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

        // skip 280 bytes of data for now, plus 6 more?
        for (int i = 0; i < (280 + 6) * 2; i++) {
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
