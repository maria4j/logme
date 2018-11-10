package com.logme;

public final class Logme {

    private Logme() {}

    // todo: поддержать
//    public static LogMessage newMessage() {
//        return new LogMessageBuilder();
//    }

    public static MessageBuilder newMessage(String text) {
        return new MessageBuilderImpl(text);
    }

    public static MessageBuilder newMessage(String text, int indent) {
        return new MessageBuilderImpl(text, indent);
    }

    public static MessageBuilder newMessage(String id, String text) {
        return new MessageBuilderImpl(id, text);
    }

    public static MessageBuilder newMessage(String id, String text, int indent) {
        return new MessageBuilderImpl(id, text, indent);
    }

    public static ParameterBuilder newParameters() {
        return new ParameterBuilderImpl();
    }

    public static ParameterBuilder newParameters(int indent) {
        return new ParameterBuilderImpl(indent);
    }

}
