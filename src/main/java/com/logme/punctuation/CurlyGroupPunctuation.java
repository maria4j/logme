package com.logme.punctuation;

/**
 * Describes indentation style for a single-line group of items enclosed in curly brackets.
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

    // todo: design notes: delimiter and indent are separated because it allows to create one multiline wrapper instead of many for each group punctuation
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
