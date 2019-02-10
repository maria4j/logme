package com.logme;

import com.logme.punctuation.PunctuationMark;

import java.util.function.Consumer;

class Message {

    private final StringBuilder builder;

    Message() {
        this.builder = new StringBuilder();
    }

    Message(String text) {
        this.builder = new StringBuilder(text);
    }

    public Message appendTag(String value) {
        builder.append(PunctuationMark.OPENING_SQUARE_BRACKET.value())
                .append(value)
                .append(PunctuationMark.CLOSING_SQUARE_BRACKET.value());
        return this;
    }

    public Message append(String text) {
        builder.append(text);
        return this;
    }

    public Message append(Parameters parameters) {
        builder.append(parameters.toString());
        return this;
    }

    public Message append(Consumer<Parameters> parametersConsumer) {
        Parameters parameters = ParametersFactory.parameters();
        parametersConsumer.accept(parameters);
        append(parameters);
        return this;
    }

    public Message append(LogmeStyle style, Consumer<Parameters> parametersConsumer) {
        Parameters parameters = ParametersFactory.parameters(style);
        parametersConsumer.accept(parameters);
        append(parameters);
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }

}
