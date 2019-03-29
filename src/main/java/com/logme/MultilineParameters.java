package com.logme;

import com.logme.punctuation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Maria
 * @since 02.08.2018
 */
public class MultilineParameters extends Parameters {

    private final MultilineGroupPunctuation multilineValuePunctuation;

    MultilineParameters() {
        this(0);
    }

    MultilineParameters(int baseIndent) {
        super(new MultilineGroupPunctuation(baseIndent + 1, DEFAULT_PUNCTUATION));
        this.multilineValuePunctuation = new MultilineGroupPunctuation(baseIndent + 2, getValuePunctuation());
    }

    public MultilineParameters append(String name, boolean value) {
        super.append(name, value);
        return this;
    }

    public MultilineParameters append(String name, byte value) {
        super.append(name, value);
        return this;
    }

    public MultilineParameters append(String name, char value) {
        super.append(name, value);
        return this;
    }

    public MultilineParameters append(String name, double value) {
        super.append(name, value);
        return this;
    }

    public MultilineParameters append(String name, float value) {
        super.append(name, value);
        return this;
    }

    public MultilineParameters append(String name, int value) {
        super.append(name, value);
        return this;
    }

    public MultilineParameters append(String name, long value) {
        super.append(name, value);
        return this;
    }

    public MultilineParameters append(String name, Object value) {
        super.append(name, value);
        return this;
    }

    public MultilineParameters append(String name, Object value, Object nullDefault) {
        super.append(name, value, nullDefault);
        return this;
    }

    public <V> MultilineParameters append(String name, V[] values) {
        super.append(name, values);
        return this;
    }

    public <V> MultilineParameters append(String name, Collection<V> values) {
        super.append(name, values);
        return this;
    }

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

    // use appendMultilineParameters to append parameters with auto formatting
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

    @Override
    public MultilineParameters appendParameters(String name, Consumer<Parameters> valueConsumer) {
        super.appendParameters(name, valueConsumer);
        return this;
    }

    @Override
    public MultilineParameters appendParameters(String name, Collection<Consumer<Parameters>> valueConsumers) {
        super.appendParameters(name, valueConsumers);
        return this;
    }

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

    public MultilineParameters appendMultilineParameters(String name, Consumer<MultilineParameters> valueConsumer) {
        int baseIndent = ((MultilineGroupPunctuation) getPunctuation()).getIndentLevel();
        MultilineParameters multilineParameters = new MultilineParameters(baseIndent);
        valueConsumer.accept(multilineParameters);
        append(name, multilineParameters);
        return this;
    }

    public MultilineParameters appendMultilineParameters(String name, Collection<Consumer<MultilineParameters>> valueConsumers) {
        appendMultilineParameters(name, valueConsumers, false);
        return this;
    }

    public MultilineParameters appendMultilineParameters(String name, Collection<Consumer<MultilineParameters>> valueConsumers, boolean multilineValue) {
        List<MultilineParameters> values = new ArrayList<>(valueConsumers.size());
        for (Consumer<MultilineParameters> valueConsumer : valueConsumers) {
            // todo: fix cast
            // todo: fix tricky logic
            // todo: check in hierarchy
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
