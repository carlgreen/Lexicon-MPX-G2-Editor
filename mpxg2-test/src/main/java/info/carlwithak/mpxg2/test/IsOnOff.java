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

package info.carlwithak.mpxg2.test;

import info.carlwithak.mpxg2.model.parameters.OnOffValue;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Hamcrest matcher for On/Off value parameters.
 *
 * @author Carl Green
 */
public class IsOnOff extends BaseMatcher<OnOffValue> {
    private final boolean value;

    public IsOnOff(final boolean value) {
        this.value = value;
    }

    @Override
    public boolean matches(final Object item) {
        if (item instanceof OnOffValue) {
            OnOffValue parameter = (OnOffValue) item;
            return equalTo(value).matches(parameter.getValue());
        }
        return false;
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("value of ").appendValue(value);
    }

    @Factory
    public static Matcher<OnOffValue> on() {
        return new IsOnOff(true);
    }

    @Factory
    public static Matcher<OnOffValue> off() {
        return new IsOnOff(false);
    }

}
