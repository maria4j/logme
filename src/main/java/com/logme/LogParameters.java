package com.logme;

import java.util.Collection;

/**
 * @author Maria
 * @since 04.08.2018
 */
public interface LogParameters {

    LogParameters append(String name, String value);

    LogParameters append(String name, String[] values);

    LogParameters append(String name, Collection<LogParameters> values);

    boolean isEmpty();
}
