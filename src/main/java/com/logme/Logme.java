package com.logme;

public final class Logme {

    private Logme() {}

    public static MessageBuilder newMessage() {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl();
        return new MessageBuilderImpl(parameterBuilder);
    }

    public static MessageBuilder newMessage(String text) {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl();
        return new MessageBuilderImpl(text, parameterBuilder);
    }

    public static MessageBuilder newMessage(int indent) {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(indent);
        return new MessageBuilderImpl(parameterBuilder);
    }

    public static MessageBuilder newMessage(String text, int indent) {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(indent);
        return new MessageBuilderImpl(text, parameterBuilder);
    }

    public static MessageBuilder newMessage(String id, String text) {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl();
        return new MessageBuilderImpl(id, text, parameterBuilder);
    }

    public static MessageBuilder newMessage(String id, String text, int indent) {
        final ParameterBuilder parameterBuilder = new ParameterBuilderImpl(indent);
        return new MessageBuilderImpl(id, text, parameterBuilder);
    }

    public static ParameterBuilder newParameters() {
        return new ParameterBuilderImpl();
    }

    public static ParameterBuilder newParameters(int indent) {
        return new ParameterBuilderImpl(indent);
    }

}
