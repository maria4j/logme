package com.logme.test.mockito;

import org.hamcrest.Matcher;

import org.mockito.internal.progress.HandyReturnValues;
import org.mockito.internal.progress.MockingProgress;
import org.mockito.internal.progress.ThreadSafeMockingProgress;

import com.logme.Message;

import com.logme.test.mockito.matchers.Contains;
import com.logme.test.mockito.matchers.Equals;
import com.logme.test.mockito.matchers.ParameterEquals;
import com.logme.test.mockito.matchers.StartsWith;

/**
 *  Allow verification of Logme {@code Message} passed as argument.
 *  <p>
 *  E.g. to verify that the application used Logme logs the proper diagnostic information.   
 *  <pre>
 *  {@code
 *      // Mocks the logger
 *      Logger logger = Mockito.mock(Logger.class);
 *  
 *      // Calls the logger's method that argument should be verified
 *      logger.info(Logme.message("This is a test message built with Logme"));
 *
 *      // Verifies that the logged message contains the expected text 
 *      Mockito.verify(logger, new Times(1)).info(LogmeMatchers.contains("a test message"));
 *  }
 *  </pre>    
 *  @see org.mockito.Matchers
 */
public class LogmeMatchers {
    
    private static final MockingProgress MOCKING_PROGRESS = new ThreadSafeMockingProgress();

    private LogmeMatchers() {
    }

    /**
     * {@code Message} argument that contains the given substring.
     *
     * @param substring the substring.
     * @return empty string.
     */
    public static Message contains(String substring) {
        return reportMatcher(new Contains(substring)).returnFor(Message.class);
    }

    /**
     * {@code Message} argument that is equal to the given value.
     *
     * @param value the given value.
     * @return null.
     */
    public static Message eq(String value) {
        return reportMatcher(new Equals(value)).returnFor(Message.class);
    }

    /**
     * {@code Message} argument that has a parameter with the given name and value.
     * 
     * @param name the name of a parameter.
     * @param value the value of a parameter.
     * @return null.
     */
    public static Message parameterEq(String name, String value) {
        return reportMatcher(new ParameterEquals(name, value)).returnFor(Message.class);
    }

    /**
     * {@code Message} argument that starts with the given prefix.
     *
     * @param prefix the prefix.
     * @return empty string.
     */
    public static Message startsWith(String prefix) {
        return reportMatcher(new StartsWith(prefix)).returnFor(Message.class);
    }

    private static HandyReturnValues reportMatcher(Matcher<?> matcher) {
        return MOCKING_PROGRESS.getArgumentMatcherStorage().reportMatcher(matcher);
    }
}
