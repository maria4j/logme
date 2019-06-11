package com.logme.punctuation;

/**
 * Describes punctuation rule for a multiline group of items.
 * <p>
 * Each item is separated by comma and is placed on a separate 
 * line with the specified indent.
 * <p>
 * Indent level must be provided via constructor. The result indent 
 * is calculated as indent level multiplied by a number of indent 
 * characters for single level. By default single level indent 
 * corresponds to 4 spaces.
 * <p>
 * Example:
 * <pre>{@code Starts with opening bracket -> {
 *     a,
 *     b,
 *     c
 * } <- Ends with closing bracket}
 * </pre>
 */
public class MultilineGroupPunctuation implements GroupPunctuation {

    private static final int TAB_SIZE = 4;
    private static final String TAB_CHAR = PunctuationMark.SPACE.value();

    private final GroupPunctuation groupPunctuation;

    private final int indentLevel;
    private final String indent;
    private final String openingMark;
    private final String closingMark;

    public MultilineGroupPunctuation(int indentLevel, GroupPunctuation groupPunctuation) {
        this.indentLevel = indentLevel;
        this.groupPunctuation = groupPunctuation;

        String indent = buildIndent(indentLevel);
        this.openingMark = groupPunctuation.getOpeningMark() + System.lineSeparator() + indent;
        this.indent = System.lineSeparator() + indent;

        String reducedIndent = buildIndent(indentLevel - 1);
        this.closingMark = System.lineSeparator() + reducedIndent + groupPunctuation.getClosingMark();
    }

    private static String buildIndent(int level) {
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

    @Override
    public String getOpeningMark() {
        return openingMark;
    }

    @Override
    public String getDelimiter() {
        return groupPunctuation.getDelimiter();
    }

    @Override
    public String getIndent() {
        return indent;
    }

    @Override
    public String getClosingMark() {
        return closingMark;
    }

    public int getIndentLevel() {
        return indentLevel;
    }

}
