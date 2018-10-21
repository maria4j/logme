package com.logme;

import java.util.Collection;

public interface ParameterBuilder {

    // Всё же вынести глобально indent, т.к. он на группу параметров
    // А вложенные можно сразу попробовать ставить на 1 уровень ниже, если baseIndent установлен
    // Возможо, отдельным классом, но тогда будет иерархия большевата, хотя таких параметров обычно немного
    int getNumberOfIndents();

    boolean hasParameters();

    ParameterBuilder appendParameter(String name, String value);

//    ParameterBuilder appendParameter(String name, String value, int indent);

    ParameterBuilder appendParameter(String name, String[] values);

//    ParameterBuilder appendParameter(String name, String[] values, int valueIndent);

    ParameterBuilder appendParameter(String name, Collection<ParameterBuilder> values);

//    ParameterBuilder appendParameter(String name, Collection<ParameterBuilder> values, int valueIndent);

}
