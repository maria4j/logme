package com.logme;

public class Logme {

    private Logme() {}

    public static LogMessage createMessage(String text) {
        return new LogMessageBuilder(text);
    }

    public static LogMessage createMessage(String id, String text) {
        return new LogMessageBuilder(id, text);
    }

    public static LogParameters createParameters() {
        return new LogParametersBuilder();
    }

    public static LogParameters createParameters(boolean multiline, int numberOfIndents) {
        return new LogParametersBuilder(multiline, numberOfIndents);
    }

}
