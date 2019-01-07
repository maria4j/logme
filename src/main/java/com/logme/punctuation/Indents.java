package com.logme.punctuation;

class Indents {

    private static final int TAB_SIZE = 4;
    private static final String TAB_CHAR = PunctuationMark.SPACE.value();

    private Indents() {

    }

    static String forLevel(int level) {
        if (level <= 0) {
            return "";
        }

        StringBuilder indentBuilder = new StringBuilder();
        int count = level * TAB_SIZE;
        while (count > 0) {
            indentBuilder.append(TAB_CHAR);
            count--;
        }

        return indentBuilder.toString();
    }

}
