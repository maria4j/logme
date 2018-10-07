package com.logme;

/**
 * @author Maria
 * @since 04.08.2018
 */
public interface LogMessage {
    LogMessage appendText(String text);

    LogMessage appendMessage(LogMessage message);

    LogMessage setParameters(LogParameters parameters);
}
