package com.logme.punctuation;

public enum PunctuationMark {

    OPENING_BRACE("{"),
    CLOSING_BRACE("}"),
    OPENING_BRACKET("["),
    CLOSING_BRACKET("]"),
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
