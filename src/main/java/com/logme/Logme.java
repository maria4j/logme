package com.logme;

import com.logme.punctuation.CurlyGroupPunctuation;
import com.logme.punctuation.MultilineGroupPunctuation;

public final class Logme {

    private Logme() {
    }

    public static MessageBuilder newMessage() {
        return new MessageBuilderImpl(ParameterBuilderFactoryImpl.DEFAULT);
    }

    public static MessageBuilder newMessage(String text) {
        return new MessageBuilderImpl(text, ParameterBuilderFactoryImpl.DEFAULT);
    }

    // todo: without indent level
    public static MessageBuilder newMultilineMessage(int indentLevel) {
        final MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(indentLevel, CurlyGroupPunctuation.INSTANCE);
        final ParameterBuilderFactory parameterBuilderFactory = new ParameterBuilderFactoryImpl(multilineStyle);
        return new MessageBuilderImpl(parameterBuilderFactory);
    }

    public static MessageBuilder newMultilineMessage(String text, int indentLevel) {
        final MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(indentLevel, CurlyGroupPunctuation.INSTANCE);
        final ParameterBuilderFactory parameterBuilderFactory = new ParameterBuilderFactoryImpl(multilineStyle);
        return new MessageBuilderImpl(text, parameterBuilderFactory);
    }

    public static ParameterBuilder newParameters() {
        return ParameterBuilderFactoryImpl.DEFAULT.newParameterBuilder();
    }

    public static ParameterBuilder newMultilineParameters(int indentLevel) {
        final MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(indentLevel, CurlyGroupPunctuation.INSTANCE);
        final ParameterBuilderFactory parameterBuilderFactory = new ParameterBuilderFactoryImpl(multilineStyle);
        return parameterBuilderFactory.newParameterBuilder();
    }

}
