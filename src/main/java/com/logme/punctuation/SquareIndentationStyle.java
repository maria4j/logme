package com.logme.punctuation;

/**
 * Describes indentation style for a single-line group of items enclosed in square brackets.
 * <p>
 * Example: {@code [a, b, c]}
 */
public class SquareIndentationStyle implements IndentationStyle {

    public static final SquareIndentationStyle INSTANCE = new SquareIndentationStyle();

    private SquareIndentationStyle() {
    }

    @Override
    public String getOpeningMark() {
        return PunctuationMark.OPENING_SQUARE_BRACKET.value();
    }

    @Override
    public String getDelimiter() {
        return PunctuationMark.COMMA.value();
    }

    @Override
    public String getIndent() {
        return PunctuationMark.SPACE.value();
    }

    @Override
    public String getClosingMark() {
        return PunctuationMark.CLOSING_SQUARE_BRACKET.value();
    }

}
