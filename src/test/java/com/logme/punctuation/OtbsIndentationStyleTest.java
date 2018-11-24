package com.logme.punctuation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OtbsIndentationStyleTest {

    private static final String SINGLE_LEVEL_INDENT = "    ";
    private static final String EOL = System.lineSeparator();

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void init_withZeroOrNegativeIndentLevel_initialized(int indentLevel) {
        OtbsIndentationStyle otbs = new OtbsIndentationStyle(indentLevel);

        Assertions.assertEquals(indentLevel, otbs.getIndentLevel());
        Assertions.assertEquals(EOL, otbs.getIndent());
        Assertions.assertEquals("{" + EOL, otbs.getOpeningMark());
        Assertions.assertEquals(EOL + "}", otbs.getClosingMark());
    }

    @Test
    void init_withOneIndentLevel_initialized() {
        final int indentLevel = 1;
        OtbsIndentationStyle otbs = new OtbsIndentationStyle(indentLevel);

        Assertions.assertEquals(indentLevel, otbs.getIndentLevel());
        Assertions.assertEquals(EOL + SINGLE_LEVEL_INDENT, otbs.getIndent());
        Assertions.assertEquals("{" + EOL + SINGLE_LEVEL_INDENT, otbs.getOpeningMark());
        Assertions.assertEquals(EOL + "}", otbs.getClosingMark());
    }

    @Test
    void init_withTwoIndentLevel_initialized() {
        final int indentLevel = 2;
        OtbsIndentationStyle otbs = new OtbsIndentationStyle(indentLevel);

        Assertions.assertEquals(indentLevel, otbs.getIndentLevel());
        Assertions.assertEquals(EOL + SINGLE_LEVEL_INDENT + SINGLE_LEVEL_INDENT, otbs.getIndent());
        Assertions.assertEquals("{" + EOL + SINGLE_LEVEL_INDENT + SINGLE_LEVEL_INDENT, otbs.getOpeningMark());
        Assertions.assertEquals(EOL + SINGLE_LEVEL_INDENT + "}", otbs.getClosingMark());
    }

}
