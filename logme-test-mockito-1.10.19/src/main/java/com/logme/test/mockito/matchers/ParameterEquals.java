package com.logme.test.mockito.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.logme.Message;

/**
 * Argument matcher to verify that Logme {@code Message} has a parameter with the given name and value.
 *
 * @see com.logme.test.mockito.LogmeMatchers
 */
public class ParameterEquals extends TypeSafeMatcher<Message> {
    
    private final String name;
    private final String value;

    public ParameterEquals(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public void describeTo(Description description) {
        description.appendText("parameterEquals(\"" + this.name + "\" = \"" + this.value + "\")");
    }
    
    protected boolean matchesSafely(Message actual) {
        return actual != null && actual.toString().contains(this.name + "=" + this.value);
    }
}
