package com.epam.compositechain.model;

import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private final List<Component> components;

    public Composite(List<Component> components) {
        this.components = components;
    }

    @Override
    public List<Component> getChildren() {
        return components;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Composite composite = (Composite) object;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "components=" + components +
                '}';
    }
}
