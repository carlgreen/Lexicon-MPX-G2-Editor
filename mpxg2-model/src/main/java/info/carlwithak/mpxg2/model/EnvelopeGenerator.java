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

/**
 * Class to hold information about the Envelope Generator controller.
 *
 * @author Carl Green
 */
public class EnvelopeGenerator {
    private int src1;
    private int src2;
    private int aTrim;
    private int response;

    public int getSrc1() {
        return src1;
    }

    public void setSrc1(final int src1) {
        this.src1 = src1;
    }

    public int getSrc2() {
        return src2;
    }

    public void setSrc2(final int src2) {
        this.src2 = src2;
    }

    public int getATrim() {
        return aTrim;
    }

    public void setATrim(final int aTrim) {
        this.aTrim = aTrim;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(final int response) {
        this.response = response;
    }

}
