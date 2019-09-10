package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessageTest {

    private static final String TEST_MESSAGE = " This is a test message built with Logme ";
    private static final String EOL = System.lineSeparator();
    private static final String TAB = "    ";

    @Test
    void init_default_created() {
        // Given
        Message message = new Message();
        
        // When
        String actual = message.toString();
        
        // Then
        Assertions.assertEquals("", actual);
    }

    @Test
    void init_withText_created() {
        // Given
        Message message = new Message(TEST_MESSAGE);

        // When
        String actual = message.toString();

        // Then
        Assertions.assertEquals(TEST_MESSAGE, actual);
    }

    @Test
    void append_text_appended() {
        // Given
        Message message = new Message();

        // When
        String actual = message
                .append(TEST_MESSAGE)
                .toString();

        // Then
        Assertions.assertEquals(TEST_MESSAGE, actual);
    }

    @Test
    void append_tagAndText_appended() {
        // Given
        Message message = new Message();

        // When
        String actual = message
                .appendTag("TEST-MSG-TAG")
                .append(TEST_MESSAGE)
                .toString();

        // Then
        Assertions.assertEquals(
                "[TEST-MSG-TAG]" + TEST_MESSAGE,
                actual
        );
    }

    @Test
    void append_tagAndTagAndText_appended() {
        // Given
        Message message = new Message();

        // When
        String actual = message
                .appendTag("TEST-MSG-TAG-1")
                .appendTag("TEST-MSG-TAG-2")
                .append(TEST_MESSAGE)
                .toString();

        // Then
        Assertions.assertEquals(
                "[TEST-MSG-TAG-1][TEST-MSG-TAG-2]" + TEST_MESSAGE,
                actual
        );
    }

    @Test
    void append_textAndParameters_appended() {
        // Given
        Message message = new Message();

        // When
        String actual = message
                .append(TEST_MESSAGE)
                .appendParameters(parameters -> parameters
                        .append("numeric", 1)
                        .append("string", "someTextGoesHere")
                )
                .toString();

        // Then
        Assertions.assertEquals(
                TEST_MESSAGE + "{numeric=1, string=someTextGoesHere}",
                actual
        );
    }
    
    @Test
    void append_textAndMultilineParameters_appended() {
        // Given
        Message message = new Message();

        // When
        String actual = message
                .append(TEST_MESSAGE)
                .appendMultilineParameters(multilineParameters -> multilineParameters
                        .append("numeric", 1)
                        .append("string", "some text goes here")
                )
                .toString();

        // Then
        Assertions.assertEquals(
                TEST_MESSAGE + "{" + EOL
                        + TAB + "numeric=1," + EOL
                        + TAB + "string=some text goes here" + EOL
                        + "}",
                actual
        );
    }
    
    @Test
    void append_textAndParametersAndText_appended() {
        // Given
        Message message = new Message();

        // When
        String actual = message
                .append(TEST_MESSAGE)
                .appendParameters(parameters -> parameters
                        .append("numeric", 1)
                        .append("string", "some text goes here")
                )
                .append(TEST_MESSAGE)
                .toString();

        // Then
        Assertions.assertEquals(
                TEST_MESSAGE + "{numeric=1, string=some text goes here}" + TEST_MESSAGE,
                actual
        );
    }

    @Test
    void append_textAndParametersAndTextAndParametersAndText_appended() {
        // Given
        Message message = new Message();

        // When
        String actual = message
                .append(TEST_MESSAGE)
                .appendParameters(parameters -> parameters
                        .append("numeric", 1)
                        .append("string", "some text goes here")

                )
                .append(TEST_MESSAGE)
                .appendParameters(parameters -> parameters
                        .append("file1", "C:/app/cfg/cfg1.xml")
                        .append("file2", "C:/app/cfg/cfg2.xml")
                        .append("file3", "C:/app/cfg/cfg3.xml")
                )
                .toString();

        // Then
        Assertions.assertEquals(
                TEST_MESSAGE 
                        + "{numeric=1, string=some text goes here}" 
                        + TEST_MESSAGE 
                        + "{file1=C:/app/cfg/cfg1.xml, file2=C:/app/cfg/cfg2.xml, file3=C:/app/cfg/cfg3.xml}",
                actual
        );
    }

}
