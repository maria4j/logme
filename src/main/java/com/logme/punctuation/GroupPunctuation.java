package com.logme.punctuation;

/**
 * Describes punctuation rule for a group of items to convey text structure.
 * <p>
 * design notes: delimiter and indent are separated because it allows to
 * create one multiline wrapper instead of many for each group punctuation.
 *
 * @see SquareGroupPunctuation
 * @see CurlyGroupPunctuation
 * @see MultilineGroupPunctuation
 */
public interface GroupPunctuation {

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
