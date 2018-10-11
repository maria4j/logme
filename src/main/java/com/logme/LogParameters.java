package com.logme;

import java.util.Collection;

/**
 * @author Maria
 * @since 04.08.2018
 */
public interface LogParameters extends Indentable {

    LogParameters append(String name, String value);

    LogParameters append(String name, String[] values);

    //? LogParameters append(String name, String[] values, boolean multiline, int numberOfIndents);

    LogParameters append(String name, Collection<LogParameters> values);

    //? LogParameters append(String name, Collection<LogParameters> values, boolean multiline, int numberOfIndents);

    boolean isEmpty();
}
