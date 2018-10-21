package com.logme;

import java.util.Collection;

public interface MessageBuilder {

    // Вообще относится к параметрам
    int getNumberOfIndents();

    boolean hasParameters();

    MessageBuilder appendText(String text);

    MessageBuilder appendParameter(String name, String value);

    MessageBuilder appendParameter(String name, String[] values);

    MessageBuilder appendParameter(String name, Collection<ParameterBuilder> values);

}
