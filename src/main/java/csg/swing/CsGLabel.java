package csg.swing;

import javax.swing.*;

public class CsGLabel extends JLabel {
    public CsGLabel(Enum<?> name, String text) {
        super(text);
        setName(name.name());
    }
}
