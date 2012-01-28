/*
 *  Copyright (C) 2012 Carl Green
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

package info.carlwithak.mpxg2.sysex.effects.algorithms;

import info.carlwithak.mpxg2.model.effects.algorithms.Click;

/**
 * Class to parse parameter data for Click effect.
 *
 * @author Carl Green
 */
public class ClickParser {

    public static Click parse(byte[] effectParameters) {
        Click click = new Click();

        int mix = effectParameters[0] + effectParameters[1] * 16;
        click.mix.setValue(mix);

        int level = (byte) (effectParameters[2] + effectParameters[3] * 16);
        click.level.setValue(level);

        return click;
    }

}
