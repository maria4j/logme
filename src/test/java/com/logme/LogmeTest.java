package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class LogmeTest {

    @Test
    void newMessage_default_emptyTextAppended() {
        String actualMessage = Logme.newMessage().toString();
        Assertions.assertEquals("", actualMessage);
    }

    @Test
    void newMessage_withText_appended() {
        String actualMessage = Logme.newMessage("Something happened").toString();
        Assertions.assertEquals("Something happened", actualMessage);
    }

    @Test
    void newMessage_withLazyText_appended() {
        String actualMessage = Logme.newMessage().appendText("Something happened").toString();
        Assertions.assertEquals("Something happened", actualMessage);
    }

    @Test
    void newMessage_withIdAndText_appended() {
        String actualMessage = Logme.newMessage("SMTH-HPND", "Something happened").toString();
        Assertions.assertEquals("[SMTH-HPND] Something happened", actualMessage);
    }

    @Test
    void newMessage_withTextAndTwoParameters_appended() {
        String actualMessage = Logme.newMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("type", "plain")
                .toString();

        Assertions.assertEquals("Something happened {id=36f6f78hje, type=plain}", actualMessage);
    }

    @Test
    void newMessage_withTextAppendedAfterNewMessage_textAppendedToOriginal() {
        String actualMessage = Logme.newMessage("Something happened")
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
    // newMessage_itShouldBuildMessageRegardlessOfMethodCallOrder()
    @Test
    void newMessage_withTextAppendedAfterParameters_textAppendedToOriginal() {
        String actualMessage = Logme.newMessage("Something happened at this moment")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("type", "plain")
                .appendText(". Let's fix it")
                .toString();

        Assertions.assertEquals("Something happened at this moment {id=36f6f78hje, type=plain}. Let's fix it", actualMessage);
    }

    @Test
    void newMessage_withMultipleTextAndParametersParameters_textAppendedToOriginal() {
        String actualMessage = Logme.newMessage("Something happened at this moment")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("type", "plain")
                .appendText(". Let's fix it, more details:")
                .appendParameter("file1", "C:/bin/cfg1.xml")
                .appendParameter("file2", "C:/bin/cfg2.xml")
                .appendParameter("file3", "C:/bin/cfg3.xml")
                .appendText("Good luck!")
                .toString();

        Assertions.assertEquals("Something happened at this moment {id=36f6f78hje, type=plain}. Let's fix it, more details: {file1=C:/bin/cfg1.xml, file2=C:/bin/cfg2.xml, file3=C:/bin/cfg3.xml}Good luck!", actualMessage);
    }

    @Test
    void newMessage_withTextAndTwoParametersOneOfWhichIsStringArray_appended() {
        String actualMessage = Logme.newMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("numbers", new String[] {"1", "2", "3"})
                .toString();

        Assertions.assertEquals("Something happened {id=36f6f78hje, numbers=[1, 2, 3]}", actualMessage);
    }

    @Test
    void newMessage_withTextAndTwoParametersOneOfWhichIsIntegerArray_appended() {
        String actualMessage = Logme.newMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("numbers", new Integer[] {1, 2, 3})
                .toString();

        Assertions.assertEquals("Something happened {id=36f6f78hje, numbers=[1, 2, 3]}", actualMessage);
    }

    @Test
    void newMessage_withValueAsStringCollection_appended() {
        String actualMessage = Logme.newMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("numbers", Arrays.asList("1", "2", "3"))
                .toString();

        Assertions.assertEquals("Something happened {id=36f6f78hje, numbers=[1, 2, 3]}", actualMessage);

    }

    @Test
    void newMessage_withTextAndTwoParametersOneOfWhichIsParametersArrayWithOneItem_appended() {
        String actualMessage = Logme.newMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("files", Collections.singletonList(
                        Logme.newParameters()
                                .appendParameter("type", "pdf")
                                .appendParameter("path", "C:/doc/1.pdf"))
                ).toString();

        Assertions.assertEquals("Something happened {id=36f6f78hje, files=[{type=pdf, path=C:/doc/1.pdf}]}", actualMessage);
    }

    @Test
    void newMessage_withTextAndTwoParametersOneOfWhichIsParametersArrayWithTwoItems_appended() {
        String actualMessage = Logme.newMessage("Something happened")
                .appendParameter("id", "36f6f78hje")
                .appendParameter("files", Arrays.asList(
                        Logme.newParameters()
                                .appendParameter("type", "pdf")
                                .appendParameter("path", "C:/doc/1.pdf"),
                        Logme.newParameters()
                                .appendParameter("type", "txt")
                                .appendParameter("path", "C:/doc/2.txt"))
                ).toString();
        
        Assertions.assertEquals("Something happened {id=36f6f78hje, files=[{type=pdf, path=C:/doc/1.pdf}, {type=txt, path=C:/doc/2.txt}]}", actualMessage);
    }

    @Test
    void newMessage_multiline_formatted() {
        String actualMessage = Logme.newMessage("Something happened", 1)
                .appendParameter("type", "pdf")
                .appendParameter("path", "C:/doc/1.pdf")
                .appendParameter("files",
                        Arrays.asList(
                            Logme.newParameters(2)
                                .appendParameter("type", "pdf")
                                .appendParameter("path", "C:/doc/1.pdf"),
                            Logme.newParameters(2)
                                .appendParameter("type", "txt")
                                .appendParameter("path", "C:/doc/2.txt")
                        )
                )
                .appendParameter("files",
                        Arrays.asList(
                                Logme.newParameters()
                                        .appendParameter("type", "pdf")
                                        .appendParameter("path", "C:/doc/1.pdf"),
                                Logme.newParameters()
                                        .appendParameter("type", "txt")
                                        .appendParameter("path", "C:/doc/2.txt")
                        )
                )
                .toString();

        String eol = System.lineSeparator();
        Assertions.assertEquals("Something happened {" + eol +
                "    type=pdf," + eol +
                "    path=C:/doc/1.pdf," + eol +
                "    files=[{" + eol +
                "        type=pdf," + eol +
                "        path=C:/doc/1.pdf" + eol +
                "    }, {" + eol +
                "        type=txt," + eol +
                "        path=C:/doc/2.txt" + eol +
                "    }]," + eol +
                "    files=[{type=pdf, path=C:/doc/1.pdf}, {type=txt, path=C:/doc/2.txt}]" + eol +
                "}", actualMessage);
    }

}
