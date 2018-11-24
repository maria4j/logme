package com.logme;

import com.logme.punctuation.IndentationStyle;

class ParameterBuilderFactoryImpl implements ParameterBuilderFactory {

    static final ParameterBuilderFactory DEFAULT = new ParameterBuilderFactoryImpl();

    private final IndentationStyle indentationStyle;

    private ParameterBuilderFactoryImpl() {
        this.indentationStyle = null;
    }

    ParameterBuilderFactoryImpl(IndentationStyle indentationStyle) {
        this.indentationStyle = indentationStyle;
    }

    @Override
    public IndentationStyle getIndentationStyle() {
        return indentationStyle;
    }

    @Override
    public ParameterBuilder newParameterBuilder() {
        if (indentationStyle == null) {
            return new ParameterBuilderImpl();
        }

        return new ParameterBuilderImpl(indentationStyle);
    }

}
