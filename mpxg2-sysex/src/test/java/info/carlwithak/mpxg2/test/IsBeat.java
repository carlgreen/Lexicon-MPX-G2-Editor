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

package info.carlwithak.mpxg2.test;

import info.carlwithak.mpxg2.model.parameters.BeatRate;
import info.carlwithak.mpxg2.model.parameters.Rate;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * Hamcrest matcher for beat rate parameters.
 *
 * @author Carl Green
 */
public class IsBeat extends BaseMatcher<Rate> {
    private final int value1;
    private final int value2;

    public IsBeat(final int value1, final int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public boolean matches(final Object item) {
        if (item instanceof BeatRate) {
            BeatRate rate = (BeatRate) item;
            return value1 == rate.getMeasures() && value2 == rate.getBeats();
        }
        return false;
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("beat of ").appendValue(value1 + ":" + value2);
    }

    @Factory
    public static Matcher<Rate> beat(int value1, int value2) {
        return new IsBeat(value1, value2);
    }

}
