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

package info.carlwithak.mpxg2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Kind of an integration test for CLI application.
 *
 * @author Carl Green
 */
public class AppIT {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
}

    @Test
    public void testWithG2BlueSysex() throws Exception {
        String[] args = {
            new File(this.getClass().getClassLoader().getResource("001_G2_Blue.syx").toURI()).getAbsolutePath()
        };
        App.main(args);
        assertThat(out.toString("UTF-8"), containsString("G2 Blue\n"));
    }
}
