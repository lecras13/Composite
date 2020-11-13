package com.epam.compositechain.data.parser;

public class ParagraphParser extends AbstractParser {
    private static final String PATTERN_TO_SENTENCE = ".*?[.!?]";

    public ParagraphParser() {
    }

    public ParagraphParser(Parser accessor) {
        super(accessor);
    }

    @Override
    public String getRegexExpression() {
        return PATTERN_TO_SENTENCE;
    }
}
