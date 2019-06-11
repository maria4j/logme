package com.logme;

import com.logme.punctuation.PunctuationMark;

import java.util.function.Consumer;

/**
 * A message builder.
 * <p>
 * This class provides API similar to {@link StringBuilder}. 
 * Under cover it actually uses {@code StringBuilder} to build messages.
 * <p>
 * Every message are usually contains some text and parameters. 
 * The principal operation on the {@code Message} is the 
 * {@code append} method, which appends the specified text to the message.
 * <p>
 * There are two types of parameters: single-line and multiline. 
 * The first type is the most common and the most lightweight. 
 * It can be appended by the {@code appendParameters} method. 
 * If parameters don't fit in one line or are hardly readable 
 * they can be represented in a more structured way, where every parameter 
 * will be placed on a new line. Multiline parameters can be appended to 
 * the message by the {@code appendMultilineParameters} method.
 * <p>
 * Sometimes it's useful to tag messages belongs to the one context, e.g. 
 * logged by one thread. For these purposes use the {@code appendTag} method. 
 * Although every tag is enclosed with brackets it is recommended to 
 * append them at the beginning of the message building. 
 * 
 * @see Parameters
 * @see MultilineParameters
 */
public class Message {

    /**
     * The builder that appends text to this message.
     */
    private final StringBuilder builder;

    /**
     * Constructs an empty message builder.
     */
    Message() {
        this.builder = new StringBuilder();
    }

    /**
     * Constructs a message builder initialized to the contents of the specified string.
     * 
     * @param text the initial contents of the message.
     */
    Message(String text) {
        this.builder = new StringBuilder(text);
    }

    /**
     * Appends the specified {@code String} to this message as tag.
     * <p>
     * Tag is a value enclosed in brackets. It's intended to use as repeatable identifiers in log messages. 
     * A common example is a thread number (e.g. "[thread-0]").
     * 
     * @param value the {@code String} to append as tag.
     * @return a reference to this object.
     */
    public Message appendTag(String value) {
        builder.append(PunctuationMark.OPENING_SQUARE_BRACKET.value())
               .append(value)
               .append(PunctuationMark.CLOSING_SQUARE_BRACKET.value());
        return this;
    }

    /**
     * Appends the specified {@code String} to this message as is.
     * 
     * @param text the {@code String} to append.
     * @return a reference to this object.
     */
    public Message append(String text) {
        builder.append(text);
        return this;
    }

    /**
     * Appends the {@code Parameters} built by the specified {@code Consumer} to this message.
     * <p>
     * It creates a {@link Parameters} builder and returned it to the {@code Consumer}. The result built by 
     * {@code Parameters} will be appended as a {@code String} to this message.
     * 
     * @param consumer the {@code Consumer<Parameters>} to append.
     * @return a reference to this object.
     */
    public Message appendParameters(Consumer<Parameters> consumer) {
        Parameters parameters = new Parameters();
        consumer.accept(parameters);
        builder.append(parameters.toString());
        return this;
    }

    /**
     * Appends the {@code MultilineParameters} built by the specified {@code Consumer} to this message.
     * <p>
     * It creates a {@link MultilineParameters} builder and returned it to the {@code Consumer}. The result built by 
     * {@code MultilineParameters} will be appended as a {@code String} 
     * to this message.
     * 
     * @param consumer the {@code Consumer<MultilineParameters>} to append.
     * @return a reference to this object.
     */
    public Message appendMultilineParameters(Consumer<MultilineParameters> consumer) {
        MultilineParameters multilineParameters = new MultilineParameters();
        consumer.accept(multilineParameters);
        builder.append(multilineParameters.toString());
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }

}
