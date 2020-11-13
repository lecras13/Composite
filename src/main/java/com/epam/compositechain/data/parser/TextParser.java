package com.epam.compositechain.data.parser;

public class TextParser extends AbstractParser {
    private static final String PATTERN_TO_PARAGRAPH = "(.*)\\n";

    public TextParser(Parser accessor) {
        super(accessor);
    }

    @Override
    public String getRegexExpression() {
        return PATTERN_TO_PARAGRAPH;
    }
}
