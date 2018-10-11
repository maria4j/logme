package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class LogmeTest {

    @Test
    void createMessage_withText_appended() {
        String actualMessage = Logme.createMessage("Something happened").toString();
        Assertions.assertEquals("Something happened", actualMessage);
    }

    @Test
    void createMessage_withIdAndText_appended() {
        String actualMessage = Logme.createMessage("SMTH-HPND", "Something happened").toString();
        Assertions.assertEquals("[SMTH-HPND] Something happened", actualMessage);
    }

    @Test
    void createMessage_withTextAndTwoParameters_appended() {
        String actualMessage = Logme.createMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("type", "plain")
                .toString();

        Assertions.assertEquals("Something happened {id=36f6f78hje, type=plain}", actualMessage);
    }

    @Test
    void createMessage_withTextAppendedAfterCreateMessage_textAppendedToOriginal() {
        String actualMessage = Logme.createMessage("Something happened")
                .appendText(" at this moment. Let's fix it")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("type", "plain")
                .toString();

        Assertions.assertEquals("Something happened at this moment. Let's fix it {id=36f6f78hje, type=plain}", actualMessage);
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
    // createMessage_itShouldBuildMessageRegardlessOfMethodCallOrder()
    @Test
    void createMessage_withTextAppendedAfterSetParameters_textAppendedToOriginal() {
        String actualMessage = Logme.createMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("type", "plain")
                .appendText(" at this moment. Let's fix it")
                .toString();

        Assertions.assertEquals("Something happened at this moment. Let's fix it {id=36f6f78hje, type=plain}", actualMessage);
    }

    @Test
    void createMessage_withTextAndTwoParametersOneOfWhichIsStringArray_appended() {
        String actualMessage = Logme.createMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("numbers", new String[]{"1", "2", "3"})
                .toString();

        Assertions.assertEquals("Something happened {id=36f6f78hje, numbers=[1, 2, 3]}", actualMessage);
    }

    @Test
    void createMessage_withTextAndTwoParametersOneOfWhichIsParametersArrayWithOneItem_appended() {
        // TODO: String[] неудобно, потому что тогда нарушается конструирование в динамике
        String actualMessage = Logme.createMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("files", Collections.singletonList(
                        Logme.createParameters()
                                .append("type", "pdf")
                                .append("path", "C:/doc/1.pdf"))
                ).toString();

        Assertions.assertEquals("Something happened {id=36f6f78hje, files=[{type=pdf, path=C:/doc/1.pdf}]}", actualMessage);
    }

    @Test
    void createMessage_withTextAndTwoParametersOneOfWhichIsParametersArrayWithTwoItems_appended() {
        String actualMessage = Logme.createMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("files", Arrays.asList(
                        Logme.createParameters()
                                .append("type", "pdf")
                                .append("path", "C:/doc/1.pdf"),
                        Logme.createParameters()
                                .append("type", "txt")
                                .append("path", "C:/doc/2.txt"))
                ).toString();
        
        Assertions.assertEquals("Something happened {id=36f6f78hje, files=[{type=pdf, path=C:/doc/1.pdf}, {type=txt, path=C:/doc/2.txt}]}", actualMessage);
    }

    @Test
    void createMessage_multiline_formatted() {
        String actualMessage = Logme.createParameters(true, 1)
                .append("type", "pdf")
                .append("path", "C:/doc/1.pdf")
                .append("files",
                        Arrays.asList(
                            Logme.createParameters(true, 2)
                                .append("type", "pdf")
                                .append("path", "C:/doc/1.pdf"),
                            Logme.createParameters(true, 2)
                                .append("type", "txt")
                                .append("path", "C:/doc/2.txt")
                        )
                )
                .append("files",
                        Arrays.asList(
                                Logme.createParameters()
                                        .append("type", "pdf")
                                        .append("path", "C:/doc/1.pdf"),
                                Logme.createParameters()
                                        .append("type", "txt")
                                        .append("path", "C:/doc/2.txt")
                        )
                )
                .toString();

        System.out.println(actualMessage);
    }

}
