package com.epam.compositechain.logic.calculator.expression;

import com.epam.compositechain.logic.calculator.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TerminalExpressionPlus extends AbstractMathExpression {
    private static final Logger LOGGER = LogManager.getLogger(TerminalExpressionPlus.class);

    @Override
    public void interpret(Context context) {
        LOGGER.info("Interpret plus.");
        double first = context.popValue();
        double second = context.popValue();
        double result = first + second;
        context.pushValue(result);
    }
}