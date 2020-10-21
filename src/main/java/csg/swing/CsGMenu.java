package csg.swing;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CsGMenu extends JMenuBar {

    private final Map<String, JMenu> menu;

    public CsGMenu(Enum<?> name) {
        setName(name.name());
        menu = new HashMap<>();
    }

    public void addMenu(String menuName) {
        final JMenu menu = new JMenu(menuName);
        this.menu.put(menuName, menu);
        add(menu);
    }

    public void addMenuItem(String menuName, String menuItemName, ActionListener actionListener) {
        if (!menu.containsKey(menuName)) {
            addMenu(menuName);
        }
        JMenu menu = this.menu.get(menuName);
        menu.addActionListener(actionListener);
        final JMenuItem menuItem = new JMenuItem(menuItemName);
        menuItem.addActionListener(actionListener);
        menu.add(menuItem);
    }

    public void addMenuSeparator(String menuName) {
        if (!menu.containsKey(menuName) || menu.get(menuName).getItemCount() == 0) {
            throw new RuntimeException("There is nothing to separate in " + menuName + " menu.");
        }
        menu.get(menuName).addSeparator();
    }
}
