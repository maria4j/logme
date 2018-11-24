package com.logme;

import com.logme.punctuation.PunctuationMark;

import java.util.Collection;

class MessageBuilderImpl implements MessageBuilder {

    private final String id;
    private final StringBuilder textBuilder;
    private final ParameterBuilder parameterBuilder;

    MessageBuilderImpl(ParameterBuilder parameterBuilder) {
        this.id = null;
        this.textBuilder = new StringBuilder();
        this.parameterBuilder = parameterBuilder;
    }

    MessageBuilderImpl(String text, ParameterBuilder parameterBuilder) {
        this.id = null;
        this.textBuilder = new StringBuilder(text);
        this.parameterBuilder = parameterBuilder;
    }

    MessageBuilderImpl(String id, String text, ParameterBuilder parameterBuilder) {
        this.id = id;
        this.textBuilder = new StringBuilder(text);
        this.parameterBuilder = parameterBuilder;
    }

    @Override
    public MessageBuilder appendText(String text) {
        textBuilder.append(text);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, boolean value) {
        parameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, byte value) {
        parameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, char value) {
        parameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, double value) {
        parameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, float value) {
        parameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, int value) {
        parameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, long value) {
        parameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public boolean hasParameters() {
        return parameterBuilder.hasParameters();
    }

    @Override
    public MessageBuilder appendParameter(String name, Object value) {
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
            stringBuilder.append(PunctuationMark.OPENING_BRACKET.value())
                         .append(id)
                         .append(PunctuationMark.CLOSING_BRACKET.value())
                         .append(PunctuationMark.SPACE.value());
        }

        stringBuilder.append(textBuilder);

        if (hasParameters()) {
            stringBuilder.append(PunctuationMark.SPACE.value()).append(parameterBuilder);
        }

        return stringBuilder.toString();
    }

}
