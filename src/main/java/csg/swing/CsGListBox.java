package csg.swing;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JList;

public class CsGListBox<T> extends JList<T> {
    public CsGListBox(Enum<?> name) {
        super();
        setName(name.name());
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public CsGListBox(Enum<?> name, T[] items) {
        super(items);
        setName(name.name());
    }

    public void reset(List<T> items) {
        if (items.size() == 0) {
            setListData(new Vector<>());
        } else {
            removeAll();
            final Class<T> clazz = (Class<T>) items.get(0).getClass();
            final T[] data = (T[]) Array.newInstance(clazz, items.size());
            items.toArray(data);
            setListData(data);
            setSelectedIndex(items.size() - 1);
        }
    }


}
