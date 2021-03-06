package csg.swing;

import javax.swing.*;

public class CsGComboBox<E> extends JComboBox<E> {
    public CsGComboBox(Enum<?> name) {
        super();
        setName(name.name());
    }

    public CsGComboBox(Enum<?> name, E[] items) {
        super(items);
        setName(name.name());
    }

    public void reset(Iterable<E> items) {
        removeAllItems();
        items.forEach(this::addItem);
        setSelectedIndex(getItemCount() - 1);
    }
}
