package com.logme;

import java.util.Collection;

public interface MessageBuilder {

    int getParametersIndent();

    // todo: delete when changed api to flow builder
    boolean hasParameters();

    MessageBuilder appendText(String text);

    MessageBuilder appendParameter(String name, String value);

    <T> MessageBuilder appendParameter(String name, T[] values);

    <T> MessageBuilder appendParameter(String name, Collection<T> values);

}
