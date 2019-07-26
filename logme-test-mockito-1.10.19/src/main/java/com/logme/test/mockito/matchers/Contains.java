package com.logme.test.mockito.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.logme.Message;

/**
 * Argument matcher to verify that Logme {@code Message} contains the given substring.
 * 
 * @see com.logme.test.mockito.LogmeMatchers
 */
public class Contains extends TypeSafeMatcher<Message> {
    private final String substring;
    
    public Contains(String substring) {
        this.substring = substring;
    }
    
    public void describeTo(Description description) {
        description.appendText("contains(\"" + this.substring + "\")");
    }
    
    protected boolean matchesSafely(Message actual) {
        return actual != null && actual.toString().contains(this.substring);
    }
}
