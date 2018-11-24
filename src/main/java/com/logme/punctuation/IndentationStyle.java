package com.logme.punctuation;

/**
 * Describes indentation style for a group of items to convey text structure.
 *
 * @see SquareIndentationStyle
 * @see CurlyIndentationStyle
 * @see OtbsIndentationStyle
 */
public interface IndentationStyle {

    /**
     * Returns a mark that should be used for opening a group.
     */
    String getOpeningMark();

    /**
     * Returns a mark that should be used after each item in a group, except the last one.
     */
    String getDelimiter();

    /**
     * Returns an indent that should be used after each delimiter between items.
     */
    String getIndent();

    /**
     * Returns a mark that should be used for closing a group.
     */
    String getClosingMark();

}
