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

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

/**
 * Based on code from @see <a href="https://github.com/codebox/javabean-tester">codebox / javabean-tester</a>.
 *
 * @author Carl Green
 */
public class Util {

    public static <T> void testBean(final Class<T> algorithmClass) throws IntrospectionException {
        final PropertyDescriptor[] props = Introspector.getBeanInfo(algorithmClass).getPropertyDescriptors();
        nextProp:
        for (PropertyDescriptor prop : props) {
            final Method getter = prop.getReadMethod();
            final Method setter = prop.getWriteMethod();

            if (getter != null && setter != null) {
                // We have both a get and set method for this property
                final Class<?> returnType = getter.getReturnType();
                final Class<?>[] params = setter.getParameterTypes();

                if (params.length == 1 && params[0] == returnType) {
                    // The set method has 1 argument, which is of the same type as the return type of the get method, so we can test this property
                    try {
                        // Build a value of the correct type to be passed to the set method
                        Object value = buildValue(returnType);

                        // Build an instance of the bean that we are testing (each property test gets a new instance)
                        T bean = algorithmClass.newInstance();

                        // Call the set method, then check the same value comes back out of the get method
                        setter.invoke(bean, value);

                        final Object expectedValue = value;
                        final Object actualValue = getter.invoke(bean);

                        assertEquals(String.format("Failed while testing property %s", prop.getName()), expectedValue, actualValue);

                    } catch (Exception ex) {
                        fail(String.format("An exception was thrown while testing the property %s: %s", prop.getName(), ex.toString()));
                    }
                }
            }
        }
    }

    private static Object buildMockValue(Class<?> clazz) {
        if (!Modifier.isFinal(clazz.getModifiers())) {
            return mock(clazz);
        } else {
            return null;
        }
    }

    private static Object buildValue(Class<?> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException {
        // If we are using a Mocking framework try that first...
        final Object mockedObject = buildMockValue(clazz);
        if (mockedObject != null) {
            return mockedObject;
        }

        // Next check for a no-arg constructor
        final Constructor<?>[] ctrs = clazz.getConstructors();
        for (Constructor<?> ctr : ctrs) {
            if (ctr.getParameterTypes().length == 0) {
                // The class has a no-arg constructor, so just call it
                return ctr.newInstance();
            }
        }

        // Specific rules for common classes
        if (clazz == String.class) {
            return "testvalue";

        } else if (clazz.isArray()) {
            return Array.newInstance(clazz.getComponentType(), 1);

        } else if (clazz == boolean.class || clazz == Boolean.class) {
            return true;

        } else if (clazz == int.class || clazz == Integer.class) {
            return 1;

        } else if (clazz == long.class || clazz == Long.class) {
            return 1L;

        } else if (clazz == double.class || clazz == Double.class) {
            return 1.0D;

        } else if (clazz == float.class || clazz == Float.class) {
            return 1.0F;

        } else if (clazz == char.class || clazz == Character.class) {
            return 'Y';

            // Add your own rules here

        } else {
            fail("Unable to build an instance of class " + clazz.getName() + ", please add some code to the "
                    + Util.class.getName() + " class to do this.");
            return null; // for the compiler
        }
    }
}
