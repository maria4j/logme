package com.logme;

public final class Logme {

    private Logme() {
    }

    public static Message message() {
        return new Message();
    }

    public static Message message(String text) {
        return new Message(text);
    }

    public static Parameters parameters() {
        return ParametersFactory.parameters();
    }

    public static Parameters multilineParameters(int indentLevel) {
        return ParametersFactory.multilineParameters(indentLevel);
    }

}
