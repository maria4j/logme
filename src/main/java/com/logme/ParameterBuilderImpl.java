package com.logme;

import com.logme.punctuation.*;

import java.util.Collection;

/**
 * @author Maria
 * @since 02.08.2018
 */
class ParameterBuilderImpl implements ParameterBuilder {

    /**
     * A delimiter between name and value.
     */
    private static final String NAME_VALUE_DELIMITER = PunctuationMark.EQUAL_SIGN.value();
    private static final GroupPunctuation DEFAULT_PUNCTUATION = CurlyGroupPunctuation.INSTANCE;
    private static final GroupPunctuation DEFAULT_VALUE_PUNCTUATION = SquareGroupPunctuation.INSTANCE;

    private final StringBuilder stringBuilder = new StringBuilder();
    private final GroupPunctuation punctuation;
    private final GroupPunctuation valuePunctuation;
    private final MultilineGroupPunctuation multilineValuePunctuation;

    ParameterBuilderImpl() {
        this(DEFAULT_PUNCTUATION);
    }

    // todo: pull valuePunctuation up
    ParameterBuilderImpl(GroupPunctuation punctuation) {
        this.punctuation = punctuation;
        this.valuePunctuation = DEFAULT_VALUE_PUNCTUATION;

        int baseIndent = 0;
        if (punctuation instanceof MultilineGroupPunctuation) {
            baseIndent = ((MultilineGroupPunctuation) punctuation).getIndentLevel();
        }
        this.multilineValuePunctuation = new MultilineGroupPunctuation(baseIndent + 1, valuePunctuation);
    }

    @Override
    public ParameterBuilder appendParameter(String name, boolean value) {
        appendDelimiter();
        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, byte value) {
        appendDelimiter();
        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, char value) {
        appendDelimiter();
        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, double value) {
        appendDelimiter();
        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, float value) {
        appendDelimiter();
        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, int value) {
        appendDelimiter();
        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, long value) {
        appendDelimiter();
        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, Object value) {
        appendDelimiter();
        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, Object value, Object nullDefault) {
        appendDelimiter();
        final Object appendingValue = value != null ? value : nullDefault;
        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(appendingValue);
        return this;
    }

    @Override
    public <T> ParameterBuilder appendParameter(String name, T[] values) {
        return appendParameter(name, values, valuePunctuation);
    }

    @Override
    public <T> ParameterBuilder appendMultilineParameter(String name, T[] values) {
        return appendParameter(name, values, multilineValuePunctuation);
    }

    @Override
    public <T> ParameterBuilder appendParameter(String name, Collection<T> values) {
        return appendParameter(name, values, valuePunctuation);
    }

    @Override
    public <T> ParameterBuilder appendMultilineParameter(String name, Collection<T> values) {
        return appendParameter(name, values, multilineValuePunctuation);
    }

    private <T> ParameterBuilder appendParameter(String name, T[] values, GroupPunctuation valuePunctuation) {
        appendDelimiter();

        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(valuePunctuation.getOpeningMark());

        boolean empty = true;
        for (T value : values) {
            if (empty) {
                empty = false;
            } else {
                stringBuilder.append(valuePunctuation.getDelimiter()).append(valuePunctuation.getIndent());
            }

            // todo: move to multiline and check in hierarchy
            String result = value.toString();
            if (valuePunctuation == multilineValuePunctuation && value instanceof ParameterBuilder) {
                result = result.replace(System.lineSeparator(), System.lineSeparator() + "    ");
            }
            stringBuilder.append(result);
        }

        stringBuilder.append(valuePunctuation.getClosingMark());

        return this;

    }

    private <T> ParameterBuilder appendParameter(String name, Collection<T> values, GroupPunctuation valuePunctuation) {
        appendDelimiter();

        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(valuePunctuation.getOpeningMark());

        boolean empty = true;
        for (Object value : values) {
            if (empty) {
                empty = false;
            } else {
                stringBuilder.append(valuePunctuation.getDelimiter()).append(valuePunctuation.getIndent());
            }

            // todo: move to multiline and check in hierarchy
            String result = value.toString();
            if (valuePunctuation == multilineValuePunctuation && value instanceof ParameterBuilder) {
                result = result.replace(System.lineSeparator(), System.lineSeparator() + "    ");
            }
            stringBuilder.append(result);
        }

        stringBuilder.append(valuePunctuation.getClosingMark());

        return this;
    }

    private void appendDelimiter() {
        if (stringBuilder.length() > 0) {
            stringBuilder.append(punctuation.getDelimiter()).append(punctuation.getIndent());
        }
    }

    @Override
    public String toString() {
        return punctuation.getOpeningMark() + stringBuilder.toString() + punctuation.getClosingMark();
    }

}
