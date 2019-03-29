package com.logme;

import com.logme.punctuation.PunctuationMark;

import java.util.function.Consumer;

public class Message {

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

    public Message appendParameters(Consumer<Parameters> consumer) {
        Parameters parameters = new Parameters();
        consumer.accept(parameters);
        builder.append(parameters.toString());
        return this;
    }

    public Message appendMultilineParameters(Consumer<MultilineParameters> consumer) {
        MultilineParameters multilineParameters = new MultilineParameters();
        consumer.accept(multilineParameters);
        builder.append(multilineParameters.toString());
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }

}
