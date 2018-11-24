package com.logme.punctuation;

public class InlineItemPunctuation implements ItemPunctuation {

    public static final InlineItemPunctuation INSTANCE = new InlineItemPunctuation();

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
