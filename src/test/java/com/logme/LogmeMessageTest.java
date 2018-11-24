package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LogmeMessageTest {

    @Test
    void newMessage_default_emptyTextAppended() {
        String actualMessage = Logme.newMessage().toString();
        Assertions.assertEquals("", actualMessage);
    }

    @Test
    void newMessage_withText_appended() {
        String actualMessage = Logme.newMessage("This is a test message built with Logme").toString();
        Assertions.assertEquals("This is a test message built with Logme", actualMessage);
    }

    @Test
    void newMessage_withLazyText_appended() {
        String actualMessage = Logme.newMessage().appendText("This is a test message built with Logme").toString();
        Assertions.assertEquals("This is a test message built with Logme", actualMessage);
    }

    @Test
    void newMessage_withMarkerAndText_appended() {
        String actualMessage = Logme.newMessage()
                .appendMarker("TEST-MSG")
                .appendText(" This is a test message with a marker built with Logme")
                .toString();

        Assertions.assertEquals(
                "[TEST-MSG] This is a test message with a marker built with Logme",
                actualMessage
        );
    }

    @Test
    void newMessage_withTwoMarkersAndText_appended() {
        String actualMessage = Logme.newMessage()
                .appendMarker("TEST-MSG-MRKR-1")
                .appendMarker("TEST-MSG-MRKR-2")
                .appendText(" This is a test message with two markers built with Logme")
                .toString();

        Assertions.assertEquals(
                "[TEST-MSG-MRKR-1][TEST-MSG-MRKR-2] This is a test message with two markers built with Logme",
                actualMessage
        );
    }

    @Test
    void newMessage_withTextAppendedTwice_appended() {
        String actualMessage = Logme.newMessage()
                .appendText("This is a test message ")
                .appendText("built with Logme ")
                .appendParameter("appendTextInvocations", 2)
                .appendParameter("indentation", "oneLine")
                .toString();

        Assertions.assertEquals(
                "This is a test message built with Logme {appendTextInvocations=2, indentation=oneLine}",
                actualMessage
        );
    }

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
    void newMessage_withTextAppendedAfterParameters_appended() {
        String actualMessage = Logme.newMessage()
                .appendText("This is a test message built with Logme ")
                .appendParameter("appendTextInvocations", 2)
                .appendParameter("indentation", "oneLine")
                .appendText(". More details coming soon!")
                .toString();

        Assertions.assertEquals(
                "This is a test message built with Logme {appendTextInvocations=2, indentation=oneLine}"
                        + ". More details coming soon!",
                actualMessage
        );
    }

    @Test
    void newMessage_withMixedTextAndParameters_appended() {
        String actualMessage = Logme.newMessage()
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
                actualMessage
        );
    }

}
