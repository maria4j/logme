package com.logme;

import java.util.Collection;

/**
 * @author Maria
 * @since 02.08.2018
 */
class ParameterBuilderImpl implements ParameterBuilder {

    private final StringBuilder stringBuilder = new StringBuilder();
    private final int numberOfIndents;
    private final String indentString;

    ParameterBuilderImpl() {
        this(-1);
    }

    ParameterBuilderImpl(int numberOfIndents) {
        this.numberOfIndents = numberOfIndents;

        if (numberOfIndents <= 0) {
            indentString = ""; // todo: возможно, чтобы было более очевидно, если < 0, то null
        } else {
            indentString = buildIndentString(numberOfIndents);
        }
    }

    @Override
    public int getNumberOfIndents() {
        return numberOfIndents;
    }

    @Override
    public boolean hasParameters() {
        return stringBuilder.length() > 0;
    }

    @Override
    public ParameterBuilder appendParameter(String name, String value) {
        if (hasParameters()) {
            stringBuilder.append(", ");

            if (hasIndents()) {
                stringBuilder.append(System.lineSeparator());
            }
        }

        if (hasIndents()) {
            stringBuilder.append(indentString);
        }

        stringBuilder.append(name).append("=").append(value);

        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, String[] values) {
        if (hasParameters()) {
            stringBuilder.append(", ");

            if (hasIndents()) {
                stringBuilder.append(System.lineSeparator());
            }
        }

        if (hasIndents()) {
            stringBuilder.append(indentString);
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
    public ParameterBuilder appendParameter(String name, Collection<ParameterBuilder> values) {
        if (hasParameters()) {
            stringBuilder.append(", ");

            if (hasIndents()) {
                stringBuilder.append(System.lineSeparator());
            }
        }

        if (hasIndents()) {
            stringBuilder.append(indentString);
        }

        stringBuilder.append(name).append("=[");

        boolean empty = true;
        for (ParameterBuilder value : values) {
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
        return numberOfIndents >= 0;
    }

    private String buildIndentString(int numberOfIndents) {
        StringBuilder indentBuilder = new StringBuilder();
        int count = numberOfIndents;
        while (count > 0) {
            indentBuilder.append('\t');
            count--;
        }
        return indentBuilder.toString();
    }

    @Override
    public String toString() {
        if (hasIndents()) {
            if (numberOfIndents <= 0) {
                return "{" + System.lineSeparator() + stringBuilder.toString() + System.lineSeparator() + "}";
            }
            String lastIndentString = buildIndentString(numberOfIndents - 1);
            return "{" + System.lineSeparator() + stringBuilder.toString() + System.lineSeparator() + lastIndentString + "}";
        }
        return "{" + stringBuilder.toString() + "}";
    }
}
