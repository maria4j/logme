package com.logme;

import com.logme.punctuation.IndentationStyle;

import java.util.Collection;

public interface ParameterBuilder {

    IndentationStyle getIndentationStyle();

    ParameterBuilder appendParameter(String name, boolean value);

    ParameterBuilder appendParameter(String name, byte value);

    ParameterBuilder appendParameter(String name, char value);

    ParameterBuilder appendParameter(String name, double value);

    ParameterBuilder appendParameter(String name, float value);

    ParameterBuilder appendParameter(String name, int value);

    ParameterBuilder appendParameter(String name, long value);

    ParameterBuilder appendParameter(String name, Object value);

    ParameterBuilder appendParameter(String name, Object value, Object nullDefault);

    <T> ParameterBuilder appendParameter(String name, T[] values);

    <T> ParameterBuilder appendParameter(String name, Collection<T> values);

}
