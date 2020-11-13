package com.epam.compositechain.logic;

import com.epam.compositechain.model.Component;
import com.epam.compositechain.model.Leaf;
import com.epam.compositechain.model.LeafException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextConstructor {
    private static final Logger LOGGER = LogManager.getLogger(TextConstructor.class);

    public String composeTextFromComposite(Component component) throws LeafException {
        LOGGER.info("Composing text from composite file.");
        StringBuilder stringBuilder = new StringBuilder();
        for (Component paragraph : component.getChildren()) {
            for (Component sentence : paragraph.getChildren()) {
                for (Component leaf : sentence.getChildren()) {
                    stringBuilder.append(((Leaf) leaf).getValue());
                }
            }
            stringBuilder.append("\n");
        }
        return String.valueOf(stringBuilder);
    }
}
