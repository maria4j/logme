package com.logme;

import java.util.ArrayList;
import java.util.List;

class LogMessageBuilder implements LogMessage {

    private final String id;
    private final StringBuilder textBuilder;
    private final List<LogMessage> appendedMessages = new ArrayList<>();

    private LogParameters parameters = null;

    LogMessageBuilder(String text) {
        this.textBuilder = new StringBuilder(text);
        this.id = null;
    }

    LogMessageBuilder(String id, String text) {
        this.textBuilder = new StringBuilder(text);
        this.id = id;
    }

    @Override
    public LogMessageBuilder appendText(String text) {
        textBuilder.append(text);
        return this;
    }

    @Override
    public LogMessageBuilder appendMessage(LogMessage message) {
        appendedMessages.add(message);
        return this;
    }

    @Override
    public LogMessageBuilder setParameters(LogParameters parameters) {
        this.parameters = parameters;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (id != null) {
            stringBuilder.append("[").append(id).append("] ");
        }

        stringBuilder.append(textBuilder);

        if (parameters != null && !parameters.isEmpty()) {
            stringBuilder.append(" ").append(parameters);
        }

        for (LogMessage appendedMessage : appendedMessages) {
            stringBuilder.append(" ").append(appendedMessage.toString());
        }

        return stringBuilder.toString();
    }

}
