package com.logme;

public final class Logme {

    private Logme() {}

    // todo: поддержать
//    public static LogMessage newMessageBuilder() {
//        return new LogMessageBuilder();
//    }

    public static MessageBuilder newMessageBuilder(String text) {
        return new MessageBuilderImpl(text);
    }

    public static MessageBuilder newMessageBuilder(String text, int numberOfIndents) {
        return new MessageBuilderImpl(text, numberOfIndents);
    }

    public static MessageBuilder newMessageBuilder(String id, String text) {
        return new MessageBuilderImpl(id, text);
    }

    public static MessageBuilder newMessageBuilder(String id, String text, int numberOfIndents) {
        return new MessageBuilderImpl(id, text, numberOfIndents);
    }

    public static ParameterBuilder newParameterBuilder() {
        return new ParameterBuilderImpl();
    }

    public static ParameterBuilder newParameterBuilder(int numberOfIndents) {
        return new ParameterBuilderImpl(numberOfIndents);
    }

}
