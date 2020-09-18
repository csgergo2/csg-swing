package csg.swing;

import javax.swing.*;

public class CsGScrollableLabel extends JScrollPane {
    public CsGScrollableLabel(Enum<?> name, String text) {
        setName(name.name());
        setText(text);
    }

    public void setText(String text) {
        final JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.setVerticalAlignment(SwingConstants.TOP);
        setViewportView(label);
    }
}
