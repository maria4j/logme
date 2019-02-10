package com.logme;

import com.logme.punctuation.*;

import java.util.Collection;

/**
 * @author Maria
 * @since 02.08.2018
 */
class Parameters {

    /**
     * A delimiter between name and value.
     */
    private static final String NAME_VALUE_DELIMITER = PunctuationMark.EQUAL_SIGN.value();
    private static final GroupPunctuation DEFAULT_PUNCTUATION = CurlyGroupPunctuation.INSTANCE;
    private static final GroupPunctuation DEFAULT_VALUE_PUNCTUATION = SquareGroupPunctuation.INSTANCE;

    private final StringBuilder builder = new StringBuilder();
    private final GroupPunctuation punctuation;
    private final GroupPunctuation valuePunctuation;
    private final MultilineGroupPunctuation multilineValuePunctuation;

    Parameters() {
        this(DEFAULT_PUNCTUATION);
    }

    // todo: pull valuePunctuation up
    Parameters(GroupPunctuation punctuation) {
        this.punctuation = punctuation;
        this.valuePunctuation = DEFAULT_VALUE_PUNCTUATION;

        int baseIndent = 0;
        if (punctuation instanceof MultilineGroupPunctuation) {
            baseIndent = ((MultilineGroupPunctuation) punctuation).getIndentLevel();
        }
        this.multilineValuePunctuation = new MultilineGroupPunctuation(baseIndent + 1, valuePunctuation);
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

    public <T> Parameters append(String name, T[] values) {
        return appendParameter(name, values, valuePunctuation);
    }

    public <T> Parameters append(String name, Collection<T> values) {
        return appendParameter(name, values, valuePunctuation);
    }

    public <T> Parameters appendMultiline(String name, T[] values) {
        return appendParameter(name, values, multilineValuePunctuation);
    }

    public <T> Parameters appendMultiline(String name, Collection<T> values) {
        return appendParameter(name, values, multilineValuePunctuation);
    }

    private <T> Parameters appendParameter(String name, T[] values, GroupPunctuation valuePunctuation) {
        appendDelimiter();

        builder.append(name).append(NAME_VALUE_DELIMITER).append(valuePunctuation.getOpeningMark());

        boolean empty = true;
        for (T value : values) {
            if (empty) {
                empty = false;
            } else {
                builder.append(valuePunctuation.getDelimiter()).append(valuePunctuation.getIndent());
            }

            // todo: move to multiline and check in hierarchy
            String result = value.toString();
            if (valuePunctuation == multilineValuePunctuation && value instanceof Parameters) {
                result = result.replace(System.lineSeparator(), System.lineSeparator() + "    ");
            }
            builder.append(result);
        }

        builder.append(valuePunctuation.getClosingMark());

        return this;
    }

    private <T> Parameters appendParameter(String name, Collection<T> values, GroupPunctuation valuePunctuation) {
        appendDelimiter();

        builder.append(name).append(NAME_VALUE_DELIMITER).append(valuePunctuation.getOpeningMark());

        boolean empty = true;
        for (Object value : values) {
            if (empty) {
                empty = false;
            } else {
                builder.append(valuePunctuation.getDelimiter()).append(valuePunctuation.getIndent());
            }

            // todo: move to multiline and check in hierarchy
            String result = value.toString();
            if (valuePunctuation == multilineValuePunctuation && value instanceof Parameters) {
                result = result.replace(System.lineSeparator(), System.lineSeparator() + "    ");
            }
            builder.append(result);
        }

        builder.append(valuePunctuation.getClosingMark());

        return this;
    }

    private void appendDelimiter() {
        if (builder.length() > 0) {
            builder.append(punctuation.getDelimiter()).append(punctuation.getIndent());
        }
    }

    @Override
    public String toString() {
        return punctuation.getOpeningMark() + builder.toString() + punctuation.getClosingMark();
    }

}
