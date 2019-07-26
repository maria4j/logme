package com.logme.test.mockito;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.mockito.internal.verification.Times;

import com.logme.Logme;
import com.logme.Message;

class LogmeMatchersTest {

    private static final String TEST_MESSAGE = " This is a test message built with Logme ";
    
    @Test
    void contains_expectedSubstring_verified() {
        // Given
        ConsoleLogger logger = Mockito.mock(ConsoleLogger.class);
        Message message = Logme.message(TEST_MESSAGE);
        
        // When
        logger.info(message);

        // Then
        Mockito.verify(logger, new Times(1)).info(LogmeMatchers.contains("a test message"));
    }

    @Test
    void eq_expectedValue_verified() {
        // Given
        ConsoleLogger logger = Mockito.mock(ConsoleLogger.class);
        Message message = Logme.message(TEST_MESSAGE);

        // When
        logger.info(message);

        // Then
        Mockito.verify(logger, new Times(1)).info(LogmeMatchers.eq(TEST_MESSAGE));
    }

    @Test
    void parameterEq_expectedNameAndValue_verified() {
        // Given
        ConsoleLogger logger = Mockito.mock(ConsoleLogger.class);
        Message message = Logme.message(TEST_MESSAGE).appendParameters(parameters -> parameters.append("numeric", 1));

        // When
        logger.info(message);

        // Then
        Mockito.verify(logger, new Times(1)).info(LogmeMatchers.parameterEq("numeric", "1"));
    }

    @Test
    void startsWith_expectedPrefix_verified() {
        // Given
        ConsoleLogger logger = Mockito.mock(ConsoleLogger.class);
        Message message = Logme.message(TEST_MESSAGE);

        // When
        logger.info(message);

        // Then
        Mockito.verify(logger, new Times(1)).info(LogmeMatchers.startsWith(" This is "));
    }
    
    private static class ConsoleLogger {
        
        ConsoleLogger() {
        }
        
        void info(Message message) {
            System.out.println(message);
        }
        
    }
}
