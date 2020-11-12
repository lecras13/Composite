package com.epam.compositechain.logic.calculator;

import com.epam.compositechain.logic.calculator.expression.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private static final Logger LOGGER = LogManager.getLogger(Calculator.class);
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String REGEX_SPLIT = "\\p{Blank}+";
    private ArrayList<AbstractMathExpression> listExpression = new ArrayList<>();

    private void parse(String expression) {
        LOGGER.info("Parsing expression...");
        for (String lexeme : expression.split(REGEX_SPLIT)) {
            if (lexeme.isEmpty()) {
                continue;
            }
            String value = String.valueOf(lexeme.charAt(0));
            switch (value) {
                case PLUS:
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                case MINUS:
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                case MULTIPLY:
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case DIVIDE:
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        listExpression.add(new NonTerminalExpressionNumber(scan.nextInt()));
                    }
            }
        }
    }

    public Number calculate(String expression) {
        LOGGER.info("Calculating expression...");
        parse(expression);
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}
