package info.carlwithak.mpxg2.sysex;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import org.junit.Test;

/**
 * Tests for SysexParser, using real files dumped from the MPX G2.
 *
 * @author carl
 */
public class SysexParserTest {

    /**
     * Test parsing the Clean Slate preset, which has pretty much nothing defined.
     */
    @Test
    public void testParseCleanSlate() throws Exception {
        URI presetUri = this.getClass().getClassLoader().getResource("250_Clean_Slate.syx").toURI();
        Program program = SysexParser.parseProgram(presetUri);

        assertEquals("Clean Slate", program.getProgramName());
    }
}
