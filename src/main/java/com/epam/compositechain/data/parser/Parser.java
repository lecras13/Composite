package com.epam.compositechain.data.parser;

import com.epam.compositechain.model.Component;

public interface Parser {
    Component parse(String dataComponent);
}
