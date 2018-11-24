package com.logme;

import com.logme.punctuation.IndentationStyle;

interface ParameterBuilderFactory {

    IndentationStyle getIndentationStyle();

    ParameterBuilder newParameterBuilder();

}
