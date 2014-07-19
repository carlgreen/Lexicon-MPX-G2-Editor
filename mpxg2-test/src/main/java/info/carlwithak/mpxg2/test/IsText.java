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

import info.carlwithak.mpxg2.model.parameters.TextValue;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Hamcrest matcher for text value parameters.
 *
 * @author Carl Green
 */
public class IsText extends BaseMatcher<TextValue> {
    private final String text;

    public IsText(final String text) {
        this.text = text;
    }

    @Override
    public boolean matches(final Object item) {
        if (item instanceof TextValue) {
            final TextValue parameter = (TextValue) item;
            return equalTo(text).matches(parameter.getValue());
        }
        return false;
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("text of ").appendValue(text);
    }

    @Factory
    public static Matcher<TextValue> text(final String text) {
        return new IsText(text);
    }

}
