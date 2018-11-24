package com.logme.punctuation;

/**
 * Describes indentation style for a multiline group of items formatted in OTBS(1TBS, K&R).
 * <p>
 * Each item is separated by comma and is placed on a separate line with the specified indent.
 * <p>
 * Indent level must be provided via constructor. The result indent is calculated as indent level multiplied by
 * a number of indent characters for single level. By default single level indent corresponds to 4 spaces.
 * <p>
 * Example:
 * <pre>{@code Starts with opening bracket -> {
 *     a,
 *     b,
 *     c
 * } <- Ends with closing bracket}
 * </pre>
 */
public class OtbsIndentationStyle implements IndentationStyle {

    private static final int TAB_SIZE = 4;

    private final int indentLevel;
    private final String indent;
    private final String openingMark;
    private final String closingMark;

    public OtbsIndentationStyle(int indentLevel) {
        this.indentLevel = indentLevel;
        indent = buildIndent(TAB_SIZE * indentLevel);
        openingMark = PunctuationMark.OPENING_CURLY_BRACKET.value() + System.lineSeparator() + indent;

        int reducedIndentLength = indentLevel - 1;
        String reducedIndent = buildIndent(TAB_SIZE * reducedIndentLength);
        closingMark = System.lineSeparator() + reducedIndent + PunctuationMark.CLOSING_CURLY_BRACKET.value();
    }

    private static String buildIndent(int indentLength) {
        if (indentLength <= 0) {
            return "";
        }

        StringBuilder indentBuilder = new StringBuilder();
        int count = indentLength;
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

    int getIndentLevel() {
        return indentLevel;
    }

}
