package com.epam.compositechain.logic;

import com.epam.compositechain.TestDataHelper;
import com.epam.compositechain.model.Component;
import com.epam.compositechain.model.LeafException;

import org.junit.Assert;
import org.junit.Test;

public class TextConstructorTest {
    private static final Component TEXT = TestDataHelper.getText();
    private static final String EXPECTED = "It [ 1 6 + 6 * ] has. \n" +
            "PageMaker Ipsum. \n" +
            "It [ 6 2 - 5 * ] has. Bye. \n";

    @Test
    public void testCreateTextFromCompositeIsCorrect() throws LeafException {
        TextConstructor textConstructor = new TextConstructor();

        String actual = textConstructor.composeTextFromComposite(TEXT);

        Assert.assertEquals(actual, EXPECTED);
    }
}
