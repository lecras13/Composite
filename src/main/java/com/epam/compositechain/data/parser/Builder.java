package com.epam.compositechain.data.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Builder {
    private static final Logger LOGGER = LogManager.getLogger(Builder.class);

    public Parser build() {
        LOGGER.info("Composing all parsers to create composite.");
        Parser sentenceParser = new SentenceParser();

        Parser paragraphParser = new ParagraphParser(sentenceParser);

        Parser textParser = new TextParser(paragraphParser);

        return textParser;
    }
}
