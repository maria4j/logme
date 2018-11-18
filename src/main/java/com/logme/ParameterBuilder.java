package com.logme;

import java.util.Collection;

public interface ParameterBuilder {

    int getIndent();

    boolean hasParameters();

    ParameterBuilder appendParameter(String name, boolean value);

    ParameterBuilder appendParameter(String name, byte value);

    ParameterBuilder appendParameter(String name, char value);

    ParameterBuilder appendParameter(String name, double value);

    ParameterBuilder appendParameter(String name, float value);

    ParameterBuilder appendParameter(String name, int value);

    ParameterBuilder appendParameter(String name, long value);

    ParameterBuilder appendParameter(String name, String value);

    <T> ParameterBuilder appendParameter(String name, T[] values);

    <T> ParameterBuilder appendParameter(String name, Collection<T> values);

}
