package com.logme;

class InlineObjectGroupPunctuation implements GroupPunctuation {

    static final InlineObjectGroupPunctuation INSTANCE = new InlineObjectGroupPunctuation();

    private InlineObjectGroupPunctuation() {
    }

    @Override
    public String getOpeningMark() {
        return PunctuationMark.OPENING_BRACE.value();
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
        return PunctuationMark.CLOSING_BRACE.value();
    }

}
