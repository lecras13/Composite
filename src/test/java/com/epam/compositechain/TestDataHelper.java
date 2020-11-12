package com.epam.compositechain;

import com.epam.compositechain.model.Component;
import com.epam.compositechain.model.Composite;
import com.epam.compositechain.model.Leaf;
import com.epam.compositechain.model.LeafType;

import java.util.Arrays;

public class TestDataHelper {

    private static final Leaf FIRST_SENTENCE_FIRST_PARAGRAPH_FIRST = new Leaf("It ", LeafType.WORD);
    private static final Leaf SECOND_SENTENCE_FIRST_PARAGRAPH_FIRST = new Leaf("[ 1 6 + 6 * ] ", LeafType.EXPRESSION);
    private static final Leaf THIRD_SENTENCE_FIRST_PARAGRAPH_FIRST = new Leaf("has. ", LeafType.WORD);
    private static final Leaf FIRST_SENTENCE_FIRST_PARAGRAPH_SECOND = new Leaf("PageMaker ", LeafType.WORD);
    private static final Leaf SECOND_SENTENCE_FIRST_PARAGRAPH_SECOND = new Leaf("Ipsum. ", LeafType.WORD);
    private static final Leaf FIRST_SENTENCE_FIRST_PARAGRAPH_THIRD = new Leaf("It ", LeafType.WORD);
    private static final Leaf SECOND_SENTENCE_FIRST_PARAGRAPH_THIRD = new Leaf("[ 6 2 - 5 * ] ", LeafType.EXPRESSION);
    private static final Leaf THIRD_SENTENCE_FIRST_PARAGRAPH_THIRD = new Leaf("has. ", LeafType.WORD);
    private static final Leaf THIRD_SENTENCE_SECOND_PARAGRAPH_THIRD = new Leaf("Bye. ", LeafType.WORD);

    private static final Component FIRST_SENTENCE = new Composite(Arrays.asList(
            FIRST_SENTENCE_FIRST_PARAGRAPH_FIRST, SECOND_SENTENCE_FIRST_PARAGRAPH_FIRST,
            THIRD_SENTENCE_FIRST_PARAGRAPH_FIRST));
    private static final Component SECOND_SENTENCE = new Composite(Arrays.asList(
            FIRST_SENTENCE_FIRST_PARAGRAPH_SECOND, SECOND_SENTENCE_FIRST_PARAGRAPH_SECOND));
    private static final Component THIRD_SENTENCE = new Composite(Arrays.asList(
            FIRST_SENTENCE_FIRST_PARAGRAPH_THIRD, SECOND_SENTENCE_FIRST_PARAGRAPH_THIRD,
            THIRD_SENTENCE_FIRST_PARAGRAPH_THIRD));
    private static final Component FOURTH_SENTENCE = new Composite(Arrays.asList(
            THIRD_SENTENCE_SECOND_PARAGRAPH_THIRD));

    private static final Component FIRST_PARAGRAPH = new Composite(Arrays.asList(FIRST_SENTENCE));
    private static final Component SECOND_PARAGRAPH = new Composite(Arrays.asList(SECOND_SENTENCE));
    private static final Component THIRD_PARAGRAPH = new Composite(Arrays.asList(THIRD_SENTENCE, FOURTH_SENTENCE));

    private static final Component TEXT = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH, THIRD_PARAGRAPH));
    private static final Component TEXT_SORT_BY_COUNT_SENTENCE = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH, THIRD_PARAGRAPH));
    private static final Component TEXT_SORT_BY_LEXEME_SENTENCE = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH, THIRD_PARAGRAPH));

    public static Component getText(){
        return TEXT;
    }

    public static Component getTextAfterSortByCountSentence(){
        return TEXT_SORT_BY_COUNT_SENTENCE;
    }

    public static Component getTextAfterSortSentenceByLengthOfLexeme(){
        return TEXT_SORT_BY_LEXEME_SENTENCE;
    }

    public static Component getFirstParagraph(){
        return FIRST_PARAGRAPH;
    }

    public static Component getSecondParagraph(){
        return SECOND_PARAGRAPH;
    }

    public static Component getThirdParagraph(){
        return THIRD_PARAGRAPH;
    }

    public static Component getFirstSentence(){
        return FIRST_SENTENCE;
    }

    public static Component getThirdSentence(){
        return THIRD_SENTENCE;
    }

    public static Component getFourthSentence(){
        return FOURTH_SENTENCE;
    }
}
