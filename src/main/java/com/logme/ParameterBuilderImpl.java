package com.logme;

import com.logme.punctuation.GroupPunctuation;
import com.logme.punctuation.ItemPunctuation;

import java.util.Collection;

/**
 * @author Maria
 * @since 02.08.2018
 */
class ParameterBuilderImpl implements ParameterBuilder {

    private final StringBuilder stringBuilder = new StringBuilder();
    private final GroupPunctuation groupPunctuation;
    private final ItemPunctuation itemPunctuation;

    ParameterBuilderImpl(GroupPunctuation groupPunctuation, ItemPunctuation itemPunctuation) {
        this.groupPunctuation = groupPunctuation;
        this.itemPunctuation = itemPunctuation;
    }

    @Override
    public boolean hasParameters() {
        return stringBuilder.length() > 0;
    }

    @Override
    public GroupPunctuation getGroupPunctuation() {
        return groupPunctuation;
    }

    @Override
    public ParameterBuilder appendParameter(String name, boolean value) {
        appendDelimiter();
        stringBuilder.append(name).append(itemPunctuation.getKeyValueDelimiter()).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, byte value) {
        appendDelimiter();
        stringBuilder.append(name).append(itemPunctuation.getKeyValueDelimiter()).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, char value) {
        appendDelimiter();
        stringBuilder.append(name).append(itemPunctuation.getKeyValueDelimiter()).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, double value) {
        appendDelimiter();
        stringBuilder.append(name).append(itemPunctuation.getKeyValueDelimiter()).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, float value) {
        appendDelimiter();
        stringBuilder.append(name).append(itemPunctuation.getKeyValueDelimiter()).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, int value) {
        appendDelimiter();
        stringBuilder.append(name).append(itemPunctuation.getKeyValueDelimiter()).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, long value) {
        appendDelimiter();
        stringBuilder.append(name).append(itemPunctuation.getKeyValueDelimiter()).append(value);
        return this;
    }

    @Override
    public ParameterBuilder appendParameter(String name, Object value) {
        appendDelimiter();
        stringBuilder.append(name).append(itemPunctuation.getKeyValueDelimiter()).append(value);
        return this;
    }

    @Override
    public <T> ParameterBuilder appendParameter(String name, T[] values) {
        appendDelimiter();

        stringBuilder.append(name).append(itemPunctuation.getKeyValueDelimiter()).append(itemPunctuation.getValueGroupPunctuation().getOpeningMark());

        boolean empty = true;
        for (T value : values) {
            if (empty) {
                empty = false;
            } else {
                stringBuilder.append(itemPunctuation.getValueGroupPunctuation().getDelimiter())
                             .append(itemPunctuation.getValueGroupPunctuation().getIndent());
            }

            stringBuilder.append(value.toString());
        }

        stringBuilder.append(itemPunctuation.getValueGroupPunctuation().getClosingMark());

        return this;
    }

    @Override
    public <T> ParameterBuilder appendParameter(String name, Collection<T> values) {
        appendDelimiter();

        stringBuilder.append(name).append(itemPunctuation.getKeyValueDelimiter()).append(itemPunctuation.getValueGroupPunctuation().getOpeningMark());

        boolean empty = true;
        for (Object value : values) {
            if (empty) {
                empty = false;
            } else {
                stringBuilder.append(itemPunctuation.getValueGroupPunctuation().getDelimiter())
                             .append(itemPunctuation.getValueGroupPunctuation().getIndent());
            }

            stringBuilder.append(value.toString());
        }

        stringBuilder.append(itemPunctuation.getValueGroupPunctuation().getClosingMark());

        return this;
    }

    private void appendDelimiter() {
        if (hasParameters()) {
            stringBuilder.append(groupPunctuation.getDelimiter()).append(groupPunctuation.getIndent());
        }
    }

    @Override
    public String toString() {
        return groupPunctuation.getOpeningMark() + stringBuilder.toString() + groupPunctuation.getClosingMark();
    }

}
