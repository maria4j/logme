package com.logme;

enum PunctuationMark {

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

    String value() {
        return value;
    }

}
