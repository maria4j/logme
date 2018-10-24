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

    public static MessageBuilder newMessage(String text, int numberOfIndents) {
        return new MessageBuilderImpl(text, numberOfIndents);
    }

    public static MessageBuilder newMessage(String id, String text) {
        return new MessageBuilderImpl(id, text);
    }

    public static MessageBuilder newMessage(String id, String text, int numberOfIndents) {
        return new MessageBuilderImpl(id, text, numberOfIndents);
    }

    public static ParameterBuilder newParameters() {
        return new ParameterBuilderImpl();
    }

    public static ParameterBuilder newParameters(int numberOfIndents) {
        return new ParameterBuilderImpl(numberOfIndents);
    }

}
