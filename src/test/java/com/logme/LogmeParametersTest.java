package com.logme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class LogmeParametersTest {

    private static final String EOL = System.lineSeparator();

    @Test
    void appendParameter_withBooleanAsValue_appended() {
        boolean value = true;
        String actual = Logme.parameters().append("value", value).toString();
        Assertions.assertEquals("{value=true}", actual);
    }

    @Test
    void appendParameter_withByteAsValue_appended() {
        byte value = 1;
        String actual = Logme.parameters().append("value", value).toString();
        Assertions.assertEquals("{value=1}", actual);
    }

    @Test
    void appendParameter_withCharAsValue_appended() {
        char value = 'c';
        String actual = Logme.parameters().append("value", value).toString();
        Assertions.assertEquals("{value=c}", actual);
    }

    @Test
    void appendParameter_withDoubleAsValue_appended() {
        double value = 1.5d;
        String actual = Logme.parameters().append("value", value).toString();
        Assertions.assertEquals("{value=1.5}", actual);
    }

    @Test
    void appendParameter_withFloatAsValue_appended() {
        float value = 1.5f;
        String actual = Logme.parameters().append("value", value).toString();
        Assertions.assertEquals("{value=1.5}", actual);
    }

    @Test
    void appendParameter_withIntAsValue_appended() {
        int value = 1;
        String actual = Logme.parameters().append("value", value).toString();
        Assertions.assertEquals("{value=1}", actual);
    }

    @Test
    void appendParameter_withLongAsValue_appended() {
        long value = 1L;
        String actual = Logme.parameters().append("value", value).toString();
        Assertions.assertEquals("{value=1}", actual);
    }

    @Test
    void appendParameter_withNullAsValue_nullDefaultAppended() {
        String value = null;
        String nullDefault = "<not specified>";
        String actual = Logme.parameters().append("value", value, nullDefault).toString();
        Assertions.assertEquals("{value=<not specified>}", actual);

    }

    @Test
    void appendParameter_withStringArrayAsValue_appended() {
        String actual = Logme.parameters()
                .append("numbers", new String[] {"1", "2", "3"})
                .toString();

        Assertions.assertEquals("{numbers=[1, 2, 3]}", actual);
    }

    @Test
    void appendMultilineParameter_withStringArrayAsValue_appended() {
        String actual = Logme.parameters()
                .appendMultiline("numbers", new String[] {"1", "2", "3"})
                .toString();

        Assertions.assertEquals("{numbers=[" + EOL
                        + "    1," + EOL
                        + "    2," + EOL
                        + "    3" + EOL
                        + "]}",
                actual
        );
    }

    @Test
    void appendParameter_withStringCollectionAsValue_appended() {
        String actual = Logme.parameters()
                .append("numbers", Arrays.asList("1", "2", "3"))
                .toString();

        Assertions.assertEquals("{numbers=[1, 2, 3]}", actual);
    }

    @Test
    void appendMultilineParameter_withStringCollectionAsValue_appended() {
        String actual = Logme.parameters()
                .appendMultiline("numbers", Arrays.asList("1", "2", "3"))
                .toString();

        Assertions.assertEquals("{numbers=[" + EOL
                        + "    1," + EOL
                        + "    2," + EOL
                        + "    3" + EOL
                        + "]}",
                actual
        );
    }

    @Test
    void appendParameter_withParameterBuilderCollectionWithOneItemAsValue_appended() {
        String actual = Logme.parameters()
                .append("files", Collections.singletonList(
                        Logme.parameters()
                                .append("type", "pdf")
                                .append("path", "C:/doc/1.pdf"))
                ).toString();

        Assertions.assertEquals("{files=[{type=pdf, path=C:/doc/1.pdf}]}", actual);
    }

    @Test
    void appendParameter_withParameterBuilderCollectionWithTwoItemsAsValue_appended() {
        String actual = Logme.parameters()
                .append("files", Arrays.asList(
                        Logme.parameters()
                                .append("type", "pdf")
                                .append("path", "C:/doc/1.pdf"),
                        Logme.parameters()
                                .append("type", "txt")
                                .append("path", "C:/doc/2.txt"))
                ).toString();

        Assertions.assertEquals("{files=[{type=pdf, path=C:/doc/1.pdf}, {type=txt, path=C:/doc/2.txt}]}", actual);
    }

    @Test
    void appendParameter_withMultilineParameterBuilderCollectionAsValue_appended() {
        String actual = Logme.multilineParameters(1)
                .append("files",
                        Arrays.asList(
                                Logme.multilineParameters(2)
                                        .append("type", "pdf")
                                        .append("path", "C:/doc/1.pdf"),
                                Logme.multilineParameters(2)
                                        .append("type", "txt")
                                        .append("path", "C:/doc/2.txt")
                        )
                )
                .toString();

        String eol = System.lineSeparator();
        Assertions.assertEquals("{" + eol +
                "    files=[{" + eol +
                "        type=pdf," + eol +
                "        path=C:/doc/1.pdf" + eol +
                "    }, {" + eol +
                "        type=txt," + eol +
                "        path=C:/doc/2.txt" + eol +
                "    }]" + eol +
                "}",
                actual
        );
    }

    @Test
    void appendMultilineParameter_withMultilineParameterBuilderCollectionAsValue_appended() {
        String actual = Logme.multilineParameters(1)
                .appendMultiline("files",
                        Arrays.asList(
                                Logme.multilineParameters(2)
                                        .append("type", "pdf")
                                        .append("path", "C:/doc/1.pdf"),
                                Logme.multilineParameters(2)
                                        .append("type", "txt")
                                        .append("path", "C:/doc/2.txt")
                        )
                )
                .toString();

        String eol = System.lineSeparator();
        Assertions.assertEquals("{" + eol +
                        "    files=[" + eol +
                        "        {" + eol +
                        "            type=pdf," + eol +
                        "            path=C:/doc/1.pdf" + eol +
                        "        }," + eol +
                        "        {" + eol +
                        "            type=txt," + eol +
                        "            path=C:/doc/2.txt" + eol +
                        "        }" + eol +
                        "    ]" + eol +
                        "}",
                actual
        );
    }

    @Test
    void buildParameters_withTwoItems_appended() {
        String actual = Logme.parameters()
                .append("id", "36f6f78hje")
                .append("type", "plain")
                .toString();

        Assertions.assertEquals("{id=36f6f78hje, type=plain}", actual);
    }

    @Test
    void buildParameters_withMixedSingleLineAndMultilineValues_appended() {
        String actual = Logme.multilineParameters(1)
                .append("type", "pdf")
                .append("path", "C:/doc/1.pdf")
                .append("files",
                        Arrays.asList(
                                Logme.multilineParameters(2)
                                        .append("type", "pdf")
                                        .append("path", "C:/doc/1.pdf"),
                                Logme.multilineParameters(2)
                                        .append("type", "txt")
                                        .append("path", "C:/doc/2.txt")
                        )
                )
                .append("files",
                        Arrays.asList(
                                Logme.parameters()
                                        .append("type", "pdf")
                                        .append("path", "C:/doc/1.pdf"),
                                Logme.parameters()
                                        .append("type", "txt")
                                        .append("path", "C:/doc/2.txt")
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
                "}",
                actual
        );
    }

}
