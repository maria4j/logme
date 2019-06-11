package com.logme;

import com.logme.punctuation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * A builder for a multiline group of parameters.
 * <p>
 * This class extends {@code Parameters} but place each parameter 
 * in a group on a new line in {@code json}-like format.
 * <p>
 * Other {@code MultilineParameters} can be appended as parameter value 
 * by the {@code appendMultilineParameters} methods.
 * 
 * @see Message
 * @see Parameters
 * @see MultilineGroupPunctuation
 */
public class MultilineParameters extends Parameters {

    /**
     * The punctuation rule for a parameter value represented by 
     * an array or a collection each value of which is placed on 
     * a new line.
     */
    private final MultilineGroupPunctuation multilineValuePunctuation;

    /**
     * Constructs an empty multiline parameter builder.
     */
    MultilineParameters() {
        this(0);
    }

    /**
     * Constructs an empty multiline parameter builder initialized with the
     * specified base indent.
     * 
     * @param baseIndent the base indent for this group of parameters.
     */
    private MultilineParameters(int baseIndent) {
        super(new MultilineGroupPunctuation(baseIndent + 1, DEFAULT_PUNCTUATION));
        this.multilineValuePunctuation = new MultilineGroupPunctuation(baseIndent + 2, getValuePunctuation());
    }

    /**
     * {@inheritDoc}
     * The appended parameter is placed on a new line.
     */
    public MultilineParameters append(String name, boolean value) {
        super.append(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter is placed on a new line.
     */
    public MultilineParameters append(String name, byte value) {
        super.append(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter is placed on a new line.
     */
    public MultilineParameters append(String name, char value) {
        super.append(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter is placed on a new line.
     */
    public MultilineParameters append(String name, double value) {
        super.append(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter is placed on a new line.
     */
    public MultilineParameters append(String name, float value) {
        super.append(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter will be placed on a new line.
     */
    public MultilineParameters append(String name, int value) {
        super.append(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter will be placed on a new line.
     */
    public MultilineParameters append(String name, long value) {
        super.append(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter will be placed on a new line.
     */
    public MultilineParameters append(String name, Object value) {
        super.append(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter will be placed on a new line.
     */
    public MultilineParameters append(String name, Object value, Object nullDefault) {
        super.append(name, value, nullDefault);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter will be placed on a new line.
     */
    public <V> MultilineParameters append(String name, V[] values) {
        super.append(name, values);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter will be placed on a new line.
     */
    public <V> MultilineParameters append(String name, Collection<V> values) {
        super.append(name, values);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the array of values with type {@code V} as value.
     * <p>
     * The appended parameter is placed on a new line.
     * <p>
     * The array is converted to a string due to the punctuation rule for a parameter value. 
     * Each value is placed on a new line if it is specified via {@code multilineValue} flag.
     * <p>
     * To pass an array of {@code Parameters} 
     * use {@link #appendParameters(String, Collection)} method.
     * To pass an array of {@code MultilineParameters}
     * use {@link #appendMultilineParameters(String, Collection)} method.
     *
     * @param name the {@code String} to append as parameter name.
     * @param values the array of values with type {@code V} to append as parameter value.
     * @param <V> the type of the value in the array.
     * @param multilineValue the indicator of whether to place each value on a new line or not.          
     * @return a reference to this object.
     */
    public <V> MultilineParameters append(String name, V[] values, boolean multilineValue) {
        if (!multilineValue) {
            return append(name, values);
        }

        appendDelimiter();

        getBuilder().append(name).append(NAME_VALUE_DELIMITER).append(multilineValuePunctuation.getOpeningMark());

        boolean empty = true;
        for (V value : values) {
            if (empty) {
                empty = false;
            } else {
                getBuilder().append(multilineValuePunctuation.getDelimiter()).append(multilineValuePunctuation.getIndent());
            }

            getBuilder().append(value);
        }

        getBuilder().append(multilineValuePunctuation.getClosingMark());

        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the array of values with type {@code V} as value.
     * <p>
     * The appended parameter is placed on a new line.
     * <p>
     * The array is converted to a string due to the punctuation rule for a parameter value. 
     * Each value is placed on a new line if it is specified via {@code multilineValue} flag.
     * <p>
     * To pass a collection of {@code Parameters}
     * use {@link #appendParameters(String, Collection)} method.
     * To pass a collection of {@code MultilineParameters}
     * use {@link #appendMultilineParameters(String, Collection)} method.
     *
     * @param name the {@code String} to append as parameter name.
     * @param values the collection of values with type {@code V} to append as parameter value.
     * @param <V> the type of the value in the array.
     * @param multilineValue the indicator of whether to place each value on a new line or not.          
     * @return a reference to this object.
     */
    public <V> MultilineParameters append(String name, Collection<V> values, boolean multilineValue) {
        if (!multilineValue) {
            return append(name, values);
        }

        appendDelimiter();

        getBuilder().append(name).append(NAME_VALUE_DELIMITER).append(multilineValuePunctuation.getOpeningMark());

        boolean empty = true;
        for (V value : values) {
            if (empty) {
                empty = false;
            } else {
                getBuilder().append(multilineValuePunctuation.getDelimiter()).append(multilineValuePunctuation.getIndent());
            }

            getBuilder().append(value);
        }

        getBuilder().append(multilineValuePunctuation.getClosingMark());

        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter will be placed on a new line.
     */
    @Override
    public MultilineParameters appendParameters(String name, Consumer<Parameters> valueConsumer) {
        super.appendParameters(name, valueConsumer);
        return this;
    }

    /**
     * {@inheritDoc}
     * The appended parameter will be placed on a new line.
     */
    @Override
    public MultilineParameters appendParameters(String name, Collection<Consumer<Parameters>> valueConsumers) {
        super.appendParameters(name, valueConsumers);
        return this;
    }
    
    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the collection of {@code Consumer<Parameters>} as value.
     * <p>
     * The appended parameter is placed on a new line.
     * <p>
     * Each {@code Parameters} in the collection are properly initialized by 
     * these {@code Parameters} due to punctuation rule and returned to the caller.
     * <p>
     * Each value is placed on a new line if it is specified via {@code multilineValue} flag.
     *
     * @param name the {@code String} to append as parameter name.
     * @param valueConsumers the collection of {@code Consumer<Parameters>} to append as parameter value.
     * @param multilineValue the indicator of whether to place each value on a new line or not
     * @return a reference to this object.
     */
    public MultilineParameters appendParameters(String name, Collection<Consumer<Parameters>> valueConsumers, boolean multilineValue) {
        List<Parameters> values = new ArrayList<>(valueConsumers.size());
        for (Consumer<Parameters> valueConsumer : valueConsumers) {
            Parameters parameters = new Parameters();
            valueConsumer.accept(parameters);
            values.add(parameters);
        }
        append(name, values, multilineValue);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the {@code Consumer<MultilineParameters>} as value.
     * <p>
     * The appended parameter is placed on a new line.
     * <p>
     * The nested {@code MultilineParameters} are properly initialized by 
     * these {@code MultilineParameters} due to punctuation rule and returned to the caller.
     * The indentation level of created parameters is calculated automatically.
     *
     * @param name the {@code String} to append as parameter name.
     * @param valueConsumer the {@code Consumer<MultilineParameters>} to append as parameter value. 
     * @return a reference to this object.
     */
    public MultilineParameters appendMultilineParameters(String name, Consumer<MultilineParameters> valueConsumer) {
        int baseIndent = ((MultilineGroupPunctuation) getPunctuation()).getIndentLevel();
        MultilineParameters multilineParameters = new MultilineParameters(baseIndent);
        valueConsumer.accept(multilineParameters);
        append(name, multilineParameters);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the collection of {@code Consumer<MultilineParameters>} as value.
     * <p>
     * The appended parameter is placed on a new line.
     * <p>
     * Each {@code MultilineParameters} in the collection are properly initialized by 
     * these {@code MultilineParameters} due to punctuation rule and returned to the caller.
     * The indentation level of created parameters is calculated automatically.
     *
     * @param name the {@code String} to append as parameter name.
     * @param valueConsumers the collection of {@code Consumer<MultilineParameters>} to append as parameter value.
     * @return a reference to this object.
     */
    public MultilineParameters appendMultilineParameters(String name, Collection<Consumer<MultilineParameters>> valueConsumers) {
        appendMultilineParameters(name, valueConsumers, false);
        return this;
    }

    /**
     * Appends the parameter with the specified {@code String} as name 
     * and the string representation of the collection of {@code Consumer<MultilineParameters>} as value.
     * <p>
     * The appended parameter is placed on a new line.
     * <p>
     * Each {@code MultilineParameters} in the collection are properly initialized by 
     * these {@code MultilineParameters} due to punctuation rule and returned to the caller.
     * The indentation level of created parameters is calculated automatically.
     * <p>
     * Each value is placed on a new line if it is specified via {@code multilineValue} flag.
     *
     * @param name the {@code String} to append as parameter name.
     * @param valueConsumers the collection of {@code Consumer<MultilineParameters>} to append as parameter value.
     * @param multilineValue the indicator of whether to place each value on a new line or not
     * @return a reference to this object.
     */
    public MultilineParameters appendMultilineParameters(String name, Collection<Consumer<MultilineParameters>> valueConsumers, boolean multilineValue) {
        List<MultilineParameters> values = new ArrayList<>(valueConsumers.size());
        for (Consumer<MultilineParameters> valueConsumer : valueConsumers) {
            int baseIndent = ((MultilineGroupPunctuation) getPunctuation()).getIndentLevel();
            if (multilineValue) {
                baseIndent += 1;    
            }
            MultilineParameters multilineParameters = new MultilineParameters(baseIndent);
            valueConsumer.accept(multilineParameters);
            values.add(multilineParameters);
        }
        append(name, values, multilineValue);
        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
