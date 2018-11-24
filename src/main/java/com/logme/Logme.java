package com.logme;

import com.logme.punctuation.InlineItemPunctuation;
import com.logme.punctuation.InlineObjectGroupPunctuation;
import com.logme.punctuation.MultilineGroupPunctuation;

public final class Logme {

    private Logme() {
    }

    // TODO: default inline
    public static MessageBuilder newMessage() {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(InlineObjectGroupPunctuation.INSTANCE, InlineItemPunctuation.INSTANCE);
        return new MessageBuilderImpl(parameterBuilder);
    }

    public static MessageBuilder newMessage(String text) {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(InlineObjectGroupPunctuation.INSTANCE, InlineItemPunctuation.INSTANCE);
        return new MessageBuilderImpl(text, parameterBuilder);
    }

    public static MessageBuilder newMessage(int indent) {
        final MultilineGroupPunctuation multilinePunctuation = new MultilineGroupPunctuation(indent);
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(multilinePunctuation, InlineItemPunctuation.INSTANCE);
        return new MessageBuilderImpl(parameterBuilder);
    }

    public static MessageBuilder newMessage(String text, int indent) {
        final MultilineGroupPunctuation multilinePunctuation = new MultilineGroupPunctuation(indent);
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(multilinePunctuation, InlineItemPunctuation.INSTANCE);
        return new MessageBuilderImpl(text, parameterBuilder);
    }

    public static MessageBuilder newMessage(String id, String text) {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(InlineObjectGroupPunctuation.INSTANCE, InlineItemPunctuation.INSTANCE);
        return new MessageBuilderImpl(id, text, parameterBuilder);
    }

    public static MessageBuilder newMessage(String id, String text, int indent) {
        final MultilineGroupPunctuation multilinePunctuation = new MultilineGroupPunctuation(indent);
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(multilinePunctuation, InlineItemPunctuation.INSTANCE);
        return new MessageBuilderImpl(id, text, parameterBuilder);
    }

    public static ParameterBuilder newParameters() {
        return new ParameterBuilderImpl(InlineObjectGroupPunctuation.INSTANCE, InlineItemPunctuation.INSTANCE);
    }

    public static ParameterBuilder newParameters(int indent) {
        final MultilineGroupPunctuation multilinePunctuation = new MultilineGroupPunctuation(indent);
        return new ParameterBuilderImpl(multilinePunctuation, InlineItemPunctuation.INSTANCE);
    }

}
