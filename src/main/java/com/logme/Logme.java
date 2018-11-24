package com.logme;

import com.logme.punctuation.OtbsIndentationStyle;

public final class Logme {

    private Logme() {
    }

    public static MessageBuilder newMessage() {
        return new MessageBuilderImpl(ParameterBuilderFactoryImpl.DEFAULT);
    }

    public static MessageBuilder newMessage(String text) {
        return new MessageBuilderImpl(text, ParameterBuilderFactoryImpl.DEFAULT);
    }

    public static MessageBuilder newMessage(int indent) {
        final OtbsIndentationStyle otbsStyle = new OtbsIndentationStyle(indent);
        final ParameterBuilderFactory parameterBuilderFactory = new ParameterBuilderFactoryImpl(otbsStyle);
        return new MessageBuilderImpl(parameterBuilderFactory);
    }

    public static MessageBuilder newMessage(String text, int indent) {
        final OtbsIndentationStyle otbsStyle = new OtbsIndentationStyle(indent);
        final ParameterBuilderFactory parameterBuilderFactory = new ParameterBuilderFactoryImpl(otbsStyle);
        return new MessageBuilderImpl(text, parameterBuilderFactory);
    }

    public static MessageBuilder newMessage(String id, String text) {
        return new MessageBuilderImpl(id, text, ParameterBuilderFactoryImpl.DEFAULT);
    }

    public static MessageBuilder newMessage(String id, String text, int indent) {
        final OtbsIndentationStyle otbsStyle = new OtbsIndentationStyle(indent);
        final ParameterBuilderFactory parameterBuilderFactory = new ParameterBuilderFactoryImpl(otbsStyle);
        return new MessageBuilderImpl(id, text, parameterBuilderFactory);
    }

    public static ParameterBuilder newParameters() {
        return ParameterBuilderFactoryImpl.DEFAULT.newParameterBuilder();
    }

    public static ParameterBuilder newParameters(int indent) {
        final OtbsIndentationStyle otbsStyle = new OtbsIndentationStyle(indent);
        final ParameterBuilderFactory parameterBuilderFactory = new ParameterBuilderFactoryImpl(otbsStyle);
        return parameterBuilderFactory.newParameterBuilder();
    }

}
