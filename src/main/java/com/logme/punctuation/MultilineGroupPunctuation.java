package com.logme.punctuation;

public class MultilineGroupPunctuation implements GroupPunctuation {

    private static final int TAB_SIZE = 4;

    private final int indentLength;
    private final String indent;
    private final String openingMark;
    private final String closingMark;

    public MultilineGroupPunctuation(int indentLength) {
        this.indentLength = indentLength;
        int reducedIndentLength = indentLength > 0 ? indentLength - 1 : 0;

        String reducedIndent;
        if (indentLength <= 0) {
            indent = ""; // todo: возможно, чтобы было более очевидно, если < 0, то null
            reducedIndent = "";
        } else {
            indent = buildIndentString(TAB_SIZE * indentLength);
            reducedIndent = buildIndentString(TAB_SIZE * reducedIndentLength);
        }

        openingMark = PunctuationMark.OPENING_BRACE.value() + System.lineSeparator() + indent;
        closingMark = System.lineSeparator() + reducedIndent + PunctuationMark.CLOSING_BRACE.value();
    }

    private static String buildIndentString(int indent) {
        StringBuilder indentBuilder = new StringBuilder();
        int count = indent;
        while (count > 0) {
            indentBuilder.append(PunctuationMark.SPACE.value());
            count--;
        }
        return indentBuilder.toString();
    }

    @Override
    public String getOpeningMark() {
        return openingMark;
    }

    @Override
    public String getDelimiter() {
        return PunctuationMark.COMMA.value();
    }

    @Override
    public String getIndent() {
        return System.lineSeparator() + indent;
    }

    @Override
    public String getClosingMark() {
        return closingMark;
    }

    int getIndentLength() {
        return indentLength;
    }

}
