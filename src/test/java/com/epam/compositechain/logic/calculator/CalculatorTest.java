package com.epam.compositechain.logic.calculator;

import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class CalculatorTest {
    @DataProvider
    public static Object[][] testProviderRightParameters() {
        String a = "[ 5 6 + ] ";
        String b = "[ 7 6 - ] ";
        String c = "[ 5 6 * ] ";
        String d = "[ 8 2 / ] ";
        Number a1 = 11.0;
        Number b1 = -1.0;
        Number c1 = 30.0;
        Number d1 = 0.25;

        return new Object[][]{
                {a, b, c, d, a1, b1, c1, d1}
        };
    }

    @Test
    @UseDataProvider("testProviderRightParameters")
    public void testCalculateIsCorrect(String a, String b, String c, String d, Number a1, Number b1, Number c1, Number d1) {
        List<String> list = Arrays.asList(a, b, c, d);
        List<Number> result = Arrays.asList(a1, b1, c1, d1);
        List<Number> actual = new ArrayList<>();
        Calculator client = new Calculator();

        for (String s : list) {
            Number res = client.calculate(s);
            actual.add(res);
        }

        Assert.assertEquals(result, actual);
    }
}
