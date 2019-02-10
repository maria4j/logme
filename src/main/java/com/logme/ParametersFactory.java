package com.logme;

import com.logme.punctuation.CurlyGroupPunctuation;
import com.logme.punctuation.MultilineGroupPunctuation;

class ParametersFactory {

    private ParametersFactory() {
    }

    static Parameters parameters() {
        return new Parameters();
    }

    static Parameters parameters(LogmeStyle style) {
        if (style.equals(LogmeStyle.MULTILINE)) {
            MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(1, CurlyGroupPunctuation.INSTANCE);
            return new Parameters(multilineStyle);
        }

        return new Parameters();
    }

    static Parameters multilineParameters(int indentLevel) {
        MultilineGroupPunctuation multilineStyle = new MultilineGroupPunctuation(indentLevel, CurlyGroupPunctuation.INSTANCE);
        return new Parameters(multilineStyle);
    }

}
