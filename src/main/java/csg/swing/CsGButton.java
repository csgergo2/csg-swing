package csg.swing;

import java.awt.event.ActionListener;

import javax.swing.*;

public class CsGButton extends JButton {
    public CsGButton(Enum<?> name, String text, ActionListener actionListener) {
        setName(name.name());
        setText(text);
        addActionListener(actionListener);
        setVisible(true);
    }
}
