package com.logme.punctuation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MultilineGroupPunctuationTest {

    private static final String EOL = System.lineSeparator();
    private static final String TAB = "    ";

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void init_withZeroOrNegativeIndentLevelAndCurlyStyle_initialized(int indentLevel) {
        GroupPunctuation singleLineStyle = CurlyGroupPunctuation.INSTANCE;
        MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(indentLevel, singleLineStyle);

        Assertions.assertEquals(indentLevel, multilineStyle.getIndentLevel());
        Assertions.assertEquals(EOL, multilineStyle.getIndent());
        Assertions.assertEquals(singleLineStyle.getOpeningMark() + EOL, multilineStyle.getOpeningMark());
        Assertions.assertEquals(EOL + singleLineStyle.getClosingMark(), multilineStyle.getClosingMark());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void init_withZeroOrNegativeIndentLevelAndSquareStyle_initialized(int indentLevel) {
        GroupPunctuation singleLineStyle = SquareGroupPunctuation.INSTANCE;
        MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(indentLevel, singleLineStyle);

        Assertions.assertEquals(indentLevel, multilineStyle.getIndentLevel());
        Assertions.assertEquals(EOL, multilineStyle.getIndent());
        Assertions.assertEquals(singleLineStyle.getOpeningMark() + EOL, multilineStyle.getOpeningMark());
        Assertions.assertEquals(EOL + singleLineStyle.getClosingMark(), multilineStyle.getClosingMark());
    }

    @Test
    void init_withOneIndentLevelAndCurlyStyle_initialized() {
        final int indentLevel = 1;
        GroupPunctuation singleLineStyle = CurlyGroupPunctuation.INSTANCE;
        MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(indentLevel, singleLineStyle);

        Assertions.assertEquals(indentLevel, multilineStyle.getIndentLevel());
        Assertions.assertEquals(EOL + TAB, multilineStyle.getIndent());
        Assertions.assertEquals(singleLineStyle.getOpeningMark() + EOL + TAB, multilineStyle.getOpeningMark());
        Assertions.assertEquals(EOL + singleLineStyle.getClosingMark(), multilineStyle.getClosingMark());
    }

    @Test
    void init_withOneIndentLevelAndSquareStyle_initialized() {
        final int indentLevel = 1;
        GroupPunctuation singleLineStyle = SquareGroupPunctuation.INSTANCE;
        MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(indentLevel, singleLineStyle);

        Assertions.assertEquals(indentLevel, multilineStyle.getIndentLevel());
        Assertions.assertEquals(EOL + TAB, multilineStyle.getIndent());
        Assertions.assertEquals(singleLineStyle.getOpeningMark() + EOL + TAB, multilineStyle.getOpeningMark());
        Assertions.assertEquals(EOL + singleLineStyle.getClosingMark(), multilineStyle.getClosingMark());
    }

    @Test
    void init_withTwoIndentLevelAndCurlyStyle_initialized() {
        final int indentLevel = 2;
        GroupPunctuation singleLineStyle = CurlyGroupPunctuation.INSTANCE;
        MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(indentLevel, singleLineStyle);

        Assertions.assertEquals(indentLevel, multilineStyle.getIndentLevel());
        Assertions.assertEquals(EOL + TAB + TAB, multilineStyle.getIndent());
        Assertions.assertEquals(singleLineStyle.getOpeningMark() + EOL + TAB + TAB, multilineStyle.getOpeningMark());
        Assertions.assertEquals(EOL + TAB + singleLineStyle.getClosingMark(), multilineStyle.getClosingMark());
    }

    @Test
    void init_withTwoIndentLevelAndSquareStyle_initialized() {
        final int indentLevel = 2;
        GroupPunctuation singleLineStyle = SquareGroupPunctuation.INSTANCE;
        MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(indentLevel, singleLineStyle);

        Assertions.assertEquals(indentLevel, multilineStyle.getIndentLevel());
        Assertions.assertEquals(EOL + TAB + TAB, multilineStyle.getIndent());
        Assertions.assertEquals(singleLineStyle.getOpeningMark() + EOL + TAB + TAB, multilineStyle.getOpeningMark());
        Assertions.assertEquals(EOL + TAB + singleLineStyle.getClosingMark(), multilineStyle.getClosingMark());
    }

}
