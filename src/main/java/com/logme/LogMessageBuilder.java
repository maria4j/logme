package com.logme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class LogMessageBuilder implements LogMessage {

    private final String id;
    private final StringBuilder textBuilder;
    private final List<LogMessage> appendedMessages = new ArrayList<>();

    private final LogParameters parameters = new LogParametersBuilder();

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
    public LogMessage appendParameter(String name, String value) {
        parameters.append(name, value);
        return this;
    }

    @Override
    public LogMessage appendParameter(String name, String[] values) {
        parameters.append(name, values);
        return this;
    }

    @Override
    public LogMessage appendParameter(String name, Collection<LogParameters> values) {
        parameters.append(name, values);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (id != null) {
            stringBuilder.append("[").append(id).append("] ");
        }

        stringBuilder.append(textBuilder);

        if (!parameters.isEmpty()) {
            stringBuilder.append(" ").append(parameters);
        }

        for (LogMessage appendedMessage : appendedMessages) {
            stringBuilder.append(" ").append(appendedMessage.toString());
        }

        return stringBuilder.toString();
    }

}
