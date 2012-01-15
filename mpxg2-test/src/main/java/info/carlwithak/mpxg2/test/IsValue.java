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

import info.carlwithak.mpxg2.model.parameters.GenericValue;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Hamcrest matcher for generic value parameters.
 *
 * @author Carl Green
 */
public class IsValue<T> extends BaseMatcher<GenericValue<T>> {
    private final T value;

    public IsValue(final T value) {
        this.value = value;
    }

    @Override
    public boolean matches(final Object item) {
        if (item instanceof GenericValue) {
            GenericValue parameter = (GenericValue) item;
            return equalTo(value).matches(parameter.getValue());
        }
        return false;
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("value of ").appendValue(value);
    }

    @Factory
    public static <T> Matcher<GenericValue<T>> value(final T value) {
        return new IsValue<T>(value);
    }

}
