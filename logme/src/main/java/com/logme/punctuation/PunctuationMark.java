package com.logme.punctuation;

/**
 * The {@code PunctuationMark} class includes all marks that are used to punctuate in Logme messages.
 */
public enum PunctuationMark {

    OPENING_CURLY_BRACKET("{"),
    CLOSING_CURLY_BRACKET("}"),
    OPENING_SQUARE_BRACKET("["),
    CLOSING_SQUARE_BRACKET("]"),
    COMMA(","),
    EQUAL_SIGN("="),
    SPACE(" ");

    private final String value;

    PunctuationMark(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
