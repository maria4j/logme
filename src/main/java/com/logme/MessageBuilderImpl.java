package com.logme;

import java.util.Collection;

class MessageBuilderImpl implements MessageBuilder {

    private final String id;
    private final StringBuilder textBuilder;
    private final ParameterBuilder parameterBuilder;

    MessageBuilderImpl(String text) {
        this(null, text, -1);
    }

    MessageBuilderImpl(String text, int numberOfIndents) {
        this(null, text, numberOfIndents);
    }

    MessageBuilderImpl(String id, String text) {
        this(id, text, -1);
    }

    MessageBuilderImpl(String id, String text, int numberOfIndents) {
        this.id = id;
        this.textBuilder = new StringBuilder(text);
        this.parameterBuilder = new ParameterBuilderImpl(numberOfIndents);
    }

    @Override
    public MessageBuilder appendText(String text) {
        textBuilder.append(text);
        return this;
    }

    @Override
    public boolean hasParameters() {
        return parameterBuilder.hasParameters();
    }

    @Override
    public int getNumberOfIndents() {
        return parameterBuilder.getNumberOfIndents();
    }

    @Override
    public MessageBuilder appendParameter(String name, String value) {
        parameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, String[] values) {
        parameterBuilder.appendParameter(name, values);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, Collection<ParameterBuilder> values) {
        parameterBuilder.appendParameter(name, values);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (id != null) {
            stringBuilder.append("[").append(id).append("] ");
        }

        stringBuilder.append(textBuilder);

        if (hasParameters()) {
            stringBuilder.append(" ").append(parameterBuilder);
        }

        return stringBuilder.toString();
    }

}
