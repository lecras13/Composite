package com.epam.compositechain.data.reader;

import org.junit.Assert;
import org.junit.Test;

public class FileDataAcquirerTest {

    private static final String FILE_NAME_VALID = "src/test/java/resources/dataTest.txt";
    private static final String FILE_NAME_INVALID = "src/test/java/resources/datafTest.txt";
    private static final String EXPECTED = "It has survived - not only (five) centuries! " +
            "But also the leap into [ 1 6 + 6 * ] " +
            "electronic typesetting, remaining [ 3 5 / ] essentially [ 6 2 - 5 * ] unchanged." +
            " It was popularised in the with the release of Let ra set sheets containing Lorem.\n";

    @Test
    public void testGetTextFromFileShouldGiveWrightText() throws DataException {
        DataAcquirer dataAcquirer = new FileDataAcquirer();

        String actual = dataAcquirer.getText(FILE_NAME_VALID);

        Assert.assertEquals(EXPECTED, actual);
    }

    @Test(expected = DataException.class)
    public void testGetTextFromFileShouldGiveDataException() throws DataException {
        DataAcquirer dataAcquirer = new FileDataAcquirer();

        String actual = dataAcquirer.getText(FILE_NAME_INVALID);
    }
}
