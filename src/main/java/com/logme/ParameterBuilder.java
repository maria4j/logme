package com.logme;

import java.util.Collection;

public interface ParameterBuilder {

    GroupPunctuation getGroupPunctuation();

    boolean hasParameters();

    // todo: defaultValue appendParameter("name", "value", "<не задано>") -> или условие обработки (функция?) -> Supplier
    // todo: supplier пока что не нужен, пояснить, что multilineSeparator не страшен, т.к. основная часть сообщений в логах - однострочные

    ParameterBuilder appendParameter(String name, boolean value);

    ParameterBuilder appendParameter(String name, byte value);

    ParameterBuilder appendParameter(String name, char value);

    ParameterBuilder appendParameter(String name, double value);

    ParameterBuilder appendParameter(String name, float value);

    ParameterBuilder appendParameter(String name, int value);

    ParameterBuilder appendParameter(String name, long value);

    ParameterBuilder appendParameter(String name, Object value);

    <T> ParameterBuilder appendParameter(String name, T[] values);

    <T> ParameterBuilder appendParameter(String name, Collection<T> values);

}
