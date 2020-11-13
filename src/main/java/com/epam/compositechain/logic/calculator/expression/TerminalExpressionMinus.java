package com.epam.compositechain.logic.calculator.expression;

import com.epam.compositechain.logic.calculator.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TerminalExpressionMinus extends AbstractMathExpression {
    private static final Logger LOGGER = LogManager.getLogger(TerminalExpressionMinus.class);

    @Override
    public void interpret(Context context) {
        LOGGER.info("Interpret minus.");
        double first = context.popValue();
        double second = context.popValue();
        double result = first - second;
        context.pushValue(result);
    }
}