package com.logme;

import com.logme.punctuation.CurlyIndentationStyle;
import com.logme.punctuation.OtbsIndentationStyle;

public final class Logme {

    private Logme() {
    }

    // TODO: default inline
    public static MessageBuilder newMessage() {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(CurlyIndentationStyle.INSTANCE);
        return new MessageBuilderImpl(parameterBuilder);
    }

    public static MessageBuilder newMessage(String text) {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(CurlyIndentationStyle.INSTANCE);
        return new MessageBuilderImpl(text, parameterBuilder);
    }

    public static MessageBuilder newMessage(int indent) {
        final OtbsIndentationStyle otbsStyle = new OtbsIndentationStyle(indent);
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(otbsStyle);
        return new MessageBuilderImpl(parameterBuilder);
    }

    public static MessageBuilder newMessage(String text, int indent) {
        final OtbsIndentationStyle otbsStyle = new OtbsIndentationStyle(indent);
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(otbsStyle);
        return new MessageBuilderImpl(text, parameterBuilder);
    }

    public static MessageBuilder newMessage(String id, String text) {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(CurlyIndentationStyle.INSTANCE);
        return new MessageBuilderImpl(id, text, parameterBuilder);
    }

    public static MessageBuilder newMessage(String id, String text, int indent) {
        final OtbsIndentationStyle otbsStyle = new OtbsIndentationStyle(indent);
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(otbsStyle);
        return new MessageBuilderImpl(id, text, parameterBuilder);
    }

    public static ParameterBuilder newParameters() {
        return new ParameterBuilderImpl(CurlyIndentationStyle.INSTANCE);
    }

    public static ParameterBuilder newParameters(int indent) {
        final OtbsIndentationStyle otbsStyle = new OtbsIndentationStyle(indent);
        return new ParameterBuilderImpl(otbsStyle);
    }

}
