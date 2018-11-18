package com.logme;

import java.util.Collection;

class MessageBuilderImpl implements MessageBuilder {

    private final String id;
    private final StringBuilder textBuilder;
    // todo: move parameterBuilder creation to Logme
    private final ParameterBuilder parameterBuilder;

    MessageBuilderImpl() {
        this.id = null;
        this.textBuilder = new StringBuilder();
        this.parameterBuilder = new ParameterBuilderImpl(-1);
    }

    MessageBuilderImpl(String text) {
        this(null, text, -1);
    }

    MessageBuilderImpl(int indent) {
        this.id = null;
        this.textBuilder = new StringBuilder();
        this.parameterBuilder = new ParameterBuilderImpl(indent);
    }

    MessageBuilderImpl(String text, int indent) {
        this(null, text, indent);
    }

    MessageBuilderImpl(String id, String text) {
        this(id, text, -1);
    }

    MessageBuilderImpl(String id, String text, int indent) {
        this.id = id;
        this.textBuilder = new StringBuilder(text);
        this.parameterBuilder = new ParameterBuilderImpl(indent);
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
    public int getParametersIndent() {
        return parameterBuilder.getIndent();
    }

    @Override
    public MessageBuilder appendParameter(String name, String value) {
        parameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public <T> MessageBuilder appendParameter(String name, T[] values) {
        parameterBuilder.appendParameter(name, values);
        return this;
    }

    @Override
    public <T> MessageBuilder appendParameter(String name, Collection<T> values) {
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
