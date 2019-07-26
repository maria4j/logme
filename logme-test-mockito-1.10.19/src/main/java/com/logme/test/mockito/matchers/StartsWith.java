package com.logme.test.mockito.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.logme.Message;

/**
 * Argument matcher to verify that Logme {@code Message} starts with the given prefix.
 *
 * @see com.logme.test.mockito.LogmeMatchers
 */
public class StartsWith extends TypeSafeMatcher<Message> {
    private final String prefix;

    public StartsWith(String prefix) {
        this.prefix = prefix;
    }

    public void describeTo(Description description) {
        description.appendText("startsWith(\"" + this.prefix + "\")");
    }

    protected boolean matchesSafely(Message actual) {
        return actual != null && actual.toString().startsWith(this.prefix);
    }
}
