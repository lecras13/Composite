package com.epam.compositechain.logic.calculator.expression;

import com.epam.compositechain.logic.calculator.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NonTerminalExpressionNumber extends AbstractMathExpression {
    private static final Logger LOGGER = LogManager.getLogger(NonTerminalExpressionNumber.class);
    private double number;

    public NonTerminalExpressionNumber(double number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        LOGGER.info("Interpret number.");
        context.pushValue(number);
    }
}
