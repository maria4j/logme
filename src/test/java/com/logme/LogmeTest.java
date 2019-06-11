package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LogmeTest {

    private static final String TEST_MESSAGE = "This is a test message built with Logme";

    @Test
    void message_default_created() {
        // Given
        Message message = Logme.message();

        // When
        String actual = message.toString();

        // Then
        Assertions.assertEquals("", actual);
    }

    @Test
    void message_withText_created() {
        // Given
        Message message = Logme.message(TEST_MESSAGE);
        
        // When
        String actual = message.toString();
        
        // Then
        Assertions.assertEquals(TEST_MESSAGE, actual);
    }

}
