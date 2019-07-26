package com.logme.test.mockito.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.logme.Message;

/**
 * Argument matcher to verify that Logme {@code Message} equals to the given value.
 *
 * @see com.logme.test.mockito.LogmeMatchers
 */
public class Equals extends TypeSafeMatcher<Message> {
    private final String value;

    public Equals(String value) {
        this.value = value;
    }

    public void describeTo(Description description) {
        description.appendText("equals(\"" + this.value + "\")");
    }

    protected boolean matchesSafely(Message actual) {
        return actual != null && actual.toString().equals(this.value);
    }
}
