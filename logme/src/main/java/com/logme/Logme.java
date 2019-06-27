package com.logme;

/**
 * An entry point of Logme.
 * <p>
 * Start creating Logme messages by using {@code message}-methods.
 */
public final class Logme {

    private Logme() {
    }

    /**
     * Returns an empty message builder.
     */
    public static Message message() {
        return new Message();
    }

    /**
     * Returns a message builder initialized to the contents of the specified string.
     * 
     * @param text the initial contents of the message.
     */
    public static Message message(String text) {
        return new Message(text);
    }

}
