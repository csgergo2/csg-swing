package csg.swing;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

public class CsGListBox<T> extends JScrollPane {

    private int listSelectionModel = ListSelectionModel.SINGLE_SELECTION;

    private final ListSelectionListener listSelectionListener;

    public CsGListBox(Enum<?> name, ListSelectionListener listSelectionListener) {
        super();
        this.listSelectionListener = listSelectionListener;
        setName(name.name());
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void setListSelectionModel(final int listSelectionModel) {
        this.listSelectionModel = listSelectionModel;
    }

    public Optional<T> getSelectedValue() {
        return getViewport().getView() != null ? Optional.ofNullable(((JList<T>) getViewport().getView()).getSelectedValue()) : Optional.empty();
    }

    public void setSelectedValue(T value) {
        ((JList<T>) getViewport().getView()).setSelectedValue(value, true);
    }

    public void reset(List<T> items) {
        JList<T> list = new JList<>();
        list.setSelectionMode(listSelectionModel);
        if (listSelectionListener != null) {
            list.addListSelectionListener(listSelectionListener);
        }
        if (items.size() == 0) {
            list.setListData(new Vector<>());
        } else {
            list.removeAll();
            Class<T> clazz = (Class<T>) items.get(0).getClass();
            T[] data = (T[]) Array.newInstance(clazz, items.size());
            items.toArray(data);
            list.setListData(data);
            list.setSelectedIndex(items.size() - 1);
            list.setSelectedIndex(0);
            setViewportView(list);
        }
    }


}
