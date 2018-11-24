package com.logme.punctuation;

public class InlineArrayGroupPunctuation implements GroupPunctuation {

    static final InlineArrayGroupPunctuation INSTANCE = new InlineArrayGroupPunctuation();

    private InlineArrayGroupPunctuation() {
    }

    @Override
    public String getOpeningMark() {
        return PunctuationMark.OPENING_BRACKET.value();
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
        return PunctuationMark.CLOSING_BRACKET.value();
    }

}
