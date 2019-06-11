package com.logme;

import com.logme.punctuation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * A builder for a single-line group of parameters.
 * <p>
 * A parameter is a name-value pair. Each parameter in a group is 
 * separated from others due to default or specified punctuation rule. 
 * <p>
 * This class provides API similar to {@link StringBuilder}. 
 * Under cover it actually uses {@code StringBuilder} to build 
 * a group of parameters. 
 * <p>
 * The principal operations on the {@code Parameters} are the 
 * {@code append} methods, which are overloaded so as to accept 
 * value of any type. Each effectively converts a given datum to 
 * a string and then appends that string to the builder. 
 * The {@code append} method always adds these characters 
 * at the end of the builder.
 * <p>
 * Other {@code Parameters} can be appended as parameter value 
 * by the {@code appendParameters} methods.
 * 
 * @see Message
 * @see MultilineParameters
 * @see GroupPunctuation
 */
public class Parameters {

    /**
     * The delimiter between a parameter name and value.
     */
    static final String NAME_VALUE_DELIMITER = PunctuationMark.EQUAL_SIGN.value();

    /**
     * The default punctuation rule for this group of parameters.
     */
    static final GroupPunctuation DEFAULT_PUNCTUATION = CurlyGroupPunctuation.INSTANCE;

    /**
     * The default punctuation rule for a parameter value represented by an array or a collection.
     */
    static final GroupPunctuation DEFAULT_VALUE_PUNCTUATION = SquareGroupPunctuation.INSTANCE;

    /**
     * The builder that appends items to this group of parameters.
     */
    private final StringBuilder builder = new StringBuilder();

    /**
     * The punctuation rule for this group of parameters.
     */
    private final GroupPunctuation punctuation;

    /**
     * The punctuation rule for a parameter value 
     * represented by an array or a collection of values.
     */
    private final GroupPunctuation valuePunctuation;

    /**
     * Constructs an empty parameter builder.
     */
    Parameters() {
        this(DEFAULT_PUNCTUATION);
    }

    /**
     * Constructs an empty parameter builder initialized with the 
     * specified indentation style to apply for each parameter.
     *
     * @param punctuation the indentation style for each parameter.
     */
    // todo: remove?
    protected Parameters(GroupPunctuation punctuation) {
        this.punctuation = punctuation;
        this.valuePunctuation = DEFAULT_VALUE_PUNCTUATION;
    }

    /**
     * Returns the punctuation rule for this group of parameters.
     */
    GroupPunctuation getPunctuation() {
        return punctuation;
    }

    /**
     * Returns the punctuation rule for a parameter value 
     * represented by an array or a collection.
     */
    GroupPunctuation getValuePunctuation() {
        return valuePunctuation;
    }

    /**
     * Returns the builder that appends items to these parameters.
     */
    protected StringBuilder getBuilder() {
        return builder;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the {@code boolean} as value 
     * to these parameters.
     * 
     * @param name the {@code String} to append as parameter name.
     * @param value the {@code boolean} to append as parameter value.
     * @return a reference to this object.
     */
    public Parameters append(String name, boolean value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the {@code byte} as value 
     * to these parameters.
     *
     * @param name the {@code String} to append as parameter name.
     * @param value the {@code byte} to append as parameter value.
     * @return a reference to this object.
     */
    public Parameters append(String name, byte value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the {@code char} as value 
     * to these parameters.
     *
     * @param name the {@code String} to append as parameter name.
     * @param value the {@code char} to append as parameter value.
     * @return a reference to this object.
     */
    public Parameters append(String name, char value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the {@code double} as value 
     * to these parameters.
     *
     * @param name the {@code String} to append as parameter name.
     * @param value the {@code double} to append as parameter value.
     * @return a reference to this object.
     */
    public Parameters append(String name, double value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the {@code float} as value 
     * to these parameters.
     *
     * @param name the {@code String} to append as parameter name.
     * @param value the {@code float} to append as parameter value.
     * @return a reference to this object.
     */
    public Parameters append(String name, float value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the {@code int} as value 
     * to these parameters.
     *
     * @param name the {@code String} to append as parameter name.
     * @param value the {@code int} to append as parameter value.
     * @return a reference to this object.
     */
    public Parameters append(String name, int value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the {@code long} as value 
     * to these parameters.
     *
     * @param name the {@code String} to append as parameter name.
     * @param value the {@code long} to append as parameter value.
     * @return a reference to this object.
     */
    public Parameters append(String name, long value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the {@code Object} as value 
     * to these parameters.
     *
     * @param name the {@code String} to append as parameter name.
     * @param value the {@code Object} to append as parameter value.
     * @return a reference to this object.
     */
    public Parameters append(String name, Object value) {
        appendDelimiter();
        builder.append(name).append(NAME_VALUE_DELIMITER).append(value);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the first {@code Object} as value 
     * if it is not null and the string representation of the second {@code Object} 
     * otherwise.
     * 
     * @param name the {@code String} to append as parameter name.
     * @param value the {@code Object} to append as parameter if not null.
     * @param nullDefault the {@code Object} to append as parameter value 
     *                    if the first {@code Object} is {@code null}.
     * @return a reference to this object.
     */
    public Parameters append(String name, Object value, Object nullDefault) {
        appendDelimiter();
        final Object appendingValue = value != null ? value : nullDefault;
        builder.append(name).append(NAME_VALUE_DELIMITER).append(appendingValue);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the array of values with type {@code V} as value.
     * <p>
     * The array is converted to a string due to the punctuation rule for a parameter value.
     * <p>
     * To pass an array of {@code Parameters} 
     * use {@link #appendParameters(String, Collection)} method.  
     * 
     * @param name the {@code String} to append as parameter name.
     * @param values the array of values with type {@code V} to append as parameter value.
     * @param <V> the type of the value in the array.
     * @return a reference to this object.
     */
    public <V> Parameters append(String name, V[] values) {
        appendDelimiter();

        builder.append(name).append(NAME_VALUE_DELIMITER).append(valuePunctuation.getOpeningMark());

        boolean empty = true;
        for (V value : values) {
            if (empty) {
                empty = false;
            } else {
                builder.append(valuePunctuation.getDelimiter()).append(valuePunctuation.getIndent());
            }

            builder.append(value.toString());
        }

        builder.append(valuePunctuation.getClosingMark());

        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the collection of values with type {@code V} as value.
     * <p>
     * The collection is converted to a string due to the punctuation rule for a parameter value.
     * <p>
     * To pass a collection of {@code Parameters} 
     * use {@link #appendParameters(String, Collection)} method.  
     *
     * @param name the {@code String} to append as parameter name.
     * @param values the collection of values with type {@code V} to append as parameter value.
     * @param <V> the type of the value in the array.
     * @return a reference to this object.
     */
    public <V> Parameters append(String name, Collection<V> values) {
        appendDelimiter();

        builder.append(name).append(NAME_VALUE_DELIMITER).append(valuePunctuation.getOpeningMark());

        boolean empty = true;
        for (V value : values) {
            if (empty) {
                empty = false;
            } else {
                builder.append(valuePunctuation.getDelimiter()).append(valuePunctuation.getIndent());
            }

            builder.append(value.toString());
        }

        builder.append(valuePunctuation.getClosingMark());

        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the {@code Consumer<Parameters>} as value.
     * <p>
     * The nested {@code Parameters} are properly initialized by 
     * these {@code Parameters} due to punctuation rule and returned to the caller.
     * 
     * @param name the {@code String} to append as parameter name.
     * @param valueConsumer the {@code Consumer<Parameters>} to append as parameter value. 
     * @return a reference to this object.
     */
    public Parameters appendParameters(String name, Consumer<Parameters> valueConsumer) {
        Parameters parameters = new Parameters();
        valueConsumer.accept(parameters);
        append(name, parameters);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the collection of {@code Consumer<Parameters>} as value.
     * <p>
     * Each {@code Parameters} in the collection are properly initialized by 
     * these {@code Parameters} due to punctuation rule and returned to the caller.
     * 
     * @param name the {@code String} to append as parameter name.
     * @param valueConsumers the collection of {@code Consumer<Parameters>} to append as parameter value.
     * @return a reference to this object.
     */
    public Parameters appendParameters(String name, Collection<Consumer<Parameters>> valueConsumers) {
        List<Parameters> values = new ArrayList<>(valueConsumers.size());

        for (Consumer<Parameters> valueConsumer : valueConsumers) {
            Parameters parameters = new Parameters();
            valueConsumer.accept(parameters);
            values.add(parameters);
        }

        append(name, values);
        return this;
    }

    /**
     * Appends the delimiter after the last parameter in this group due to the punctuation rule.
     */
    protected void appendDelimiter() {
        if (builder.length() > 0) {
            builder.append(punctuation.getDelimiter()).append(punctuation.getIndent());
        }
    }

    /**
     * Returns a string representation of this group of parameters formatted due to the punctuation rule.
     */
    @Override
    public String toString() {
        return punctuation.getOpeningMark() + builder.toString() + punctuation.getClosingMark();
    }

}
