package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LogmeMessageTest {

    @Test
    void newMessage_default_emptyTextAppended() {
        String actual = Logme.newMessage().toString();
        Assertions.assertEquals("", actual);
    }

    @Test
    void newMessage_withText_appended() {
        String actual = Logme.newMessage("This is a test message built with Logme").toString();
        Assertions.assertEquals("This is a test message built with Logme", actual);
    }

    @Test
    void buildMessage_withText_appended() {
        String actual = Logme.newMessage().appendText("This is a test message built with Logme").toString();
        Assertions.assertEquals("This is a test message built with Logme", actual);
    }

    @Test
    void buildMessage_withMarkerAndText_appended() {
        String actual = Logme.newMessage()
                .appendMarker("TEST-MSG")
                .appendText(" This is a test message with a marker built with Logme")
                .toString();

        Assertions.assertEquals(
                "[TEST-MSG] This is a test message with a marker built with Logme",
                actual
        );
    }

    @Test
    void buildMessage_withTwoMarkersAndText_appended() {
        String actual = Logme.newMessage()
                .appendMarker("TEST-MSG-MRKR-1")
                .appendMarker("TEST-MSG-MRKR-2")
                .appendText(" This is a test message with two markers built with Logme")
                .toString();

        Assertions.assertEquals(
                "[TEST-MSG-MRKR-1][TEST-MSG-MRKR-2] This is a test message with two markers built with Logme",
                actual
        );
    }

    @Test
    void buildMessage_withTwoTextsAndTwoParameters_appended() {
        String actual = Logme.newMessage()
                .appendText("This is a test message ")
                .appendText("built with Logme ")
                .appendParameter("appendTextInvocations", 2)
                .appendParameter("indentation", "oneLine")
                .toString();

        Assertions.assertEquals(
                "This is a test message built with Logme {appendTextInvocations=2, indentation=oneLine}",
                actual
        );
    }

    // todo: move to readme
    /*
     * message : text payload appendedMessages
     * appendedMessages: message | message ' ' appendedMessages
     * payload : '{' parameters '}'
     * parameters : name '=' value | name '=' value ', ' parameters
     * value : simpleValue | '[' arrayValue ']'
     * arrayValue : simpleValueArray | payloadArray
     * simpleValueArray : simpleValue | simpleValue ', ' simpleValueArray
     * payloadArray : payload | payload ', ' payloadArray
     * payload, name, simpleValue: java.lang.String
     */
    @Test
    void buildMessage_withTextAppendedAfterParameters_appended() {
        String actual = Logme.newMessage()
                .appendText("This is a test message built with Logme ")
                .appendParameter("appendTextInvocations", 2)
                .appendParameter("indentation", "oneLine")
                .appendText(". More details coming soon!")
                .toString();

        Assertions.assertEquals(
                "This is a test message built with Logme {appendTextInvocations=2, indentation=oneLine}"
                        + ". More details coming soon!",
                actual
        );
    }

    @Test
    void newMessage_withMixedTextAndParameters_appended() {
        String actual = Logme.newMessage()
                .appendText("This is a test message built with Logme ")
                .appendParameter("appendTextInvocations", 1)
                .appendParameter("indentation", "oneLine")
                .appendText(". More details: ")
                .appendParameter("file1", "C:/bin/cfg1.xml")
                .appendParameter("file2", "C:/bin/cfg2.xml")
                .appendParameter("file3", "C:/bin/cfg3.xml")
                .appendText(" Good luck!")
                .toString();

        Assertions.assertEquals(
                "This is a test message built with Logme {appendTextInvocations=1, indentation=oneLine}" +
                        ". More details: {file1=C:/bin/cfg1.xml, file2=C:/bin/cfg2.xml, file3=C:/bin/cfg3.xml}" +
                        " Good luck!",
                actual
        );
    }

}
