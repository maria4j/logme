package com.logme;

import java.util.Collection;

public interface ParameterBuilder {

    int getIndent();

    boolean hasParameters();

    ParameterBuilder appendParameter(String name, String value);

    ParameterBuilder appendParameter(String name, String[] values);

    ParameterBuilder appendParameter(String name, Collection<ParameterBuilder> values);

}
