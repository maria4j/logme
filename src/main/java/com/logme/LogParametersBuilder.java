package com.logme;


import java.util.Collection;

/**
 * @author Maria
 * @since 02.08.2018
 */
class LogParametersBuilder implements LogParameters {

    private final StringBuilder stringBuilder = new StringBuilder();

    LogParametersBuilder() {}

    @Override
    public LogParametersBuilder append(String name, String value) {
        if (!isEmpty()) {
            stringBuilder.append(", ");
        }

        stringBuilder.append(name).append("=").append(value);

        return this;
    }

    @Override
    public LogParametersBuilder append(String name, String[] values) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append(", ");
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
        if (stringBuilder.length() != 0) {
            stringBuilder.append(", ");
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

    public boolean isEmpty() {
        return stringBuilder.length() == 0;
    }

    @Override
    public String toString() {
        return "{" + stringBuilder.toString() + "}";
    }

}
