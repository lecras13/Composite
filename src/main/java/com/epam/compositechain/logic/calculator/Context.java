package com.epam.compositechain.logic.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;

public class Context {
    private static final Logger LOGGER = LogManager.getLogger(Context.class);
    private ArrayDeque<Double> contextValues = new ArrayDeque<>();

    public Double popValue() {
        LOGGER.info("Pop value expression.");
        return contextValues.pop();
    }

    public void pushValue(Double value) {
        LOGGER.info("Push value expression.");
        this.contextValues.push(value);
    }
}
