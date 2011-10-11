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

import info.carlwithak.mpxg2.model.Program;
import info.carlwithak.mpxg2.printing.PrintException;
import info.carlwithak.mpxg2.printing.ProgramPrinter;
import info.carlwithak.mpxg2.sysex.ParseException;
import info.carlwithak.mpxg2.sysex.SysexParser;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Carl Green
 */
public class App {
    public static void main(String[] args) throws IOException, ParseException, PrintException {
        Program program = SysexParser.parseProgram(new File(args[0]));
        //System.out.println(ProgramPrinter.print(program));
    }
}
