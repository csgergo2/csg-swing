package csg.swing;

import javax.swing.*;

public class CsGCheckBox extends JCheckBox {
    public CsGCheckBox(Enum<?> name) {
        setName(name.name());
    }
}
