package com.epam.compositechain.data.parser;

import com.epam.compositechain.model.Component;
import com.epam.compositechain.model.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements Parser {
    private Parser accessor;

    public AbstractParser() {
    }

    public AbstractParser(Parser accessor) {
        this.accessor = accessor;
    }

    public abstract String getRegexExpression();

    @Override
    public Component parse(String text) {
        Pattern pattern = Pattern.compile(getRegexExpression());
        Matcher matcher = pattern.matcher(text);
        List<Component> children = new ArrayList<>();
        while (matcher.find()) {
            String value = matcher.group();
            process(children, value);
        }
        return new Composite(children);
    }

    protected void process(List<Component> children, String value) {
        Component child = accessor.parse(value);
        children.add(child);
    }
}
