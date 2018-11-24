package com.logme;

import java.util.Collection;

public interface MessageBuilder {

    MessageBuilder appendText(String text);

    MessageBuilder appendParameter(String name, boolean value);

    MessageBuilder appendParameter(String name, byte value);

    MessageBuilder appendParameter(String name, char value);

    MessageBuilder appendParameter(String name, double value);

    MessageBuilder appendParameter(String name, float value);

    MessageBuilder appendParameter(String name, int value);

    MessageBuilder appendParameter(String name, long value);

    MessageBuilder appendParameter(String name, Object value);

    <T> MessageBuilder appendParameter(String name, T[] values);

    <T> MessageBuilder appendParameter(String name, Collection<T> values);

}
