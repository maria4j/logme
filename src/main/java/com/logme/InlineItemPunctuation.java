package com.logme;

class InlineItemPunctuation implements ItemPunctuation {

    static final InlineItemPunctuation INSTANCE = new InlineItemPunctuation();

    private InlineItemPunctuation() {
    }

    @Override
    public String getKeyValueDelimiter() {
        return PunctuationMark.EQUAL_SIGN.value();
    }

    @Override
    public GroupPunctuation getValueGroupPunctuation() {
        return InlineArrayGroupPunctuation.INSTANCE;
    }

}
