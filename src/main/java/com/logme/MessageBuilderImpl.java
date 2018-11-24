package com.logme;

import com.logme.punctuation.PunctuationMark;

import java.util.Collection;

class MessageBuilderImpl implements MessageBuilder {

    private final String id;
    private final StringBuilder mainBuilder;
    private final ParameterBuilderFactory parameterBuilderFactory;
    private ParameterBuilder currentParameterBuilder;

    MessageBuilderImpl(ParameterBuilderFactory parameterBuilderFactory) {
        this.id = null;
        this.mainBuilder = new StringBuilder();
        this.parameterBuilderFactory = parameterBuilderFactory;
        this.currentParameterBuilder = null;
    }

    MessageBuilderImpl(String text, ParameterBuilderFactory parameterBuilderFactory) {
        this.id = null;
        this.mainBuilder = new StringBuilder(text);
        this.parameterBuilderFactory = parameterBuilderFactory;
        this.currentParameterBuilder = null;
    }

    MessageBuilderImpl(String id, String text, ParameterBuilderFactory parameterBuilderFactory) {
        this.id = id;
        this.mainBuilder = new StringBuilder(text);
        this.parameterBuilderFactory = parameterBuilderFactory;
        this.currentParameterBuilder = null;
    }

    @Override
    public MessageBuilder appendText(String text) {
        flushParameters();

        mainBuilder.append(text);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, boolean value) {
        initParameters();
        currentParameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, byte value) {
        initParameters();
        currentParameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, char value) {
        initParameters();
        currentParameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, double value) {
        initParameters();
        currentParameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, float value) {
        initParameters();
        currentParameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, int value) {
        initParameters();
        currentParameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, long value) {
        initParameters();
        currentParameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public MessageBuilder appendParameter(String name, Object value) {
        initParameters();
        currentParameterBuilder.appendParameter(name, value);
        return this;
    }

    @Override
    public <T> MessageBuilder appendParameter(String name, T[] values) {
        initParameters();
        currentParameterBuilder.appendParameter(name, values);
        return this;
    }

    @Override
    public <T> MessageBuilder appendParameter(String name, Collection<T> values) {
        initParameters();
        currentParameterBuilder.appendParameter(name, values);
        return this;
    }

    private void initParameters() {
        if (currentParameterBuilder == null) {
            currentParameterBuilder = parameterBuilderFactory.newParameterBuilder();
        }
    }

    private void flushParameters() {
        if (currentParameterBuilder == null) {
            return;
        }

        // todo: remove additional spaces
        if (mainBuilder.length() > 0) {
            mainBuilder.append(PunctuationMark.SPACE.value());
        }

        mainBuilder.append(currentParameterBuilder.toString());
        currentParameterBuilder = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (id != null) {
            stringBuilder.append(PunctuationMark.OPENING_SQUARE_BRACKET.value())
                         .append(id)
                         .append(PunctuationMark.CLOSING_SQUARE_BRACKET.value())
                         .append(PunctuationMark.SPACE.value());
        }

        flushParameters();

        stringBuilder.append(mainBuilder);

        return stringBuilder.toString();
    }

}
