package com.epam.compositechain.logic.sorter;

import com.epam.compositechain.TestDataHelper;
import com.epam.compositechain.model.Component;
import com.epam.compositechain.model.LeafException;
import org.junit.Assert;
import org.junit.Test;

public class SorterTest {
    private static final Component TEXT = TestDataHelper.getText();
    private static final Component TEXT_SORT_PARAGRAPH_VALID = TestDataHelper.getTextAfterSortByCountSentence();
    private static final Component TEXT_SORT_LEXEME = TestDataHelper.getTextAfterSortSentenceByLengthOfLexeme();

    @Test
    public void testSortParagraphByCountOfSentenceIsCorrect() throws LeafException {
        Sorter sorter = new Sorter();

        Component actual = sorter.sortParagraphByCountOfSentence(TEXT);

        Assert.assertEquals(TEXT_SORT_PARAGRAPH_VALID, actual);
    }


    @Test
    public void testSortSentenceByLengthOfLexemeIsCorrect() throws LeafException {
        Sorter sorter = new Sorter();

        Component actual = sorter.sortSentenceByLengthOfLexeme(TEXT);

        Assert.assertEquals(TEXT_SORT_LEXEME, actual);
    }
}
