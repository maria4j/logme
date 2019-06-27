package com.logme.punctuation;

/**
 * Describes punctuation rule for a single-line group of items enclosed in curly brackets.
 * <p>
 * Example: {@code {a, b, c}}
 */
public class CurlyGroupPunctuation implements GroupPunctuation {

    public static final CurlyGroupPunctuation INSTANCE = new CurlyGroupPunctuation();

    private CurlyGroupPunctuation() {
    }

    @Override
    public String getOpeningMark() {
        return PunctuationMark.OPENING_CURLY_BRACKET.value();
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
        return PunctuationMark.CLOSING_CURLY_BRACKET.value();
    }

}
