package com.logme;

import com.logme.punctuation.GroupPunctuation;

class ParameterBuilderFactoryImpl implements ParameterBuilderFactory {

    static final ParameterBuilderFactory DEFAULT = new ParameterBuilderFactoryImpl();

    private final GroupPunctuation punctuation;

    private ParameterBuilderFactoryImpl() {
        this.punctuation = null;
    }

    ParameterBuilderFactoryImpl(GroupPunctuation punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public ParameterBuilder newParameterBuilder() {
        if (punctuation == null) {
            return new ParameterBuilderImpl();
        }

        return new ParameterBuilderImpl(punctuation);
    }

}
