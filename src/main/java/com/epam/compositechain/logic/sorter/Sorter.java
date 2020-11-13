package com.epam.compositechain.logic.sorter;

import com.epam.compositechain.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Sorter {
    private static final Logger LOGGER = LogManager.getLogger(Sorter.class);

    public Component sortParagraphByCountOfSentence(Component component) throws LeafException {
        LOGGER.info("Sort paragraph by count os sentence.");
        Comparator<Component> comp = new ParagraphComparator();
        List<Component> paragraphs = component.getChildren();
        paragraphs.sort(comp);
        return new Composite(paragraphs);
    }

    public Component sortSentenceByLengthOfLexeme(Component component) throws LeafException {
        LOGGER.info("Sort sentence by length of lexeme.");
        Comparator<Component> comp = new LexemeComparator();
        List<Component> paragraphs = component.getChildren();
        for (Component paragraph : paragraphs) {
            for (Component sentence : paragraph.getChildren()) {
                sentence.getChildren().sort(comp);
            }
        }
        return new Composite(paragraphs);
    }


    public class ParagraphComparator implements Comparator<Component> {
        @Override
        public int compare(Component firstComponent, Component secondComponent) {
            try {
                int first = firstComponent.getChildren().size();
                int second = secondComponent.getChildren().size();
                if (first > second) {
                    return 1;
                } else if (first < second) {
                    return -1;
                }
            } catch (LeafException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    public class LexemeComparator implements Comparator<Component> {
        @Override
        public int compare(Component firstLexeme, Component secondLexeme) {
            int first = ((Leaf) firstLexeme).getValue().length();
            int second = ((Leaf) secondLexeme).getValue().length();
            if (first > second) {
                return 1;
            } else if (first < second) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

