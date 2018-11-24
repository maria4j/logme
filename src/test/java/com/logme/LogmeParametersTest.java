package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class LogmeParametersTest {

    @Test
    void newParameters_withBooleanAsValue_appended() {
        boolean value = true;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals("{value=true}", actualMessage);
    }

    @Test
    void newParameters_withByteAsValue_appended() {
        byte value = 1;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals("{value=1}", actualMessage);
    }

    @Test
    void newParameters_withCharAsValue_appended() {
        char value = 'c';
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals("{value=c}", actualMessage);
    }

    @Test
    void newParameters_withDoubleAsValue_appended() {
        double value = 1.5d;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals("{value=1.5}", actualMessage);
    }

    @Test
    void newParameters_withFloatAsValue_appended() {
        float value = 1.5f;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals("{value=1.5}", actualMessage);
    }

    @Test
    void newParameters_withIntAsValue_appended() {
        int value = 1;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals("{value=1}", actualMessage);
    }

    @Test
    void newParameters_withLongAsValue_appended() {
        long value = 1L;
        String actualMessage = Logme.newParameters().appendParameter("value", value).toString();
        Assertions.assertEquals("{value=1}", actualMessage);
    }

    @Test
    void newParameters_withNullAsValue_nullDefaultAppended() {
        String value = null;
        String nullDefault = "<not specified>";
        String actualMessage = Logme.newParameters().appendParameter("value", value, nullDefault).toString();
        Assertions.assertEquals("{value=<not specified>}", actualMessage);

    }

    @Test
    void newParameters_withStringArrayAsValue_appended() {
        String actualMessage = Logme.newParameters()
                .appendParameter("numbers", new String[] {"1", "2", "3"})
                .toString();

        Assertions.assertEquals("{numbers=[1, 2, 3]}", actualMessage);
    }

    @Test
    void newParameters_withStringCollectionAsValue_appended() {
        String actualMessage = Logme.newParameters()
                .appendParameter("numbers", Arrays.asList("1", "2", "3"))
                .toString();

        Assertions.assertEquals("{numbers=[1, 2, 3]}", actualMessage);
    }

    @Test
    void newParameters_withTwoParameters_appended() {
        String actualMessage = Logme.newParameters()
                .appendParameter("id", "36f6f78hje")
                .appendParameter("type", "plain")
                .toString();

        Assertions.assertEquals("{id=36f6f78hje, type=plain}", actualMessage);
    }

    @Test
    void newParameters_withParameterBuilderCollectionWithOneItemAsValue_appended() {
        String actualMessage = Logme.newParameters()
                .appendParameter("files", Collections.singletonList(
                        Logme.newParameters()
                                .appendParameter("type", "pdf")
                                .appendParameter("path", "C:/doc/1.pdf"))
                ).toString();

        Assertions.assertEquals("{files=[{type=pdf, path=C:/doc/1.pdf}]}", actualMessage);
    }

    @Test
    void newParameters_withParameterBuilderCollectionWithTwoItemsAsValue_appended() {
        String actualMessage = Logme.newParameters()
                .appendParameter("files", Arrays.asList(
                        Logme.newParameters()
                                .appendParameter("type", "pdf")
                                .appendParameter("path", "C:/doc/1.pdf"),
                        Logme.newParameters()
                                .appendParameter("type", "txt")
                                .appendParameter("path", "C:/doc/2.txt"))
                ).toString();

        Assertions.assertEquals("{files=[{type=pdf, path=C:/doc/1.pdf}, {type=txt, path=C:/doc/2.txt}]}", actualMessage);
    }

    @Test
    void newParameters_withMixOfOneLineAndMultilineParameters_formatted() {
        String actualMessage = Logme.newParameters(1)
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
        Assertions.assertEquals("{" + eol +
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
