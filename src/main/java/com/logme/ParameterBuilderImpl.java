package com.logme;

import com.logme.punctuation.CurlyIndentationStyle;
import com.logme.punctuation.SquareIndentationStyle;
import com.logme.punctuation.IndentationStyle;
import com.logme.punctuation.PunctuationMark;

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
    private static final IndentationStyle DEFAULT_INDENTATION_STYLE = CurlyIndentationStyle.INSTANCE;
    private static final IndentationStyle DEFAULT_VALUE_INDENTATION_STYLE = SquareIndentationStyle.INSTANCE;

    private final StringBuilder stringBuilder = new StringBuilder();
    private final IndentationStyle indentationStyle;
    private final IndentationStyle valueIndentationStyle;

    ParameterBuilderImpl() {
        this.indentationStyle = DEFAULT_INDENTATION_STYLE;
        this.valueIndentationStyle = DEFAULT_VALUE_INDENTATION_STYLE;
    }

    ParameterBuilderImpl(IndentationStyle indentationStyle) {
        this.indentationStyle = indentationStyle;
        this.valueIndentationStyle = DEFAULT_VALUE_INDENTATION_STYLE;
    }

    @Override
    public IndentationStyle getIndentationStyle() {
        return indentationStyle;
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
        return null;
    }

    @Override
    public <T> ParameterBuilder appendParameter(String name, T[] values) {
        appendDelimiter();

        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(valueIndentationStyle.getOpeningMark());

        boolean empty = true;
        for (T value : values) {
            if (empty) {
                empty = false;
            } else {
                stringBuilder.append(valueIndentationStyle.getDelimiter()).append(valueIndentationStyle.getIndent());
            }

            stringBuilder.append(value.toString());
        }

        stringBuilder.append(valueIndentationStyle.getClosingMark());

        return this;
    }

    @Override
    public <T> ParameterBuilder appendParameter(String name, Collection<T> values) {
        appendDelimiter();

        stringBuilder.append(name).append(NAME_VALUE_DELIMITER).append(valueIndentationStyle.getOpeningMark());

        boolean empty = true;
        for (Object value : values) {
            if (empty) {
                empty = false;
            } else {
                stringBuilder.append(valueIndentationStyle.getDelimiter()).append(valueIndentationStyle.getIndent());
            }

            stringBuilder.append(value.toString());
        }

        stringBuilder.append(valueIndentationStyle.getClosingMark());

        return this;
    }

    private void appendDelimiter() {
        if (stringBuilder.length() > 0) {
            stringBuilder.append(indentationStyle.getDelimiter()).append(indentationStyle.getIndent());
        }
    }

    @Override
    public String toString() {
        return indentationStyle.getOpeningMark() + stringBuilder.toString() + indentationStyle.getClosingMark();
    }

}
