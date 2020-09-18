package csg.swing;

import java.awt.*;
import java.util.Arrays;

public interface CsGLayout extends LayoutManager {
    default void addLayoutComponent(final String name, final Component comp) {
    }

    default void removeLayoutComponent(final Component comp) {
    }

    default Dimension preferredLayoutSize(final Container parent) {
        return null;
    }

    default Dimension minimumLayoutSize(final Container parent) {
        return null;
    }

    default void layoutContainer(final Container parent) {
        Arrays.stream(parent.getComponents()).forEach(component -> component.setBounds(getRectangleForComponentName(component.getName())));
    }

    Rectangle getRectangleForComponentName(String name);
}
