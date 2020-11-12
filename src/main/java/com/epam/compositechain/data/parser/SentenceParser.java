package com.epam.compositechain.data.parser;

import com.epam.compositechain.model.Component;
import com.epam.compositechain.model.Leaf;

import java.util.List;

public class SentenceParser extends AbstractParser {

    private static final String PATTERN_TO_LEXEME = "(\\[.*\\]\\s{1})|([^\\s]+\\s*)";

    public SentenceParser() {
    }

    @Override
    public String getRegexExpression() {
        return PATTERN_TO_LEXEME;
    }

    @Override
    protected void process(List<Component> children, String lexeme) {
        if (checkMathExpression(lexeme)) {
            children.add(Leaf.leafExpression(lexeme));
        } else {
            children.add(Leaf.leafWord(lexeme));
        }
    }

    protected boolean checkMathExpression(String lexeme) {
        return (lexeme.charAt(0) == '[');
    }
}
