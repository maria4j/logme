package com.logme;

import com.logme.punctuation.PunctuationMark;

import java.util.Collection;

class MessageBuilderImpl implements MessageBuilder {

    private final StringBuilder mainBuilder;
    private final ParameterBuilderFactory parameterBuilderFactory;
    private ParameterBuilder currentParameterBuilder;

    MessageBuilderImpl(ParameterBuilderFactory parameterBuilderFactory) {
        this.mainBuilder = new StringBuilder();
        this.parameterBuilderFactory = parameterBuilderFactory;
        this.currentParameterBuilder = null;
    }

    MessageBuilderImpl(String text, ParameterBuilderFactory parameterBuilderFactory) {
        this.mainBuilder = new StringBuilder(text);
        this.parameterBuilderFactory = parameterBuilderFactory;
        this.currentParameterBuilder = null;
    }

    @Override
    public MessageBuilder appendMarker(String marker) {
        flushParameters();

        mainBuilder.append(PunctuationMark.OPENING_SQUARE_BRACKET.value())
                   .append(marker)
                   .append(PunctuationMark.CLOSING_SQUARE_BRACKET.value());

        return this;
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
        flushParameters();
        return mainBuilder.toString();
    }

}
