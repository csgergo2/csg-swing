package csg.swing;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class CsGListBox<T> extends JScrollPane {

    private int listSelectionModel = ListSelectionModel.SINGLE_SELECTION;

    public CsGListBox(Enum<?> name) {
        super();
        setName(name.name());
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void reset(List<T> items) {
        JList<T> list = new JList<>();
        list.setSelectionMode(listSelectionModel);
        if (items.size() == 0) {
            list.setListData(new Vector<>());
        } else {
            list.removeAll();
            Class<T> clazz = (Class<T>) items.get(0).getClass();
            T[] data = (T[]) Array.newInstance(clazz, items.size());
            items.toArray(data);
            list.setListData(data);
            list.setSelectedIndex(items.size() - 1);
            setViewportView(list);
        }
    }


}
