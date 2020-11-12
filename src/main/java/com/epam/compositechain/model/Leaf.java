package com.epam.compositechain.model;

import java.util.List;
import java.util.Objects;

public class Leaf implements Component {
    private String value;
    private final LeafType type;


    public Leaf(String value, LeafType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public LeafType getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Leaf leafWord(String value) {
        return new Leaf(value, LeafType.WORD);
    }

    public static Leaf leafExpression(String value) {
        return new Leaf(value, LeafType.EXPRESSION);
    }

    @Override
    public List<Component> getChildren() throws LeafException {
        throw new LeafException("Unsupported operation!This object have not children!");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) object;
        return Objects.equals(value, leaf.value) &&
                type == leaf.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
