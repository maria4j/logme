package com.logme;

import java.util.Collection;

/**
 * @author Maria
 * @since 04.08.2018
 */
public interface LogMessage {
    LogMessage appendText(String text);

    LogMessage appendMessage(LogMessage message);

    LogMessage appendParameter(String name, String value);

    LogMessage appendParameter(String name, String[] values);

    LogMessage appendParameter(String name, Collection<LogParameters> values);

}
