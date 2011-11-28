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

import info.carlwithak.mpxg2.model.Rate;
import info.carlwithak.mpxg2.model.TapMsRate;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * Hamcrest matcher for tap ms rate parameters.
 *
 * @author Carl Green
 */
public class IsTapMs extends BaseMatcher<Rate> {
    private final int value;

    public IsTapMs(final int value) {
        this.value = value;
    }

    @Override
    public boolean matches(final Object item) {
        if (item instanceof TapMsRate) {
            TapMsRate rate = (TapMsRate) item;
            return value == rate.getMs();
        }
        return false;
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("tap ms of ").appendValue(value);
    }

    @Factory
    public static Matcher<Rate> tapMs(final int value) {
        return new IsTapMs(value);
    }

}
