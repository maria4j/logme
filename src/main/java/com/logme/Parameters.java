package com.logme;

import com.logme.punctuation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Maria
 * @since 02.08.2018
 */
public class Parameters {

    /**
     * A delimiter between name and value.
     */
    static final String NAME_VALUE_DELIMITER = PunctuationMark.EQUAL_SIGN.value();
    static final GroupPunctuation DEFAULT_PUNCTUATION = CurlyGroupPunctuation.INSTANCE;
    static final GroupPunctuation DEFAULT_VALUE_PUNCTUATION = SquareGroupPunctuation.INSTANCE;

    private final StringBuilder builder = new StringBuilder();
    private final GroupPunctuation punctuation;
    private final GroupPunctuation valuePunctuation;

    Parameters() {
        this(DEFAULT_PUNCTUATION);
    }

    protected Parameters(GroupPunctuation punctuation) {
        this.punctuation = punctuation;
        this.valuePunctuation = DEFAULT_VALUE_PUNCTUATION;
    }

    GroupPunctuation getPunctuation() {
        return punctuation;
    }

    GroupPunctuation getValuePunctuation() {
        return valuePunctuation;
    }

    protected StringBuilder getBuilder() {
        return builder;
    }

    public Parameters append(String name, boolean value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    public Parameters append(String name, byte value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    public Parameters append(String name, char value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    public Parameters append(String name, double value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    public Parameters append(String name, float value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    public Parameters append(String name, int value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    public Parameters append(String name, long value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    public Parameters append(String name, Object value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    public Parameters append(String name, Object value, Object nullDefault) {
        appendDelimiter();
        final Object appendingValue = value != null ? value : nullDefault;
        builder.append(name).append(NAME_VALUE_DELIMITER).append(appendingValue);
        return this;
    }

    public <V> Parameters append(String name, V[] values) {
        appendDelimiter();

        builder.append(name).append(NAME_VALUE_DELIMITER).append(valuePunctuation.getOpeningMark());

        boolean empty = true;
        for (V value : values) {
            if (empty) {
                empty = false;
            } else {
                builder.append(valuePunctuation.getDelimiter()).append(valuePunctuation.getIndent());
            }

            builder.append(value.toString());
        }

        builder.append(valuePunctuation.getClosingMark());

        return this;
    }

    public <V> Parameters append(String name, Collection<V> values) {
        appendDelimiter();

        builder.append(name).append(NAME_VALUE_DELIMITER).append(valuePunctuation.getOpeningMark());

        boolean empty = true;
        for (V value : values) {
            if (empty) {
                empty = false;
            } else {
                builder.append(valuePunctuation.getDelimiter()).append(valuePunctuation.getIndent());
            }

            builder.append(value.toString());
        }

        builder.append(valuePunctuation.getClosingMark());

        return this;
    }

    public Parameters appendParameters(String name, Consumer<Parameters> valueConsumer) {
        Parameters parameters = new Parameters();
        valueConsumer.accept(parameters);
        append(name, parameters);
        return this;
    }

    public Parameters appendParameters(String name, Collection<Consumer<Parameters>> valueConsumers) {
        List<Parameters> values = new ArrayList<>(valueConsumers.size());

        for (Consumer<Parameters> valueConsumer : valueConsumers) {
            Parameters parameters = new Parameters();
            valueConsumer.accept(parameters);
            values.add(parameters);
        }

        append(name, values);
        return this;
    }

    protected void appendDelimiter() {
        if (builder.length() > 0) {
            builder.append(punctuation.getDelimiter()).append(punctuation.getIndent());
        }
    }

    @Override
    public String toString() {
        return punctuation.getOpeningMark() + builder.toString() + punctuation.getClosingMark();
    }

}
