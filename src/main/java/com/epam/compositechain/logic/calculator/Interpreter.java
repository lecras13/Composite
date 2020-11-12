package com.epam.compositechain.logic.calculator;

import com.epam.compositechain.model.Component;
import com.epam.compositechain.model.Leaf;
import com.epam.compositechain.model.LeafException;
import com.epam.compositechain.model.LeafType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Interpreter {
    private static final Logger LOGGER = LogManager.getLogger(Interpreter.class);
    private final Calculator client;

    public Interpreter(Calculator client) {
        this.client = client;
    }

    public Component changeExpressionToResult(Component component) throws LeafException {
        LOGGER.info("Changing expression in component to result expression.");
        for (Component paragraph : component.getChildren()) {
            for (Component sentence : paragraph.getChildren()) {
                for (Component leaf : sentence.getChildren()) {
                    if (((Leaf) leaf).getType() == LeafType.EXPRESSION) {
                        Number result = client.calculate(((Leaf) leaf).getValue());
                        ((Leaf) leaf).setValue(String.format("%s ", result.toString()));
                    }
                }
            }
        }
        return component;
    }
}
