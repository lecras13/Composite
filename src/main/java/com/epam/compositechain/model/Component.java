package com.epam.compositechain.model;

import java.util.List;

public interface Component {
    List<Component> getChildren() throws LeafException;
}
