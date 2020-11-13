package com.epam.compositechain.data.parser;

import com.epam.compositechain.TestDataHelper;
import com.epam.compositechain.model.Component;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class TextParserTest {
    private static final Component PARAGRAPH_FIRST = TestDataHelper.getFirstParagraph();
    private static final Component PARAGRAPH_SECOND = TestDataHelper.getSecondParagraph();
    private static final Component PARAGRAPH_THIRD = TestDataHelper.getThirdParagraph();
    private static final Component TEXT = TestDataHelper.getText();
    private static final Component PARAGRAPH_ANSWER = TestDataHelper.getParagraphForThenAnswerText();
    private static final String SENTENCE_TO_PARSE = "It [ 1 6 + 6 * ] has. \n" +
            "PageMaker Ipsum. \n" +
            "It [ 6 2 - 5 * ] has. Bye. \n";


   /* @Test
    public void testParseTextToParagraphsCompositeIsCorrect() {
        AbstractParser paragraph = Mockito.mock(ParagraphParser.class);
        when(paragraph.parse(anyString())).thenReturn(PARAGRAPH_FIRST).thenReturn(PARAGRAPH_SECOND).thenReturn(PARAGRAPH_THIRD);
        Parser textParser = new TextParser(paragraph);

        Component actual = textParser.parse(SENTENCE_TO_PARSE);

        Assert.assertEquals(TEXT, actual);
    }*/

    @Test
    public void testParseTextToParagraphsCompositeIsCorrect() {
        AbstractParser paragraph = Mockito.mock(ParagraphParser.class);
        Parser textParser = new TextParser(paragraph);
        when(paragraph.parse(anyString())).thenAnswer(invocation -> Leaf.leafWord(invocation.getArgument(0)));

        Component actualComponent = textParser.parse(SENTENCE_TO_PARSE);

        Assert.assertEquals(PARAGRAPH_ANSWER, actualComponent);
    }
}
