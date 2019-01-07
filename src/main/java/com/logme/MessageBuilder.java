package com.logme;

import java.util.Collection;

public interface MessageBuilder {

    MessageBuilder appendMarker(String marker);

    MessageBuilder appendText(String text);

    MessageBuilder appendParameter(String name, boolean value);

    MessageBuilder appendParameter(String name, byte value);

    MessageBuilder appendParameter(String name, char value);

    MessageBuilder appendParameter(String name, double value);

    MessageBuilder appendParameter(String name, float value);

    MessageBuilder appendParameter(String name, int value);

    MessageBuilder appendParameter(String name, long value);

    MessageBuilder appendParameter(String name, Object value);

    MessageBuilder appendParameter(String name, Object value, Object nullDefault);

    <T> MessageBuilder appendParameter(String name, T[] values);

    <T> MessageBuilder appendMultilineParameter(String name, T[] values);

    <T> MessageBuilder appendParameter(String name, Collection<T> values);

    <T> MessageBuilder appendMultilineParameter(String name, Collection<T> values);

}
