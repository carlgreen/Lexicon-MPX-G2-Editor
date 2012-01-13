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

import info.carlwithak.mpxg2.model.parameters.FrequencyRate;
import info.carlwithak.mpxg2.model.parameters.Rate;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * Hamcrest matcher for frequency rate parameters.
 *
 * @author Carl Green
 */
public class IsFrequency extends BaseMatcher<Rate> {
    private final double value;

    public IsFrequency(final double value) {
        this.value = value;
    }

    @Override
    public boolean matches(final Object item) {
        if (item instanceof FrequencyRate) {
            FrequencyRate rate = (FrequencyRate) item;
            return value == rate.getFrequency();
        }
        return false;
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("frequency of ").appendValue(value);
    }

    @Factory
    public static Matcher<Rate> frequency(final double value) {
        return new IsFrequency(value);
    }

}
