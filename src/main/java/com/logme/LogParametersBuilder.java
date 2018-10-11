package com.logme;

import java.util.Collection;

/**
 * @author Maria
 * @since 02.08.2018
 */
class LogParametersBuilder implements LogParameters {

    private final StringBuilder stringBuilder = new StringBuilder();
    private final boolean multiline;
    private final int numberOfIndents;
    private final String indents;

    LogParametersBuilder() {
        this(false, 0);
    }

    LogParametersBuilder(boolean multiline, int numberOfIndents) {
        this.multiline = multiline;
        this.numberOfIndents = numberOfIndents;

        if (numberOfIndents <= 0) {
            indents = null;
        } else {
            StringBuilder indentBuilder = new StringBuilder();
            int count = numberOfIndents;
            while (count > 0) {
                indentBuilder.append('\t');
                count--;
            }
            indents = indentBuilder.toString();
        }
    }

    @Override
    public LogParametersBuilder append(String name, String value) {
        if (!isEmpty()) {
            stringBuilder.append(", ");

            if (isMultiline()) {
                stringBuilder.append(System.lineSeparator());
            }
        }

        if (indents != null) {
            stringBuilder.append(indents);
        }

        stringBuilder.append(name).append("=").append(value);

        return this;
    }

    @Override
    public LogParametersBuilder append(String name, String[] values) {
        if (!isEmpty()) {
            stringBuilder.append(", ");

            if (isMultiline()) {
                stringBuilder.append(System.lineSeparator());
            }
        }

        if (indents != null) {
            stringBuilder.append(indents);
        }

        stringBuilder.append(name).append("=[");

        boolean empty = true;
        for (String value : values) {
            if (empty) {
                empty = false;
            } else {
                stringBuilder.append(", ");
            }

            stringBuilder.append(value);
        }

        stringBuilder.append("]");

        return this;
    }

    @Override
    public LogParameters append(String name, Collection<LogParameters> values) {
        if (!isEmpty()) {
            stringBuilder.append(", ");

            if (isMultiline()) {
                stringBuilder.append(System.lineSeparator());
            }
        }

        if (indents != null) {
            stringBuilder.append(indents);
        }

        stringBuilder.append(name).append("=[");

        boolean empty = true;
        for (LogParameters value : values) {
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
    public boolean isEmpty() {
        return stringBuilder.length() == 0;
    }

    @Override
    public boolean isMultiline() {
        return multiline;
    }

    @Override
    public int getNumberOfIndents() {
        return numberOfIndents;
    }

    @Override
    public String toString() {
        if (isMultiline()) {
            if (numberOfIndents <= 1) {
                return "{" + System.lineSeparator() + stringBuilder.toString() + System.lineSeparator() + "}";
            }
            String endIndents = indents.substring(0, indents.length() - 1);
            return "{" + System.lineSeparator() + stringBuilder.toString() + System.lineSeparator() + endIndents + "}";
        }
        return "{" + stringBuilder.toString() + "}";
    }
}
