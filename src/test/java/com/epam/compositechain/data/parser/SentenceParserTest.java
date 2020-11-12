package com.epam.compositechain.data.parser;

import com.epam.compositechain.TestDataHelper;
import com.epam.compositechain.model.Component;
import org.junit.Assert;
import org.junit.Test;

public class SentenceParserTest {
    private static final Component SENTENCE = TestDataHelper.getFirstSentence();
    private static final String SENTENCE_TO_PARSE = "It [ 1 6 + 6 * ] has. ";

    @Test
    public void testParseSentenceToLexemeCompositeIsCorrect() {
        Parser sentenceParser = new SentenceParser();

        Component actual = sentenceParser.parse(SENTENCE_TO_PARSE);

        Assert.assertEquals(SENTENCE, actual);
    }
}
