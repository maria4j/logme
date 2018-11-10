package com.logme;

import java.util.Collection;

public interface ParameterBuilder {

    int getIndent();

    boolean hasParameters();

    ParameterBuilder appendParameter(String name, String value);

    <T> ParameterBuilder appendParameter(String name, T[] values);

    <T> ParameterBuilder appendParameter(String name, Collection<T> values);

}
