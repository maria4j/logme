package com.logme;

import java.util.Collection;

/**
 * @author Maria
 * @since 02.08.2018
 */
class ParameterBuilderImpl implements ParameterBuilder {

    private static final int NO_INDENT = -1;
    private static final int TAB_SIZE = 4;

    private final StringBuilder stringBuilder = new StringBuilder();
    private final int indent;
    private final String indentString;

    ParameterBuilderImpl() {
        this(NO_INDENT);
    }

    ParameterBuilderImpl(int indent) {
        this.indent = indent;

        if (indent <= 0) {
            indentString = ""; // todo: возможно, чтобы было более очевидно, если < 0, то null
        } else {
            indentString = buildIndentString(TAB_SIZE * indent);
        }
    }

    private static String buildIndentString(int indent) {
        StringBuilder indentBuilder = new StringBuilder();
        int count = indent;
        while (count > 0) {
            indentBuilder.append(' ');
            count--;
        }
        return indentBuilder.toString();
    }

    @Override
    public int getIndent() {
        return indent;
    }

    @Override
    public boolean hasParameters() {
        return stringBuilder.length() > 0;
    }

    @Override
    public ParameterBuilder appendParameter(String name, boolean value) {
        appendSeparators();
        stringBuilder.append(name).append("=").append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, byte value) {
        appendSeparators();
        stringBuilder.append(name).append("=").append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, char value) {
        appendSeparators();
        stringBuilder.append(name).append("=").append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, double value) {
        appendSeparators();
        stringBuilder.append(name).append("=").append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, float value) {
        appendSeparators();
        stringBuilder.append(name).append("=").append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, int value) {
        appendSeparators();
        stringBuilder.append(name).append("=").append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, long value) {
        appendSeparators();
        stringBuilder.append(name).append("=").append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, String value) {
        appendSeparators();
        stringBuilder.append(name).append("=").append(value);
        return this;
    }

    @Override
    public <T> ParameterBuilder appendParameter(String name, T[] values) {
        appendSeparators();

        stringBuilder.append(name).append("=[");

        boolean empty = true;
        for (T value : values) {
            if (empty) {
                empty = false;
            } else {
                stringBuilder.append(", ");
            }

            stringBuilder.append(value.toString());
        }

        stringBuilder.append("]");

        return this;
    }

    @Override
    public <T> ParameterBuilder appendParameter(String name, Collection<T> values) {
        appendSeparators();

        stringBuilder.append(name).append("=[");

        boolean empty = true;
        for (Object value : values) {
            if (empty) {
                empty = false;
            } else {
                stringBuilder.append(", ");
            }

            stringBuilder.append(value.toString());
        }

        stringBuilder.append("]");

        return this;
    }

    private boolean hasIndents() {
        return indent >= 0;
    }

    private void appendSeparators() {
        if (hasParameters()) {
            stringBuilder.append(", ");

            if (hasIndents()) {
                stringBuilder.append(System.lineSeparator());
            }
        }

        if (hasIndents()) {
            stringBuilder.append(indentString);
        }
    }

    @Override
    public String toString() {
        if (hasIndents()) {
            if (indent <= 0) {
                return "{" + System.lineSeparator() + stringBuilder.toString() + System.lineSeparator() + "}";
            }
            String lastIndentString = buildIndentString(indent - 1);
            return "{" + System.lineSeparator() + stringBuilder.toString() + System.lineSeparator() + lastIndentString + "}";
        }
        return "{" + stringBuilder.toString() + "}";
    }
}
