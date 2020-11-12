package com.epam.compositechain.data.parser;

import com.epam.compositechain.TestDataHelper;
import com.epam.compositechain.model.Component;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ParagraphParserTest {
    private static final Component SENTENCE_FIRST = TestDataHelper.getThirdSentence();
    private static final Component SENTENCE_SECOND = TestDataHelper.getFourthSentence();
    private static final Component SENTENCES = TestDataHelper.getThirdParagraph();
    private static final String SENTENCE_TO_PARSE = "It [ 6 2 - 5 * ] has. Bye. ";

    @Test
    public void testParseTextToParagraphsCompositeIsCorrect() {
        AbstractParser sentence = Mockito.mock(SentenceParser.class);
        when(sentence.parse(anyString())).thenReturn(SENTENCE_FIRST).thenReturn(SENTENCE_SECOND);
        Parser paragraphParser = new ParagraphParser(sentence);

        Component actual = paragraphParser.parse(SENTENCE_TO_PARSE);

        Assert.assertEquals(SENTENCES, actual);
    }
}
